package wk.technology.test.imccalc.service.impl;

import org.springframework.stereotype.Service;
import wk.technology.test.imccalc.domain.Estado;
import wk.technology.test.imccalc.domain.Paciente;
import wk.technology.test.imccalc.domain.enums.PacienteSexo;
import wk.technology.test.imccalc.repository.PacienteRepository;
import wk.technology.test.imccalc.service.StatisticsService;
import wk.technology.test.imccalc.service.dto.BloodTypeDataDTO;
import wk.technology.test.imccalc.service.dto.GenderRateObesityDTO;
import wk.technology.test.imccalc.service.dto.IMCAgeRangeDTO;
import wk.technology.test.imccalc.service.dto.IMCMediaDTO;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
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

    public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
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

    private static double calculateIMC(Paciente paciente) {
        return paciente.getPeso() / Math.pow(paciente.getAltura(), 2);
    }

    private static Integer getDistanceBetweenDates(Date dataNascimento, Date reference) {
        return Math.toIntExact(ChronoUnit.YEARS.between(convertToLocalDateViaInstant(dataNascimento), convertToLocalDateViaInstant(reference)));
    }

    private IMCAgeRangeDTO calculateIMCWithAgeRange(List<Paciente> pacientes, Integer minAge, Integer maxAge) {
        Date currentDate = new Date();
        List<Paciente> pacientesOnRange = pacientes.stream()
                .filter(o -> getDistanceBetweenDates(o.getDataNascimento(), currentDate) <= maxAge)
                .filter(o -> getDistanceBetweenDates(o.getDataNascimento(), currentDate) >= minAge)
                .collect(Collectors.toList());
        Double mediaIMC = pacientesOnRange.stream().mapToDouble(StatisticsServiceImpl::calculateIMC).sum() / pacientesOnRange.size();

        IMCAgeRangeDTO dto = new IMCAgeRangeDTO();
//        dto.setPacientes(pacientesOnRange);
        dto.setIMCmedio(mediaIMC);

        return dto;
    }

    @Override
    public List<IMCMediaDTO> getIMCRateByAge() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        Integer minAge = 0;
        Integer maxAge = 10;
        List<IMCMediaDTO> dto = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            dto.add(new IMCMediaDTO(minAge + " - " + maxAge, calculateIMCWithAgeRange(pacientes, minAge, maxAge)));
            minAge = maxAge + 1;
            maxAge = maxAge + 10;
        }
        return dto;
    }

    @Override
    public List<GenderRateObesityDTO> getIMCRateByGender() {
        List<Paciente> pacientes = pacienteRepository.findAll();

        List<Paciente> masculinos = pacientes.stream()
                .filter(o -> o.getSexo().equals(PacienteSexo.MASCULINO))
                .collect(Collectors.toList());

        List<Paciente> femininos = pacientes.stream()
                .filter(o -> o.getSexo().equals(PacienteSexo.FEMININO))
                .collect(Collectors.toList());

        Float porcentagemMasculinos = (float) (masculinos.stream()
                                                        .mapToDouble(StatisticsServiceImpl::calculateIMC)
                                                        .filter(imc -> imc >= 30)
                                                        .count()) / masculinos.size();

        Float porcentagemFemininos = (float) (femininos.stream()
                                                        .mapToDouble(StatisticsServiceImpl::calculateIMC)
                                                        .filter(imc -> imc >= 30)
                                                        .count()) / femininos.size();


        List<GenderRateObesityDTO> dto = new ArrayList<>();
        dto.add(new GenderRateObesityDTO(masculinos.size(), porcentagemMasculinos * 100, PacienteSexo.MASCULINO));
        dto.add(new GenderRateObesityDTO(femininos.size(), porcentagemFemininos * 100, PacienteSexo.FEMININO));

        return dto;
    }

    @Override
    public List<BloodTypeDataDTO> getBloodTypeData() {
        Date currenteDate = new Date();
        List<Paciente> pacientes = pacienteRepository.findAll();
        List<String> tipoSanguineos = pacientes.stream().map(Paciente::getTipoSanguineo).distinct().sorted().collect(Collectors.toList());

        List<BloodTypeDataDTO> dto = new ArrayList<>();

        tipoSanguineos.forEach(tipo -> {
            List<Paciente> pacientesTipoSanguineo = pacientes.stream()
                                                                .filter(o -> o.getTipoSanguineo().equals(tipo))
                                                                .collect(Collectors.toList());

            Double ageRate = pacientesTipoSanguineo.stream()
                                                    .mapToDouble(o -> getDistanceBetweenDates(o.getDataNascimento(), currenteDate))
                                                    .sum() / pacientesTipoSanguineo.size();

            BloodTypeDataDTO data = new BloodTypeDataDTO();
            data.setAgeRate(ageRate);
            data.setTipoSanguineo(tipo);
            dto.add(data);
        });


        return dto;
    }


}
