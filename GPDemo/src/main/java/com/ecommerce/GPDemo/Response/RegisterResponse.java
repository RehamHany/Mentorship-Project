package com.ecommerce.GPDemo.Response;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RegisterResponse {
    private  String message;
    private String email;
}
