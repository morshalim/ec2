package com.aws.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.StartInstancesRequest;
import com.amazonaws.services.ec2.model.StartInstancesResult;
import com.aws.service.AWSService;
import com.aws.service.EC2Service;

/**
 * @author Morshalim
 *
 */
@Service
public class EC2ServiceImpl implements EC2Service {
	
	private static Logger logger = LoggerFactory.getLogger(AWSServiceImpl.class);
	
	@Autowired
	private AWSService awsService;
	
	@Value("${instanceId}")
	private String instanceId;

	@Override
	public String startEC2() {
		String res = "fail";
		try {
			
			AmazonEC2 ec2 = awsService.getEC2Client();
			StartInstancesRequest request = new StartInstancesRequest().withInstanceIds(instanceId);
			@SuppressWarnings("unused")
			StartInstancesResult result = ec2.startInstances(request);
			res ="success";
		} catch (Exception e) {
			logger.error("Error:", e);
		}
		return res;
	}

}
