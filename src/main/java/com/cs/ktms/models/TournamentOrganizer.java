package com.cs.ktms.models;
import java.util.ArrayList;

public class TournamentOrganizer extends User {

	private int federationID;
	private ArrayList<Tournament> tournaments;

	public int getFederationID() {
		return this.federationID;
	}

	public void setFederationID(int federationID) {
		this.federationID = federationID;
	}

	public ArrayList<Tournament> getTournaments() {
		return this.tournaments;
	}

	public void addTournament(Tournament tournament) {
		tournaments.add(tournament);
	}

	public void removeTournament(Tournament tournament) {
		tournaments.add(tournament);
	}

	@Override
	public String toString() {
		return "User " + getClass().getSimpleName() + ", Email: " + this.getEmail() +
				", Gender: " + this.getGender() + ", Name: " + this.getFirstname() +
				" " + this.getLastname() + ", Federation ID: " + this.federationID + ".";
	}
}
// Zaki Kurdya