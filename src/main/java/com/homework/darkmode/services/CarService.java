package com.homework.darkmode.services;

import com.homework.darkmode.dto.CarDTO;
import com.homework.darkmode.dto.DarkModeDTO;
import com.homework.darkmode.models.Car;
import com.homework.darkmode.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;

    private boolean isDarkModeEnabled = false;
    public DarkModeDTO getAllCarsWithDarkMode(boolean darkMode) {
        isDarkModeEnabled = darkMode;
        List<Car> cars = carRepository.findAll();
        List<CarDTO> carsDTO = new ArrayList<>();
        for (var car : cars) {
            carsDTO.add(new CarDTO(car.getName(), car.getModel()));
        }

        return new DarkModeDTO(isDarkModeEnabled, carsDTO);
    }

    public void updateDarkMode(boolean darkMode) {
        isDarkModeEnabled = darkMode;
    }
}
