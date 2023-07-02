package lista_de_compras;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class ListaDeCompras {

    int escolha;

    String nome = "";


    Scanner scannerNumerico = new Scanner(System.in);
    Scanner scannerAlfabetico = new Scanner(System.in);

    List<Alimento> listaDeCompras;

    public ListaDeCompras(List<Alimento> listaDeCompras) {

        this.listaDeCompras = listaDeCompras;
    }

    public void menu() {

        do {

            System.out.println("Digite 1 para VERDURA, 2 para LEGUMES, 3 para GRÃOS, 4 para OUTROS ou 0 para sair:");

            try {
                escolha = scannerNumerico.nextInt();

                switch (escolha) {
                    case 0:

                        System.out.println("FIM!");
                        break;

                    case 1:
                        Verdura verdura = new Verdura();
                        verdura.setQuantidade(informaQuantidadeAlimentoDouble());
                        System.out.println("Informe o nome da verdura que deseja adicionar:");
                        verdura.setNome(informaNomeDoAlimento());
                        listaDeCompras.add(verdura);

                        break;

                    case 2:
                        Legumes legumes = new Legumes();
                        legumes.setQuantidade(informaQuantidadeAlimentoInteger());
                        System.out.println("Informe o nome do legume que deseja adicionar:");
                        legumes.setNome(informaNomeDoAlimento());
                        listaDeCompras.add(legumes);

                        break;

                    case 3:

                        Graos graos = new Graos();
                        graos.setQuantidade(informaQuantidadeAlimentoDouble());
                        System.out.println("Informe o nome do grão que deseja adicionar:");
                        graos.setNome(informaNomeDoAlimento());
                        listaDeCompras.add(graos);

                        break;

                    case 4:

                        Outros outro = new Outros();
                        outro.setQuantidade(informaQuantidadeAlimentoInteger());
                        System.out.println("Informe o nome do alimento que deseja adicionar:");
                        outro.setNome(informaNomeDoAlimento());
                        listaDeCompras.add(outro);

                        break;

                    default:

                        throw new IllegalArgumentException("Tipo de alimento inválido!");


                }

            } catch (IllegalArgumentException e) {

                System.out.println(e.getMessage());

            }

        } while (escolha != 0);

    }


    public String informaNomeDoAlimento() {

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

    public Double informaQuantidadeAlimentoDouble() {
        System.out.println("Informe a quantidade que deseja adicionar (em kg)");
        boolean valorValido = false;
        BigDecimal quantidadeDecimal = BigDecimal.ZERO;

        do {
            try {
                String linha = scannerAlfabetico.nextLine().trim();

                if (linha.isEmpty()) {
                    throw new UnsupportedOperationException("Não é permitido inserir valor vazio");
                }

                quantidadeDecimal = new BigDecimal(linha);

                if (quantidadeDecimal.compareTo(BigDecimal.ZERO) < 0) {
                    System.out.println("Não é possível inserir números negativos!");
                } else if (quantidadeDecimal.scale() == 0) {
                    throw new NumberFormatException("A quantidade deve ser informada com ponto!");
                } else {
                    valorValido = true;
                }

            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (UnsupportedOperationException e) {
                System.out.println(e.getMessage());
            }
        } while (!valorValido);

        return quantidadeDecimal.doubleValue();
    }

    public Integer informaQuantidadeAlimentoInteger() {
        System.out.println("Informe a quantidade que deseja adicionar (em unidade)");
        boolean valorValido = false;
        BigDecimal quantidadeDecimal = BigDecimal.ZERO;

        do {
            try {
                String linha = scannerAlfabetico.nextLine().trim();

                if (linha.isEmpty()) {
                    throw new UnsupportedOperationException("Não é permitido inserir valor vazio");
                }

                quantidadeDecimal = new BigDecimal(linha);

                if (quantidadeDecimal.compareTo(BigDecimal.ZERO) < 0) {

                    System.out.println("Não é possível inserir números negativos!");

                } else if (quantidadeDecimal.scale() != 0) {

                    throw new NumberFormatException("A quantidade deve ser informada em unidades inteiras!");


                } else {

                    valorValido = true;

                }

            } catch (NumberFormatException e) {

                System.out.println(e.getMessage());

            } catch (UnsupportedOperationException e) {

                System.out.println(e.getMessage());
            }
        } while (!valorValido);

        return quantidadeDecimal.intValue();
    }

    public void imprimirLista(){

        System.out.println("Lista de compras:");
        System.out.println("ID  | NOME | QUANTIDADE | TIPO ALIMENTO");
        System.out.println(listaDeCompras.toString());

        }



}