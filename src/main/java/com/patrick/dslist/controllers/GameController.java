package com.patrick.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patrick.dslist.dto.GameMinDTO;
import com.patrick.dslist.services.GameService;

@RestController //Configurando a classe para ser um controlador
@RequestMapping(value = "/games")//Configurando o caminho
public class GameController {
	
	@Autowired //Injetando uma instância do GameService
	private GameService gameService;
	
	@GetMapping//Mapeando com o verbo HTTP
	public List<GameMinDTO> findAll(){
		List<GameMinDTO> result = gameService.findAll();
		return result;
	}
}
