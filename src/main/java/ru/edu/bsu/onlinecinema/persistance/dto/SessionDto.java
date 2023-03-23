package ru.edu.bsu.onlinecinema.persistance.dto;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class SessionDto {

    private String filmName;

    private String time;

    private Integer placeCount;



}
