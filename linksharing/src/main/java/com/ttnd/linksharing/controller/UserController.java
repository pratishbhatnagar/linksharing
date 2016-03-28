package com.ttnd.linksharing.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ttnd.linksharing.dto.TopicDTO;
import com.ttnd.linksharing.dto.UserDTO;
import com.ttnd.linksharing.service.TopicService;
import com.ttnd.linksharing.service.UserService;

/**
 * 
 * @author Pratish Bhatnagar
 *
 */

@Controller
@RequestMapping("/")
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	TopicService topicService;
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping("/")
	public ModelAndView welcomePage(HttpServletRequest request, HttpServletResponse response) {
		if (request.getSession().getAttribute("userDTO") == null) {
			return new ModelAndView("login");
		} else {
			return new ModelAndView("user-home");
		}
	}

	@RequestMapping(value = "register")
	public ModelAndView registerUser(@ModelAttribute UserDTO userDTO, HttpServletRequest request,
			HttpServletResponse response) {
		int id = 0;
		if (userDTO != null) {
			id = userService.saveUser(userDTO);
			HttpSession session = request.getSession();
			session.setAttribute("userDTO", userDTO);
		}
		if (id != 0) {
			return new ModelAndView("user-home");
		} else {
			return new ModelAndView("login");
		}
	}

	@RequestMapping(value = "login")
	public ModelAndView loginUser(@ModelAttribute UserDTO userDTO, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelAndView;
		userDTO = userService.getUserDTO(userDTO);
		if (userDTO != null) {
			request.getSession().setAttribute("userDTO", userDTO);
			System.out.println(request.getSession().getAttribute("userDTO"));
			modelAndView = new ModelAndView("user-home");
			modelAndView.addObject("userDTO", userDTO);
		} else {
			modelAndView = new ModelAndView("login");
		}
		return modelAndView;
	}

	@RequestMapping(value = "logout")
	public ModelAndView logoutUser(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		logger.info("User logged out : " + session.getAttribute("userDTO"));
		session.invalidate();
		return new ModelAndView("login");
	}

	@RequestMapping(value = "createTopic")
	public ModelAndView createTopic(@ModelAttribute TopicDTO topicDTO, HttpServletRequest request,
			HttpServletResponse response) {
		UserDTO userDTO = (UserDTO) request.getSession().getAttribute("userDTO");
		topicDTO.setCreatedBy(userDTO);
		int id = topicService.saveTopic(topicDTO);
		if (id == 0) {
			logger.warn("Topic not saved!");
		} else {
			logger.info("Topic saved : " + topicDTO);
		}
		return new ModelAndView("user-home");
	}

	@RequestMapping("*")
	public ModelAndView fallbackMethod(HttpServletRequest request, HttpServletResponse response) {
		if (request.getSession().getAttribute("userDTO") == null) {
			return new ModelAndView("login");
		} else {
			return new ModelAndView("user-home");
		}
	}

}
