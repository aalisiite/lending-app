package lendingapp.demo.service;

import lendingapp.demo.repository.model.service.customer.CustomerService;
import org.junit.jupiter.api.Test;

class CostumerServiceTest {
    private CustomerService service;

    public CostumerServiceTest(CustomerService service) {
        this.service = service;
    }

    @Test
    void should_not_be_able_to_register_if_email_is_present() {
        //given

        //when

        //then
    }
}