package com.wizardsdev.ApiRequests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.wizardsdev.ApiRequests.CreateCompany.CreateCompanyBase;
import com.wizardsdev.Context;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jetbrains.annotations.Nullable;

public class ApiRequest {

  //Request headers
  private static final String CONTENT_TYPE = "application/json;charset=utf-8";
  private static final String ACCEPT = "application/json, text/plain, */*";
  private static final String USER_AGENT = "Mozilla/5.0 (X11; "
      + "Ubuntu; Linux x86_64; rv:63.0) Gecko/20100101 Firefox/63.0";
  //Headers to keep user's session
  private final ThreadLocal<Header> accessToken = new ThreadLocal<>();
  private final ThreadLocal<Header> uid = new ThreadLocal<>();
  private final ThreadLocal<Header> client = new ThreadLocal<>();

  //Client to send requests
  private final ThreadLocal<CloseableHttpClient> httpClient = new ThreadLocal<>() {
    {
      set(HttpClientBuilder.create()
          .setConnectionTimeToLive(CONNECTION_TIME_TO_LIVE, TimeUnit.SECONDS)
          .build());
    }
  };
  //Response from API
  private final ThreadLocal<HttpResponse> response = new ThreadLocal<>();
  //Json body builder, can convert Java Class or JsonObject to JsonString
  private final ThreadLocal<Gson> gsonBuilder = new ThreadLocal<>() {
    {
      set(new GsonBuilder().create());
    }
  };
  //Uses for parse JsonString to JsonElement
  private final ThreadLocal<JsonParser> jsonParser = new ThreadLocal<>() {
    {
      set(new JsonParser());
    }
  };

  //Tests properties
  private final Properties properties = Context.getInstance().getProperties();
  private final int qaNumber = Context.getQaNumber();

  private static final long CONNECTION_TIME_TO_LIVE = 60;
  private static final int UNAUTHORIZED_STATUS_CODE = 401;

  //Site url
  private final String url;

  //Constructor for setting site url
  public ApiRequest(String url) {
    this.url = url;
  }

  //Getters and setters for ThreadLocal variables
  public Header getAccessToken() {
    return accessToken.get();
  }

  public void setAccessToken(Header accessToken) {
    this.accessToken.set(accessToken);
  }

  public Header getuid() {
    return uid.get();
  }

  public void setuid(Header uid) {
    this.uid.set(uid);
  }

  public Header getClient() {
    return client.get();
  }

  public void setClient(Header client) {
    this.client.set(client);
  }

  private CloseableHttpClient getHttpClient() {
    return httpClient.get();
  }

  private HttpResponse getResponse() {
    return response.get();
  }

  private void setResponse(HttpResponse response) {
    this.response.set(response);
  }

  private JsonParser getJsonParser() {
    return jsonParser.get();
  }

  private Gson getGsonBuilder() {
    return gsonBuilder.get();
  }

  //Method for adding headers for each request
  private void addHeaders(HttpRequestBase request) {
    request.addHeader("Content-Type", CONTENT_TYPE);
    request.addHeader("Accept", ACCEPT);
    request.addHeader("User-Agent", USER_AGENT);
    //Checking access-token for keep user session
    if (getResponse() != null
        && getHeader("access-token") != null
        && !getHeader("access-token").toString().equals("access-token: ")) {
      setAccessToken(getHeader("access-token"));
    }
    request.addHeader(getAccessToken());
    request.addHeader(getuid());
    request.addHeader(getClient());
  }

  //Method for sending POST request with body from String or from json file
  private String postRequest(String route, String body, boolean... bodyFromFile) {
    HttpPost request = new HttpPost(url + route);
    request.setEntity(generateEntity(body, bodyFromFile));
    return executeRequest(request);
  }

  //Method for sending POST request with File
  private String postRequest(String route, File file) {
    HttpPost request = new HttpPost(url + route);
    HttpEntity postData = MultipartEntityBuilder.create().addBinaryBody("file", file).build();
    request.setEntity(postData);
    request.setHeader(postData.getContentType());
    return executeRequest(request);
  }

  //Method for sending PUT request with String body or body from json File
  private String putRequest(String route, String body, boolean... bodyFromFile) {
    HttpPut request = new HttpPut(url + route);
    request.setEntity(generateEntity(body, bodyFromFile));
    return executeRequest(request);
  }

  //Method for sending GET request
  private String getRequest(String route) {
    HttpGet request = new HttpGet(url + route);
    return executeRequest(request);
  }

  //Method for sending DELETE request
  private void deleteRequest(String route) {
    HttpDelete request = new HttpDelete(url + route);
    executeRequest(request);
  }

  //Method for sending any configured before request
  private String executeRequest(HttpRequestBase request) {
    addHeaders(request);
    response.remove();
    try {
      setResponse(getHttpClient().execute(request));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return getResponse(request);
  }

  //Method for generate request's body from string or json file
  private static HttpEntity generateEntity(String body, boolean... bodyFromFile) {
    HttpEntity entity = null;
    try {
      entity = bodyFromFile.length > 0 && bodyFromFile[0]
          ? new FileEntity(new File(body))
          : new StringEntity(body);
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return entity;
  }

  //Method for reading response from API
  private String getResponse(HttpRequestBase request) {
    StringBuilder result = new StringBuilder();
    assert getResponse() != null;
    int responseCode = getResponse().getStatusLine().getStatusCode();
    System.out.println("Response Code: " + responseCode);
    System.out.println("Get Response is Successful from: \n"
        + request.getRequestLine().getMethod() + ' ' + request.getRequestLine().getUri());
    try {
      try (BufferedReader reader = new BufferedReader(
          new InputStreamReader(getResponse().getEntity().getContent(), StandardCharsets.UTF_8))) {
        String line;
        while ((line = reader.readLine()) != null) {
          result.append(line);
        }
      }
      //Clearing session's headers if receive 401 status code
      if (responseCode == UNAUTHORIZED_STATUS_CODE) {
        getResponse().removeHeader(getAccessToken());
        getResponse().removeHeader(getuid());
        getResponse().removeHeader(getClient());
        request.releaseConnection();
      }
      return result.toString();
    } catch (Exception e) {
      result.append("Get Response Failed");
      return result.toString();
    }
  }

  //Method for getting any header from response
  private Header getHeader(String headerName) {
    return getResponse().getFirstHeader(headerName);
  }

  //Method for getting all founded ids from response
  public List<String> getAllIDs(String text) {
    List<String> matches = new ArrayList<>();
    Matcher matcher = Pattern.compile(
        "(?=([0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}))"
    )
        .matcher(text);
    while (matcher.find()) {
      matches.add(matcher.group(1));
    }
    return matches;
  }

  //Example for creating JsonObject with all needed properties for request
  private static String createBodyForRequest() {
    JsonArray countriesArray = new JsonArray();
    countriesArray.add("United States");
    JsonObject companyCountry = new JsonObject();
    companyCountry.add("include", countriesArray);
    JsonObject companyQuery = new JsonObject();
    companyQuery.add("company_country", companyCountry);
    JsonObject company = new JsonObject();
    company.addProperty("count", 6);
    company.addProperty("page", 1);
    company.add("query", companyQuery);
    JsonObject contact = new JsonObject();
    contact.addProperty("count", 6);
    contact.addProperty("page", 1);
    contact.add("query", new JsonObject());
    JsonObject body = new JsonObject();
    body.add("company", company);
    body.add("contact", contact);
    body.addProperty("entity", "company");
    return body.toString();
  }

  //Request for login in Web-Application
  /**
   * @param userLevel used if you have not one users' levels
   * @param numberOfUser used for parallelism
   */
  public void loginRequest(String userLevel, int numberOfUser) {
    String email = properties.getProperty(String.format("%sEmail%s%s", userLevel, qaNumber, numberOfUser));
    String password = properties.getProperty("LoginPassword");
    JsonObject bodyJson = new JsonObject();
    bodyJson.addProperty("email", email);
    bodyJson.addProperty("password", password);
    postRequest("/api/auth/sign_in", bodyJson.toString());
    setuid(getHeader("uid"));
    setClient(getHeader("client"));
  }

  //Method for creating company in Web-Application with body from String or json file
  public @Nullable String createCompany(String body, boolean... fromFile) {
    boolean fromFile1 = fromFile.length > 0 && fromFile[0];
    List<String> ids = getAllIDs(postRequest("/api/companies", body, fromFile1));
    if (!ids.isEmpty()) {
      return ids.get(0);
    }
    return null;
  }

  //Method for generating body from Java Class for creating company request
  public @Nullable String createCompanyFromClass(CreateCompanyBase createCompany) {
    String body = getGsonBuilder().toJson(createCompany);
    return createCompany(body);
  }

}
