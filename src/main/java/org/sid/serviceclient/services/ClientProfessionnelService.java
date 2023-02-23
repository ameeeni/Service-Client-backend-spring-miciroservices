package org.sid.serviceclient.services;

import org.sid.serviceclient.entities.Client;
import org.sid.serviceclient.entities.Client_Professionnel;

public interface ClientProfessionnelService {
    Client_Professionnel getClientProfessionnelById(Long id);
    Client_Professionnel SaveClientProfessionnel(Client_Professionnel newClient);
    void updateClientProfessionnel(Long id , Client_Professionnel detailsClient);
    void deleteClientProfessionnel(Long id);
}
