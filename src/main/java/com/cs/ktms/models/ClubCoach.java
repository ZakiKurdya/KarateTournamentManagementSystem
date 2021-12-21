package com.cs.ktms.models;
import java.util.ArrayList;
import java.util.Objects;

public class ClubCoach extends User {
	private int clubID;
	private ArrayList<Team> teams;

	public int getClubID() {
		return this.clubID;
	}

	public void setClubID(int clubID) {
		this.clubID = clubID;
	}

	public ArrayList<Team> getTeams() {
		return this.teams;
	}

	public boolean addPlayer(Player player, String teamID) {
		for (Team team: teams) {
			if (Objects.equals(team.getTeamID(), teamID)){
				team.addPlayer(player);
				return true;
			}
		}
		return false;
	}

	public boolean createTeam() {
		throw new UnsupportedOperationException();
	}

	public boolean removePlayer(int playerID, int teamID) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		return "User " + getClass().getSimpleName() + ", Email: " + this.getEmail() +
				", Gender: " + this.getGender() + ", Name: " + this.getFirstname() +
				" " + this.getLastname() + ", Club ID: " + this.clubID + ".";
	}
}
// Zaki Kurdya