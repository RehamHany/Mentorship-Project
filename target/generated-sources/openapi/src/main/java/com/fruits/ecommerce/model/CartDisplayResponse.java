package com.fruits.ecommerce.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fruits.ecommerce.model.CartDisplayResponseCartTotal;
import com.fruits.ecommerce.model.CartDisplayResponseProductsDetailsInner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CartDisplayResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-17T23:15:03.663996300+03:00[Africa/Cairo]")
public class CartDisplayResponse {

  @Valid
  private List<@Valid CartDisplayResponseProductsDetailsInner> productsDetails;

  private CartDisplayResponseCartTotal cartTotal;

  public CartDisplayResponse productsDetails(List<@Valid CartDisplayResponseProductsDetailsInner> productsDetails) {
    this.productsDetails = productsDetails;
    return this;
  }

  public CartDisplayResponse addProductsDetailsItem(CartDisplayResponseProductsDetailsInner productsDetailsItem) {
    if (this.productsDetails == null) {
      this.productsDetails = new ArrayList<>();
    }
    this.productsDetails.add(productsDetailsItem);
    return this;
  }

  /**
   * Get productsDetails
   * @return productsDetails
  */
  @Valid 
  @Schema(name = "ProductsDetails", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ProductsDetails")
  public List<@Valid CartDisplayResponseProductsDetailsInner> getProductsDetails() {
    return productsDetails;
  }

  public void setProductsDetails(List<@Valid CartDisplayResponseProductsDetailsInner> productsDetails) {
    this.productsDetails = productsDetails;
  }

  public CartDisplayResponse cartTotal(CartDisplayResponseCartTotal cartTotal) {
    this.cartTotal = cartTotal;
    return this;
  }

  /**
   * Get cartTotal
   * @return cartTotal
  */
  @Valid 
  @Schema(name = "CartTotal", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("CartTotal")
  public CartDisplayResponseCartTotal getCartTotal() {
    return cartTotal;
  }

  public void setCartTotal(CartDisplayResponseCartTotal cartTotal) {
    this.cartTotal = cartTotal;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CartDisplayResponse cartDisplayResponse = (CartDisplayResponse) o;
    return Objects.equals(this.productsDetails, cartDisplayResponse.productsDetails) &&
        Objects.equals(this.cartTotal, cartDisplayResponse.cartTotal);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productsDetails, cartTotal);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CartDisplayResponse {\n");
    sb.append("    productsDetails: ").append(toIndentedString(productsDetails)).append("\n");
    sb.append("    cartTotal: ").append(toIndentedString(cartTotal)).append("\n");
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

