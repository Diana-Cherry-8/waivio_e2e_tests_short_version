package com.wizardsdev.ApiRequests.CreateCompany;

public class CreateCompany implements CreateCompanyBase {

  CompanyFields company;

  public CreateCompany() {
  }

  @Override
  public CreateCompany fillRequiredFields(String externalId, String name, String website) {
    company = new CompanyFields(externalId, name, website);
    return this;
  }

}

