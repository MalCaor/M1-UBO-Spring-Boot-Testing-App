package com.dtos;

import com.entities.Concert;
import lombok.Data;

@Data
public class BilletDto {
    private int numero;
    private Concert concert;
}
