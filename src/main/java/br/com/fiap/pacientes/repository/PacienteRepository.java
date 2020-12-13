package br.com.fiap.pacientes.repository;

import br.com.fiap.pacientes.entity.Paciente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PacienteRepository extends MongoRepository<Paciente, String> {

    Paciente findByCpf(String cpf);

}
