package wk.technology.test.imccalc.service;

import wk.technology.test.imccalc.service.dto.EstadoEstatisticDTO;
import wk.technology.test.imccalc.service.dto.GenderRateObesityDTO;
import wk.technology.test.imccalc.service.dto.IMCMediaDTO;

import java.util.List;

public interface StatisticsService {

    List<EstadoEstatisticDTO> getStatisticsForUsersByState();

    List<IMCMediaDTO> getIMCRateByAge();

    List<GenderRateObesityDTO> getIMCRateByGender();

    Object getBloodTotalData();

    Object getBloodTypeData();
}
