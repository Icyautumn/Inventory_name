package models;

import java.util.Arrays;

// import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;

import entities.InventoryItem;
import entities.Report;
import entities.ReportCategory;

class ReportsCollectionTest {

	private ReportsCollection rp;
	private Report rp1;
	private Report rp2;
	private Report rp3;
	private final int REPORT_COLLECTION_SIZE = 3;

	@BeforeMethod
	void setUp() throws Exception {
		System.out.println("Starting ReportsCollectionTest\nBefore each test method");
		// Arrange
		rp = new ReportsCollection();
		rp1 = new Report("01", "110011", "11/11/20", ReportCategory.FOOD,
				List.of(new InventoryItem("Oreo", 1.0, 2.0, 3.0, 4.0, 5.0, ReportCategory.FOOD),
						new InventoryItem("cake", 1.0, 2.0, 3.0, 4.0, 5.0, ReportCategory.FOOD)),
				"001");
		rp2 = new Report("02", "110022", "10/10/20", ReportCategory.DRINK,
				List.of(new InventoryItem("Oreo", 1.0, 2.0, 3.0, 4.0, 5.0, ReportCategory.DRINK),
						new InventoryItem("cake", 1.0, 2.0, 3.0, 4.0, 5.0, ReportCategory.DRINK)),
				"001");
		rp3 = new Report("03", "110033", "09/09/20", ReportCategory.FOOD,
				List.of(new InventoryItem("Oreo", 1.0, 2.0, 3.0, 4.0, 5.0, ReportCategory.FOOD),
						new InventoryItem("cake", 1.0, 2.0, 3.0, 4.0, 5.0, ReportCategory.FOOD)),
				"001");

		rp.addInventory(rp1);
		rp.addInventory(rp2);
		rp.addInventory(rp3);

	}

	@Test
	void testGetReports() {
		List<Report> testRp = rp.getReports();

		Assert.assertEquals(testRp.size(), REPORT_COLLECTION_SIZE);

		Assert.assertEquals(rp.getReports().size(), REPORT_COLLECTION_SIZE);
	}

	@Test
	void testAddInventory() {
		// fail("Not yet implemented");
		List<Report> testRp = rp.getReports();
		// assert that report collection is equals to report collection size 3
		Assert.assertEquals(testRp.size(), REPORT_COLLECTION_SIZE);
		// ACT
		rp.addInventory(rp1);
		// assert that Song Collection is equals to song collection 3 + 1
		Assert.assertEquals(rp.getReports().size(), REPORT_COLLECTION_SIZE + 1);

	}

	@Test
	void testRemoveInventory() {
		List<Report> testRp = rp.getReports();

		Assert.assertEquals(testRp.size(), REPORT_COLLECTION_SIZE);

		rp.removeInventory(rp1);

		Assert.assertEquals(rp.getReports().size(), REPORT_COLLECTION_SIZE - 1);

	}

	@Test
	void removeReportSuccessfully() {
		List<Report> testRp = rp.getReports();
		int initialSize = testRp.size();

		rp.removeInventory(rp1);

		Assert.assertEquals(testRp.size(), initialSize - 1);
		Assert.assertFalse(testRp.contains(rp1));
	}

	@Test
	void removeReportFailed() {
		List<Report> testRp = rp.getReports();
		int initialSize = testRp.size();
		testRp.clear();
		testRp.addAll(List.of(rp1, rp2, rp3));

		rp.removeInventory(rp2);

		Assert.assertEquals(testRp.size(), initialSize - 1);
		Assert.assertTrue(!testRp.contains(rp2));
	}

	@Test
	public void testReportProperties() {
		List<InventoryItem> items = Arrays.asList(
				new InventoryItem(null, REPORT_COLLECTION_SIZE, REPORT_COLLECTION_SIZE, REPORT_COLLECTION_SIZE,
						REPORT_COLLECTION_SIZE, REPORT_COLLECTION_SIZE, null),
				new InventoryItem(null, REPORT_COLLECTION_SIZE, REPORT_COLLECTION_SIZE, REPORT_COLLECTION_SIZE,
						REPORT_COLLECTION_SIZE, REPORT_COLLECTION_SIZE, null));
		Report report = new Report("1", "Report Name", "2022-01-01", ReportCategory.FOOD, items, "Company ID");

		Assert.assertEquals(report.getId(), "1");
		Assert.assertEquals(report.getReportName(), "Report Name");
		Assert.assertEquals(report.getReportDate(), "2022-01-01");
		Assert.assertEquals(report.getItems(), items);
		Assert.assertEquals(report.getCategory(), ReportCategory.FOOD);
		Assert.assertEquals(report.getCompanyID(), "Company ID");
	}

	@Test
	public void testReportSetters() {
		Report report = new Report("1", "Report Name", "2022-01-01", ReportCategory.FOOD, null, "Company ID");

		report.setId("2");
		report.setReportName("Updated Report Name");
		report.setReportDate("2022-01-02");
		report.setItems(Arrays.asList(new InventoryItem(null, REPORT_COLLECTION_SIZE, REPORT_COLLECTION_SIZE,
				REPORT_COLLECTION_SIZE, REPORT_COLLECTION_SIZE, REPORT_COLLECTION_SIZE, null)));
		report.setCategory(ReportCategory.FOOD);
		report.setCompanyID("Updated Company ID");

		Assert.assertEquals(report.getId(), "2");
		Assert.assertEquals(report.getReportName(), "Updated Report Name");
		Assert.assertEquals(report.getReportDate(), "2022-01-02");
		Assert.assertEquals(report.getItems().size(), 1);
		Assert.assertEquals(report.getCategory(), ReportCategory.FOOD);
		Assert.assertEquals(report.getCompanyID(), "Updated Company ID");
	}

	@Test
	public void testSetName() {
		InventoryItem item = new InventoryItem("item1", 1, 2, 10, 20, 10, ReportCategory.FOOD);
		item.setName("item2");
		Assert.assertEquals(item.getName(), "item2");
	}

	@Test
	public void testSetOpenStock() {
		InventoryItem item = new InventoryItem("item1", 1, 2, 10, 20, 10, ReportCategory.FOOD);
		item.setOpenStock(2);
		Assert.assertEquals(item.getOpenStock(), 2);
	}

	@Test
	public void testSetCloseStock() {
		InventoryItem item = new InventoryItem("item1", 1, 2, 10, 20, 10, ReportCategory.FOOD);
		item.setCloseStock(3);
		Assert.assertEquals(item.getCloseStock(), 3);
	}

	@Test
	public void testSetCostPrice() {
		InventoryItem item = new InventoryItem("item1", 1, 2, 10, 20, 10, ReportCategory.FOOD);
		item.setCostPrice(5);
		Assert.assertEquals(item.getCostPrice(), 5);
	}

	@Test
	public void testSetRetailPrice() {
		InventoryItem item = new InventoryItem("item1", 1, 2, 10, 20, 10, ReportCategory.FOOD);
		item.setRetailPrice(15);
		Assert.assertEquals(item.getRetailPrice(), 15);
	}

	@Test
	public void testSetProfit() {
		InventoryItem item = new InventoryItem("item1", 1, 2, 10, 20, 10, ReportCategory.FOOD);
		item.setProfit(5);
		Assert.assertEquals(item.getProfit(), 5);
	}

	@Test
	public void testSetCategory() {
		InventoryItem item = new InventoryItem("item1", 1, 2, 10, 20, 10, ReportCategory.DRINK);
		item.setCategory(ReportCategory.FOOD);
		Assert.assertEquals(item.getCategory(), ReportCategory.FOOD);
	}

	@Test
	public void testToString() {
		InventoryItem item = new InventoryItem("item1", 10, 20, 5, 15, 10, ReportCategory.FOOD);
		String expected = "InventoryItem [name=item1, openStock=10.0, closeStock=20.0, costPrice=5.0, retailPrice=15.0, profit=10.0, category=FOOD]";
		Assert.assertEquals(item.toString(), expected);
	}
}