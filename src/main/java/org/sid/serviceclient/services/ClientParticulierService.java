package org.sid.serviceclient.services;

import org.sid.serviceclient.entities.Client;
import org.sid.serviceclient.entities.Client_Particulier;

public interface ClientParticulierService {
    Client_Particulier getClientParticulierById(Long id);
    Client_Particulier SaveClientParticulier(Client_Particulier newClientParticulier);
    void updateClientParticulier(Long id , Client_Particulier detailsClientParticulier);
    void deleteClientParticulier(Long id);
}
