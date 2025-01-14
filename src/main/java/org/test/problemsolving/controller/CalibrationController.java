package org.test.problemsolving.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.test.problemsolving.service.CalibrationService;

import java.io.IOException;

@RestController
public class CalibrationController {

    @Autowired
    private CalibrationService calibrationService;

    @GetMapping("/calculate")
    public void calculateCalibration() throws IOException {
        String filePath = "src/main/resources/calibration_document.txt";
        int sum = calibrationService.calculateCalibrationSum(filePath);
        System.out.println("La somme totale est : " + sum);
    }
}
