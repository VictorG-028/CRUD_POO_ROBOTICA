package repositorio;

import modelo.Aluno;

import java.util.ArrayList;

public class RepositorioAluno extends RepositorioGenerico<Aluno> {

    private static RepositorioAluno singleton;

    private RepositorioAluno() {
        super();
    }

    public static RepositorioAluno getRepositorioAluno() {
        if (singleton == null){
            singleton = new RepositorioAluno();
        }
        return singleton;
    }

    @Override
    public Aluno inserir(Aluno item) {
        this.incrementCurrentID();
        item.setId(this.getCurrentID());
        this.getDatabase().add(item);

        return item;
    }

    @Override
    public ArrayList<Aluno> procurarTodos() {
        return new ArrayList<>(this.getDatabase());
    }

    @Override
    public Aluno procurarPorId(int id) {
        Aluno item = null;

        for (Aluno aluno: this.getDatabase()) {
            if (aluno.getId() == id){
                item = aluno;
                break;
            }
        }
        return item;
    }

    @Override
    public Aluno procurarPorNome(String nome) {
        Aluno item = null;

        for (Aluno aluno: this.getDatabase()) {
            if (aluno.getNome().toLowerCase().equals(nome.toLowerCase())){
                item = aluno;
                break;
            }
        }
        return item;
    }

    public ArrayList<Aluno> procurarPorEquipe(String nomeEquipe) {
        ArrayList<Aluno> alunosFiltrados = new ArrayList<>();

        for (Aluno aluno: alunosFiltrados) {
            String nomeEquipeLoop = aluno.getEquipe().getNome().toLowerCase();
            if  (nomeEquipeLoop.equals(nomeEquipe.toLowerCase())) {
                alunosFiltrados.add(aluno);
            }
        }
        return alunosFiltrados;
    }

    public Aluno procurarPorCpf(String cpf) {
        Aluno cpfAluno = null;
        for (Aluno aluno: this.getDatabase()) {
            if (aluno.getCpf().equals(cpf)){
                cpfAluno = aluno;
                break;
            }
        }
        return cpfAluno;
    }

    @Override
    public void deletarTodos(){
        this.getDatabase().clear();
    }

    @Override
    public boolean deletarPorId(int id) {
        Aluno item = procurarPorId(id);

        if (item == null){
            return false;
        }else {
            this.getDatabase().remove(item);
            return true;
        }
    }

}
