package wk.technology.test.imccalc.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;
import wk.technology.test.imccalc.domain.enums.MensagemErro;

public class ErroConsulta  extends ErrorGeneric {


    private String code;
    @JsonIgnore
    private Exception exception;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ErroConsulta(MensagemErro meErroCadastroJson, HttpStatus badRequest, String s, WKException ex) {

    }

    public ErroConsulta(String codigo, String tipo, String title, HttpStatus httpStatus, String detail, String uri ) {
        this.setCode(codigo);
        this.setType(tipo);
        this.setTitle(title);
        this.setStatus(String.valueOf(httpStatus.value()));
        this.setDetail(detail);
        this.setInstance(uri);
    }

    public ErroConsulta(String mensagem, String codigo, HttpStatus httpStatus, String detail, String uri, Exception ex) {
        this.setCode(codigo);
        this.setType("");
        this.setTitle(mensagem);
        this.setStatus(String.valueOf(httpStatus.value()));
        this.setDetail(detail);
        this.setInstance(uri);
        this.setException(ex);
    }

    public ErroConsulta(MensagemErro mensagem, HttpStatus httpStatus, String detail, String uri, Exception ex) {
        if(mensagem != null){
            this.setCode(mensagem.getCodigo());
            this.setType(mensagem.getTipo());
            this.setTitle(mensagem.getDescricao());
        }else{
            this.setCode(String.valueOf(httpStatus.value()));
            this.setTitle(ex.getMessage());
        }
        this.setStatus(String.valueOf(httpStatus.value()));
        this.setDetail(detail);
        this.setInstance(uri);
        this.setException(ex);
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }


    @Override
    public String toString(){
        return
                "\ncode:" + this.getCode() +"\n" +
                        "type:" + this.getType() +"\n" +
                        "title:" + this.getTitle() +"\n" +
                        "status:" + this.getStatus() +"\n" +
                        "detail:" + this.getException()+"\n" +
                        "instance:" + this.getInstance();
    }

}
