package lendingapp.demo.service;

import com.sun.jdi.request.InvalidRequestStateException;
import lendingapp.demo.api.Customer;
import lendingapp.demo.api.request.RegistrationRequest;
import lendingapp.demo.api.request.SignInRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerService {

    private List<Customer> customers = new ArrayList<>();
    private Long id;

    public void registerCustomer(RegistrationRequest request) {
        if (request.getEmail().trim().toLowerCase().contains(request.getEmail().toLowerCase().trim())) {
            throw new InvalidRequestStateException("Wrong email or password");
        } else {
            Customer customer = new Customer(
                    id,
                    request.getEmail(),
                    request.getPassword()
            );
            customers.add(customer);
        }
    }

    public void authenticateCustomer(SignInRequest request) {

//        if (!customers.contains(new Customer(id, request.getEmail().trim().toLowerCase(), request.getPassword()))) {
//            Customer customer = new Customer();
//        } else {
//            throw new InvalidRequestStateException("Wrong email or password");
//        }
    }
}
