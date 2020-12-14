package br.com.fiap.pacientes.mapper;

import br.com.fiap.pacientes.dto.PacienteDTO;
import br.com.fiap.pacientes.entity.Paciente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PacienteMapper {

    PacienteMapper INSTANCE = Mappers.getMapper(PacienteMapper.class);

    PacienteDTO toDto(Paciente paciente);

    Paciente toModel(PacienteDTO pacienteDTO);

}
