package com.testcases;

import java.nio.file.Paths;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DownloadFile {

	protected static Page page;
	Playwright playwright;

	@BeforeClass
	public void setUp() {
		playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		page = browser.newPage();
	}

	@Test
	public void download() throws InterruptedException {
		page.navigate("https://nodejs.org/en/download/");
		Download download = page.waitForDownload(() -> {
			page.locator("a#windows-downloadbutton").click();
		});
		//download.cancel();
		//System.out.println("Download failure message: " + download.failure());
		System.out.println("Download url: " + download.url());
		System.out.println("Download page title: " + download.page().title());
		System.out.println("Download path : " + download.path().toString());
		download.saveAs(Paths.get("Nodejs.msi"));
		System.out.println("Suggested file name: " + download.suggestedFilename());
	}

	@AfterClass
	public void tearDown() {
		page.context().browser().close();
	}
}
