package fr.uga.l3miage.pc.prisonnersdilemma.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartieResponseDTO {
    private Long id;
    private Long joueur1Id;
    private Long joueur2Id;
}
