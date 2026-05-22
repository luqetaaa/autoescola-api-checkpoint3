package br.com.fiap.autoescola.entity;

import br.com.fiap.autoescola.enums.Especialidade;
import br.com.fiap.autoescola.vo.EnderecoVO;
import jakarta.persistence.*;

@Entity
@Table(name = "instrutores")
public class Instrutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String cnh;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private EnderecoVO endereco;

    private Boolean ativo = true;

    public Instrutor() {}

    public Instrutor(String nome, String email, String telefone, String cnh, Especialidade especialidade, EnderecoVO endereco) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cnh = cnh;
        this.especialidade = especialidade;
        this.endereco = endereco;
        this.ativo = true;
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getCnh() { return cnh; }
    public Especialidade getEspecialidade() { return especialidade; }
    public EnderecoVO getEndereco() { return endereco; }
    public void setEndereco(EnderecoVO endereco) { this.endereco = endereco; }
    public Boolean getAtivo() { return ativo; }
    public void inativar() { this.ativo = false; }
}
