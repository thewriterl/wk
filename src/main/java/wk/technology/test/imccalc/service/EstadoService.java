package wk.technology.test.imccalc.service;

import wk.technology.test.imccalc.domain.Estado;
import wk.technology.test.imccalc.domain.Paciente;

import java.util.List;

public interface EstadoService {

    List<Estado> cadastrarEstadosJsonDemoWK(List<Paciente> dto);

    Estado getEstadoByUF(String uf);
}
