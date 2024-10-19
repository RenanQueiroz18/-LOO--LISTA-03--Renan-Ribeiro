import java.util.ArrayList;
import java.util.Scanner;

public class SistemaEscola {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Aluno> alunosCadastrados = new ArrayList<>();
    private ArrayList<Turma> turmasCadastradas = new ArrayList<>();

    public void executar() {
        int opcao;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Inserir Aluno na Turma");
            System.out.println("3. Remover Aluno da Turma");
            System.out.println("4. Listar Alunos da Turma");
            System.out.println("5. Remover todos Alunos da Turma");
            System.out.println("6. Criar nova Turma");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    inserirAlunoNaTurma();
                    break;
                case 3:
                    removerAlunoNaTurma();
                    break;
                case 4:
                    listarAlunosDaTurma();
                    break;
                case 5:
                    removerTodosAlunosDaTurma();
                    break;
                case 6:
                    criarNovaTurma();
                    break;
                case 9:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 9);
    }

    public void cadastrarAluno() {
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF do aluno: ");
        String cpf = scanner.nextLine();

        Aluno aluno = new Aluno(nome, cpf);
        alunosCadastrados.add(aluno);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    public void inserirAlunoNaTurma() {
        System.out.print("Digite o código da turma: ");
        String codigo = scanner.nextLine();
        Turma turma = buscarTurmaPorCodigo(codigo);

        if (turma != null) {
            System.out.print("Digite o CPF do aluno a ser inserido: ");
            String cpf = scanner.nextLine();

            Aluno aluno = buscarAlunoPorCpf(cpf);
            if (aluno != null) {
                turma.adicionarAluno(aluno);
            } else {
                System.out.println("Aluno não encontrado.");
            }
        } else {
            System.out.println("Turma não encontrada.");
        }
    }

    public void removerAlunoNaTurma() {
        System.out.print("Digite o código da turma: ");
        String codigo = scanner.nextLine();
        Turma turma = buscarTurmaPorCodigo(codigo);

        if (turma != null) {
            System.out.print("Digite o CPF do aluno a ser removido: ");
            String cpf = scanner.nextLine();

            Aluno aluno = buscarAlunoPorCpf(cpf);
            if (aluno != null) {
                turma.removerAluno(aluno);
            } else {
                System.out.println("Aluno não encontrado.");
            }
        } else {
            System.out.println("Turma não encontrada.");
        }
    }

    public void listarAlunosDaTurma() {
        System.out.print("Digite o código da turma: ");
        String codigo = scanner.nextLine();
        Turma turma = buscarTurmaPorCodigo(codigo);

        if (turma != null) {
            turma.listarAlunos();
        } else {
            System.out.println("Turma não encontrada.");
        }
    }

    public void removerTodosAlunosDaTurma() {
        System.out.print("Digite o código da turma: ");
        String codigo = scanner.nextLine();
        Turma turma = buscarTurmaPorCodigo(codigo);

        if (turma != null) {
            turma.removerTodosAlunos();
        } else {
            System.out.println("Turma não encontrada.");
        }
    }

    public void criarNovaTurma() {
        System.out.print("Digite o nome da nova turma: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o código da nova turma: ");
        String codigo = scanner.nextLine();

        Turma novaTurma = new Turma(nome, codigo);
        turmasCadastradas.add(novaTurma);
        System.out.println("Nova turma criada com sucesso!");
    }

    public Turma buscarTurmaPorCodigo(String codigo) {
        for (Turma turma : turmasCadastradas) {
            if (turma.getCodigo().equals(codigo)) {
                return turma;
            }
        }
        return null;
    }

    public Aluno buscarAlunoPorCpf(String cpf) {
        for (Aluno aluno : alunosCadastrados) {
            if (aluno.getCpf().equals(cpf)) {
                return aluno;
            }
        }
        return null;
    }
}
