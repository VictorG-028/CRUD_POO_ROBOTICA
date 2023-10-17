package modelo;

public abstract class Aluno extends Pessoa {

    public Aluno(String nome, int idade, String cpf, Equipe equipe) {
        super(nome, idade, cpf, equipe);
    }

    @Override
    public String toString() {
        return "Aluno{ " +
                "id=" + this.getId() + "\', " + 
                "nome='" + this.getNome() + "\', " +
                "cpf='" + this.getCpf() + "\', " +
                "equipe='" + this.getEquipe() + "\'" +
                " }";
    }
}
