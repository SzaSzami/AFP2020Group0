package hu.uni.eku.tzs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bill {

    private UUID owner;
    private List<UUID> users;
    private int endsum;
    private Date endstamp;

}
