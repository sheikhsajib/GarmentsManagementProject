package com.garmentsmanagement.GM.service.clientService;

import com.garmentsmanagement.GM.entity.clientEntity.ClientOrder;
import com.garmentsmanagement.GM.repository.clientRepository.ICOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientOrderService {
    @Autowired
    ICOrderRepository icOrderRepo;

    //this method for save student
    public void saveOrderInformation(ClientOrder co){
        icOrderRepo.save(co);
        //CRUD = C For Create;
    }

    public List<ClientOrder> getAllOrderList(){
        return icOrderRepo.findAll();
        //CRUD = R For Read or Get;
    }

    //this method for get  by id
    public ClientOrder findOrderById(int coid){
        return icOrderRepo.findById(coid).get();
        //CRUD = U For Update or Edit;
    }

    //this method for delete an Order
    public void deleteOrder(int coid){
        icOrderRepo.deleteById(coid);
        //CRUD = D For Delete or Remove;
    }





}





