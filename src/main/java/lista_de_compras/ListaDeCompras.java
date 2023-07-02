package lista_de_compras;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ListaDeCompras {

    int escolha;
    Double quantidade;

    String nome = "";


    Scanner scannerNumerico = new Scanner(System.in);
    Scanner scannerAlfabetico = new Scanner(System.in);

    List<Alimento> listaDeCompras;

    public ListaDeCompras(List<Alimento> listaDeCompras) {

        this.listaDeCompras = listaDeCompras;
    }

    public void adicionarAlimento() {

        int escolha;

        do {

            System.out.println("Vamos montar sua lista de compras. Informe seu alimento:");
            System.out.println("Digite 1 para VERDURA, 2 para LEGUMES, 3 para GRÃOS ou 4 para OUTROS:");
            escolha = scannerNumerico.nextInt();
            if (escolha < 1 || escolha > 4) {

                System.out.println("Valor inválido!");

            }

        } while (escolha < 1 || escolha > 4);

    }


    public void menu() {

        System.out.println("Vamos montar sua lista de compras. Informe seu alimento:");
        System.out.println("Digite 1 para VERDURA, 2 para LEGUMES, 3 para GRÃOS ou 4 para OUTROS:");

        try {
            escolha = scannerNumerico.nextInt();

            switch (escolha) {
                case 1:
                    Verdura verdura = new Verdura();
                    System.out.println("Informe a quantidade de verdura que deseja adicionar:");
                    informaQuantidadeAlimentoDouble();
                    verdura.setQuantidade(quantidade);
                    System.out.println("Informe o nome da verdura que deseja adicionar:");
                    informarNomeDoAlimento();
                    verdura.setNome(nome);
                    listaDeCompras.add(verdura);
                    System.out.println(verdura.getNome());
                    System.out.println(verdura.getQuantidade());
                    break;

                case 2:


                    break;

                case 3:

                    Graos graos = new Graos();
                    System.out.println("Informe a quantidade de grãos que deseja adicionar:");
                    informaQuantidadeAlimentoDouble();
                    graos.setQuantidade(quantidade);
                    System.out.println("Informe o nome do grão que deseja adicionar:");
                    informarNomeDoAlimento();
                    graos.setNome(nome);
                    listaDeCompras.add(graos);
                    break;

                case 4:

                    System.out.println("Informe o nome do alimento que deseja adicionar:");
                    break;

                default:

                    throw new IllegalArgumentException("Tipo de alimento inválido!");


            }
        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());

        }
    }


    public void informarNomeDoAlimento() {

        do {
            try {

                nome = scannerAlfabetico.nextLine();

                if (nome.isEmpty()) {

                    throw new UnsupportedOperationException("Não é permitido inserir nome vazio");

                }


            }catch (UnsupportedOperationException e) {

                System.out.println(e.getMessage());
            }
        } while (nome.isEmpty());

    }

    public String informarNomeDoAlimento2() {

        do {
            try {

                nome = scannerAlfabetico.nextLine();

                if (nome.isEmpty()) {

                    throw new UnsupportedOperationException("Não é permitido inserir nome vazio");

                }


            }catch (UnsupportedOperationException e) {

                System.out.println(e.getMessage());
            }
        } while (nome.isEmpty());

        return nome;

    }


    public void informaQuantidadeAlimentoDouble() {

        try{
                quantidade =  scannerNumerico.nextDouble();
                String entradaQuantidade = String.valueOf(quantidade);


            if(quantidade < 0) {

                        System.out.println("Não é possível inserir número negativos!");


                } else if (quantidade == Math.floor(quantidade)) {

                    throw new NumberFormatException("Para verdura, a quantidade deve ser informada com vírgula!");

                } else if (entradaQuantidade.isEmpty()) {

                    throw new UnsupportedOperationException("Não é permitido inserir valor vazio");

                }

        } catch (NumberFormatException e) {

            System.out.println(e.getMessage());

        } catch (UnsupportedOperationException e) {

            System.out.println(e.getMessage());

        } catch (InputMismatchException e) {

            System.out.println(e.getMessage());

        }

    }

}