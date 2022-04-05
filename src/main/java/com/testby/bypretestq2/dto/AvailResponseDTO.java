package com.testby.bypretestq2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvailResponseDTO {
    String storeNo;
    String productId;
    Date reqDate;
    Double reqQty;
    String status;
}
