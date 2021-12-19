package com.cs.ktms.models;
import java.time.LocalDate;

public class Player {

	private int playerID;
	private String playerName;
	private String playerEmail;
	private char playerGender;
	private LocalDate playerDOB;
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

	public LocalDate getPlayerDOB() {
		return playerDOB;
	}

	public void setPlayerDOB(LocalDate playerDOB) {
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

	@Override
	public String toString() {
		return "--- Player ---\n" +
				"Player Name: " + playerName +
				", Player Email: " + playerEmail + "\n" +
				"PlayerGender: " + playerGender +
				", Player DOB: " + playerDOB + "\n" +
				"Player Weight: " + playerWeight +
				", Player Height: " + playerHeight +
				"\n------------\n\n";
	}
}
// Zaki Kurdya