package com.example.eventman2019.Model;

public class Cart {
    private String pid, productName, price, quantity, date, time, category;

    public Cart() {
    }

    public Cart(String pid, String productName, String price, String quantity, String date, String time, String category) {
        this.pid = pid;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.date = date;
        this.time = time;
        this.category = category;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
