package lendingapp.demo.repository.service.customer;

import lendingapp.demo.MapCostumerRecordToCostumer;
import lendingapp.demo.api.request.RegistrationRequest;
import lendingapp.demo.api.request.SignInRequest;
import lendingapp.demo.repository.model.CostumerRecord;
import lendingapp.demo.repository.CostumerRecordRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomerService {

    private CostumerRecordRepository costumerRecordRepository;
    private PasswordEncoder passwordEncoder;
    private MapCostumerRecordToCostumer costumerRecordToCostumer = new MapCostumerRecordToCostumer();

    public CustomerService(CostumerRecordRepository costumerRecordRepository, PasswordEncoder passwordEncoder) {
        this.costumerRecordRepository = costumerRecordRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerCustomer(RegistrationRequest request) {
        if (costumerRecordRepository.isEmailPresent(request.getEmail().toLowerCase().trim())) {
            throw new IllegalStateException();
        }
        CostumerRecord costumer = new CostumerRecord(
                request.getEmail().toLowerCase().trim(),
                passwordEncoder.encode(request.getPassword())
        );
        costumerRecordRepository.save(costumer);
        costumerRecordToCostumer.apply(costumer);
    }

    public void authenticateCustomer(SignInRequest request) {
        CostumerRecord costumer = costumerRecordRepository.findByEmail(request.getEmail().toLowerCase().trim());
        if (costumer != null) {
            if (passwordEncoder.matches(request.getPassword(), costumer.getPassword())) {
                costumerRecordToCostumer.apply(costumer);
            } else {
                throw new IllegalStateException("Wrong password");
            }
        } else {
            throw new IllegalStateException("Wrong email");
        }
    }

    public void clearDatabase() {
        costumerRecordRepository.deleteAll();
    }
}
