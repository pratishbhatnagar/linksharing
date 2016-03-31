package com.ttnd.linksharing.service;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.web.multipart.MultipartFile;

import com.ttnd.linksharing.dto.ResourceDTO;

/**
 * 
 * @author Pratish Bhatnagar
 *
 */

public interface ResourceService {

	int saveLinkResource(ResourceDTO resourceDTO);
	ResourceDTO getResourceDTO(Integer id);
	List<ResourceDTO> getResourceDTOs();
	int saveDocumentResource(ResourceDTO documentResourceDTO, MultipartFile file, ServletContext context);
	
}
