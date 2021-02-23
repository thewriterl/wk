package wk.technology.test.imccalc.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "estado")
public class Estado {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "uf")
    private String uf;

    public Estado() {
        super();
    }

    public Estado(Long id, String estado, String uf) {
        this.id = id;
        this.estado = estado;
        this.uf = uf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return uf.equals(estado.uf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uf);
    }
}
