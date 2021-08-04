package com.everis.dar.discordjokebot.model;

public class Flags {
	private Boolean nsfw;
	private Boolean religious;
	private Boolean political;
	private Boolean racist;
	private Boolean sexist;
	
	
	public Boolean getNsfw() {
		return nsfw;
	}
	public void setNsfw(Boolean nsfw) {
		this.nsfw = nsfw;
	}
	public Boolean getReligious() {
		return religious;
	}
	public void setReligious(Boolean religious) {
		this.religious = religious;
	}
	public Boolean getPolitical() {
		return political;
	}
	public void setPolitical(Boolean political) {
		this.political = political;
	}
	public Boolean getRacist() {
		return racist;
	}
	public void setRacist(Boolean racist) {
		this.racist = racist;
	}
	public Boolean getSexist() {
		return sexist;
	}
	public void setSexist(Boolean sexist) {
		this.sexist = sexist;
	}
}
