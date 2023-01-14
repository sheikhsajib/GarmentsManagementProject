package com.garment.clientregistration.controller;

import com.garment.clientregistration.entity.ClientRegistration;
import com.garment.clientregistration.service.ClientRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClientRegistrationController {

    @Autowired
    ClientRegistrationService crService;

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    // Go to Client Registration form
    @RequestMapping("/client_reg_form")
    public String clientRegForm(Model m){
        m.addAttribute("clientRegTable", new ClientRegistration());
        m.addAttribute("title", "New Client Registration Form");
        return "client_reg_form";
    }


    //Client Registration From Action to save client data to dataBase
    @RequestMapping(value = "/new_client_reg", method = RequestMethod.POST)
    public String addNewClient(@ModelAttribute("client") ClientRegistration cr, Model m ){

        crService.saveClientInformation(cr);
        return "redirect:/client_list";
    }


    //This Page will Show All list of Client Data
    @RequestMapping("/client_list")
    public String allClientList(Model m){
        m.addAttribute("allClient", crService.getAllClientList());
        return "client_list";
    }

    // Go to Client Profile Page
    @RequestMapping("/client_profile")
    public String clientProfilePage(){
        return "client_profile";
    }


    @RequestMapping("/client_profile/{cid}")
    public String clientProfile(){
//        ClientRegistration cr = new  ClientRegistrationService().findClientById(cid);
//
//        m.addAttribute("Client Profile", cr);

        return "client_profile";
    }



}
