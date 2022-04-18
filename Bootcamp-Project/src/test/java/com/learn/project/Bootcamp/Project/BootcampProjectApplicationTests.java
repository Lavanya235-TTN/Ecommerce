package com.learn.project.Bootcamp.Project;

import com.learn.project.Bootcamp.Project.model.Users.Address;
import com.learn.project.Bootcamp.Project.model.Users.Customer;
import com.learn.project.Bootcamp.Project.model.Users.Role.Role;
import com.learn.project.Bootcamp.Project.model.Users.User;
import com.learn.project.Bootcamp.Project.repository.CustomerRepository;
import com.learn.project.Bootcamp.Project.repository.RoleRepository;
import com.learn.project.Bootcamp.Project.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
class BootcampProjectApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	RoleRepository roleRepository;

//	@Autowired
//	PasswordEncoder passwordEncoder;

	@Test
	void contextLoads() {
	}

	@Test
	public void createCustomer(){
		Customer customer=new Customer();
		//userRepository.save(customer);
		//User user=new User();
		customer.setEmail("deral@gmail.com");
		customer.setContact("981096197");
	//	Address address=new Address();
		customer.setFirstName("Komal");
		customer.setLastName("Rawat");
		customer.setPassword("komal");
		Role role=roleRepository.findByName("ROLE_CUSTOMER");
		System.out.println(role.getName());
		Set<Role> roles=new HashSet<>();
		roles.add(role);
		//user.setRoles(roles);
		customer.addRole(role);
		userRepository.save(customer);
//		address.setCity("Delhi");
//		address.setCountry("India");
//		address.setLabel("home");
//		address.setState("Delhi");
//		address.setAddressLine("jwqj jwqj");
//		address.setZipCode(110074);

		//user.addAddress(address);
		//userRepository.save(customer);
	}

	/*@Test
	public void getRoles(){
		List<Role> role=roleRepository.findAll();
		role.forEach(p -> System.out.println(p));

	}*/

	@Test
	public void testst(){
		Customer customer=new Customer();
		customer.setFirstName("Komal");
		userRepository.save(customer);
		customer.setLastName("Rawat");
		userRepository.save(customer);
	}

	@Test
	public void ewj(){
		List<Customer> customers=customerRepository.findAll();
		customers.forEach(p -> System.out.println(p.getId() + "--->" + p.getEmail()));


		List<Object[]> partialData =customerRepository.findAllCustomer();
		for (Object[] objects : partialData) {
			System.out.println("Id: "+objects[0]+" FullName: "+objects[1]+"Emial: "+objects[2]);
		}

	}

}
