package com.library.service;

import com.library.config.CustomTestConfiguration;
import com.library.dto.enums.UserRole;
import com.library.dto.enums.UserStatus;
import com.library.exceptions.UserAlreadyExistException;
import com.library.model.BookRepository;
import com.library.model.UserRepository;
import com.library.model.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = CustomTestConfiguration.class)
class UserServiceTest {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private BookRepository bookRepository;

    @Autowired
    private UserService userService;

    @Captor
    ArgumentCaptor<User> userCaptor;

   private static final String USER_PASSWORD = "123Password";



    @Test
    void testRegisterShouldCreateUser() {
        when(userRepository.findByEmail(any())).thenReturn(Optional.empty());

        User user = mockUser();
        userService.register(user);

        verify(userRepository).save(userCaptor.capture());

        verify(userRepository, times(1)).findByEmail(any());
        verify(userRepository, times(1)).save(any());

        User updatedUser = mockUserWithUpdatedData();

        User capturedUser = userCaptor.getValue();
        assertThat(updatedUser, equalTo(capturedUser));
        assertTrue(bCryptPasswordEncoder.matches(USER_PASSWORD, updatedUser.getPassword()));
        assertThat(updatedUser.getUserRole(), equalTo(capturedUser.getUserRole()));
        assertThat(updatedUser.getUserStatus(), equalTo(capturedUser.getUserStatus()));
    }

    @Test
    public void testRegisterShouldThrowUserAlreadyExistException() {
        User user = mockUser();
        when(userRepository.findByEmail(any())).thenReturn(Optional.of(user));
        assertThrows(UserAlreadyExistException.class, () -> userService.register(user),
                String.format("User with specified email already exist %s", user.getEmail()));
    }


    private User mockUser() {
        return new User(1, "Oleksandr", "Yanov", "oleksandr1@gmail.com",
                null, null, USER_PASSWORD);
    }

    private User mockUserWithUpdatedData() {
        return new User(1, "Oleksandr", "Yanov", "oleksandr1@gmail.com",
                UserRole.ROLE_USER, UserStatus.ACTIVE, "$2a$10$cSwh8hhFS2ZJ1FGldkNGbeD6aH7ZwkdL2FF1Mi8LPvBM60xGKZAE2");
    }
}