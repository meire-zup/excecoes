package conversor_de_moedas;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class Conversor {

    Scanner scanner = new Scanner(System.in);
    int escolha;

    // Menu inicial:
    public void menu() {

        System.out.println("Boas vindas ao conversor de moedas");

        do {

            System.out.println("Qual moeda deseja converter?");
            System.out.println("1 - Dólar americano, 2 - Dólar canadense, 3 - Euro ou 4 - Libra Esterlina");
            escolha = scanner.nextInt();

            scanner.nextLine();

            try {
                if (escolha > 0 && escolha <5){

                    System.out.println("O sistema irá converter a moeda escolhida em Real (R$)");
                    converterValor();
                    System.out.println("Deseja realizar outra conversão? (Digite 1 para sim ou 2 para não)");
                    int querContinuar = scanner.nextInt();
                    if (querContinuar == 1) {

                        menu();

                    } else {
                        System.out.println("FIM!");
                    }

                }  else                 {

                    throw new IllegalArgumentException("Tipo de moeda inválido.");

                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());

            }

        } while (escolha <=0 || escolha > 4);

    }

// O método recebe o valor que o usuário deseja converter.
    public BigDecimal receberValor() {

        BigDecimal moeda = null;

        boolean valorValido = false;

        while (!valorValido) {

            System.out.println("Informe o valor que deseja converter:");
            String moedaString = scanner.nextLine().trim();

            try {

                if (moedaString.isEmpty()) {
                    throw new NumberFormatException("Para moeda, o valor monetário deve ser um número decimal");

                }

                moeda = new BigDecimal(moedaString);

                if (moeda.compareTo(BigDecimal.ZERO) <= 0) {

                    System.out.println("Valor inválido, por favor, tente novamente");

                } else {

                    valorValido = true;

                }

            } catch (NumberFormatException e) {

                System.out.println(e.getMessage());
            }
        }

        return moeda;
    }

    // Método converte o valor de uma das moedas abaixo para real.
    public void converterValor() {

        Map<Integer, Moeda> moedas = new HashMap<>();
        moedas.put(1, new DolarAmericano());
        moedas.put(2, new DolarCanadense());
        moedas.put(3, new Euro());
        moedas.put(4, new LibraEsterlina());

        Moeda moeda = moedas.get(escolha);
        if (moeda != null) {
            BigDecimal valor = receberValor();
            BigDecimal moedaConvertida = moeda.converterMoeda(valor);

            System.out.println("A [" + moeda.getNome() + "] na cotação do dia de hoje [" + LocalDate.now()
                    + "] está em valor de [" + moeda.getCambio() + "], o valor que pediu para converter de [" + valor +
                    "] em reais é R$ " + moedaConvertida);
        } else {
            throw new IllegalArgumentException("Tipo de moeda inválido.");
        }

    }


}
