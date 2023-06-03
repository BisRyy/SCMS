package com.SCMS.Auth;

import java.io.*;
public class SessionManager {
    private static final String SESSION_FILE = "session.txt";

    public static boolean isAuthenticated() {
        try (BufferedReader reader = new BufferedReader(new FileReader(SESSION_FILE))) {
            return Boolean.parseBoolean(decrypt(reader.readLine().toCharArray()));
        } catch (IOException e) {
            return false;
        }
    }

    public static String getAuthenticatedUser() {
        try (BufferedReader reader = new BufferedReader(new FileReader(SESSION_FILE))) {
            reader.readLine(); // Skip the first line (authentication state)
            return decrypt(reader.readLine().toCharArray());
        } catch (IOException e) {
            return null;
        }
    }

    public static String getAuthenticatedUserRole() {
        try (BufferedReader reader = new BufferedReader(new FileReader(SESSION_FILE))) {
            reader.readLine(); // Skip the first line (authentication state)
            reader.readLine(); // Skip the second line (username)
            return decrypt(reader.readLine().toCharArray());
        } catch (IOException e) {
            return null;
        }
    }

    public static void saveAuthenticationState(boolean isAuthenticated, String username, String role) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SESSION_FILE))) {
            writer.write(encrypt(String.valueOf(isAuthenticated)));
            writer.newLine();
            writer.write(encrypt(username));
            writer.newLine();
            writer.write(encrypt(role));
                        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static char[] encrypt(String value) {
        // encrypt the value
        char[] encrypted = new char[value.length()];
        for (int i = 0; i < value.length(); i++) {
            encrypted[i] = (char) (value.charAt(i) + 1);
        }
        return encrypted;
    }

    private static String decrypt(char[] value) {
        // decrypt the value
        char[] decrypted = new char[value.length];
        for (int i = 0; i < value.length; i++) {
            decrypted[i] = (char) (value[i] - 1);
        }
        return new String(decrypted);
    }
}