package com.ttnd.linksharing.utils.enums;

/**
 * 
 * @author Pratish Bhatnagar
 *
 */

public enum Visibility {

	PUBLIC(1), PRIVATE(0);

	private final int visibility;

	private Visibility(int visibility) {
		this.visibility = visibility;
	}

	int getVisibility() {
		return this.visibility;
	}

}
