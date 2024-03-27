package com.real_estate.service.impl;

import com.real_estate.dto.PropertyDto;
import com.real_estate.entities.Property;
import com.real_estate.exception.ResourceNotFoundException;
import com.real_estate.repository.PropertyRepo;
import com.real_estate.service.ServiceProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertySeviceImpl implements ServiceProperty {

    @Autowired
    private PropertyRepo propertyRepo;

    @Override
    public PropertyDto createProperty(PropertyDto propertyDto) {
        Property property1= this.DtoToProperty(propertyDto);
        Property savedproperty=this.propertyRepo.save(property1);
        return this.PropertyToDto(savedproperty);

    }

    @Override
    public PropertyDto updateProperty(PropertyDto propertyDto, Integer propertyId) {
        Property props=this.propertyRepo.findById(propertyId).
                orElseThrow(()->new ResourceNotFoundException("Property","propertyId",propertyId));


        //	props.setId(Id);
        props.setLocation(propertyDto.getLocation());
        props.setPrice(propertyDto.getPrice());
        props.setType(propertyDto.getType());
        props.setTitle(propertyDto.getTitle());
        Property saveupdate = propertyRepo.save(props);
        PropertyDto propertyDto1 = this.PropertyToDto(saveupdate);
        return propertyDto1;
    }

    @Override
    public PropertyDto getPropertyById(Integer propertyId) {
        Property pro=this.propertyRepo.findById(propertyId).
                orElseThrow(()->new ResourceNotFoundException("Property","propertyId",propertyId));
        return this.PropertyToDto(pro);

    }

    @Override
    public List<PropertyDto> getAllProperty() {
        List<Property> properties = this.propertyRepo.findAll();
        List<PropertyDto> proDtos=properties.stream().map(pro-> this.PropertyToDto(pro)).collect(Collectors.toList());

        return proDtos;

    }

    @Override
    public void deleteProperty(Integer propertyId) {
        Property pro=this.propertyRepo.findById(propertyId).
                orElseThrow(()->new ResourceNotFoundException("Property","propertyId",propertyId));
        this.propertyRepo.delete(pro);
    }
    private Property DtoToProperty(PropertyDto propertyDto){
        Property prop=new Property();

        prop.setPropertyId(propertyDto.getPropertyId());
        prop.setLocation(propertyDto.getLocation());
        prop.setPrice(propertyDto.getPrice());
        prop.setType(propertyDto.getType());
        prop.setTitle(propertyDto.getTitle());
        return prop;
    }
    private PropertyDto PropertyToDto(Property property){
        PropertyDto propertyDto=new PropertyDto();
        propertyDto.setPropertyId(property.getPropertyId());
        propertyDto.setLocation(property.getLocation());
        propertyDto.setPrice(property.getPrice());
        propertyDto.setTitle(property.getTitle());
        propertyDto.setType(property.getType());
        return propertyDto;
    }

}

