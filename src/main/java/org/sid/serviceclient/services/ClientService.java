package org.sid.serviceclient.services;

import org.sid.serviceclient.entities.Client;

public interface ClientService {
    Client getClientById(Long id);
    Client SaveClient(Client newClient);
    void updateClient(Long id , Client detailsClient);
    void deleteClient(Long id);
}
