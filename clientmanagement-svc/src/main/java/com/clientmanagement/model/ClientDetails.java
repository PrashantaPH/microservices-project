package com.clientmanagement.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "clients")
public class ClientDetails {

    @JsonProperty("client_id")
    @Column(name = "client_id", length = 6)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger clientId;

    @Column(name = "entity_name")
    @JsonProperty("entity_name")
    private String entityName;

    private String address;

    private String city;

    @Column(name = "postal_code_po_box")
    @JsonProperty("postal_code_po_box")
    private String postalCode;

    @Column(name = "country_name")
    @JsonProperty("country_name")
    private String countryName;

    @Column(name = "country_code")
    @JsonProperty("country_code")
    private String countryCode;

    @Column(name = "telephone_number")
    @JsonProperty("telephone_number")
    private String telephoneNumber;

    @Column(name = "email_id")
    @JsonProperty("email_id")
    private String emailId;

    @Column(name = "client_type")
    @JsonProperty("client_type")
    private String clientType;

    @Column(name = "tax_registration_number_1")
    @JsonProperty("tax_registration_number_1")
    private String taxRegistrationNumber1;

    @Column(name = "tax_registration_number_2")
    @JsonProperty("tax_registration_number_2")
    private String taxRegistrationNumber2;

    @Column(name = "tax_registration_number_3")
    @JsonProperty("tax_registration_number_3")
    private String taxRegistrationNumber3;

    private String revenue;

    @Column(name = "description_of_client_business")
    @JsonProperty("description_of_client_business")
    private String descriptionOfClientBusiness;

    @Column(name = "description_of_purchases")
    @JsonProperty("description_of_purchases")
    private String descriptionOfPurchases;

    @Column(name = "examples_of_purchases")
    @JsonProperty("examples_of_purchases")
    private String examplesOfPurchases;

    private List<String> additions;

    private String status;

    @Column(name = "industry_type")
    @JsonProperty("industry_type")
    private List<String> industryType;

    @Column(name = "created_by")
    @JsonProperty("created_by")
    private String createdBy;

    @Column(name = "created_on")
    @JsonProperty("created_on")
    private String createdOn;

    @Column(name = "modified_by")
    @JsonProperty("modified_by")
    private String modifiedBy;

    @Column(name = "modified_on")
    @JsonProperty("modified_on")
    private String modifiedOn;

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getTaxRegistrationNumber1() {
        return taxRegistrationNumber1;
    }

    public void setTaxRegistrationNumber1(String taxRegistrationNumber1) {
        this.taxRegistrationNumber1 = taxRegistrationNumber1;
    }

    public String getTaxRegistrationNumber2() {
        return taxRegistrationNumber2;
    }

    public void setTaxRegistrationNumber2(String taxRegistrationNumber2) {
        this.taxRegistrationNumber2 = taxRegistrationNumber2;
    }

    public String getTaxRegistrationNumber3() {
        return taxRegistrationNumber3;
    }

    public void setTaxRegistrationNumber3(String taxRegistrationNumber3) {
        this.taxRegistrationNumber3 = taxRegistrationNumber3;
    }

    public String getRevenue() {
        return revenue;
    }

    public void setRevenue(String revenue) {
        this.revenue = revenue;
    }

    public String getDescriptionOfClientBusiness() {
        return descriptionOfClientBusiness;
    }

    public void setDescriptionOfClientBusiness(String descriptionOfClientBusiness) {
        this.descriptionOfClientBusiness = descriptionOfClientBusiness;
    }

    public String getDescriptionOfPurchases() {
        return descriptionOfPurchases;
    }

    public void setDescriptionOfPurchases(String descriptionOfPurchases) {
        this.descriptionOfPurchases = descriptionOfPurchases;
    }

    public String getExamplesOfPurchases() {
        return examplesOfPurchases;
    }

    public void setExamplesOfPurchases(String examplesOfPurchases) {
        this.examplesOfPurchases = examplesOfPurchases;
    }

    public List<String> getAdditions() {
        return additions;
    }

    public void setAdditions(List<String> additions) {
        this.additions = additions;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getIndustryType() {
        return industryType;
    }

    public void setIndustryType(List<String> industryType) {
        this.industryType = industryType;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
    }
}
