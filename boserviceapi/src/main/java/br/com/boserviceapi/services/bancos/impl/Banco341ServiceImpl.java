package br.com.boserviceapi.services.bancos.impl;

import br.com.boserviceapi.entities.beans.BoletoBean;
import br.com.boserviceapi.entities.boletos.Boleto;
import br.com.boserviceapi.entities.config.Datas;
import br.com.boserviceapi.entities.config.Endereco;
import br.com.boserviceapi.entities.pessoas.Beneficiario;
import br.com.boserviceapi.entities.pessoas.Pagador;
import br.com.boserviceapi.services.bancos.BancoService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static br.com.boserviceapi.utils.StellaStringUtils.leftPadWithZeros;

@Service
public class Banco341ServiceImpl implements BancoService {

    private static final long serialVersionUID = 1L;

    private static final String NUMERO = "341";
    private static final String DIGITO_NUMERO = "7";

    String arquivo = "/imagens/%s.png";

    @Override
    public String getNumeroFormatado() {
        return NUMERO;
    }

    @Override
    public java.net.URL getImage() {
        String imagem = String.format(arquivo, getNumeroFormatado());
        return getClass().getResource(imagem);
    }

    @Override
    public String geraCodigoDeBarrasPara(Boleto boleto) {
        return null;
    }

    public String getNumeroConvenioFormatado(Beneficiario beneficiario) {
        return beneficiario.getNumeroConvenio();
    }

    @Override
    public String getCodigoBeneficiarioFormatado(Beneficiario beneficiario) {
        return beneficiario.getCodigoBeneficiario();
    }

    @Override
    public String getCarteiraFormatado(Beneficiario beneficiario) {
        return leftPadWithZeros(beneficiario.getCarteira(), 2);
    }

    @Override
    public String getNossoNumeroFormatado(Beneficiario beneficiario) {
        return beneficiario.getNossoNumero();
    }

    @Override
    public String getAgenciaECodigoBeneficiario(Beneficiario beneficiario) {
        return String.format("%s / %s", beneficiario.getAgencia(), beneficiario.getCodigoBeneficiario());
    }

    @Override
    public String getNumeroFormatadoComDigito() {
        return NUMERO + "-" + DIGITO_NUMERO;
    }

    @Override
    public String getNossoNumeroECodigoDocumento(Boleto boleto) {
        Beneficiario beneficiario = boleto.getBeneficiario();
        return getNossoNumeroFormatado(beneficiario);
    }

    private static Boleto from(BoletoBean boletoBean, Banco341ServiceImpl banco, Datas datas,
                               Beneficiario beneficiario, Pagador pagador) {

        Boleto boleto = new Boleto();
        boleto.setBanco(banco);
        boleto.setDatas(datas);
        boleto.setBeneficiario(beneficiario);
        boleto.setPagador(pagador);
        boleto.setValorBoleto(BigDecimal.valueOf(Double.parseDouble(boletoBean.getVlValorTotal())));
        boleto.setValorDescontoNew(boletoBean.getValorDescontoNew());
        boleto.setValorMultaNew(boletoBean.getValorMultaNew());
        boleto.setValorJurosNew(boletoBean.getValorJurosNew());
        boleto.setValorAcrescimoNew(boletoBean.getValorAcrescimoNew());
        boleto.setValorTotalLiquidoNew(boletoBean.getValorTotalLiquidoNew());
        boleto.setNumeroDocumento(boletoBean.getNumeroDoc());
        boleto.setInstrucoes(Arrays.asList(boletoBean.getInstrucao1(), boletoBean.getInstrucao2(),
                boletoBean.getInstrucao3(), boletoBean.getInstrucao4(),
                boletoBean.getInstrucao5()));
        boleto.setLocaisDePagamento(List.of(boletoBean.getLogradouroPag() + ", " +
                boletoBean.getBairroPag() + " - " + boletoBean.getCidadePag()
                + " - " + boletoBean.getUfPag()));
        boleto.setEnderecoCompletoBeneficiario(List.of(boletoBean.getLogradouro() + ", " +
                boletoBean.getBairro() + " - " + boletoBean.getCidade()
                + " - " + boletoBean.getUf()));
        boleto.setCarteira(banco.getCarteiraFormatado(beneficiario));
        boleto.setEspecieDocumento(boletoBean.getEspecieDoc());
        boleto.setAceiteDesc(boletoBean.getAceite());
        boleto.setInputCodigoBarra(boletoBean.getInputCodigoBarra());
        boleto.setInputLinhaDigitavel(boletoBean.getInputLinhaDigitavel());

        boleto.setCodigoDeBarras(boletoBean.getInputCodigoBarra());
        boleto.setLinhaDigitavel(boletoBean.getInputLinhaDigitavel());
        boleto.setDigitoNossoNumero("");

        boleto.setValorFormatadoNew(boletoBean.getValorFormatadoNew());
        boleto.setInstrucao1(boletoBean.getInstrucao1());
        boleto.setInstrucao2(boletoBean.getInstrucao2());
        boleto.setInstrucao3(boletoBean.getInstrucao3());
        boleto.setInstrucao4(boletoBean.getInstrucao4());
        boleto.setInstrucao5(boletoBean.getInstrucao5());

        return boleto;
    }

    public static Boleto boletoCreate(BoletoBean boletoBean) {

        Datas datas = Datas.from(boletoBean);

        // endereço beneficiario
        Endereco enderecoBeneficiario = Endereco.fromBeneficiario(boletoBean);

        //Quem emite o boleto
        Beneficiario beneficiario = Beneficiario.from(boletoBean, enderecoBeneficiario);

        //Quem paga o boleto
        Endereco enderecoPagador = Endereco.fromPagador(boletoBean);
        Pagador pagador = Pagador.from(boletoBean, enderecoPagador);

        Banco341ServiceImpl banco = new Banco341ServiceImpl();

        // dados do boleto

        return from(boletoBean, banco, datas, beneficiario, pagador);
    }
}

