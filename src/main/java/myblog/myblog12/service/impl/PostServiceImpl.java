package myblog.myblog12.service.impl;

import myblog.myblog12.entity.Post;
import myblog.myblog12.exception.ResourseNotFoundException;
import myblog.myblog12.payload.PostDto;
import myblog.myblog12.repository.PostRepository;
import myblog.myblog12.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<PostDto>
    getAllRegistration(int pageNo, int pageSize, String shortBy, String sortDir) {
       Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(shortBy).ascending() : Sort.by(shortBy).descending();
        Pageable pageable = PageRequest.of(pageNo,pageSize, sort);
        Page<Post> pagePost = repository.findAll(pageable);
        List<Post> posts = pagePost.getContent();
        List<PostDto> dto = posts.stream().map(post -> mapTODto(post)).collect(Collectors.toList());
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
