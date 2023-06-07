package com.SCMS;
import javax.swing.*;

import com.SCMS.Auth.SessionManager;
import com.SCMS.Pages.Auth;

public class Main{
    public static void main(String[] args) {
        if (SessionManager.isAuthenticated()) {
            String username = SessionManager.getAuthenticatedUser();
            String role = SessionManager.getAuthenticatedUserRole();
            String cId = SessionManager.getAuthenticatedUserCompanyId();
             SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new Menu(username, role, cId);
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

