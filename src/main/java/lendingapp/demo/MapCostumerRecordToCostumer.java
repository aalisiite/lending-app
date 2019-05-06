package lendingapp.demo;

import lendingapp.demo.api.Costumer;
import lendingapp.demo.repository.model.CostumerRecord;

import java.util.function.Function;

public class MapCostumerRecordToCostumer implements Function<CostumerRecord, Costumer> {
    @Override
    public Costumer apply(CostumerRecord costumerRecord) {
        return new Costumer(
                costumerRecord.getId(),
                costumerRecord.getEmail(),
                costumerRecord.getPassword()
        );
    }
}
