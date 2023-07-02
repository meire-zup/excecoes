package lista_de_compras;

import java.util.ArrayList;
import java.util.List;

public class Main2 {

    public static void main(String[] args) {

        List<Alimento> alimentos = new ArrayList<>();

        ListaDeCompras2 listaDeCompras2 = new ListaDeCompras2(alimentos);

        //System.out.println(listaDeCompras2.informaNomeDoAlimento());

       //System.out.println(listaDeCompras2.informaQuantidadeAlimentoDouble());
        listaDeCompras2.menu();
        listaDeCompras2.imprimirLista();

    }
}
