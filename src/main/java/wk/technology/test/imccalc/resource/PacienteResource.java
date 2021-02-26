package wk.technology.test.imccalc.resource;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import wk.technology.test.imccalc.domain.Paciente;
import wk.technology.test.imccalc.domain.enums.MensagemErro;
import wk.technology.test.imccalc.service.PacienteService;
import wk.technology.test.imccalc.service.dto.PacienteDemoDTO;
import wk.technology.test.imccalc.utils.ErroConsulta;
import wk.technology.test.imccalc.utils.WKException;

import javax.annotation.PostConstruct;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
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
