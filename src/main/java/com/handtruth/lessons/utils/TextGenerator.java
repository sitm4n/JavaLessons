package com.handtruth.lessons.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TextGenerator {

    private static String alphaSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            + "0123456789"
            + "abcdefghijklmnopqrstuvxyz";

    private static String numericSet = "0123456789";


    private static String getString(int n, String set) {
        // create StringBuilder size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int) (set.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(set
                    .charAt(index));
        }

        return sb.toString();
    }


    private static String generateNick() {
        Random random = new Random();
        return getString(random.nextInt(10) + 1, alphaSet + numericSet + "_");
    }

    private static String generateServiceDomen() {
        Random random = new Random();
        return getString(random.nextInt(20) + 1, alphaSet + numericSet);
    }

    private static String generateRandomString() {
        Random random = new Random();
        return getString(random.nextInt(20) + 1, alphaSet + numericSet + "_");
    }


    private static String generateMail() {
        return generateNick() +
                '@' +
                generateServiceDomen() +
                '.' +
                generateServiceDomen();
    }

    @SuppressWarnings("unused")
    public List<String> generateTestMailFile(String filename) throws IOException {
        File file = new File(filename);
        return generateTestMailFile(file);
    }

    public List<String> generateTestMailFile(File file) throws IOException {
        Random random = new Random();
        List<String> result = new ArrayList<>();
        int lineNum = random.nextInt(200);

        try (BufferedWriter bf = new BufferedWriter(new FileWriter(file))) {
            for (int l = 0; l < lineNum; l++) {
                int size = random.nextInt(20) + 1;
                StringBuilder sb = new StringBuilder();
                sb.append(generateRandomString());
                for (int i = 0; i < size; i++) {
                    sb.append(' ');
                    if (random.nextInt(100) == 0) {
                        String mail = generateMail();
                        result.add(mail);
                        sb.append(mail);
                    } else {
                        sb.append(generateRandomString());
                    }
                }
                bf.write(sb.toString());
                bf.newLine();
            }
        }
        return result;

    }
}