package org.sid.serviceclient.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client_Particulier extends Client{
    private int CIN;
    private Date date_de_naissance ;
    private String lieu_de_naissance;
    private String profession;
    private String status ;
}
