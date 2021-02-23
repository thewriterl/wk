package wk.technology.test.imccalc.service.impl;

import org.springframework.stereotype.Service;
import wk.technology.test.imccalc.domain.Estado;
import wk.technology.test.imccalc.domain.Paciente;
import wk.technology.test.imccalc.repository.EstadoRepository;
import wk.technology.test.imccalc.service.EstadoService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstadoServiceImpl implements EstadoService {

    private final EstadoRepository estadoRepository;

    public EstadoServiceImpl(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }


    @Override
    public List<Estado> cadastrarEstadosJsonDemoWK(List<Paciente> pacientes) {
        return estadoRepository.saveAll(pacientes.stream()
                                    .map(o -> o.getEndereco().getEstado())
                                    .distinct()
                                    .collect(Collectors.toList()));
    }

    @Override
    public Estado getEstadoByUF(String uf) {
        return estadoRepository.findByUf(uf).orElseThrow();
    }


}
