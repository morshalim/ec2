package com.aws.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aws.service.EC2Service;

/**
 * @author Morshalim
 *
 */
@RestController
@RequestMapping(value="/ec2")
public class Controller {
	
	private static Logger logger = LoggerFactory.getLogger(Controller.class);
	
	@Autowired
	private EC2Service ec2Service;
	
	@GetMapping("/test")
	public String test() {
		
		return "app is running";
	}
	
	@GetMapping("/start")
	public String startEC2() {
		logger.debug("EC2 starting request received.");
		return ec2Service.startEC2();
	}

}
