package br.com.boserviceapi.entities.config;

import br.com.boserviceapi.entities.beans.BoletoBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import static br.com.boserviceapi.utils.StellaStringUtils.suffixNotNullStringOrDefault;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;

    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;

    public String getEnderecoCompleto() {
        return (suffixNotNullStringOrDefault(logradouro, "", ", "))
                + (suffixNotNullStringOrDefault(bairro, "", " "))
                + (suffixNotNullStringOrDefault(cep, "", " - "))
                + (suffixNotNullStringOrDefault(cidade, "", " - "))
                + (suffixNotNullStringOrDefault(uf, "", ""));
    }

    @Override
    public String toString() {
        return this.getEnderecoCompleto();
    }

    public static Endereco fromBeneficiario(BoletoBean boletoBean) {

        Endereco enderecoBeneficiario = new Endereco();
        enderecoBeneficiario.setLogradouro(boletoBean.getLogradouro());
        enderecoBeneficiario.setBairro(boletoBean.getBairro());
        enderecoBeneficiario.setCep(boletoBean.getCep());
        enderecoBeneficiario.setCidade(boletoBean.getCidade());
        enderecoBeneficiario.setUf(boletoBean.getUf());

        return enderecoBeneficiario;
    }

    public static Endereco fromPagador(BoletoBean boletoBean) {

        Endereco enderecoPagador = new Endereco();
        enderecoPagador.setLogradouro(boletoBean.getLogradouroPag());
        enderecoPagador.setBairro(boletoBean.getBairroPag());
        enderecoPagador.setCep(boletoBean.getCepPag());
        enderecoPagador.setCidade(boletoBean.getCidadePag());
        enderecoPagador.setUf(boletoBean.getUfPag());

        return enderecoPagador;
    }
}

