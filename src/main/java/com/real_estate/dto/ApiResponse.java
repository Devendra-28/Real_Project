package com.real_estate.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiResponse {

    private String email;

    private boolean success;


    public ApiResponse(String propertyDeletedSuccessfully, boolean b) {
    }
}
