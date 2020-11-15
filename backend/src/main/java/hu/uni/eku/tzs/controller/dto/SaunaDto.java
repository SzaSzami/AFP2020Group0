package hu.uni.eku.tzs.controller.dto;

import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Data
@Builder
public class SaunaDto {
    private String name;
    private int age;
    private boolean allowed;
    private Date Date;
}

// Sauna: Minors can not use the Sauna, so only those who are older than 17 can enter the Sauna entrance gate