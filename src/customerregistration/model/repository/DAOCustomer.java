package customerregistration.model.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import customerregistration.model.Customer;
import customerregistration.model.repository.exception.ConnectionException;
import customerregistration.model.repository.exception.InsertionException;
import customerregistration.model.repository.exception.QueryException;

public class DAOCustomer {

	// private Customer customer;

	public DAOCustomer() {

	}

	public Customer create(Customer customer) throws ConnectionException, InsertionException, ClassNotFoundException {
		
		String user = "root";
		String password = "root";
		String dburl = "jdbc:mysql://localhost:3306/lojaunit?useTimezone=true&serverTimezone=UTC";

		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn;
		
		try {
			
			conn = DriverManager.getConnection(dburl, user, password);
			
		} catch (SQLException e) {
			
			throw new ConnectionException(e.getMessage());
		}
		
		String sql = "INSERT INTO clientes (cpf, nome, email, dataNascimento, sexo, nomeSocial, apelido, telefone) "
				+ "VALUES (?,?,?,?,?,?,?,?)";

		PreparedStatement pstm;

		try {
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, customer.getCpf());
			pstm.setString(2, customer.getName());
			pstm.setString(3, customer.getEmail());
			pstm.setString(4, customer.getBorn());
			pstm.setString(5, customer.getSexo());
			pstm.setString(6, customer.getSocial());
			pstm.setString(7, customer.getNickname());
			pstm.setString(8, customer.getPhone());
			
			pstm.executeUpdate();

		} catch (SQLException e) {
			
			throw new InsertionException(e.getMessage());
		}

		return customer;

	}

	public Customer readByCpf(String cpf) throws ConnectionException, QueryException {

		String user = "root";
		String password = "root";
		String dburl = "jdbc:mysql://localhost:3306/lojaunit?autoReconnect=true&useTimezone=true&serverTimezone=UTC";

		Connection conn;
		try {
			conn = DriverManager.getConnection(dburl, user, password);
		} catch (SQLException e) {
			throw new ConnectionException(e.getMessage());
		}

		String sql = "SELECT id, cpf, nome, email, dataNascimento, sexo, nomeSocial, apelido, telefone "
				+ "FROM clientes WHERE cpf=?";

		PreparedStatement pstm;

		Customer customer = null;

		try {
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, cpf);

			ResultSet rs = pstm.executeQuery();

			if (rs.next()) {

				String id = rs.getString("id");
				cpf = rs.getString("cpf");
				String name = rs.getString("nome");
				String email = rs.getString("email");
				String born = rs.getString("dataNascimento");
				String sexo = rs.getString("sexo");
				String social = rs.getString("nomeSocial");
				String nickname = rs.getString("apelido");
				String phone = rs.getString("telefone");

				customer = new Customer(name, cpf, email, born, sexo, social, nickname, phone);

			}
		} catch (SQLException e) {
			throw new QueryException(e.getMessage());
		}

		return customer;

	}

}
