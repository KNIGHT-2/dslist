package com.patrick.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patrick.dslist.dto.GameMinDTO;
import com.patrick.dslist.entities.Game;
import com.patrick.dslist.repositories.GameRepository;

@Service
public class GameService {

	@Autowired //Injetando uma instância do GameRepository na classe GameService
	private GameRepository gameRepository;
	
	public List<GameMinDTO> findAll(){
		
		List<Game> result = gameRepository.findAll();
		//Convertendo uma lista do tipo "Game" em "GameMinDTO"
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList(); 
		
		return dto;
	}
	
}
