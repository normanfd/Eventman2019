package com.example.eventman2019.Model;
import java.security.MessageDigest;

public class Hash {
    //method yang memberikan return value berupa hash dari string input
    public static String sha512(String s) throws Exception {
        s = addSalt(s);
        //hash string menggunakan SHA-512
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        byte[] digest = md.digest(s.getBytes());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digest.length; i++) {
            sb.append(Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    //method yang memberikan return value berupa string prefix salt + input string + postfix salt
    public static String addSalt(String s) throws Exception {
        return "t3TeVV" + s + "6A123M";
    }
}
