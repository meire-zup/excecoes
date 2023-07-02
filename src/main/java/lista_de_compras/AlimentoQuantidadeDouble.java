package lista_de_compras;

public abstract class AlimentoQuantidadeDouble extends Alimento {

    private Double quantidade;


    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }
}
