package org.socialsignin.provider.linkedin;

import org.socialsignin.provider.AbstractProviderService;
import org.springframework.social.linkedin.api.LinkedIn;
import org.springframework.stereotype.Service;

@Service
public class LinkedInProviderService extends AbstractProviderService<LinkedIn> {

	@Override
	public Class<LinkedIn> getApiClass() {
		return LinkedIn.class;
	}

	@Override
	public LinkedIn getUnauthenticatedApi() {
		// No unauthenticated API Available for LinkedIn - only Authenticated API is available
		return null;
	}

}
