package com.ecommerce.GPDemo.response;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {
    private  String message;
    private String email;
    private String accessToken;
}
