package br.com.boserviceapi.dto;

import com.fasterxml.jackson.databind.ObjectMapper;

public class GenericRequestPayload {

    public static <T> BoletoBeanRequestDTO from(T payload) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(payload, BoletoBeanRequestDTO.class);
    }
}
