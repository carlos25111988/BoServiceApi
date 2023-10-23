package br.com.boserviceapi.services.boletos.impl;

import br.com.boserviceapi.dto.BoletoBeanRequestDTO;
import br.com.boserviceapi.services.boletos.GenerateBoletoService;
import br.com.boserviceapi.services.boletos.PreparedBoletoGenericsService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.Future;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class GenerateBoletoServiceImpl implements GenerateBoletoService {

    @Autowired
    private PreparedBoletoGenericsService preparedBoletoGenericsService;
    private static String PATH_001_JRXML =
            "https://app.foxmanager.com.br/foxmanager/Relatorios/Financeiro/boleto-001.jrxml";
    private static String PATH_104_JRXML =
            "https://app.foxmanager.com.br/foxmanager/Relatorios/Financeiro/boleto-104.jrxml";
    private static String PATH_237_JRXML =
            "https://app.foxmanager.com.br/foxmanager/Relatorios/Financeiro/boleto-237.jrxml";
    private static String PATH_341_JRXML =
            "https://app.foxmanager.com.br/foxmanager/Relatorios/Financeiro/boleto-341.jrxml";
    private static String PATH_707_JRXML =
            "https://app.foxmanager.com.br/foxmanager/Relatorios/Financeiro/boleto-707.jrxml";
    private static String BANCO_BB = "001";
    private static String BANCO_CAIXA = "104";
    private static String BANCO_BRADESCO = "237";
    private static String BANCO_ITAU = "341";
    private static String BANCO_DAYCOVAL = "707";

    @Override
    @Async
    public Future<byte[]> boletoFileToImpressAsync001(BoletoBeanRequestDTO boletoBeanRequestDTO) throws JRException, IOException {

        final var boleto = preparedBoletoGenericsService.boletoSetValuesGeneric(BANCO_BB, boletoBeanRequestDTO);
        byte[] boletoFile = preparedBoletoGenericsService.boletoPreparedFileToImpress(boleto, PATH_001_JRXML);
        return new AsyncResult<byte[]>(boletoFile);

    }

    @Override
    @Async
    public Future<byte[]> boletoFileToImpressAsync104(BoletoBeanRequestDTO boletoBeanRequestDTO) throws JRException, IOException {

        final var boleto = preparedBoletoGenericsService.boletoSetValuesGeneric(BANCO_CAIXA, boletoBeanRequestDTO);
        byte[] boletoFile = preparedBoletoGenericsService.boletoPreparedFileToImpress(boleto, PATH_104_JRXML);
        return new AsyncResult<byte[]>(boletoFile);

    }

    @Override
    @Async
    public Future<byte[]> boletoFileToImpressAsync237(BoletoBeanRequestDTO boletoBeanRequestDTO) throws JRException, IOException {

        final var boleto = preparedBoletoGenericsService.boletoSetValuesGeneric(BANCO_BRADESCO, boletoBeanRequestDTO);
        byte[] boletoFile = preparedBoletoGenericsService.boletoPreparedFileToImpress(boleto, PATH_237_JRXML);
        return new AsyncResult<byte[]>(boletoFile);

    }

    @Override
    @Async
    public Future<byte[]> boletoFileToImpressAsync341(BoletoBeanRequestDTO boletoBeanRequestDTO) throws JRException, IOException {

        final var boleto = preparedBoletoGenericsService.boletoSetValuesGeneric(BANCO_ITAU, boletoBeanRequestDTO);
        byte[] boletoFile = preparedBoletoGenericsService.boletoPreparedFileToImpress(boleto, PATH_341_JRXML);
        return new AsyncResult<byte[]>(boletoFile);

    }

    @Override
    @Async
    public Future<byte[]> boletoFileToImpressAsync707(BoletoBeanRequestDTO boletoBeanRequestDTO) throws JRException, IOException {

        final var boleto = preparedBoletoGenericsService.boletoSetValuesGeneric(BANCO_DAYCOVAL, boletoBeanRequestDTO);
        byte[] boletoFile = preparedBoletoGenericsService.boletoPreparedFileToImpress(boleto, PATH_707_JRXML);
        return new AsyncResult<byte[]>(boletoFile);

    }

    @Override
    public void boletoGeneratePDFFile001(String fileName, BoletoBeanRequestDTO boletoBeanRequestDTO)
            throws JRException, IOException {

        final var boleto = preparedBoletoGenericsService.boletoSetValuesGeneric(BANCO_BB, boletoBeanRequestDTO);
        byte[] boletoFile = preparedBoletoGenericsService.boletoPreparedFileToImpress(boleto, PATH_001_JRXML);

        preparedBoletoGenericsService.boletoGeneratePDFFile(boletoFile, fileName);

    }

    @Override
    public void boletoGeneratePDFFile104(String fileName, BoletoBeanRequestDTO boletoBeanRequestDTO)
            throws JRException, IOException {

        final var boleto = preparedBoletoGenericsService.boletoSetValuesGeneric(BANCO_CAIXA, boletoBeanRequestDTO);
        byte[] boletoFile = preparedBoletoGenericsService.boletoPreparedFileToImpress(boleto, PATH_104_JRXML);

        preparedBoletoGenericsService.boletoGeneratePDFFile(boletoFile, fileName);

    }

    @Override
    public void boletoGeneratePDFFile237(String fileName, BoletoBeanRequestDTO boletoBeanRequestDTO)
            throws JRException, IOException {

        final var boleto = preparedBoletoGenericsService.boletoSetValuesGeneric(BANCO_BRADESCO, boletoBeanRequestDTO);
        byte[] boletoFile = preparedBoletoGenericsService.boletoPreparedFileToImpress(boleto, PATH_237_JRXML);

        preparedBoletoGenericsService.boletoGeneratePDFFile(boletoFile, fileName);

    }

    @Override
    public void boletoGeneratePDFFile341(String fileName, BoletoBeanRequestDTO boletoBeanRequestDTO)
            throws JRException, IOException {

        final var boleto = preparedBoletoGenericsService.boletoSetValuesGeneric(BANCO_ITAU, boletoBeanRequestDTO);
        byte[] boletoFile = preparedBoletoGenericsService.boletoPreparedFileToImpress(boleto, PATH_341_JRXML);

        preparedBoletoGenericsService.boletoGeneratePDFFile(boletoFile, fileName);

    }

    @Override
    public void boletoGeneratePDFFile707(String fileName, BoletoBeanRequestDTO boletoBeanRequestDTO)
            throws JRException, IOException {

        final var boleto = preparedBoletoGenericsService.boletoSetValuesGeneric(BANCO_DAYCOVAL, boletoBeanRequestDTO);
        byte[] boletoFile = preparedBoletoGenericsService.boletoPreparedFileToImpress(boleto, PATH_707_JRXML);

        preparedBoletoGenericsService.boletoGeneratePDFFile(boletoFile, fileName);

    }

}
