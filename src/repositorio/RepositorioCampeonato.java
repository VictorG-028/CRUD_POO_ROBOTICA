package repositorio;

import modelo.Campeonato;

import java.util.ArrayList;

public class RepositorioCampeonato extends RepositorioGenerico<Campeonato> {

    private static RepositorioCampeonato singleton;


    private RepositorioCampeonato() {
        super();
    }

    public static RepositorioCampeonato getRepositorioCampeonato() {
        if (singleton == null) {
            singleton = new RepositorioCampeonato();
        }
        return singleton;
    }

    public Campeonato inserir(Campeonato item) {
        this.incrementCurrentID();
        item.setId(this.getCurrentID());
        this.getDatabase().add(item);

        return item;
    }

    public ArrayList<Campeonato> procurarTodos() {
        return new ArrayList<>(this.getDatabase());
    }

    public Campeonato procurarPorId(int id){
        Campeonato item = null;

        for (Campeonato campeonato: this.getDatabase()) {
            if (campeonato.getId() == id){
                item = campeonato;
                break;
            }
        }
        return item;
    }

    public Campeonato procurarPorNome(String nome) {
        Campeonato item = null;

        for (Campeonato campeonato: this.getDatabase()) {
            if (campeonato.getNome().toLowerCase().equals(nome.toLowerCase())){
                item = campeonato;
                break;
            }
        }
        return item;
    }

    public void deletarTodos() {
        this.getDatabase().clear();
    }

    public boolean deletarPorId(int id) {
        Campeonato item = procurarPorId(id);

        if (item == null){
            return false;
        }else {
            this.getDatabase().remove(item);
            return true;
        }
    }
}
