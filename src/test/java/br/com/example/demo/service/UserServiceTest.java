package br.com.example.demo.service;

import br.com.example.demo.entity.User;
import br.com.example.demo.mapper.UserMapper;
import br.com.example.demo.model.request.UserRequest;
import br.com.example.demo.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository repository;

    @Mock
    private UserMapper mapper;

    @InjectMocks
    private UserService service;


    @Test
    void save() {
        UserRequest request = new UserRequest("andrey","andrey.alves@gmail.com", "123");
        User entity = User.builder().build();
        when(mapper.toEntity(any(UserRequest.class))).thenReturn(entity);
        when(repository.save(any(User.class))).thenReturn(Mono.just(User.builder().build()));

        Mono<User> result = service.save(request);

        StepVerifier.create(result)
                .expectNextMatches(user -> user.getClass()== User.class)
                .expectComplete()
                .verify();
        Mockito.verify(repository, times(1)).save(any(User.class));

    }

    @Test
    void testFindById(){
        when(repository.findById(anyString())).thenReturn(Mono.just(User.builder().id("123").build()));

        Mono<User> result = service.findById("123");

        StepVerifier.create(result)
                .expectNextMatches(user -> user.getClass()== User.class)
                .expectComplete()
                .verify();
        Mockito.verify(repository, times(1)).findById(anyString());
    }
}