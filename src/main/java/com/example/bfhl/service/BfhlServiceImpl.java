package com.example.bfhl.service;

import com.example.bfhl.dto.BfhlRequestDTO;
import com.example.bfhl.dto.BfhlResponseDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BfhlServiceImpl implements BfhlService {

    private static final String USER_ID = "vishal_saini_26052002";
    private static final String EMAIL = "vishal.saini.roll@xyz.com";
    private static final String ROLL_NUMBER = "VS12345";

    @Override
    public BfhlResponseDTO processRequest(BfhlRequestDTO request) {
        if (request == null || request.getData() == null) {
            return new BfhlResponseDTO(
                    false, USER_ID, EMAIL, ROLL_NUMBER,
                    List.of(), List.of(), List.of(), List.of(), "0", ""
            );
        }

        List<String> inputData = request.getData();
        List<String> evenNumbers = new ArrayList<>();
        List<String> oddNumbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> specialCharacters = new ArrayList<>();
        
        long sum = 0;
        StringBuilder alphabeticSequence = new StringBuilder();

        for (String element : inputData) {
            if (element == null) continue;
            
            String trimmed = element.trim();
            if (trimmed.isEmpty()) continue;

            if (isNumeric(trimmed)) {
                try {
                    int num = Integer.parseInt(trimmed);
                    if (num % 2 == 0) {
                        evenNumbers.add(trimmed);
                    } else {
                        oddNumbers.add(trimmed);
                    }
                    sum += num;
                } catch (NumberFormatException e) {
                    // Fallback to special character if it fails integer parsing (e.g. extremely large value)
                    specialCharacters.add(trimmed);
                }
            } else if (isAlphabetic(trimmed)) {
                alphabets.add(trimmed.toUpperCase());
                alphabeticSequence.append(trimmed);
            } else {
                specialCharacters.add(trimmed);
            }
        }

        // Concatenate alphabetical characters in reverse order with alternating caps
        String concatString = generateConcatString(alphabeticSequence.toString());

        return new BfhlResponseDTO(
                true,
                USER_ID,
                EMAIL,
                ROLL_NUMBER,
                evenNumbers,
                oddNumbers,
                alphabets,
                specialCharacters,
                String.valueOf(sum),
                concatString
        );
    }

    private boolean isNumeric(String str) {
        return str.matches("-?\\d+");
    }

    private boolean isAlphabetic(String str) {
        return str.matches("[a-zA-Z]+");
    }

    private String generateConcatString(String original) {
        if (original.isEmpty()) {
            return "";
        }
        
        // Reverse the original concatenated string
        String reversed = new StringBuilder(original).reverse().toString();
        
        // Convert to alternating caps: first character is upper, second is lower, etc.
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < reversed.length(); i++) {
            char c = reversed.charAt(i);
            if (i % 2 == 0) {
                result.append(Character.toUpperCase(c));
            } else {
                result.append(Character.toLowerCase(c));
            }
        }
        return result.toString();
    }
}
