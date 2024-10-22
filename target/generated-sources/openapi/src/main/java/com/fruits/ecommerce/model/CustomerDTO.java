package com.fruits.ecommerce.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fruits.ecommerce.model.CustomerDTOCreditDTO;
import com.fruits.ecommerce.model.CustomerDTOShipAddDTO;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CustomerDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-17T23:15:03.663996300+03:00[Africa/Cairo]")
public class CustomerDTO {

  private Long id = null;

  private String username;

  private String email;

  private String password;

  private CustomerDTOShipAddDTO shipAddDTO;

  private CustomerDTOShipAddDTO billAddDTO;

  private CustomerDTOCreditDTO creditDTO;

  public CustomerDTO id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", example = "10", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public CustomerDTO username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Get username
   * @return username
  */
  
  @Schema(name = "username", example = "theUser", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("username")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public CustomerDTO email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  */
  
  @Schema(name = "email", example = "john@email.com", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public CustomerDTO password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
  */
  
  @Schema(name = "password", example = "12345", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("password")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public CustomerDTO shipAddDTO(CustomerDTOShipAddDTO shipAddDTO) {
    this.shipAddDTO = shipAddDTO;
    return this;
  }

  /**
   * Get shipAddDTO
   * @return shipAddDTO
  */
  @Valid 
  @Schema(name = "ShipAddDTO", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ShipAddDTO")
  public CustomerDTOShipAddDTO getShipAddDTO() {
    return shipAddDTO;
  }

  public void setShipAddDTO(CustomerDTOShipAddDTO shipAddDTO) {
    this.shipAddDTO = shipAddDTO;
  }

  public CustomerDTO billAddDTO(CustomerDTOShipAddDTO billAddDTO) {
    this.billAddDTO = billAddDTO;
    return this;
  }

  /**
   * Get billAddDTO
   * @return billAddDTO
  */
  @Valid 
  @Schema(name = "BillAddDTO", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("BillAddDTO")
  public CustomerDTOShipAddDTO getBillAddDTO() {
    return billAddDTO;
  }

  public void setBillAddDTO(CustomerDTOShipAddDTO billAddDTO) {
    this.billAddDTO = billAddDTO;
  }

  public CustomerDTO creditDTO(CustomerDTOCreditDTO creditDTO) {
    this.creditDTO = creditDTO;
    return this;
  }

  /**
   * Get creditDTO
   * @return creditDTO
  */
  @Valid 
  @Schema(name = "CreditDTO", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("CreditDTO")
  public CustomerDTOCreditDTO getCreditDTO() {
    return creditDTO;
  }

  public void setCreditDTO(CustomerDTOCreditDTO creditDTO) {
    this.creditDTO = creditDTO;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerDTO customerDTO = (CustomerDTO) o;
    return Objects.equals(this.id, customerDTO.id) &&
        Objects.equals(this.username, customerDTO.username) &&
        Objects.equals(this.email, customerDTO.email) &&
        Objects.equals(this.password, customerDTO.password) &&
        Objects.equals(this.shipAddDTO, customerDTO.shipAddDTO) &&
        Objects.equals(this.billAddDTO, customerDTO.billAddDTO) &&
        Objects.equals(this.creditDTO, customerDTO.creditDTO);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, username, email, password, shipAddDTO, billAddDTO, creditDTO);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    shipAddDTO: ").append(toIndentedString(shipAddDTO)).append("\n");
    sb.append("    billAddDTO: ").append(toIndentedString(billAddDTO)).append("\n");
    sb.append("    creditDTO: ").append(toIndentedString(creditDTO)).append("\n");
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

