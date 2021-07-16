package com.marcos.ciss.resource;

import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.marcos.ciss.event.RecursoCriadoEvent;
import com.marcos.ciss.model.Funcionario;
import com.marcos.ciss.repository.FuncionarioRepository;
import com.marcos.ciss.repository.filter.FuncionarioFilter;
import com.marcos.ciss.service.FuncionarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("funcionarios")
@CrossOrigin(origins = { "http://localhost:3000" })
public class FuncionarioResource {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<?> listarFuncionarios(FuncionarioFilter funcionarioFilter, Pageable pageable) {
        Page<Funcionario> response = funcionarioRepository.filtrar(funcionarioFilter, pageable);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Funcionario> salvarFuncionario(@Valid @RequestBody Funcionario funcionario,
            HttpServletResponse response) {
        Funcionario funcionarioSalvo = funcionarioRepository.save(funcionario);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, funcionarioSalvo.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarFuncionarioPeloId(@PathVariable Long id) {
        Optional<Funcionario> funcionarioEncontrado = funcionarioRepository.findById(id);
        return funcionarioEncontrado.isPresent() ? ResponseEntity.ok(funcionarioEncontrado.get())
                : ResponseEntity.notFound().build();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerFuncionario(@PathVariable Long id) {
        this.funcionarioRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizarFuncionario(@PathVariable Long id,
            @Valid @RequestBody Funcionario funcionario) {
        Funcionario funcionarioSalvo = funcionarioService.atualizar(id, funcionario);
        return ResponseEntity.ok(funcionarioSalvo);
    }
}
