package lista_de_compras;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Alimento> alimentos = new ArrayList<>();

        ListaDeCompras listaDeCompras = new ListaDeCompras(alimentos);

        //System.out.println(listaDeCompras2.informaNomeDoAlimento());

       //System.out.println(listaDeCompras2.informaQuantidadeAlimentoDouble());
        listaDeCompras.menu();
        listaDeCompras.imprimirLista();

    }
}
