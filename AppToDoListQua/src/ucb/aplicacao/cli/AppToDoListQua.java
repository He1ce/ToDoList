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
            System.out.println("Opção 5: Sair");
            System.out.println("Escolha uma opção: ");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.println("Digite o titulo da tarefa: ");
                    String titulo = sc.next();
                    System.out.println("Digite o descricao da tarefa: ");
                    String descricao = sc.next();

                }
            }

        }
    }
}
