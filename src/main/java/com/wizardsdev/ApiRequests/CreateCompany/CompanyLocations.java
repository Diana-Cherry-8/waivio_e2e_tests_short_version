package com.wizardsdev.ApiRequests.CreateCompany;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CompanyLocations {

  @SerializedName("address_1")
  @Expose
  String address1 = "0703 Timika Parkway";
  @SerializedName("address_2")
  @Expose
  String address2 = "036 Keebler Fall";
  @SerializedName("hq")
  @Expose
  boolean hq = true;
  @SerializedName("country_id")
  @Expose
  String countryId = "e0a0cd63-8e52-4b78-9884-4695204a9d56";
  @SerializedName("state_id")
  @Expose
  String stateId = "5aa00740-65cc-4d3d-8771-f1fae4042a0c";
  @SerializedName("zip_code")
  @Expose
  String zipCode = "12973";
  @SerializedName("city_id")
  @Expose
  String cityId = "29d9751f-19d5-4caf-a00a-b6d09a0a7758";
}
