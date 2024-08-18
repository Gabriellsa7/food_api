package com.example.menu.model;

import com.example.menu.record.FoodRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

//Model Class
@Table(name = "foods")
@Entity(name = "foods")
// #Lombok notations
//Creates All getters
//Discover why this notation doesn't work
@Getter
//Creates a constructor with any arguments
@NoArgsConstructor
//Creates a constructor with all arguments
@AllArgsConstructor
//indicates that the ID is a unique representation in food
@EqualsAndHashCode(of = "id")
public class Food {
    //You can use either UUID or IDENTITY in this case. Since this application is simple, we can use IDENTITY.
    //When we have a complex application we need use UUID to security;
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String title;
    private String image;
    private Integer price;

    //constructor to pick up the data
    public Food(FoodRequestDTO data) {
        this.image = data.image();
        this.price = data.price();
        this.title = data.title();
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public Integer getPrice() {
        return price;
    }
}
