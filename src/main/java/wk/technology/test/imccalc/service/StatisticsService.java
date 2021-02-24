package wk.technology.test.imccalc.service;

import wk.technology.test.imccalc.service.dto.GenderRateObesityDTO;
import wk.technology.test.imccalc.service.dto.IMCMediaDTO;

import java.util.HashMap;
import java.util.List;

public interface StatisticsService {

    HashMap<String, Integer> getStatisticsForUsersByState();

    List<IMCMediaDTO> getIMCRateByAge();

    List<GenderRateObesityDTO> getIMCRateByGender();

    Object getBloodTotalData();

    Object getBloodTypeData();
}
