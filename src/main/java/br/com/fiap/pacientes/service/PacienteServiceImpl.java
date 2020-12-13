package br.com.fiap.pacientes.service;

import br.com.fiap.pacientes.dto.PacienteDTO;
import br.com.fiap.pacientes.entity.Paciente;
import br.com.fiap.pacientes.repository.PacienteRepository;
import org.springframework.stereotype.Service;

@Service
public class PacienteServiceImpl implements  PacienteService{

    private final PacienteRepository pacienteRepository;

    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public PacienteDTO create(PacienteDTO pacienteDTO) {
        Paciente paciente = new Paciente();

        paciente.setCpf(pacienteDTO.getCpf());
        paciente.setDataNascimento(pacienteDTO.getDataNascimento());
        paciente.setTelefoneContato(pacienteDTO.getTelefoneContato());
        paciente.setSintomas(pacienteDTO.getSintomas());
        paciente.setDataInternacao(pacienteDTO.getDataInternacao());
        paciente.setDataNascimento(pacienteDTO.getDataNascimento());
        paciente.setNome(pacienteDTO.getNome());

        Paciente savedPaciente = pacienteRepository.save(paciente);

        return new PacienteDTO(savedPaciente);

    }

    @Override
    public PacienteDTO update(PacienteDTO pacienteDTO, String cpf) throws Exception {
        Paciente paciente = pacienteRepository.findByCpf(cpf);

        if (paciente != null) {
            paciente.setDataAlta(pacienteDTO.getDataAlta());

            pacienteRepository.save(paciente);

            return pacienteDTO;
        }else {
            throw new Exception();
        }
    }

    @Override
    public PacienteDTO findByCpf(String cpf) {
        return new PacienteDTO(
                pacienteRepository.findByCpf(cpf)
        );
    }
}
