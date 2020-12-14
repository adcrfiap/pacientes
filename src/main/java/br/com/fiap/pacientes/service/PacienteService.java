package br.com.fiap.pacientes.service;

import br.com.fiap.pacientes.dto.PacienteDTO;
import br.com.fiap.pacientes.exception.PacienteNotFoundException;

import java.util.List;

public interface PacienteService {

    PacienteDTO create(PacienteDTO pacienteDTO);

    PacienteDTO update(PacienteDTO pacienteDTO, String cpf) throws Exception;

    List<PacienteDTO> findAll();

    PacienteDTO findByCpf(String cpf) throws PacienteNotFoundException;

}
