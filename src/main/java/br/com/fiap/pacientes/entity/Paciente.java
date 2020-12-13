package br.com.fiap.pacientes.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "Pacientes")
public class Paciente {

    @Id
    private String id;

    private String cpf;

    private LocalDate dataNascimento;

    private int telefoneContato;

    private String sintomas;

    private String nome;

    private LocalDate dataInternacao;

    private LocalDate dataAlta;

}
