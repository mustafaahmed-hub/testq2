package com.testby.bypretestq2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Availability {
    String storeNo;
    String productId;
    Date date;
    Double availQty;
}
