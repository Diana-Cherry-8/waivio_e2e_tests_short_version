package Junit5;

import static com.codeborne.selenide.Selenide.*;
import static com.wizardsdev.Context.THREADS_COUNT;

import Extensions.MyAfterTestExecutionCallback;
import Helpers.FileGenerator;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.github.javafaker.Faker;
import com.wizardsdev.ApiRequests.ApiRequest;
import com.wizardsdev.Components.*;
import com.wizardsdev.Context;
import com.wizardsdev.Keywords;
import com.wizardsdev.Modals.ChooseLogo;
import com.wizardsdev.Modals.DeleteWebsite;
import com.wizardsdev.Modals.Post;
import com.wizardsdev.Modals.ReBlog;
import com.wizardsdev.Modals.Reservation;
import com.wizardsdev.Modals.SignIn;


import com.wizardsdev.Modals.UseCookies;
import com.wizardsdev.Modals.WriteReview;
import com.wizardsdev.PageObjects.Tools.Website.AdministratorsPage;
import com.wizardsdev.PageObjects.Tools.Website.AreasPage;
import com.wizardsdev.PageObjects.Tools.Website.AuthoritiesPage;
import com.wizardsdev.PageObjects.Tools.Website.ConfigurationWebsitePage;
import com.wizardsdev.PageObjects.Tools.Website.ModeratorsPage;
import com.wizardsdev.PageObjects.Tools.Website.MutedUsersPage;
import com.wizardsdev.PageObjects.Tools.Website.ObjectsFiltersPage;
import com.wizardsdev.PageObjects.Tools.Website.SettingsWebsitePage;
import java.util.HashMap;
import java.util.Properties;
import java.util.ResourceBundle;

import com.wizardsdev.PageObjects.*;
import com.wizardsdev.PageObjects.Objects.*;
import com.wizardsdev.PageObjects.Profile.*;
import com.wizardsdev.PageObjects.Rewards.*;
import com.wizardsdev.PageObjects.Tools.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.support.ui.WebDriverWait;

@ExtendWith(MyAfterTestExecutionCallback.class)
public abstract class TestBase {

  private static final int WAIT_TIME = 20000;

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
  protected static Post post;
  protected static ReBlog reBlog;
  protected static DeleteWebsite deleteWebsite;
  protected static Reservation reservation;
  protected static ChooseLogo chooseLogo;
  protected static SignInPage signInPage;
  protected static UseCookies useCookies;
  protected static WriteReview writeReview;

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
  protected static RewardsLeftSidebar rewardsLeftSidebar;
  protected static ToolsLeftSidebar toolsLeftSidebar;
  protected static DiscoverLeftSidebar discoverLeftSidebar;

  //Page Objects
  protected static FeedPage feedPage;
  protected static DiscoverPage discoverPage;
  protected static NotificationsPage notificationsPage;
  protected static EligiblePage eligiblePage;
  protected static AllPage allPage;
  protected static ReservedPage reservedPage;
  protected static ReceivablesPage receivablesPage;
  protected static ReportsPage reportsPage;
  protected static HistoryPage historyPage;
  protected static CreatePage createPage;
  protected static ManagePage managePage;
  protected static PayablesPage payablesPage;
  protected static ReservationsPage reservationsPage;
  protected static MessagesPage messagesPage;
  protected static MatchBotPage matchBotPage;
  protected static BlacklistPage blacklistPage;
  protected static DetailsPage detailsPage;
  protected static InstructionsPage instructionsPage;
  protected static StatusPage statusPage;
  protected static FraudDetectionPage fraudDetectionPage;
  protected static EditorPage editorPage;

  protected static DraftsPage draftsPage;
  protected static BookmarksPage bookmarksPage;
  protected static EditProfilePage editProfilePage;
  protected static SettingsPage settingsPage;
  protected static GuestsSettingsPage guestsSettingsPage;
  protected static ToolsNotificationsPage toolsNotificationsPage;
  protected static NewAccountsPage newAccountsPage;
  protected static InvitePage invitePage;
  protected static AboutPage aboutPage;
  protected static CreateWebsitePage createWebsitePage;
  protected static ManageWebsitePage manageWebsitePage;
  protected static ReportsWebsitePage reportsWebsitePage;

//website
  protected static ConfigurationWebsitePage configurationWebsitePage;
  protected static SettingsWebsitePage settingsWebsitePage;
  protected static AdministratorsPage administratorsPage;
  protected static ModeratorsPage moderatorsPage;
  protected static AuthoritiesPage authoritiesPage;
  protected static AreasPage areasPage;
  protected static ObjectsFiltersPage objectsFiltersPage;
  protected static MutedUsersPage mutedUsersPage;

  protected static NewSitePage newSitePage;


  protected static CommentsPage commentsPage;
  protected static ExpertisePage expertisePage;
  protected static FollowersPage followersPage;
  protected static FollowingPage followingPage;
  protected static PostsPage postsPage;
  protected static WalletPage walletPage;
  protected static ProfilePage profilePage;
  protected static AdvancedPage advancedPage;

  protected static RestaurantObjectPage restaurantObjectPage;
  protected static ObjectPage objectPage;

  protected static ReviewsObjectPage reviewsObjectPage;
  protected static GalleryObjectPage galleryObjectPage;
  protected static UpdatesObjectPage updatesObjectPage;
  protected static FollowersObjectPage followersObjectPage;
  protected static ExpertsObjectPage expertsObjectPage;
  protected static ListObjectPage listObjectPage;
  protected static ReviewsObjectPage drinkObjectPage;
  protected static ReviewsObjectPage dishObjectPage;
  protected static PageObjectPage pageObjectPage;

  protected static TwitterPage twitterPage;
  protected static FacebookSignPage facebookSignPage;
  protected static HiveOnBoardPage hiveOnBoardPage;

  protected static FullScreenOfTheReservationPost fullScreenOfTheReservationPost;

  protected static WebDriverWait waiter;



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
    waiter = new WebDriverWait(WebDriverRunner.getWebDriver(), 20);//как вариант чтобы избавиться от sleep
    qaNumber = Context.getQaNumber();
    properties = Context.getInstance().getProperties();
    messages = Context.getInstance().getMessages();
    keywords = Context.getInstance().getKeywords();
    faker = Context.getInstance().getFaker();
    header = Header.initHeader();
    feedLeftBar = FeedLeftBar.initFeedLeftBar();
    topNavigation = TopNavigation.initTopNavigation();
    rewardsLeftSidebar = RewardsLeftSidebar.initRewardsLeftSidebar();
    toolsLeftSidebar = ToolsLeftSidebar.initToolsLeftSidebar();
    discoverLeftSidebar = DiscoverLeftSidebar.initDiscoverLeftSidebar();

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

  //Refresh method
  public static void refreshPage() {
    refresh();
    sleep(5000);
  }
}
