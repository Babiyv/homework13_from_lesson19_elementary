package homework13.elementary.entity;

import lombok.Data;

@Data
public class Client {
    private int id;
    private String name;
    private String email;
    private long phone;
    private String about;
    private int age;
}