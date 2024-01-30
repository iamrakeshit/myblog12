package myblog.myblog12.service;

import myblog.myblog12.entity.Post;
import myblog.myblog12.payload.PostDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface PostService {

    PostDto createRegistartion(PostDto postDto);

    PostDto getRegistration(long id);
}
