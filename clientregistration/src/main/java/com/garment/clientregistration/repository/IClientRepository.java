package com.garment.clientregistration.repository;

import com.garment.clientregistration.entity.ClientRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends JpaRepository<ClientRegistration, Integer> {


}
