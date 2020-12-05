package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.NodeService;
/*
 * Rest controller for checking connected routes
 * 
 */
@RestController
public class ConnectController {

	@Autowired
	NodeService nodeService;

	/*
	 * Origin - is the source city
	 * Destination - is the destination city to check
	 * Returns Yes if source is connected to destination
	 * Returns No If source is not connected to destination
	 */
	
	@GetMapping("/connected")
	public String findConnected(@RequestParam("origin") String source,
			@RequestParam("destination") String destination) {

		return nodeService.getPath(source, destination);
	}

}
