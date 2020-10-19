package hu.uni.eku.tzs.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GuestDto {

    private int id;
    private String name;
    private int age;
    private boolean typeofwatch;
}
