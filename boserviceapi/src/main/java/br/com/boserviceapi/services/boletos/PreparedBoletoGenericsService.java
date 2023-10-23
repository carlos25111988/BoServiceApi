package br.com.boserviceapi.services.boletos;

import br.com.boserviceapi.dto.BoletoBeanRequestDTO;
import br.com.boserviceapi.entities.boletos.Boleto;

public interface PreparedBoletoGenericsService extends PreparedBoletoService {
    <T> Boleto boletoSetValuesGeneric(String codigoBanco, T body);

    Boleto boletoCreate(String codigoBanco, BoletoBeanRequestDTO boletoBeanRequestDTO);
}
