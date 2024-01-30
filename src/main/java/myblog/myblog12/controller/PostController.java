package myblog.myblog12.controller;

import myblog.myblog12.payload.PostDto;
import myblog.myblog12.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//      http://localhost:8080/rest/api
@RestController
@RequestMapping("/rest/api")
public class PostController {
    private PostService service;

    public PostController(PostService service) {
        this.service = service;
    }
@PostMapping
    public ResponseEntity<PostDto> createRegistration(@RequestBody PostDto postDto){
        PostDto dto = service.createRegistartion(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
}
