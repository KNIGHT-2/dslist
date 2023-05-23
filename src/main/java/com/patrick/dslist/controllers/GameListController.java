package com.patrick.dslist.controllers;

import java.util.List;

import com.patrick.dslist.dto.ReplacementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.patrick.dslist.dto.GameListDTO;
import com.patrick.dslist.dto.GameMinDTO;
import com.patrick.dslist.services.GameListService;
import com.patrick.dslist.services.GameService;

@RestController //Configurando a classe para ser um controlador
@RequestMapping(value = "/lists")//Configurando o caminho
public class GameListController {
	
	@Autowired //Injetando uma instância do GameListService
	private GameListService gameListService;
	
	@Autowired
	private GameService gameService;
	
	@GetMapping//Mapeando com o verbo HTTP
	public List<GameListDTO> findAll(){
		List<GameListDTO> result = gameListService.findAll();
		return result;
	}
	
	@GetMapping(value = "/{listId}/games")//Mapeando com o verbo HTTP
	public List<GameMinDTO> findByList(@PathVariable Long listId){
		List<GameMinDTO> result = gameService.findByList(listId);
		return result;
	}

	@PostMapping(value = "/{listId}/replacement")
	public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body){
		gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
	}
}
