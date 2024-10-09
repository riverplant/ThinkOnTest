package com.example.ThinkOnDemo;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import jakarta.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ThinkOnDemoApplication.class)
@AutoConfigureMockMvc
@Transactional
public class BaseControllerTest {

}
