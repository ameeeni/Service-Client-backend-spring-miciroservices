package org.sid.serviceclient.repositories;

import org.sid.serviceclient.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client, Long> {
}
