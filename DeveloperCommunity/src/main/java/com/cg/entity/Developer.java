package com.cg.entity;

import java.time.LocalDate;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Developer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "devId")
	private int devId;
	@Column(name = "name")

	private String name;
	@Column(name = "email")

	private String email;
	@Column(name = "skillLevel")

	private String skillLevel;
	@Column(name = "membeRSince")

	private String memberSince;

	private int reputation;
	@Column(name = "_totaLFeeds")
	private int totalFeeds;
	@Column(name = "verify")
	private boolean isVerified;
	@Column(name = "block")
	private boolean isBlocked;
	@OneToMany
	private Set<Feed> feeds;
	@OneToOne
	private Users users;

	public Developer(int devId, String name, String email, String skillLevel, String memberSince, int reputation,
			int totalFeeds, boolean isVerified, boolean isBlocked) {
		super();
		this.devId = devId;
		this.name = name;
		this.email = email;
		this.skillLevel = skillLevel;
		this.memberSince = memberSince;
		this.reputation = reputation;
		this.totalFeeds = totalFeeds;
		this.isVerified = isVerified;
		this.isBlocked = isBlocked;
	}

	public Developer() {
		super();
	}

	public int getDevId() {
		return devId;
	}

	public void setDevId(int devId) {
		this.devId = devId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(String skillLevel) {
		this.skillLevel = skillLevel;
	}

	public String getMemberSince() {
		return memberSince;
	}

	public void setMemberSince(String memberSince) {
		this.memberSince = memberSince;
	}

	public int getReputation() {
		return reputation;
	}

	public void setReputation(int reputation) {
		this.reputation = reputation;
	}

	public boolean isVerified() {
		return isVerified;
	}

	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

	public boolean isBlocked() {
		return isBlocked;
	}

	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	public Set<Feed> getFeeds() {
		return feeds;
	}

	public void setFeeds(Set<Feed> feeds) {
		this.feeds = feeds;
	}

	public int getTotalFeeds() {
		return totalFeeds;
	}

	public void setTotalFeeds(int totalFeeds) {
		this.totalFeeds = totalFeeds;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Developer [devId=" + devId + ", name=" + name + ", email=" + email + ", skillLevel=" + skillLevel
				+ ", memberSince=" + memberSince + ", reputation=" + reputation + ", totalFeeds=" + totalFeeds
				+ ", isVerified=" + isVerified + ", isBlocked=" + isBlocked + ", feeds=" + feeds + ", users=" + users
				+ "]";
	}

}