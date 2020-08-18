package com.qait.tests;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qait.automation.TestSessionInitiator;
import com.qait.automation.utils.YamlReader;

public class BasicCourseTest extends TestSessionInitiator {

	@Test(priority = 1, enabled = false)
	public void launchApplication() throws Throwable {
		basicCourse.launchApplicationUrl();
		String url = basicCourse.getCurrentURL();
		Assert.assertEquals(url, "https://www.makemytrip.com/");
		basicCourse.clickOnLogin();
		basicCourse.clickGoogleLogin();
		basicCourse.switchWindow();

	}

	@Test(priority = 2, enabled = false)
	public void navigateToFlights() throws Throwable {
		basicCourse.launchApplicationUrl();
		basicCourse.selectFlights();
		basicCourse.selectTrip();
		basicCourse.selectCity();
		basicCourse.selectDateCalendar();
		basicCourse.btnSearch();
		String txt = basicCourse.getTextCity();
		String news = txt.replace("Flights from", "").trim();
		String str = news.replace("to Chennai", "").trim();
		Assert.assertEquals(str, YamlReader.getData("to_city"));
		basicCourse.checkbox_Stops();
		basicCourse.checkbox_Flight();
		basicCourse.btnViewPrice();
	}

	@Test(priority = 2, enabled = false)
	public void navigateToHotels() throws Throwable {
		basicCourse.launchApplicationUrl();
		basicCourse.selectHotels();
		// basicCourse.selectHotelCity();
		basicCourse.selectDateCalendarHotel();
		basicCourse.btnSearch();

	}

	@Test(priority = 3, enabled = false)
	public void navigateToBuses() throws Throwable {
		basicCourse.launchApplicationUrl();
		basicCourse.selectBuses();
		basicCourse.selectBusCity();
		basicCourse.selectDateCalendarBus();
		String txt = basicCourse.getTextCityBus();
		Assert.assertEquals(txt, YamlReader.getData("to_City"));
		basicCourse.clickSearchBuses();
		String str = basicCourse.publicTransport();
		Assert.assertEquals(str, "State Transports");
		basicCourse.clickViewBus();

	}

	@Test(priority = 3, enabled = false)
	public void verifyTravelBlogText() throws Throwable {
		basicCourse.launchApplicationUrl();
		String txt = basicCourse.textTravelBlog();
		String news = txt.replace("VIEW ALL", "").trim();
		Assert.assertEquals(news, "Travel Blog");
		basicCourse.clickViewTravelBlog();
		String url = basicCourse.getCurrentURL();
		Assert.assertEquals(url, "https://www.makemytrip.com/blog/?intid=Blog_HomePage_Tab_Stories");

	}
	
	@Test(priority = 3, enabled = false)
	public void navigateToCharterFlights() throws Throwable {
		basicCourse.launchApplicationUrl();
		basicCourse.selectCharterFlights();
		basicCourse.selectCity();
		basicCourse.selectDateCalendarVisa();
		basicCourse.selectTime();
		Thread.sleep(4000);
		basicCourse.selectPassengerCount();
//		basicCourse.btnSearchCharter();
//		basicCourse.checkbox();
	}
	
	@Test(priority = 3, enabled = true)
	public void navigateToCabs() throws Throwable {
		basicCourse.launchApplicationUrl();
		basicCourse.selectCabs();
		basicCourse.selectCityCabs();
		basicCourse.selectDateCalendarCabs();
		basicCourse.selectCabTime();
		basicCourse.btnSearchCharter();
		Thread.sleep(2000);
		String txt = basicCourse.verifyText();
		Assert.assertEquals(txt, "Your Safety: Our Priority");
		/*
		 * String cab = basicCourse.getlistCabs(); Assert.assertEquals(cab,
		 * "Indica, Swift"); String cabamt = basicCourse.getCabPrice();
		 * Assert.assertEquals(cabamt, "5,329");
		 */
	}
}
