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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws Exception { this.password = Hash.sha512(password); }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}