package com.blaze.springvaadindemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FigureApi {

    // localhost:8080/calculate?figure=RECTANGLE&sideA=12&sideB=5
    // localhost:8080/calculate?figure=TRIANGLE&sideA=13&sideB=25&sideC=28
    @GetMapping("/calculate")
    public int calculateCircuit(@RequestParam String figure, @RequestParam int sideA, @RequestParam int sideB,
                                @RequestParam(required = false) Integer sideC) {
        if(figure.equalsIgnoreCase("RECTANGLE")) {
            return 2 * sideA + 2 * sideB;
        }
        else if(figure.equalsIgnoreCase("TRIANGLE")){
            return sideA + sideB + sideC;
        }
        return -1;
    }
}
