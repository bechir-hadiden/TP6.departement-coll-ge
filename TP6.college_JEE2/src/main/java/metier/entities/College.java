package metier.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class College implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcol;
    private String nomcol;

    @Temporal(TemporalType.DATE)
    private Date dateAffection;
    
    @OneToMany(mappedBy = "college")


    private List<Departement> departements;

    public College() {
        // Default constructor required by JPA
    }

    public College(String nomcol, Date dateAffection) {
        this.nomcol = nomcol;
        this.dateAffection = dateAffection;
    }

    // Getters and setters
    public Long getIdcol() {
        return idcol;
    }

    public void setIdcol(Long idcol) {
        this.idcol = idcol;
    }

    public String getNomcol() {
        return nomcol;
    }

    public void setNomcol(String nomcol) {
        this.nomcol = nomcol;
    }

    public Date getDateAffection() {
        return dateAffection; 
    }

    public void setDateAffection(Date dateAffection) {
        this.dateAffection = dateAffection;
    }

    public List<Departement> getDepartements() {
        return departements;
    }

    public void setDepartements(List<Departement> departements) {
        this.departements = departements;
    }

	@Override
	public String toString() {
		return "college [idcol=" + idcol + ", nomcol=" + nomcol + ", dateAffection=" + dateAffection + ", departements="
				+ departements + "]";
	}

	
    
}
