package wk.technology.test.imccalc.service.dto;

public class EstadoEstatisticDTO {

    private String estado;
    private Integer total;

    public EstadoEstatisticDTO() {
        super();
    }

    public EstadoEstatisticDTO(String estado, Integer total) {
        this.estado = estado;
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
