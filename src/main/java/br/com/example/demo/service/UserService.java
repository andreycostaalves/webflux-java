package br.com.example.demo.service;

import br.com.example.demo.entity.User;
import br.com.example.demo.mapper.UserMapper;
import br.com.example.demo.model.request.UserRequest;
import br.com.example.demo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public Mono<User> save(final UserRequest request){

        return userRepository.save(userMapper.toEntity(request));
    }

    public Mono<User> findById(final String id){
        return userRepository.findById(id);
    }
}
