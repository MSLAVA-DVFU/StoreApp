package com.example.storeapp;

public class Product {

    public String title;
    public String description;

    public String detailed_description;
    public int price;
    public int imageUrl;

    public Product(String title, String description, String detailed_description, int price, int imageUrl) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.detailed_description=detailed_description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDetailed_description() {
        return detailed_description;
    }

    public int getPrice() {
        return price;
    }

    public int getImageRes() {
        return imageUrl;
    }
}
