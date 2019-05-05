package lendingapp.demo;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/testing-api")
public class TestingController {

    private TimeSupplier timeSupplier;

    public TestingController(TimeSupplier timeSupplier) {
        this.timeSupplier = timeSupplier;
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
    public void deleteTime() {
    }
}
