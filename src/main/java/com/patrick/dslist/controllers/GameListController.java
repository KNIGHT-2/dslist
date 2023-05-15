package com.patrick.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
}
