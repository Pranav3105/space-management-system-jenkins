package com.mindtree.space_management_system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pranav
 *
 */
@RestController
@RequestMapping(value="/space-management")
public class HealthCheckController {
	@GetMapping(value="/health")
	public String healthCheck() {
		return "Server is up and Running";
	}
}