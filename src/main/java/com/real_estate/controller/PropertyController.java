package com.real_estate.controller;

import com.real_estate.dto.ApiResponse;
import com.real_estate.dto.PropertyDto;
import com.real_estate.service.ServiceProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/property")
public class PropertyController {

    @Autowired
    private ServiceProperty serviceProperty;

    // POST-Create Property
    @PostMapping("/")
    public ResponseEntity<PropertyDto> createProperty(@RequestBody PropertyDto propertyDto) {
        PropertyDto createPropertyDto = this.serviceProperty.createProperty(propertyDto);
        return new ResponseEntity<PropertyDto>(createPropertyDto, HttpStatus.CREATED);
    }
    // PUT-update Property

    @PutMapping("/{propertyId}")
    public ResponseEntity<PropertyDto> updateProperty(@RequestBody PropertyDto propertyDto,
                                                      @PathVariable("propertyId") Integer propertyId)
    {
        try {
            PropertyDto updateProperty = this.serviceProperty.updateProperty(propertyDto, propertyId);
            return ResponseEntity.ok(updateProperty);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity <>(HttpStatus.NOT_FOUND);
    }

    // DELETE-delete Property
    @DeleteMapping("/{propertyId}")
    public ResponseEntity<ApiResponse> DeleteProperty(@PathVariable("propertyId") Integer propertyId) {
        try {
         //   this.serviceProperty.deleteProperty(propertyId);
        //    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            this.serviceProperty.deleteProperty(propertyId);
            return new ResponseEntity<ApiResponse>(new ApiResponse("Property Deleted Successfully",true), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    // GET-List OF Property
    @GetMapping("/")
    public ResponseEntity<List<PropertyDto>> getAllProperty() {
        try {
        //  return (ResponseEntity<List<PropertyDto>>) serviceProperty.getAllProperty();
            return ResponseEntity.ok(this.serviceProperty.getAllProperty());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Get- Property By Id

    @GetMapping("/{propertyId}")
    public ResponseEntity<PropertyDto> getSingleProperty(@PathVariable("propertyId") Integer propertyId) {
        try {
            //serviceProperty.getPropertyById(propertyId);
            return ResponseEntity.ok(this.serviceProperty.getPropertyById(propertyId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}