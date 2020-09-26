package customerregistration.resource;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customerregistration.controller.CustomerController;
import customerregistration.model.Customer;
import customerregistration.model.repository.DAOCustomer;
import customerregistration.model.repository.exception.ConnectionException;
import customerregistration.model.repository.exception.InsertionException;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/CustomerResource")
public class CustomerResource extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at GET: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at POST:
		// ").append(request.getContextPath());

		
		
		String name = request.getParameter("name");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		String born = request.getParameter("born");
		String sexo = request.getParameter("sexo");
		String social = request.getParameter("social");
		String nickname = request.getParameter("nickname");
		String phone = request.getParameter("phone");

		Customer customer = new Customer(name, cpf, email, born, sexo, social, nickname, phone);

		CustomerController customerController = new CustomerController();

		try {

			customerController.create(customer);

		} catch (Exception e) {

			response.getWriter().append("Erro: " + e.getMessage());

		}
	}

}
