package homework13.elementary.entity;

import lombok.Data;

@Data
public class Account {
    private int id;
    private int clientId;
    private String number;
    private double value;
}