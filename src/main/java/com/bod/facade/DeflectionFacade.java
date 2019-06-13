package com.bod.facade;

import com.bod.entity.DeflectionRecord;
import com.bod.entity.NutritiveValue;
import com.bod.services.DeflectionService;

import java.time.LocalDate;

public class DeflectionFacade {
    public void writeDeflection(NutritiveValue deflection, int clientId) {
        DeflectionRecord deflectionRecord =
                new DeflectionRecord(clientId, LocalDate.now(), deflection);

        DeflectionService deflectionService = new DeflectionService();
        deflectionService.writeDeflection(deflectionRecord);
    }
}
