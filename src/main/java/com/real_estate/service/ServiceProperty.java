package com.real_estate.service;

import com.real_estate.dto.PropertyDto;

import java.util.List;

public interface ServiceProperty {
    PropertyDto createProperty(PropertyDto property);

    PropertyDto updateProperty(PropertyDto property,Integer propertyId);

    PropertyDto getPropertyById(Integer propertyId );

    List<PropertyDto> getAllProperty();

    void deleteProperty(Integer propertyId );
}
