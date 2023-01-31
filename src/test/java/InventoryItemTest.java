import org.testng.Assert;
import org.testng.annotations.Test;

import entities.InventoryItem;
import entities.ReportCategory;

public class InventoryItemTest {
  
    @Test
    public void testGettersAndSetters() {
        InventoryItem item = new InventoryItem("item1", 10, 20, 5, 10, 5, ReportCategory.FOOD);
        Assert.assertEquals("item1", item.getName());
        Assert.assertEquals(10, item.getOpenStock(), 0.1);
        Assert.assertEquals(20, item.getCloseStock(), 0.1);
        Assert.assertEquals(5, item.getCostPrice(), 0.1);
        Assert.assertEquals(10, item.getRetailPrice(), 0.1);
        Assert.assertEquals(5, item.getProfit(), 0.1);
        Assert.assertEquals(ReportCategory.FOOD, item.getCategory());
    }
}