package com.garmentsmanagement.GM.controller;

import com.garmentsmanagement.GM.entity.employeeEntity.EndtAttendance;
import com.garmentsmanagement.GM.entity.employeeEntity.Employees;
import com.garmentsmanagement.GM.entity.employeeEntity.StartAttend;
import com.garmentsmanagement.GM.repository.EmployeeRepository.DesignationRepo;
import com.garmentsmanagement.GM.repository.EmployeeRepository.EmployeeRepository;
import com.garmentsmanagement.GM.service.employeeService.EmployeeService;
import com.garmentsmanagement.GM.utility.EmployeeUtility;
import com.garmentsmanagement.GM.utility.LocalDateDeserializer;
import com.garmentsmanagement.GM.utility.LocalDateTimeSerializer;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.List;

@RestController
public class ApiController {

    @Autowired
    DesignationRepo desigRepo;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeUtility employeeUtility;

//    LocalDateDeserializer localDateDeserialize;

    GsonBuilder gsonBuilder = new GsonBuilder();

    public GsonBuilder getGsonBuilder() {
         gsonBuilder.registerTypeAdapter(LocalTime.class, new LocalDateTimeSerializer());
         gsonBuilder.registerTypeAdapter(LocalTime.class, new LocalDateDeserializer());

         return gsonBuilder;
    }

    @RequestMapping(value = "designation/{id}")
    public String getCityById(@PathVariable("id") Integer id, Model model){
        Gson gson = new Gson();
        return gson.toJson(desigRepo.findByDesigId(id));
    }

    @RequestMapping(value = "attend/{id}")
    public String getAttendenc(@PathVariable("id") String id, Model model) {
        List<Employees> hre = employeeService.findEmplyByEmid(id);

        if (!hre.isEmpty()) {
//            model.addAttribute("hrem", hre);

            List<StartAttend> stAt = employeeService.findStartData(id);
            StartAttend startAttend = new StartAttend();
            if (stAt.isEmpty()) {

                startAttend.setAtt_emId(id);
                startAttend.setEm_attend(true);
//                startAttend.setEm_IdPK(hre.get(0).getEm_id());
                startAttend.setEmployees(hre.get(0));
                employeeService.saveStartAtt(startAttend);

            } else {
                List<EndtAttendance> endList = employeeService.findEndData(stAt.get(0).getEm_id());
                if (endList.isEmpty()) {
                    EndtAttendance endAttdend = new EndtAttendance();

                    endAttdend.setEm_leave(true);
                    endAttdend.setStartAttend(stAt.get(0));
                    long x = stAt.get(0).getStartTime().until(endAttdend.getLeaveTime(), ChronoUnit.HOURS);
                    endAttdend.setTotalWorkHous(x);
                    endAttdend.setEm_idEnd(id);
                    employeeService.saveStartAtt(endAttdend);
                }

                model.addAttribute("hremErorr", "Your start Attendenc Already Updated");
            }
        } else {
            model.addAttribute("hremErorr", "Id Not Match");
            System.out.println("Id Not Match");
        }

        Gson gson = new Gson();
        return gson.toJson(hre);



    }
}


//            @Override
//            public LocalDateTime deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
//                Instant instant = Instant.ofEpochMilli(json.getAsJsonPrimitive().getAsLong());
//                return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
//            }
//        }).create();

//        return





