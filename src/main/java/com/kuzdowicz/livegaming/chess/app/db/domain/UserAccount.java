package com.kuzdowicz.livegaming.chess.app.db.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class UserAccount {

	@Id
	private String id;
	private String username;
	private String password;
	private String name;
	private String lastname;
	private int role;
	private String email;
	private String registrationHashString;
	private Boolean isRegistrationConfirmed;
	private Date registrationDate;
	private Long numberOfGamesPlayed;
	private Long numberOfWonChessGames;
	private Long numberOfLostChessGames;

	public UserAccount() {
	}

	public UserAccount(String username, String password, int role, String email) {
		this.username = username;
		this.password = password;
		this.role = role;
		this.email = email;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getEmail() {
		return email;
	}

	public String getRegistrationHashString() {
		return registrationHashString;
	}

	public void setRegistrationHashString(String registrationHashString) {
		this.registrationHashString = registrationHashString;
	}

	public Boolean getIsRegistrationConfirmed() {
		return isRegistrationConfirmed;
	}

	public void setIsRegistrationConfirmed(Boolean isRegistrationConfirmed) {
		this.isRegistrationConfirmed = isRegistrationConfirmed;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Long getNumberOfGamesPlayed() {
		return numberOfGamesPlayed;
	}

	public void setNumberOfGamesPlayed(Long numberOfGamesPlayed) {
		this.numberOfGamesPlayed = numberOfGamesPlayed;
	}

	public Long getNumberOfWonChessGames() {
		return numberOfWonChessGames;
	}

	public void setNumberOfWonChessGames(Long numberOfWonChessGames) {
		this.numberOfWonChessGames = numberOfWonChessGames;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getNumberOfLostChessGames() {
		return numberOfLostChessGames;
	}

	public void setNumberOfLostChessGames(Long numberOfLostChessGames) {
		this.numberOfLostChessGames = numberOfLostChessGames;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
