package lista_de_compras;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Alimento> alimentos = new ArrayList<>();

        ListaDeCompras listaDeCompras = new ListaDeCompras(alimentos);

        listaDeCompras.menu();
        listaDeCompras.imprimirLista();

    }
}
