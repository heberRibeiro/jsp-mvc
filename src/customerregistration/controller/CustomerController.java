package customerregistration.controller;

import customerregistration.model.Customer;
import customerregistration.model.repository.DAOCustomer;
import customerregistration.model.repository.exception.ConnectionException;
import customerregistration.model.repository.exception.InsertionException;

public class CustomerController {
	
	public Customer create(Customer customer) throws Exception {
		
		
		DAOCustomer daoCustomer = new DAOCustomer();
		
		try {
			
			daoCustomer.create(customer);
			
		} catch (ConnectionException e) {
			
			throw new Exception("Connection Error! " + e.getMessage());
			
		} catch ( InsertionException e) {
		
			throw new Exception("Insertion Error! " + e.getMessage());	
			
		}
		
		
		return customer;	
	}

}
