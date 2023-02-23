package org.sid.serviceclient.web;
import org.sid.serviceclient.entities.Client;
import org.sid.serviceclient.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/clients")
public class ClientController {
    @Autowired
   ClientService clientService;
    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id){
        return new ResponseEntity<>(clientService.getClientById(id) , HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Client> saveClient(@RequestBody Client newClient) {
        Client savedClient = clientService.SaveClient(newClient);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Clients" ,"/clients" + savedClient.getId_client().toString());
        return new ResponseEntity<>(savedClient,httpHeaders, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")

    public ResponseEntity<Client> updatedClient (@PathVariable Long id , @RequestBody Client detailsClient ){
         clientService.updateClient(id,detailsClient);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Client> deleteClient(@PathVariable Long id ){
        clientService.deleteClient(id);
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
