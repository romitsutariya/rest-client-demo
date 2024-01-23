package com.example.restclientdemo.post;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PostServiceTest {

    @Test
    void getAllPost() {
    }

    @Test
    void getPostById() {
    }

    @Test
    public void whenNotUseMockAnnotation_thenCorrect() {
        List<String> mockList = mock(ArrayList.class);

        mockList.add("one");
        verify(mockList).add("one");
        assertEquals(0, mockList.size());

        when(mockList.size()).thenReturn(100);
        assertEquals(100, mockList.size());
        System.out.println(mockList.size());
    }


}