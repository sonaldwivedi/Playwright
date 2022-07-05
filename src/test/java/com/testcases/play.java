package com.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.*;

public class play {
	static Page page;
	Playwright playwright;

	@BeforeTest
	public void setUp() {
		playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		page = browser.newPage();
	}

	@Test
	public static void launch() {

		page.navigate("http://google.com");
		System.out.println(page.title());
	}
}
