package br.com.fiap.pacientes.controller;

import br.com.fiap.pacientes.dto.PacienteDTO;
import br.com.fiap.pacientes.exception.PacienteNotFoundException;
import br.com.fiap.pacientes.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public ResponseEntity<PacienteDTO> create(@RequestBody PacienteDTO pacienteDTO) {
        PacienteDTO dto = this.pacienteService.create(pacienteDTO);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();

        return ResponseEntity.created(location)
                .body(dto);
    }

    @GetMapping
    public ResponseEntity<List<PacienteDTO>> findAll() {
        return ResponseEntity.ok(this.pacienteService.findAll());
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<PacienteDTO> findByCpf(@PathVariable String cpf) {
        PacienteDTO dto;

        try {
            dto = this.pacienteService.findByCpf(cpf);
        } catch (PacienteNotFoundException e) {
            return ResponseEntity.notFound()
                    .build();
        }

        return ResponseEntity.ok(dto);
    }


    @PutMapping("/{cpf}")
    public ResponseEntity<PacienteDTO> atualizaDataAlta(@PathVariable String cpf, @RequestBody PacienteDTO pacienteDTO) throws Exception {
        return new ResponseEntity<>(this.pacienteService.update(pacienteDTO, cpf), HttpStatus.NO_CONTENT);
    }

}
