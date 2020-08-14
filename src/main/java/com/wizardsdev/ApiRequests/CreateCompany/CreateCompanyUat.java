package com.wizardsdev.ApiRequests.CreateCompany;

public class CreateCompanyUat implements CreateCompanyBase {

  CompanyFieldsUat company;

  public CreateCompanyUat() {
  }

  @Override
  public CreateCompanyUat fillRequiredFields(String externalId, String name, String website) {
    company = new CompanyFieldsUat(externalId, name, website);
    return this;
  }

}

