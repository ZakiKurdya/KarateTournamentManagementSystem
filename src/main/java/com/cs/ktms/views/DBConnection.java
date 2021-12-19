package com.cs.ktms.views;
import com.cs.ktms.models.Player;
import com.cs.ktms.models.User;

import java.io.*;
import java.util.ArrayList;

public class DBConnection {
    private static DBConnection instance;

    private DBConnection() {}

    public static DBConnection getInstance() {
        if (instance == null)
            instance = new DBConnection();
        return instance;
    }

    public boolean verifyUser(String loginName, String password) {
        String[] temp;
        try (BufferedReader authDataRead = new BufferedReader(new FileReader("AuthenticationData.md5"))){
            while (true) {
                temp = authDataRead.readLine().trim().split("&");
                if (loginName.equals(temp[0]) && password.equals(temp[1]))
                    return true;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public void saveUser(User user, String password){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("KTMS.data", true))) {
            bufferedWriter.write(user.getEmail() + "%" + user.getFirstname() + "%" + user.getLastname());
            bufferedWriter.newLine();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("AuthenticationData.md5", true))) {
            bufferedWriter.write(user.getEmail() + "&" + password);
            bufferedWriter.newLine();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public boolean insertPlayer(Player player) {
        throw new UnsupportedOperationException();
    }

    public ArrayList<Player> selectPlayers() {
        throw new UnsupportedOperationException();
    }
}
// Zaki Kurdya