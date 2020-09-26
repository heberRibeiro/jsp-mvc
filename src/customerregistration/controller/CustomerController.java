package customerregistration.controller;

import customerregistration.controller.exception.DuplicateCpfException;
import customerregistration.controller.exception.MandatoryParameterException;
import customerregistration.model.Customer;
import customerregistration.model.repository.DAOCustomer;
import customerregistration.model.repository.exception.ConnectionException;
import customerregistration.model.repository.exception.InsertionException;

public class CustomerController {
	
	public Customer create(Customer customer) throws Exception {
		
		// Checks if the name and cpf were passed
		if(customer.getName() == "" || customer.getCpf() == "")	
			throw new MandatoryParameterException("Name or cpf are mandatory");
		
		// Checks if the cpf already exist in database
		DAOCustomer daoCustomer = new DAOCustomer();
		Customer customerFound = daoCustomer.readByCpf(customer.getCpf());
		
		if(customerFound != null)
			throw new DuplicateCpfException("CPF duplicate");
			
		
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
