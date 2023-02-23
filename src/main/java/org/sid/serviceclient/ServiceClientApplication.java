package org.sid.serviceclient;

import org.sid.serviceclient.entities.Client;
import org.sid.serviceclient.entities.Client_Particulier;
import org.sid.serviceclient.entities.Client_Professionnel;
import org.sid.serviceclient.repositories.ClientParticulierRepository;
import org.sid.serviceclient.repositories.ClientProfessionnelRepository;
import org.sid.serviceclient.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServiceClientApplication {
    @Autowired
    ClientRepository clientRepository ;
    @Autowired
    ClientProfessionnelRepository clientProfessionnelRepository;
    @Autowired
    ClientParticulierRepository clientParticulierRepository;

    public static void main(String[] args) {
        SpringApplication.run(ServiceClientApplication.class, args);
    }
    @Bean
    CommandLineRunner start (){
        return args -> {
            /*Client client = new Client();
            client.setNom("Ameni");
            client.setEmail("ameni@gmail.com");
            client.setPrénom("*****");
            client.setMot_de_passe("******");
            clientRepository.save(client);*/
            Client_Professionnel client_professionnel = new Client_Professionnel();
            client_professionnel.setNom("Amenities");
            client_professionnel.setEmail("amenities@gmail.com");
            client_professionnel.setPrénom("*****");
            client_professionnel.setMot_de_passe("******");
            client_professionnel.setMatricule_fiscale("test");
            client_professionnel.setNum_registre_commerce("55555");
            client_professionnel.setRaison_socile("kkkkkkk");
            clientProfessionnelRepository.save(client_professionnel);
            /*Client_Particulier client_particulier = new Client_Particulier();
            client_particulier.setNom("Salah");
            client_particulier.setEmail("Salah@gmail.com");
            client_particulier.setPrénom("Mejri");
            client_particulier.setMot_de_passe("*********");
            client_particulier.setProfession("Ingénieur");
            client_particulier.setLieu_de_naissance("Tunis");
            client_particulier.setStatus("married");
            clientParticulierRepository.save(client_particulier);*/

        };
    }

}
