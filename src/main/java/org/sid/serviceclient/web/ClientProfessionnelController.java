package org.sid.serviceclient.web;

import org.sid.serviceclient.entities.Client;
import org.sid.serviceclient.entities.Client_Professionnel;
import org.sid.serviceclient.services.ClientProfessionnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ClientsPro")
public class ClientProfessionnelController {
    @Autowired
    ClientProfessionnelService clientProfessionnelService;
    @GetMapping("/{id}")
    public ResponseEntity<Client_Professionnel> getClientById(@PathVariable Long id){
        return new ResponseEntity<>(clientProfessionnelService.getClientProfessionnelById(id) , HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Client_Professionnel> saveClient(@RequestBody Client_Professionnel newClient) {
        Client_Professionnel savedClient = clientProfessionnelService.SaveClientProfessionnel(newClient);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("ClientsPro" ,"/clientsPro" + savedClient.getId_client().toString());
        return new ResponseEntity<>(savedClient,httpHeaders, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")

    public ResponseEntity<Client_Professionnel> updatedClient (@PathVariable Long id , @RequestBody Client_Professionnel detailsClient ){
        clientProfessionnelService.updateClientProfessionnel(id,detailsClient);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Client> deleteClient(@PathVariable Long id ){
        clientProfessionnelService.deleteClientProfessionnel(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
