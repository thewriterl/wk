package wk.technology.test.imccalc.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wk.technology.test.imccalc.domain.Paciente;
import wk.technology.test.imccalc.domain.enums.MensagemErro;
import wk.technology.test.imccalc.service.PacienteService;
import wk.technology.test.imccalc.service.dto.PacienteDemoDTO;
import wk.technology.test.imccalc.utils.ErroConsulta;
import wk.technology.test.imccalc.utils.WKException;

import java.util.List;

@RestController
@RequestMapping("/api/paciente")
public class PacienteResource {

    private final PacienteService pacienteService;

    public PacienteResource(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping("/json")
    public ResponseEntity<Object> cadastrarJsonDemoWK(@RequestBody List<PacienteDemoDTO> dto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.cadastrarJsonDemoWK(dto));
        } catch (WKException ex) {
            ErroConsulta erroConsulta = new ErroConsulta(MensagemErro.ME_ERRO_CADASTRO_JSON, HttpStatus.BAD_REQUEST, "", ex);
            return ResponseEntity.badRequest().body(erroConsulta);
        }
    }

}
