package wrappers;

import annots.ModelName;

public interface MobileApp {

	void assertAllFree(String type);

	void assertAvailable(String type, int expected);

	void refresh();

	void assertNearestParkSelected(String type);

	void validLogin();

	void invalidLogin();

	void emptyLogin();

	void assertInvalidLogin();

	void assertEmptyLogin();

}