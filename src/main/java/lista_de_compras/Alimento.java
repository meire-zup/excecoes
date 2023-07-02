package lista_de_compras;

public abstract class Alimento {

    private Long id;

    private String nome;

    private static Long proximoId = 1L;


    public Alimento() {
        this.id = proximoId;
        proximoId++;

    }

    public String getNome() {

        return nome;

    }

    public void setNome(String nome) {

        this.nome = nome;

    }

    public Long getId() {

        return id;
    }
}
