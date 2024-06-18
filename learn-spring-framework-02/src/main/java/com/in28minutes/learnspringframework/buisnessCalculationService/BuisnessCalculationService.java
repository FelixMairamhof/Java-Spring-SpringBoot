package com.in28minutes.learnspringframework.buisnessCalculationService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;

//@Component
@Service
public class BuisnessCalculationService {
    private final DataService dataService;

    public BuisnessCalculationService( DataService dataService) {
        super();
        this.dataService = dataService;
    }

    public int findMax (){
        return Arrays.stream(dataService.retrieveData())
                .max().orElse(0);
    }
}
