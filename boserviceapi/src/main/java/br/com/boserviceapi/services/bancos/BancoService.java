package br.com.boserviceapi.services.bancos;

import br.com.boserviceapi.entities.boletos.Boleto;
import br.com.boserviceapi.entities.pessoas.Beneficiario;

import java.io.Serializable;
import java.net.URL;

public interface BancoService extends Serializable {

    String getNumeroFormatado();

    URL getImage();

    String geraCodigoDeBarrasPara(Boleto boleto);

    String getCodigoBeneficiarioFormatado(Beneficiario beneficiario);

    String getCarteiraFormatado(Beneficiario beneficiario);

    String getNossoNumeroFormatado(Beneficiario beneficiario);

    String getAgenciaECodigoBeneficiario(Beneficiario beneficiario);

    String getNumeroFormatadoComDigito();

    String getNossoNumeroECodigoDocumento(Boleto boleto);

}

