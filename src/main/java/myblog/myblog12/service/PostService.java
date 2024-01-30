package myblog.myblog12.service;

import myblog.myblog12.payload.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    PostDto createRegistartion(PostDto postDto);

    PostDto getRegistration(long id);

    List<PostDto> getAllRegistration(int pageNo, int pageSize, String shortBy);
}
