package com.talenthub.AccountManager.controller;

import com.talenthub.AccountManager.model.Card;
import com.talenthub.AccountManager.service.CardService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CardController.class)
public class CardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CardService cardService;

    @Test
    public void getAllCardsTest() throws Exception {
        Mockito.when(cardService.getAllCards()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/card"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    public void getCardByIdTest() throws Exception {
        Card card = new Card();
        card.setId(1);
        Mockito.when(cardService.getCardById(1)).thenReturn(Optional.of(card));

        mockMvc.perform(get("/card/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    public void createCardTest() throws Exception {
        Card card = new Card();
        card.setId(1);
        Mockito.when(cardService.saveCard(Mockito.any(Card.class))).thenReturn(card);

        mockMvc.perform(post("/card")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\": 1, \"cardNumber\": \"1234567890\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    public void updateCardTest() throws Exception {
        Card card = new Card();
        card.setId(1);
        Mockito.when(cardService.getCardById(1)).thenReturn(Optional.of(card));
        Mockito.when(cardService.saveCard(Mockito.any(Card.class))).thenReturn(card);

        mockMvc.perform(put("/card/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"cardNumber\": \"9876543210\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    public void deleteCardTest() throws Exception {
        Mockito.when(cardService.getCardById(1)).thenReturn(Optional.of(new Card()));

        mockMvc.perform(delete("/card/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    public void getCardByEmailTest() throws Exception {
        Card card = new Card();
        card.setHolderEmail("test@example.com");
        Mockito.when(cardService.getCardByEmail("test@example.com")).thenReturn(card);

        mockMvc.perform(get("/card/email/test@example.com"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.holderEmail").value("test@example.com"));
    }
}
