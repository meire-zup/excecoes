package lista_de_compras;

public abstract class AlimentoQuantidadeDouble extends Alimento {

    private Double quantidade;


    public Double getQuantidade() {

        return quantidade;

    }

    public void setQuantidade(Double quantidade) {

        this.quantidade = quantidade;

    }

    @Override
    public String toString() {
        return super.getId() +
                " - " + super.getNome() + ": " + this.getQuantidade() + " kg\n";
    }


}
