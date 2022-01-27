package com.wizardsdev.PageObjects;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.url;
import static java.lang.Integer.parseInt;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.wizardsdev.Context;
import com.wizardsdev.Modals.Post;
import com.wizardsdev.Modals.ReBlog;
import com.wizardsdev.PageObjects.Facebook.FacebookSignPage;
import com.wizardsdev.PageObjects.Objects.ObjectPage;
import com.wizardsdev.PageObjects.Profile.ProfilePage;
import io.qameta.allure.Step;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FeedPage extends Page {
  private static final String PAGE_URL = "/";

  private static final By POST_LOCATOR = By.className("Story");
  private static final By POST_PAYOUTS_LOCATOR = By.className("Payout");
  private static final By POST_LIKES_COUNTER_LOCATOR =
      By.cssSelector(".Buttons__number");
  private static final By POST_COMMENTS_COUNTER_LOCATOR =
      By.cssSelector(".Buttons__number:not(.Buttons__reactions-count):not(.amount-users)");
  private static final By POST_DATE_LOCATOR = By.className("Story__date");
  private static final By POST_TITLE_LOCATOR = By.cssSelector(".Story__content h2");
  private static final By POST_RELATED_OBJECT_LOCATOR = By.cssSelector(".PostWobject__wrap a");
  private static final By POST_AUTHOR_LOCATOR = By.cssSelector(".Story__header__flex a");
  private static final By POSTS_LOADING_LOCATOR = By.className("StoryLoading");
  private static final By WRITE_QUICK_POST_LOCATOR = By.className("QuickPostEditor");
  private static final By POST_LIKE_BUTTON_LOCATOR = By.className("icon-praise_fill");
  private static final By POST_LIKE_LOADING_LOCATOR = By.className("anticon-loading");
  private static final Pattern PATTERN = Pattern.compile("$", Pattern.LITERAL);
  private static final By MODAL_WINDOW_SIGN_IN = By.cssSelector(".ModalSignUp__button");
  private static final By BUTTON_RE_BLOG_LOCATOR = By.cssSelector(".Buttons__share");
  private static final By BUTTON_EXPAND_COMMENT_LOCATOR = By.cssSelector(".icon-message_fill");
  private static final By COMMENT_LOCATOR = By.cssSelector(".Comment__text");
  private static final By LOADING_LOCATOR = By.cssSelector(".Loading");
  private static final By TREE_DOTS_BUTTON_LOCATOR = By.cssSelector(".Buttons__post-menu");
  private static final By SOCIAL_ITEMS_LOCATOR = By.cssSelector(".Popover__shared-link");

  public FeedPage() {
    super(PAGE_URL);
  }

  @Step
  public static FeedPage openFeedPage() {
    if (!url().equals(Context.getSiteUrl())) {
      open(PAGE_URL);
    }
    return new FeedPage();
  }

  @Step
  private static boolean isListSortDown(ElementsCollection webElementList) {
    boolean result = true;

    for (int i = 1; i < webElementList.size(); i++) {
      float currentValue = Float.parseFloat(PATTERN.matcher(webElementList.get(i).getText())
          .replaceAll(Matcher.quoteReplacement("")));
      float previousValue = Float.parseFloat(PATTERN.matcher(webElementList.get(i - 1)
          .getText()).replaceAll(Matcher.quoteReplacement("")));
      System.out.println("current: " + currentValue + ", previous: " + previousValue);
      if (currentValue > previousValue) {
        result = false;
        break;
      }
    }
    return result;
  }

  @Step
  private static boolean isDateListSortUp(ElementsCollection webElementList){
    boolean result = true;

    for (int i = 1; i < webElementList.size(); i++) {
      int timePastCurrentPost = getTimeAfterPostingInSeconds(webElementList.get(i).getText());
      int timePastPreviousPost = getTimeAfterPostingInSeconds(webElementList.get(i-1).getText());
      System.out.println("current: " + timePastCurrentPost + ", previous: " + timePastPreviousPost);
      if (timePastCurrentPost < timePastPreviousPost) {
        result = false;
        break;
      }
    }

    return result;
  }

  @Step
  private static int getTimeAfterPostingInSeconds(String timeAfterPosting) {
    String[] splitTimeAfterPosting = timeAfterPosting.split(" ");
    return switch (splitTimeAfterPosting[1]) {
      case "minute", "minutes" -> parseInt(splitTimeAfterPosting[0]) * 60;
      case "hour", "hours" -> parseInt(splitTimeAfterPosting[0]) * 3600;
      case "day", "days" -> parseInt(splitTimeAfterPosting[0]) * 86400;
      default -> parseInt(splitTimeAfterPosting[0]);
    };
  }

  @Step
  public boolean isTrendingFeedPostsOrderCorrect() {
    $(POST_PAYOUTS_LOCATOR).shouldBe(Condition.visible);
    ElementsCollection payoutsList = $$(POST_PAYOUTS_LOCATOR);
    return isListSortDown(payoutsList);
  }

  @Step
  public boolean isHotFeedPostsOrderCorrect() {
    $(POST_COMMENTS_COUNTER_LOCATOR).shouldBe(Condition.visible);
    ElementsCollection commentsCounterList = $$(POST_COMMENTS_COUNTER_LOCATOR);
    return isListSortDown(commentsCounterList);
  }

  @Step
  public boolean isNewFeedPostsOrderCorrect() {
    $(POST_DATE_LOCATOR).shouldBe(Condition.visible);
    ElementsCollection postsDateList = $$(POST_DATE_LOCATOR);
    return isDateListSortUp(postsDateList);
  }

  @Step
  public boolean isMyFeedFoundedOnFollowList(List<String> followingObjectsNameList,
                                             List<String>  followingUsersNameList) {
    ElementsCollection postsTitleList = $$(POST_TITLE_LOCATOR);
    Post postModal;
    boolean result = false;
    for (WebElement postTitle: postsTitleList) {
      scrollToElement($(POST_AUTHOR_LOCATOR)); //Title иногда скролится за хедер, если скролить автора то как раз отображается тайтл
      postTitle.click();
      postModal = new Post();
      List<String> authorNameAsList =
          new ArrayList<>(Collections.singletonList(postModal.getPostAuthorName()));
      postModal.expandCollapseObjectRelatedList();
      List<String> objectsRelatedNameList = postModal.getObjectsRelatedNameList();
      if (isTwoListsHaveSameItem(followingUsersNameList, authorNameAsList)
          || isTwoListsHaveSameItem(followingObjectsNameList, objectsRelatedNameList)) {
        result = true;
        postModal.clickOnCloseButton();
        continue;
      }
      postModal.clickOnCloseButton();
      break;
    }
    return result;
  }

  @Step
  public Post openPost(int postIndex) {
    $$(POST_LOCATOR).get(postIndex).$(POST_TITLE_LOCATOR).click();
    return new Post();
  }

  @Step
  public String getPostRelatedObjectTitle(int postIndex) {
    String result = $$(POST_LOCATOR)
        .get(postIndex)
        .$(POST_RELATED_OBJECT_LOCATOR)
        .getAttribute("href")
        .split("/")[4];
    System.out.println(result);
    return result;
  }

  @Step
  public String getPostAuthorName(int postIndex) {
    return $$(POST_LOCATOR).get(postIndex).$(POST_AUTHOR_LOCATOR).getText();
  }

  @Step
  public ObjectPage clickOnPostRelatedObject(int postIndex) {
    $$(POST_LOCATOR).get(postIndex).$(POST_RELATED_OBJECT_LOCATOR).shouldBe(Condition.visible).click();
    return new ObjectPage() {
      @Override
      protected void init() {

      }

      @Override
      protected void parsePage() {

      }
    };
  }

  @Step
  public ProfilePage clickOnPostAuthorName(int postIndex) {
    $$(POST_LOCATOR).get(postIndex).$(POST_AUTHOR_LOCATOR).shouldBe(Condition.visible).click();
    return new ProfilePage() {
      @Override
      protected void init() {

      }

      @Override
      protected void parsePage() {

      }
    };
  }

  @Step
  public void clickOnPostLikeButton(int postIndex) {
    scrollToElement($$(POST_LOCATOR).get(postIndex));
    $$(POST_LOCATOR).get(postIndex).$(POST_LIKE_BUTTON_LOCATOR).shouldBe(Condition.visible).click();
    $$(POST_LOCATOR).get(postIndex).$(POST_LIKE_LOADING_LOCATOR).shouldBe(Condition.disappear);
    sleep(3000);
  }

  @Step
  public String getPostTitle(int postIndex) {
    return $$(POST_TITLE_LOCATOR).get(postIndex).getText();
  }

  @Step
  public int getPostLikeCount(int postIndex) {
    return  parseInt($$(POST_LOCATOR)
        .get(postIndex)
        .$(POST_LIKES_COUNTER_LOCATOR)
        .scrollTo()
        .shouldBe(Condition.visible)
        .getText());
  }

  @Step
  public void clickOnCommentButton(int postIndex) {
    $(POST_COMMENTS_COUNTER_LOCATOR).shouldBe(Condition.visible);
    scrollToElement($$(POST_LOCATOR).get(postIndex));
      $$(BUTTON_EXPAND_COMMENT_LOCATOR).get(postIndex).shouldBe(Condition.visible).click();
      $(LOADING_LOCATOR).shouldBe(Condition.disappear);
  }

  @Step
  public ReBlog clickOnReBlog(int postIndex) {
    scrollToElement($$(POST_LOCATOR).get(postIndex));
    $$(BUTTON_RE_BLOG_LOCATOR).get(postIndex).shouldBe(Condition.visible).click();
    return new ReBlog();
  }

  @Step
  public boolean isCommentExist() {
    return $(COMMENT_LOCATOR).shouldBe(Condition.visible).exists();
  }

  @Step
  public void clickOnTreeDotsButton(int index) {
    $$(TREE_DOTS_BUTTON_LOCATOR).get(index).shouldBe(Condition.visible).click();
  }

  @Step
  public TwitterPage clickOnTwitterInPostMenu(int index) {
    clickOnTreeDotsButton(index);
    $$(SOCIAL_ITEMS_LOCATOR).get(1).shouldBe(Condition.visible).click();
    return new TwitterPage();
  }

  @Step
  public FacebookSignPage clickOnFacebookInPostMenu(int index, boolean newWindow) {
    clickOnTreeDotsButton(index);
    $$(SOCIAL_ITEMS_LOCATOR).get(0).shouldBe(Condition.visible).click();
    return new FacebookSignPage(newWindow);
  }

  @Override
  protected void init() {
    $(POST_LOCATOR).shouldBe(Condition.visible);
  }

  @Override
  protected void parsePage() {

  }
}
