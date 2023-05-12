package com.patrick.dslist.dto;

import org.springframework.beans.BeanUtils;

import com.patrick.dslist.entities.Game;

public class GameDTO {
	
	private Long id;
	private String title;
	private Integer year;
	private String genre;
	private String platforms;
	private Double score;
	private String imgUrl;
	private String shortDescription;
	private String longDescription;
	
	public GameDTO() {}
	//Utilizando o recurso do Spring (É necessário que o DTO tenha Getters e Setters)
	public GameDTO(Game game) {
		BeanUtils.copyProperties(game, this);
	}
	/* Ou fazendo manualmente
	public GameDTO(Game game) {
		id = game.getId();
		title = game.getTitle();
		year = game.getYear();
		genre = game.getGenre();
		platforms = game.getPlatforms();
		score = game.getScore();
		imgUrl = game.getImgUrl();
		shortDescription = game.getShortDescription();
		longDescription = game.getLongDescription();
	}*/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getPlatforms() {
		return platforms;
	}
	public void setPlatforms(String platforms) {
		this.platforms = platforms;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getLongDescription() {
		return longDescription;
	}
	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}
	
}
