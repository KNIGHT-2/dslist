package com.patrick.dslist.services;

import java.util.List;

import com.patrick.dslist.projections.GameMinProjection;
import com.patrick.dslist.repositories.GameRepository;
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

	@Autowired
	private GameRepository gameRepository;

	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		
		List<GameList> result = gameListRepository.findAll();
		//Convertendo uma lista do tipo "GameList" em "GameListDTO"
		List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList(); 
		
		return dto;
	}

	@Transactional(readOnly = true)
	public void move(Long listId, int sourceIndex, int destinationIndex){
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);

		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

		for(int i = min; i <= max; i++){
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}
}
