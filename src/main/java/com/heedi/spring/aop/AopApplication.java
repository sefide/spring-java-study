package com.heedi.spring.aop;

import com.heedi.spring.aop.board.Board;
import com.heedi.spring.aop.board.BoardRepository;
import com.heedi.spring.aop.board.BoardService;
import com.heedi.spring.aop.common.Performance;
import com.heedi.spring.aop.user.User;
import com.heedi.spring.aop.user.UserRepository;
import com.heedi.spring.aop.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@EnableAspectJAutoProxy
public class AopApplication implements CommandLineRunner {

    @Autowired
    private BoardService boardService;

    @Autowired
    private UserService userService;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("run 실행");

        for (int i = 1; i <= 100; i++) {
            boardRepository.save(new Board(i + "번째 게시글의 제목", i + "번째 게시글의 내용"));
            userRepository.save(new User(i + "@email.com", i + "번째 사용자"));
        }
    }

    @GetMapping("/boards")
    public List<Board> getBoards() {
        return boardService.getBoards();
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);
    }

//    @Bean
//    public Performance performance() {
//        return new Performance();
//    }
}
