package conversor_de_moedas;

import java.math.BigDecimal;

public class DolarCanadense implements Moeda{

    private Double cambio = 4.15;

    @Override
    public BigDecimal converterMoeda(BigDecimal valor) {

        BigDecimal cambioConvertido = BigDecimal.valueOf(cambio);

        return valor.multiply(cambioConvertido);

    }
}
