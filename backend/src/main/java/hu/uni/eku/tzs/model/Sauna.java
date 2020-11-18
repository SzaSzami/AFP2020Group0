package hu.uni.eku.tzs.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sauna {
    private String name;
    private int age;
    private boolean allowed;
    private Date date;


    public boolean getAllowed() {
        return this.allowed;
    }
}
