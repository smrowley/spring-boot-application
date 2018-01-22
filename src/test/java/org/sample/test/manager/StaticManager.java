package org.sample.test.manager;

public class StaticManager {

	public static CriteriaManager CRITERIA;
	public static ResultManager RESULTS;
	
	static {
		reset();
	}
		
	public static void reset() {
		CRITERIA = new CriteriaManager();
		RESULTS = new ResultManager();
	}
}
