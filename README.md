# Food API

## Description

This project is a Food API developed with Java 21 and Spring Boot 3. The API allows users to add, list, and delete food items, each with an associated image, price, and name. This is a practical tool for managing a menu or catalog of food items in a web or mobile application.

## Features

- **Add Food Items:** Create new food items with a name, price, and image.
- **List Food Items:** View all food items currently available in the system.
- **Delete Food Items:** Remove food items from the system as needed.

## Technologies Used

- **Java 21**
- **Spring Boot 3**
- **Spring Data JPA**
- **MySQL**
- **Maven**

## Endpoints

### Add Food Item

`POST /foods`

### List Food Items

`GET food`

### Delete Food Item

`DELETE food/{id}`

#### Request Body

```json
{
  "name": "Food Name",
  "price": 12.99,
  "imageUrl": "http://example.com/image.jpg"
}
