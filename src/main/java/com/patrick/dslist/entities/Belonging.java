package com.patrick.dslist.entities;

import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_belonging")
public class Belonging {
	
	@EmbeddedId //Explicando que esse id faz parte de um composição
	private BelongingPK id = new BelongingPK();
	
	private Integer prosition;
	
	public Belonging() {}

	public Belonging(Game game, GameList list, Integer prosition) {
		id.setGame(game);
		id.setList(list);
		this.prosition = prosition;
	}

	public BelongingPK getId() {
		return id;
	}

	public void setId(BelongingPK id) {
		this.id = id;
	}

	public Integer getProsition() {
		return prosition;
	}

	public void setProsition(Integer prosition) {
		this.prosition = prosition;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Belonging other = (Belonging) obj;
		return Objects.equals(id, other.id);
	}
	
}
