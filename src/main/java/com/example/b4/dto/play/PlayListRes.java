package com.example.b4.dto.play;

import lombok.Data;

import java.util.List;

@Data
public class PlayListRes {
    private List<String> categories;
    private List<PlayListDto> plays;

}
