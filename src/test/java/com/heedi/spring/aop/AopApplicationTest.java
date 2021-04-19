package com.heedi.spring.aop;

import com.heedi.spring.aop.board.BoardService;
import com.heedi.spring.aop.history.History;
import com.heedi.spring.aop.history.HistoryRepository;
import com.heedi.spring.aop.user.User;
import com.heedi.spring.aop.user.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class AopApplicationTest {

    @Autowired
    private BoardService boardService;

    @Autowired
    private UserService userService;

    @Autowired
    private HistoryRepository historyRepository;

    @Test
    void getBoards() {
        assertThat(boardService.getBoards().size()).isEqualTo(100);
    }

    @Test
    void getUsers() {
        assertThat(userService.getUsers().size()).isEqualTo(100);
    }

    @Test
    void updateUsers() throws Exception {
        List<User> users = userService.getUsers();

        for (int i = 0; i < 5; i++) {
            User user = users.get(i);
            user.setEmail("momo@catwolrd.com");
            userService.update(user);
        }

        List<History> histories = historyRepository.findAll();

        assertThat(histories.size()).isEqualTo(5);
        assertThat(histories.get(0).getUserIdx()).isEqualTo(users.get(0).getIdx());
        assertThat(histories.get(1).getUserIdx()).isEqualTo(users.get(1).getIdx());
    }
}