package com.cs.ktms.DataStorage;
import com.cs.ktms.models.User;

import java.io.*;
import java.util.Scanner;

public class DBConnection {
    public boolean verifyUser(String loginName, String password) {
        String[] temp;
        try (BufferedReader authDataRead = new BufferedReader(new FileReader("AuthenticationData.md5"))){
            while (true) {
                temp = authDataRead.readLine().trim().split("&");
                System.out.println(temp[0]);
                if (loginName.equals(temp[0]) && password.equals(temp[1]))
                    return true;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public void saveUser(User user, String password){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("KTMS.data", true))) {
            bw.write(user.getEmail() + "%" + user.getFirstname() + "%" + user.getLastname());
            bw.newLine();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("AuthenticationData.md5", true))) {
            bw.write(user.getEmail() + "&yk" + password);
            bw.newLine();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
// Zaki Kurdya