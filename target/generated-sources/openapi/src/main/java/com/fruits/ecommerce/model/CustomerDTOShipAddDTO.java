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
 * CustomerDTOShipAddDTO
 */

@JsonTypeName("CustomerDTO_ShipAddDTO")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-17T23:15:03.663996300+03:00[Africa/Cairo]")
public class CustomerDTOShipAddDTO {

  private Long id = null;

  private String addressL1;

  private String addressL2;

  private String postalCode;

  public CustomerDTOShipAddDTO id(Long id) {
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

  public CustomerDTOShipAddDTO addressL1(String addressL1) {
    this.addressL1 = addressL1;
    return this;
  }

  /**
   * Get addressL1
   * @return addressL1
  */
  
  @Schema(name = "addressL1", example = "hella", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("addressL1")
  public String getAddressL1() {
    return addressL1;
  }

  public void setAddressL1(String addressL1) {
    this.addressL1 = addressL1;
  }

  public CustomerDTOShipAddDTO addressL2(String addressL2) {
    this.addressL2 = addressL2;
    return this;
  }

  /**
   * Get addressL2
   * @return addressL2
  */
  
  @Schema(name = "addressL2", example = "bella", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("addressL2")
  public String getAddressL2() {
    return addressL2;
  }

  public void setAddressL2(String addressL2) {
    this.addressL2 = addressL2;
  }

  public CustomerDTOShipAddDTO postalCode(String postalCode) {
    this.postalCode = postalCode;
    return this;
  }

  /**
   * Get postalCode
   * @return postalCode
  */
  
  @Schema(name = "postal_code", example = "12547", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("postal_code")
  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerDTOShipAddDTO customerDTOShipAddDTO = (CustomerDTOShipAddDTO) o;
    return Objects.equals(this.id, customerDTOShipAddDTO.id) &&
        Objects.equals(this.addressL1, customerDTOShipAddDTO.addressL1) &&
        Objects.equals(this.addressL2, customerDTOShipAddDTO.addressL2) &&
        Objects.equals(this.postalCode, customerDTOShipAddDTO.postalCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, addressL1, addressL2, postalCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerDTOShipAddDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    addressL1: ").append(toIndentedString(addressL1)).append("\n");
    sb.append("    addressL2: ").append(toIndentedString(addressL2)).append("\n");
    sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
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

