package com.exercicio_2.demo.Entiny;
import jakarta.persistence.*;

@Entity
@Table(name = "lembretes",schema = "public")
public class LembreteEntiny {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="lembretes")
    private String lembrete;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_id")
    private PessoaEntiny pessoaId;

    public LembreteEntiny(){}

    public LembreteEntiny(Long id, String lembrete, PessoaEntiny pessoaId){
        super();
        this.id = id;
        this.lembrete = lembrete;
        this.pessoaId = pessoaId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLembrete() {
        return lembrete;
    }

    public void setLembrete(String lembrete) {
        this.lembrete = lembrete;
    }

    public PessoaEntiny getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(PessoaEntiny pessoaId) {
        this.pessoaId = pessoaId;
    }
}
