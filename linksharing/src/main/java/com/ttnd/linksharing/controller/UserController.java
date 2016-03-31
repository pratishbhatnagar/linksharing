package com.ttnd.linksharing.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ttnd.linksharing.dto.ResourceDTO;
import com.ttnd.linksharing.dto.TopicDTO;
import com.ttnd.linksharing.dto.UserDTO;
import com.ttnd.linksharing.service.ResourceService;
import com.ttnd.linksharing.service.SubscriptionService;
import com.ttnd.linksharing.service.TopicService;
import com.ttnd.linksharing.service.UserService;
import com.ttnd.linksharing.utils.enums.Seriousness;

/**
 * 
 * @author Pratish Bhatnagar
 *
 */

@Controller
@RequestMapping("/")
public class UserController implements ServletContextAware {

	@Autowired
	UserService userService;
	@Autowired
	TopicService topicService;
	@Autowired
	ResourceService resourceService;
	@Autowired
	SubscriptionService subscriptionService;
	ServletContext servletContext;
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	@RequestMapping("/")
	public ModelAndView welcomePage(HttpServletRequest request, HttpServletResponse response) {
		return getView(request);
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute UserDTO userDTO,
			@RequestParam(name = "confirmPassword", required = true) String confirmPassword, HttpServletRequest request,
			HttpServletResponse response) {
		int id = 0;
		if (userDTO != null && userDTO.getPassword().equals(confirmPassword)) {
			id = userService.saveUser(userDTO);
		}
		if (id != 0) {
			request.getSession().setAttribute("userDTO", userDTO);
		}
		return getView(request);
	}

	@RequestMapping(value = "login")
	public ModelAndView loginUser(@ModelAttribute UserDTO userDTO, HttpServletRequest request,
			HttpServletResponse response) {
		userDTO = userService.getUserDTO(userDTO);
		if (userDTO != null) {
			request.getSession().setAttribute("userDTO", userDTO);
			logger.info(userDTO + "saved in session");
		}
		return getView(request).addObject("userDTO", userDTO);
	}

	@RequestMapping(value = "logout")
	public ModelAndView logoutUser(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		logger.info("User logged out : " + session.getAttribute("userDTO"));
		session.invalidate();
		return getView(request);
	}

	@RequestMapping(value = "createTopic", method = RequestMethod.POST)
	public ModelAndView createTopic(@ModelAttribute TopicDTO topicDTO, HttpServletRequest request,
			HttpServletResponse response) {
		UserDTO userDTO = (UserDTO) request.getSession().getAttribute("userDTO");
		topicDTO.setCreatedBy(userDTO);
		int id = topicService.saveTopic(topicDTO);
		if (id == 0) {
			logger.warn("Topic not saved!");
		} else {
			logger.info("Topic saved : " + topicDTO);
			subscribeTopic(id, Seriousness.VERY_SERIOUS, request, response);
		}
		return getView(request);
	}

	@RequestMapping(value = "createLinkResource", method = RequestMethod.POST)
	public ModelAndView createLinkResource(@ModelAttribute ResourceDTO linkResourceDTO, HttpServletRequest request,
			HttpServletResponse response) {
		logger.trace("Inside createLinkResource method");
		UserDTO userDTO = (UserDTO) request.getSession().getAttribute("userDTO");
		linkResourceDTO.setCreatedBy(userDTO);
		int id = resourceService.saveLinkResource(linkResourceDTO);
		if (id == 0) {
			logger.warn("Resource not saved");
		} else {
			logger.info("Resource saved : " + linkResourceDTO);
		}
		return getView(request);
	}

	@RequestMapping(value = "createDocumentResource", method = RequestMethod.POST)
	public ModelAndView createDocumentResource(@ModelAttribute ResourceDTO documentResourceDTO,
			@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("Inside createDocumentResource method");
		UserDTO userDTO = (UserDTO) request.getSession().getAttribute("userDTO");
		documentResourceDTO.setCreatedBy(userDTO);
		int id = resourceService.saveDocumentResource(documentResourceDTO, file, servletContext);
		if (id == 0) {
			logger.warn("Document not saved");
		} else {
			logger.info("Document saved : " + documentResourceDTO);
		}
		return getView(request);
	}

	@RequestMapping(value = "subscribeTopic")
	public ModelAndView subscribeTopic(@RequestParam(value = "topicId", required = true) Integer topicId,
			@RequestParam(value = "seriousness", required = true) Seriousness seriousness, HttpServletRequest request,
			HttpServletResponse response) {
		logger.trace("Inside subscribeTopic method");
		UserDTO userDTO = (UserDTO) request.getSession().getAttribute("userDTO");
		if (userDTO != null) {
			int id = subscriptionService.saveSubscription(topicId, userDTO, seriousness);
			if (id == 0) {
				logger.warn("Topic not subscribed!");
			} else {
				logger.info("Topic subscribed");
			}
		}
		return getView(request);
	}

	@RequestMapping("*")
	public ModelAndView fallbackMethod(HttpServletRequest request, HttpServletResponse response) {
		logger.info("Inside fallbackMethod");
		return getView(request);
		// return new ModelAndView("view-resource");
	}

	public ModelAndView getView(HttpServletRequest request) {
		ModelAndView modelAndView;
		UserDTO userDTO = (UserDTO) request.getSession().getAttribute("userDTO");
		if (userDTO == null) {
			modelAndView = new ModelAndView("login");
			modelAndView.addObject("resourceDTOs", resourceService.getResourceDTOs());
		} else {
			modelAndView = new ModelAndView("user-home");
			// modelAndView.addObject("userDTO", userDTO);
			modelAndView.addObject("topicDTOs", topicService.getTopicDTOs());
			modelAndView.addObject("resourceDTOs", resourceService.getResourceDTOs());
		}
		return modelAndView;
	}

}
