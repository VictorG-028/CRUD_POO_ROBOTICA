package repositorio;

import modelo.Tecnico;

import java.util.ArrayList;

public class RepositorioTecnico extends RepositorioGenerico<Tecnico> {

    private static RepositorioTecnico singleton;

    private RepositorioTecnico(){
        super();
    }

    public static RepositorioTecnico getRepositorioTecnico() {
        if (singleton == null){
            singleton = new RepositorioTecnico();
        }
        return singleton;
    }

    @Override
    public Tecnico inserir(Tecnico item) {
        this.incrementCurrentID();
        item.setId(this.getCurrentID());
        this.getDatabase().add(item);

        return item;
    }

    @Override
    public ArrayList<Tecnico> procurarTodos() {
        return new ArrayList<>(this.getDatabase());
    }

    @Override
    public Tecnico procurarPorId(int id) {
        Tecnico item = null;

        for (Tecnico tecnico: this.getDatabase()) {
            if (tecnico.getId() == id){
                item = tecnico;
                break;
            }
        }
        return item;
    }

    @Override
    public Tecnico procurarPorNome(String nome) {
        Tecnico item = null;

        for (Tecnico tecnico: this.getDatabase()) {
            if (tecnico.getNome().toLowerCase().equals(nome.toLowerCase())){
                item = tecnico;
                break;
            }
        }
        return item;
    }

    public ArrayList<Tecnico> procurarPorEquipe(String nomeEquipe) {
        ArrayList<Tecnico> tecnicoFiltrados = new ArrayList<>();

        for (Tecnico tecnico: tecnicoFiltrados) {
            if (tecnico.getEquipe().getNome().toLowerCase().equals(nomeEquipe.toLowerCase())){
                tecnicoFiltrados.add(tecnico);
            }
        }
        return tecnicoFiltrados;
    }

    public Tecnico procurarPorCpf(String cpf) {
        Tecnico cpfTecnico = null;
        for (Tecnico tecnico: this.getDatabase()) {
            if (tecnico.getCpf().equals(cpf)){
                cpfTecnico = tecnico;
                break;
            }
        }
        return cpfTecnico;
    }

    @Override
    public void deletarTodos() {
        this.getDatabase().clear();
    }

    @Override
    public boolean deletarPorId(int id) {
        Tecnico item = procurarPorId(id);

        if (item == null){
            return false;
        }else {
            this.getDatabase().remove(item);
            return true;
        }
    }
}
