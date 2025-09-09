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
