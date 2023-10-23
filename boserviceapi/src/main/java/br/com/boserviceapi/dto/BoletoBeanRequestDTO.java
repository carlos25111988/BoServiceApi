package br.com.boserviceapi.dto;

import br.com.boserviceapi.entities.beans.BoletoBean;
import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class BoletoBeanRequestDTO {

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
    private String docBeneficiario;

    private String logradouroPag;
    private String bairroPag;
    private String cepPag;
    private String cidadePag;
    private String ufPag;

    private String nomeCedente;
    private String docPagador;

    private String locaisDePagamento;

    private String vlValorTotal;
    private String numeroDoc;
    private String instrucao1;
    private String instrucao2;
    private String instrucao3;
    private String instrucao4;
    private String instrucao5;
    private String especieDoc;
    private String aceite;

    private String inputCodigoBarra;
    private String inputLinhaDigitavel;

    private String valorFormatadoNew;
    private String valorDescontoNew;
    private String valorMultaNew;
    private String valorJurosNew;
    private String valorTotalLiquidoNew;
    private String valorAcrescimoNew;

    public static BoletoBean from(BoletoBeanRequestDTO boletoBeanRequestDTO) {
        var boletoBean = new BoletoBean();

        boletoBean.setDtDoc(boletoBeanRequestDTO.getDtDoc());
        boletoBean.setDtProcessamento(boletoBeanRequestDTO.getDtProcessamento());
        boletoBean.setDtVencimento(boletoBeanRequestDTO.getDtVencimento());

        boletoBean.setLogradouro(boletoBeanRequestDTO.getLogradouro());
        boletoBean.setBairro(boletoBeanRequestDTO.getBairro());
        boletoBean.setCep(boletoBeanRequestDTO.getCep());
        boletoBean.setCidade(boletoBeanRequestDTO.getCidade());
        boletoBean.setUf(boletoBeanRequestDTO.getUf());

        boletoBean.setNomeBeneficiario(boletoBeanRequestDTO.getNomeBeneficiario());
        boletoBean.setAgencia(boletoBeanRequestDTO.getAgencia());
        boletoBean.setDacAgencia(boletoBeanRequestDTO.getDacAgencia());
        boletoBean.setCodigoBeneficiario(boletoBeanRequestDTO.getCodigoBeneficiario());
        boletoBean.setCodigoBeneficiarioDiv(boletoBeanRequestDTO.getCodigoBeneficiarioDiv());
        boletoBean.setConvenioBeneficiario(boletoBeanRequestDTO.getConvenioBeneficiario());

        boletoBean.setCarteira(boletoBeanRequestDTO.getCarteira());
        boletoBean.setNossoNumero(boletoBeanRequestDTO.getNossoNumero());
        boletoBean.setDocBeneficiario(boletoBeanRequestDTO.getDocBeneficiario());

        boletoBean.setLogradouroPag(boletoBeanRequestDTO.getLogradouroPag());
        boletoBean.setBairroPag(boletoBeanRequestDTO.getBairroPag());
        boletoBean.setCepPag(boletoBeanRequestDTO.getCepPag());
        boletoBean.setCidadePag(boletoBeanRequestDTO.getCidadePag());
        boletoBean.setUfPag(boletoBeanRequestDTO.getUfPag());

        boletoBean.setNomeCedente(boletoBeanRequestDTO.getNomeCedente());
        boletoBean.setDocPagador(boletoBeanRequestDTO.getDocPagador());

        boletoBean.setLocaisDePagamento(boletoBeanRequestDTO.getLocaisDePagamento());

        boletoBean.setVlValorTotal(boletoBeanRequestDTO.getVlValorTotal());
        boletoBean.setNumeroDoc(boletoBeanRequestDTO.getNumeroDoc());
        boletoBean.setInstrucao1(boletoBeanRequestDTO.getInstrucao1());
        boletoBean.setInstrucao2(boletoBeanRequestDTO.getInstrucao2());
        boletoBean.setInstrucao3(boletoBeanRequestDTO.getInstrucao3());
        boletoBean.setInstrucao4(boletoBeanRequestDTO.getInstrucao4());
        boletoBean.setInstrucao5(boletoBeanRequestDTO.getInstrucao5());

        boletoBean.setEspecieDoc(boletoBeanRequestDTO.getEspecieDoc());
        boletoBean.setAceite(boletoBeanRequestDTO.getAceite());

        boletoBean.setInputCodigoBarra(boletoBeanRequestDTO.getInputCodigoBarra());
        boletoBean.setInputLinhaDigitavel(boletoBeanRequestDTO.getInputLinhaDigitavel());

        boletoBean.setValorFormatadoNew(boletoBeanRequestDTO.getValorFormatadoNew());
        boletoBean.setValorDescontoNew(boletoBeanRequestDTO.getValorDescontoNew());
        boletoBean.setValorMultaNew(boletoBeanRequestDTO.getValorMultaNew());
        boletoBean.setValorJurosNew(boletoBeanRequestDTO.getValorJurosNew());
        boletoBean.setValorTotalLiquidoNew(boletoBeanRequestDTO.getValorTotalLiquidoNew());
        boletoBean.setValorAcrescimoNew(boletoBeanRequestDTO.getValorAcrescimoNew());

        return boletoBean;
    }

}
