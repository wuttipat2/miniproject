package com.coffeetracker.repository;

import com.coffeetracker.Entity.CoffeeBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeBeanRepository extends JpaRepository<CoffeeBean, Long> {

}
