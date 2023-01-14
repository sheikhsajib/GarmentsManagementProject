package com.garment.clientregistration.service;

import com.garment.clientregistration.entity.ClientRegistration;
import com.garment.clientregistration.repository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientRegistrationService {

    @Autowired
    IClientRepository icRepo;


    //this method for save student
    public void saveClientInformation(ClientRegistration cr){
        icRepo.save(cr);
        //CRUD = C For Create;
    }

    public List<ClientRegistration> getAllClientList(){
        return icRepo.findAll();
        //CRUD = R For Read of Get;
    }





}
