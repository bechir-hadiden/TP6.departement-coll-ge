package metier.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "Departement")
public class Departement implements Serializable{
	@Id
	@Column (name="ID_departement")
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long ID_departement;
	@Column (name="NOM_departement")
	private String NOM_departement;
	private int Nb_employee;

     
		
		  private College college ;
		 
	
	public Departement()
	{	super();
	}
	public Departement(String NOM_departement, int Nb_employee , College col) {
	
	this.NOM_departement = NOM_departement;
	this.Nb_employee = Nb_employee;
	this.setCollege(col);
	}
	
	public Long getID_departement() {
		return ID_departement;
	}
	public void setID_departement(Long iD_departement) {
		ID_departement = iD_departement;
	}
	public String getNOM_departement() {
		return NOM_departement;
	}
	public void setNOM_departement(String nOM_departement) {
		NOM_departement = nOM_departement;
	}
	public int getNb_employee() {
		return Nb_employee; 
	}
	public void setNb_employee(int nb_employee) {
		Nb_employee = nb_employee;
	}
	
	public College getCollege() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}
	@Override
	public String toString() {
		return "Departement [ID_departement=" + ID_departement + ", NOM_departement=" + NOM_departement
				+ ", Nb_employee=" + Nb_employee + ", college=" + college + "]";
	}
	
	

	
	
}
	