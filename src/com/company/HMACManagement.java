package com.company;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class HMACManagement {
    public static String createSecretKey(){
        Random randomValue = new SecureRandom();
        byte[] secretKey = new byte[16];
        randomValue.nextBytes(secretKey);
        return bytesToStr(secretKey).toUpperCase();
    }

    public static String bytesToStr(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static String hashMessage(String message, String secretKey) {
        String messageToEncode = message + secretKey;
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA3-256");
            byte[] result = md.digest(messageToEncode.getBytes());
            return bytesToStr(result).toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
