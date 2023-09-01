package com.homework.darkmode.controllers;

import com.homework.darkmode.dto.CarDTO;
import com.homework.darkmode.dto.DarkModeDTO;
import com.homework.darkmode.services.CarService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseCookie;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/cars")
    public ResponseEntity<DarkModeDTO> getAllCarsWithDarkMode(@CookieValue(value = "darkmode", defaultValue = "false") boolean darkMode){
        DarkModeDTO darkModeDTO = carService.getAllCarsWithDarkMode(darkMode);
        return ResponseEntity.ok(darkModeDTO);
    }

    @PutMapping("/dark-mode")
    public ResponseEntity<Void> updateDarkMode(@RequestBody DarkModeDTO darkModeDTO){
        boolean darkMode = darkModeDTO.isDarkMode();
        carService.updateDarkMode(darkMode);

        ResponseCookie springCookie = ResponseCookie.from("darkmode", String.valueOf(darkMode))
                .path("/")
                .build();
        return ResponseEntity .ok()
                .header(HttpHeaders.SET_COOKIE, springCookie.toString()) .build();
    }



}
