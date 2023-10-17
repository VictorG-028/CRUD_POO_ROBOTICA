package modelo;

public abstract class Pessoa {

    private int id = 0;
    private String nome;
    private int idade;
    private String cpf;
    private Equipe equipe;

    public Pessoa(String nome, int idade, String cpf, Equipe equipe) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.equipe = equipe;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public Equipe getEquipe() { return equipe; }
    public void setEquipe(Equipe equipe) { this.equipe = equipe; }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{ " +
                "id=" + id + "\', " + 
                "nome='" + nome + "\', " +
                "cpf='" + cpf + "\', " +
                "equipe=" + equipe +
                " }";
    }
}
