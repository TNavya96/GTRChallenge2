package com.gtr.pageobject;

public class SixthTestCasePO {
	public static String slider="//*[@class='dy-slick-arrow dy-next-arrow slick-arrow']";
	public static String liveMarket="//*[text()='Live Market']";
	public static String topTenGainersOrLosers="//*[contains(text(),'Top Ten Gainers / Losers')]";
	public static String headers="//table[@id='topGainers']//tbody/tr[1]/th";
	public static String symbolNames="//*[contains(@href,'/live_market/dynaContent/live_watch/get_quote/GetQuote.jsp?symbol')]";
	public static String tableValues="//table[@id='topGainers']//tbody/tr/td";

}
