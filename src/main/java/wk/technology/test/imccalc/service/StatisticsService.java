package wk.technology.test.imccalc.service;

import java.util.HashMap;

public interface StatisticsService {

    HashMap<String, Integer> getStatisticsForUsersByState();

    Object getIMCRateByAge();
}
