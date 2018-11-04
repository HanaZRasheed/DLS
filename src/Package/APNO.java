package Package;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class APNO extends VARs {
	Integer Const=500;
	WebDriver driver;
  @BeforeTest
  public void Login() throws InterruptedException {
// System.setProperty("webdriver.ie.driver",IEDriver);
 //driver = new InternetExplorerDriver();
	  
//	  System.setProperty("webdriver.chrome.driver", ChromeDriver);
//	driver = new ChromeDriver();
	
	System.setProperty("webdriver.gecko.driver", gekoDriver);
	driver = new FirefoxDriver();
	
	 driver.manage().window().maximize(); 
	 driver.get(link);
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
	driver.findElement(username).sendKeys(usernameContent);
	Thread.sleep(Const);
	driver.findElement(Password).sendKeys(passwordContent);
	Thread.sleep(Const);
	driver.findElement(LoginButton).click();
	Thread.sleep(Const*5);
	
	
	
  }

  
//موافقة تملّك لغير الأردنيين
 // مقدم الطلب 
@Test
 public void Case4_0_0_0() throws InterruptedException, IOException // الجهة التنظيمية امانة عمان الكبرى
 {
		driver.findElement(NonJordanianPropertyApproval).click(); // موافقات التملك لغير الاردنين
		Thread.sleep(Const*8);
		driver.findElement(validationCode).sendKeys(verificationCodeContent); // رمز التحقق
		Thread.sleep(Const*8);
		
		driver.findElement(continueButton).click(); // استمرار
		Thread.sleep(Const*15);
		
		driver.findElement(ApprovalcheckBox).click();  // موافقة
		Thread.sleep(Const*10 );

		driver.findElement(nextButton).click(); //  التالي

		Thread.sleep(Const*15);
		// مغلومات مقدم الطلب 
		Select ApplicantTypeDDL = new Select(driver.findElement(ApplicantType));// صفة مقدم الطلب
		ApplicantTypeDDL.selectByVisibleText(purchaser); 
		Thread.sleep(Const*2);

		driver.findElement(ExpressRequestCheckBox).click(); // طلب سريع
		Thread.sleep(Const*2);
		
		//driver.findElement(InternalRequestApprovalRadio).click();
		driver.findElement(ExternalRequestApprovalRadio).click(); 

		Select PurposeOfPossessionDDL = new Select(driver.findElement(PurposeOfPossession)); // الغاية من التملك
		PurposeOfPossessionDDL.selectByVisibleText(FinanceLease); 
		Thread.sleep(Const*5);
		
		Select SecondaryPurposeOfPossessionDDL = new Select(driver.findElement(SecondaryPurposeOfPossession)); // الغاية الفرعية من التملك
		SecondaryPurposeOfPossessionDDL.selectByVisibleText(CombineAreas); 
		Thread.sleep(Const * 4);
		
		driver.findElement(next).click();

		Thread.sleep(Const * 10);
	
		// معلومات المشتري
		driver.findElement(buyerInfofield1).sendKeys(buyerInfofield1Content);
		driver.findElement(buyerInfofield2).sendKeys(buyerInfofield2Content);
		driver.findElement(buyerInfofield3).sendKeys(buyerInfofield3Content);
		driver.findElement(buyerInfofield4).sendKeys(buyerInfofield4Content);
	
		Thread.sleep(Const*3);
		driver.findElement(nameasinPassport).sendKeys(nameasinPassportContent); // الاسم حسب جواز السفر
		Thread.sleep(Const*3);
		
		
		Select NationalityDDL = new Select(driver.findElement(nationality)); // الجنسية
		NationalityDDL.selectByVisibleText(emirates); 
		Thread.sleep(Const*3);
		driver.findElement(phoneNumber).sendKeys(phoneNoContent); // رقم الهاتف
		
		Select CountryDDL = new Select(driver.findElement(CountryCode)); // الرمز الدولي
		CountryDDL.selectByVisibleText(code1); 
		Thread.sleep(Const*3);
		
		Select passportTypeDDL = new Select(driver.findElement(passportType)); //نوع جواز السفر 
		passportTypeDDL.selectByVisibleText(Permenant); 
		Thread.sleep(Const*3);
		
		driver.findElement(passportNumber).sendKeys(passportNumberContent); //  رقم جواز السفر
		Thread.sleep(Const*3);

		driver.findElement(productionDate).sendKeys(productionDateContent); //  تاريخ الاصدار
		Thread.sleep(Const*3);
		driver.findElement(ExpiryDate).sendKeys(ExpiryDateContent); // تاريخ الانتهاء
		Thread.sleep(Const*3);
		
		driver.findElement(productionLocation).sendKeys(productionLocationContent); // مكان الاصدار
		Thread.sleep(Const*3);
		
		Select arrivalCountryDDL = new Select(driver.findElement(arrivalCountry)); //  بلد القدوم
		arrivalCountryDDL.selectByVisibleText(AbuDhabi); 
		Thread.sleep(Const*3);
		
		driver.findElement(placeOfBirth).sendKeys(placeOfBirthContent); // مكان الولادة
		Thread.sleep(Const*5);
		
		driver.findElement(birthDate).sendKeys(dateOfBirthContent); // تاريخ الولادة
		Thread.sleep(Const*5);

		driver.findElement(NoResidency).click(); // لديك إقامة بالمملكة
		Thread.sleep(Const *3);
		
		driver.findElement(noProperty).click(); // هل لديك عقارات داخل المملكة؟
		Thread.sleep(Const*3);

		driver.findElement(currentResidenceAddress).sendKeys(currentResidenceAddressContent); // عنوان الإقامة الحالية
		Thread.sleep(Const*3);

		Select GenderDDL = new Select(driver.findElement(Gender)); // الجنس
		GenderDDL.selectByVisibleText(female); 
		Thread.sleep(Const*3);

		Select SocialStatusDDL = new Select(driver.findElement(socialStatus)); // الحالة الاجتماعية
		SocialStatusDDL.selectByVisibleText(married); 
		Thread.sleep(Const*3);

		driver.findElement(job).sendKeys(JobContent); // عنوان الإقامة الحالية
		Thread.sleep(Const*3);
		
		driver.findElement(registrationNo).sendKeys(registrationNoContent); // رقم الدخول
		Thread.sleep(Const*3);
		
		driver.findElement(additionalInfo).sendKeys(additionalInfoContent); // معلومات اضافية
		Thread.sleep(Const*3);
		
		driver.findElement(noOtherNationality).click();// جنسية أخرى
		Thread.sleep(Const*8);

		//Select AnotherNationalityDDL = new Select(driver.findElement(AnotherNationality)); //جنسية أخرى
	//	AnotherNationalityDDL.selectByVisibleText(Australian); 
	//	Thread.sleep(Const);
		
		Select motherNationalityDDL = new Select(driver.findElement(motherNationality)); // جنسية الام
		motherNationalityDDL.selectByVisibleText(Jordanian); 
		Thread.sleep(Const);
		
		driver.findElement(insideKigdom).click();// هل المستدعى له داخل المملكة؟
		Thread.sleep(Const*9);
		// معلومات الام
		driver.findElement(MomFirstName).sendKeys(MomFirstNameContent); 
		Thread.sleep(Const);
		driver.findElement(MomSecondName).sendKeys(MomSecondNameContent); 
		Thread.sleep(Const);
		driver.findElement(MomThirdName).sendKeys(MomThirdNameContent); 
		Thread.sleep(Const);
		driver.findElement(MomLastName).sendKeys(MomLastNameContent); 
		Thread.sleep(Const * 3);
		
		driver.findElement(chooseFile).click(); //صورة جواز السفر
		Thread.sleep(Const *10);
	// 	Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\FileUpload.exe"); // Chrome 
		Runtime.getRuntime().exec("C:\\Users\\hrasheed\\Documents\\FileUploadFirfox.exe"); // Firefox
		
		Thread.sleep(Const *7);
		
		driver.findElement(chooseFile1).click();
		Thread.sleep(Const *10);
		
	//	Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec("C:\\Users\\hrasheed\\Documents\\FileUploadFirfox.exe"); // Firefox
		Thread.sleep(Const *10);
		
		driver.findElement(Nxt).click();
		Thread.sleep(Const*5);
		
		driver.findElement(addButton).click();
		Thread.sleep(Const*5);
		// معلومات الو
		driver.findElement(spousefirstName).sendKeys(spousefirstNameContent); 
		Thread.sleep(Const*10);
		
		driver.findElement(spouseSecondName).sendKeys(spouseSecondNameContent); 
		Thread.sleep(Const*10);
		
		driver.findElement(spouseThirdName).sendKeys(spouseThirdNameContent); 
		Thread.sleep(Const*10);
		
		driver.findElement(spouseLastName).sendKeys(spouselastNameContent); 
		Thread.sleep(Const*10);
		
		Select spouseNationalityDDL = new Select(driver.findElement(spouseNationality)); // جنسية الزوجة 
		spouseNationalityDDL.selectByVisibleText(Jordanian); 
		Thread.sleep(Const);
	
		
		driver.findElement(spouseMomfirstName).sendKeys(spouseMomfirstNameContent); 
		Thread.sleep(Const*10);
		
		driver.findElement(spouseMomSecondName).sendKeys(spouseMomSecondNameContent); 
		Thread.sleep(Const*10);
		
		driver.findElement(spouseMomThirdName).sendKeys(spouseMomThirdNameContent); 
		Thread.sleep(Const*10);
		
		driver.findElement(spouseMomFourthName).sendKeys(spouseMomlastNameContent); 
		Thread.sleep(Const*10);
		
		Select spouseMomNationalityDDL = new Select(driver.findElement(spouseMomNationality)); // جنسية أم  الزوجة 
		spouseMomNationalityDDL.selectByVisibleText(Jordanian); 
		Thread.sleep(Const);
		
		
		
		/*
		driver.findElement(recordNo).sendKeys(recordNoContent); 
		Thread.sleep(Const*10);
		
		driver.findElement(SearchButton).click();
		Thread.sleep(Const*10);
		
		driver.findElement(schemeNo).sendKeys(recordNoContent); 
		Thread.sleep(Const*10);
		
		driver.findElement(checkowners).click();
		Thread.sleep(Const*8);
		
		driver.findElement(checkOwners).click();
		Thread.sleep(Const*8);
		
		driver.findElement(choosefile2).click(); // سند التسجيل
		Thread.sleep(Const*5);
		
//		Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec("C:\\Users\\hrasheed\\Documents\\FileUploadFirfox.exe"); // Firefox
		Thread.sleep(Const *10);
		
		driver.findElement(choosefile3).click(); // مخطط الأراضي
		Thread.sleep(Const*5);
		
//		Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec("C:\\Users\\hrasheed\\Documents\\FileUploadFirfox.exe"); // Firefox
		Thread.sleep(Const *15);
		
		driver.findElement(choosefile7).click();
		Thread.sleep(Const*5);
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec("C:\\Users\\hrasheed\\Documents\\FileUploadFirfox.exe"); // Firefox
		Thread.sleep(Const *15);
		
		driver.findElement(choosefile5).click();   // شهادة تسجيل الشركة
		Thread.sleep(Const*5);
		//	Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec("C:\\Users\\hrasheed\\Documents\\FileUploadFirfox.exe"); // Firefox
		Thread.sleep(Const *15);
		
	driver.findElement(choosefile6).click(); // رخصة المهن 
	Thread.sleep(Const*5);
	//	Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec("C:\\Users\\hrasheed\\Documents\\FileUploadFirfox.exe"); // Firefox
		Thread.sleep(Const *15);
		
		driver.findElement(next).click(); 	//  التالي
*/
 }
 

  
  @AfterMethod(enabled =false, groups = {"StartRNVL"})
	public void End(ITestResult result) throws InterruptedException {
		// Here will compare if test is failing then only it will enter into
		// if
		// condition
		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				// Create reference of TakesScreenshot
				TakesScreenshot ts = (TakesScreenshot) driver;

				// Call method to capture screenshot
				File source = ts.getScreenshotAs(OutputType.FILE);

				// Copy files to specific location here it will save all
				// screenshot in our project home directory and
				// result.getName() will return name of test case so that
				// screenshot name will be same
				FileUtils.copyFile(source, new File("./Screenshots/" + result.getName() + ".png"));

				System.out.println("Failed. Screenshot taken " + result.getName());
			} catch (Exception e) {

				System.out.println("Failed. Exception while taking screenshot" + e.getMessage());
			}
		}

		driver.quit();

	}
 
}
