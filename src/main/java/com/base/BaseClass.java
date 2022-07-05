package com.base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BaseClass {

	protected static Page page;
	Playwright playwright;

	@BeforeClass
	public void setUp() {
		playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		page = browser.newPage();
	}
	
	@AfterClass
	public void tearDown() {
		page.context().browser().close();
	}
}
