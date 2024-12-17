package fr.uga.l3miage.pc.prisonersdilemma.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TourResponseDTO {
    private Long id;
    private int roundNumber;
    private String status;
}
