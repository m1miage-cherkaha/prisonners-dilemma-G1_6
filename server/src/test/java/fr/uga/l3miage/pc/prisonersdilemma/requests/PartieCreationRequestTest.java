package fr.uga.l3miage.pc.prisonersdilemma.requests;

import org.junit.jupiter.api.Test;

import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.requests.PartieCreationRequest;

import static org.junit.jupiter.api.Assertions.*;


class PartieCreationRequestTest {

    @Test
    void testPartieCreationRequestBuilder() {
        PartieCreationRequest request = PartieCreationRequest.builder()
                .nomJoueur1("Player1")
                .nbTours(5)
                .build();

        assertEquals("Player1", request.getNomJoueur1());
        assertEquals(5, request.getNbTours());
    }

    @Test
    void testPartieCreationRequestAllArgsConstructor() {
        PartieCreationRequest request = new PartieCreationRequest("Player1", 5);

        assertEquals("Player1", request.getNomJoueur1());
        assertEquals(5, request.getNbTours());
    }

    @Test
    void testPartieCreationRequestSetters() {
        PartieCreationRequest request = new PartieCreationRequest("Player1", 5);
        request.setNomJoueur1("Player2");
        request.setNbTours(10);

        assertEquals("Player2", request.getNomJoueur1());
        assertEquals(10, request.getNbTours());
    }
}