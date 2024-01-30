package myblog.myblog12.service.impl;

import myblog.myblog12.entity.Post;
import myblog.myblog12.exception.ResourseNotFoundException;
import myblog.myblog12.payload.PostDto;
import myblog.myblog12.repository.PostRepository;
import myblog.myblog12.service.PostService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository repository;

    public PostServiceImpl(PostRepository repository) {
        this.repository = repository;
    }

    @Override
    public PostDto createRegistartion(PostDto postDto) {
        Post post = mapToEntity(postDto);
        Post spost = repository.save(post);
        PostDto dto = mapTODto(spost);
        return dto;
    }

    @Override
    public PostDto getRegistration(long id) {
        Post post = repository.findById(id).orElseThrow(
                ()->new ResourseNotFoundException("data is not found with id "+id)
        );
        PostDto dto = mapTODto(post);
        return dto;
    }

    Post mapToEntity(PostDto postDto){
       Post post = new Post();
       post.setName(postDto.getName());
       post.setEmail(postDto.getEmail());
       post.setMobile(postDto.getMobile());
       return post;
    }
    PostDto mapTODto(Post post){
        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setName(post.getName());
        dto.setEmail(post.getEmail());
        dto.setMobile(post.getMobile());
        return dto;
    }
}
