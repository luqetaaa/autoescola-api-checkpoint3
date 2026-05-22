package br.com.fiap.autoescola.entity;

import br.com.fiap.autoescola.vo.EnderecoVO;
import jakarta.persistence.*;

@Entity
@Table(name = "alunos")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    @Embedded
    private EnderecoVO endereco;

    private Boolean ativo = true;

    public Aluno() {}

    public Aluno(String nome, String email, String telefone, String cpf, EnderecoVO endereco) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.endereco = endereco;
        this.ativo = true;
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getCpf() { return cpf; }
    public EnderecoVO getEndereco() { return endereco; }
    public void setEndereco(EnderecoVO endereco) { this.endereco = endereco; }
    public Boolean getAtivo() { return ativo; }
    public void inativar() { this.ativo = false; }
}
