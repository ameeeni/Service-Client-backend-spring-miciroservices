package org.sid.serviceclient.repositories;

import org.sid.serviceclient.entities.Client_Professionnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClientProfessionnelRepository extends JpaRepository<Client_Professionnel,Long> {
}
