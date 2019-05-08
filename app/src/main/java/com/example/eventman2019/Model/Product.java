package com.example.eventman2019.Model;

public class Product {
    private String category, date, description, image, pid, price, productname, productvendor, time ;

    public Product() {

    }

    public Product(String category, String date, String description, String image, String pid, String price, String productname, String productvendor, String time) {
        this.category = category;
        this.date = date;
        this.description = description;
        this.image = image;
        this.pid = pid;
        this.price = price;
        this.productname = productname;
        this.productvendor = productvendor;
        this.time = time;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductvendor() {
        return productvendor;
    }

    public void setProductvendor(String productvendor) {
        this.productvendor = productvendor;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}