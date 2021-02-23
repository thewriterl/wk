package wk.technology.test.imccalc.utils;

import org.springframework.http.HttpStatus;
import org.zalando.problem.AbstractThrowableProblem;
import wk.technology.test.imccalc.domain.enums.MensagemErro;


public class WKException extends AbstractThrowableProblem {

    private static final long serialVersionUID = 1L;
    private MensagemErro messageCustom;
    private String codigo;
    private HttpStatus httpStatus;

    public WKException(String message) {
        super(ErrorConstants.DEFAULT_TYPE, message);
    }

    public WKException(String message, String codigo) {
        super(ErrorConstants.DEFAULT_TYPE, message);
        this.setCodigo(codigo);
    }

    public WKException(MensagemErro message) {
        super(ErrorConstants.DEFAULT_TYPE, message.getDescricao());
        this.setMessageCustom(message);
    }

    public WKException(MensagemErro message, String adendoDescricao) {
        super(ErrorConstants.DEFAULT_TYPE, message.getDescricao() + " (" + adendoDescricao + ")");
        this.setMessageCustom(message);
    }

    public WKException(MensagemErro message, HttpStatus httpStatus) {
        super(ErrorConstants.DEFAULT_TYPE, message.getDescricao());
        this.setMessageCustom(message);
        this.setHttpStatus(httpStatus);
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public MensagemErro getMessageCustom() {
        return messageCustom;
    }

    public void setMessageCustom(MensagemErro messageCustom) {
        this.messageCustom = messageCustom;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
