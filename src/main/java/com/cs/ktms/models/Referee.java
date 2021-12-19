package com.cs.ktms.models;

public class Referee extends User {

	private int federationID;

	public int getFederationID() {
		return federationID;
	}

	public void setFederationID(int federationID) {
		this.federationID = federationID;
	}

	@Override
	public String toString() {
		return "User " + getClass().getSimpleName() + ", Email: " + this.getEmail() +
				", Gender: " + this.getGender() + ", Name: " + this.getFirstname() +
				" " + this.getLastname() + ", Federation ID: " + this.federationID + ".";
	}
}
// Zaki Kurdya