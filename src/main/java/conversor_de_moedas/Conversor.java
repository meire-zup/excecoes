package conversor_de_moedas;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Scanner;

public class Conversor {

    Scanner scanner = new Scanner(System.in);
    Scanner scannerAlfa = new Scanner(System.in);


    int escolha;


    public void menu() {

        int escolha;
        System.out.println("Boas vindas ao conversor de moedas");

        do {
            System.out.println("Qual moeda deseja converter?");
            System.out.println("1 - Dólar americano, 2 - Dólar canadense, 3 - Euro ou 4 - Libra Esterlina");
            escolha = scannerAlfa.nextInt();

            try {
                if (escolha > 0 && escolha <5){
                    converterValor();
                    System.out.println(converterValor());
                }  else                 {
                    throw new IllegalArgumentException("Tipo de moeda inválido.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        } while (escolha <=0 || escolha > 4);

    }

    public BigDecimal receberValor() {

        BigDecimal moeda = null;

        do {

            try {

                System.out.println("Informe o valor que deseja converter:");
                String moedaString = scanner.nextLine();

                if (moedaString.trim().isEmpty()) {

                    throw new NumberFormatException("Para moeda, o valor monetário deve ser um número decimal");

                }

                moeda = new BigDecimal(moedaString);

                if (moeda.compareTo(BigDecimal.ZERO) <= 0) {

                    System.out.println("Valor inválido, por favor, tente novamente");

                }


            } catch (NumberFormatException e) {
                e.printStackTrace();

                e.getMessage();

            }

            } while (moeda.compareTo(BigDecimal.ZERO) <= 0);

            return moeda;

    }

    public BigDecimal converterValor() {

        Moeda moeda;

        switch (escolha) {

            case 1:
                moeda = new DolarAmericano();
                return moeda.converterMoeda(receberValor());

            case 2:
                moeda = new DolarCanadense();
                return moeda.converterMoeda(receberValor());

            case 3:
                moeda = new Euro();
                return moeda.converterMoeda(receberValor());


            case 4:
                moeda = new LibraEsterlina();
                return moeda.converterMoeda(receberValor());
        }
        return BigDecimal.ZERO;
    }

}
