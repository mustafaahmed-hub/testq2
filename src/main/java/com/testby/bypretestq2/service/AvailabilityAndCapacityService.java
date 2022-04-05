package com.testby.bypretestq2.service;

import com.testby.bypretestq2.dto.AvailRequestDTO;
import com.testby.bypretestq2.dto.AvailResponseDTO;
import com.testby.bypretestq2.model.Availability;
import com.testby.bypretestq2.model.Capacity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

@Service
public class AvailabilityAndCapacityService {
    List<Availability> availabilityList = new LinkedList<>();
    List<Capacity> capacityList = new LinkedList<>();
    static int availability ;
    static int capacity ;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    public AvailResponseDTO getProdAvailability(AvailRequestDTO availRequestDTO) {
        init();
        int capacity = getCapacity(availRequestDTO);
        int availability = getAvailability(availRequestDTO);
//        availability=0;
//        capacity =0;
//        List<Callable<Integer>> collection = Arrays.asList(
//                ()->getAvailability(availRequestDTO),
//                ()->getCapacity(availRequestDTO)
//        );
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        List<Integer> tmpList = new LinkedList<>();
//        try {
//             List<Future<Integer>> results = executorService.invokeAll(collection);
//            for(Future<Integer> future: results)
//                System.out.println(future.get());
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }
//
////        (executorService)
//        executorService.shutdown();
        String status = "";


        if(availability==0)
            return null;
        else if(capacity==0)
            status = "No Capacity";
        else
            status = "Available";

        AvailResponseDTO availResponseDTO = new AvailResponseDTO(
                availRequestDTO.getStoreNo(),
                availRequestDTO.getProductId(),
                availRequestDTO.getReqDate(),
                availRequestDTO.getReqQty(),
                status
        );


        return availResponseDTO;



}
    //used for populating initial data
    private void init()  {
        try {
            availabilityList.add(new Availability("Store001", "Prod1", sdf.parse("2021-02-19"), 1.0));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            availabilityList.add(new Availability("Store001", "Prod1", sdf.parse("2021-02-20"), 3.0));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            availabilityList.add(new Availability("Store001", "Prod1", sdf.parse("2021-02-21"), 0.0));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            capacityList.add(new Capacity("Store001", "Prod1", sdf.parse("2021-02-19"), 0.0));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            capacityList.add(new Capacity("Store001", "Prod1", sdf.parse("2021-02-20"), 2.0));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            capacityList.add(new Capacity("Store001", "Prod1", sdf.parse("2021-02-21"), 2.0));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            capacityList.add(new Capacity("Store001", "Prod1", (sdf.parse("2021-02-22")), 0.0));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    private Integer getCapacity(AvailRequestDTO availRequestDTO){
        int currCapacity =0;

        List<Capacity> capacityMatch = capacityList.stream()
                .filter(a -> a.getStoreNo().compareTo(availRequestDTO.getStoreNo())==0
                && sdf.format(availRequestDTO.getReqDate()).equals(sdf.format(a.getDate()))
                && availRequestDTO.getProductId().compareTo(a.getProductId())==0)
                .collect(Collectors.toList());
        for(Capacity c : capacityMatch){
//            System.out.println(c);
            currCapacity+= c.getNoOfOrdersAccepted();
        }
        capacity = currCapacity;
        return currCapacity;
    }
    private Integer getAvailability(AvailRequestDTO availRequestDTO){
        int currAvailability =0;
        List<Availability> availabilityMatch =  availabilityList.stream()
                .filter(a-> a.getStoreNo().compareTo(availRequestDTO.getStoreNo())==0
                        && sdf.format(availRequestDTO.getReqDate()).equals(sdf.format(a.getDate()))
                        && availRequestDTO.getProductId().compareTo(a.getProductId())==0)
                .collect(Collectors.toList());
        for(Availability a : availabilityMatch){
//            System.out.println(a);
            currAvailability+= a.getAvailQty();
        }
        availability = currAvailability;
        return currAvailability;
    }

}

