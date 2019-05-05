package lendingapp.demo;

import lendingapp.demo.api.Loan;
import lendingapp.demo.api.request.RegistrationRequest;
import lendingapp.demo.api.request.SignInRequest;
import lendingapp.demo.service.AuthContextService;
import lendingapp.demo.service.CustomerService;
import lendingapp.demo.service.Role;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {
    private CustomerService service;
    private AuthContextService authContext;

    public CustomerController(CustomerService service, AuthContextService authContex) {
        this.service = service;
        this.authContext = authContex;
    }

    @PostMapping("/register")
    public void register(@Valid @RequestBody RegistrationRequest request) {
        service.registerCustomer(request);
        authContext.authorise(request.getEmail().toLowerCase().trim(), request.getPassword(), Role.USER);
    }

    @PostMapping("/sign-in")
    public void signIn(@Valid @RequestBody SignInRequest request) {
        service.authenticateCustomer(request);
        authContext.authorise(request.getEmail().toLowerCase().trim(), request.getPassword(), Role.USER);
    }

    @PostMapping("/sign-out")
    public void SignOut() {
        authContext.clearAuthentication();
    }

    @GetMapping("/loans")
    public List<Loan> fetchLoans() {
        return new ArrayList<>();
    }
}
