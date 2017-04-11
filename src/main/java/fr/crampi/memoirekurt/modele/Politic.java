package fr.crampi.memoirekurt.modele;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by crampi on 08/04/17.
 */
@Entity
@Table(name = "Politic")
public class Politic implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3730126925741832726L;
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	private int id;
	@Column(name = "firstname")
	private String firstName;
	@Column(name = "lastname")
	private String lastName;
	@Column(name = "party")
	private String party;

	public Politic() {
		// TODO Auto-generated constructor stub
	}

	public Politic(String firstName, String lastName, String party) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.party = party;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	@Override
	public String toString() {
		return "Politic{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", party='" + party
				+ '\'' + '}';
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
