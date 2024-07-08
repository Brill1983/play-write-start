package ru.brill.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PledgeResultDto {
    private Boolean isFound;
    private Boolean isIpRestricted;
    private List<List<String>> result;
}
