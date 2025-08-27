package ucb.aplicacao.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Tarefas {

   private Long id;
   private String titulo;
   private String descricao;
   private boolean completa;
   private LocalDateTime dataAgora;


   public Tarefas() {
       this.dataAgora = LocalDateTime.now();
       this.completa = false;
   }

   public Tarefas (String titulo) {
       this();
       this.titulo = titulo;
   }

    public Tarefas(Long id, String titulo, String descricao, boolean completa, LocalDateTime dataAgora) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.completa = completa;
        this.dataAgora = dataAgora;
    }
}
