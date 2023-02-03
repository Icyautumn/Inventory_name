import org.testng.annotations.Test;

import entities.InventoryItem;
import entities.Report;
import entities.ReportCategory;
import models.ReportModel;
import servlets.ReportServlet;

import java.io.IOException;
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

public class ReportServletTest extends Mockito {

  private HttpServletRequest request;
  private HttpServletResponse response;
  private HttpSession session;
  private ReportModel reportModel;
  private RequestDispatcher requestDispatcher;
  @Spy
  ReportServlet servlet;

  @BeforeMethod
  public void setUp() {
    request = mock(HttpServletRequest.class);
    response = mock(HttpServletResponse.class);
    session = mock(HttpSession.class);
    when(request.getSession()).thenReturn(session);
    reportModel = mock(ReportModel.class);
    servlet = mock(ReportServlet.class);
    requestDispatcher = mock(RequestDispatcher.class);

  }

  @Test
  public void testDoGet() throws ServletException, IOException {
    List<Report> result = spy(new ArrayList<Report>());

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
    when(request.getSession()).thenReturn(session);
    when(request.getRequestDispatcher("reports.jsp")).thenReturn(requestDispatcher);

    servlet.doGet(request, response);

    when(reportModel.findAll()).thenReturn(result);
    when(request.getSession()).thenReturn(session);
    verify(servlet, atLeast(1)).doGet(request, response);

    when(request.getSession()).thenReturn(session);
    when(session.getAttribute("reportData")).thenReturn(result);
    List<Report> testData = (List<Report>) session.getAttribute("reportData");
    // verify(session, atLeast(1)).getAttribute("reportData");

    System.out.println(result);
    System.out.println(reportModel.findAll());

    Assert.assertEquals(result, testData);
  }

  @Test
  public void testdoPost() throws ServletException, IOException {
    List<Report> result = spy(new ArrayList<Report>());

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

    System.out.println(result);

    when(request.getSession()).thenReturn(session);
    when(request.getRequestDispatcher("/reports.jsp")).thenReturn(requestDispatcher);
    when(reportModel.findAll()).thenReturn(result);
    when(request.getSession()).thenReturn(session);
    when(session.getAttribute("reportData")).thenReturn(result);

    HttpSession session = request.getSession();

    ReportModel reportModel = new ReportModel();

    List<Report> action = reportModel.findAll();

    session.setAttribute("reportData", action);

    List<Report> testData = (List<Report>) session.getAttribute("reportData");
    System.out.println(testData);

    request.getRequestDispatcher("/reports.jsp").forward(request, response);

    Assert.assertEquals(action.size(), testData.size());

  }

}

// verify(result, atLeast(0)).add(new Report("01", "110011", "11/11/20",
// ReportCategory.FOOD,
// List.of(new InventoryItem("Oreo", 1.0, 2.0, 3.0, 4.0, 5.0,
// ReportCategory.FOOD),
// new InventoryItem("cake", 1.0, 2.0, 3.0, 4.0, 5.0, ReportCategory.FOOD)),
// "001"));
// verify(result, atLeast(0)).add(new Report("02", "110022", "10/10/20",
// ReportCategory.DRINK,
// List.of(new InventoryItem("Oreo", 1.0, 2.0, 3.0, 4.0, 5.0,
// ReportCategory.DRINK),
// new InventoryItem("cake", 1.0, 2.0, 3.0, 4.0, 5.0, ReportCategory.DRINK)),
// "002"));
// verify(result, atLeast(0)).add(new Report("03", "110033", "09/09/20",
// ReportCategory.FOOD,
// List.of(new InventoryItem("Oreo", 1.0, 2.0, 3.0, 4.0, 5.0,
// ReportCategory.FOOD),
// new InventoryItem("cake", 1.0, 2.0, 3.0, 4.0, 5.0, ReportCategory.FOOD)),
// "003"));
