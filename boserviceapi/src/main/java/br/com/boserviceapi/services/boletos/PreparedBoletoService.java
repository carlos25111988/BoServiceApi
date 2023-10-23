package br.com.boserviceapi.services.boletos;

import br.com.boserviceapi.dto.BoletoBeanRequestDTO;
import br.com.boserviceapi.entities.beans.BoletoBean;
import br.com.boserviceapi.entities.boletos.Boleto;
import net.sf.jasperreports.engine.JRException;

import java.io.IOException;

public interface PreparedBoletoService {

    //Boleto boletoSetValues(BoletoBeanRequestDTO boletoBeanRequestDTO);

    //Boleto boletoCreate(BoletoBean boletoBean);

    String boletoGeneratePDFFile(byte[] boletoFile, String fileName) throws IOException;

    byte[] boletoPreparedFileToImpress(Boleto boleto, String pathJrxml) throws JRException, IOException;

}
