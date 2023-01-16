package models;

import java.util.*;


import entities.Report;


public class ReportsCollection {
	
	private List<Report> reports = new ArrayList<Report>();
	private int Capacity;
	
	public ReportsCollection() {
		
		this.Capacity = 20;
	}
	
	public List<Report> getReports() {
        return reports;
    }
	
	public void addInventory(Report report) {
    	if(reports.size() != Capacity) {
    		reports.add(report);
    	}
    }
	
	public void removeInventory(Report report) {
		if(reports.size() != Capacity) {
			reports.remove(report);
		}
	}

}
