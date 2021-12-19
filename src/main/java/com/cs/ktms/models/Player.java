package com.cs.ktms.models;
import java.util.Date;

public class Player {

	private int playerID;
	private String playerName;
	private String playerEmail;
	private char playerGender;
	private Date playerDOB;
	private byte playerWeight;
	private byte playerHeight;

	public int getPlayerID() {
		return playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerEmail() {
		return playerEmail;
	}

	public void setPlayerEmail(String playerEmail) {
		this.playerEmail = playerEmail;
	}

	public char getPlayerGender() {
		return playerGender;
	}

	public void setPlayerGender(char playerGender) {
		this.playerGender = playerGender;
	}

	public Date getPlayerDOB() {
		return playerDOB;
	}

	public void setPlayerDOB(Date playerDOB) {
		this.playerDOB = playerDOB;
	}

	public byte getPlayerWeight() {
		return playerWeight;
	}

	public void setPlayerWeight(byte playerWeight) {
		this.playerWeight = playerWeight;
	}

	public byte getPlayerHeight() {
		return playerHeight;
	}

	public void setPlayerHeight(byte playerHeight) {
		this.playerHeight = playerHeight;
	}
}
// Zaki Kurdya