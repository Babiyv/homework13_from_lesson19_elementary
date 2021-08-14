package homework13.elementary.dto;

import lombok.Data;

@Data
public class ClientDto {
    private int id;
    private String name;
    private String email;
    private long phone;
    private String about;
    private int age;
}
