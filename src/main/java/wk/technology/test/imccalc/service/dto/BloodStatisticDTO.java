package wk.technology.test.imccalc.service.dto;

import java.util.List;

public class BloodStatisticDTO {

    private List<BloodTypeDTO> details;
    private Integer aptosADoar;
    private Integer totalPacientes;

    public BloodStatisticDTO() {
        super();
    }

    public BloodStatisticDTO(List<BloodTypeDTO> details, Integer aptosADoar, Integer totalPacientes) {
        this.details = details;
        this.aptosADoar = aptosADoar;
        this.totalPacientes = totalPacientes;
    }

    public List<BloodTypeDTO> getDetails() {
        return details;
    }

    public void setDetails(List<BloodTypeDTO> details) {
        this.details = details;
    }

    public Integer getAptosADoar() {
        return aptosADoar;
    }

    public void setAptosADoar(Integer aptosADoar) {
        this.aptosADoar = aptosADoar;
    }

    public Integer getTotalPacientes() {
        return totalPacientes;
    }

    public void setTotalPacientes(Integer totalPacientes) {
        this.totalPacientes = totalPacientes;
    }
}
