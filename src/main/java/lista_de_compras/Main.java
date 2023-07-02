package lista_de_compras;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {

        ListaDeCompras listaDeCompras = new ListaDeCompras(new ArrayList<>());

        //listaDeCompras.menu();
        //listaDeCompras.informarNomeDoAlimento();
        //listaDeCompras.informaQuantidadeAlimentoDouble();

        List<Alimento> alimentos = new ArrayList<>();

        int saida;

        Scanner scannerNumerico = new Scanner(System.in);
        Scanner scannerAlfabetico = new Scanner(System.in);



        do {

            System.out.println("Nome: ");
            Verdura verdura = new Verdura();
            verdura.setNome(scannerAlfabetico.nextLine());
            System.out.println("Quantidade: ");
            verdura.setQuantidade(scannerNumerico.nextDouble());
            alimentos.add(verdura);
            System.out.println("Deseja continuar (0 para sair)");
            saida = scannerNumerico.nextInt();

        } while (saida !=0);

        System.out.println(alimentos);


    }
}



