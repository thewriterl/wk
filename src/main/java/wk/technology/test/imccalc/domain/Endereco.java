package wk.technology.test.imccalc.domain;

import javax.persistence.*;
import java.security.AllPermission;

@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="endereco")
    public String endereco;

    @Column(name="numero")
    public Integer numero;

    @Column(name="bairro")
    public String bairro;

    @Column(name="cidade")
    public String cidade;

    @Column(name="cep")
    public String cep;

    @OneToOne(cascade = CascadeType.ALL)
    public Estado estado;

    public Endereco() {
        super();
    }

    public Endereco(Long id, String endereco, Integer numero, String bairro, String cidade, String cep, Estado estado) {
        this.setId(id);
        this.setEndereco(endereco);
        this.setNumero(numero);
        this.setBairro(bairro);
        this.setCidade(cidade);
        this.setCep(cep);
        this.setEstado(estado);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
