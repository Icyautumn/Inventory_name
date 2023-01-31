import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import entities.InventoryItem;
import entities.Report;
import entities.ReportCategory;
import models.ReportModel;

public class ReportModelTest {
  @Test
  public void testFind() {
    ReportModel reportModel = new ReportModel();
    Report report = reportModel.find();
    Assert.assertEquals("01", report.getId());
    Assert.assertEquals("11011", report.getReportName());
    Assert.assertEquals("11/11/20", report.getReportDate());
    Assert.assertEquals(ReportCategory.FOOD, report.getCategory());
    Assert.assertEquals(1, report.getItems().size());
    Assert.assertEquals("Oreo", report.getItems().get(0).getName());
    Assert.assertEquals("001", report.getCompanyID());
  }

  @Test
  public void testFindAll() {
    ReportModel reportModel = new ReportModel();
    List<Report> reports = reportModel.findAll();
    Assert.assertEquals(3, reports.size());
    Assert.assertEquals("01", reports.get(0).getId());
    Assert.assertEquals("02", reports.get(1).getId());
    Assert.assertEquals("03", reports.get(2).getId());
    Assert.assertEquals(ReportCategory.FOOD, reports.get(0).getCategory());
    Assert.assertEquals(ReportCategory.DRINK, reports.get(1).getCategory());
    Assert.assertEquals(ReportCategory.FOOD, reports.get(2).getCategory());
  }

  @Test
  public void testFindAllAdded() {
    ReportModel reportModel = new ReportModel();
    List<Report> reports = reportModel.findAllAdded();
    Assert.assertEquals(4, reports.size());
    Assert.assertEquals("01", reports.get(0).getId());
    Assert.assertEquals("02", reports.get(1).getId());
    Assert.assertEquals("03", reports.get(2).getId());
    Assert.assertEquals("04", reports.get(3).getId());
    Assert.assertEquals(ReportCategory.FOOD, reports.get(0).getCategory());
    Assert.assertEquals(ReportCategory.DRINK, reports.get(1).getCategory());
    Assert.assertEquals(ReportCategory.FOOD, reports.get(2).getCategory());
    Assert.assertEquals(ReportCategory.FOOD, reports.get(3).getCategory());
  }

}