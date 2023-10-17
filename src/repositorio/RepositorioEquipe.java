package repositorio;

import modelo.Equipe;

import java.util.ArrayList;

public class RepositorioEquipe extends RepositorioGenerico<Equipe> {

    private static RepositorioEquipe singleton;

    private RepositorioEquipe() {
        super();
    }

    public static RepositorioEquipe getRepositorioEquipe(){
        if (singleton == null) {
            singleton = new RepositorioEquipe();
        }
        return singleton;
    }

    @Override
    public Equipe inserir(Equipe item){
        this.incrementCurrentID();
        item.setId(this.getCurrentID());
        this.getDatabase().add(item);

        return item;
    }

    @Override
    public ArrayList<Equipe> procurarTodos(){
        return new ArrayList<>(this.getDatabase());
    }

    @Override
    public Equipe procurarPorId(int id){
        Equipe item = null;

        for (Equipe equipe: this.getDatabase()) {
            if (equipe.getId() == id){
                item = equipe;
                break;
            }
        }
        return item;
    }

    @Override
    public Equipe procurarPorNome(String nome){
        Equipe item = null;

        for (Equipe equipe: this.getDatabase()) {
            if (equipe.getNome().toLowerCase().equals(nome.toLowerCase())){
                item = equipe;
                break;
            }
        }
        return item;
    }

    @Override
    public void deletarTodos(){
        this.getDatabase().clear();
    }

    @Override
    public boolean deletarPorId(int id){
        Equipe item = procurarPorId(id);

        if (item == null){
            return false;
        }else {
            this.getDatabase().remove(item);
            return true;
        }
    }
}
