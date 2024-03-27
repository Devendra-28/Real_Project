package com.real_estate.repository;

import com.real_estate.entities.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepo extends JpaRepository<Property, Integer> {

}
