package fr.uga.l3miage.pc.prisonersdilemma.requests;

import org.junit.jupiter.api.Test;

import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.requests.PartieJoinRequest;

import static org.junit.jupiter.api.Assertions.*;


class PartieJoinRequestTest {

    @Test
    void testPartieJoinRequestBuilder() {
        String nomJoueur2 = "Player2";
        PartieJoinRequest request = PartieJoinRequest.builder()
                                                     .nomJoueur2(nomJoueur2)
                                                     .build();
        assertNotNull(request);
        assertEquals(nomJoueur2, request.getNomJoueur2());
    }

    @Test
    void testPartieJoinRequestAllArgsConstructor() {
        String nomJoueur2 = "Player2";
        PartieJoinRequest request = new PartieJoinRequest(nomJoueur2);
        assertNotNull(request);
        assertEquals(nomJoueur2, request.getNomJoueur2());
    }

    @Test
    void testPartieJoinRequestSettersAndGetters() {
        PartieJoinRequest request = new PartieJoinRequest("Player2");
        request.setNomJoueur2("NewPlayer2");
        assertEquals("NewPlayer2", request.getNomJoueur2());
    }
}