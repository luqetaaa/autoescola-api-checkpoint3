package br.com.fiap.autoescola.service;

import br.com.fiap.autoescola.dto.*;
import br.com.fiap.autoescola.entity.Instrutor;
import br.com.fiap.autoescola.exception.RecursoNaoEncontradoException;
import br.com.fiap.autoescola.exception.RegraNegocioException;
import br.com.fiap.autoescola.repository.InstrutorRepository;
import br.com.fiap.autoescola.vo.EnderecoVO;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class InstrutorService {

    private final InstrutorRepository repository;

    public InstrutorService(InstrutorRepository repository) {
        this.repository = repository;
    }

    public InstrutorDetalhesDTO cadastrar(InstrutorCadastroDTO dto) {
        if (repository.existsByEmail(dto.email())) {
            throw new RegraNegocioException("Já existe instrutor cadastrado com este e-mail");
        }
        if (repository.existsByCnh(dto.cnh())) {
            throw new RegraNegocioException("Já existe instrutor cadastrado com esta CNH");
        }

        Instrutor instrutor = new Instrutor(dto.nome(), dto.email(), dto.telefone(), dto.cnh(), dto.especialidade(), converterEndereco(dto.endereco()));
        return new InstrutorDetalhesDTO(repository.save(instrutor));
    }

    public Page<InstrutorListagemDTO> listar(int page) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by("nome").ascending());
        return repository.findByAtivoTrue(pageable).map(InstrutorListagemDTO::new);
    }

    public InstrutorDetalhesDTO buscarPorId(Long id) {
        return new InstrutorDetalhesDTO(buscarEntidade(id));
    }

    public InstrutorDetalhesDTO atualizar(Long id, InstrutorAtualizacaoDTO dto) {
        Instrutor instrutor = buscarEntidade(id);
        instrutor.setNome(dto.nome());
        instrutor.setTelefone(dto.telefone());
        instrutor.setEndereco(converterEndereco(dto.endereco()));
        return new InstrutorDetalhesDTO(repository.save(instrutor));
    }

    public void excluir(Long id) {
        Instrutor instrutor = buscarEntidade(id);
        instrutor.inativar();
        repository.save(instrutor);
    }

    private Instrutor buscarEntidade(Long id) {
        return repository.findById(id)
                .filter(Instrutor::getAtivo)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Instrutor não encontrado"));
    }

    private EnderecoVO converterEndereco(EnderecoDTO dto) {
        return new EnderecoVO(dto.logradouro(), dto.numero(), dto.complemento(), dto.bairro(), dto.cidade(), dto.uf(), dto.cep());
    }
}
