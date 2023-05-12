package com.patrick.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patrick.dslist.dto.GameDTO;
import com.patrick.dslist.dto.GameMinDTO;
import com.patrick.dslist.services.GameService;

@RestController //Configurando a classe para ser um controlador
@RequestMapping(value = "/games")//Configurando o caminho
public class GameController {
	
	@Autowired //Injetando uma instância do GameService
	private GameService gameService;
	
	@GetMapping(value = "/{id}") //Configurando que ele esperará um id no caminho
	public GameDTO findById(@PathVariable Long id) {//@PathVariable para configurar que será a mesma variável
		GameDTO result = gameService.findById(id);	//informada no caminho
		return result;
	}
	
	@GetMapping//Mapeando com o verbo HTTP
	public List<GameMinDTO> findAll(){
		List<GameMinDTO> result = gameService.findAll();
		return result;
	}
}
