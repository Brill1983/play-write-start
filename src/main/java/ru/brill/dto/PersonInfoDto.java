package ru.brill.dto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PersonInfoDto {
    private String lastName;
    private String firstName;
    private String fatherName;
    private LocalDate birthday;
}
