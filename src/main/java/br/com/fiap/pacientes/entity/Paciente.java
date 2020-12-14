package br.com.fiap.pacientes.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@Document(collection = "pacientes")
public class Paciente {

    @Id
    private String id;

    private String cpf;

    private LocalDate dataNascimento;

    private String telefoneContato;

    private List<String> sintomas;

    private String nome;

    private LocalDate dataInternacao;

    private LocalDate dataAlta;

    private Integer status;

}
