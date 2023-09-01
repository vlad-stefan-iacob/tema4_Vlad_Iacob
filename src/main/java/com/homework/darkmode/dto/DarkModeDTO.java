package com.homework.darkmode.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DarkModeDTO {
    private boolean darkMode;
    private List<CarDTO> cars;
}
