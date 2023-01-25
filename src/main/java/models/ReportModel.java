package models;

import java.util.*;

import entities.InventoryItem;
import entities.Report;
import entities.ReportCategory;

public class ReportModel {

	public Report find() {
		return new Report("01", "11011", "11/11/20", ReportCategory.FOOD,
				List.of(new InventoryItem("Oreo", 1.0, 2.0, 3.0, 4.0, 5.0, ReportCategory.FOOD)),"001");
	}

	/*
	 * public Report findOne(String id) { return ;
	 * 
	 * }
	 */
	public List<Report> findAll() {
		List<Report> result = new ArrayList<Report>();
		result.add(new Report("01", "110011", "11/11/20", ReportCategory.FOOD,
				List.of(new InventoryItem("Oreo", 1.0, 2.0, 3.0, 4.0, 5.0, ReportCategory.FOOD),
						new InventoryItem("cake", 1.0, 2.0, 3.0, 4.0, 5.0, ReportCategory.FOOD)),"001"));
		result.add(new Report("02", "110022", "10/10/20", ReportCategory.DRINK,
				List.of(new InventoryItem("Oreo", 1.0, 2.0, 3.0, 4.0, 5.0, ReportCategory.DRINK),
						new InventoryItem("cake", 1.0, 2.0, 3.0, 4.0, 5.0, ReportCategory.DRINK)),"002"));
		result.add(new Report("03", "110033", "09/09/20", ReportCategory.FOOD,
				List.of(new InventoryItem("Oreo", 1.0, 2.0, 3.0, 4.0, 5.0, ReportCategory.FOOD),
						new InventoryItem("cake", 1.0, 2.0, 3.0, 4.0, 5.0, ReportCategory.FOOD)),"003"));
		
		return result;
	}
	
	public List<Report> findAllAdded() {
		List<Report> result = new ArrayList<Report>();
		result.add(new Report("01", "110011", "11/11/20", ReportCategory.FOOD,
				List.of(new InventoryItem("Oreo", 1.0, 2.0, 3.0, 4.0, 5.0, ReportCategory.FOOD),
						new InventoryItem("cake", 1.0, 2.0, 3.0, 4.0, 5.0, ReportCategory.FOOD)),"001"));
		result.add(new Report("02", "110022", "10/10/20", ReportCategory.DRINK,
				List.of(new InventoryItem("Oreo", 1.0, 2.0, 3.0, 4.0, 5.0, ReportCategory.DRINK),
						new InventoryItem("cake", 1.0, 2.0, 3.0, 4.0, 5.0, ReportCategory.DRINK)),"002"));
		result.add(new Report("03", "110033", "09/09/20", ReportCategory.FOOD,
				List.of(new InventoryItem("Oreo", 1.0, 2.0, 3.0, 4.0, 5.0, ReportCategory.FOOD),
						new InventoryItem("cake", 1.0, 2.0, 3.0, 4.0, 5.0, ReportCategory.FOOD)),"003"));
		result.add(new Report("04", "110044", "26/01/23", ReportCategory.FOOD,
				List.of(new InventoryItem("Oreo", 1.0, 2.0, 3.0, 4.0, 5.0, ReportCategory.FOOD),
						new InventoryItem("cake", 1.0, 2.0, 3.0, 4.0, 5.0, ReportCategory.FOOD)),"002"));
		
		return result;
	}


}
