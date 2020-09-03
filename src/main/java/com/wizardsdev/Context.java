package com.wizardsdev;

import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import com.wizardsdev.ApiRequests.ApiRequest;
import io.qameta.allure.selenide.AllureSelenide;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

//Here you can start browser and set all variables witch will be used in whole project
public class Context {

  public static final String STAGING = "Staging";
  public static final String PRODUCTION = "Production";
  private static String env;
  private static int qaNumber;
  private static String siteUrl;
  private static final ThreadLocal<Context> context = new ThreadLocal<>();
  public static Properties properties;
  private static ResourceBundle messages;
  private static Keywords keywords;
  private static final ThreadLocal<ApiRequest> apiRequest = new ThreadLocal<>();
  private static Faker faker;
  public static final int THREADS_COUNT = 4;
  public static final String SITE_URL_STAGING = "https://waiviodev.com";
  public static final String SITE_URL_PRODUCTION = "https://waivio.com";
  public static final String PROPERTIES_FILE_NAME = "TestsData";

  public static void initInstance(String browserName, long timeout, int numberOfUser) {
    initInstanceWithoutBrowser();
    Context.setMessages();
    Context.setKeywords();
    Context.startBrowser(browserName, timeout);
  }

  public static void initInstanceWithoutBrowser() {
    context.set(new Context());
    Context.setProperties();
    Context.setEnv();
    Context.setSiteUrl();
    Context.setQaNumber();
    Context.setApiRequests();
    Context.setLogger();
    Context.setFaker();
  }

  public static Context getInstance() {
    if (context.get() != null) {
      return context.get();
    }
    throw new IllegalStateException("Context is not initialized");
  }

  //Configuring and starting browser
  private static void startBrowser(String browserName, long timeout) {
    SelenideLogger.addListener("AllureSelenide",
        new AllureSelenide().screenshots(true).savePageSource(true));
    Configuration.baseUrl = siteUrl;
    Configuration.startMaximized = true;
    //Time for waiting an element
    Configuration.timeout = timeout;
    if (browserName.equalsIgnoreCase("Remote")) {
      DesiredCapabilities capabilities = new DesiredCapabilities();
      //change browser name or move it to method parameters if you want another remote browser in Selenoid
      capabilities.setBrowserName("chrome");
      capabilities.setCapability("enableVNC", true);
      capabilities.setCapability("enableVideo", false);
      Configuration.driverManagerEnabled = false;
      //set Selenoid RemoteWebDriver url
      Configuration.remote = "http://localhost:4444/wd/hub";
      Configuration.browserCapabilities = capabilities;
      open();
      RemoteWebDriver remote = (RemoteWebDriver) WebDriverRunner.getWebDriver();
      //used for fix that remote driver can't see local files from docker container
      remote.setFileDetector(new LocalFileDetector());
    } else {
      Configuration.browser = browserName;
      open();
    }
  }

  public static int getQaNumber() {
    return qaNumber;
  }

  public Properties getProperties() {
    if (properties != null) {
      return properties;
    }
    throw new IllegalStateException("Properties is not initialized");
  }

  public Keywords getKeywords() {
    if (keywords != null) {
      return keywords;
    }
    throw new IllegalStateException("Keywords is not initialized");
  }

  public ApiRequest getApiRequest() {
    if (apiRequest.get() != null) {
      return apiRequest.get();
    }
    throw new IllegalStateException("Api Requests is not initialized");
  }

  public Faker getFaker() {
    if (faker != null) {
      return faker;
    }
    throw new IllegalStateException("Faker is not initialized");
  }


  public static String getSiteUrl() {
    return siteUrl;
  }

  public static void setSiteUrl() {
    siteUrl = switch (getEnv()) {
      case "Staging" -> SITE_URL_STAGING;
      case "Production" -> SITE_URL_PRODUCTION;
      default -> throw new IllegalStateException("Env property is null");
    };
  }

  public static String getEnv() {
    return env;
  }

  private static void setEnv() {
    env = System.getProperty("Env") != null
        ? System.getProperty("Env")
        : properties.getProperty("Env");
  }

  public ResourceBundle getMessages() {
    return messages;
  }

  private static void setMessages() {
    Context.messages = ResourceBundle.getBundle("messages", Locale.US);
  }

  private static void setProperties() {
    if (System.getProperty("Browser") == null) {
      try {
        properties = new Properties();
        FileInputStream fis = new FileInputStream(
            String.format("src/test/resources/%s.properties", PROPERTIES_FILE_NAME)
        );
        properties.load(fis);
      } catch (IOException e) {
        System.err.println(String.format("No such property file: %s", PROPERTIES_FILE_NAME));
      }
    } else {
      properties = System.getProperties();
    }
  }

  public static void storeProperties() {
    storeProperties(properties, PROPERTIES_FILE_NAME);
  }

  private static void storeProperties(Properties props, String propsFileName) {
    try {
      FileOutputStream out = new FileOutputStream(
          String.format("src/test/resources/%s.properties", propsFileName)
      );
      props.store(out, null);
      out.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void setQaNumber() {
    Context.qaNumber = Integer.parseInt(properties.getProperty("QANumber"));
  }

  private static void setKeywords() {
    keywords = new Keywords();
  }

  private static void setApiRequests() {
    apiRequest.set(new ApiRequest(Context.getSiteUrl()));
  }

  private static void setFaker() {
    Context.faker = new Faker();
  }

  private static void setLogger() {
    DOMConfigurator.configure("log4j.xml");
  }

}
