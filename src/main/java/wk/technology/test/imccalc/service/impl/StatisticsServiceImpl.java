package wk.technology.test.imccalc.service.impl;

import org.springframework.stereotype.Service;
import wk.technology.test.imccalc.domain.Estado;
import wk.technology.test.imccalc.domain.Paciente;
import wk.technology.test.imccalc.repository.PacienteRepository;
import wk.technology.test.imccalc.service.StatisticsService;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    private final PacienteRepository pacienteRepository;

    public StatisticsServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }
    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    @Override
    public HashMap<String, Integer> getStatisticsForUsersByState() {
        HashMap<String, Integer> response = new HashMap<>();
        List<Paciente> pacientes = pacienteRepository.findAll();
        List<Estado> estados = pacientes.stream().map(o -> o.getEndereco().getEstado()).collect(Collectors.toList());
        estados.forEach(estado -> response.put(estado.getUf(), (int) pacientes.stream().filter(o -> o.getEndereco().getEstado().equals(estado)).count()));
        return response;
    }

    private Float calculateIMCForAgeRange(List<Paciente> pacientes, Integer minAge, Integer maxAge) {
        Date currentDate = new Date();
        Integer ageRange = maxAge - minAge;
        List<Paciente> pacientesOnRange = pacientes.stream().filter(o -> ChronoUnit.YEARS.between(convertToLocalDateViaInstant(o.getDataNascimento()), convertToLocalDateViaInstant(currentDate)) <= ageRange).collect(Collectors.toList());
        return null;
    }

    @Override
    public Object getIMCRateByAge() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        calculateIMCForAgeRange(pacientes, 0, 10);
        calculateIMCForAgeRange(pacientes, 11, 20);
        calculateIMCForAgeRange(pacientes, 21, 30);
        calculateIMCForAgeRange(pacientes, 31, 40);
        calculateIMCForAgeRange(pacientes, 41, 50);
        calculateIMCForAgeRange(pacientes, 51, 60);
        return null;
    }


}
