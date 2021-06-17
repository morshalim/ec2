package com.aws.service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.services.ec2.AmazonEC2;

/**
 * @author Morshalim
 *
 */
public interface AWSService {

	public AWSCredentials generateCredentials();
	
	public AmazonEC2 getEC2Client();
}
