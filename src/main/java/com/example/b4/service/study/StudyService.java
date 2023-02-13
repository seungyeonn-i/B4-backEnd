package com.example.b4.service.study;

import com.example.b4.dto.study.StudyDetailDto;
import com.example.b4.dto.study.StudyDetailReq;
import com.example.b4.dto.study.StudyListDto;
import com.example.b4.entity.post.Post;
import com.example.b4.entity.post.Study;
import com.example.b4.entity.user.User;
import com.example.b4.repository.PostRepository;
import com.example.b4.repository.UserRepository;
import com.example.b4.repository.comment.CommentRepository;
import com.example.b4.repository.study.StudyRepository;
import com.example.b4.service.comment.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudyService {

    private final PostRepository postRepository;
    private final StudyRepository studyRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final CommentService commentService;

    public StudyDetailDto createStudy(StudyDetailReq req) {
//            user.setUserId(1L);
//            user.setUserNickname("user1");
        // TODO : JWT로 교체
        User user = userRepository.findById(1L).get();

        Post newPost = Post.builder()
                .bookmark(Boolean.TRUE)
                .user(user)
                .title(req.getTitle())
                .attachedFile(req.getStudyAttachedFile())
                .category(req.getCategory())
                .build();
        Post savedPost = postRepository.save(newPost);

        Study newStudy = Study.builder()
                .post(savedPost)
                .studyDetails(req.getStudyDetails())
                .build();
        Study savedStudy = studyRepository.save(newStudy);
        return new StudyDetailDto(savedPost.getCategory(), savedPost.getTitle(), savedPost.getUser().getUserNickname(),savedStudy.getStudyDetails(), savedPost.getAttachedFile(),savedPost.getCreatedDate());

    }

    // return All Post
    public List<Post> getAllStudy() {
        return postRepository.findAll();
    }

    // return All StudyListDto
    public List<StudyListDto> getStudyLists(){
        return studyRepository.findStudyListDto();
    }

    // return category StudyListDto
    public List<StudyListDto> getStudyListsByCategory(String category) {
        return studyRepository.findStudyCategoryListDto(category);
    }

    // return StudyDetailDto
    public List<StudyDetailDto> getStudyDetail() {
        return studyRepository.findStudyDetailDto();
    }
    // return
    public StudyDetailDto getStudyDetailByPostId(Long postId) {

        StudyDetailDto getStudyDetail = studyRepository.findByPostIdDetailDto(postId);
        getStudyDetail.setComments(commentService.readComments(postId));
        return getStudyDetail;
    }






}