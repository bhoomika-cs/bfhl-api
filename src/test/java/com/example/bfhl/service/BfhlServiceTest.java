package com.example.bfhl.service;

import com.example.bfhl.dto.BfhlRequestDTO;
import com.example.bfhl.dto.BfhlResponseDTO;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class BfhlServiceTest {

    private final BfhlService bfhlService = new BfhlServiceImpl();

    @Test
    public void testExampleA() {
        BfhlRequestDTO request = new BfhlRequestDTO(List.of("a", "1", "334", "4", "R", "$"));
        BfhlResponseDTO response = bfhlService.processRequest(request);

        assertTrue(response.isSuccess());
        assertEquals("vishal_saini_26052002", response.getUserId());
        assertEquals("vishal.saini.roll@xyz.com", response.getEmail());
        assertEquals("VS12345", response.getRollNumber());
        assertEquals(List.of("1"), response.getOddNumbers());
        assertEquals(List.of("334", "4"), response.getEvenNumbers());
        assertEquals(List.of("A", "R"), response.getAlphabets());
        assertEquals(List.of("$"), response.getSpecialCharacters());
        assertEquals(List.of("$"), response.getSepcialCharacters()); // handles typo
        assertEquals("339", response.getSum());
        assertEquals("Ra", response.getConcatString());
    }

    @Test
    public void testExampleB() {
        BfhlRequestDTO request = new BfhlRequestDTO(List.of("2", "a", "y", "4", "&", "-", "*", "5", "92", "b"));
        BfhlResponseDTO response = bfhlService.processRequest(request);

        assertTrue(response.isSuccess());
        assertEquals(List.of("5"), response.getOddNumbers());
        assertEquals(List.of("2", "4", "92"), response.getEvenNumbers());
        assertEquals(List.of("A", "Y", "B"), response.getAlphabets());
        assertEquals(List.of("&", "-", "*"), response.getSpecialCharacters());
        assertEquals(List.of("&", "-", "*"), response.getSepcialCharacters()); // handles typo
        assertEquals("103", response.getSum());
        assertEquals("ByA", response.getConcatString());
    }

    @Test
    public void testExampleC() {
        BfhlRequestDTO request = new BfhlRequestDTO(List.of("A", "ABCD", "DOE"));
        BfhlResponseDTO response = bfhlService.processRequest(request);

        assertTrue(response.isSuccess());
        assertEquals(List.of(), response.getOddNumbers());
        assertEquals(List.of(), response.getEvenNumbers());
        assertEquals(List.of("A", "ABCD", "DOE"), response.getAlphabets());
        assertEquals(List.of(), response.getSpecialCharacters());
        assertEquals("0", response.getSum());
        assertEquals("EoDdCbAa", response.getConcatString());
    }

    @Test
    public void testEmptyAndNull() {
        BfhlResponseDTO responseNull = bfhlService.processRequest(null);
        assertFalse(responseNull.isSuccess());

        BfhlResponseDTO responseEmptyData = bfhlService.processRequest(new BfhlRequestDTO(null));
        assertFalse(responseEmptyData.isSuccess());

        BfhlResponseDTO responseEmptyList = bfhlService.processRequest(new BfhlRequestDTO(List.of()));
        assertTrue(responseEmptyList.isSuccess());
        assertEquals("0", responseEmptyList.getSum());
        assertEquals("", responseEmptyList.getConcatString());
    }
}
