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
 * CartDisplayResponseCartTotal
 */

@JsonTypeName("CartDisplayResponse_CartTotal")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-17T23:15:03.663996300+03:00[Africa/Cairo]")
public class CartDisplayResponseCartTotal {

  private Long subTotal = null;

  private Long shipCost = null;

  private Long total = null;

  public CartDisplayResponseCartTotal subTotal(Long subTotal) {
    this.subTotal = subTotal;
    return this;
  }

  /**
   * Get subTotal
   * @return subTotal
  */
  
  @Schema(name = "subTotal", example = "125", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("subTotal")
  public Long getSubTotal() {
    return subTotal;
  }

  public void setSubTotal(Long subTotal) {
    this.subTotal = subTotal;
  }

  public CartDisplayResponseCartTotal shipCost(Long shipCost) {
    this.shipCost = shipCost;
    return this;
  }

  /**
   * Get shipCost
   * @return shipCost
  */
  
  @Schema(name = "shipCost", example = "45", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("shipCost")
  public Long getShipCost() {
    return shipCost;
  }

  public void setShipCost(Long shipCost) {
    this.shipCost = shipCost;
  }

  public CartDisplayResponseCartTotal total(Long total) {
    this.total = total;
    return this;
  }

  /**
   * Get total
   * @return total
  */
  
  @Schema(name = "total", example = "170", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("total")
  public Long getTotal() {
    return total;
  }

  public void setTotal(Long total) {
    this.total = total;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CartDisplayResponseCartTotal cartDisplayResponseCartTotal = (CartDisplayResponseCartTotal) o;
    return Objects.equals(this.subTotal, cartDisplayResponseCartTotal.subTotal) &&
        Objects.equals(this.shipCost, cartDisplayResponseCartTotal.shipCost) &&
        Objects.equals(this.total, cartDisplayResponseCartTotal.total);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subTotal, shipCost, total);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CartDisplayResponseCartTotal {\n");
    sb.append("    subTotal: ").append(toIndentedString(subTotal)).append("\n");
    sb.append("    shipCost: ").append(toIndentedString(shipCost)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
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

