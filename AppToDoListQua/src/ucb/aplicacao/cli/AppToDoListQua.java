package ucb.aplicacao.cli;
import ucb.aplicacao.model.Tarefas;
import ucb.aplicacao.service.TarefasService;

import java.util.ArrayList;
import java.util.List;
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
            System.out.println("Opção 4: Marcar como concluída");
            System.out.println("Opção 5: Remover tarefa");
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
                }
                case 2 -> {
                    List<Tarefas> lista_tarefas = tarefa.getTarefas();
                    if(lista_tarefas.isEmpty()){
                        System.out.println("---------------------------");
                        System.out.println("Não há tarefas registradas.");
                        System.out.println("---------------------------");
                    }
                    for (Tarefas tarefa_listada : lista_tarefas) {
                        System.out.println("----------------------------------------");
                        System.out.println("Título: " + tarefa_listada.getTitulo());
                        System.out.println("Descrição: " + tarefa_listada.getDescricao());
                        System.out.println((tarefa_listada.isCompleta()) ? "Status: Completa" : "Status : Incompleta");
                        System.out.println("ID: " + tarefa_listada.getId());
                        System.out.println("----------------------------------------");
                        }

                }
                case 3 -> {
                    System.out.println("Digite o ID da tarefa que você deseja atualizar: ");
                    long idTarefa = sc.nextLong();
                    sc.nextLine();
                    System.out.println("Digite o novo título da tarefa: ");
                    String novoTituloTarefa = sc.nextLine();
                    System.out.println("Digite o novo descricao da tarefa: ");
                    String novoDescricaoTarefa = sc.nextLine();
                    tarefa.atualizarTarefa(idTarefa, novoTituloTarefa, novoDescricaoTarefa);
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
                default -> {
                    System.out.println("O valor inserido é inválido! Tente novamente");
                }
                case 6 -> {
                    System.out.println("Saindo...");
                    System.exit(0);
                }
            }

        }
    }
}
