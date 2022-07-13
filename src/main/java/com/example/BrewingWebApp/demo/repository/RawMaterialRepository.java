package com.example.BrewingWebApp.demo.repository;

import com.example.BrewingWebApp.demo.model.RawMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RawMaterialRepository extends JpaRepository<RawMaterial,Long> {
}
