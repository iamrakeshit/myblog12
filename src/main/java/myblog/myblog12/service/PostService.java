package myblog.myblog12.service;

import myblog.myblog12.payload.PostDto;
import org.springframework.stereotype.Service;

@Service
public interface PostService {

    PostDto createRegistartion(PostDto postDto);
}
