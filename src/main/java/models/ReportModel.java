package models;

import java.util.*;

import entities.Report;

public class ReportModel {
	
	public Report find() {
		return new Report("01", "Oreo", 2.0, 1.0);
	}
	
	public List<Report> findAll(){
		List<Report> result = new ArrayList<Report>();
		result.add(new Report("01", "Oreo", 2.0, 2.0));
		result.add(new Report("02", "Nuggets", 2.0, 2.0));
		result.add(new Report("03", "Sotong Ballz", 2.0, 1.0));
		return result;
	}

}
