package com.qa.pages;
import com.microsoft.playwright.Page;

public class HomePage{
	Page page;
	
	private String search="input#search_query_top";
	
	HomePage(Page page) {
		this.page=page; 
	}	
	
	
	public SearchPage search(String searchTxt) {
		page.locator(search).fill(searchTxt);
		return new SearchPage(page);
	}
	
	
}
