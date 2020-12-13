package br.com.fiap.pacientes.dto;

import br.com.fiap.pacientes.entity.Paciente;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class PacienteDTO {

    private String cpf;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    private int telefoneContato;

    private String sintomas;
    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInternacao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAlta;

    public PacienteDTO() { };

    public PacienteDTO(Paciente paciente) {
        this.cpf = paciente.getCpf();;
        this.telefoneContato = paciente.getTelefoneContato();
        this.dataAlta = paciente.getDataAlta();
        this.dataInternacao = paciente.getDataInternacao();
        this.dataNascimento = paciente.getDataNascimento();
        this.sintomas = paciente.getSintomas();
        this.nome   = paciente.getNome();
    }

}
