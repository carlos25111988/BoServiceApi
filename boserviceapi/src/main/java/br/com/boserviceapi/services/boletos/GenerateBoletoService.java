package br.com.boserviceapi.services.boletos;

import br.com.boserviceapi.dto.BoletoBeanRequestDTO;
import net.sf.jasperreports.engine.JRException;
import org.springframework.scheduling.annotation.Async;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.Future;

public interface GenerateBoletoService {

    @Async
    Future<byte[]> boletoFileToImpressAsync001(BoletoBeanRequestDTO boletoBeanRequestDTO) throws JRException, IOException;

    @Async
    Future<byte[]> boletoFileToImpressAsync104(BoletoBeanRequestDTO boletoBeanRequestDTO) throws JRException, IOException;

    Future<byte[]> boletoFileToImpressAsync237(BoletoBeanRequestDTO boletoBeanRequestDTO) throws JRException, URISyntaxException, IOException;

    @Async
    Future<byte[]> boletoFileToImpressAsync341(BoletoBeanRequestDTO boletoBeanRequestDTO) throws JRException, IOException;

    Future<byte[]> boletoFileToImpressAsync707(BoletoBeanRequestDTO boletoBeanRequestDTO) throws JRException, URISyntaxException, IOException;

    void boletoGeneratePDFFile001(String fileName, BoletoBeanRequestDTO boletoBeanRequestDTO)
            throws JRException, IOException;

    void boletoGeneratePDFFile104(String fileName, BoletoBeanRequestDTO boletoBeanRequestDTO)
            throws JRException, IOException;

    void boletoGeneratePDFFile237(String fileName, BoletoBeanRequestDTO boletoBeanRequestDTO)
            throws JRException, IOException, URISyntaxException;

    void boletoGeneratePDFFile341(String fileName, BoletoBeanRequestDTO boletoBeanRequestDTO)
            throws JRException, IOException;

    void boletoGeneratePDFFile707(String fileName, BoletoBeanRequestDTO boletoBeanRequestDTO)
            throws JRException, IOException;
}
