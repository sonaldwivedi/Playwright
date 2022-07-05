package com.testcases;
import org.testng.annotations.Test;
import com.base.BaseClass;

public class play extends BaseClass{
	


	@Test
	public static void launch() {

		page.navigate("http://google.com");
		System.out.println(page.title());
	}
}
