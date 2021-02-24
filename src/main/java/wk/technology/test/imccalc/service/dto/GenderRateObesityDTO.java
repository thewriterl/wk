package wk.technology.test.imccalc.service.dto;

import wk.technology.test.imccalc.domain.enums.PacienteSexo;

public class GenderRateObesityDTO {

    private Integer total;
    private Float percentage;
    private PacienteSexo genero;

    public GenderRateObesityDTO() {
        super();
    }

    public GenderRateObesityDTO(Integer total, Float percentage, PacienteSexo genero) {
        this.setTotal(total);
        this.setPercentage(percentage);
        this.setGenero(genero);
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }

    public PacienteSexo getGenero() {
        return genero;
    }

    public void setGenero(PacienteSexo genero) {
        this.genero = genero;
    }
}
