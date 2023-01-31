import org.testng.annotations.Test;

import entities.Report;
import models.ReportModel;
import models.ReportsCollection;
import servlets.ReportServlet;

import static org.mockito.Mockito.mock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReportServletTesting extends Mockito {
  private HttpServletRequest request;
  private HttpServletResponse response;
  private HttpSession session;
  private ReportServlet reportServlet;
  private ReportModel reportModel;
  private List<Report> reports;
    

  
  @BeforeMethod
  public void setup() {
    request = mock(HttpServletRequest.class);
    response = mock(HttpServletResponse.class);
    session = mock(HttpSession.class);

    reportModel = mock(ReportModel.class);
    reportServlet = mock(ReportServlet.class);

    when(request.getSession()).thenReturn(session);
    when(reportModel.findAll()).thenReturn(reports);
  }
  
  @Test
  public void testDoGet() throws ServletException, IOException {
    reportServlet.doGet(request, response);

    verify(session).setAttribute(anyString(), eq("reportData"));
    
    // Mockito.verify(request).getRequestDispatcher("/reports.jsp");
    verify(request.getRequestDispatcher("/reports.jsp")).forward(request, response);

    Assert.assertEquals(reports, reportModel.findAll());
  }

  @Test
  public void testDoPost() throws ServletException, IOException {
    reportServlet.doPost(request, response);

    verify(session).setAttribute("reportData", reports);
    verify(request).getRequestDispatcher("/reports.jsp");
    verify(request.getRequestDispatcher("/reports.jsp")).forward(request, response);

    Assert.assertEquals(reports, reportModel.findAll());
  }

}
