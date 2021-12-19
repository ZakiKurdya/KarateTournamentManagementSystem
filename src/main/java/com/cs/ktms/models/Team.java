package com.cs.ktms.models;
import java.util.ArrayList;

public class Team {

	private ArrayList<Player> players;
	private int teamID;
	private String teamName;
	private byte teamMaxNumber;
	private String teamCategory;

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

	public int getTeamID() {
		return teamID;
	}

	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}
}
// Zaki Kurdya