import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import servlets.loginServlet;

public class LoginServletTest {
    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpServletResponse response = mock(HttpServletResponse.class);
    HttpSession session = mock(HttpSession.class);
    PrintWriter printWriter;
    StringWriter stringWriter = new StringWriter();
    RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
    loginServlet servlet = new loginServlet();

    @BeforeMethod
    public void setUp() throws IOException {
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);
        printWriter = mock(PrintWriter.class);
        requestDispatcher = mock(RequestDispatcher.class);
        Mockito.when(response.getWriter()).thenReturn(new PrintWriter(stringWriter));

    }


    @Test
    public void testDecodeFromBase64(){
        when(request.getParameter("password")).thenReturn("cGFzc3dvcmQ=");
        String result = servlets.loginServlet.decodeFromBase64(request.getParameter("password"));
        Assert.assertEquals(result, "password");

    }

    @Test
    public void testEncodeToBase64(){
        when(request.getParameter("password")).thenReturn("password");
        String result = servlets.loginServlet.encodeToBase64(request.getParameter("password"));

        Assert.assertEquals(result, "cGFzc3dvcmQ=");
    }

    @Test
    public void testDoGet() throws ServletException, IOException {
        servlet.doGet(request, response);
        Assert.assertTrue(stringWriter.toString().contains("Served at: "));
    }

    @Test
    public void testDoPost() throws ServletException, IOException {
        when(request.getParameter("username")).thenReturn("admin");
        when(request.getParameter("password")).thenReturn("password");

        Mockito.when(request.getParameter("username")).thenReturn("username");
        Mockito.when(request.getParameter("password")).thenReturn("password");
        Mockito.when(request.getSession()).thenReturn(session);
        Mockito.when(request.getRequestDispatcher("/ReportServlet.jsp")).thenReturn(requestDispatcher);
        Mockito.when(request.getRequestDispatcher("/login.jsp")).thenReturn(requestDispatcher);
        
        

        loginServlet servlet = new loginServlet();
        try (PrintWriter out = response.getWriter()) {
            servlet.doPost(request, response);
            String email = request.getParameter("username");
            String password = request.getParameter("password");

            session = request.getSession();

            if (email.equals("inventory") && password.equals("password")) {
                session.setAttribute("getAlert", null);
				session.setAttribute("companyID", "002");
                
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                System.setOut(new PrintStream(bos));
                String result = bos.toString();
                Assert.assertTrue(result.contains("connected"));

                Assert.assertTrue(result.contains("company id"));
                request.getRequestDispatcher("/ReportServlet.jsp").forward(request, response);
                verify(requestDispatcher).forward(request, response);
                
            } else {
                session.setAttribute("getAlert", "Yes");
				session.setAttribute("CompanyID", "invalid");

                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                System.setOut(new PrintStream(bos));
                String result = bos.toString();

                request.getRequestDispatcher("/login.jsp").forward(request, response);
                verify(requestDispatcher).forward(request, response);
                Assert.assertFalse(result.contains("connected"));
            }


        }
    }

}