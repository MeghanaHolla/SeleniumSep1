package kdf;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.GenericMethods;

public class Application {
	
	@Test
	public void verifyInvalidLogin() throws IOException {
		//Making changes after r1.1
		String[][] data = GenericMethods.getData("D:\\Sel4Aug\\TestData.xlsx", "Sheet2");
		for(int i =1;i<data.length;i++) {
			switch(data[i][3]) {
			case "openBrowser":
				Methods.openBrowser();
				break;
			case "maxBrowser":
				Methods.maximizeBrowser();
				break;
			case "impWait":
				Methods.implicitWait();
				break;
			case "navigateToApplication":
				Methods.navigateToApplication(data[i][6]);
				break;
			case "enterUserID":
				Methods.enterUserID(data[i][4],data[i][5], data[i][6]);
				break;
			case "enterPassword":
				Methods.enterPassword(data[i][4],data[i][5], data[i][6]);
				break;
			case "clickSignIn":
				Methods.clickSignIn(data[i][4],data[i][5]);
				break;
			case "verifyErrMsg":
				String actualMsg = Methods.verifyErrorMessage(data[i][5]);
				Assert.assertEquals(actualMsg, data[i][6]);
				break;
			case "closeAUT":
				Methods.closeApplication();
				break;
			}
		}
	}

}
