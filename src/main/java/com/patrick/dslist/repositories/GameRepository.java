package com.patrick.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patrick.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
