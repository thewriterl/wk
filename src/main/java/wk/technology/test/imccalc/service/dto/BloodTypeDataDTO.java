package wk.technology.test.imccalc.service.dto;

public class BloodTypeDataDTO {

    private String tipoSanguineo;
    private Double ageRate;

    public BloodTypeDataDTO() {
        super();
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public Double getAgeRate() {
        return ageRate;
    }

    public void setAgeRate(Double ageRate) {
        this.ageRate = ageRate;
    }
}
