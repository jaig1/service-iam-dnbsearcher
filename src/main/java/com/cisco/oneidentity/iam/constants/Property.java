package com.cisco.oneidentity.iam.constants;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

public enum Property {
	
	ACCESS_TOCKEN_ENDPOINT,
	ACCESS_TOCKEN_URI,
	DNB_SEARCH_ENDPOINT,
	DNB_SEARCH_URI;
	

	private static Properties props;
	private static final Logger LOGGER = LoggerFactory.getLogger(Property.class);

	private String value;
	
	private void init() {
		//TODO: Pass cisco.life property through -Dconfpath = option and resolve the property file corresponding to the life cycle.
		if (props == null) {
			props = new Properties();
			try {
				ClassPathResource resource = new ClassPathResource("dev.dnb.properties");
				props.load(resource.getInputStream());
			} catch (Exception e) {
				LOGGER.error(e.getMessage() + e.getStackTrace());
			}
		}
		value = (String) props.get(this.toString());
	}

	public String getValue() {
		if (value == null) {
			init();
		}
		return value;
	}
}

