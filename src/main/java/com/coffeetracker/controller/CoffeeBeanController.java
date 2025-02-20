package com.coffeetracker.controller;

import com.coffeetracker.dto.CoffeeBeanDTO;
import com.coffeetracker.service.CoffeeBeanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coffee-beans")
@RequiredArgsConstructor
public class CoffeeBeanController {

    private final CoffeeBeanService coffeeBeanService;

    // ✅ GET: ดึงข้อมูลเมล็ดกาแฟทั้งหมด
    @GetMapping
    public ResponseEntity<List<CoffeeBeanDTO>> getAllCoffeeBeans() {
        return ResponseEntity.ok(coffeeBeanService.getAllCoffeeBeans());
    }

    // ✅ GET: ดึงข้อมูลเมล็ดกาแฟตาม ID
    @GetMapping("/{id}")
    public ResponseEntity<CoffeeBeanDTO> getCoffeeBeanById(@PathVariable Long id) {
        return ResponseEntity.ok(coffeeBeanService.getCoffeeBeanById(id));
    }

    // ✅ POST: เพิ่มเมล็ดกาแฟใหม่
    @PostMapping
    public ResponseEntity<CoffeeBeanDTO> addCoffeeBean(@RequestBody CoffeeBeanDTO coffeeBeanDTO) {
        return ResponseEntity.ok(coffeeBeanService.addCoffeeBean(coffeeBeanDTO));
    }

    // ✅ DELETE: ลบเมล็ดกาแฟ
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoffeeBean(@PathVariable Long id) {
        coffeeBeanService.deleteCoffeeBean(id);
        return ResponseEntity.noContent().build();
    }
}
