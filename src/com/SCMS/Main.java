package com.SCMS;
import javax.swing.*;

import com.SCMS.Auth.SessionManager;
import com.SCMS.Pages.Auth;

public class Main{
    public static void main(String[] args) {
        if (SessionManager.isAuthenticated()) {
            String username = SessionManager.getAuthenticatedUser();
            String role = SessionManager.getAuthenticatedUserRole();
             SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new Menu(username, role);
                }
            });
        } else {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new Auth();
                }
            });
        }
    }
}

