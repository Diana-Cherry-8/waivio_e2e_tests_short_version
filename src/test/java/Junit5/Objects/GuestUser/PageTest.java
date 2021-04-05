package Junit5.Objects.GuestUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import com.wizardsdev.PageObjects.Objects.PageObjectPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

import static com.wizardsdev.Context.properties;
import static org.junit.jupiter.api.Assertions.*;

@Feature("Page type, Object")
public class PageTest extends TestBase {
    static String facebookEmail = properties.getProperty("FacebookUserEmail00");
    static String facebookPassword = properties.getProperty("FacebookUserPass00");
    static String pageObject = properties.getProperty("PageObject");
    String pageName = properties.getProperty("PageObjectName");
    static boolean newWindow = true;

    @BeforeAll
    static void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithFacebook(facebookEmail, facebookPassword, newWindow);
        pageObjectPage = PageObjectPage.openPageObjectPage(pageObject);
    }

    @Story("Open page")
    @DisplayName("Check Page object page is opened")
    @Test
    void openPage() {
        header.inputTextToSearch(pageName);
        pageObjectPage = header.clickOnTheFirstItemFromSearch();
        refreshPage();
        String expectedResult = pageName;
        String actualResult = pageObjectPage.getObjectName();
        assertEquals(expectedResult, actualResult);
    }

    @Story("Check page")
    @DisplayName("Check Page object  is opened with correct object type")
    @Test
    void checkPageObjectType() {
        String expectedResult = "page";
        String actualResult = pageObjectPage.getObjectTypeName();
        assertEquals(expectedResult, actualResult);
    }

    @Story("Open page")
    @DisplayName("Check Page object page is opened in review tab")
    @Test
    void openPageReviewTab() {
        reviewsObjectPage = pageObjectPage.clickOnReviewsItemPage();
        refreshPage();   //проблемы с перезагрузой
        String expectedResult = "Write a new review";
        String actualResult = reviewsObjectPage.getButtonText();
        assertEquals(expectedResult, actualResult);
    }


    @Story("Open page")
    @DisplayName("Check Page object page is opened in updates tab")
    @Test
    void openPageUpdatesTab() {
        updatesObjectPage = pageObjectPage.clickOnUpdatesItemPage();
        refreshPage();
        String expectedResult = "Add";
        String actualResult = updatesObjectPage.getButtonText();
        assertEquals(expectedResult, actualResult);
    }

    @Story("Open page")
    @DisplayName("Check Page object page is opened in followers tab")
    @Test
    void openPageFollowersTab() {
        followersObjectPage = pageObjectPage.clickOnFollowersItemPage();
        refreshPage();
        boolean actualResult = followersObjectPage.isSortingInFollowersExist();
        assertTrue(actualResult);
    }

    @Story("Open page")
    @DisplayName("Check Page object page is opened in experts tab")
    @Test
    void openPageExpertsTab() {
        expertsObjectPage = pageObjectPage.clickOnExpertiseItemPage();
        //refreshPage();
        boolean actualResult = expertsObjectPage.isButtonFollowSecondaryExist();
        assertTrue(actualResult);
    }

    @Story("Check content")
    @DisplayName("Check check availability content in Page")
    @Test
    void checkContent() {
        header.inputTextToSearch(pageName);
        pageObjectPage = header.clickOnTheFirstItemFromSearch();
        String expectedResult = "8 REASONS WHY MUSIC IS IMPORTANT TO US:";
        String actualResult = pageObjectPage.getContentPage();
        assertTrue(actualResult.contains(expectedResult));
    }

    @Story("Open page")
    @DisplayName("Check page Privacy Policy is opened")
    @Test
    void openPagePrivacyPolicy() {
        String expectedResult = "Privacy Policy";
        header.inputTextToSearch(expectedResult);
        pageObjectPage = header.clickOnTheSecondItemFromSearch();
        String actualResult = pageObjectPage.getObjectName();
        assertEquals(expectedResult, actualResult);
    }

    @Story("Open page")
    @DisplayName("Check page Privacy Policy is opened")
    @Test
    void checkContentPrivacyPolicy() {
        String pageNameToSearch = "Privacy Policy";
        header.inputTextToSearch(pageNameToSearch);
        pageObjectPage = header.clickOnTheSecondItemFromSearch();
        String expectedResult = "Waivio Technologies Inc.\n" +
                "Privacy Policy\n" +
                "Effective date: August 22, 2019\n" +
                "Waivio Technologies Inc. (\"us\", \"we\", or \"our\") operates the www.waivio.com website (hereinafter referred to as the \"Service\").\n" +
                "This page informs you of our policies regarding the collection, use and disclosure of personal data when you use our Service and the choices you have associated with that data.\n" +
                "We use your data to provide and improve the Service. By using the Service, you agree to the collection and use of information in accordance with this policy. Unless otherwise defined in this Privacy Policy, the terms used in this Privacy Policy have the same meanings as in our Terms and Conditions, accessible from www.waivio.com\n" +
                "Definitions\n" +
                "Service\n" +
                "Service is the www.waivio.com website operated by Waivio Technologies Inc.\n" +
                "Personal Data\n" +
                "Personal Data means data about a living individual who can be identified from those data (or from those and other information either in our possession or likely to come into our possession).\n" +
                "Usage Data\n" +
                "Usage Data is data collected automatically either generated by the use of the Service or from the Service infrastructure itself (for example, the duration of a page visit).\n" +
                "Cookies\n" +
                "Cookies are small files stored on your device (computer or mobile device).\n" +
                "Data Controller\n" +
                "Data Controller means the natural or legal person who (either alone or jointly or in common with other persons) determines the purposes for which and the manner in which any personal information are, or are to be, processed.\n" +
                "For the purpose of this Privacy Policy, we are a Data Controller of your Personal Data.\n" +
                "Data Processors (or Service Providers)\n" +
                "Data Processor (or Service Provider) means any natural or legal person who processes the data on behalf of the Data Controller.\n" +
                "We may use the services of various Service Providers in order to process your data more effectively.\n" +
                "Data Subject (or User)\n" +
                "Data Subject is any living individual who is using our Service and is the subject of Personal Data.\n" +
                "Information Collection and Use\n" +
                "We collect several different types of information for various purposes to provide and improve our Service to you.\n" +
                "Types of Data Collected\n" +
                "Personal Data\n" +
                "While using our Service, we may ask you to provide us with certain personally identifiable information that can be used to contact or identify you (\"Personal Data\"). Personally identifiable information may include, but is not limited to:\n" +
                "· Cookies and Usage Data\n" +
                "Usage Data\n" +
                "We may also collect information on how the Service is accessed and used (\"Usage Data\"). This Usage Data may include information such as your computer's Internet Protocol address (e.g. IP address), browser type, browser version, the pages of our Service that you visit, the time and date of your visit, the time spent on those pages, unique device identifiers and other diagnostic data.\n" +
                "Location Data\n" +
                "We may use and store information about your location if you give us permission to do so (\"Location Data\"). We use this data to provide features of our Service, to improve and customise our Service.\n" +
                "You can enable or disable location services when you use our Service at any time by way of your device settings.\n" +
                "Tracking Cookies Data\n" +
                "We use cookies and similar tracking technologies to track the activity on our Service and we hold certain information.\n" +
                "Cookies are files with a small amount of data which may include an anonymous unique identifier. Cookies are sent to your browser from a website and stored on your device. Other tracking technologies are also used such as beacons, tags and scripts to collect and track information and to improve and analyse our Service.\n" +
                "You can instruct your browser to refuse all cookies or to indicate when a cookie is being sent. However, if you do not accept cookies, you may not be able to use some portions of our Service.\n" +
                "Examples of Cookies we use:\n" +
                "· Session Cookies. We use Session Cookies to operate our Service.\n" +
                "· Preference Cookies. We use Preference Cookies to remember your preferences and various settings.\n" +
                "· Security Cookies. We use Security Cookies for security purposes.\n" +
                "· Advertising Cookies. Advertising Cookies are used to serve you with advertisements that may be relevant to you and your interests.\n" +
                "Use of Data\n" +
                "Waivio Technologies Inc. uses the collected data for various purposes:\n" +
                "· To provide and maintain our Service\n" +
                "· To notify you about changes to our Service\n" +
                "· To allow you to participate in interactive features of our Service when you choose to do so\n" +
                "· To provide customer support\n" +
                "· To gather analysis or valuable information so that we can improve our Service\n" +
                "· To monitor the usage of our Service\n" +
                "· To detect, prevent and address technical issues\n" +
                "Legal Basis for Processing Personal Data under the General Data Protection Regulation (GDPR)\n" +
                "If you are from the European Economic Area (EEA), Waivio Technologies Inc. legal basis for collecting and using the personal information described in this Privacy Policy depends on the Personal Data we collect and the specific context in which we collect it.\n" +
                "Waivio Technologies Inc. may process your Personal Data because:\n" +
                "· We need to perform a contract with you\n" +
                "· You have given us permission to do so\n" +
                "· The processing is in our legitimate interests and it is not overridden by your rights\n" +
                "· For payment processing purposes\n" +
                "· To comply with the law\n" +
                "Retention of Data\n" +
                "Waivio Technologies Inc. will retain your Personal Data only for as long as is necessary for the purposes set out in this Privacy Policy. We will retain and use your Personal Data to the extent necessary to comply with our legal obligations (for example, if we are required to retain your data to comply with applicable laws), resolve disputes and enforce our legal agreements and policies.\n" +
                "Waivio Technologies Inc. will also retain Usage Data for internal analysis purposes. Usage Data is generally retained for a shorter period of time, except when this data is used to strengthen the security or to improve the functionality of our Service, or we are legally obligated to retain this data for longer periods.\n" +
                "Transfer of Data\n" +
                "Your information, including Personal Data, may be transferred to - and maintained on - computers located outside of your state, province, country or other governmental jurisdiction where the data protection laws may differ from those of your jurisdiction.\n" +
                "If you are located outside Canada and choose to provide information to us, please note that we transfer the data, including Personal Data, to Canada and process it there.\n" +
                "Your consent to this Privacy Policy followed by your submission of such information represents your agreement to that transfer.\n" +
                "Waivio Technologies Inc. will take all the steps reasonably necessary to ensure that your data is treated securely and in accordance with this Privacy Policy and no transfer of your Personal Data will take place to an organisation or a country unless there are adequate controls in place including the security of your data and other personal information.\n" +
                "Disclosure of Data\n" +
                "Business Transaction\n" +
                "If Waivio Technologies Inc. is involved in a merger, acquisition or asset sale, your Personal Data may be transferred. We will provide notice before your Personal Data is transferred and becomes subject to a different Privacy Policy.\n" +
                "Disclosure for Law Enforcement\n" +
                "Under certain circumstances, Waivio Technologies Inc. may be required to disclose your Personal Data if required to do so by law or in response to valid requests by public authorities (e.g. a court or a government agency).\n" +
                "Legal Requirements\n" +
                "Waivio Technologies Inc. may disclose your Personal Data in the good faith belief that such action is necessary to:\n" +
                "· To comply with a legal obligation\n" +
                "· To protect and defend the rights or property of Waivio Technologies Inc.\n" +
                "· To prevent or investigate possible wrongdoing in connection with the Service\n" +
                "· To protect the personal safety of users of the Service or the public\n" +
                "· To protect against legal liability\n" +
                "Security of Data\n" +
                "The security of your data is important to us but remember that no method of transmission over the Internet or method of electronic storage is 100% secure. While we strive to use commercially acceptable means to protect your Personal Data, we cannot guarantee its absolute security.\n" +
                "Our Policy on \"Do Not Track\" Signals under the California Online Protection Act (CalOPPA)\n" +
                "We do not support Do Not Track (\"DNT\"). Do Not Track is a preference you can set in your web browser to inform websites that you do not want to be tracked.\n" +
                "You can enable or disable Do Not Track by visiting the Preferences or Settings page of your web browser.\n" +
                "Your Data Protection Rights under the General Data Protection Regulation (GDPR)\n" +
                "If you are a resident of the European Economic Area (EEA), you have certain data protection rights. Waivio Technologies Inc. aims to take reasonable steps to allow you to correct, amend, delete or limit the use of your Personal Data.\n" +
                "If you wish to be informed about what Personal Data we hold about you and if you want it to be removed from our systems, please contact us by email at support(at)waivio.com\n" +
                "In certain circumstances, you have the following data protection rights:\n" +
                "The right to access, update or delete the information we have on you. Whenever made possible, you can access, update or request deletion of your Personal Data directly within your account settings section. If you are unable to perform these actions yourself, please contact us to assist you.\n" +
                "The right of rectification. You have the right to have your information rectified if that information is inaccurate or incomplete.\n" +
                "The right to object. You have the right to object to our processing of your Personal Data.\n" +
                "The right of restriction. You have the right to request that we restrict the processing of your personal information.\n" +
                "The right to data portability. You have the right to be provided with a copy of the information we have on you in a structured, machine-readable and commonly used format.\n" +
                "The right to withdraw consent. You also have the right to withdraw your consent at any time where Waivio Technologies Inc. relied on your consent to process your personal information.\n" +
                "Please note that we may ask you to verify your identity before responding to such requests.\n" +
                "You have the right to complain to a Data Protection Authority about our collection and use of your Personal Data. For more information, please contact your local data protection authority in the European Economic Area (EEA).\n" +
                "Service Providers\n" +
                "We may employ third party companies and individuals to facilitate our Service (\"Service Providers\"), provide the Service on our behalf, perform Service-related services or assist us in analysing how our Service is used.\n" +
                "These third parties have access to your Personal Data only to perform these tasks on our behalf and are obligated not to disclose or use it for any other purpose.\n" +
                "Analytics\n" +
                "We may use third-party Service Providers to monitor and analyse the use of our Service.\n" +
                "Google Analytics\n" +
                "Google Analytics is a web analytics service offered by Google that tracks and reports website traffic. Google uses the data collected to track and monitor the use of our Service. This data is shared with other Google services. Google may use the collected data to contextualise and personalise the ads of its own advertising network.\n" +
                "You can opt-out of having made your activity on the Service available to Google Analytics by installing the Google Analytics opt-out browser add-on. The add-on prevents the Google Analytics JavaScript (ga.js, analytics.js and dc.js) from sharing information with Google Analytics about visits activity.\n" +
                "For more information on the privacy practices of Google, please visit the Google Privacy Terms web page: https://policies.google.com/privacy?hl=en\n" +
                "Advertising\n" +
                "We may use third-party Service Providers to show advertisements to you to help support and maintain our Service.\n" +
                "Google AdSense DoubleClick Cookie\n" +
                "Google, as a third party vendor, uses cookies to serve ads on our Service. Google's use of the DoubleClick cookie enables it and its partners to serve ads to our users based on their visit to our Service or other websites on the Internet.\n" +
                "You may opt out of the use of the DoubleClick Cookie for interest-based advertising by visiting the Google Ads Settings web page: http://www.google.com/ads/preferences/\n" +
                "Behavioral Remarketing\n" +
                "Waivio Technologies Inc. uses remarketing services to advertise on third party websites to you after you visited our Service. We and our third-party vendors use cookies to inform, optimise and serve ads based on your past visits to our Service.\n" +
                "Google Ads (AdWords)\n" +
                "Google Ads (AdWords) remarketing service is provided by Google Inc.\n" +
                "You can opt-out of Google Analytics for Display Advertising and customise the Google Display Network ads by visiting the Google Ads Settings page: http://www.google.com/settings/ads\n" +
                "Google also recommends installing the Google Analytics Opt-out Browser Add-on - https://tools.google.com/dlpage/gaoptout - for your web browser. Google Analytics Opt-out Browser Add-on provides visitors with the ability to prevent their data from being collected and used by Google Analytics.\n" +
                "For more information on the privacy practices of Google, please visit the Google Privacy Terms web page: https://policies.google.com/privacy?hl=en\n" +
                "Payments\n" +
                "We may provide paid products and/or services within the Service. In that case, we use third-party services for payment processing (e.g. payment processors).\n" +
                "We will not store or collect your payment card details. That information is provided directly to our third-party payment processors whose use of your personal information is governed by their Privacy Policy. These payment processors adhere to the standards set by PCI-DSS as managed by the PCI Security Standards Council, which is a joint effort of brands like Visa, MasterCard, American Express and Discover. PCI-DSS requirements help ensure the secure handling of payment information.\n" +
                "The payment processors we work with are:\n" +
                "PayPal / Braintree\n" +
                "Their Privacy Policy can be viewed at https://www.paypal.com/webapps/mpp/ua/privacy-full\n" +
                "Links to Other Sites\n" +
                "Our Service may contain links to other sites that are not operated by us. If you click a third party link, you will be directed to that third party's site. We strongly advise you to review the Privacy Policy of every site you visit.\n" +
                "We have no control over and assume no responsibility for the content, privacy policies or practices of any third party sites or services.\n" +
                "Children's Privacy\n" +
                "Our Service does not address anyone under the age of 18 (\"Children\").\n" +
                "We do not knowingly collect personally identifiable information from anyone under the age of 18. If you are a parent or guardian and you are aware that your Child has provided us with Personal Data, please contact us. If we become aware that we have collected Personal Data from children without verification of parental consent, we take steps to remove that information from our servers.\n" +
                "Changes to This Privacy Policy\n" +
                "We may update our Privacy Policy from time to time. We will notify you of any changes by posting the new Privacy Policy on this page.\n" +
                "We will let you know via email and/or a prominent notice on our Service, prior to the change becoming effective and update the \"effective date\" at the top of this Privacy Policy.\n" +
                "You are advised to review this Privacy Policy periodically for any changes. Changes to this Privacy Policy are effective when they are posted on this page.";
        String actualResult = pageObjectPage.getContentPage();
        assertEquals(expectedResult, actualResult);
    }


}


