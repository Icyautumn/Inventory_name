public class InventoryItem {
	private String name;
	private double openStock;
	private double closeStock;
	private double costPrice;
	private double retailPrice;
	private double profit;
	private ReportCategory category;
	
	
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



	public double getCostPrice() {
		return costPrice;
	}



	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}



	public double getRetailPrice() {
		return retailPrice;
	}



	public void setRetailPrice(double retailPrice) {
		this.retailPrice = retailPrice;
	}



	public double getProfit() {
		return profit;
	}



	public void setProfit(double profit) {
		this.profit = profit;
	}



	public ReportCategory getCategory() {
		return category;
	}



	public void setCategory(ReportCategory category) {
		this.category = category;
	}

	
	
	public InventoryItem(String name, double openStock, double closeStock, double costPrice, double retailPrice,
			double profit, ReportCategory category) {
		super();
		this.name = name;
		this.openStock = openStock;
		this.closeStock = closeStock;
		this.costPrice = costPrice;
		this.retailPrice = retailPrice;
		this.profit = profit;
		this.category = category;
	}



	@Override
	public String toString() {
		return "InventoryItem [name=" + name + ", openStock=" + openStock + ", closeStock=" + closeStock
				+ ", costPrice=" + costPrice + ", retailPrice=" + retailPrice + ", profit=" + profit + ", category="
				+ category + "]";
	}
}
