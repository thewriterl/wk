package wk.technology.test.imccalc.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import wk.technology.test.imccalc.domain.Estado;
import wk.technology.test.imccalc.domain.Paciente;
import wk.technology.test.imccalc.repository.PacienteRepository;
import wk.technology.test.imccalc.resource.PacienteResource;
import wk.technology.test.imccalc.service.EstadoService;
import wk.technology.test.imccalc.service.PacienteService;
import wk.technology.test.imccalc.service.dto.PacienteDemoDTO;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;

    private final EstadoService estadoService;

    private Logger logger = LoggerFactory.getLogger(PacienteResource.class);

    @Value("classpath:data.json")
    private Resource resource;

    public PacienteServiceImpl(PacienteRepository pacienteRepository, EstadoService estadoService) {
        this.pacienteRepository = pacienteRepository;
        this.estadoService = estadoService;
    }

    @PostConstruct
    private void cadastarDadosViaJson() {
        try {
            logger.info("CADASTRANDO DADOS DE DATA.JSON");
            Type listType = new TypeToken<ArrayList<PacienteDemoDTO>>(){}.getType();
            Reader reader = new InputStreamReader(resource.getInputStream());
            List<PacienteDemoDTO> pacientes = new Gson().fromJson(reader, listType);
            cadastrarViaJson(pacientes);
            logger.info("DADOS CADASTRADOS COM SUCESSO");
        } catch (IOException e) {
            e.printStackTrace();
            logger.info("OCORREU UM ERRO AO CADASTRAR DADOS DO JSON");
        }
    }

    @Override
    public List<Paciente> cadastrarJsonDemoWK(List<PacienteDemoDTO> dto) {
        List<Paciente> pacientes = dto.stream().map(Paciente::new).collect(Collectors.toList());
        estadoService.cadastrarEstadosJsonDemoWK(pacientes);
        pacientes.forEach(o -> o.getEndereco().setEstado(estadoService.getEstadoByUF(o.getEndereco().getEstado().getUf())));
        return pacienteRepository.saveAll(pacientes);
    }

    @Override
    public void cadastrarViaJson(List<PacienteDemoDTO> dto) {
        List<Paciente> pacientes = dto.stream().map(Paciente::new).collect(Collectors.toList());
        this.pacienteRepository.saveAll(pacientes);
    }
}
