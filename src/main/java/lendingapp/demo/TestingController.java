package lendingapp.demo;

import lendingapp.demo.repository.service.customer.CustomerService;
import lendingapp.demo.repository.service.time.TimeSupplier;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/testing-api")
public class TestingController {

    private TimeSupplier timeSupplier;
    private CustomerService service;

    public TestingController(TimeSupplier timeSupplier, CustomerService service) {
        this.timeSupplier = timeSupplier;
        this.service = service;
    }

    @PostMapping("/reset-time")
    public void resetTime() {
        timeSupplier.resetDateTime();
    }

    @PutMapping("/time")
    public void setTime(@RequestBody LocalDateTime dateTime) {
        timeSupplier.setDateTime(dateTime);
    }

    @GetMapping("/time")
    public LocalDateTime getTime() {
        return timeSupplier.getDateTime();
    }

    @PostMapping("/clear-database")
    public void clearDatabase() {
        service.clearDatabase();
    }
}
