package servlets;
import java.io.IOException;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String public_key = "MCgCIQCbuuorFiegnOsF/zE43ApBUT3e2kRiLQXw4RUJxgxCiwIDAQAB";
//		String private_Key = "MIGqAgEAAiEAm7rqKxYnoJzrBf8xONwKQVE93tpEYi0F8OEVCcYMQosCAwEAAQIhAJJxBltWDhWe+fM9sk/Bu3GPf9E9Z0iLDAgjIfqg58OBAhEA22P3XflRg0f5ocDVLqPImwIRALW3eSJ/x21smfx5hGsiNNECEHPoHIhJcAcrv3b1qas6XIECEFusEZpL6CnVzeFG1HzPpuECEEGBsBkuGWGqtcuEoXkBB1I=";
		// TODO Auto-generated method stub
		
//		KeyPairGenerator kpg = null;
//		try {
//			kpg = KeyPairGenerator.getInstance("RSA");
//		} catch (NoSuchAlgorithmException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		KeyPair kp = kpg.generateKeyPair();
//		RSAPublicKey rPubKey = (RSAPublicKey) kp.getPublic();
//		RSAPrivateKey rPriKey = (RSAPrivateKey) kp.getPrivate();
		
		try (PrintWriter out = response.getWriter()){
			String email = request.getParameter("username");
			String password = request.getParameter("password");
//			try {
//			    Algorithm algorithm = Algorithm.RSA256(rPubKey, rPriKey);
//			    String token = JWT.create()
//			        .withIssuer("auth0")
//			        .sign(algorithm);
//			} catch (JWTCreationException exception){
//			    // Invalid Signing configuration / Couldn't convert Claims.
//			}
			
			HttpSession session = request.getSession();
			
//			password = encodeToBase64(password);
			System.out.println(email);
			System.out.println(password);
//			System.out.println(decodeFromBase64(password)+ " decoded");
			
			if(email.equals("inventory") && password.equals("password") ) {
//				request.getSession().setAttribute("auth", user);
				session.setAttribute("getAlert",null);
				request.getRequestDispatcher("/ReportServlet.jsp").forward(request, response);
//				response.sendRedirect("summary.jsp");
				
			}
			else {
				session.setAttribute("getAlert","Yes");
				System.out.print(request.getAttribute("getAlert") + "hello");
				response.sendRedirect("login.jsp");
				
			}
		}
		doGet(request, response);
	}

}
