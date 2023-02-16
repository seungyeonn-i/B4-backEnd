package com.example.b4.controller;

import com.example.b4.dto.play.PlayDetailDto;
import com.example.b4.dto.play.PlayDetailReq;
import com.example.b4.dto.play.PlayListRes;
import com.example.b4.dto.study.StudyDetailDto;
import com.example.b4.dto.study.StudyDetailReq;
import com.example.b4.entity.post.PlayCategory;
import com.example.b4.entity.post.StudyCategory;
import com.example.b4.service.play.PlayService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequiredArgsConstructor
@RequestMapping("plays")
public class PlayController {

    private final PlayService playService;

    @GetMapping
    public ResponseEntity<PlayListRes> getPlayList() {
        PlayListRes playListRes = new PlayListRes();
        playListRes.setPlays(playService.getPlayLists());

        List<String> newString = Stream.of(PlayCategory.values())
                .map(Enum::name)
                .collect(Collectors.toList());

        playListRes.setCategories(newString);
        return new ResponseEntity<>(playListRes, HttpStatus.OK);
    }

    @GetMapping("/categories/{category}")
    public ResponseEntity<PlayListRes> getPlayListByCategory(@PathVariable("category") String category) {
        PlayListRes playListRes = new PlayListRes();

        ArrayList newCategory = new ArrayList();
        newCategory.add(category);
        playListRes.setCategories(newCategory);

        playListRes.setPlays(playService.getPlayListsByCategory(category));
        return new ResponseEntity<>(playListRes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayDetailDto> getPlayDetail(@PathVariable("id") Long playId) {
        return new ResponseEntity<>(playService.getPlayDetailsByPlayId(playId), HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping("/new")
    public ResponseEntity<PlayDetailDto> postStudyDetail(@RequestBody PlayDetailReq playDetailReq) {
        return new ResponseEntity<>(playService.createPlay(playDetailReq), HttpStatus.OK);
    }
    @ResponseBody
    @PutMapping("/{id}")
    public ResponseEntity<PlayDetailDto> putStudyDetail(@PathVariable("id") Long playId, @RequestBody PlayDetailReq playDetailReq) {
        return new ResponseEntity<>(playService.updatePlay(playId, playDetailReq), HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteStudyDetail(@PathVariable("id") Long playId) {
        playService.deletePlay(playId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
