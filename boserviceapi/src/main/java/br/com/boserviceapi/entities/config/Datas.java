package br.com.boserviceapi.entities.config;

import br.com.boserviceapi.entities.beans.BoletoBean;
import br.com.boserviceapi.exception.DataLimiteUltrapassadaException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.GregorianCalendar;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Datas {

    private static final Calendar INIT_DATE = new GregorianCalendar(2000, 6, 3);

    private static final int RANGE_MINIMO = 3000;
    private static final int RANGE_MAXIMO = 5500;

    private Calendar documento;
    private Calendar processamento;
    private Calendar vencimento;

    public Datas getDataDocumento(Calendar documento) {
        Calendar dataLimite = Calendar.getInstance();
        dataLimite.setTime(documento.getTime());
        dataLimite.add(Calendar.DAY_OF_YEAR, RANGE_MAXIMO);

        if (documento.getTime().before(INIT_DATE.getTime())) {
            throw new DataLimiteUltrapassadaException("A data do documento deve ser a partir de 03/07/2000.");
        }

        this.documento = documento;

        return this;
    }

    private Calendar dataPara(int dia, int mes, int ano) {
        Calendar c = Calendar.getInstance();
        c.set(ano, mes - 1, dia);
        return c;

    }

    public Datas setDataDocumento(int dia, int mes, int ano) {
        return getDataDocumento(dataPara(dia, mes, ano));
    }

    public Datas getDataProcessamento(Calendar processamento) {
        if (processamento.getTime().before(INIT_DATE.getTime())) {
            throw new DataLimiteUltrapassadaException("A data do documento deve ser a partir de 03/07/2000.");
        }

        this.processamento = processamento;

        return this;
    }

    public Datas setDataProcessamento(int dia, int mes, int ano) {
        return getDataProcessamento(dataPara(dia, mes, ano));
    }

    public Datas getDataVencimento(Calendar vencimento) {
        if (vencimento.getTime().before(INIT_DATE.getTime())) {
            throw new DataLimiteUltrapassadaException("A data do documento deve ser a partir de 03/07/2000.");
        }

        Calendar dataLimite = Calendar.getInstance();
        if (documento != null)
            dataLimite.setTime(documento.getTime());

        dataLimite.add(Calendar.DAY_OF_YEAR, RANGE_MAXIMO);

        if (vencimento.getTime().after(dataLimite.getTime())) {
            throw new DataLimiteUltrapassadaException("A data de vencimento ultrapassa o range permitido para emissão do boleto.");
        }

        this.vencimento = vencimento;

        return this;
    }

    public Datas setDataVencimento(int dia, int mes, int ano) {
        return getDataVencimento(dataPara(dia, mes, ano));
    }

    public static Datas from(BoletoBean boletoBean) {

        Datas datas = new Datas();
        datas.setDataDocumento(Integer.parseInt(boletoBean.getDtDoc().substring(0, 2)),
                Integer.parseInt(boletoBean.getDtDoc().substring(3, 5)),
                Integer.parseInt(boletoBean.getDtDoc().substring(6, 10))
        );
        datas.setDataProcessamento(Integer.parseInt(boletoBean.getDtProcessamento().substring(0, 2)),
                Integer.parseInt(boletoBean.getDtProcessamento().substring(3, 5)),
                Integer.parseInt(boletoBean.getDtProcessamento().substring(6, 10))
        );
        datas.setDataVencimento(Integer.parseInt(boletoBean.getDtVencimento().substring(0, 2)),
                Integer.parseInt(boletoBean.getDtVencimento().substring(3, 5)),
                Integer.parseInt(boletoBean.getDtVencimento().substring(6, 10))
        );
        return datas;
    }
}