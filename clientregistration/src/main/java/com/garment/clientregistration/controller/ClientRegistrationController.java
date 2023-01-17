package com.garment.clientregistration.controller;

import com.garment.clientregistration.entity.ClientRegistration;
import com.garment.clientregistration.service.ClientOrderService;
import com.garment.clientregistration.service.ClientRegistrationService;
import com.garment.clientregistration.service.CountryService;
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

    @Autowired
    CountryService cntService;
    @Autowired
    ClientOrderService coService;

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    // Go to Client Registration form
    @RequestMapping("/client_reg_form")
    public String clientRegForm(Model m){
        m.addAttribute("client_all_data", new ClientRegistration());
        m.addAttribute("viewCountry", cntService.getAllCountryList());
        m.addAttribute("title", "New Client Registration Form");


        return "client_reg_form";
    }


    //Client Registration From Action to save client data to dataBase
    @RequestMapping(value = "/save_client_submit", method = RequestMethod.POST)
    public String addNewClientForm(@ModelAttribute("client_all_data") ClientRegistration cr){

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
    public String clientProfile(@PathVariable("cid") Integer cid, Model m){
        m.addAttribute("allOrder", coService.getAllOrderList());
        m.addAttribute("ClientProfile",  crService.findClientById(cid));
        return "client_profile";
    }

    @RequestMapping("/update_client_profile/{cid}")
    public String clientUpdateForm(@PathVariable("cid") Integer cid, Model m){
        m.addAttribute("title", "Update Client");
        ClientRegistration cr = crService.findClientById(cid);
        m.addAttribute("viewCountry", cntService.getAllCountryList());
        m.addAttribute("client_all_data", cr);

        return "/client_reg_form";
    }


}
