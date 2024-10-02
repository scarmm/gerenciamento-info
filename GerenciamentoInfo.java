import java.util.ArrayList;
import java.util.Scanner;

public class GerenciamentoInfo {

    public static void main(String[] args) {
        int opt = 0;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Professor> professores = new ArrayList<>();
        ArrayList<Curso> cursos = new ArrayList<>();
        ArrayList<Aluno> alunos = new ArrayList<>();

        try {
            do {
                System.out.println("Opções: ");
                System.out.println("1 - Cadastrar Professor");
                System.out.println("2 - Cadastrar Curso");
                System.out.println("3 - Cadastrar Aluno");
                System.out.println("4 - Listar Professores");
                System.out.println("5 - Listar Cursos");
                System.out.println("6 - Listar Alunos");
                System.out.println("7 - Sair...");
                
                try {
                    opt = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("Opção inválida");
                    scanner.nextLine();
                    continue;
                }
                
                switch (opt) {
                    case 1: {
                        System.out.println("Digite o Id do professor: ");
                        int IdProfessor = scanner.nextInt();
                        System.out.println("Digite o nome do professor: ");
                        String nomeProfessor = scanner.next();
                        System.out.println("Digite o departamento do professor: ");
                        String departamento = scanner.next();
                        
                        Professor professor = new Professor(IdProfessor, nomeProfessor, departamento);
                        professores.add(professor);
                        break;
                    }

                    case 2: {
                        System.out.println("Digite o Id do curso: ");
                        int IdCurso = scanner.nextInt();
                        System.out.println("Digite o nome do curso: ");
                        String nomeCurso = scanner.next();
                        System.out.println("Digite a carga horária do curso: ");
                        int cargaHoraria = scanner.nextInt();
                        System.out.println("Digite o Id do professor responsável: ");
                        int IdProfessor = scanner.nextInt();

                        Curso curso = new Curso(IdCurso, nomeCurso, cargaHoraria, IdProfessor);
                        cursos.add(curso);
                        break;
                    }

                    case 3: {
                        System.out.println("Digite o Id do aluno: ");
                        int IdAluno = scanner.nextInt();
                        System.out.println("Digite o nome do aluno: ");
                        String nomeAluno = scanner.next();
                        System.out.println("Digite a data de nascimento do aluno: ");
                        String dtNasc = scanner.next();
                        System.out.println("Digite o CPF do aluno: ");
                        String CPF = scanner.next();
                        System.out.println("Digite o Id do curso: ");
                        int IdCurso = scanner.nextInt();

                        Aluno aluno = new Aluno(IdAluno, nomeAluno, dtNasc, CPF, IdCurso);
                        alunos.add(aluno);
                        break;
                    }

                    case 4: {
                        for (Professor professor : professores) {
                            int contadorCursos = 0;
                            for (Curso curso : cursos) {
                                if (curso.IdProfessor == professor.IdProfessor) {
                                    contadorCursos++;
                                }
                            }
                            System.out.println("Id: " + professor.IdProfessor);
                            System.out.println("Nome: " + professor.nomeProfessor);
                            System.out.println("Departamento: " + professor.departamento);
                            System.out.println("Número de cursos: " + contadorCursos);
                        }
                        break;
                    }

                    case 5: {
                        for (Curso curso : cursos) {
                            Professor professorResponsavel = null; //null, !=null, = null serve para verificar se um objeto não é nulo.
                            for (Professor professor : professores) {
                                if (curso.IdProfessor == professor.IdProfessor) {
                                    professorResponsavel = professor;
                                    break;
                                }
                            }
                            System.out.println("Id: " + curso.Idcurso);
                            System.out.println("Nome do curso: " + curso.nomeCurso);
                            System.out.println("Carga horária: " + curso.cargaHoraria);
                            if (professorResponsavel != null) {
                                System.out.println("Professor responsável: " + professorResponsavel.nomeProfessor);
                            } else {
                                System.out.println("Professor responsável: Não encontrado");
                            }
                        }
                        break;
                    }

                    case 6: {
                        for (Aluno aluno : alunos) {
                            Curso cursoDoAluno = null;
                            for (Curso curso : cursos) {
                                if (aluno.Idcurso == curso.Idcurso) {
                                    cursoDoAluno = curso;
                                    break;
                                }
                            }
                            System.out.println("Id: " + aluno.IdAluno);
                            System.out.println("Nome: " + aluno.nomeAluno);
                            System.out.println("Data de nascimento: " + aluno.dtNasc);
                            System.out.println("CPF: " + aluno.CPF);
                            if (cursoDoAluno != null) {
                                System.out.println("Curso: " + cursoDoAluno.nomeCurso);
                            } else {
                                System.out.println("Curso: Não encontrado");
                            }
                        }
                        break;
                    }

                    case 7:
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            } while (opt != 7);

        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
