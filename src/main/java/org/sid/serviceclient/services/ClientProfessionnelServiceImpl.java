package org.sid.serviceclient.services;

import org.sid.serviceclient.entities.Client_Professionnel;
import org.sid.serviceclient.repositories.ClientProfessionnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClientProfessionnelServiceImpl implements ClientProfessionnelService {
    @Autowired
    ClientProfessionnelRepository clientProfessionnelRepository;
    @Override
    public Client_Professionnel getClientProfessionnelById(Long id) {
        return clientProfessionnelRepository.findById(id).get();
    }

    @Override
    public Client_Professionnel SaveClientProfessionnel(Client_Professionnel newClient) {
        return clientProfessionnelRepository.save(newClient);

    }

    @Override
    public void updateClientProfessionnel(Long id, Client_Professionnel detailsClient) {
        Client_Professionnel updateClient = clientProfessionnelRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Client with id "+ id+ " does not exist"));
        updateClient.setId_client(detailsClient.getId_client());
        updateClient.setNom(detailsClient.getNom());
        updateClient.setPrénom(detailsClient.getPrénom());
        updateClient.setEmail(detailsClient.getEmail());
        updateClient.setMot_de_passe(detailsClient.getMot_de_passe());
        updateClient.setRaison_socile(detailsClient.getRaison_socile());
        updateClient.setNum_registre_commerce(detailsClient.getNum_registre_commerce());
        updateClient.setMatricule_fiscale(detailsClient.getMatricule_fiscale());
        clientProfessionnelRepository.save(updateClient);

    }

    @Override
    public void deleteClientProfessionnel(Long id) {
        clientProfessionnelRepository.deleteById(id);

    }
}
