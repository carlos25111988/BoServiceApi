package br.com.boserviceapi.entities.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoletoBean {

    private int idBoleto;
    private String dtDoc;
    private String dtProcessamento;
    private String dtVencimento;
    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String nomeBeneficiario;
    private String agencia;
    private String dacAgencia;
    private String codigoBeneficiario;
    private String codigoBeneficiarioDiv;
    private String convenioBeneficiario;
    private String carteira;
    private String nossoNumero;
    private int idCarteira;
    private String nomeCedente;
    private String vlValorTotal;
    private String aceite;
    private String especieDoc;
    private String logradouroPag;
    private String bairroPag;
    private String cepPag;
    private String cidadePag;
    private String ufPag;
    private String numeroDoc;
    private String docPagador;
    private String docBeneficiario;
    private String instrucao1;
    private String instrucao2;
    private String instrucao3;
    private String instrucao4;
    private String instrucao5;
    private String inputCodigoBarra;
    private String inputLinhaDigitavel;
    private String valorFormatadoNew;
    private String valorDescontoNew;
    private String valorMultaNew;
    private String valorJurosNew;
    private String valorTotalLiquidoNew;
    private String valorAcrescimoNew;
    private String locaisDePagamento;

}
