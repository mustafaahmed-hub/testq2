package com.testby.bypretestq2.controller;

import com.testby.bypretestq2.dto.AvailRequestDTO;
import com.testby.bypretestq2.dto.AvailResponseDTO;
import com.testby.bypretestq2.service.AvailabilityAndCapacityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/")
public class AvalabilityAndCapacityController {
        @Autowired
        AvailabilityAndCapacityService availabilityAndCapacityService;
        @PostMapping("getProdAvailability")
        public ResponseEntity getProdAvailability(@RequestBody AvailRequestDTO availRequestDTO){
                AvailResponseDTO availResponseDTO = availabilityAndCapacityService.getProdAvailability(availRequestDTO);
                if(availRequestDTO.)


        }
}
