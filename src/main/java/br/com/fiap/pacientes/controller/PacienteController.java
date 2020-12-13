package br.com.fiap.pacientes.controller;

import br.com.fiap.pacientes.dto.PacienteDTO;
import br.com.fiap.pacientes.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    private  final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PacienteDTO> create(@RequestBody PacienteDTO pacienteDTO){

        try {
            return new ResponseEntity(pacienteService.create(pacienteDTO),
                    HttpStatus.OK);
        }catch( Exception e ){
            return new ResponseEntity("Não foi possivel criar o registro",
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("{cpf}")
    public ResponseEntity<PacienteDTO> findByCpf(@PathVariable String cpf){
        try {
            return new ResponseEntity(pacienteService.findByCpf(cpf),
                    HttpStatus.OK);
        }catch( Exception e ){
            return new ResponseEntity("Nenhum registro encontrado!",
                    HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("{cpf}")
    public ResponseEntity<String> atualizaDataAlta(@PathVariable String cpf, @RequestBody PacienteDTO pacienteDTO){
        try {
            pacienteService.update(pacienteDTO, cpf);
            return new ResponseEntity("Registro Atualizado",
                    HttpStatus.OK);
        }catch( Exception e ){
            return new ResponseEntity("Nenhum registro encontrado!",
                    HttpStatus.NOT_FOUND);
        }
    }

}
