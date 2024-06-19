package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.PostService;

@Controller
@RequestMapping("/")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

//    @GetMapping("")
//    public ModelAndView blog(@PageableDefault(size = 20) Pageable pageable) {
//        return new ModelAndView("index")
//                .addObject("posts", postService.list());
//    }

    @GetMapping("/post/{slug}")
    public Object detail(@PathVariable String slug) {
        return new ModelAndView("detail")
                .addObject("post", postService.singlePost(slug));
    }


    @GetMapping("")
    public ModelAndView index() {
        return new ModelAndView("index")
                .addObject("posts", postService.list());
    }



//    @GetMapping("/{slug}")
//    public Object detail(@PathVariable String slug) {
//        return new ModelAndView("detail")
//                .addObject("post", postService.singlePost(slug));
//    }
}
