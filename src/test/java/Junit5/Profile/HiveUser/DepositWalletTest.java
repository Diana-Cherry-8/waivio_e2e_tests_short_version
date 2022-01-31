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
  @DisplayName("Check open deposit modal window")
  @Test
  void checkOpenSwapModalWindow() {
    String expectedResult = "Deposit";
    String actualResult = getTitleModalWindow();
    assertEquals(expectedResult, actualResult);
  }

  @Story("Deposit")
  @DisplayName("Check account name BLURT instructions")
  @Test
  void checkAccountBlurt() {
    walletPage.clickDepositDropdown(blurtCurrency);
    String actualAccount = walletPage.getContentFirstInputInDeposit();
    assertEquals(blurtAccount, actualAccount, "BLURT account is wrong");
  }

  @Story("Deposit")
  @DisplayName("Check memo BLURT instructions")
  @Test
  void checkMemoBlurt() {
    walletPage.clickDepositDropdown(blurtCurrency);
    String actualMemo = walletPage.getMemoInDeposit();
    assertEquals(blurtMemo, actualMemo, "BLURT memo is wrong");
  }

  @Story("Deposit")
  @DisplayName("Check account name BTS instructions")
  @Test
  void checkAccountBts() {
    walletPage.clickDepositDropdown(btsCurrency);
    String actualAccount = walletPage.getContentFirstInputInDeposit();
    assertEquals(steemEngineAccount, actualAccount, "BTS account is wrong");
  }

  @Story("Deposit")
  @DisplayName("Check memo BTS instructions")
  @Test
  void checkMemoBts() {
    walletPage.clickDepositDropdown(btsCurrency);
    String actualMemo = walletPage.getMemoInDeposit();
    assertEquals(btsMemo, actualMemo, "BTS memo is wrong");
  }

  @Story("Deposit")
  @DisplayName("Check account name EOS instructions")
  @Test
  void checkAccountEos() {
    walletPage.clickDepositDropdown(eosCurrency);
    String actualAccount = walletPage.getContentFirstInputInDeposit();
    assertEquals(steemEngAccount, actualAccount, "EOS account is wrong");
  }

  @Story("Deposit")
  @DisplayName("Check memo EOS instructions")
  @Test
  void checkMemoEos() {
    walletPage.clickDepositDropdown(eosCurrency);
    String actualMemo = walletPage.getMemoInDeposit();
    assertEquals(eosMemo, actualMemo, "EOS memo is wrong");
  }

  @Story("Deposit")
  @DisplayName("Check account name GOLOS CLASSIC instructions")
  @Test
  void checkAccountGolos() {
    walletPage.clickDepositDropdown(golosCurrency);
    String actualAccount = walletPage.getContentFirstInputInDeposit();
    assertEquals(steemEngineAccount, actualAccount, "GOLOS account is wrong");
  }

  @Story("Deposit")
  @DisplayName("Check memo GOLOS CLASSIC instructions")
  @Test
  void checkMemoGolos() {
    walletPage.clickDepositDropdown(golosCurrency);
    String actualMemo = walletPage.getMemoInDeposit();
    assertEquals(golosMemo, actualMemo, "GOLOS memo is wrong");
  }

  @Story("Deposit")
  @DisplayName("Check account name HBD instructions")
  @Test
  void checkAccountHbd() {
    walletPage.clickDepositDropdown(hbdCurrency);
    String actualAccount = walletPage.getContentFirstInputInDeposit();
    assertEquals(grapheneAccount, actualAccount, "HBD account is wrong");
  }

  @Story("Deposit")
  @DisplayName("Check memo HBD instructions")
  @Test
  void checkMemoHbd() {
    walletPage.clickDepositDropdown(hbdCurrency);
    String actualMemo = walletPage.getMemoInDeposit();
    assertEquals(hbdMemo, actualMemo, "HBD memo is wrong");
  }

  @Story("Deposit")
  @DisplayName("Check account name HIVE instructions")
  @Test
  void checkAccountHive() {
    walletPage.clickDepositDropdown(hiveCurrency);
    String actualAccount = walletPage.getContentFirstInputInDeposit();
    assertEquals(hiveAccount, actualAccount, "HIVE account is wrong");
  }

  @Story("Deposit")
  @DisplayName("Check memo HIVE instructions")
  @Test
  void checkMemoHive() {
    walletPage.clickDepositDropdown(hiveCurrency);
    String actualMemo = walletPage.getMemoInDeposit();
    assertEquals(hiveMemo, actualMemo, "HIVE memo is wrong");
  }

  @Story("Deposit")
  @DisplayName("Check account name SBD instructions")
  @Test
  void checkAccountSbd() {
    walletPage.clickDepositDropdown(sbdCurrency);
    String actualAccount = walletPage.getContentFirstInputInDeposit();
    assertEquals(grapheneAccount, actualAccount, "SBD account is wrong");
  }

  @Story("Deposit")
  @DisplayName("Check memo SBD instructions")
  @Test
  void checkMemoSbd() {
    walletPage.clickDepositDropdown(sbdCurrency);
    String actualMemo = walletPage.getMemoInDeposit();
    assertEquals(sbdMemo, actualMemo, "SBD memo is wrong");
  }

  @Story("Deposit")
  @DisplayName("Check account name STEEM instructions")
  @Test
  void checkAccountSteem() {
    walletPage.clickDepositDropdown(steemCurrency);
    String actualAccount = walletPage.getContentFirstInputInDeposit();
    assertEquals(grapheneAccount, actualAccount, "STEEM account is wrong");
  }

  @Story("Deposit")
  @DisplayName("Check memo STEEM instructions")
  @Test
  void checkMemoSteem() {
    walletPage.clickDepositDropdown(steemCurrency);
    String actualMemo = walletPage.getMemoInDeposit();
    assertEquals(steemMemo, actualMemo, "STEEM memo is wrong");
  }

  @Story("Deposit")
  @DisplayName("Check account name ENG instructions")
  @Test
  void checkAccountEng() {
    walletPage.clickDepositDropdown(engCurrency);
    String actualAccount = walletPage.getContentFirstInputInDeposit();
    assertEquals(engTokensAccount, actualAccount, "ENG account is wrong");
  }

  @Story("Deposit")
  @DisplayName("Check memo ENG instructions")
  @Test
  void checkMemoEng() {
    walletPage.clickDepositDropdown(engCurrency);
    String actualMemo = walletPage.getMemoInDeposit();
    assertEquals(engMemo, actualMemo, "ENG memo is wrong");
  }

  @Story("Deposit")
  @DisplayName("Check account name TLOS instructions")
  @Test
  void checkAccountTlos() {
    walletPage.clickDepositDropdown(tlosCurrency);
    String actualAccount = walletPage.getContentFirstInputInDeposit();
    assertEquals(steemEngAccount, actualAccount, "TLOS account is wrong");
  }

  @Story("Deposit")
  @DisplayName("Check memo TLOS instructions")
  @Test
  void checkMemoTlos() {
    walletPage.clickDepositDropdown(tlosCurrency);
    String actualMemo = walletPage.getMemoInDeposit();
    assertEquals(tlosMemo, actualMemo, "TLOS memo is wrong");
  }

  @Story("Deposit")
  @DisplayName("Check account name WAX instructions")
  @Test
  void checkAccountWax() {
    walletPage.clickDepositDropdown(waxCurrency);
    String actualAccount = walletPage.getContentFirstInputInDeposit();
    assertEquals(waxAccount, actualAccount, "WAX account is wrong");
  }

  @Story("Deposit")
  @DisplayName("Check memo WAX instructions")
  @Test
  void checkMemoWax() {
    walletPage.clickDepositDropdown(waxCurrency);
    String actualMemo = walletPage.getMemoInDeposit();
    assertEquals(waxMemo, actualMemo, "WAX memo is wrong");
  }

  //Currencies with addresses
  @Story("Deposit")
  @DisplayName("Check address BTC instructions")
  @Test
  void checkAddressBtc() {
    walletPage.clickDepositDropdown(btcCurrency);
    assertTrue(walletPage.isAddressPresent(), "BTC address is wrong");
  }
  @Story("Deposit")
  @DisplayName("Check qr code BTC instructions")
  @Test
  void checkQrCodeBtc() {
    walletPage.clickDepositDropdown(btcCurrency);
    assertTrue(walletPage.isQRCodePresent(), "QR code not found");
  }

  @Story("Deposit")
  @DisplayName("Check address BCH instructions")
  @Test
  void checkAddressBch() {
    walletPage.clickDepositDropdown(bchCurrency);
    assertTrue(walletPage.isAddressPresent(), "BCH address is wrong");
  }

  @Story("Deposit")
  @DisplayName("Check qr code BCH instructions")
  @Test
  void checkQrCodeBch() {
    walletPage.clickDepositDropdown(bchCurrency);
    assertTrue(walletPage.isQRCodePresent(), "QR code not found");
  }

  @Story("Deposit")
  @DisplayName("Check address DOGE instructions")
  @Test
  void checkAddressDoge() {
    walletPage.clickDepositDropdown(dogeCurrency);
    assertTrue(walletPage.isAddressPresent(), "DOGE address is wrong");
  }

  @Story("Deposit")
  @DisplayName("Check qr code DOGE instructions")
  @Test
  void checkQrCodeDoge() {
    walletPage.clickDepositDropdown(dogeCurrency);
    assertTrue(walletPage.isQRCodePresent(), "QR code not found");
  }

  @Story("Deposit")
  @DisplayName("Check address LTC instructions")
  @Test
  void checkAddressLtc() {
    walletPage.clickDepositDropdown(ltcCurrency);
    assertTrue(walletPage.isAddressPresent(), "LTC address is wrong");
  }

  @Story("Deposit")
  @DisplayName("Check qr code LTC instructions")
  @Test
  void checkQrCodeLtc() {
    walletPage.clickDepositDropdown(ltcCurrency);
    assertTrue(walletPage.isQRCodePresent(), "QR code not found");
  }

  @Story("Deposit")
  @DisplayName("Check address SWIFT instructions")
  @Test
  void checkAddressSwift() {
    walletPage.clickDepositDropdown(swiftCurrency);
    assertTrue(walletPage.isAddressPresent(), "SWIFT address is wrong");
  }

  @Story("Deposit")
  @DisplayName("Check qr code SWIFT instructions")
  @Test
  void checkQrCodeSwift() {
    walletPage.clickDepositDropdown(swiftCurrency);
    assertTrue(walletPage.isQRCodePresent(), "QR code not found");
  }
}
