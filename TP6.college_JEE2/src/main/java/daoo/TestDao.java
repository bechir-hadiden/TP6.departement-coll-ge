package daoo;


import java.util.List;
import metier.entities.Departement;
public class TestDao {
public static void main(String[] args) {
	DepartementDaolmpl pdao= new DepartementDaolmpl();
Departement Depa= pdao.save(new Departement("departement informatique ", 3, null));
System.out.println(Depa);
List<Departement> Depar =pdao.DepartementParMC("departement");
for (Departement d : Depar)
System.out.println(d);
}
}