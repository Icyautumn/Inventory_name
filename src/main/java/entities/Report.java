package entities;

import java.util.Date;
import java.util.List;

import entities.ReportCategory;
import entities.InventoryItem;

public class Report {
	private String id, reportName, reportDate, companyID;
	private List<InventoryItem> items;
	private ReportCategory category;

	public Report(String id, String reportName, String reportDate, ReportCategory category, List<InventoryItem> items, String companyID) {
		super();
		this.id = id;
		this.reportName = reportName;
		this.reportDate = reportDate;
		this.items = items;
		this.category = category;
		this.companyID = companyID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getReportDate() {
		return reportDate;
	}

	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}

	public List<InventoryItem> getItems() {
		return items;
	}

	public void setItems(List<InventoryItem> items) {
		this.items = items;
	}

	public ReportCategory getCategory() {
		return category;
	}

	public void setCategory(ReportCategory category) {
		this.category = category;
	}

	public String getCompanyID() {
		return companyID;
	}

	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}

}
