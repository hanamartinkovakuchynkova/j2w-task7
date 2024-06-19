package service;

import entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import repository.PostRepository;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

//    public Page<Post> list() {
//        Pageable pageable = PageRequest.of(0, 20);
//        return postRepository.findAllByPublishedNotNullAndPublishedBeforeOrderByPublishedDesc(pageable);
//    }

    public Page<Post> list() {
//        Pageable pageable = PageRequest.of(0,20);
//        return postRepository.findAll(pageable);

        Pageable pageable = PageRequest.of(0,20);
        return postRepository.findBeforeToday(pageable);

    }

    public Post singlePost(String slug) {
        return postRepository.findBySlug(slug);
    }
}
