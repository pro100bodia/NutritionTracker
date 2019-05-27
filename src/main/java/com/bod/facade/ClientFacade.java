package com.bod.facade;

import com.bod.dto.ClientDTO;
import com.bod.entity.Client;
import com.bod.entity.Gender;
import com.bod.entity.LifeStyle;
import com.bod.services.ClientService;

import java.time.LocalDate;
import java.time.Period;

public class ClientFacade {
    private int id;
    private ClientService clientService;

    public ClientFacade(int id) {
        this.id = id;
        clientService = new ClientService(id);
    }

    public ClientDTO getData() {
        Client client = clientService.getRawData();

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
            case A:
                return "Average";
            case I:
                return "Intensive";
            case H:
                return "Hard";
            case U:
                return "Ultimate";
            default:
                return "Minimal";
        }
    }
}
