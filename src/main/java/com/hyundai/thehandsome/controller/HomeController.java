package com.hyundai.thehandsome.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	@GetMapping(value = "/")
	public String memberForm(Model model) {

		return "main";
	}

	@GetMapping(value = "/member/testpage")
	public String main(Model model) {

		return "mypage/mypage";
	}

	@GetMapping(value = "/main")
	public String main2(Model model) {
		log.info("exMember.....");
		log.info("--------------");

		return "main";
	}

}
