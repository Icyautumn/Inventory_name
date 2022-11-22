package entities;

public class Report {
	private String id, name;
	private double openStock, closeStock;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	
	public Report(String id, String name, double openStock, double closeStock) {
		super();
		this.id = id;
		this.name = name;
		this.openStock = openStock;
		this.closeStock = closeStock;
	}

}
