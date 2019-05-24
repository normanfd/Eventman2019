package com.example.eventman2019.Model;

public class Users {
    private String name, phone, email, password, image, address;

    public Users(String name, String phone, String email, String password, String image, String address) throws Exception {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = Hash.sha512(password);
        this.image = image;
        this.address = address;
    }

    //getter & setter nama user
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //getter & setter nomor telephone user
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    //getter & setter email user
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //getter & setter password user
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws Exception { this.password = Hash.sha512(password); }

    //getter & user gambar profil user
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    //getter & setter alamat user
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}