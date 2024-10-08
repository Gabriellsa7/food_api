package com.example.menu.record;

import com.example.menu.model.Food;

import java.util.UUID;

public record FoodResponseDTO(UUID id, String title, String image, Integer price) {
    public FoodResponseDTO(Food food) {
        this(food.getId(), food.getTitle(), food.getImage(), food.getPrice());
    }
}
