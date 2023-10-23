package br.com.boserviceapi.entities.pessoas;

import br.com.boserviceapi.entities.beans.BoletoBean;
import br.com.boserviceapi.entities.config.Endereco;
import br.com.boserviceapi.enums.Modalidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Beneficiario {
    private static final long serialVersionUID = 1L;

    private String agencia;
    private String digitoAgencia;

    private String codigoBeneficiario;
    private String digitoCodigoBeneficiario;

    private String carteira;
    private String nossoNumero;
    private String digitoNossoNumero;

    private String nomeBeneficiario;
    private String documento;
    private Endereco endereco;

    private String numeroConvenio; //Exigência do BB: número do convênio
    private Modalidade modalidade = Modalidade.COM_REGISTRO; //C ou S Registro

    public static Beneficiario from(BoletoBean boletoBean, Endereco enderecoBeneficiario) {

        Beneficiario beneficiario = new Beneficiario();
        beneficiario.setNomeBeneficiario(boletoBean.getNomeBeneficiario());
        beneficiario.setAgencia(boletoBean.getAgencia());
        beneficiario.setDigitoAgencia(boletoBean.getDacAgencia());
        beneficiario.setCodigoBeneficiario(boletoBean.getCodigoBeneficiario());
        beneficiario.setDigitoCodigoBeneficiario(boletoBean.getCodigoBeneficiarioDiv());
        beneficiario.setNumeroConvenio(boletoBean.getConvenioBeneficiario());
        beneficiario.setCarteira(boletoBean.getCarteira());
        beneficiario.setEndereco(enderecoBeneficiario);
        beneficiario.setNossoNumero(boletoBean.getNossoNumero());
        beneficiario.setDocumento(boletoBean.getDocBeneficiario());

        return beneficiario;
    }
}
