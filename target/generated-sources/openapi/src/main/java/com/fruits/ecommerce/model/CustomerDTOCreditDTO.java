package com.fruits.ecommerce.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CustomerDTOCreditDTO
 */

@JsonTypeName("CustomerDTO_CreditDTO")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-17T23:15:03.663996300+03:00[Africa/Cairo]")
public class CustomerDTOCreditDTO {

  private Long id = null;

  private String cardNumber;

  private String expiryDate;

  private Integer cvv;

  public CustomerDTOCreditDTO id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", example = "2", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public CustomerDTOCreditDTO cardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
    return this;
  }

  /**
   * Get cardNumber
   * @return cardNumber
  */
  
  @Schema(name = "card_number", example = "1234-5678-9101-1121", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("card_number")
  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public CustomerDTOCreditDTO expiryDate(String expiryDate) {
    this.expiryDate = expiryDate;
    return this;
  }

  /**
   * Get expiryDate
   * @return expiryDate
  */
  
  @Schema(name = "expiry_date", example = "12/2025", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("expiry_date")
  public String getExpiryDate() {
    return expiryDate;
  }

  public void setExpiryDate(String expiryDate) {
    this.expiryDate = expiryDate;
  }

  public CustomerDTOCreditDTO cvv(Integer cvv) {
    this.cvv = cvv;
    return this;
  }

  /**
   * Get cvv
   * @return cvv
  */
  
  @Schema(name = "cvv", example = "123", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("cvv")
  public Integer getCvv() {
    return cvv;
  }

  public void setCvv(Integer cvv) {
    this.cvv = cvv;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerDTOCreditDTO customerDTOCreditDTO = (CustomerDTOCreditDTO) o;
    return Objects.equals(this.id, customerDTOCreditDTO.id) &&
        Objects.equals(this.cardNumber, customerDTOCreditDTO.cardNumber) &&
        Objects.equals(this.expiryDate, customerDTOCreditDTO.expiryDate) &&
        Objects.equals(this.cvv, customerDTOCreditDTO.cvv);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, cardNumber, expiryDate, cvv);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerDTOCreditDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    cardNumber: ").append(toIndentedString(cardNumber)).append("\n");
    sb.append("    expiryDate: ").append(toIndentedString(expiryDate)).append("\n");
    sb.append("    cvv: ").append(toIndentedString(cvv)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

