package br.com.boserviceapi.endpoints;

import br.com.boserviceapi.dto.BoletoBeanRequestDTO;
import br.com.boserviceapi.services.boletos.GenerateBoletoService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
@RestController
@RequestMapping(path = "/app/v1/boletos")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@EnableAsync
public class GenerateBoletosEndpoint {

    private GenerateBoletoService generateBoletoService;

    @PostMapping("gerarBoleto/001")
    public ResponseEntity gerarBoleto001(@RequestHeader("File-Save-Name") String fileName,
                                         @RequestBody BoletoBeanRequestDTO boletoBeanRequestDTO)
            throws JRException, IOException, URISyntaxException {

        generateBoletoService.boletoGeneratePDFFile001(fileName, boletoBeanRequestDTO);
        return ResponseEntity.ok().build();
    }

    @PostMapping("gerarBoleto/104")
    public ResponseEntity gerarBoleto104(@RequestHeader("File-Save-Name") String fileName,
                                         @RequestBody BoletoBeanRequestDTO boletoBeanRequestDTO)
            throws JRException, IOException, URISyntaxException {

        generateBoletoService.boletoGeneratePDFFile104(fileName, boletoBeanRequestDTO);
        return ResponseEntity.ok().build();
    }

    @PostMapping("gerarBoleto/237")
    public ResponseEntity gerarBoleto237(@RequestHeader("File-Save-Name") String fileName,
                                         @RequestBody BoletoBeanRequestDTO boletoBeanRequestDTO)
            throws JRException, IOException, URISyntaxException {

        generateBoletoService.boletoGeneratePDFFile237(fileName, boletoBeanRequestDTO);
        return ResponseEntity.ok().build();

    }

    @PostMapping("gerarBoleto/341")
    public ResponseEntity gerarBoleto341(@RequestHeader("File-Save-Name") String fileName,
                                         @RequestBody BoletoBeanRequestDTO boletoBeanRequestDTO)
            throws JRException, IOException, URISyntaxException {

        generateBoletoService.boletoGeneratePDFFile341(fileName, boletoBeanRequestDTO);
        return ResponseEntity.ok().build();

    }

    @PostMapping("gerarBoleto/707")
    public ResponseEntity gerarBoleto707(@RequestHeader("File-Save-Name") String fileName,
                                         @RequestBody BoletoBeanRequestDTO boletoBeanRequestDTO)
            throws JRException, IOException, URISyntaxException {

        generateBoletoService.boletoGeneratePDFFile707(fileName, boletoBeanRequestDTO);
        return ResponseEntity.ok().build();

    }

    @PostMapping("/imprimirBoleto/001")
    public ResponseEntity<byte[]> imprimirBoletoAsync001(@RequestBody BoletoBeanRequestDTO boletoBeanRequestDTO)
            throws JRException, ExecutionException, InterruptedException, URISyntaxException, IOException {

        Future<byte[]> futureResponse = generateBoletoService.boletoFileToImpressAsync001(boletoBeanRequestDTO);
        byte[] arquivoRetorno;

        while (true) {
            if (futureResponse.isDone()) {
                arquivoRetorno = futureResponse.get();
                break;
            }
        }

        if (arquivoRetorno == null) {
            String erro = new InterruptedException().getMessage();
            throw new RuntimeException("Error: " + erro);
        }

        return ResponseEntity.ok()
                .contentLength(arquivoRetorno.length)
                .contentType(MediaType.APPLICATION_PDF)
                .body(arquivoRetorno);

    }

    @PostMapping("/imprimirBoleto/104")
    public ResponseEntity<byte[]> imprimirBoletoAsync104(@RequestBody BoletoBeanRequestDTO boletoBeanRequestDTO)
            throws JRException, ExecutionException, InterruptedException, URISyntaxException, IOException {

        Future<byte[]> futureResponse = generateBoletoService.boletoFileToImpressAsync104(boletoBeanRequestDTO);
        byte[] arquivoRetorno;

        while (true) {
            if (futureResponse.isDone()) {
                arquivoRetorno = futureResponse.get();
                break;
            }
        }

        if (arquivoRetorno == null) {
            String erro = new InterruptedException().getMessage();
            throw new RuntimeException("Error: " + erro);
        }

        return ResponseEntity.ok()
                .contentLength(arquivoRetorno.length)
                .contentType(MediaType.APPLICATION_PDF)
                .body(arquivoRetorno);

    }

    @PostMapping("/imprimirBoleto/237")
    public ResponseEntity<byte[]> imprimirBoletoAsync237(@RequestBody BoletoBeanRequestDTO boletoBeanRequestDTO)
            throws JRException, ExecutionException, InterruptedException, URISyntaxException, IOException {

        Future<byte[]> futureResponse = generateBoletoService.boletoFileToImpressAsync237(boletoBeanRequestDTO);
        byte[] arquivoRetorno;

        while (true) {
            if (futureResponse.isDone()) {
                arquivoRetorno = futureResponse.get();
                break;
            }
        }

        if (arquivoRetorno == null) {
            String erro = new InterruptedException().getMessage();
            throw new RuntimeException("Error: " + erro);
        }

        return ResponseEntity.ok()
                .contentLength(arquivoRetorno.length)
                .contentType(MediaType.APPLICATION_PDF)
                .body(arquivoRetorno);

    }

    @PostMapping("/imprimirBoleto/341")
    public ResponseEntity<byte[]> imprimirBoletoAsync341(@RequestBody BoletoBeanRequestDTO boletoBeanRequestDTO)
            throws JRException, ExecutionException, InterruptedException, URISyntaxException, IOException {

        Future<byte[]> futureResponse = generateBoletoService.boletoFileToImpressAsync341(boletoBeanRequestDTO);
        byte[] arquivoRetorno;

        while (true) {
            if (futureResponse.isDone()) {
                arquivoRetorno = futureResponse.get();
                break;
            }
        }

        if (arquivoRetorno == null) {
            String erro = new InterruptedException().getMessage();
            throw new RuntimeException("Error: " + erro);
        }

        return ResponseEntity.ok()
                .contentLength(arquivoRetorno.length)
                .contentType(MediaType.APPLICATION_PDF)
                .body(arquivoRetorno);

    }

    @PostMapping("/imprimirBoleto/707")
    public ResponseEntity<byte[]> imprimirBoletoAsync707(@RequestBody BoletoBeanRequestDTO boletoBeanRequestDTO)
            throws JRException, ExecutionException, InterruptedException, URISyntaxException, IOException {

        Future<byte[]> futureResponse = generateBoletoService.boletoFileToImpressAsync341(boletoBeanRequestDTO);
        byte[] arquivoRetorno;

        while (true) {
            if (futureResponse.isDone()) {
                arquivoRetorno = futureResponse.get();
                break;
            }
        }

        if (arquivoRetorno == null) {
            String erro = new InterruptedException().getMessage();
            throw new RuntimeException("Error: " + erro);
        }

        return ResponseEntity.ok()
                .contentLength(arquivoRetorno.length)
                .contentType(MediaType.APPLICATION_PDF)
                .body(arquivoRetorno);

    }
}
