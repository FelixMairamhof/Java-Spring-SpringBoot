package com.in28minutes.learnspringframework.buisnessCalculationService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BuisnessCalculationService {
    private final DataService dataService;

    public BuisnessCalculationService( DataService dataService) {
        this.dataService = dataService;
    }

    public int findMax (){
        return Arrays.stream(dataService.retrieveData())
                .max().orElse(0);
    }
}
