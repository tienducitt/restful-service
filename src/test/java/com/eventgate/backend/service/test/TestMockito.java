package com.eventgate.backend.service.test;

import com.eventgate.backend.service.model.User;
import com.eventgate.backend.service.repository.UserRepository;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class TestMockito {

    @Mock
    UserRepository mockUserRepository;

    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void testMockito() {
        when(mockUserRepository.findById(anyInt())).thenReturn(Optional.of(new User()));

        User user = mockUserRepository.findById(1).orElse(null);
        assertNotNull(user);
        verify(mockUserRepository).findById(1);
    }
}
