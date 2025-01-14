package org.test.problemsolving.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class CalibrationService {

    public int calculateCalibrationSum(String filePath) throws IOException {
        int total = 0;
        List<String> lines = Files.readAllLines(Path.of(filePath));
        for (String line : lines) {
            line = line.trim();
            String digits = line.replaceAll("[^0-9]", "");
            if (digits.length() >= 2) {
                int calibrationValue = Integer.parseInt("" + digits.charAt(0) + digits.charAt(digits.length() - 1));
                total += calibrationValue;
            } else if (digits.length() == 1) {
                int calibrationValue = Integer.parseInt(digits + digits); // Repeat the digit
                total += calibrationValue;
            }
        }
        return total;
    }
}
