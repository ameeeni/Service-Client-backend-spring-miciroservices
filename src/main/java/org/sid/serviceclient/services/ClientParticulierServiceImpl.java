package org.sid.serviceclient.services;

import org.sid.serviceclient.entities.Client;
import org.sid.serviceclient.entities.Client_Particulier;
import org.sid.serviceclient.repositories.ClientParticulierRepository;
import org.sid.serviceclient.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClientParticulierServiceImpl implements ClientParticulierService {
    @Autowired
    ClientParticulierRepository clientParticulierRepository;
    @Override
    public Client_Particulier getClientParticulierById(Long id) {
        return clientParticulierRepository.findById(id).get();
    }

    @Override
    public Client_Particulier SaveClientParticulier(Client_Particulier newClientParticulier) {
        return clientParticulierRepository.save(newClientParticulier);
    }

    @Override
    public void updateClientParticulier(Long id, Client_Particulier detailsClientParticulier) {
        Client_Particulier updateClient = clientParticulierRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Client with id "+ id+ " does not exist"));
        updateClient.setId_client(detailsClientParticulier.getId_client());
        updateClient.setNom(detailsClientParticulier.getNom());
        updateClient.setPrénom(detailsClientParticulier.getPrénom());
        updateClient.setEmail(detailsClientParticulier.getEmail());
        updateClient.setMot_de_passe(detailsClientParticulier.getMot_de_passe());
        updateClient.setCIN(detailsClientParticulier.getCIN());
        updateClient.setStatus(detailsClientParticulier.getStatus());
        updateClient.setDate_de_naissance(detailsClientParticulier.getDate_de_naissance());
        updateClient.setLieu_de_naissance(detailsClientParticulier.getLieu_de_naissance());
        updateClient.setProfession(updateClient.getProfession());
        clientParticulierRepository.save(updateClient);

    }

    @Override
    public void deleteClientParticulier(Long id) {
        clientParticulierRepository.deleteById(id);

    }
}
