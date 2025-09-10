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
    private Tarefas buscaID(Long id) {
        for (Tarefas tarefa : tarefas) {
            if (tarefa.getId().equals(id)) {
                return tarefa;
            }
        }
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
}

