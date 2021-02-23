package wk.technology.test.imccalc.domain;

import wk.technology.test.imccalc.domain.enums.MensagemErro;
import wk.technology.test.imccalc.domain.enums.PacienteSexo;
import wk.technology.test.imccalc.service.dto.PacienteDemoDTO;
import wk.technology.test.imccalc.utils.WKException;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome")
    public String nome;

    @Column(name="cpf")
    public String cpf;

    @Column(name="rg")
    public String rg;

    @Column(name="data_nascimento")
    public Date dataNascimento;

    @Column(name="sexo")
    @Enumerated(EnumType.STRING)
    public PacienteSexo sexo;

    @Column(name="mae")
    public String mae;

    @Column(name="pai")
    public String pai;

    @Column(name="email")
    public String email;

    @Column(name="telefone_fixo")
    public String telefoneFixo;

    @Column(name="celular")
    public String celular;

    @Column(name="altura")
    public Float altura;

    @Column(name="peso")
    public Integer peso;

    @Column(name="tipo_sanguineo")
    public String tipoSanguineo;

    @OneToOne(cascade = CascadeType.ALL)
    public Endereco endereco;

    public Paciente() {
        super();
    }

    public Paciente(PacienteDemoDTO dto) {
        this.setId(null);
        this.setNome(dto.getNome());
        this.setCpf(dto.getCpf());
        this.setRg(dto.getRg());
        this.setSexo(getPacienteSexo(dto.getSexo()));
        this.setMae(dto.getMae());
        this.setPai(dto.getPai());
        this.setEmail(dto.getEmail());
        this.setTelefoneFixo(dto.getTelefoneFixo());
        this.setCelular(dto.getCelular());
        this.setAltura(dto.getAltura());
        this.setPeso(dto.getPeso());
        this.setTipoSanguineo(dto.getTipoSanguineo());
        this.setEndereco(new Endereco(null, dto.getEndereco(), dto.getNumero(), dto.getBairro(), dto.getCidade(), dto.getCep(), new Estado(null, getEstadoForUF(dto.getEstado()), dto.getEstado())));
        try {
            this.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse(dto.getDataNasc()));
        } catch (ParseException ignored) { }

    }

    private static String getEstadoForUF(String uf) {
        switch (uf) {
            case "RO":
                return "Rondonia";
            case "AC":
                return  "Acre";
            case "AM":
                return "Amazonas";
            case "RR":
                return "Roraima";
            case "PA":
                return "Pará";
            case "AP":
                return "Amapá";
            case "TO":
                return "Tocantins";
            case "MA":
                return "Maranhão";
            case "PI":
                return "Piauí";
            case "CE":
                return "Ceará";
            case "RN":
                return "Rio Grande do Norte";
            case "PB":
                return "Paraíba";
            case "PE":
                return "Pernambuco";
            case "AL":
                return "Alagoas";
            case "SE":
                return "Sergipe";
            case "BA":
                return "Bahia";
            case "MG":
                return "Minas Gerais";
            case "ES":
                return "Espírito Santo";
            case "RJ":
                return "Rio de Janeiro";
            case "SP":
                return "São Paulo";
            case "PR":
                return "Paraná";
            case "SC":
                return "Santa Catarina";
            case "RS":
                return "Rio Grande do Sul";
            case "MS":
                return "Mato Grosso do Sul";
            case "MT":
                return "Mato Grosso";
            case "GO":
                return "Goiás";
            case "DF":
                return "Distrito Federal";
                default:
                    throw new WKException(MensagemErro.UNIDADE_FEDERATIVA_NAO_ENCONTRADA);
        }
    }

    private static PacienteSexo getPacienteSexo(String sexo) {
        switch (sexo) {
            case "Masculino":
                return PacienteSexo.MASCULINO;
            case "Feminino":
                return PacienteSexo.FEMININO;
            default:
                return PacienteSexo.INDEFINIDO;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNasc) {
        this.dataNascimento = dataNasc;
    }

    public PacienteSexo getSexo() {
        return sexo;
    }

    public void setSexo(PacienteSexo sexo) {
        this.sexo = sexo;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
