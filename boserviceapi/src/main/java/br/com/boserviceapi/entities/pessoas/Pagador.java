package br.com.boserviceapi.entities.pessoas;

import br.com.boserviceapi.entities.beans.BoletoBean;
import br.com.boserviceapi.entities.config.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pagador implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome = "";
    private String documento = "";
    private Endereco endereco;

    public static Pagador from(BoletoBean boletoBean, Endereco enderecoPagador) {

        Pagador pagador = new Pagador();
        pagador.setNome(boletoBean.getNomeCedente());
        pagador.setDocumento(boletoBean.getDocPagador());
        pagador.setEndereco(enderecoPagador);

        return pagador;
    }
}

