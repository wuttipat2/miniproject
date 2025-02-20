package com.coffeetracker.service;

import com.coffeetracker.dto.CoffeeBeanDTO;
import com.coffeetracker.mapper.CoffeeBeanMapper;
import com.coffeetracker.Entity.CoffeeBean;
import com.coffeetracker.repository.CoffeeBeanRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CoffeeBeanService {

    private final CoffeeBeanRepository coffeeBeanRepository;
    private final CoffeeBeanMapper coffeeBeanMapper;

    // ✅ ดึงข้อมูลเมล็ดกาแฟทั้งหมด
    public List<CoffeeBeanDTO> getAllCoffeeBeans() {
        return coffeeBeanRepository.findAll()
                .stream()
                .map(coffeeBeanMapper::toDTO)
                .collect(Collectors.toList());
    }

    // ✅ GET: ดึงข้อมูลเมล็ดกาแฟตาม ID
    public CoffeeBeanDTO getCoffeeBeanById(Long id) {
        CoffeeBean coffeeBean = coffeeBeanRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Coffee Bean not found with id: " + id));
        return coffeeBeanMapper.toDTO(coffeeBean);
    }

    // ✅ เพิ่มเมล็ดกาแฟใหม่
    public CoffeeBeanDTO addCoffeeBean(CoffeeBeanDTO coffeeBeanDTO) {
        CoffeeBean coffeeBean = coffeeBeanMapper.toEntity(coffeeBeanDTO);
        coffeeBean = coffeeBeanRepository.save(coffeeBean);
        return coffeeBeanMapper.toDTO(coffeeBean);
    }

    // ✅ ลบเมล็ดกาแฟ
    public void deleteCoffeeBean(Long id) {
        coffeeBeanRepository.deleteById(id);
    }
}
