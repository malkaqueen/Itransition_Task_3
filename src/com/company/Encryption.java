package com.company;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class Encryption {
    byte[] secretKey;

    public Encryption() {
        Random randomValue = new SecureRandom();
        this.secretKey = new byte[16];
        randomValue.nextBytes(this.secretKey);
    }

    public String getSecretKey() {
        return this.bytesToStr(secretKey).toUpperCase();
    }

    public String bytesToStr(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public String hashMessage(String message) {
        String messageToEncode = message + this.getSecretKey();
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA3-256");
            byte[] result = md.digest(messageToEncode.getBytes());
            return this.bytesToStr(result).toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
