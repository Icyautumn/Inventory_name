import org.testng.annotations.Test;

import entities.InventoryItem;
import entities.Report;
import entities.ReportCategory;
import models.ReportModel;
import servlets.ReportServlet;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mockito.Mockito;
import org.mockito.Spy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class ReportServletTest {

  private HttpServletRequest request;
  private HttpServletResponse response;
  private HttpSession session;
  private ReportModel reportModel;
  private RequestDispatcher requestDispatcher;
  PrintWriter printWriter;
  ReportServlet servlet = new ReportServlet();

  StringWriter stringWriter = new StringWriter();

  @BeforeMethod
  public void setUp() throws IOException {
    request = mock(HttpServletRequest.class);
    response = mock(HttpServletResponse.class);
    session = mock(HttpSession.class);
    when(request.getSession()).thenReturn(session);
    reportModel = mock(ReportModel.class);
    requestDispatcher = mock(RequestDispatcher.class);
    printWriter = mock(PrintWriter.class);

    Mockito.when(response.getWriter()).thenReturn(new PrintWriter(stringWriter));

  }

  @Test
  public void testDoGet() throws ServletException, IOException {
    servlet.doGet(request, response);
    Assert.assertTrue(stringWriter.toString().contains("Served at: "));
  }

  @Test
  public void testdoPost() throws ServletException, IOException {
    Mockito.when(request.getSession()).thenReturn(session);
    Mockito.when(request.getRequestDispatcher("/reports.jsp")).thenReturn(requestDispatcher);

    List<Report> result = Mockito.spy(new ArrayList<Report>());
    servlet.doPost(request, response);

    result.add(new Report("01", "110011", "11/11/20", ReportCategory.FOOD,
        Arrays.asList(new InventoryItem("Oreo", 1.0, 2.0, 3.0, 4.0, 5.0, ReportCategory.FOOD),
            new InventoryItem("cake", 1.0, 2.0, 3.0, 4.0, 5.0, ReportCategory.FOOD)),
        "001"));
    result.add(new Report("02", "110022", "10/10/20", ReportCategory.DRINK,
        Arrays.asList(new InventoryItem("Oreo", 1.0, 2.0, 3.0, 4.0, 5.0, ReportCategory.DRINK),
            new InventoryItem("cake", 1.0, 2.0, 3.0, 4.0, 5.0, ReportCategory.DRINK)),
        "002"));
    result.add(new Report("03", "110033", "09/09/20", ReportCategory.FOOD,
        Arrays.asList(new InventoryItem("Oreo", 1.0, 2.0, 3.0, 4.0, 5.0, ReportCategory.FOOD),
            new InventoryItem("cake", 1.0, 2.0, 3.0, 4.0, 5.0, ReportCategory.FOOD)),
        "003"));

    Mockito.when(reportModel.findAll()).thenReturn(result);
    Mockito.when(session.getAttribute("reportData")).thenReturn(result);

    Assert.assertEquals(request.getSession(), session);
    Assert.assertEquals(request.getRequestDispatcher("/reports.jsp"), requestDispatcher);
    Assert.assertEquals(reportModel.findAll(), result);

    List<Report> action = reportModel.findAll();

    List<Report> testData = (List<Report>) session.getAttribute("reportData");
    System.out.println(testData);
    session.setAttribute("reportData", action);
    Assert.assertEquals(testData.size(), action.size());

  }

}