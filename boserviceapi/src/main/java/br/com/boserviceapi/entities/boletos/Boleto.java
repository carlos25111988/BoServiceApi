package br.com.boserviceapi.entities.boletos;

import br.com.boserviceapi.entities.config.Datas;
import br.com.boserviceapi.entities.pessoas.Beneficiario;
import br.com.boserviceapi.entities.pessoas.Pagador;
import br.com.boserviceapi.services.bancos.BancoService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static br.com.boserviceapi.utils.StellaStringUtils.leftPadWithZeros;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Boleto implements Serializable {

    private static final long serialVersionUID = 1L;

    protected BigDecimal valorBoleto = BigDecimal.ZERO;

    protected BigDecimal quantidadeMoeda;
    protected BigDecimal valorMoeda;
    protected BigDecimal valorDescontos = BigDecimal.ZERO;
    protected BigDecimal valorDeducoes = BigDecimal.ZERO;
    protected BigDecimal valorMulta = BigDecimal.ZERO;
    protected BigDecimal valorAcrescimos = BigDecimal.ZERO;

    protected String carteira;
    protected String especieMoeda;
    protected int codigoEspecieMoeda;
    protected String especieDocumento;
    protected String numeroDocumento;

    protected String inputCodigoBarra;
    protected String inputLinhaDigitavel;
    protected String valorFormatadoNew;

    protected String valorDescontoNew;
    protected String valorMultaNew;
    protected String valorJurosNew;
    protected String valorTotalLiquidoNew;
    protected String valorAcrescimoNew;

    protected String instrucao1;
    protected String instrucao2;
    protected String instrucao3;
    protected String instrucao4;
    protected String instrucao5;

    protected boolean aceite;
    protected String aceiteDesc;
    protected BancoService banco;
    protected Datas datas;
    protected Pagador pagador;
    protected Beneficiario beneficiario;

    protected List<String> instrucoes = Collections.emptyList();
    protected List<String> descricoes = Collections.emptyList();
    protected List<String> locaisDePagamento = Collections.emptyList();
    protected List<String> enderecoCompletoBeneficiario = Collections.emptyList();

    //corrigir erro no docker
    protected String linhaDigitavel;
    protected String codigoDeBarras;
    protected String digitoNossoNumero;

    //inicio usados no jasper
    public BigDecimal getValorCobrado() {
        BigDecimal valorCobrado = valorBoleto;
        BigDecimal descontos = BigDecimal.ZERO;
        BigDecimal acrescimos = BigDecimal.ZERO;

        descontos = descontos.add(valorDescontos).add(valorDeducoes);
        acrescimos = acrescimos.add(valorMulta).add(valorAcrescimos);

        if (descontos.compareTo(BigDecimal.ZERO) != 0) {
            valorCobrado = valorCobrado.subtract(descontos);
        }
        if (acrescimos.compareTo(BigDecimal.ZERO) != 0) {
            valorCobrado = valorCobrado.add(acrescimos);
        }
        if (valorCobrado.compareTo(valorBoleto) == 0) {
            return BigDecimal.ZERO;
        }

        return valorCobrado;
    }

    public String getAgenciaECodigoBeneficiario() {
        return this.banco.getAgenciaECodigoBeneficiario(this.beneficiario);
    }

    public String getNossoNumeroECodDocumento() {
        return banco.getNossoNumeroECodigoDocumento(this);
    }

    public BigDecimal getQuantidadeDeMoeda() {
        return this.quantidadeMoeda;
    }

    public String getLocalDePagamento() {
        return locaisDePagamento.isEmpty() ? "" : locaisDePagamento.get(0);
    }

    public String getEnderecoCompletoBeneficiario() {
        return enderecoCompletoBeneficiario.isEmpty() ? "" : enderecoCompletoBeneficiario.get(0);
    }

    public String getNumeroDoDocumentoFormatado() {
        return leftPadWithZeros(this.numeroDocumento, 4);
    }

    //fim usados no jasper

}

