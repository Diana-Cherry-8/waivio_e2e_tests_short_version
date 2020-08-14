package com.wizardsdev.ApiRequests.CreateCompany;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CompanyLocationsUat {

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
  String stateId = "5f2b6a85-f8cf-423e-abef-d2d4cd19a3e3";
  @SerializedName("zip_code")
  @Expose
  String zipCode = "12973";
  @SerializedName("city_id")
  @Expose
  String cityId = "252a3140-feeb-4099-8782-f0c2f3cb0b5f";
}
