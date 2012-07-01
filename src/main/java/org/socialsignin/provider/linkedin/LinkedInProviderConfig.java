/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.socialsignin.provider.linkedin;

import org.socialsignin.provider.AbstractProviderConfig;
import org.socialsignin.springsocial.security.LinkedInConnectInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.connect.web.ConnectInterceptor;
import org.springframework.social.linkedin.api.LinkedIn;
import org.springframework.social.linkedin.api.impl.LinkedInTemplate;
import org.springframework.social.linkedin.connect.LinkedInConnectionFactory;

/** 
* @author Michael Lavelle
*/
@Configuration
public class LinkedInProviderConfig extends AbstractProviderConfig<LinkedIn> {

	@Autowired(required=false)
	private LinkedInConnectInterceptor linkedInConnectInterceptor;

	@Value("${linkedin.apiKey}")
	private String linkedInClientId;

	@Value("${linkedin.secretKey}")
	private String linkedInClientSecret;
	
	public LinkedInProviderConfig() {
		super();
	}
	
	public LinkedInProviderConfig(String linkedInClientId,
			LinkedIn authenticatedApi) {
		super(authenticatedApi);
		this.linkedInClientId = linkedInClientId;
	}
	

	public LinkedInProviderConfig(String linkedInClientId,String linkedInClientSecret,String accessToken,String accessTokenSecret) {
		super(new LinkedInTemplate(linkedInClientId,linkedInClientSecret,accessToken,accessTokenSecret));
		this.linkedInClientId = linkedInClientId;
		this.linkedInClientSecret = linkedInClientSecret;
	}
	
	public LinkedInProviderConfig(String linkedInClientId,String linkedInClientSecret,ConnectionRepository connectionRepository,
			ConnectionFactoryRegistry connectionFactoryRegistry) {
		super(connectionRepository, connectionFactoryRegistry);
		this.linkedInClientSecret = linkedInClientSecret;
		this.linkedInClientSecret  = linkedInClientSecret;
	}

	public LinkedInProviderConfig(String linkedInClientId,String linkedInClientSecret,ConnectionRepository connectionRepository,
			UsersConnectionRepository usersConnectionRepository,
			ConnectionFactoryRegistry connectionFactoryRegistry) {
		super(connectionRepository, usersConnectionRepository,
				connectionFactoryRegistry);
		this.linkedInClientId = linkedInClientSecret;
		this.linkedInClientSecret  = linkedInClientSecret;
	}
	
	public LinkedInProviderConfig(String linkedInClientId,String linkedInClientSecret,String userId,	UsersConnectionRepository usersConnectionRepository,
			ConnectionFactoryRegistry connectionFactoryRegistry) {
		super(userId,usersConnectionRepository,
				connectionFactoryRegistry);
		this.linkedInClientId = linkedInClientId;
		this.linkedInClientSecret  = linkedInClientSecret;
	}
	
	public void setLinkedInClientId(String linkedInClientId) {
		this.linkedInClientId = linkedInClientId;
	}

	public void setLinkedInClientSecret(String linkedInClientSecret) {
		this.linkedInClientSecret = linkedInClientSecret;
	}

	@Override
	protected ConnectionFactory<LinkedIn> createConnectionFactory() {
		return new LinkedInConnectionFactory(linkedInClientId, linkedInClientSecret);
	}

	@Override
	protected ConnectInterceptor<LinkedIn> getConnectInterceptor() {
		return linkedInConnectInterceptor;
	}

	@Override
	public Class<LinkedIn> getApiClass() {
		return LinkedIn.class;
	}

}
