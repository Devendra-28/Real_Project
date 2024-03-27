package com.real_estate.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {
    String property;
    String propertyId;
    Integer propertyId1;

    public ResourceNotFoundException(String property, String propertyId, Integer propertyId1) {
        super(String.format("%s not found with %s :%s", property,"propertyId",propertyId1));
        this.property = property;
        this.propertyId = propertyId;
        this.propertyId1 = propertyId1;
    }
}
