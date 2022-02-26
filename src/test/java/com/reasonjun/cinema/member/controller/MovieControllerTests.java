package com.reasonjun.cinema.member.controller;

import com.reasonjun.cinema.member.MemberRepresentationModelAssembler;
import com.reasonjun.cinema.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(MemberController.class)
@Import({MemberRepresentationModelAssembler.class})
public class MovieControllerTests {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private MemberRepository repository;
}