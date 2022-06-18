package com.spring.controller;

import java.util.Locale;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.service.BoardService;

@Controller
@RequestMapping("/event/*")
public class EventController {
	
	@Inject
	BoardService service;
	
	// 한달만 초특급
	@RequestMapping(value = "/lowest_price", method = RequestMethod.GET)
	public String lowestPrice(Locale locale, Model model) {
		return "/event/lowest_price";
	}
	
	// 충칭
	@RequestMapping(value = "/chungqing", method = RequestMethod.GET)
	public String chungqing(Locale locale, Model model) {
		return "/event/chungqing";
	}
	
	// 일본
	@RequestMapping(value = "/japan", method = RequestMethod.GET)
	public String japan(Locale locale, Model model) {
		return "/event/japan";
	}
	
	// 다낭
	@RequestMapping(value = "/danang", method = RequestMethod.GET)
	public String danang(Locale locale, Model model) {
		return "/event/danang";
	}
	
	// 차박
	@RequestMapping(value = "/car_sleep", method = RequestMethod.GET)
	public String carSleep(Locale locale, Model model) {
		return "/event/car_sleep";
	} 
	
	// 캠핑카
	@RequestMapping(value = "/camping", method = RequestMethod.GET)
	public String campingCar(Locale locale, Model model) {
		return "/event/camping";
	}
	
	// 감성팝 100
	@RequestMapping(value = "/event07", method = RequestMethod.GET)
	public String eventPop(Locale locale, Model model) {
		return "/event/singPop100";
	}
}
