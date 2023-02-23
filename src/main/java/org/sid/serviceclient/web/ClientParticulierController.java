package org.sid.serviceclient.web;
import org.sid.serviceclient.entities.Client_Particulier;
import org.sid.serviceclient.services.ClientParticulierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ClientsPar")
public class ClientParticulierController {
   @Autowired
    ClientParticulierService clientParticulierService;
    @GetMapping("/{id}")
    public ResponseEntity<Client_Particulier> getClientById(@PathVariable Long id){
        return new ResponseEntity<>(clientParticulierService.getClientParticulierById(id) , HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Client_Particulier> saveClient(@RequestBody Client_Particulier newClient) {
        Client_Particulier savedClient = clientParticulierService.SaveClientParticulier(newClient);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("ClientsPar" ,"/ClientsPar" + savedClient.getId_client().toString());
        return new ResponseEntity<>(savedClient,httpHeaders, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")

    public ResponseEntity<Client_Particulier> updatedClient (@PathVariable Long id , @RequestBody Client_Particulier detailsClient ){
        clientParticulierService.updateClientParticulier(id,detailsClient);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Client_Particulier> deleteClient(@PathVariable Long id ){
        clientParticulierService.deleteClientParticulier(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
