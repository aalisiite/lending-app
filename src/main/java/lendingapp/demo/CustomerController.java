package lendingapp.demo;

import lendingapp.demo.api.Costumer;
import lendingapp.demo.api.Loan;
import lendingapp.demo.api.request.RegistrationRequest;
import lendingapp.demo.api.request.SignInRequest;
import lendingapp.demo.repository.service.Role;
import lendingapp.demo.repository.service.customer.AuthContextService;
import lendingapp.demo.repository.service.customer.CustomerService;
import lendingapp.demo.repository.service.loan.LoansService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {
    private CustomerService service;
    private AuthContextService authContext;
    private LoansService loansService;

    public CustomerController(CustomerService service, AuthContextService authContext, LoansService loansService) {
        this.service = service;
        this.authContext = authContext;
        this.loansService = loansService;
    }

    @PostMapping("/register")
    public ResponseEntity<Costumer> register(@Valid @RequestBody RegistrationRequest request) {
        try {
            service.registerCustomer(request);
            authContext.authorise(request.getEmail().toLowerCase().trim(), request.getPassword(), Role.USER);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IllegalStateException o_O) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/sign-in")
    public ResponseEntity<Costumer> signIn(@Valid @RequestBody SignInRequest request) {
        try {
            service.authenticateCustomer(request);
            authContext.authorise(request.getEmail().toLowerCase().trim(), request.getPassword(), Role.USER);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IllegalStateException o_O) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/sign-out")
    public void signOut() {
        authContext.clearAuthentication();
    }

    @GetMapping("/loans")
    public List<Loan> fetchLoans() {
        return new ArrayList<>();
    }

    @PostMapping("/loans/apply")
    public ResponseEntity<Loan> applyForLoan() {
        loansService.apply();
    }
}