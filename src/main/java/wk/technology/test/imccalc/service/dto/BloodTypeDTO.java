package wk.technology.test.imccalc.service.dto;

public class BloodTypeDTO {

    private String tipoSanguineo;
    private Integer total;
    private Integer doadores;

    public BloodTypeDTO() {
        super();
    }

    public BloodTypeDTO(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
        this.setTotal(0);
        this.setDoadores(0);
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getDoadores() {
        return doadores;
    }

    public void setDoadores(Integer doadores) {
        this.doadores = doadores;
    }
}
