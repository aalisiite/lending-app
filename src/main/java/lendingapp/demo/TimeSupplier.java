package lendingapp.demo;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TimeSupplier {

    private LocalDateTime dateTime;


    void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    void resetDateTime() {
        setDateTime(LocalDateTime.now());
    }

    LocalDateTime getDateTime() {
        return dateTime;
    }
}
