package wk.technology.test.imccalc.domain.enums;

public enum MensagemErro {

    ME_ERRO_CADASTRO_JSON                    ("MGE_001","Erro ao cadastrar Dados do JSON", ""),
    UNIDADE_FEDERATIVA_NAO_ENCONTRADA        ("mge_002", "Erro ao parse Estado", "NonValueExpected"),
    ME_ERRO_AO_OBTER_ESTATISTICAS            ("ME_003", "Erro ao Obter Estatísticas0", "");


    private String codigo;
    private String descricao;
    private String tipo;

    MensagemErro(final String codigo) {
        this.codigo = codigo;
    }

    MensagemErro(final String codigo, final String descricao, String tipo) {
        this(codigo);
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getTipo() {
        return tipo;
    }

}
