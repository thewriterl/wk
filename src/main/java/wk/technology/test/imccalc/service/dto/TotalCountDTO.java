package wk.technology.test.imccalc.service.dto;

public class TotalCountDTO {

    private Integer total;

    public TotalCountDTO(Integer size) {
        this.setTotal(size);
    }

    public TotalCountDTO() {
        super();
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
