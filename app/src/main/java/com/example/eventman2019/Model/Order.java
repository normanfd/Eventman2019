package com.example.eventman2019.Model;

public class Order {

    private String name, phone, address, city, state, date, time, totalAmount;

    public Order() {
    }

    public Order(String name, String phone, String address, String city, String state, String date, String time, String totalAmount) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.date = date;
        this.time = time;
        this.totalAmount = totalAmount;
    }

    //get nama customer
    public String getName() {
        return name;
    }

    //set nama customer
    public void setName(String name) {
        this.name = name;
    }

    //get nomor telephone customer
    public String getPhone() {
        return phone;
    }

    //set nomor telephone customer
    public void setPhone(String phone) {
        this.phone = phone;
    }

    //get alamat customer
    public String getAddress() {
        return address;
    }

    //set alamat customer
    public void setAddress(String address) {
        this.address = address;
    }

    //get kota domisili customer
    public String getCity() {
        return city;
    }

    //set kota domisili customer
    public void setCity(String city) {
        this.city = city;
    }

    //get state dari pemesanan
    public String getState() {
        return state;
    }

    //set state dari pemesanan
    public void setState(String state) {
        this.state = state;
    }

    //get tanggal pemesanan dilakukan
    public String getDate() {
        return date;
    }

    //set tanggal pemesanan dilakukan
    public void setDate(String date) {
        this.date = date;
    }

    //get waktu (Jam:Menit:Detik AM/PM) pemesanan dilakukan
    public String getTime() {
        return time;
    }

    //set waktu (Jam:Menit:Detik AM/PM) pemesanan dilakukan
    public void setTime(String time) {
        this.time = time;
    }

    //get total harga seluruh produk yang dipesan
    public String getTotalAmount() {
        return totalAmount;
    }

    //set total harga seluruh produk yang dipesan
    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }
}
