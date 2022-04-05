package com.testby.bypretestq2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailRequestDTO {
    String storeNo;
    String productId;
    Date reqDate;
    Double reqQty;
}
