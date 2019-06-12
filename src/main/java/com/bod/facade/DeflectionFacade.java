package com.bod.facade;

import com.bod.entity.DeflectionHistory;
import com.bod.entity.NutritiveValue;
import com.bod.services.DeflectionService;

import java.time.LocalDate;

public class DeflectionFacade {
    public void writeDeflection(NutritiveValue deflection, int clientId) {
        DeflectionHistory deflectionHistory =
                new DeflectionHistory(clientId, LocalDate.now(), deflection);

        DeflectionService deflectionService = new DeflectionService();
        deflectionService.writeDeflection(deflectionHistory);
    }
}
