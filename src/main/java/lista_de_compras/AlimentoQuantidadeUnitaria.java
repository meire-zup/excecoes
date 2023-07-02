package lista_de_compras;

public class AlimentoQuantidadeUnitaria extends Alimento {

    private Integer quantidade;

    public Integer getQuantidade() {

        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {

        this.quantidade = quantidade;
    }

    @Override
    public String toString() {

        return super.getId() +
                " - " + super.getNome() + ": " + this.getQuantidade() ;

    }
}
