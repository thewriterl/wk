package wk.technology.test.imccalc.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import wk.technology.test.imccalc.domain.Paciente;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class IMCAgeRangeDTO {

    private List<Paciente> pacientes;
    private Double IMCmedio;

    public IMCAgeRangeDTO() {
        super();
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public Double getIMCmedio() {
        return IMCmedio;
    }

    public void setIMCmedio(Double IMCmedio) {
        this.IMCmedio = IMCmedio;
    }
}
