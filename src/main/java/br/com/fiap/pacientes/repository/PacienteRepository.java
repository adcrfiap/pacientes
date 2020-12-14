package br.com.fiap.pacientes.repository;

import br.com.fiap.pacientes.entity.Paciente;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PacienteRepository extends MongoRepository<Paciente, String> {

    Optional<Paciente> findByCpf(String cpf);

}
