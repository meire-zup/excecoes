package conversor_de_moedas;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

public class Conversor {

    Scanner scanner = new Scanner(System.in);

    int escolha;


    public void menu() {


        System.out.println("Boas vindas ao conversor de moedas");

        do {
            System.out.println("Qual moeda deseja converter?");
            System.out.println("1 - Dólar americano, 2 - Dólar canadense, 3 - Euro ou 4 - Libra Esterlina");
            escolha = scanner.nextInt();

            scanner.nextLine();

            try {
                if (escolha > 0 && escolha <5){

                    converterValor();

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




    public BigDecimal receberValor2() {
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





    public void converterValor() {

        Moeda moeda;
        BigDecimal valor = receberValor2();

        if (escolha == 1) {

            moeda = new DolarAmericano();
            BigDecimal moedaConvertida =  moeda.converterMoeda(valor);
            System.out.println(moeda.converterMoeda(valor));
            System.out.println("A ["+ moeda.getNome() + "] na cotação do dia de hoje [" + LocalDate.now()
                    + "] está em valor de [" + moeda.getCambio() + "], o valor que pediu para converter de [" + valor +
                    "] em reias é R$ " + moedaConvertida);


        } else if (escolha == 2) {

            moeda = new DolarCanadense();
            BigDecimal moedaConvertida =  moeda.converterMoeda(valor);
            System.out.println("A ["+ moeda.getNome() + "] na cotação do dia de hoje [" + LocalDate.now()
                    + "] está em valor de [" + moeda.getCambio() + "], o valor que pediu para converter de [" + valor +
                    "] em reias é R$ " + moedaConvertida);


        } else if (escolha == 3) {

            moeda = new Euro();
            BigDecimal moedaConvertida =  moeda.converterMoeda(valor);
            System.out.println("A ["+ moeda.getNome() + "] na cotação do dia de hoje [" + LocalDate.now()
                    + "] está em valor de [" + moeda.getCambio() + "], o valor que pediu para converter de [" + valor +
                    "] em reias é R$ " + moedaConvertida);


        } else if (escolha == 4){

                moeda = new LibraEsterlina();
            BigDecimal moedaConvertida =  moeda.converterMoeda(valor);
            System.out.println("A ["+ moeda.getNome() + "] na cotação do dia de hoje [" + LocalDate.now()
                    + "] está em valor de [" + moeda.getCambio() + "], o valor que pediu para converter de [" + valor +
                    "] em reias é R$ " + moedaConvertida);

        }

    }

}
