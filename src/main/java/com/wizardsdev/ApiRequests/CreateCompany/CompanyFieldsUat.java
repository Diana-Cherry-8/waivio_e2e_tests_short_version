package com.wizardsdev.ApiRequests.CreateCompany;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CompanyFieldsUat {

  @SerializedName("external_id")
  @Expose
  String externalId;
  @SerializedName("name")
  @Expose
  String name;
  @SerializedName("website")
  @Expose
  String website;
  @SerializedName("employees_absolute")
  @Expose
  int employeesAbsolute = 923149;
  @SerializedName("available_locations")
  @Expose
  int availableLocations = 4;
  @SerializedName("revenue_absolute")
  @Expose
  int revenueAbsolute = 735835;
  @SerializedName("linkedin")
  @Expose
  String linkedin = "https://www.linkedin.com/company/eos/";
  @SerializedName("basic_type")
  @Expose
  String basicType = "Private";
  @SerializedName("description")
  @Expose
  String description = "Company for Automated Tests";
  @SerializedName("fortune_500")
  @Expose
  boolean fortune500 = true;
  @SerializedName("global_2000")
  @Expose
  boolean global2000 = true;
  @SerializedName("inc_5000")
  @Expose
  boolean inc5000 = true;
  @SerializedName("fortune_1000")
  @Expose
  boolean fortune1000 = true;
  @SerializedName("saas_1000")
  @Expose
  boolean saas1000 = true;
  @SerializedName("sales_growth")
  @Expose
  int salesGrowth = 456456;
  @SerializedName("year_founded")
  @Expose
  int yearFounded = 456456;
  @SerializedName("employees_growth")
  @Expose
  int employeesGrowth = 456456;
  @SerializedName("hospital_beds")
  @Expose
  int hospitalBeds = 456456;
  @SerializedName("phone")
  @Expose
  String phone = "8668355322";
  @SerializedName("sic_code")
  @Expose
  String sicCode = "5323";
  @SerializedName("naics_code")
  @Expose
  String naicsCode = "113690";
  @SerializedName("employees_category_id")
  @Expose
  String employeesCategoryId = "94ddd052-450e-47e3-9374-7e5d4e19ad8e";
  @SerializedName("revenue_category_id")
  @Expose
  String revenueCategoryId = "b1b49099-4472-403a-b57a-306ada76068c";
  @SerializedName("locations")
  @Expose
  List<CompanyLocationsUat> locations = List.of(new CompanyLocationsUat());
  @SerializedName("markets")
  @Expose
  String[] markets = {
      "16bd1cb7-aba6-4fb1-8ad9-df7441658490",
      "98d90a88-1b62-4aa0-bbe1-02d4a07a1f32",
      "1d2a1142-80c2-4a24-8d2f-dff784f66306"
  };
  @SerializedName("industries")
  @Expose
  String[] industries = {"5c3a9079-73da-4412-afa3-daf6337c6755"};
  @SerializedName("sub_industries")
  @Expose
  String[] subIndustries = {};

  public CompanyFieldsUat(String externalId, String name, String website) {
    this.externalId = externalId;
    this.name = name;
    this.website = website;
  }
}
