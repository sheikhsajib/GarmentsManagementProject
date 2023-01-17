package com.garment.clientregistration.repository;

import com.garment.clientregistration.entity.ClientOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICOrderRepository extends JpaRepository<ClientOrder, Integer> {


}
