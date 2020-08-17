package Junit5;

import static com.wizardsdev.Context.THREADS_COUNT;

import Extensions.MyAfterTestExecutionCallback;
import Helpers.FileGenerator;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.github.javafaker.Faker;
import com.wizardsdev.ApiRequests.ApiRequest;
import com.wizardsdev.Components.FeedLeftBar;
import com.wizardsdev.Components.Header;
import com.wizardsdev.Components.TopNavigation;
import com.wizardsdev.Context;
import com.wizardsdev.Keywords;
import com.wizardsdev.Modals.Post;
import com.wizardsdev.Modals.SignIn;
import com.wizardsdev.Modals.SignUp;
import com.wizardsdev.PageObjects.*;

import java.util.HashMap;
import java.util.Properties;
import java.util.ResourceBundle;

import com.wizardsdev.PageObjects.Rewards.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MyAfterTestExecutionCallback.class)
public abstract class TestBase {

  private static final int WAIT_TIME = 10000;
  public static final String PATH_TO_TEST_FILE = "src/test/resources/";
  protected static HashMap<Integer, String> usersInThreads = new HashMap<>() {
    {
      put(0, "not used");
      put(1, "not used");
      put(2, "not used");
      put(3, "not used");
    }
  };
  protected static ThreadLocal<Integer> numberOfUser = new ThreadLocal<>(); // User for login
  protected static ThreadLocal<String> userLogin = new ThreadLocal<>();
  protected static ThreadLocal<String> userPassword  = new ThreadLocal<>();

  //Modals
  protected static SignIn signIn;
  protected static SignUp signUp;
  protected static Post post;

  //Tools
  protected static final ThreadLocal<ApiRequest> apiRequest = new ThreadLocal<>();
  protected static Keywords keywords;
  protected static Faker faker;
  protected static Properties properties;
  protected static ResourceBundle messages;

  //Components
  protected static Header header;
  protected static TopNavigation topNavigation;
  protected static FeedLeftBar feedLeftBar;

  //Page Objects
  protected static FeedPage feedPage;
  protected static UserPage userPage;
  protected static DiscoverPage discoverPage;
  protected static ObjectPage objectPage;
  protected static NotificationsPage notificationsPage;
  protected static EligiblePage eligiblePage;
  protected static AllPage allPage;
  protected static ReservedPage reservedPage;
  protected static ReceivablesPage receivablesPage;
  protected static ReportsPage reportsPage;


  //Helpers
  protected static FileGenerator fileGen = new FileGenerator();

  //Number is different for each QA Engineer
  protected static int qaNumber;

  @BeforeAll
  static void init() {
    initContext();
  }

  @AfterAll
  static void resetSession() {
    usersInThreads.replace(getNumberOfUser(), "not used");
    Selenide.closeWebDriver();
  }

  protected static void initContext() {
    String browser = System.getProperty("Browser") == null
        ? WebDriverRunner.CHROME
        : System.getProperty("Browser");
    setNumberOfUser();
    Context.initInstance(browser, WAIT_TIME, getNumberOfUser());
    qaNumber = Context.getQaNumber();
    properties = Context.getInstance().getProperties();
    messages = Context.getInstance().getMessages();
    keywords = Context.getInstance().getKeywords();
    faker = Context.getInstance().getFaker();
    header = Header.initHeader();
    feedLeftBar = FeedLeftBar.initFeedLeftBar();
    topNavigation = TopNavigation.initTopNavigation();
    setUserLogin(properties.getProperty(String.format("UserLogin%s%s", qaNumber, getNumberOfUser())));
    setUserPassword(properties.getProperty(String.format("LoginPassword%s%s", qaNumber, getNumberOfUser())));
    setApiRequest(Context.getInstance().getApiRequest());
  }

  private static synchronized void setNumberOfUser() {
    for (int i = 0; i < THREADS_COUNT; i++) {
      if (!usersInThreads.get(i).equals("used")) {
        usersInThreads.replace(i, "used");
        numberOfUser.set(i);
        break;
      }
    }
  }

  //Getters
  protected static int getNumberOfUser() {
    return numberOfUser.get();
  }

  protected static String getUserLogin() {
    return userLogin.get();
  }

  protected static String getUserPassword() {
    return userPassword.get();
  }

  //Setters
  private static void setApiRequest(ApiRequest apiRequest) {
    TestBase.apiRequest.set(apiRequest);
  }

  private static void setUserLogin(String login) {
    userLogin.set(login);
  }

  private static void setUserPassword(String password) {
    userPassword.set(password);
  }
}
