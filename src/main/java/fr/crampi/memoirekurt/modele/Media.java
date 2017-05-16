package fr.crampi.memoirekurt.modele;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "media")
public class Media implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9029426986415399389L;
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "twitteraccount")
	private String twitterAccount;

	public Media() {
		// TODO Auto-generated constructor stub
	}

	public Media(String name, String twitterAccount) {
		super();
		this.name = name;
		this.twitterAccount = twitterAccount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTwitterAccount() {
		return twitterAccount;
	}

	public void setTwitterAccount(String twitterAccount) {
		this.twitterAccount = twitterAccount;
	}

	@Override
	public String toString() {
		return "Media [id=" + id + ", name=" + name + ", twitterAccount=" + twitterAccount + "]";
	}

}
