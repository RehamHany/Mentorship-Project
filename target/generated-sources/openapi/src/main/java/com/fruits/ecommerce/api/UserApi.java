/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.3.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.fruits.ecommerce.api;

import com.fruits.ecommerce.model.AuthenticationResponse;
import com.fruits.ecommerce.model.CustomerDTO;
import com.fruits.ecommerce.model.Login;
import com.fruits.ecommerce.model.RegisterResponse;
import com.fruits.ecommerce.model.UserDTO;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-17T23:15:03.663996300+03:00[Africa/Cairo]")
@Validated
@Tag(name = "user", description = "Operations about user")
public interface UserApi {

    /**
     * POST /login : Logs user into the system
     * 
     *
     * @param login login user object (optional)
     * @return AuthenticationResponse (status code 200)
     *         or Invalid username/password supplied (status code 403)
     */
    @Operation(
        operationId = "loginUser",
        summary = "Logs user into the system",
        description = "",
        tags = { "user" },
        responses = {
            @ApiResponse(responseCode = "200", description = "AuthenticationResponse", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = AuthenticationResponse.class))
            }),
            @ApiResponse(responseCode = "403", description = "Invalid username/password supplied")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/login",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    ResponseEntity<AuthenticationResponse> _loginUser(
        @Parameter(name = "Login", description = "login user object") @Valid @RequestBody(required = false) Login login
    );


    /**
     * POST /register : register user
     * This can only be done by the logged in user.
     *
     * @param userDTO Created user object (optional)
     * @return RegisterResponse (status code 200)
     *         or User error (status code 403)
     */
    @Operation(
        operationId = "register",
        summary = "register user",
        description = "This can only be done by the logged in user.",
        tags = { "user" },
        responses = {
            @ApiResponse(responseCode = "200", description = "RegisterResponse", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = RegisterResponse.class))
            }),
            @ApiResponse(responseCode = "403", description = "User error")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/register",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    ResponseEntity<RegisterResponse> _register(
        @Parameter(name = "UserDTO", description = "Created user object") @Valid @RequestBody(required = false) UserDTO userDTO
    );


    /**
     * POST /registerClient : register user as a customer
     * This can only be done by the logged in user.
     *
     * @param customerDTO Created client object (optional)
     * @return RegisterResponse (status code 200)
     *         or User error (status code 403)
     */
    @Operation(
        operationId = "registerClient",
        summary = "register user as a customer",
        description = "This can only be done by the logged in user.",
        tags = { "user" },
        responses = {
            @ApiResponse(responseCode = "200", description = "RegisterResponse", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = RegisterResponse.class))
            }),
            @ApiResponse(responseCode = "403", description = "User error")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/registerClient",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    ResponseEntity<RegisterResponse> _registerClient(
        @Parameter(name = "CustomerDTO", description = "Created client object") @Valid @RequestBody(required = false) CustomerDTO customerDTO
    );

}