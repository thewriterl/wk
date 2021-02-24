package wk.technology.test.imccalc.service.dto;

public class BloodTypeDTO {

    private String tipoSanguineo;
    private Integer totalTipoSanguineo;
    private Integer podeReceber;
    private Integer podeDoar;

    public BloodTypeDTO() {
        super();
    }

    public BloodTypeDTO(String tipoSanguineo, Integer podeDoar, Integer podeReceber, Integer totalTipoSanguineo) {
        this.setPodeReceber(podeDoar);
        this.setPodeDoar(podeReceber);
        this.setTotalTipoSanguineo(totalTipoSanguineo);
        this.setTipoSanguineo(tipoSanguineo);
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public Integer getTotalTipoSanguineo() {
        return totalTipoSanguineo;
    }

    public void setTotalTipoSanguineo(Integer totalTipoSanguineo) {
        this.totalTipoSanguineo = totalTipoSanguineo;
    }

    public Integer getPodeReceber() {
        return podeReceber;
    }

    public void setPodeReceber(Integer podeReceber) {
        this.podeReceber = podeReceber;
    }


    public void setPodeDoar(Integer podeDoar) {
        this.podeDoar = podeDoar;
    }

    public Integer getPodeDoar() {
        return podeDoar;
    }
}
