import java.util.ArrayList;
import java.util.Scanner;

public class Turma {
    private ArrayList<Aluno> alunos;
    private String nome;
    private String codigo;

    public Turma(String nome, String codigo) {
        this.alunos = new ArrayList<>();
        this.nome = nome;
        this.codigo = codigo;
    }

    // Métodos de adicionar/remover/listar alunos
    public void adicionarAluno(Aluno aluno) {
        int anoAtual = java.time.Year.now().getValue();
        String novoRga = nome + "/" + anoAtual + "-" + aluno.getCpf();
        aluno.matricular(novoRga);
        alunos.add(aluno);
    }

    public void removerAluno(int indice) {
        if (indice >= 0 && indice < alunos.size()) {
            alunos.remove(indice); 
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void removerAluno(Aluno aluno) {
        if (alunos.remove(aluno)) {
            System.out.println("Aluno removido com sucesso.");
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    public void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno matriculado.");
        } else {
            for (int i = 0; i < alunos.size(); i++) {
                Aluno aluno = alunos.get(i);
                System.out.println("Posição do ArrayList [" + i + "] " + aluno.getNome() + "/" + aluno.getRga());
            }
        }
    }

    // Método para remover todos os alunos
    public void removerTodosAlunos() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Você tem certeza que deseja remover todos os alunos da turma?");
        System.out.println("1. Sim");
        System.out.println("2. Não");
        int escolha = scanner.nextInt();
        if (escolha == 1) {
            alunos.clear();
            System.out.println("Todos os alunos foram removidos.");
        } else {
            System.out.println("Ação cancelada.");
        }
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
