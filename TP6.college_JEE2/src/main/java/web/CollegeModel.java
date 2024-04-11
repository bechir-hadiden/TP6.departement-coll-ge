package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.College;

public class CollegeModel {

     List<College> colleges  = new ArrayList<>(); 
    public List<College> getColleges() {
        return this.colleges ;
    }

        
    public void setColleges(List<College> college) { 
        this.colleges  = college;
    }


	public CollegeModel() {
		super();
	}
}
