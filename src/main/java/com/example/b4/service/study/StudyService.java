package com.example.b4.service.study;

import com.example.b4.dto.study.StudyDetailDto;
import com.example.b4.dto.study.StudyDetailReq;
import com.example.b4.entity.post.Study;
import com.example.b4.entity.user.User;
import com.example.b4.repository.PostRepository;
import com.example.b4.repository.study.StudyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudyService {

    private final PostRepository postRepository;
    private final StudyRepository studyRepository;

    public StudyDetailDto createStudy(StudyDetailReq req) {
//        User user = new User();
//        user.setUserId(1L);
//        user.setUserNickname("user1");

        Study buildStudy = Study.builder()
                .category(req.getCategory())
                .bookmark(Boolean.TRUE)
                .user(null)
                .attachedFile(req.getStudyAttachedFile())
                .title(req.getTitle())
                .studyDetails(req.getStudyDetails())
                .build();

        Study save = studyRepository.save(buildStudy);
        return null;
//        return new StudyDetailDto(save.getCategory(), save.getTitle(), save.getUser().getUserNickname(), save.getStudyDetails(), save.getAttachedFile());

    }




}
