package exercise.dto;

// BEGIN
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class GuestCreateDTO {
    @NotBlank(message = "Имя не может быть пустым")
    private String name;

    @Email(message = "Электронная почта должна быть валидной")
    @NotBlank(message = "Электронная почта не может быть пустой")
    private String email;

    @Pattern(regexp = "^\\+\\d{11,13}$", message = "Номер телефона должен начинаться с + и содержать от 11 до 13 цифр")
    @NotBlank(message = "Номер телефона не может быть пустым")
    private String phoneNumber;

    @Pattern(regexp = "^\\d{4}$", message = "Номер клубной карты должен состоять ровно из четырех цифр")
    @NotBlank(message = "Номер клубной карты не может быть пустым")
    private String clubCard;

    @FutureOrPresent(message = "Срок действия клубной карты должен быть еще не истекшим")
    private LocalDate cardValidUntil;
}
// END
