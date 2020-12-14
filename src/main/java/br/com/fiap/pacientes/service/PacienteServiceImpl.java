package br.com.fiap.pacientes.service;

import br.com.fiap.pacientes.dto.PacienteDTO;
import br.com.fiap.pacientes.entity.Paciente;
import br.com.fiap.pacientes.exception.PacienteNotFoundException;
import br.com.fiap.pacientes.mapper.PacienteMapper;
import br.com.fiap.pacientes.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PacienteServiceImpl implements PacienteService {

    private final static PacienteMapper PACIENTE_MAPPER = PacienteMapper.INSTANCE;

    private final PacienteRepository pacienteRepository;

    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public PacienteDTO create(PacienteDTO pacienteDTO) {
        Paciente savedPaciente = this.pacienteRepository.save(PACIENTE_MAPPER.toModel(pacienteDTO));
        return PACIENTE_MAPPER.toDto(savedPaciente);
    }

    @Override
    public PacienteDTO update(PacienteDTO pacienteDTO, String cpf) throws PacienteNotFoundException {
        Optional<Paciente> pacienteOptional = this.pacienteRepository.findByCpf(cpf);

        Paciente paciente = PACIENTE_MAPPER.toModel(pacienteDTO);

        if (pacienteOptional.isPresent()) {
            Paciente pacienteEncontrado = pacienteOptional.get();

            pacienteEncontrado.setCpf(paciente.getCpf());
            pacienteEncontrado.setDataNascimento(paciente.getDataNascimento());
            pacienteEncontrado.setTelefoneContato(paciente.getTelefoneContato());
            pacienteEncontrado.setSintomas(paciente.getSintomas());
            pacienteEncontrado.setNome(paciente.getNome());
            pacienteEncontrado.setDataInternacao(paciente.getDataInternacao());
            pacienteEncontrado.setDataAlta(paciente.getDataAlta());
            pacienteEncontrado.setStatus(paciente.getStatus());

            this.pacienteRepository.save(pacienteEncontrado);

            return PACIENTE_MAPPER.toDto(pacienteEncontrado);
        } else {
            throw new PacienteNotFoundException(cpf);
        }
    }

    @Override
    public List<PacienteDTO> findAll() {
        return this.pacienteRepository.findAll()
                .stream()
                .map(PACIENTE_MAPPER::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PacienteDTO findByCpf(String cpf) throws PacienteNotFoundException {
        return this.pacienteRepository.findByCpf(cpf)
                .map(PACIENTE_MAPPER::toDto)
                .orElseThrow(() -> new PacienteNotFoundException(cpf));
    }

}
