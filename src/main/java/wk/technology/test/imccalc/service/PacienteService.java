package wk.technology.test.imccalc.service;

import org.springframework.web.bind.annotation.RequestBody;
import wk.technology.test.imccalc.domain.Paciente;
import wk.technology.test.imccalc.service.dto.PacienteDemoDTO;

import java.util.List;

public interface PacienteService {

    List<Paciente> cadastrarJsonDemoWK(@RequestBody List<PacienteDemoDTO> dto);

    void cadastrarViaJson(List<PacienteDemoDTO> dto);

}
