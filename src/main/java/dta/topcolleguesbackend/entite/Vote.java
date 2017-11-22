package dta.topcolleguesbackend.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Vote {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column
	private boolean aimer;
	
	@ManyToOne
	@JoinColumn(name="ID_Collegue")
	private Collegue collegue;

	public Vote() {
	}
	
	public Vote(boolean aimer, Collegue collegue){
		this.aimer=aimer;
		this.collegue=collegue;
	}

	/**Getter for id
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**Getter for aimer
	 * @return aimer
	 */
	public boolean isAimer() {
		return aimer;
	}

	/**
	 * @param avis the aimer to set
	 */
	public void setAimer(boolean aimer) {
		this.aimer = aimer;
	}

	/**Getter for collegue
	 * @return collegue
	 */
	public Collegue getCollegue() {
		return collegue;
	}

	/**
	 * @param collegue the collegue to set
	 */
	public void setCollegue(Collegue collegue) {
		this.collegue = collegue;
	}
	
}
