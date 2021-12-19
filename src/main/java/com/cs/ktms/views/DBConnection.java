package com.cs.ktms.views;
import com.cs.ktms.models.Player;
import com.cs.ktms.models.User;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.time.LocalDate;
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
                if (MD5(loginName).equals(temp[0]) && MD5(password).equals(temp[1]))
                    return true;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public static String MD5(String s) throws Exception {
        MessageDigest m=MessageDigest.getInstance("MD5");
        m.update(s.getBytes(),0,s.length());
        return new BigInteger(1,m.digest()).toString(16);
    }

    public void saveUser(User user, String password){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("KTMS.data", true))) {
            bufferedWriter.write(user.getEmail() + "%" + user.getFirstname() + "%" + user.getLastname());
            bufferedWriter.newLine();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("AuthenticationData.md5", true))) {
            bufferedWriter.write(MD5(user.getEmail()) + "&" + MD5(password));
            bufferedWriter.newLine();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void insertPlayer(Player player) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Players.data", true))) {
            bufferedWriter.write(player.getPlayerName() + "%" + player.getPlayerEmail() + "%" + player.getPlayerGender() + "%" + player.getPlayerDOB() + "%" + player.getPlayerHeight() + "%" + player.getPlayerWeight());
            bufferedWriter.newLine();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ArrayList<Player> selectPlayers() {
        ArrayList<Player> players = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("Players.data"))){
            while (true) {
                Player tempPlayer = new Player();
                String[] temp = bufferedReader.readLine().trim().split("%");
                tempPlayer.setPlayerName(temp[0]);
                tempPlayer.setPlayerEmail(temp[1]);
                tempPlayer.setPlayerGender(temp[2].charAt(0));
                tempPlayer.setPlayerDOB(LocalDate.parse(temp[3]));
                tempPlayer.setPlayerHeight(Byte.parseByte(temp[4]));
                tempPlayer.setPlayerWeight(Byte.parseByte(temp[5]));
                players.add(tempPlayer);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return players;
    }
}
// Zaki Kurdya