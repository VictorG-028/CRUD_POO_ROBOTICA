package cli;

import modelo.*;
import negocio.NegocioAluno;
import negocio.NegocioCampeonato;
import negocio.NegocioEquipe;
import negocio.NegocioTecnico;
import negocio.excecoes.*;

import java.util.ArrayList;
import java.util.function.Function;

public class Interface {

    private static NegocioEquipe negocioEquipe = new NegocioEquipe();
    private static NegocioAluno negocioAluno = new NegocioAluno();
    private static NegocioTecnico negocioTecnico = new NegocioTecnico();
    private static NegocioCampeonato negocioCampeonato = new NegocioCampeonato();

    private static ErrorHandledScanner scanner = new ErrorHandledScanner();

    public static void main(String[] args) throws NomeMuitoPequenoException, NomeDuplicadoException, NomeNullException, NomeVazioException, IdInvalidoException, IdNegativoException, CpfCaracterException, EquipeInvalidaException, CpfSomentoNumerosException, CpfIgualException, AlunoDeMaiorException, AlunoDeMenorException {

        while (true) {
            String s = """
                    Digite uma opção:
                    [0] Sair
                    [1] Equipe
                    [2] Aluno
                    [3] Técnico
                    [4] Campeonato             
                    """;
            int operando  = scanner.pedirInt(s);

            if (operando  == 0) { break; }
            s = """
                Digite uma operação:
                [0] Sair
                [1] Criar
                [2] Listar
                [3] Deletar
                """;
            int operacao = scanner.pedirInt(s);
            if (operando == 0 || operacao == 0) { break; }

            // Link útil para entender c´podigo abaixo (ver segunda resposta Feb 8, 2019 at 9:33)
            // https://softwareengineering.stackexchange.com/questions/386845/creating-a-list-of-functions-in-java#:~:text=While%20you%20could%20pass%20an,have%20a%20single%20comprehensive%20list.
            
            ArrayList<Function<Integer, Integer>> cadastrarF = new ArrayList<>();
            cadastrarF.add(a -> { return 0; }); // [0]
            cadastrarF.add(a -> { try { cadastrarEquipe(); } catch (NomeMuitoPequenoException | NomeDuplicadoException | NomeNullException | NomeVazioException e) {e.printStackTrace();} return 0; }); // [1]
            cadastrarF.add(a -> { try { cadastrarAluno(); } catch (NomeNullException | NomeVazioException | NomeMuitoPequenoException | CpfCaracterException | CpfIgualException | CpfSomentoNumerosException | EquipeInvalidaException | AlunoDeMaiorException | AlunoDeMenorException e) {e.printStackTrace();} return 0; }); // [2]
            // cadastrarF.add(a -> { cadastrarTecnico(); return 0; }); // [3] // TODO função cadastrarTecnico
            // cadastrarF.add(a -> { cadastrarCampeonato(); return 0; }); // [4] // TODO função cadastrarCampeonato
            
            // Tentativa sem sucesso de tirar o try catch
            // List<Function<Integer, Integer>> cadastrarFuncList = List.of(
            //     a -> { return 0; }, // [0]
            //     a -> { cadastrarEquipe(); return 0; }, //[1]
            //     a -> { cadastrarAluno(); return 0; }, // [2]
            //     a -> { /*cadastrarTecnico();*/ return 0; }, // [3] // TODO função cadastrarTecnico
            //     a -> { /*cadastrarCampeonato();*/ return 0; } // [4] // TODO função cadastrarCampeonato
            // );
            

            ArrayList<Function<Integer, Integer>> procurarF = new ArrayList<>();
            procurarF.add(a -> { return 0; }); // [0]
            procurarF.add(a -> { for (Equipe item : negocioEquipe.procurarTodos()) { System.out.println(item); } return 0; }); // [1]
            procurarF.add(a -> { for (Aluno item : negocioAluno.procurarTodos()) { System.out.println(item); } return 0; }); // [2]
            procurarF.add(a -> { for (Tecnico item : negocioTecnico.procurarTodos()) { System.out.println(item); } return 0; }); // [3]
            procurarF.add(a -> { for (Campeonato item : negocioCampeonato.procurarTodos()) { System.out.println(item); } return 0; }); // [4]
            
            ArrayList<Function<Integer, Integer>> deletarF = new ArrayList<>();
            deletarF.add(a -> { return 0; }); // [0]
            deletarF.add(a -> { try { deletarEquipe(); } catch (IdNegativoException | IdInvalidoException e) {e.printStackTrace();} return 0; }); // [1]
            deletarF.add(a -> { try { deletarAluno(); } catch (IdNegativoException | IdInvalidoException e) {e.printStackTrace();} return 0; }); // [2]
            // deletarF.add(a -> { deletarTecnico(); return 0; }); // [3] // TODO função deletarTecnico
            // deletarF.add(a -> { deletarCampeonato(); return 0; }); // [4] // TODO função deletarCampeonato

            // Nada melhor que arraylist de arraylist (matriz de arraylist). izi pizy.
            ArrayList<ArrayList<Function<Integer, Integer>>> operacoes = new ArrayList<>();
            operacoes.add(cadastrarF);
            operacoes.add(procurarF);
            operacoes.add(deletarF);

            Function<Integer, Integer> lambda = operacoes.get(operando).get(operacao);
            lambda = operacoes.get(0).get(0); // Apagar essa linha
            lambda.apply(0); // Chama a função lambda (pesquisar Lambda Calculus (λ-calculus) para entender)
            // https://en.wikipedia.org/wiki/Lambda_calculus

            // Apagar resto do código depois de conferir implementação acima
            if (operando == 1) {
                if (operacao == 1) {
                    cadastrarEquipe();
                } else if (operacao == 2) {
                    for (Equipe item : negocioEquipe.procurarTodos()) {
                        System.out.println(item);
                    }
                } else if (operacao == 3) {
                    deletarEquipe();
                } else {
                    System.out.println("Opção inválida, tente novamente.");
                }
            } else if (operando == 2) {
                if (operacao == 1) {
                    cadastrarAluno();
                } else if (operacao == 2) {
                    for (Aluno item : negocioAluno.procurarTodos()) {
                        System.out.println(item);
                    }
                } else if (operacao == 3) {
                    deletarAluno();
                } else {
                    System.out.println("Opção inválida, tente novamente.");
                }
            } else if (operando == 3) {
                if (operacao == 1) {
                    // cadastrarTecnico(); // TODO
                } else if (operacao == 2) {
                    for (Tecnico item : negocioTecnico.procurarTodos()) {
                        System.out.println(item);
                    }
                } else if (operacao == 3) {
                    // deletarTecnico(); // TODO
                } else {
                    System.out.println("Opção inválida, tente novamente.");
                }
            } else if (operando == 4) {
                if (operacao == 1) {
                    // cadastrarCampeonato(); // TODO
                } else if (operacao == 2) {
                    for (Campeonato item : negocioCampeonato.procurarTodos()) {
                        System.out.println(item);
                    }
                } else if (operacao == 3) {
                    // deletarCampeonato(); // TODO
                } else {
                    System.out.println("Opção inválida, tente novamente.");
                }
            }
        }
    }

    public static void cadastrarEquipe() throws NomeMuitoPequenoException, NomeDuplicadoException, NomeNullException, NomeVazioException{
        String nomeEquipe = scanner.pedirString("Digite o nome da equipe a ser inserida: ");
        Uf ufEquipe = scanner.pedirUf();

        try {
            negocioEquipe.inserir(new Equipe(nomeEquipe,ufEquipe));
        } catch (NomeMuitoPequenoException e) {
            System.out.println("Digite um nome com 2 ou mais caracteres, tente novamente.");
        } catch (NomeDuplicadoException e) {
            System.out.println("Já existe uma equipe com este nome, tente novamente.");
        } catch (NomeNullException e) {
            System.out.println("O nome está nulo, tente novamente.");
        } catch (NomeVazioException e) {
            System.out.println("Você não digou um nome, tente novamente.");
        }

    }

    public static void deletarEquipe() throws IdNegativoException, IdInvalidoException{
        int del = scanner.pedirInt("Digite o número do Id da Equipe que deseja deletar.");
        try {
            negocioEquipe.deletarPorId(del);
        } catch (IdInvalidoException e) {
            System.out.println("Você passou um id inválido, tente novamente.");
        } catch (IdNegativoException e) {
            System.out.println("Não existe id negativo, tente novamente.");
        }
    }

    public static void cadastrarAluno() throws NomeNullException, NomeVazioException, NomeMuitoPequenoException, CpfCaracterException, CpfIgualException, CpfSomentoNumerosException, EquipeInvalidaException, AlunoDeMaiorException, AlunoDeMenorException{
        String nomeAluno = scanner.pedirString("Digite o nome do aluno(a) a ser cadastrado(a): ");
        int idadeAluno = scanner.pedirInt("Digite a idade do(a) aluno(a)");
        String cpfAluno = scanner.pedirString("Digite o cpf do(a) aluno(a): ");

        ArrayList<Equipe> equipes = negocioEquipe.procurarTodos();

        for (int i = 0; i < equipes.size(); i++) {
            System.out.println(String.format("[%d] ", i) + equipes.get(i));
        }

        int equipeIndice = scanner.pedirInt("Digite o número da Equipe existente para o(a) aluno(a): ");
        Equipe equipeDoAluno = equipes.get(equipeIndice);

        try {
            negocioAluno.inserir(new Aluno(nomeAluno, idadeAluno, cpfAluno, equipeDoAluno));
        } catch (NomeMuitoPequenoException ex) {
            System.out.println("Digite um nome com 2 ou mais caracteres, tente novamente.");
        } catch (EquipeInvalidaException ex) {
            System.out.println("Está equipe não foi encontrada no banco de dados, tente novamente.");
        } catch (CpfCaracterException ex) {
            System.out.println("O cpf deve conter 11 algarismos, tente novamente.");
        } catch (CpfSomentoNumerosException ex) {
            System.out.println("Digite apenas números no cpf, tente novamente");
        } catch (CpfIgualException ex) {
            System.out.println("Já existe um cpf igual, tente novamente.");
        } catch (AlunoDeMaiorException ex) {
            System.out.println("O(A) aluno(a) excedeu a idade máxima permitada.");
        } catch (NomeNullException ex) {
            System.out.println("O nome está nulo, tente novamente.");
        } catch (NomeVazioException ex) {
            System.out.println("Você não digou um nome, tente novamente.");
        } catch (AlunoDeMenorException ex) {
            System.out.println("O(A) aluno(a) não tem a idade mínima permitada.");
        }
    }

    public static void deletarAluno() throws IdNegativoException, IdInvalidoException{
        int del = scanner.pedirInt("Digite o número do Id do(a) Aluno(a) que deseja deletar.");
        try {
            negocioAluno.deletarPorId(del);
        } catch (IdInvalidoException e) {
            System.out.println("Você passou um id inválido, tente novamente.");
        } catch (IdNegativoException e) {
            System.out.println("Não existe id negativo, tente novamente.");
        }
    }
}
