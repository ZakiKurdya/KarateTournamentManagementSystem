package com.cs.ktms.models;
import java.io.Serializable;
import java.util.ArrayList;

public class Team implements Serializable {

	private ArrayList<Player> players = new ArrayList<>();
	private String teamID;
	private String teamName;
	private byte teamMaxNumber;
	private String teamCategory;

	public void setPlayers(ArrayList<Player> players) {
		if (players != null)
			this.players.addAll(players);
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void addPlayer(Player player) {
		players.add(player);
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public byte getTeamMaxNumber() {
		return teamMaxNumber;
	}

	public void setTeamMaxNumber(byte teamMaxNumber) {
		this.teamMaxNumber = teamMaxNumber;
	}

	public String getTeamCategory() {
		return teamCategory;
	}

	public void setTeamCategory(String teamCategory) {
		this.teamCategory = teamCategory;
	}

	public String getTeamID() {
		return teamID;
	}

	public void setTeamID(String teamID) {
		this.teamID = teamID;
	}
}
// Zaki Kurdya