package Junit5.Profile.HiveUser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DepositWalletTest extends TestBase {
  String user = getUserLogin();

  String blurtCurrency = "BLURT (BLURT)";
  String btsCurrency = "BTS (BTS)";
  String eosCurrency = "EOS (EOS)";
  String golosCurrency = "GOLOS CLASSIC (GOLOS)";
  String hbdCurrency = "HBD (HBD)";
  String hiveCurrency = "HIVE (HIVE)";
  String sbdCurrency = "SBD (SBD)";
  String steemCurrency = "STEEM (STEEM)";
  String engCurrency = "SteemEngine ENG";
  String tlosCurrency = "TLOS";
  String waxCurrency = "WAX";
  String btcCurrency = "Bitcoin (BTC)";
  String bchCurrency = "Bitcoin Cash (BCH)";
  String dogeCurrency = "Dogecoin (DOGE)";
  String ltcCurrency = "Litecoin (LTC)";
  String swiftCurrency = "SwiftCash (SWIFT)";

  String steemEngineAccount = "steem-engine";
  String blurtAccount = "blurt-swap";
  String grapheneAccount = "graphene-swap";
  String hiveAccount = "honey-swap";
  String engTokensAccount = "steem-tokens";
  String steemEngAccount = "steemenginex";
  String waxAccount = "hiveenginewx";

  String btsMemo = "SWAP.BTS " + user;
  String blurtMemo = "SWAP.BLURT " + user;
  String eosMemo = "SWAP.EOS " + user;
  String golosMemo = "SWAP.GOLOS " + user;
  String hbdMemo = "SWAP.HBD " + user;
  String sbdMemo = "SWAP.SBD " + user;
  String steemMemo = "SWAP.STEEM " + user;
  String engMemo = "SWAP.ENG " + user;
  String tlosMemo = "SWAP.TLOS " + user;
  String waxMemo = "SWAP.WAX " + user;
  String hiveMemo = "{\"id\":\"ssc-mainnet-hive\",\"json\":{\"contractName\":\"hivepegged\"," +
      "\"contractAction\":\"buy\",\"contractPayload\":{}}}";

  @BeforeAll
  static void login() {
    feedPage = FeedPage.openFeedPage();
    header.logInWithHiveSigner(getUserLogin(), getUserPassword());
    postsPage = header.clickOnAccountIcon();
    walletPage = postsPage.clickOnWalletProfileItem();
    walletPage.openHiveWalletTab();
    walletPage.clickDeposit();
  }

  @Story("Check deposit")
  @DisplayName("Check open swap modal window")
  @Test
  void checkOpenSwapModalWindow() {
    String expectedResult = "Deposit";
    String actualResult = getTitleModalWindow();
    assertEquals(expectedResult, actualResult);
  }

  @Story("Deposit")
  @DisplayName("Check BLURT instructions")
  @Test
  void checkBLURT() {
    walletPage.clickDepositDropdown(blurtCurrency);
    String actualAccount = walletPage.getContentFirstInputInDeposit();
    String actualMemo = walletPage.getMemoInDeposit();
    assertEquals(blurtAccount, actualAccount, "BLURT account  is wrong");
    assertEquals(blurtMemo, actualMemo, "BLURT memo is wrong");
  }

  @Story("Deposit")
  @DisplayName("Check BTS instructions")
  @Test
  void checkBTS() {
    walletPage.clickDepositDropdown(btsCurrency);
    String actualAccount = walletPage.getContentFirstInputInDeposit();
    String actualMemo = walletPage.getMemoInDeposit();
    assertEquals(steemEngineAccount, actualAccount, "BTS account  is wrong");
    assertEquals(btsMemo, actualMemo, "BTS memo is wrong");
  }

  @Story("Deposit")
  @DisplayName("Check EOS instructions")
  @Test
  void checkEOS() {
    walletPage.clickDepositDropdown(eosCurrency);
    String actualAccount = walletPage.getContentFirstInputInDeposit();
    String actualMemo = walletPage.getMemoInDeposit();
    assertEquals(steemEngAccount, actualAccount, "EOS account  is wrong");
    assertEquals(eosMemo, actualMemo, "EOS memo is wrong");
  }

  @Story("Deposit")
  @DisplayName("Check GOLOS CLASSIC instructions")
  @Test
  void checkGOLOS() {
    walletPage.clickDepositDropdown(golosCurrency);
    String actualAccount = walletPage.getContentFirstInputInDeposit();
    String actualMemo = walletPage.getMemoInDeposit();
    assertEquals(steemEngineAccount, actualAccount, "GOLOS account  is wrong");
    assertEquals(golosMemo, actualMemo, "GOLOS memo is wrong");
  }

  @Story("Deposit")
  @DisplayName("Check HBD instructions")
  @Test
  void checkHBD() {
    walletPage.clickDepositDropdown(hbdCurrency);
    String actualAccount = walletPage.getContentFirstInputInDeposit();
    String actualMemo = walletPage.getMemoInDeposit();
    assertEquals(grapheneAccount, actualAccount, "HBD account  is wrong");
    assertEquals(hbdMemo, actualMemo, "HBD memo is wrong");
  }

  @Story("Deposit")
  @DisplayName("Check HIVE instructions")
  @Test
  void checkHIVE() {
    walletPage.clickDepositDropdown(hiveCurrency);
    String actualAccount = walletPage.getContentFirstInputInDeposit();
    String actualMemo = walletPage.getMemoInDeposit();
    assertEquals(hiveAccount, actualAccount, "HIVE account  is wrong");
    assertEquals(hiveMemo, actualMemo, "HIVE memo is wrong");
  }

  @Story("Deposit")
  @DisplayName("Check SBD instructions")
  @Test
  void checkSBD() {
    walletPage.clickDepositDropdown(sbdCurrency);
    String actualAccount = walletPage.getContentFirstInputInDeposit();
    String actualMemo = walletPage.getMemoInDeposit();
    assertEquals(grapheneAccount, actualAccount, "SBD account  is wrong");
    assertEquals(sbdMemo, actualMemo, "SBD memo is wrong");
  }

  @Story("Deposit")
  @DisplayName("Check STEEM instructions")
  @Test
  void checkSTEEM() {
    walletPage.clickDepositDropdown(steemCurrency);
    String actualAccount = walletPage.getContentFirstInputInDeposit();
    String actualMemo = walletPage.getMemoInDeposit();
    assertEquals(grapheneAccount, actualAccount, "STEEM account  is wrong");
    assertEquals(steemMemo, actualMemo, "STEEM memo is wrong");
  }

  @Story("Deposit")
  @DisplayName("Check ENG instructions")
  @Test
  void checkENG() {
    walletPage.clickDepositDropdown(engCurrency);
    String actualAccount = walletPage.getContentFirstInputInDeposit();
    String actualMemo = walletPage.getMemoInDeposit();
    assertEquals(engTokensAccount, actualAccount, "ENG account  is wrong");
    assertEquals(engMemo, actualMemo, "ENG memo is wrong");
  }

  @Story("Deposit")
  @DisplayName("Check TLOS instructions")
  @Test
  void checkTLOS() {
    walletPage.clickDepositDropdown(tlosCurrency);
    String actualAccount = walletPage.getContentFirstInputInDeposit();
    String actualMemo = walletPage.getMemoInDeposit();
    assertEquals(steemEngAccount, actualAccount, "TLOS account  is wrong");
    assertEquals(tlosMemo, actualMemo, "TLOS memo is wrong");
  }

  @Story("Deposit")
  @DisplayName("Check WAX instructions")
  @Test
  void checkWAX() {
    walletPage.clickDepositDropdown(waxCurrency);
    String actualAccount = walletPage.getContentFirstInputInDeposit();
    String actualMemo = walletPage.getMemoInDeposit();
    assertEquals(waxAccount, actualAccount, "WAX account  is wrong");
    assertEquals(waxMemo, actualMemo, "WAX memo is wrong");
  }

  //Currencies with addresses
  @Story("Deposit")
  @DisplayName("Check BTC instructions")
  @Test
  void checkBTC() {
    walletPage.clickDepositDropdown(btcCurrency);
    assertTrue(walletPage.isAddressPresent(), "BTC address is wrong");
    assertTrue(walletPage.isQRCodePresent(), "QR code not found");
  }

  @Story("Deposit")
  @DisplayName("Check BCH instructions")
  @Test
  void checkBCH() {
    walletPage.clickDepositDropdown(bchCurrency);
    assertTrue(walletPage.isAddressPresent(), "BCH address is wrong");
    assertTrue(walletPage.isQRCodePresent(), "QR code not found");
  }

  @Story("Deposit")
  @DisplayName("Check DOGE instructions")
  @Test
  void checkDOGE() {
    walletPage.clickDepositDropdown(dogeCurrency);
    assertTrue(walletPage.isAddressPresent(), "DOGE address is wrong");
    assertTrue(walletPage.isQRCodePresent(), "QR code not found");
  }

  @Story("Deposit")
  @DisplayName("Check LTC instructions")
  @Test
  void checkLTC() {
    walletPage.clickDepositDropdown(ltcCurrency);
    assertTrue(walletPage.isAddressPresent(), "LTC address is wrong");
    assertTrue(walletPage.isQRCodePresent(), "QR code not found");
  }

  @Story("Deposit")
  @DisplayName("Check SWIFT instructions")
  @Test
  void checkSWIFT() {
    walletPage.clickDepositDropdown(swiftCurrency);
    assertTrue(walletPage.isAddressPresent(), "SWIFT address is wrong");
    assertTrue(walletPage.isQRCodePresent(), "QR code not found");
  }
}
