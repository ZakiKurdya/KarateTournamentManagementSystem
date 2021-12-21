package com.cs.ktms.views;
import com.cs.ktms.models.Player;
import com.cs.ktms.models.Team;
import com.cs.ktms.models.User;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
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
        try (BufferedReader authDataRead = new BufferedReader(new FileReader("AppData/AuthenticationData.md5"))){
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

    public String getAccountType(String email){
        String[] temp;
        try (BufferedReader usersData = new BufferedReader(new FileReader("AppData/KTMS.data"))){
            while (true) {
                temp = usersData.readLine().trim().split("%");
                if (temp[0].equals(email))
                    return temp[3];
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return "ClubCoach"; // Default
    }

    public static String MD5(String s) throws Exception {
        MessageDigest m=MessageDigest.getInstance("MD5");
        m.update(s.getBytes(),0,s.length());
        return new BigInteger(1,m.digest()).toString(16);
    }

    public void saveUser(User user, String password, String accountType){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("AppData/KTMS.data", true))) {
            bufferedWriter.write(user.getEmail() + "%" + user.getFirstname() + "%" + user.getLastname() + "%" + accountType);
            bufferedWriter.newLine();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("AppData/AuthenticationData.md5", true))) {
            bufferedWriter.write(MD5(user.getEmail()) + "&" + MD5(password));
            bufferedWriter.newLine();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void insertPlayer(Player player, String value) {
        Team temp = returnTeam(player,value);
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("AppData/Teams/"+value+".data"))) {
            objectOutputStream.writeObject(temp);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Team returnTeam(Player player, String value){
        Team temp = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("AppData/Teams/"+value+".data"))) {
            temp = (Team) objectInputStream.readObject();
            objectInputStream.close();
            temp.addPlayer(player);
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return temp;
    }

    public void insertTeam(Team team) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("AppData/Teams/Team"+team.getTeamID()+".data"))) {
            objectOutputStream.writeObject(team);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ArrayList<Player> selectTeamPlayers(String team) {
        ArrayList<Player> players = new ArrayList<>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("AppData/Teams/"+team+".data"))){
        Team temp = (Team) objectInputStream.readObject();
        players.addAll(temp.getPlayers());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return players;
    }

    public ArrayList<String> showTeams(){
        ArrayList<String> teamsName = new ArrayList<>();
        File[] files = new File("AppData/Teams/").listFiles();
        for (File file : files) {
            if (file.isFile()) {
                teamsName.add(file.getName().split("\\.")[0]);
            }
        }
        return teamsName;
    }
}
// Zaki Kurdya