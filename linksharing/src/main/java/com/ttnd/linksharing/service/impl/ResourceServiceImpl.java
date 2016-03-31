package com.ttnd.linksharing.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.ttnd.linksharing.dao.ResourceDAO;
import com.ttnd.linksharing.dto.ResourceDTO;
import com.ttnd.linksharing.dto.TopicDTO;
import com.ttnd.linksharing.dto.UserDTO;
import com.ttnd.linksharing.entities.DocumentResource;
import com.ttnd.linksharing.entities.LinkResource;
import com.ttnd.linksharing.entities.Resource;
import com.ttnd.linksharing.entities.Topic;
import com.ttnd.linksharing.entities.User;
import com.ttnd.linksharing.service.ResourceService;
import com.ttnd.linksharing.service.TopicService;
import com.ttnd.linksharing.service.UserService;

/**
 * 
 * @author Pratish Bhatnagar
 *
 */

public class ResourceServiceImpl implements ResourceService {

	private static final Logger logger = LoggerFactory.getLogger(ResourceServiceImpl.class);
	@Autowired
	ResourceDAO resourceDAO;
	@Autowired
	TopicService topicService;
	@Autowired
	UserService userService;

	@Override
	public int saveLinkResource(ResourceDTO linkResourceDTO) {
		logger.trace("Inside saveLinkResource method");
		int id = 0;
		if (linkResourceDTO != null) {
			Resource linkResource = new LinkResource(linkResourceDTO.getDescription(),
					userService.getUser(linkResourceDTO.getCreatedBy()),
					topicService.getTopic(linkResourceDTO.getTopicId()), new Date(), new Date(),
					linkResourceDTO.getUrl());
			id = resourceDAO.saveResource(linkResource);
		}
		return id;
	}

	@Override
	public int saveDocumentResource(ResourceDTO documentResourceDTO, MultipartFile file, ServletContext context) {
		logger.trace("Inside saveDocumentResource method");
		int id = 0;
		try {
			String webPath = context.getRealPath("/");
			System.out.println(webPath);
			File file2 = new File(webPath + "/src/main/webapp/Topics/" + documentResourceDTO.getTopicId()
					+ "/documents/" + documentResourceDTO.getCreatedBy().getUsername() + new Date().getTime());
			System.out.println(file2);
			Resource documentResource = new DocumentResource(documentResourceDTO.getDescription(),
					userService.getUser(documentResourceDTO.getCreatedBy()),
					topicService.getTopic(documentResourceDTO.getTopicId()), new Date(), new Date(),
					file2.getAbsolutePath());
			file2.mkdirs();
			file2.createNewFile();
			file.transferTo(file2);
			id = resourceDAO.saveResource(documentResource);
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		return id;
	}

	@Override
	public List<ResourceDTO> getResourceDTOs() {
		logger.trace("Inside getResourceDTOs method");
		List<ResourceDTO> resourceDTOs = new ArrayList<>();
		List<Resource> resources = resourceDAO.getResources();
		for (Resource resource : resources) {
			resourceDTOs.add(resourceToResourceDTO(resource));
		}
		return resourceDTOs;
	}

	@Override
	public ResourceDTO getResourceDTO(Integer id) {
		Resource resource = resourceDAO.getResource(id);
		return resourceToResourceDTO(resource);
	}

	private ResourceDTO resourceToResourceDTO(Resource resource) {
		ResourceDTO resourceDTO;
		Topic topic = resource.getTopic();
		User topicCreator = topic.getCreatedBy(), resourceCreator = resource.getCreatedBy();
		String url, filePath;
		UserDTO userDTO = new UserDTO(topicCreator.getEmail(), topicCreator.getUsername(), topicCreator.getPassword(),
				topicCreator.getFirstName(), topicCreator.getLastName());
		TopicDTO topicDTO = new TopicDTO(topic.getName(), userDTO, topic.getVisibility());
		userDTO = new UserDTO(resourceCreator.getEmail(), resourceCreator.getUsername(), resourceCreator.getPassword(),
				resourceCreator.getFirstName(), resourceCreator.getLastName());
		if (resource instanceof LinkResource) {
			url = ((LinkResource) resource).getUrl();
			filePath = null;
		} else {
			url = null;
			filePath = ((DocumentResource) resource).getFilePath();
		}
		resourceDTO = new ResourceDTO(topic.getTopicId(), resource.getDescription(), userDTO, url, filePath);
		resourceDTO.setTopicDTO(topicDTO);
		return resourceDTO;
	}

}
