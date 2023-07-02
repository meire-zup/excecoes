package conversor_de_moedas;

import java.math.BigDecimal;

public interface Moeda {

    BigDecimal converterMoeda(BigDecimal valor);

    String getNome();

    Double getCambio();


}
