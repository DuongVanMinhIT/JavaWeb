package net.codejava.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustmoerService {
	@Autowired 
	private CustomerRepository repo;
	
	
	public List<Customer> listAll() {
        return (List<Customer>) repo.findAll();
    }
}
