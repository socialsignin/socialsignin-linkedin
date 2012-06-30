package org.socialsignin.provider.linkedin;

import org.socialsignin.provider.AbstractProviderService;
import org.springframework.social.linkedin.api.LinkedIn;
import org.springframework.stereotype.Service;

@Service
public class LinkedInProviderService extends AbstractProviderService<LinkedIn,LinkedInProviderConfig> {

	

	public LinkedInProviderService() {
		super();
	}

	public LinkedInProviderService(LinkedInProviderConfig providerConfig) {
		super(providerConfig);
	}

	@Override
	public LinkedIn getUnauthenticatedApi() {
		// No unauthenticated API Available for LinkedIn - only Authenticated API is available
		return null;
	}

}
