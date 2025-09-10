package ucb.aplicacao.service;

import ucb.aplicacao.model.Tarefas;

import java.util.ArrayList;
import java.util.List;

public class TarefasService {
    private List<Tarefas> tarefas = new ArrayList<>();
    private Long contadorId = 1L;

    public Tarefas criarTarefa(String titulo, String descricao) {
        Tarefas tarefa = new Tarefas(contadorId++, titulo, descricao, false);
        tarefas.add(tarefa);
        return tarefa;
    }

    public List<Tarefas> getTarefas() {
        return tarefas;
    }
  
    public Tarefas atualizarTarefa(Long id, String novoTitulo, String novoDescricao) {
        for (Tarefas tarefa : tarefas) {
            if (tarefa.getId().equals(id)) {
                tarefa.setTitulo(novoTitulo);
                tarefa.setDescricao(novoDescricao);

                System.out.println("Tarefa atualizada com sucesso!");
                return tarefa;
            }
        }
        System.out.println("Tarefa informada não existe, informe outro ID");
        return null;
    }
  
    public Tarefas buscaID(Long id) {
        for (Tarefas tarefa : tarefas) {
            if (tarefa.getId().equals(id)) {
                System.out.println("----------------------------------------");
                System.out.println("Título: " + tarefa.getTitulo());
                System.out.println("Descrição: " + tarefa.getDescricao());
                System.out.println((tarefa.isCompleta()) ? "Status: Completa" : "Status : Incompleta");
                System.out.println("ID: " + tarefa.getId());
                System.out.println("----------------------------------------");
                return tarefa;
            }
        }
        System.out.println("Tarefa não encontrada!");
        return null;

    }

    public boolean removerTarefa(Long id) {
        for (Tarefas t : tarefas) {
            if (t.getId().equals(id)) {
                tarefas.remove(t);
                return true;
            }
        }
        return false;
    }

    public boolean marcarComoCompleta(Long id) {
        for (Tarefas tarefa : tarefas) {
            if (tarefa.getId().equals(id)) {
                tarefa.setCompleta(true);
                return true;
            }
        }
        return false;
    }
}

