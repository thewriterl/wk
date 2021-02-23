package wk.technology.test.imccalc.service.impl;

import org.springframework.stereotype.Service;
import wk.technology.test.imccalc.domain.Estado;
import wk.technology.test.imccalc.domain.Paciente;
import wk.technology.test.imccalc.repository.PacienteRepository;
import wk.technology.test.imccalc.service.EstadoService;
import wk.technology.test.imccalc.service.PacienteService;
import wk.technology.test.imccalc.service.dto.PacienteDemoDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;

    private final EstadoService estadoService;

    public PacienteServiceImpl(PacienteRepository pacienteRepository, EstadoService estadoService) {
        this.pacienteRepository = pacienteRepository;
        this.estadoService = estadoService;
    }

    @Override
    public List<Paciente> cadastrarJsonDemoWK(List<PacienteDemoDTO> dto) {
        List<Paciente> pacientes = dto.stream().map(Paciente::new).collect(Collectors.toList());
        estadoService.cadastrarEstadosJsonDemoWK(pacientes);
        pacientes.forEach(o -> o.getEndereco().setEstado(estadoService.getEstadoByUF(o.getEndereco().getEstado().getUf())));
        return pacienteRepository.saveAll(pacientes);
    }
}
