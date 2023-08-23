package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Restaurant;

public interface RestaurantRepo extends JpaRepository<Restaurant, Integer>{

}
