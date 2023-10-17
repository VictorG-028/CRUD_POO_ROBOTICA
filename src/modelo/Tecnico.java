package modelo;

public class Tecnico extends Pessoa {

    public Tecnico(String nome, int idade, String cpf, Equipe equipe) {
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
