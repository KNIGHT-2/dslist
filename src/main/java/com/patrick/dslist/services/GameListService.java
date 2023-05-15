package com.patrick.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patrick.dslist.dto.GameListDTO;
import com.patrick.dslist.entities.GameList;
import com.patrick.dslist.repositories.GameListRepository;

@Service
public class GameListService {

	@Autowired //Injetando uma instância do GameListRepository na classe GameListService
	private GameListRepository gameListRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		
		List<GameList> result = gameListRepository.findAll();
		//Convertendo uma lista do tipo "GameList" em "GameListDTO"
		List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList(); 
		
		return dto;
	}
	
}
