package conversor_de_moedas;

import java.math.BigDecimal;

public class DolarAmericano implements Moeda {

    private Double cambio = 5.25;

    @Override
    public BigDecimal converterMoeda(BigDecimal valor) {

        BigDecimal cambioConvertido = BigDecimal.valueOf(cambio);

        return valor.multiply(cambioConvertido);

    }



    @Override
    public String getNome() {

        return "MOEDA DÓLAR AMERICANO";

    }

    @Override
    public Double getCambio() {

        return this.cambio;

    }

}
