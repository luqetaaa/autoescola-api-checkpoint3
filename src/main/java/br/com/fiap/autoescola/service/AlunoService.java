package br.com.fiap.autoescola.service;

import br.com.fiap.autoescola.dto.*;
import br.com.fiap.autoescola.entity.Aluno;
import br.com.fiap.autoescola.exception.RecursoNaoEncontradoException;
import br.com.fiap.autoescola.exception.RegraNegocioException;
import br.com.fiap.autoescola.repository.AlunoRepository;
import br.com.fiap.autoescola.vo.EnderecoVO;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public AlunoDetalhesDTO cadastrar(AlunoCadastroDTO dto) {
        if (repository.existsByEmail(dto.email())) {
            throw new RegraNegocioException("Já existe aluno cadastrado com este e-mail");
        }
        if (repository.existsByCpf(dto.cpf())) {
            throw new RegraNegocioException("Já existe aluno cadastrado com este CPF");
        }

        Aluno aluno = new Aluno(dto.nome(), dto.email(), dto.telefone(), dto.cpf(), converterEndereco(dto.endereco()));
        return new AlunoDetalhesDTO(repository.save(aluno));
    }

    public Page<AlunoListagemDTO> listar(int page) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by("nome").ascending());
        return repository.findByAtivoTrue(pageable).map(AlunoListagemDTO::new);
    }

    public AlunoDetalhesDTO buscarPorId(Long id) {
        return new AlunoDetalhesDTO(buscarEntidade(id));
    }

    public AlunoDetalhesDTO atualizar(Long id, AlunoAtualizacaoDTO dto) {
        Aluno aluno = buscarEntidade(id);
        aluno.setNome(dto.nome());
        aluno.setTelefone(dto.telefone());
        aluno.setEndereco(converterEndereco(dto.endereco()));
        return new AlunoDetalhesDTO(repository.save(aluno));
    }

    public void excluir(Long id) {
        Aluno aluno = buscarEntidade(id);
        aluno.inativar();
        repository.save(aluno);
    }

    private Aluno buscarEntidade(Long id) {
        return repository.findById(id)
                .filter(Aluno::getAtivo)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Aluno não encontrado"));
    }

    private EnderecoVO converterEndereco(EnderecoDTO dto) {
        return new EnderecoVO(dto.logradouro(), dto.numero(), dto.complemento(), dto.bairro(), dto.cidade(), dto.uf(), dto.cep());
    }
}
