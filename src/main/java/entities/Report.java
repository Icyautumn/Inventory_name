package entities;

import java.util.Date;

public class Report {
	private String id, reportName, name, category, reportDate;
	private double openStock, closeStock;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String id) {
		this.id = reportName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getOpenStock() {
		return openStock;
	}

	public void setOpenStock(double openStock) {
		this.openStock = openStock;
	}

	public double getCloseStock() {
		return closeStock;
	}

	public void setCloseStock(double closeStock) {
		this.closeStock = closeStock;
	}

	public Report() {
		super();
	}

	public String getReportDate() {
		return reportDate;
	}
	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Report(String id, String reportName, String reportDate,String category, String name, double openStock, double closeStock) {
		super();
		this.id = id;
		this.reportName = reportName;
		this.reportDate = reportDate;
		this.category = category;
		this.name = name;
		this.openStock = openStock;
		this.closeStock = closeStock;
	}

}
