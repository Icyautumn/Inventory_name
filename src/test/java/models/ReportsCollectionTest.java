package models;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entities.InventoryItem;
import entities.Report;
import entities.ReportCategory;

class ReportsCollectionTest {

	private ReportsCollection rp;
	private Report rp1;
	private Report rp2;
	private Report rp3;
	private final int REPORT_COLLECTION_SIZE = 3;

	@BeforeEach
	void setUp() throws Exception {
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

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetReports() {
		List<Report> testRp = rp.getReports();

		assertEquals(testRp.size(), REPORT_COLLECTION_SIZE);

		assertEquals(rp.getReports().size(), REPORT_COLLECTION_SIZE);
	}

	@Test
	void testAddInventory() {
//		fail("Not yet implemented");
		List<Report> testRp = rp.getReports();
		// assert that report collection is equals to report collection size 3
		assertEquals(testRp.size(), REPORT_COLLECTION_SIZE);
		// ACT
		rp.addInventory(rp1);
		// assert that Song Collection is equals to song collection 3 + 1
		assertEquals(rp.getReports().size(), REPORT_COLLECTION_SIZE + 1);

	}

	@Test
	void testRemoveInventory() {
		List<Report> testRp = rp.getReports();

		assertEquals(testRp.size(), REPORT_COLLECTION_SIZE);

		rp.removeInventory(rp1);

		assertEquals(rp.getReports().size(), REPORT_COLLECTION_SIZE - 1);

	}

}
