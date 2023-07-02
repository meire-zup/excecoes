package conversor_de_moedas;

import java.math.BigDecimal;

public class Euro implements Moeda{

    private Double cambio = 6.15;

    @Override
    public BigDecimal converterMoeda(BigDecimal valor) {

        BigDecimal cambioConvertido = BigDecimal.valueOf(cambio);

        return valor.multiply(cambioConvertido);

    }
    @Override
    public Double getCambio() {

        return this.cambio;

    }

    @Override
    public String getNome() {

        return "MOEDA EURO";

    }

}
