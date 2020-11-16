package hu.uni.eku.tzs.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class BillDto {

    private UUID owner;
    private List<UUID> users;
    private List<String> items;
    private Date endstamp;
}
