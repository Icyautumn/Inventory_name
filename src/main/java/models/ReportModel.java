package models;

import java.util.*;

import entities.Report;

public class ReportModel {
	
	public Report find() {
		return new Report("01","110011", "11/11/20", "Food", "Oreo", 2.0, 1.0, 4.0, 10.0);
	}
	
	/*
	 * public Report findOne(String id) { return ;
	 * 
	 * }
	 */
	
	public List<Report> findAll(){
		List<Report> result = new ArrayList<Report>();
		result.add(new Report("01","110011", "11/11/20", "Food", "Oreo", 2.0, 1.0, 4.0, 10.0));
		result.add(new Report("02", "110022", "10/10/20", "Drink", "Milo", 2.0, 2.0, 1.0, 7.0));
		result.add(new Report("03","110033", "09/09/20", "Food", "Sotong Ballz", 2.0, 1.0, 3.0, 15.0));
		return result;
	}

}
