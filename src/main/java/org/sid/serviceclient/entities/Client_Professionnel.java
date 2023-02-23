package org.sid.serviceclient.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Client_Professionnel extends Client {
    private String matricule_fiscale;
    private String raison_socile;
    private String num_registre_commerce;
}
