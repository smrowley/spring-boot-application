package org.sample.integrationtest.util;

import java.util.HashMap;
import java.util.Map;

public class Props {

	private static Map<Key, String> properties;
	
	public static void init() {
		properties = new HashMap<>();
		
		for (Key key : Key.values()) {
			properties.put(key, System.getProperty(key.getPropName()));
		}
	}
	
	public static String getValue(Key key) {
		return properties.get(key);
	}
	
	public enum Key {
		ROUTE("openshift.route");
		
		private String propName;
		
		private Key(String propName) {
			this.propName = propName;
		}
		
		public String getPropName() {
			return this.propName;
		}
	}
}
