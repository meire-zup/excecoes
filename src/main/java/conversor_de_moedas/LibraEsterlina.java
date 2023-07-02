package conversor_de_moedas;

import java.math.BigDecimal;

public class LibraEsterlina implements Moeda{
    private Double cambio = 7.5;

    @Override
    public BigDecimal converterMoeda(BigDecimal valor) {

        BigDecimal cambioConvertido = BigDecimal.valueOf(cambio);

        return valor.multiply(cambioConvertido);

    }

}
