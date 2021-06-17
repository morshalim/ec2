package com.aws.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.aws.service.AWSService;

/**
 * @author Morshalim
 *
 */
@Service
public class AWSServiceImpl implements AWSService{
	
	private static Logger logger = LoggerFactory.getLogger(AWSServiceImpl.class);
	
	@Value("${acccessKey}")
	private String accessKey;
	
	@Value("${secretKey}")
	private String secretKey;
	
	@Override
	public AWSCredentials generateCredentials() {
		try {
			
			logger.debug("acccessKey:"+accessKey+",,,,,secretKey:"+secretKey);
			
			AWSCredentials credentials = new BasicAWSCredentials(accessKey,secretKey);
			return credentials;
			
		} catch (Exception e) {
			logger.error("Error :", e);
			return null;
		}
	}

	@Override
	public AmazonEC2 getEC2Client() {
		AmazonEC2 ec2Client = AmazonEC2ClientBuilder
				  .standard()
				  .withCredentials(new AWSStaticCredentialsProvider(this.generateCredentials()))
				  .withRegion(Regions.AP_SOUTH_1)
				  .build();
		return ec2Client;
	}

}
