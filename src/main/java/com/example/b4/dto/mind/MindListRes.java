package com.example.b4.dto.mind;

import com.example.b4.dto.play.PlayListDto;
import lombok.Data;

import java.util.List;

@Data
public class MindListRes {
    private List<String> categories;
    private List<MindListDto> minds;
}
