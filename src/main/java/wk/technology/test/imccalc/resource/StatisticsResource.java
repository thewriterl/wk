package wk.technology.test.imccalc.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wk.technology.test.imccalc.domain.Estado;
import wk.technology.test.imccalc.domain.enums.MensagemErro;
import wk.technology.test.imccalc.service.StatisticsService;
import wk.technology.test.imccalc.utils.ErroConsulta;
import wk.technology.test.imccalc.utils.WKException;

import java.util.HashMap;

@RestController
@RequestMapping("/api/statistic")
public class StatisticsResource {


    private final StatisticsService statisticsService;

    public StatisticsResource(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping("/state")
    public ResponseEntity<Object> getStatisticsForUsersByState() {
        try {
            return ResponseEntity.ok().body(statisticsService.getStatisticsForUsersByState());
        } catch (WKException ex) {
            ErroConsulta erroConsulta = new ErroConsulta(MensagemErro.ME_ERRO_AO_OBTER_ESTATISTICAS, HttpStatus.BAD_REQUEST, "", ex);
            return ResponseEntity.badRequest().body(erroConsulta);
        }
    }

    @GetMapping("/age")
    public ResponseEntity<Object> getIMCRateByAge() {
        try {
            return ResponseEntity.ok().body(statisticsService.getIMCRateByAge());
        } catch (WKException ex) {
            ErroConsulta erroConsulta = new ErroConsulta(MensagemErro.ME_ERRO_AO_OBTER_ESTATISTICAS, HttpStatus.BAD_REQUEST, "", ex);
            return ResponseEntity.badRequest().body(erroConsulta);
        }
    }


}
