package com.example.bfhl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class BfhlResponseDTO {
    @JsonProperty("is_success")
    private boolean isSuccess;

    @JsonProperty("user_id")
    private String userId;

    private String email;

    @JsonProperty("roll_number")
    private String rollNumber;

    @JsonProperty("even_numbers")
    private List<String> evenNumbers;

    @JsonProperty("odd_numbers")
    private List<String> oddNumbers;

    private List<String> alphabets;

    @JsonProperty("special_characters")
    private List<String> specialCharacters;

    @JsonProperty("sepcial_characters")
    private List<String> sepcialCharacters; // Handles typo in Example B of prompt

    private String sum;

    @JsonProperty("concat_string")
    private String concatString;

    public BfhlResponseDTO() {
    }

    public BfhlResponseDTO(boolean isSuccess, String userId, String email, String rollNumber,
                           List<String> evenNumbers, List<String> oddNumbers, List<String> alphabets,
                           List<String> specialCharacters, String sum, String concatString) {
        this.isSuccess = isSuccess;
        this.userId = userId;
        this.email = email;
        this.rollNumber = rollNumber;
        this.evenNumbers = evenNumbers;
        this.oddNumbers = oddNumbers;
        this.alphabets = alphabets;
        this.specialCharacters = specialCharacters;
        this.sepcialCharacters = specialCharacters; // align with the same list
        this.sum = sum;
        this.concatString = concatString;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public List<String> getEvenNumbers() {
        return evenNumbers;
    }

    public void setEvenNumbers(List<String> evenNumbers) {
        this.evenNumbers = evenNumbers;
    }

    public List<String> getOddNumbers() {
        return oddNumbers;
    }

    public void setOddNumbers(List<String> oddNumbers) {
        this.oddNumbers = oddNumbers;
    }

    public List<String> getAlphabets() {
        return alphabets;
    }

    public void setAlphabets(List<String> alphabets) {
        this.alphabets = alphabets;
    }

    public List<String> getSpecialCharacters() {
        return specialCharacters;
    }

    public void setSpecialCharacters(List<String> specialCharacters) {
        this.specialCharacters = specialCharacters;
        this.sepcialCharacters = specialCharacters;
    }

    public List<String> getSepcialCharacters() {
        return sepcialCharacters;
    }

    public void setSepcialCharacters(List<String> sepcialCharacters) {
        this.sepcialCharacters = sepcialCharacters;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getConcatString() {
        return concatString;
    }

    public void setConcatString(String concatString) {
        this.concatString = concatString;
    }
}
