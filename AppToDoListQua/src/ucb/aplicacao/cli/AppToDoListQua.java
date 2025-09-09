package ucb.aplicacao.cli;
import ucb.aplicacao.model.Tarefas;
import ucb.aplicacao.service.TarefasService;

import java.util.Scanner;


public class AppToDoListQua {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TarefasService tarefa = new TarefasService();
        while (true) {
            System.out.println("\n====App to Do List ====\n");
            System.out.println("Opção 1: Criar tarefa");
            System.out.println("Opção 2: Listar tarefa");
            System.out.println("Opção 3: Atualizar tarefa");
            System.out.println("Opção 4: Remover tarefa");
            System.out.println("Opção 5: Marcar tarefa como concluída");
            System.out.println("Opção 6: Sair");
            System.out.println("Escolha uma opção: ");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.println("Digite o titulo da tarefa: ");
                    String titulo = sc.nextLine();
                    System.out.println("Digite o descricao da tarefa: ");
                    String descricao = sc.nextLine();
                    tarefa.criarTarefa(titulo, descricao);
                    System.out.println("Tarefa criada com sucesso!");
                }
                case 2 -> {
                    System.out.println("\n=== Lista de Tarefas ===");
                    for (Tarefas t : tarefa.getTarefas()) {
                        System.out.println("ID: " + t.getId() + " - " + t.getTitulo() + 
                                         " - " + t.getDescricao() + 
                                         " - Completa: " + (t.isCompleta() ? "Sim" : "Não"));
                    }
                }
                case 3 -> {
                    System.out.println("Funcionalidade de atualizar tarefa ainda não implementada.");
                }
                case 4 -> {
                    System.out.print("Digite o ID da tarefa que deseja remover: ");
                    Long idRemover = sc.nextLong();
                    if (tarefa.removerTarefa(idRemover)) {
                        System.out.println("Tarefa removida!");
                    } else {
                        System.out.println("Tarefa não encontrada.");
                    }
                    break;
                }
                case 5 -> {
                    System.out.println("Digite o ID da tarefa para marcar como concluída: ");
                    Long id = sc.nextLong();
                    if (tarefa.marcarComoCompleta(id)) {
                        System.out.println("Tarefa marcada como concluída com sucesso!");
                    } else {
                        System.out.println("Tarefa não encontrada!");
                    }
                }
                case 6 -> {
                    System.out.println("Saindo do sistema...");
                    System.exit(0);
                }
                default -> {
                    System.out.println("Opção inválida!");
                }
            }

        }
    }
}
