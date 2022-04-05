package com.testby.bypretestq2.controller;

import com.testby.bypretestq2.dto.AvailRequestDTO;
import com.testby.bypretestq2.dto.AvailResponseDTO;
import com.testby.bypretestq2.service.AvailabilityAndCapacityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

                if(availResponseDTO==null)
                        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
                if(availResponseDTO.getStatus().compareTo("-1")==0)
                        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);


                return ResponseEntity.status(HttpStatus.OK).body(availResponseDTO);

        }
}
