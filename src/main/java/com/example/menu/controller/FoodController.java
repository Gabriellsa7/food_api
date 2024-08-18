package com.example.menu.controller;

import com.example.menu.model.Food;
import com.example.menu.record.FoodRequestDTO;
import com.example.menu.record.FoodResponseDTO;
import com.example.menu.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
//@RequestMapping("food")
public class FoodController {
    //repository Instance
    @Autowired
    private FoodRepository repository;

    //this method will send data that the client want POST in frontend, I use the @RequestBody
    // to pick up the requisition body;
    //CORS is a security feature implemented by web browsers to prevent web pages from making
    // requests to a different domain than the one that served the web page.
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/food")
    public void saveFood(@RequestBody FoodRequestDTO data) {
        Food foodData = new Food(data);
        repository.save(foodData);
    }

    //method to get all foods
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/food")
    public List<FoodResponseDTO> getAll() {
        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }

    //Create the Delete method and put it in frontend
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("food/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") UUID id) {
        Optional<Food> product0 = repository.findById(id);
        if (product0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product Not Found");
        }
        repository.delete(product0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully");
    }
}
