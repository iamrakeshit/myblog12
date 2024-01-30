package myblog.myblog12.controller;

import myblog.myblog12.entity.Post;
import myblog.myblog12.payload.PostDto;
import myblog.myblog12.repository.PostRepository;
import myblog.myblog12.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    //      Http://localhost:8080/rest/api/findById?id=4
    @GetMapping("/findById")
    public ResponseEntity<PostDto> getRegistration(@RequestParam long id){
        PostDto getid = service.getRegistration(id);
        return new ResponseEntity<>(getid,HttpStatus.OK);
    }
}
