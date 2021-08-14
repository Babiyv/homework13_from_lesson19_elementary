package homework13.elementary.dto;

import lombok.Data;

 /*DTO (data transfer object) - промежуточные объект, который мы создаем только с необходимыми полями для отображения
 на фронт-энд. Например нам не нужно передавать пароль или еще что-то, в таком случае мы просто создаем отдельный DTO под наши условия;*/
@Data
public class AccountDto {
    private int id;
    private int clientId;
    private String number;
    private double value;
}