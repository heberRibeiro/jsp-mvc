package customerregistration.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import customerregistration.model.Customer;
import customerregistration.repository.exception.ConnectionException;
import customerregistration.repository.exception.InsertionException;
import customerregistration.repository.exception.QueryException;
import customerregistration.resource.db.DB;
import customerregistration.resource.db.DbException;

public class DAOCustomer {

	public DAOCustomer() {

	}

	public Customer create(Customer customer) throws InsertionException, ConnectionException {

		Connection conn = null;

		try {
			conn = DB.getConnection();

		} catch (DbException e) {

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

		DB.closeStatement(pstm);
		DB.closeConnection();

		return customer;

	}

	public Customer readByCpf(String cpf) throws ConnectionException, QueryException, ClassNotFoundException {

		Connection conn = null;

		try {
			conn = DB.getConnection();

		} catch (DbException e) {

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

				cpf = rs.getString("cpf");
				String name = rs.getString("nome");
				String email = rs.getString("email");
				String born = rs.getString("dataNascimento");
				String sexo = rs.getString("sexo");
				String social = rs.getString("nomeSocial");
				String nickname = rs.getString("apelido");
				String phone = rs.getString("telefone");

				customer = new Customer(name, cpf, email, born, sexo, social, nickname, phone);
				
				DB.closeResultSet(rs);

			}
		} catch (SQLException e) {
			throw new QueryException(e.getMessage());
		}
		
		
		DB.closeStatement(pstm);
		DB.closeConnection();

		return customer;

	}

}
