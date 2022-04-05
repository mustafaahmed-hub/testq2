package com.testby.bypretestq2.service;

import com.testby.bypretestq2.dto.AvailRequestDTO;
import com.testby.bypretestq2.dto.AvailResponseDTO;
import com.testby.bypretestq2.model.Availability;
import com.testby.bypretestq2.model.Capacity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AvailabilityAndCapacityService {
    List<Availability> availabilityList = new LinkedList<>();
    List<Capacity> capacityList = new LinkedList<>();

    public AvailResponseDTO getProdAvailability(AvailRequestDTO availRequestDTO) {
        availabilityList.add(new Availability("Store001", "Prod1", new Date(2021 - 02 - 19), 1.0));
        availabilityList.add(new Availability("Store001", "Prod1", new Date(2021 - 02 - 20), 3.0));
        availabilityList.add(new Availability("Store001", "Prod1", new Date(2021 - 02 - 21), 0.0));
        capacityList.add(new Capacity(" Store001", "Prod1", new Date(2021 - 02 - 19), 0.0));
        capacityList.add(new Capacity((" Store001", "Prod1", new Date(2021 - 02 - 20), 2.0));
        capacityList.add(new Capacity(" Store001", "Prod1", new Date(2021 - 02 - 21), 2.0));
        capacityList.add(new Capacity(" Store001", "Prod1", new Date(2021 - 02 - 22), 0.0));
        List<Availability> availabilitcyMatch =  availabilityList.stream().filter(a-> a.getStoreNo()== availRequestDTO.getStoreNo()).collect(Collectors.toList());
        List<Capacity> capacityMatch = availabilityList.stream().filter(a ->a.getStoreNo()==availRequestDTO.getStoreNo()));


}
