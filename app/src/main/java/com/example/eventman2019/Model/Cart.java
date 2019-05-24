package com.example.eventman2019.Model;

public class Cart {
    private String pid, productName, price, quantity, date, time, category;

    public Cart(String pid, String productName, String price, String quantity, String date, String time, String category) {
        this.pid = pid;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.date = date;
        this.time = time;
        this.category = category;
    }

    //get pid (id pemesanan suatu produk)
    public String getPid() {
        return pid;
    }

    //set pid (id pemesanan suatu produk)
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

    //get nilai tanggal pemesanan suatu produk dilkaukan
    public String getDate() {
        return date;
    }

    //set nilai tanggal pemesanan suatu produk dilakukan
    public void setDate(String date) {
        this.date = date;
    }

    //get waktu (Jam:Menit:Detik AM/PM) pemesanan suatu produk dilakukan
    public String getTime() {
        return time;
    }

    //set waktu (Jam:Menit:Detik AM/PM) pemesanan suatu produk dilakukan
    public void setTime(String time) {
        this.time = time;
    }
}
