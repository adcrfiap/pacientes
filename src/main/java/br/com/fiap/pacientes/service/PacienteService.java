package br.com.fiap.pacientes.service;

import br.com.fiap.pacientes.dto.PacienteDTO;

public interface PacienteService {

        PacienteDTO create(PacienteDTO pacienteDTO);
        PacienteDTO update(PacienteDTO pacienteDTO, String cpf) throws Exception;
        PacienteDTO findByCpf(String cpf);

}
