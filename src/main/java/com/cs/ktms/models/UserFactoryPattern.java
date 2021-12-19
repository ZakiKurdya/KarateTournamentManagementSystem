package com.cs.ktms.models;

public class UserFactoryPattern {
	public User getUser(String accountType) {
		if (accountType.equalsIgnoreCase("ClubCoach"))
			return new ClubCoach();
		else if (accountType.equalsIgnoreCase("TournamentOrganizer"))
			return new TournamentOrganizer();
		else if (accountType.equalsIgnoreCase("Referee"))
			return new Referee();
		else return null;
	}
}
// Zaki Kurdya