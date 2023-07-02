package conversor_de_moedas;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigDecimal moeda = new BigDecimal(0);
        System.out.println(moeda.compareTo(BigDecimal.ZERO));
        System.out.println(BigDecimal.ZERO);
        String moedaString = moeda.toPlainString();
        System.out.println(moedaString);
        System.out.println(moedaString.isBlank());

        Conversor conversor = new Conversor();
        conversor.menu();
        System.out.println(":");
        int escolha = scanner.nextInt();
        conversor.converterValor();
        System.out.println(conversor.converterValor());
        //conversor.receberValor();

    }
}
