package br.com.boserviceapi.services.boletos.impl;

import br.com.boserviceapi.dto.BoletoBeanRequestDTO;
import br.com.boserviceapi.dto.GenericRequestPayload;
import br.com.boserviceapi.entities.beans.BoletoBean;
import br.com.boserviceapi.entities.boletos.Boleto;
import br.com.boserviceapi.services.bancos.impl.*;
import br.com.boserviceapi.services.boletos.PreparedBoletoGenericsService;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class PreparedBoletoGenericsServiceImpl implements PreparedBoletoGenericsService {

    //usar essa path para prod
    private static String PATH_SAVE_FILE = "/bo-service-arquivos";
    // usar esse path para dev
    //private static String PATH_SAVE_FILE = "C:/usr/share/tomcat7/efs/Boletos";
    private static String BANCO_BB = "001";
    private static String BANCO_CAIXA = "104";
    private static String BANCO_BRADESCO = "237";
    private static String BANCO_ITAU = "341";
    private static String BANCO_DAYCOVAL = "707";

    @Override
    public <T> Boleto boletoSetValuesGeneric(String codigoBanco, T body) {

        Boleto boleto = null;
        if (codigoBanco.equals(BANCO_BB)) {
            boleto = boletoCreate(BANCO_BB, GenericRequestPayload.from(body));
        }
        if (codigoBanco.equals(BANCO_CAIXA)) {
            boleto = boletoCreate(BANCO_CAIXA, GenericRequestPayload.from(body));
        }
        if (codigoBanco.equals(BANCO_BRADESCO)) {
            boleto = boletoCreate(BANCO_BRADESCO, GenericRequestPayload.from(body));
        }
        if (codigoBanco.equals(BANCO_ITAU)) {
            boleto = boletoCreate(BANCO_ITAU, GenericRequestPayload.from(body));
        }
        if (codigoBanco.equals(BANCO_DAYCOVAL)) {
            boleto = boletoCreate(BANCO_DAYCOVAL, GenericRequestPayload.from(body));
        }

        return boleto;
    }

    @Override
    public Boleto boletoCreate(String codigoBanco, BoletoBeanRequestDTO boletoBeanRequestDTO) {

        // SETAR DADOS DO BOLETO
        BoletoBean boletoBean = BoletoBeanRequestDTO.from(boletoBeanRequestDTO);
        Boleto boleto = null;

        if (codigoBanco.equals(BANCO_BB)) {
            boleto = Banco001ServiceImpl.boletoCreate(boletoBean);
        }
        if (codigoBanco.equals(BANCO_CAIXA)) {
            boleto = Banco104ServiceImpl.boletoCreate(boletoBean);
        }
        if (codigoBanco.equals(BANCO_BRADESCO)) {
            boleto = Banco237ServiceImpl.boletoCreate(boletoBean);
        }
        if (codigoBanco.equals(BANCO_ITAU)) {
            boleto = Banco341ServiceImpl.boletoCreate(boletoBean);
        }
        if (codigoBanco.equals(BANCO_DAYCOVAL)) {
            boleto = Banco707ServiceImpl.boletoCreate(boletoBean);
        }

        return boleto;

    }

    @Override
    public String boletoGeneratePDFFile(byte[] boletoFile, String fileName) throws IOException {

        File file = new File(PATH_SAVE_FILE + "/" + fileName);
        FileOutputStream out = new FileOutputStream(file);
        out.write(boletoFile);
        out.close();

        return PATH_SAVE_FILE + fileName;

    }

    @Override
    public byte[] boletoPreparedFileToImpress(Boleto boleto, String pathJrxml) throws JRException, IOException {

        URL url = new URL(pathJrxml);
        log.info("URL: " + url);
        log.info("Solicitado em: " + LocalDateTime.now());
        URLConnection connection = url.openConnection();
        InputStream in = connection.getInputStream();

        JasperDesign design = JRXmlLoader.load(in);
        // usar no dev
        //JasperDesign design = JRXmlLoader.load(pathJrxml);
        JasperReport relatorio = JasperCompileManager.compileReport(design);

        Collection<Boleto> boletosDataSource = List.of(boleto);
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(
                boletosDataSource
        );

        Map<String, Object> parametros = new HashMap<>();
        JasperPrint impressao = JasperFillManager.fillReport(relatorio, parametros, dataSource);
        byte[] boletoFile = JasperExportManager.exportReportToPdf(impressao);

        return boletoFile;

    }

}
