package com.ttnd.linksharing.utils.enums;

/**
 * 
 * @author Pratish Bhatnagar
 *
 */

public enum Seriousness {

	CASUAL(0), SERIOUS(1), VERY_SERIOUS(2);

	private final int seriousness;

	private Seriousness(int seriousness) {
		this.seriousness = seriousness;
	}

	int getSeriousness() {
		return this.seriousness;
	}

}
