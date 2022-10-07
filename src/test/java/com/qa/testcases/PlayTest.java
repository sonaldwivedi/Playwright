package com.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.pages.BaseTest;

public class PlayTest extends BaseTest {

	@Test(priority = 1)
	public void verifyTitle() {
		Assert.assertEquals(page.title(), "My Store");
	}

	@Test(priority = 2)
	public void verifySearch() {
		search = hp.search("dress");
		page.keyboard().press("Enter");
		Assert.assertEquals(search.getSearchText().trim().toLowerCase(), "\"dress\"");
	}
}
