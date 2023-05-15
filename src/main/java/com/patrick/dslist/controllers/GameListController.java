package com.patrick.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patrick.dslist.dto.GameListDTO;
import com.patrick.dslist.services.GameListService;

@RestController //Configurando a classe para ser um controlador
@RequestMapping(value = "/lists")//Configurando o caminho
public class GameListController {
	
	@Autowired //Injetando uma instância do GameListService
	private GameListService gameListService;
	
	@GetMapping//Mapeando com o verbo HTTP
	public List<GameListDTO> findAll(){
		List<GameListDTO> result = gameListService.findAll();
		return result;
	}
}
