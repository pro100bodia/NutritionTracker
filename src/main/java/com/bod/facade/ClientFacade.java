package com.bod.facade;

import com.bod.dto.ClientDTO;
import com.bod.entity.Client;
import com.bod.entity.Gender;
import com.bod.entity.LifeStyle;
import com.bod.services.ClientService;

import java.time.LocalDate;
import java.time.Period;

public class ClientFacade {
    public ClientDTO getData(int id) {
        ClientService clientService = new ClientService();
        Client client = clientService.getRawData(id);

        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setImg(client.getImg());
        clientDTO.setName(client.getName());
        clientDTO.setAge(countAge(client.getBirthDate()));
        clientDTO.setGender(identifyGender(client.getGender()));
        clientDTO.setHeight(client.getHeight());
        clientDTO.setWeight(client.getWeight());
        clientDTO.setLifeStyle(identifyLifeStyle(client.getLifeStyle()));

        return clientDTO;
    }


    private String identifyGender(Gender gender) {
        String shortCut = gender.name();

        if (shortCut.equals("M")) {
            return "male";
        } else {
            return "female";
        }
    }

    private int countAge(LocalDate birthdate) {
        return Period.between(birthdate, LocalDate.now()).getYears();
    }

    private String identifyLifeStyle(LifeStyle lifeStyle) {
        switch (lifeStyle) {
            case M:
                return "Minimal";
            case L:
                return "Lite";
            case A:
                return "Average";
            case H:
                return "Hard";
            case E:
                return "Extreme";
            default:
                return "Minimal";
        }
    }
}
