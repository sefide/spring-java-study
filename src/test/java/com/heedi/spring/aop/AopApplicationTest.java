package com.heedi.spring.aop;

import com.heedi.spring.aop.board.BoardService;
import com.heedi.spring.aop.user.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class AopApplicationTest {

    @Autowired
    private BoardService boardService;

    @Autowired
    private UserService userService;

    @Test
    void getBoards() {
        assertThat(boardService.getBoards().size()).isEqualTo(100);
    }

    @Test
    void getUsers() {
        assertThat(userService.getUsers().size()).isEqualTo(100);
    }

}