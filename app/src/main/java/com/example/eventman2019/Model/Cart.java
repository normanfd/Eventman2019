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

    //get id produk
    public String getPid() {
        return pid;
    }

    //set id produk
    public void setPid(String pid) {
        this.pid = pid;
    }

    //get nama produk
    public String getProductName() {
        return productName;
    }

    //set nama produk
    public void setProductName(String productName) {
        this.productName = productName;
    }

    //get harga produk
    public String getPrice() {
        return price;
    }

    //set harga produk
    public void setPrice(String price) {
        this.price = price;
    }

    //get nilai kuantitas suatu produk yang ingin dibeli
    public String getQuantity() {
        return quantity;
    }

    //set kuantitas suatu produk yang ingin dibeli
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    //get nilai tanggal produk dimasukkan ke dalam cart
    public String getDate() {
        return date;
    }

    //set nilai tanggal produk dimasukkan ke dalam cart
    public void setDate(String date) {
        this.date = date;
    }

    //get waktu (Jam:Menit:Detik AM/PM) produk dimasukkan ke dalam cart
    public String getTime() {
        return time;
    }

    //set waktu (Jam:Menit:Detik AM/PM) produk dimasukkan ke dalam cart
    public void setTime(String time) {
        this.time = time;
    }
}
