package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.*;
import entities.*;
import models.*;

/**
 * Servlet implementation class DataServlet
 */
@WebServlet("/reports.jsp")
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 System.out.println ("test");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		ReportModel reportModel = new ReportModel();
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("demo01")) {
			out.print(gson.toJson(reportModel.findAll()));
			out.flush(); //flushes content of buffer into output stream, whatever this means :D
			out.close();
		} else if(action.equalsIgnoreCase("demo2")){
			out.print(gson.toJson(reportModel.findAll()));
			out.flush(); //flushes content of buffer into output stream, whatever this means :D
			out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
