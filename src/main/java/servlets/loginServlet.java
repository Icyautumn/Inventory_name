package servlets;

import java.io.IOException;
import org.mindrot.jbcrypt.*;
import static javax.swing.JOptionPane.showMessageDialog;

import java.io.PrintWriter;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class login
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public loginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	public static String encodeToBase64(String message) {
		return Base64.getEncoder().encodeToString(message.getBytes());
	}

	public static String decodeFromBase64(String encodedMessage) {
		byte[] decodedBytes = Base64.getDecoder().decode(encodedMessage);
		String decodedString = new String(decodedBytes);
		return decodedString;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try (PrintWriter out = response.getWriter()) {
			String email = request.getParameter("username");
			String password = request.getParameter("password");

			HttpSession session = request.getSession();
			// test
//			 hash password
//			 var hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
//			BCrypt.checkpw(password, passwordcallfromdatabase);

			password = encodeToBase64(password);
//			System.out.println(decodeFromBase64(password)+ " decoded");

			if (email.equals("inventory") && password.equals(encodeToBase64("password"))) {
				session.setAttribute("getAlert", null);
				session.setAttribute("companyID", "002");

				System.out.println("connected");

				// sets company ID to session attribute
				System.out.println("company id: " + session.getAttribute("companyID"));

				request.getRequestDispatcher("/ReportServlet.jsp").forward(request, response);
//				response.sendRedirect("summary.jsp");

			} else {
				session.setAttribute("getAlert", "Yes");
				session.setAttribute("CompanyID", "invalid");

				System.out.println(session.getAttribute("companyID") + " companyID");
				System.out.println(session.getAttribute("getAlert") + " hello");
				response.sendRedirect("login.jsp");

			}
		}
		doGet(request, response);
	}

}
