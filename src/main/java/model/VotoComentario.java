package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import model.types.VotosComentariosKey;

@SuppressWarnings("serial")
@Entity
@IdClass(VotosComentariosKey.class)
@Table(name="TVotoComentario")
public class VotoComentario implements Serializable{
	@Id @ManyToOne private Comentario comentario;
	@Id @ManyToOne private Citizen citizen;
	private boolean isAFavor;

	public VotoComentario(Comentario comentario, Citizen citizen, boolean isAFavor) {
		super();
		this.isAFavor = isAFavor;
		Association.VotarComentario.link(comentario,this,citizen);
	}
	public VotoComentario() {}
	
	public Comentario getComentario() {
		return comentario;
	}
    void _setComentario(Comentario comentario) {
		this.comentario = comentario;
	}
	public Citizen getCitizen() {
		return citizen;
	}
	void _setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}
	public boolean isAFavor() {
		return isAFavor;
	}
	public void setAFavor(boolean isAFavor) {
		this.isAFavor = isAFavor;
	}
	
	
	
}
