package com.in28minutes.learnspringframework.buisnessCalculationService;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository
public class MySQLDataService {
    public int[] retrieveData() {
        return new int[] {1,2,3,4,5 };
    }
}
