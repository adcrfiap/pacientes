package br.com.fiap.pacientes.exception;

public class PacienteNotFoundException extends Exception {

    public PacienteNotFoundException(String cpf) {
        super(String.format("Não existe um paciente com o CPF %s informado", cpf));
    }
}
