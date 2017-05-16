package fr.crampi.memoirekurt.modele;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created on 08/04/17.
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

    @OneToMany(mappedBy = "politic")
    private Set<Conviction> convictions;


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

    public Set<Conviction> getConvictions() {
        return convictions;
    }

    public void setConvictions(Set<Conviction> convictions) {
        this.convictions = convictions;
    }
}
