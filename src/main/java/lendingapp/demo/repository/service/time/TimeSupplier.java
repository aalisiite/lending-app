package lendingapp.demo.repository.service.time;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TimeSupplier {

    private LocalDateTime dateTime;


    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void resetDateTime() {
        setDateTime(LocalDateTime.now());
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
