package daoo;

import java.util.List;

import metier.entities.College;

public interface ICollegeDao {
	public College save(College Ens);
	public College getCollege(Long id);
	public College updateCollege(College Ens);
	public void deleteCollege(Long id);
	public List<College> getAllCollege();
}
