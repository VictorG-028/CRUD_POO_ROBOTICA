package repositorio;

import java.util.ArrayList;

public abstract class RepositorioGenerico<T> {

    private ArrayList<T> database = new ArrayList<>();
    private int currentID = 0;

    public ArrayList<T> getDatabase() { return database; }
    public void setDatabase(ArrayList<T> database) { this.database = database; }

    public int getCurrentID() { return currentID; }
    public void setCurrentID(int currentID) { this.currentID = currentID; }
    public void incrementCurrentID() { this.currentID += 1; }

    abstract T inserir(T item);

    abstract ArrayList<T> procurarTodos();

    abstract T procurarPorId(int id);

    abstract T procurarPorNome(String nome);

    // Apenas RepositorioAluno e RepositorioTecnico possuem essa busca
    // abstract ArrayList<T> procurarPorEquipe(String nomeEquipe);

    // Apenas RepositorioAluno e RepositorioTecnico possuem essa busca
    // abstract T procurarPorCpf(String cpf);

    abstract void deletarTodos();

    abstract boolean deletarPorId(int id);
}
