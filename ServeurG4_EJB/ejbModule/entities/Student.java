package entities;

import java.io.Serializable;
import java.lang.String;
import jakarta.persistence.*;

/**
 *
 */


@Entity
public class Student extends User implements Serializable {
	   
	
	private String firstname;
	private String lastname;
	private String telephone;
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="filiere_id")
	private Filiere filiere;
	
	
	
	public Filiere getFiliere() {
		return filiere;
	}


	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}


	public Student() {
		super();
	}


	public Student(String login, String password, String firstname, String lastname, String telephone) {
		super(login, password);
		this.firstname = firstname;
		this.lastname = lastname;
		this.telephone = telephone;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	@Override
	public String toString() {
		return "Student [firstname=" + firstname + ", lastname=" + lastname + ", telephone=" + telephone + ", filiere="
				+ filiere + ", toString()=" + super.toString() + "]";
	}

	
	
	
	
	

	
}
