package dls;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class APNO extends Vars {

	Integer Const = 500;
	WebDriver driver;

	@BeforeTest
	public void Login() throws InterruptedException {
		// System.setProperty("webdriver.ie.driver",IEDriver);
		// driver = new InternetExplorerDriver();

		System.setProperty("webdriver.chrome.driver", ChromeDriver);
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get(link);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.findElement(username).sendKeys(usernameContent);
		Thread.sleep(Const);
		driver.findElement(Password).sendKeys(passwordContent);
		Thread.sleep(Const);
		driver.findElement(LoginButton).click();
		Thread.sleep(Const);
		driver.findElement(NonJordanianPropertyApproval).click();
		driver.findElement(verificationCode).sendKeys(verificationCodeContent);
		driver.findElement(continueButton).click();
		Thread.sleep(Const * 5);
		driver.findElement(ApprovalcheckBox).click();
		Thread.sleep(Const * 5);
		driver.findElement(nextButton).click();

	}
	@AfterMethod(enabled = true)
	public void End(ITestResult result) throws InterruptedException {
		// Here will compare if test is failing then only it will enter into if
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
				FileUtils.copyFile(source, new File("/DLS/Screenshots-Failure" + result.getName() + ".png"));

				System.out.println("Failed. Screenshot taken " + result.getName());
			} catch (Exception e) {

				System.out.println("Failed. Exception while taking screenshot" + e.getMessage());
			}
		}

	}
	@Test
	// لغايات ادارة الاعمال
	public void Case1000() throws InterruptedException, IOException {
		// -----------------------------Applicant info-----------------------------
		Select ApplicantTypeDDL = new Select(driver.findElement(ApplicantType));
		ApplicantTypeDDL.selectByVisibleText(purchaser); // مشتري
		Thread.sleep(Const * 10);
		// نوع الموافقة
		driver.findElement(InternalRequestApprovalRadio).click();
		Select Purpose = new Select(driver.findElement(PurposeOfPossession)); // الغاية الرئيسية
		Purpose.selectByVisibleText(Commercial_Office);
		Thread.sleep(Const * 20);
		Select Purpose2 = new Select(driver.findElement(SecondaryPurposeOfPossession)); // الغاية الفرعية
		Purpose2.selectByVisibleText(BussinessAdministration);
		// رقم وطني للمنشأة
		driver.findElement(CoNationalNumber).sendKeys("987445215");
		//navigaete out
				driver.findElement(By.id("pt1:r1:1:s1")).click();
		// Next to Purchaser info
		Thread.sleep(Const);
		driver.findElement(nextToPurchaseInfo).click();
		// ---------------------------Purchaser info------------------------------
		// معلومات المشتري
		driver.findElement(BuyerFields1).sendKeys(buyerInfoContent1);
		driver.findElement(BuyerFields2).sendKeys(buyerInfoContent2);
		driver.findElement(BuyerFields3).sendKeys(buyerInfoContent3);
		driver.findElement(BuyerFields4).sendKeys(buyerInfoContent4);
		Thread.sleep(Const);
		driver.findElement(nameasinPassport).sendKeys(nameasinPassportContent); // الاسم حسب جواز السفر
		Thread.sleep(Const);
		Select NationalityDDL = new Select(driver.findElement(nationality)); // الجنسية
		NationalityDDL.selectByVisibleText(Egyptian);
		Thread.sleep(Const);
		driver.findElement(phoneNumber).sendKeys(phoneNoContent); // رقم الهاتف
		Select CountryDDL = new Select(driver.findElement(CountryCode)); // الرمز الدولي
		CountryDDL.selectByVisibleText(code1);
		Thread.sleep(Const);
		Select passportTypeDDL = new Select(driver.findElement(passportType)); // نوع جواز السفر
		passportTypeDDL.selectByVisibleText(Permenant);
		Thread.sleep(Const);
		driver.findElement(passportNumber).sendKeys(passportNumberContent); // رقم جواز السفر
		Thread.sleep(Const);
		driver.findElement(productionDate).sendKeys(productionDateContent); // تاريخ الاصدار
		Thread.sleep(Const);
		driver.findElement(ExpiryDate).sendKeys(ExpiryDateContent); // تاريخ الانتهاء
		Thread.sleep(Const * 10);
		driver.findElement(productionLocation).sendKeys(productionLocationContent); // مكان الاصدار
		Thread.sleep(Const);

		Select arrivalCountryDDL = new Select(driver.findElement(arrivalCountry)); // بلد القدوم
		arrivalCountryDDL.selectByVisibleText(AbuDhabi);
		Thread.sleep(Const * 10);

		driver.findElement(placeOfBirth).sendKeys(placeOfBirthContent); // مكان الولادة
		Thread.sleep(Const * 10);
		driver.findElement(birthDate).sendKeys(dateOfBirthContent); // تاريخ الولادة
		Thread.sleep(Const * 10);

		driver.findElement(NoResidency).click(); // -لا - لديك إقامة بالمملكة
		Thread.sleep(Const * 10);
		driver.findElement(noProperty).click(); // لا - هل لديك عقارات داخل المملكة؟
		Thread.sleep(Const * 10);

		driver.findElement(currentResidenceAddress).sendKeys(currentResidenceAddressContent); // عنوان الإقامة الحالية
		Thread.sleep(Const);

		Select GenderDDL = new Select(driver.findElement(Gender)); // الجنس
		GenderDDL.selectByVisibleText(female); // أنثى
		Thread.sleep(Const * 10);
		Select SocialStatusDDL = new Select(driver.findElement(socialStatus)); // الحالة الاجتماعية
		SocialStatusDDL.selectByVisibleText(single); //أعزب
		//SocialStatusDDL.selectByVisibleText(married); // متزوج
		Thread.sleep(Const * 10);
		driver.findElement(job).sendKeys(JobContent); // عنوان الإقامة الحالية
		Thread.sleep(Const * 10);
		driver.findElement(registrationNo).sendKeys(registrationNoContent); // رقم الدخول
		Thread.sleep(Const);
		driver.findElement(additionalInfo).sendKeys(additionalInfoContent); // معلومات اضافية
		Thread.sleep(Const);
		driver.findElement(noOtherNationality).click();// - لا - جنسية أخرى
		Thread.sleep(Const);
		Select motherNationalityDDL = new Select(driver.findElement(motherNationality)); // جنسية الام
		motherNationalityDDL.selectByVisibleText(Jordanian);
		Thread.sleep(Const);
		driver.findElement(insideKigdom).click();// - نعم - هل المستدعى له داخل المملكة؟
		Thread.sleep(Const);
		// معلومات الام
		driver.findElement(MomFirstName).sendKeys(MomFirstNameContent);
		Thread.sleep(Const);
		driver.findElement(MomSecondName).sendKeys(MomSecondNameContent);
		Thread.sleep(Const);
		driver.findElement(MomThirdName).sendKeys(MomThirdNameContent);
		Thread.sleep(Const);
		driver.findElement(MomLastName).sendKeys(MomLastNameContent);
		   Thread.sleep(Const * 20);
		// ------------------------Purchaser InfoAttachments--------------------
		   Thread.sleep(Const * 20);
	   driver.findElement(Passport).click();
	   Thread.sleep(Const * 20);
	   Runtime.getRuntime().exec(AttachPath);
	    Thread.sleep(Const * 10);
		
//		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:pc1:t2:1:pgl50\"]/tbody/tr/td[3]/span")).click();
//		Thread.sleep(Const * 20);
//		Runtime.getRuntime().exec(AttachPath);
//		Thread.sleep(Const * 10);
//		
//		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:pc1:t2:0:pgl50\"]/tbody/tr/td[3]/span")).click();
//		Thread.sleep(Const * 20);
//		Runtime.getRuntime().exec(AttachPath);
//		Thread.sleep(Const * 10);
		
		driver.findElement(nextToPrpertyInfoFromPurchaserInfo).click();
		// ---------------------Property & Seller Info ------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(recordNo).sendKeys("1-6BAE1P"); // رقم القيد
		Thread.sleep(Const * 10);
		driver.findElement(DLSKeyButton).click();
		Thread.sleep(Const * 10);
		driver.findElement(schemeNo).sendKeys("1-6BAE1P"); // الرقم المميز للمخطط
		Thread.sleep(Const);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:3:pgl5\"]/div[4]")).click(); // click-anywhere-to-navigate-out
		Thread.sleep(Const);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:3:pc2:t5:0:sbc2::content\"]")).click();		
		// ------------------------Property InfoAttachments--------------------
		Thread.sleep(Const * 20);
//	driver.findElement(CoRegistrationCertificate).click();
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:3:pc1:t2:1:pgl50\"]/tbody/tr/td[3]/span")).click();
	Thread.sleep(Const * 20);
	Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 10);
		Thread.sleep(Const * 10);
		driver.findElement(NextToSellerAttach).click();
		//-------------------------Seller's Attachments----------------------
		//driver.findElement(IDCardSeller).click();
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:4:pc1:t2:0:pgl50\"]/tbody/tr/td[3]/span")).click();
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 50);
		driver.findElement(NextToLinkPurchaserandSellers).click();
	   //--------------------------Link Purchaser with Seller ----------------
		Thread.sleep(Const * 40);
		Select SellerName = new Select(driver.findElement(VendorName)); // اسم المشتري
		SellerName.selectByValue("0");
		Thread.sleep(Const);
		Select Properties = new Select(driver.findElement(PropertiesA2)); // العقارات
		Properties.selectByValue("0");
		Thread.sleep(Const);
		Select OwnerName = new Select(driver.findElement(ownerName)); //اسم المالك
		OwnerName.selectByValue("0");
		Thread.sleep(Const);
		driver.findElement(areatoBeOwnedNum).sendKeys("40"); //المساحة المراد تملكها رقما
		Thread.sleep(Const);
		driver.findElement(areatoBeOwned).sendKeys("40"); //المساحة المراد تملكها كتابة
		Thread.sleep(Const);
		driver.findElement(numberofProportions).sendKeys("2"); // الحصص المراد تملكها رقما
		Thread.sleep(Const*20);
		driver.findElement(NextToReviewSection).click();
		Thread.sleep(Const*20);
	//---------------------------Review Section ------------------------
		Thread.sleep(Const * 20);
		driver.findElement(submitRequest).click();
		Thread.sleep(Const * 50);
	}
	@Test
	// لغايات الزراعة
	public void Case1100() throws InterruptedException, IOException {
		// -----------------------------Applicant info-----------------------------

		Select ApplicantTypeDDL = new Select(driver.findElement(ApplicantType));
		ApplicantTypeDDL.selectByVisibleText(purchaser); // مشتري
		Thread.sleep(Const * 10);
		// نوع الموافقة
		driver.findElement(ExternalRequestApprovalRadio).click();
		Select Purpose = new Select(driver.findElement(PurposeOfPossession)); // الغاية الرئيسية
		Purpose.selectByVisibleText(Agriculture);
		Thread.sleep(Const * 20);
		Select Purpose2 = new Select(driver.findElement(SecondaryPurposeOfPossession)); // الغاية الفرعية
		Purpose2.selectByVisibleText(AgriculturePurpose);
		// Next to Purchaser info
		Thread.sleep(Const*30);
		driver.findElement(nextToPurchaseInfo).click();

		// ---------------------------Purchaser info------------------------------

		// معلومات المشتري
		driver.findElement(BuyerFields1).sendKeys(buyerInfoContent1);
		driver.findElement(BuyerFields2).sendKeys(buyerInfoContent2);
		Thread.sleep(Const);

		driver.findElement(BuyerFields3).sendKeys(buyerInfoContent3);
		Thread.sleep(Const);

		driver.findElement(BuyerFields4).sendKeys(buyerInfoContent4);
		Thread.sleep(Const);
		driver.findElement(nameasinPassport).sendKeys(nameasinPassportContent); // الاسم حسب جواز السفر
		Thread.sleep(Const);
		Select NationalityDDL = new Select(driver.findElement(nationality)); // الجنسية
		NationalityDDL.selectByVisibleText(Egyptian);
		Thread.sleep(Const);
		driver.findElement(phoneNumber).sendKeys(phoneNoContent); // رقم الهاتف
		Thread.sleep(Const);

		Select CountryDDL = new Select(driver.findElement(CountryCode)); // الرمز الدولي
		CountryDDL.selectByVisibleText(code1);
		Thread.sleep(Const);
		Select passportTypeDDL = new Select(driver.findElement(passportType)); // نوع جواز السفر
		passportTypeDDL.selectByVisibleText(Permenant);
		Thread.sleep(Const);
		driver.findElement(passportNumber).sendKeys(passportNumberContent); // رقم جواز السفر
		Thread.sleep(Const);
		driver.findElement(productionDate).sendKeys(productionDateContent); // تاريخ الاصدار
		Thread.sleep(Const);
		driver.findElement(ExpiryDate).sendKeys(ExpiryDateContent); // تاريخ الانتهاء
		Thread.sleep(Const * 10);
		driver.findElement(productionLocation).sendKeys(productionLocationContent); // مكان الاصدار
		Thread.sleep(Const);

		Select arrivalCountryDDL = new Select(driver.findElement(arrivalCountry)); // بلد القدوم
		arrivalCountryDDL.selectByVisibleText(AbuDhabi);
		Thread.sleep(Const * 10);

		driver.findElement(placeOfBirth).sendKeys(placeOfBirthContent); // مكان الولادة
		Thread.sleep(Const * 10);
		driver.findElement(birthDate).sendKeys(dateOfBirthContent); // تاريخ الولادة
		Thread.sleep(Const * 10);

		driver.findElement(NoResidency).click(); // -لا - لديك إقامة بالمملكة
		Thread.sleep(Const * 10);
		driver.findElement(noProperty).click(); // لا - هل لديك عقارات داخل المملكة؟
		Thread.sleep(Const * 10);

		driver.findElement(currentResidenceAddress).sendKeys(currentResidenceAddressContent); // عنوان الإقامة الحالية
		Thread.sleep(Const);

		Select GenderDDL = new Select(driver.findElement(Gender)); // الجنس
		GenderDDL.selectByVisibleText(female); // أنثى
		Thread.sleep(Const * 10);

		Select SocialStatusDDL = new Select(driver.findElement(socialStatus)); // الحالة الاجتماعية
		//SocialStatusDDL.selectByVisibleText(single); //أعزب
		SocialStatusDDL.selectByVisibleText(married); // متزوج

		Thread.sleep(Const * 10);

		driver.findElement(job).sendKeys(JobContent); // عنوان الإقامة الحالية
		Thread.sleep(Const * 30);

		driver.findElement(registrationNo).sendKeys(registrationNoContent); // رقم الدخول
		Thread.sleep(Const);

		driver.findElement(additionalInfo).sendKeys(additionalInfoContent); // معلومات اضافية
		Thread.sleep(Const);

		driver.findElement(noOtherNationality).click();// - لا - جنسية أخرى
		Thread.sleep(Const);

		Select motherNationalityDDL = new Select(driver.findElement(motherNationality)); // جنسية الام
		motherNationalityDDL.selectByVisibleText(Jordanian);
		Thread.sleep(Const);

		driver.findElement(insideKigdom).click();// - نعم - هل المستدعى له داخل المملكة؟
		Thread.sleep(Const);
		// معلومات الام
		driver.findElement(MomFirstName).sendKeys(MomFirstNameContent);
		Thread.sleep(Const);
		driver.findElement(MomSecondName).sendKeys(MomSecondNameContent);
		Thread.sleep(Const);
		driver.findElement(MomThirdName).sendKeys(MomThirdNameContent);
		Thread.sleep(Const);
		driver.findElement(MomLastName).sendKeys(MomLastNameContent);

		// ------------------------Purchaser InfoAttachments--------------------

		Thread.sleep(Const * 10);
		driver.findElement(Passport).click();
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 10);
		Thread.sleep(Const * 30);
		driver.findElement(NextToWifeHusbandScn).click();
		// ----------------------------------------Wife-HusbandInfo--------------------------------
//		Select SellerName1 = new Select(driver.findElement(VendorName)); // اسم المشتري
//		SellerName1.selectByValue("0");
//		Thread.sleep(Const * 10);
		//Add button 
		Thread.sleep(Const * 20);
		driver.findElement(addButton).click();

		// wife full name
		Thread.sleep(Const * 50);
		driver.findElement(spousefirstName).sendKeys("نوف");   
		Thread.sleep(Const);
		driver.findElement(spouseSecondName).sendKeys("هيثم");   
		Thread.sleep(Const);
		driver.findElement(spouseThirdName).sendKeys("ابراهيم");   
		Thread.sleep(Const);
		driver.findElement(spouseLastName).sendKeys("فتيحة");   
		Thread.sleep(Const);
	
		// nationality
		Select SpouseNationality = new Select(driver.findElement(spouseNationality)); //جنسية الام 
		SpouseNationality.selectByValue("1");
		Thread.sleep(Const);
				
		// Wife'sMom Full Name
		driver.findElement(spouseMomfirstName).sendKeys("أمل");   
		Thread.sleep(Const);
		driver.findElement(spouseMomSecondName).sendKeys("خالد");   
		Thread.sleep(Const);
		driver.findElement(spouseMomThirdName).sendKeys("خليل");   
		Thread.sleep(Const);
		driver.findElement(spouseMomFourthName).sendKeys("البردويل");   
		Thread.sleep(Const);
		
		// Nationality
		Select SpouseMoMNationality = new Select(driver.findElement(spouseMomNationality)); // اسم المشتري
		SpouseMoMNationality.selectByValue("1");
		Thread.sleep(Const);
		
		Thread.sleep(Const * 40);
		driver.findElement(NextToPropertyScnfromWifeSCN).click();

		// ---------------------Property & Seller Info ------------------------------
		Thread.sleep(Const * 50);

		driver.findElement(recordNo2).sendKeys("1-6BAE1P"); // رقم القيد
		Thread.sleep(Const * 10);
		driver.findElement(DLSKeyButton2).click();
		Thread.sleep(Const * 50);
		driver.findElement(schemeNo2).sendKeys("1-6BAE1P"); // الرقم المميز للمخطط
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:2:pgl10")).click(); // click-anywhere-to-navigate-out
		Thread.sleep(Const*20);
		driver.findElement(checkownersA1).click();
		
		// ------------------------Property InfoAttachments--------------------

//		driver.findElement(Others2).click();
//		Thread.sleep(Const * 20);
//		Runtime.getRuntime().exec(AttachPath);
//		Thread.sleep(Const * 20);
//		driver.findElement(CoRegistrationCertificate).click();
//		Thread.sleep(Const * 20);
//		Runtime.getRuntime().exec(AttachPath);
//		Thread.sleep(Const * 10);
//
//		Thread.sleep(Const * 10);
//		driver.findElement(NextToSellerAttach2).click();

	
			Thread.sleep(Const * 10);
			driver.findElement(NextToSellerAttach2).click();
		//-------------------------Seller's Attachments----------------------
			Thread.sleep(Const * 20);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:pc1:t2:1:pgl50\"]/tbody/tr/td[3]/span")).click();

//		driver.findElement(IDCardSeller2).click();
		Thread.sleep(Const * 20);
	Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 30);
		
		
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:pc1:t2:0:pgl50\"]/tbody/tr/td[3]/span")).click();
		Thread.sleep(Const * 20);
	Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 30);
		driver.findElement(NextToLinkPurchaserandSellers2).click();

	   //--------------------------Link Purchaser with Seller----------------
		Thread.sleep(Const * 20);

		Select SellerName = new Select(driver.findElement(VendorName2)); // اسم المشتري
		SellerName.selectByValue("0");
		Thread.sleep(Const);
		
		Select Properties = new Select(driver.findElement(PropertiesB2)); // العقارات
		Properties.selectByValue("0");
		Thread.sleep(Const);

		Select OwnerName = new Select(driver.findElement(ownerName2)); //اسم المالك
		OwnerName.selectByValue("0");
		Thread.sleep(Const);
		driver.findElement(areatoBeOwnedNum2).sendKeys("40"); //المساحة المراد تملكها رقما
		Thread.sleep(Const);
		driver.findElement(areatoBeOwned2).sendKeys("40"); //المساحة المراد تملكها كتابة
		Thread.sleep(Const);
		driver.findElement(numberofProportions2).sendKeys("2"); // الحصص المراد تملكها رقما
		Thread.sleep(Const*30);
		driver.findElement(NextToReviewSection2).click();
		Thread.sleep(Const*20);
	//---------------------------Review Section ------------------------
		Thread.sleep(Const * 20);
		driver.findElement(submitRequest2).click();
		Thread.sleep(Const * 50);
	}
	@Test
	// لغايات صناعية
	public void Case1200() throws InterruptedException, IOException {
		// -----------------------------Applicant info-----------------------------

		Select ApplicantTypeDDL = new Select(driver.findElement(ApplicantType));
		ApplicantTypeDDL.selectByVisibleText(purchaser); // مشتري
		Thread.sleep(Const * 10);
		// نوع الموافقة
		driver.findElement(InternalRequestApprovalRadio).click();
		Select Purpose = new Select(driver.findElement(PurposeOfPossession)); // الغاية الرئيسية
		Purpose.selectByVisibleText(industry);
		Thread.sleep(Const * 20);
		Select Purpose2 = new Select(driver.findElement(SecondaryPurposeOfPossession)); // الغاية الفرعية
		Purpose2.selectByVisibleText(utilizationOfBuilding);
		// رقم وطني للمنشأة
		driver.findElement(CoNationalNumber).sendKeys("987445215");
		//navigaeout
		driver.findElement(By.id("pt1:r1:1:s1")).click();

		// Next to Purchaser info
		Thread.sleep(Const*10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:b2\"]/a")).click();

		// ---------------------------Purchaser info------------------------------

		// معلومات المشتري
		driver.findElement(BuyerFields1).sendKeys(buyerInfoContent1);
		Thread.sleep(Const);

		driver.findElement(BuyerFields2).sendKeys(buyerInfoContent2);
		Thread.sleep(Const);

		driver.findElement(BuyerFields3).sendKeys(buyerInfoContent3);
		Thread.sleep(Const);

		driver.findElement(BuyerFields4).sendKeys(buyerInfoContent4);
		Thread.sleep(Const);
		driver.findElement(nameasinPassport).sendKeys(nameasinPassportContent); // الاسم حسب جواز السفر
		Thread.sleep(Const);
		Select NationalityDDL = new Select(driver.findElement(nationality)); // الجنسية
		NationalityDDL.selectByVisibleText(Egyptian);
		Thread.sleep(Const);
		driver.findElement(phoneNumber).sendKeys(phoneNoContent); // رقم الهاتف
		Select CountryDDL = new Select(driver.findElement(CountryCode)); // الرمز الدولي
		CountryDDL.selectByVisibleText(code1);
		Thread.sleep(Const);
		Select passportTypeDDL = new Select(driver.findElement(passportType)); // نوع جواز السفر
		passportTypeDDL.selectByVisibleText(Permenant);
		Thread.sleep(Const);
		driver.findElement(passportNumber).sendKeys(passportNumberContent); // رقم جواز السفر
		Thread.sleep(Const);
		driver.findElement(productionDate).sendKeys(productionDateContent); // تاريخ الاصدار
		Thread.sleep(Const);
		driver.findElement(ExpiryDate).sendKeys(ExpiryDateContent); // تاريخ الانتهاء
		Thread.sleep(Const * 10);
		driver.findElement(productionLocation).sendKeys(productionLocationContent); // مكان الاصدار
		Thread.sleep(Const);

		Select arrivalCountryDDL = new Select(driver.findElement(arrivalCountry)); // بلد القدوم
		arrivalCountryDDL.selectByVisibleText(AbuDhabi);
		Thread.sleep(Const * 10);

		driver.findElement(placeOfBirth).sendKeys(placeOfBirthContent); // مكان الولادة
		Thread.sleep(Const * 10);
		driver.findElement(birthDate).sendKeys(dateOfBirthContent); // تاريخ الولادة
		Thread.sleep(Const * 10);

		driver.findElement(NoResidency).click(); // -لا - لديك إقامة بالمملكة
		Thread.sleep(Const * 10);
		driver.findElement(noProperty).click(); // لا - هل لديك عقارات داخل المملكة؟
		Thread.sleep(Const * 10);

		driver.findElement(currentResidenceAddress).sendKeys(currentResidenceAddressContent); // عنوان الإقامة الحالية
		Thread.sleep(Const);

		Select GenderDDL = new Select(driver.findElement(Gender)); // الجنس
		GenderDDL.selectByVisibleText(female); // أنثى
		Thread.sleep(Const * 10);

		Select SocialStatusDDL = new Select(driver.findElement(socialStatus)); // الحالة الاجتماعية
		// SocialStatusDDL.selectByVisibleText(single); //أعزب
		SocialStatusDDL.selectByVisibleText(married); // متزوج

		Thread.sleep(Const * 10);

		driver.findElement(job).sendKeys(JobContent); // عنوان الإقامة الحالية
		Thread.sleep(Const * 10);

		driver.findElement(registrationNo).sendKeys(registrationNoContent); // رقم الدخول
		Thread.sleep(Const);

		driver.findElement(additionalInfo).sendKeys(additionalInfoContent); // معلومات اضافية
		Thread.sleep(Const);

		driver.findElement(noOtherNationality).click();// - لا - جنسية أخرى
		Thread.sleep(Const);

		Select motherNationalityDDL = new Select(driver.findElement(motherNationality)); // جنسية الام
		motherNationalityDDL.selectByVisibleText(Jordanian);
		Thread.sleep(Const);

		driver.findElement(insideKigdom).click();// - نعم - هل المستدعى له داخل المملكة؟
		Thread.sleep(Const);
		// معلومات الام
		driver.findElement(MomFirstName).sendKeys(MomFirstNameContent);
		Thread.sleep(Const);
		driver.findElement(MomSecondName).sendKeys(MomSecondNameContent);
		Thread.sleep(Const);
		driver.findElement(MomThirdName).sendKeys(MomThirdNameContent);
		Thread.sleep(Const);
		driver.findElement(MomLastName).sendKeys(MomLastNameContent);
		   Thread.sleep(Const * 20);

		// ------------------------Purchaser InfoAttachments--------------------

//		driver.findElement(Others).click();
//		Thread.sleep(Const * 20);
//		Runtime.getRuntime().exec(AttachPath);
//		driver.findElement(Passport).click();
//		Thread.sleep(Const * 20);
//		Runtime.getRuntime().exec(AttachPath);
	Thread.sleep(Const * 10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:pc1:t2:1:pgl50\"]/tbody/tr/td[3]/span")).click();
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 10);
		
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:pc1:t2:0:pgl50\"]/tbody/tr/td[3]/span")).click();
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 10);
		Thread.sleep(Const * 10);
		driver.findElement(nextToPrpertyInfoFromPurchaserInfo).click();

		// ---------------------Property & Seller Info ------------------------------
		Thread.sleep(Const * 10);

		driver.findElement(recordNo).sendKeys("1-6BAE1P"); // رقم القيد
		Thread.sleep(Const * 10);
		driver.findElement(DLSKeyButton).click();
		Thread.sleep(Const * 10);
		driver.findElement(schemeNo).sendKeys("1-6BAE1P"); // الرقم المميز للمخطط
		Thread.sleep(Const);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pgl5\"]/div[4]")).click(); // click-anywhere-to-navigate-out
		Thread.sleep(Const);
		driver.findElement(OwnersCheckbox).click();
		
		// ------------------------Property InfoAttachments--------------------

//		driver.findElement(Others2).click();
//		Thread.sleep(Const * 20);
//		Runtime.getRuntime().exec(AttachPath);
//		Thread.sleep(Const * 20);
//		driver.findElement(CoRegistrationCertificate).click();
//		Thread.sleep(Const * 20);
//		Runtime.getRuntime().exec(AttachPath);
//		Thread.sleep(Const * 10);
		
		Thread.sleep(Const * 20);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:pc1:t2:1:pgl50\"]/tbody/tr/td[3]/span")).click();

//		driver.findElement(IDCardSeller2).click();
		Thread.sleep(Const * 20);
	Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 30);
		
		
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:pc1:t2:0:pgl50\"]/tbody/tr/td[3]/span")).click();
		Thread.sleep(Const * 20);
	Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 30);
		Thread.sleep(Const * 10);
		driver.findElement(NextToSellerAttach).click();

		//-------------------------Seller's Attachments----------------------

		driver.findElement(IDCardSeller).click();
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 50);
		driver.findElement(NextToLinkPurchaserandSellers).click();

	   //--------------------------Link Purchaser with Seller----------------
		Thread.sleep(Const * 30);

		Select SellerName = new Select(driver.findElement(VendorName)); // اسم المشتري
		SellerName.selectByValue("1");
		Thread.sleep(Const);
		
		Select Properties = new Select(driver.findElement(PropertiesA2)); // العقارات
		Properties.selectByValue("1");
		Thread.sleep(Const);

		Select OwnerName = new Select(driver.findElement(ownerName)); //اسم المالك
		OwnerName.selectByValue("1");
		Thread.sleep(Const);
		
		driver.findElement(areatoBeOwnedNum).sendKeys("40"); //المساحة المراد تملكها رقما
		Thread.sleep(Const);
		
		driver.findElement(areatoBeOwned).sendKeys("40"); //المساحة المراد تملكها كتابة
		Thread.sleep(Const);
		
		driver.findElement(numberofProportions).sendKeys("2"); // الحصص المراد تملكها رقما
		Thread.sleep(Const*20);
		driver.findElement(NextToReviewSection).click();
		Thread.sleep(Const*20);
	//---------------------------Review Section ------------------------
		Thread.sleep(Const * 20);
		driver.findElement(submitRequest).click();
		Thread.sleep(Const * 50);

	}
		@Test
	// لغايات التوسعة
	public void Case1400() throws InterruptedException, IOException {
		// -----------------------------Applicant info-----------------------------

		Select ApplicantTypeDDL = new Select(driver.findElement(ApplicantType));
		ApplicantTypeDDL.selectByVisibleText(purchaser); // مشتري
		Thread.sleep(Const * 20);
		// نوع الموافقة
		driver.findElement(InternalRequestApprovalRadio).click();
		Select Purpose = new Select(driver.findElement(PurposeOfPossession)); // الغاية الرئيسية
		Purpose.selectByVisibleText(Residential);
		Thread.sleep(Const * 20);
		Select Purpose2 = new Select(driver.findElement(SecondaryPurposeOfPossession)); // الغاية الفرعية
		Purpose2.selectByVisibleText(expansion);
		Thread.sleep(Const * 20);
		//pt1:r1:1:b5
		driver.findElement(AddOriginalProperty).click();
       //----------------------Original property -------------------

		Select OriDirectorate = new Select (driver.findElement(Directorate));
        OriDirectorate.selectByVisibleText(directorate);
        Thread.sleep(Const * 20);
        Select Orivillage = new Select (driver.findElement(Village));
        Orivillage.selectByVisibleText(village);
        Thread.sleep(Const * 20);
        Select OriBasinNo = new Select (driver.findElement(BuildingNo));
        OriBasinNo.selectByVisibleText(basin);
        Thread.sleep(Const * 20);
        Select OrineighbourhoodNo = new Select (driver.findElement(neighbourhoodNo));
        OrineighbourhoodNo.selectByVisibleText(neighborhood);
        Thread.sleep(Const * 20);
        Select OripropertyType = new Select (driver.findElement(PropertyType));
        OripropertyType.selectByVisibleText(propertyType);
        Thread.sleep(Const * 20);
        driver.findElement(landNo).sendKeys(propertyNumber);
        Thread.sleep(Const * 20);
        driver.findElement(licenseNo).sendKeys(License, Keys.TAB);        
        Thread.sleep(Const * 20);        
        driver.findElement(saveAddedOriginalProperty).click();
        Thread.sleep(Const * 20);

//		//Back
//		driver.findElement(BackToApplicantInfo).click();
//
//		 Next to Purchaser info
		Thread.sleep(Const);
		driver.findElement(nextToPurchaseInfo).click();
		// ---------------------------Purchaser info------------------------------

		// معلومات المشتري
		driver.findElement(BuyerFields1).sendKeys(buyerInfoContent1);
		driver.findElement(BuyerFields2).sendKeys(buyerInfoContent2);
		driver.findElement(BuyerFields3).sendKeys(buyerInfoContent3);
		driver.findElement(BuyerFields4).sendKeys(buyerInfoContent4);
		Thread.sleep(Const);
		driver.findElement(nameasinPassport).sendKeys(nameasinPassportContent); // الاسم حسب جواز السفر
		Thread.sleep(Const);
		Select NationalityDDL = new Select(driver.findElement(nationality)); // الجنسية
		NationalityDDL.selectByVisibleText(Egyptian);
		Thread.sleep(Const);
		driver.findElement(phoneNumber).sendKeys(phoneNoContent); // رقم الهاتف
		Select CountryDDL = new Select(driver.findElement(CountryCode)); // الرمز الدولي
		CountryDDL.selectByVisibleText(code1);
		Thread.sleep(Const);
		Select passportTypeDDL = new Select(driver.findElement(passportType)); // نوع جواز السفر
		passportTypeDDL.selectByVisibleText(Permenant);
		Thread.sleep(Const);
		driver.findElement(passportNumber).sendKeys(passportNumberContent); // رقم جواز السفر
		Thread.sleep(Const);
		driver.findElement(productionDate).sendKeys(productionDateContent); // تاريخ الاصدار
		Thread.sleep(Const);
		driver.findElement(ExpiryDate).sendKeys(ExpiryDateContent); // تاريخ الانتهاء
		Thread.sleep(Const * 10);
		driver.findElement(productionLocation).sendKeys(productionLocationContent); // مكان الاصدار
		Thread.sleep(Const);

		Select arrivalCountryDDL = new Select(driver.findElement(arrivalCountry)); // بلد القدوم
		arrivalCountryDDL.selectByVisibleText(AbuDhabi);
		Thread.sleep(Const * 10);

		driver.findElement(placeOfBirth).sendKeys(placeOfBirthContent); // مكان الولادة
		Thread.sleep(Const * 10);
		driver.findElement(birthDate).sendKeys(dateOfBirthContent); // تاريخ الولادة
		Thread.sleep(Const * 10);

		driver.findElement(NoResidency).click(); // -لا - لديك إقامة بالمملكة
		Thread.sleep(Const * 10);
		driver.findElement(noProperty).click(); // لا - هل لديك عقارات داخل المملكة؟
		Thread.sleep(Const * 10);

		driver.findElement(currentResidenceAddress).sendKeys(currentResidenceAddressContent); // عنوان الإقامة الحالية
		Thread.sleep(Const);

		Select GenderDDL = new Select(driver.findElement(Gender)); // الجنس
		GenderDDL.selectByVisibleText(female); // أنثى
		Thread.sleep(Const * 10);

		Select SocialStatusDDL = new Select(driver.findElement(socialStatus)); // الحالة الاجتماعية
		// SocialStatusDDL.selectByVisibleText(single); //أعزب
		SocialStatusDDL.selectByVisibleText(married); // متزوج

		Thread.sleep(Const * 10);

		driver.findElement(job).sendKeys(JobContent); // عنوان الإقامة الحالية
		Thread.sleep(Const * 10);

		driver.findElement(registrationNo).sendKeys(registrationNoContent); // رقم الدخول
		Thread.sleep(Const);

		driver.findElement(additionalInfo).sendKeys(additionalInfoContent); // معلومات اضافية
		Thread.sleep(Const);

		driver.findElement(noOtherNationality).click();// - لا - جنسية أخرى
		Thread.sleep(Const);

		Select motherNationalityDDL = new Select(driver.findElement(motherNationality)); // جنسية الام
		motherNationalityDDL.selectByVisibleText(Jordanian);
		Thread.sleep(Const);

		driver.findElement(insideKigdom).click();// - نعم - هل المستدعى له داخل المملكة؟
		Thread.sleep(Const);
		// معلومات الام
		driver.findElement(MomFirstName).sendKeys(MomFirstNameContent);
		Thread.sleep(Const);
		driver.findElement(MomSecondName).sendKeys(MomSecondNameContent);
		Thread.sleep(Const);
		driver.findElement(MomThirdName).sendKeys(MomThirdNameContent);
		Thread.sleep(Const);
		driver.findElement(MomLastName).sendKeys(MomLastNameContent);
		   Thread.sleep(Const * 20);

		// ------------------------Purchaser InfoAttachments--------------------

//		driver.findElement(Others).click();
//		Thread.sleep(Const * 20);
//		Runtime.getRuntime().exec(AttachPath);
//		driver.findElement(Passport).click();
//		Thread.sleep(Const * 20);
//		Runtime.getRuntime().exec(AttachPath);
//		Thread.sleep(Const * 10);
			Thread.sleep(Const * 20);
			driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:pc1:t2:1:pgl50\"]/tbody/tr/td[3]/span")).click();

//			driver.findElement(IDCardSeller2).click();
			Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
			Thread.sleep(Const * 30);
			
			
			driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:pc1:t2:0:pgl50\"]/tbody/tr/td[3]/span")).click();
			Thread.sleep(Const * 20);
		Runtime.getRuntime().exec("AttachPath");
			Thread.sleep(Const * 30);
		Thread.sleep(Const * 10);
		driver.findElement(nextToPrpertyInfoFromPurchaserInfo).click();

		// ---------------------Property & Seller Info ------------------------------
		Thread.sleep(Const * 10);

		driver.findElement(recordNo).sendKeys("1-6BAE1P"); // رقم القيد
		Thread.sleep(Const * 10);
		driver.findElement(DLSKeyButton).click();
		Thread.sleep(Const * 10);
		driver.findElement(schemeNo).sendKeys("1-6BAE1P"); // الرقم المميز للمخطط
		Thread.sleep(Const);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pgl5\"]/div[4]")).click(); // click-anywhere-to-navigate-out
		Thread.sleep(Const);
		driver.findElement(OwnersCheckbox).click();
		
		// ------------------------Property InfoAttachments--------------------

		driver.findElement(Others2).click();
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 20);
		driver.findElement(CoRegistrationCertificate).click();
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 10);

		Thread.sleep(Const * 10);
		driver.findElement(NextToSellerAttach).click();

		//-------------------------Seller's Attachments----------------------

		driver.findElement(IDCardSeller).click();
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 50);
		driver.findElement(NextToLinkPurchaserandSellers).click();

	   //--------------------------Link Purchaser with Seller----------------
		Thread.sleep(Const * 30);

		Select SellerName = new Select(driver.findElement(VendorName)); // اسم المشتري
		SellerName.selectByValue("1");
		Thread.sleep(Const);
		
		Select Properties = new Select(driver.findElement(PropertiesA2)); // العقارات
		Properties.selectByValue("1");
		Thread.sleep(Const);

		Select OwnerName = new Select(driver.findElement(ownerName)); //اسم المالك
		OwnerName.selectByValue("1");
		Thread.sleep(Const);
		
		driver.findElement(areatoBeOwnedNum).sendKeys("40"); //المساحة المراد تملكها رقما
		Thread.sleep(Const);
		
		driver.findElement(areatoBeOwned).sendKeys("40"); //المساحة المراد تملكها كتابة
		Thread.sleep(Const);
		
		driver.findElement(numberofProportions).sendKeys("2"); // الحصص المراد تملكها رقما
		Thread.sleep(Const*20);
		driver.findElement(NextToReviewSection).click();
		Thread.sleep(Const*20);
	//---------------------------Review Section ------------------------
		Thread.sleep(Const * 20);
		driver.findElement(submitRequest).click();
		Thread.sleep(Const * 50);


	}
	@Test
	// لغايات السكن
	public void Case1300() throws InterruptedException, IOException {
		// -----------------------------Applicant info-----------------------------

		Select ApplicantTypeDDL = new Select(driver.findElement(ApplicantType));
		ApplicantTypeDDL.selectByVisibleText(purchaser); // مشتري
		Thread.sleep(Const * 10);
		// نوع الموافقة
		driver.findElement(InternalRequestApprovalRadio).click();
		Select Purpose = new Select(driver.findElement(PurposeOfPossession)); // الغاية الرئيسية
		Purpose.selectByVisibleText(Residential);
		Thread.sleep(Const * 20);
		Select Purpose2 = new Select(driver.findElement(SecondaryPurposeOfPossession)); // الغاية الفرعية
		Purpose2.selectByVisibleText(Residence);
		
		// Next to Purchaser info
		Thread.sleep(Const);
		driver.findElement(nextToPurchaseInfo).click();

		// ---------------------------Purchaser info------------------------------

		// معلومات المشتري
		driver.findElement(BuyerFields1).sendKeys(buyerInfoContent1);
		driver.findElement(BuyerFields2).sendKeys(buyerInfoContent2);
		driver.findElement(BuyerFields3).sendKeys(buyerInfoContent3);
		driver.findElement(BuyerFields4).sendKeys(buyerInfoContent4);
		Thread.sleep(Const);
		driver.findElement(nameasinPassport).sendKeys(nameasinPassportContent); // الاسم حسب جواز السفر
		Thread.sleep(Const);
		Select NationalityDDL = new Select(driver.findElement(nationality)); // الجنسية
		NationalityDDL.selectByVisibleText(Egyptian);
		Thread.sleep(Const);
		driver.findElement(phoneNumber).sendKeys(phoneNoContent); // رقم الهاتف
		Select CountryDDL = new Select(driver.findElement(CountryCode)); // الرمز الدولي
		CountryDDL.selectByVisibleText(code1);
		Thread.sleep(Const);
		Select passportTypeDDL = new Select(driver.findElement(passportType)); // نوع جواز السفر
		passportTypeDDL.selectByVisibleText(Permenant);
		Thread.sleep(Const);
		driver.findElement(passportNumber).sendKeys(passportNumberContent); // رقم جواز السفر
		Thread.sleep(Const);
		driver.findElement(productionDate).sendKeys(productionDateContent); // تاريخ الاصدار
		Thread.sleep(Const);
		driver.findElement(ExpiryDate).sendKeys(ExpiryDateContent); // تاريخ الانتهاء
		Thread.sleep(Const * 10);
		driver.findElement(productionLocation).sendKeys(productionLocationContent); // مكان الاصدار
		Thread.sleep(Const);

		Select arrivalCountryDDL = new Select(driver.findElement(arrivalCountry)); // بلد القدوم
		arrivalCountryDDL.selectByVisibleText(AbuDhabi);
		Thread.sleep(Const * 10);

		driver.findElement(placeOfBirth).sendKeys(placeOfBirthContent); // مكان الولادة
		Thread.sleep(Const * 10);
		driver.findElement(birthDate).sendKeys(dateOfBirthContent); // تاريخ الولادة
		Thread.sleep(Const * 10);

		driver.findElement(NoResidency).click(); // -لا - لديك إقامة بالمملكة
		Thread.sleep(Const * 10);
		driver.findElement(noProperty).click(); // لا - هل لديك عقارات داخل المملكة؟
		Thread.sleep(Const * 10);

		driver.findElement(currentResidenceAddress).sendKeys(currentResidenceAddressContent); // عنوان الإقامة الحالية
		Thread.sleep(Const);

		Select GenderDDL = new Select(driver.findElement(Gender)); // الجنس
		GenderDDL.selectByVisibleText(female); // أنثى
		Thread.sleep(Const * 10);

		Select SocialStatusDDL = new Select(driver.findElement(socialStatus)); // الحالة الاجتماعية
		SocialStatusDDL.selectByVisibleText(single); //أعزب
		//SocialStatusDDL.selectByVisibleText(married); // متزوج

		Thread.sleep(Const * 10);

		driver.findElement(job).sendKeys(JobContent); // عنوان الإقامة الحالية
		Thread.sleep(Const * 10);

		driver.findElement(registrationNo).sendKeys(registrationNoContent); // رقم الدخول
		Thread.sleep(Const);

		driver.findElement(additionalInfo).sendKeys(additionalInfoContent); // معلومات اضافية
		Thread.sleep(Const);

		driver.findElement(noOtherNationality).click();// - لا - جنسية أخرى
		Thread.sleep(Const);

		Select motherNationalityDDL = new Select(driver.findElement(motherNationality)); // جنسية الام
		motherNationalityDDL.selectByVisibleText(Jordanian);
		Thread.sleep(Const);

		driver.findElement(insideKigdom).click();// - نعم - هل المستدعى له داخل المملكة؟
		Thread.sleep(Const);
		// معلومات الام
		driver.findElement(MomFirstName).sendKeys(MomFirstNameContent);
		Thread.sleep(Const);
		driver.findElement(MomSecondName).sendKeys(MomSecondNameContent);
		Thread.sleep(Const);
		driver.findElement(MomThirdName).sendKeys(MomThirdNameContent);
		Thread.sleep(Const);
		driver.findElement(MomLastName).sendKeys(MomLastNameContent);
		   Thread.sleep(Const * 20);

		// ------------------------Purchaser InfoAttachments--------------------

	//	driver.findElement(Others).click();
	//	Thread.sleep(Const * 20);
		//Runtime.getRuntime().exec(AttachPath);
//		driver.findElement(Passport).click();
//		Thread.sleep(Const * 20);
//		Runtime.getRuntime().exec(AttachPath);
//		Thread.sleep(Const * 10);
		   
			driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:pc1:t2:1:pgl50\"]/tbody/tr/td[3]/span")).click();
			Thread.sleep(Const * 20);
			Runtime.getRuntime().exec(AttachPath);
			Thread.sleep(Const * 10);
			
			driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:pc1:t2:0:pgl50\"]/tbody/tr/td[3]/span")).click();
			Thread.sleep(Const * 20);
			Runtime.getRuntime().exec(AttachPath);
			Thread.sleep(Const * 10);
		Thread.sleep(Const * 10);
		driver.findElement(nextToPrpertyInfoFromPurchaserInfo).click();

		// ---------------------Property & Seller Info ------------------------------
		Thread.sleep(Const * 10);

		driver.findElement(recordNo).sendKeys("1-6BAE1P"); // رقم القيد
		Thread.sleep(Const * 10);
		driver.findElement(DLSKeyButton).click();
		Thread.sleep(Const * 10);
		driver.findElement(schemeNo).sendKeys("1-6BAE1P"); // الرقم المميز للمخطط
		Thread.sleep(Const);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:3:pgl5\"]/div[4]")).click(); // click-anywhere-to-navigate-out
		Thread.sleep(Const);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:3:pc2:t5:0:sbc2::content\"]")).click();
		
		// ------------------------Property InfoAttachments--------------------

		//driver.findElement(Others2).click();
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 20);
		//driver.findElement(CoRegistrationCertificate).click();
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 10);

		Thread.sleep(Const * 10);
		driver.findElement(NextToSellerAttach).click();

		//-------------------------Seller's Attachments----------------------

		//driver.findElement(IDCardSeller).click();
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 50);
		driver.findElement(NextToLinkPurchaserandSellers).click();

	   //--------------------------Link Purchaser with Seller----------------
		Thread.sleep(Const * 30);

		Select SellerName = new Select(driver.findElement(VendorName)); // اسم المشتري
		SellerName.selectByValue("1");
		Thread.sleep(Const);
		
		Select Properties = new Select(driver.findElement(PropertiesA2)); // العقارات
		Properties.selectByValue("1");
		Thread.sleep(Const);

		Select OwnerName = new Select(driver.findElement(ownerName)); //اسم المالك
		OwnerName.selectByValue("1");
		Thread.sleep(Const);
		
		driver.findElement(areatoBeOwnedNum).sendKeys("40"); //المساحة المراد تملكها رقما
		Thread.sleep(Const);
		
		driver.findElement(areatoBeOwned).sendKeys("40"); //المساحة المراد تملكها كتابة
		Thread.sleep(Const);
		
		driver.findElement(numberofProportions).sendKeys("2"); // الحصص المراد تملكها رقما
		Thread.sleep(Const*20);
		driver.findElement(NextToReviewSection).click();
		Thread.sleep(Const*20);
	//---------------------------Review Section ------------------------
		Thread.sleep(Const * 20);
		driver.findElement(submitRequest).click();
		Thread.sleep(Const * 50);

	}
	@Test
	// لغايات أخرى
	public void Case1500() throws InterruptedException, IOException {
		// -----------------------------Applicant info-----------------------------
		Select ApplicantTypeDDL = new Select(driver.findElement(ApplicantType));
		ApplicantTypeDDL.selectByVisibleText(purchaser); // مشتري
		Thread.sleep(Const * 10);
		// نوع الموافقة
		driver.findElement(InternalRequestApprovalRadio).click();
		Select Purpose = new Select(driver.findElement(PurposeOfPossession)); // الغاية الرئيسية
		Purpose.selectByVisibleText(Residential);
		Thread.sleep(Const * 20);
		Select Purpose2 = new Select(driver.findElement(SecondaryPurposeOfPossession)); // الغاية الفرعية
		Purpose2.selectByVisibleText(OtherPurposes);
		Thread.sleep(Const * 20);
		//navigate out
		driver.findElement(By.id("pt1:r1:1:s1")).click();
		//fill purpose
		driver.findElement(OtherPurpose).sendKeys("nn"); //غايات أخرى
		//navigate out
				driver.findElement(By.id("pt1:r1:1:s1")).click();
		// Next to Purchaser info
		Thread.sleep(Const*20);
		driver.findElement(nextToPurchaseInfo).click();
		// ---------------------------Purchaser info------------------------------
		// معلومات المشتري
		driver.findElement(BuyerFields1).sendKeys(buyerInfoContent1);
		driver.findElement(BuyerFields2).sendKeys(buyerInfoContent2);
		driver.findElement(BuyerFields3).sendKeys(buyerInfoContent3);
		driver.findElement(BuyerFields4).sendKeys(buyerInfoContent4);
		Thread.sleep(Const);
		driver.findElement(nameasinPassport).sendKeys(nameasinPassportContent); // الاسم حسب جواز السفر
		Thread.sleep(Const);
		Select NationalityDDL = new Select(driver.findElement(nationality)); // الجنسية
		NationalityDDL.selectByVisibleText(Egyptian);
		Thread.sleep(Const);
		driver.findElement(phoneNumber).sendKeys(phoneNoContent); // رقم الهاتف
		Select CountryDDL = new Select(driver.findElement(CountryCode)); // الرمز الدولي
		CountryDDL.selectByVisibleText(code1);
		Thread.sleep(Const);
		Select passportTypeDDL = new Select(driver.findElement(passportType)); // نوع جواز السفر
		passportTypeDDL.selectByVisibleText(Permenant);
		Thread.sleep(Const);
		driver.findElement(passportNumber).sendKeys(passportNumberContent); // رقم جواز السفر
		Thread.sleep(Const);
		driver.findElement(productionDate).sendKeys(productionDateContent); // تاريخ الاصدار
		Thread.sleep(Const);
		driver.findElement(ExpiryDate).sendKeys(ExpiryDateContent); // تاريخ الانتهاء
		Thread.sleep(Const * 10);
		driver.findElement(productionLocation).sendKeys(productionLocationContent); // مكان الاصدار
		Thread.sleep(Const);
		Select arrivalCountryDDL = new Select(driver.findElement(arrivalCountry)); // بلد القدوم
		arrivalCountryDDL.selectByVisibleText(AbuDhabi);
		Thread.sleep(Const * 10);
		driver.findElement(placeOfBirth).sendKeys(placeOfBirthContent); // مكان الولادة
		Thread.sleep(Const * 10);
		driver.findElement(birthDate).sendKeys(dateOfBirthContent); // تاريخ الولادة
		Thread.sleep(Const * 10);
		driver.findElement(NoResidency).click(); // -لا - لديك إقامة بالمملكة
		Thread.sleep(Const * 10);
		driver.findElement(noProperty).click(); // لا - هل لديك عقارات داخل المملكة؟
		Thread.sleep(Const * 10);
		driver.findElement(currentResidenceAddress).sendKeys(currentResidenceAddressContent); // عنوان الإقامة الحالية
		Thread.sleep(Const);
		Select GenderDDL = new Select(driver.findElement(Gender)); // الجنس
		GenderDDL.selectByVisibleText(female); // أنثى
		Thread.sleep(Const * 10);
		Select SocialStatusDDL = new Select(driver.findElement(socialStatus)); // الحالة الاجتماعية
		 SocialStatusDDL.selectByVisibleText(single); //أعزب
		//SocialStatusDDL.selectByVisibleText(married); // متزوج
		Thread.sleep(Const * 10);
		driver.findElement(job).sendKeys(JobContent); // عنوان الإقامة الحالية
		Thread.sleep(Const * 10);

		driver.findElement(registrationNo).sendKeys(registrationNoContent); // رقم الدخول
		Thread.sleep(Const);

		driver.findElement(additionalInfo).sendKeys(additionalInfoContent); // معلومات اضافية
		Thread.sleep(Const);

		driver.findElement(noOtherNationality).click();// - لا - جنسية أخرى
		Thread.sleep(Const);

		Select motherNationalityDDL = new Select(driver.findElement(motherNationality)); // جنسية الام
		motherNationalityDDL.selectByVisibleText(Jordanian);
		Thread.sleep(Const);

		driver.findElement(insideKigdom).click();// - نعم - هل المستدعى له داخل المملكة؟
		Thread.sleep(Const);
		// معلومات الام
		driver.findElement(MomFirstName).sendKeys(MomFirstNameContent);
		Thread.sleep(Const);
		driver.findElement(MomSecondName).sendKeys(MomSecondNameContent);
		Thread.sleep(Const);
		driver.findElement(MomThirdName).sendKeys(MomThirdNameContent);
		Thread.sleep(Const);
		driver.findElement(MomLastName).sendKeys(MomLastNameContent);
		   Thread.sleep(Const * 20);

		// ------------------------Purchaser InfoAttachments--------------------

		//driver.findElement(Others).click();
		//Thread.sleep(Const * 20);
		//Runtime.getRuntime().exec(AttachPath);
//		driver.findElement(Passport).click();
//		Thread.sleep(Const * 20);
//		Runtime.getRuntime().exec(AttachPath);
//		Thread.sleep(Const * 10);
			driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:pc1:t2:1:pgl50\"]/tbody/tr/td[3]/span")).click();
			Thread.sleep(Const * 20);
			Runtime.getRuntime().exec(AttachPath);
			Thread.sleep(Const * 10);
			
			driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:pc1:t2:0:pgl50\"]/tbody/tr/td[3]/span")).click();
			Thread.sleep(Const * 20);
			Runtime.getRuntime().exec(AttachPath);
			Thread.sleep(Const * 10);
		Thread.sleep(Const * 10);
		driver.findElement(nextToPrpertyInfoFromPurchaserInfo).click();

		// ---------------------Property & Seller Info ------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(recordNo).sendKeys("1-6BAE1P"); // رقم القيد
		Thread.sleep(Const * 10);
		driver.findElement(DLSKeyButton).click();
		Thread.sleep(Const * 10);
		driver.findElement(schemeNo).sendKeys("1-6BAE1P"); // الرقم المميز للمخطط
		Thread.sleep(Const);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:3:pgl5\"]/div[4]")).click(); // click-anywhere-to-navigate-out
		Thread.sleep(Const);
		//driver.findElement(OwnersCheckbox).click();
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:3:pc2:t5:0:sbc2::content\"]")).click();
		
		
		// ------------------------Property InfoAttachments--------------------

		//driver.findElement(Others2).click();
		Thread.sleep(Const * 20);
		//Runtime.getRuntime().exec(AttachPath);
		//Thread.sleep(Const * 20);
		//driver.findElement(CoRegistrationCertificate).click();
		
		//Thread.sleep(Const * 20);
		//Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 10);

		Thread.sleep(Const * 10);
		driver.findElement(NextToSellerAttach).click();

		//-------------------------Seller's Attachments----------------------

		//driver.findElement(IDCardSeller).click();
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:4:pc1:t2:0:pgl50\"]/tbody/tr/td[3]/span")).click();
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 50);
		driver.findElement(NextToLinkPurchaserandSellers).click();

	   //--------------------------Link Purchaser with Seller----------------
		Thread.sleep(Const * 30);

		Select SellerName = new Select(driver.findElement(VendorName)); // اسم المشتري
		SellerName.selectByValue("0");
		Thread.sleep(Const);		
		Select Properties = new Select(driver.findElement(PropertiesA2)); // العقارات
		Properties.selectByValue("0");
		Thread.sleep(Const);
		Select OwnerName = new Select(driver.findElement(ownerName)); //اسم المالك
		OwnerName.selectByValue("0");
		Thread.sleep(Const);		
		driver.findElement(areatoBeOwnedNum).sendKeys("40"); //المساحة المراد تملكها رقما
		Thread.sleep(Const);	
		driver.findElement(areatoBeOwned).sendKeys("40"); //المساحة المراد تملكها كتابة
		Thread.sleep(Const);
		driver.findElement(numberofProportions).sendKeys("2"); // الحصص المراد تملكها رقما
		Thread.sleep(Const*20);
		//navigate out
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:5:ssjj\"]/div[8]")).click();
		Thread.sleep(Const*20);
		driver.findElement(NextToReviewSection).click();
		Thread.sleep(Const*20);
	//---------------------------Review Section ------------------------
		Thread.sleep(Const * 20);
		driver.findElement(submitRequest).click();
		Thread.sleep(Const * 50);

	}
	@Test
	//تأجير تمويلي
	public void Case1600() throws InterruptedException, IOException {
		// -----------------------------Applicant info-----------------------------

		Select ApplicantTypeDDL = new Select(driver.findElement(ApplicantType));
		ApplicantTypeDDL.selectByVisibleText(purchaser); // مشتري
		Thread.sleep(Const * 10);
		// نوع الموافقة
		driver.findElement(InternalRequestApprovalRadio).click();
		Select Purpose = new Select(driver.findElement(PurposeOfPossession)); // الغاية الرئيسية
		Purpose.selectByVisibleText(FinanceLease);
		Thread.sleep(Const * 20);
		Select Purpose2 = new Select(driver.findElement(SecondaryPurposeOfPossession)); // الغاية الفرعية
		Purpose2.selectByVisibleText(CombineAreas);
		Thread.sleep(Const * 20);
		//navigate out
		driver.findElement(By.id("pt1:r1:1:s1")).click();
 
		//navigate out
				driver.findElement(By.id("pt1:r1:1:s1")).click();
		// Next to Purchaser info
		Thread.sleep(Const*20);
		driver.findElement(nextToPurchaseInfo).click();

		// ---------------------------Purchaser info------------------------------

		// معلومات المشتري
		driver.findElement(BuyerFields1).sendKeys(buyerInfoContent1);
		driver.findElement(BuyerFields2).sendKeys(buyerInfoContent2);
		driver.findElement(BuyerFields3).sendKeys(buyerInfoContent3);
		driver.findElement(BuyerFields4).sendKeys(buyerInfoContent4);
		Thread.sleep(Const);
		driver.findElement(nameasinPassport).sendKeys(nameasinPassportContent); // الاسم حسب جواز السفر
		Thread.sleep(Const);
		Select NationalityDDL = new Select(driver.findElement(nationality)); // الجنسية
		NationalityDDL.selectByVisibleText(Egyptian);
		Thread.sleep(Const);
		driver.findElement(phoneNumber).sendKeys(phoneNoContent); // رقم الهاتف
		Select CountryDDL = new Select(driver.findElement(CountryCode)); // الرمز الدولي
		CountryDDL.selectByVisibleText(code1);
		Thread.sleep(Const);
		Select passportTypeDDL = new Select(driver.findElement(passportType)); // نوع جواز السفر
		passportTypeDDL.selectByVisibleText(Permenant);
		Thread.sleep(Const);
		driver.findElement(passportNumber).sendKeys(passportNumberContent); // رقم جواز السفر
		Thread.sleep(Const);
		driver.findElement(productionDate).sendKeys(productionDateContent); // تاريخ الاصدار
		Thread.sleep(Const);
		driver.findElement(ExpiryDate).sendKeys(ExpiryDateContent); // تاريخ الانتهاء
		Thread.sleep(Const * 10);
		driver.findElement(productionLocation).sendKeys(productionLocationContent); // مكان الاصدار
		Thread.sleep(Const);

		Select arrivalCountryDDL = new Select(driver.findElement(arrivalCountry)); // بلد القدوم
		arrivalCountryDDL.selectByVisibleText(AbuDhabi);
		Thread.sleep(Const * 10);

		driver.findElement(placeOfBirth).sendKeys(placeOfBirthContent); // مكان الولادة
		Thread.sleep(Const * 10);
		driver.findElement(birthDate).sendKeys(dateOfBirthContent); // تاريخ الولادة
		Thread.sleep(Const * 10);

		driver.findElement(NoResidency).click(); // -لا - لديك إقامة بالمملكة
		Thread.sleep(Const * 10);
		driver.findElement(noProperty).click(); // لا - هل لديك عقارات داخل المملكة؟
		Thread.sleep(Const * 10);

		driver.findElement(currentResidenceAddress).sendKeys(currentResidenceAddressContent); // عنوان الإقامة الحالية
		Thread.sleep(Const);

		Select GenderDDL = new Select(driver.findElement(Gender)); // الجنس
		GenderDDL.selectByVisibleText(female); // أنثى
		Thread.sleep(Const * 10);

		Select SocialStatusDDL = new Select(driver.findElement(socialStatus)); // الحالة الاجتماعية
		 SocialStatusDDL.selectByVisibleText(single); //أعزب
		//SocialStatusDDL.selectByVisibleText(married); // متزوج

		Thread.sleep(Const * 10);

		driver.findElement(job).sendKeys(JobContent); // عنوان الإقامة الحالية
		Thread.sleep(Const * 10);

		driver.findElement(registrationNo).sendKeys(registrationNoContent); // رقم الدخول
		Thread.sleep(Const);

		driver.findElement(additionalInfo).sendKeys(additionalInfoContent); // معلومات اضافية
		Thread.sleep(Const);

		driver.findElement(noOtherNationality).click();// - لا - جنسية أخرى
		Thread.sleep(Const);

		Select motherNationalityDDL = new Select(driver.findElement(motherNationality)); // جنسية الام
		motherNationalityDDL.selectByVisibleText(Jordanian);
		Thread.sleep(Const);

		driver.findElement(insideKigdom).click();// - نعم - هل المستدعى له داخل المملكة؟
		Thread.sleep(Const);
		// معلومات الام
		driver.findElement(MomFirstName).sendKeys(MomFirstNameContent);
		Thread.sleep(Const);
		driver.findElement(MomSecondName).sendKeys(MomSecondNameContent);
		Thread.sleep(Const);
		driver.findElement(MomThirdName).sendKeys(MomThirdNameContent);
		Thread.sleep(Const);
		driver.findElement(MomLastName).sendKeys(MomLastNameContent);
		   Thread.sleep(Const * 20);

		// ------------------------Purchaser InfoAttachments--------------------

		//driver.findElement(Others).click();
		//Thread.sleep(Const * 20);
		//Runtime.getRuntime().exec(AttachPath);
//		driver.findElement(Passport).click();
//		Thread.sleep(Const * 20);
//		Runtime.getRuntime().exec(AttachPath);
//		Thread.sleep(Const * 10);

		Thread.sleep(Const * 10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:pc1:t2:1:pgl50\"]/tbody/tr/td[3]/span")).click();
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 10);
		
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:pc1:t2:0:pgl50\"]/tbody/tr/td[3]/span")).click();
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 10);
		driver.findElement(nextToPrpertyInfoFromPurchaserInfo).click();

		// ---------------------Property & Seller Info ------------------------------
		Thread.sleep(Const * 10);

		driver.findElement(recordNo).sendKeys("1-6BAE1P"); // رقم القيد
		Thread.sleep(Const * 10);
		driver.findElement(DLSKeyButton).click();
		Thread.sleep(Const * 10);
		driver.findElement(schemeNo).sendKeys("1-6BAE1P"); // الرقم المميز للمخطط
		Thread.sleep(Const);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pgl5\"]/div[4]")).click(); // click-anywhere-to-navigate-out
		Thread.sleep(Const);
		driver.findElement(OwnersCheckbox).click();
		
		// ------------------------Property InfoAttachments--------------------

		driver.findElement(Others2).click();
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 20);
		driver.findElement(CoRegistrationCertificate).click();
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 10);

		Thread.sleep(Const * 10);
		driver.findElement(NextToSellerAttach).click();

		//-------------------------Seller's Attachments----------------------

		driver.findElement(IDCardSeller).click();
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 50);
		driver.findElement(NextToLinkPurchaserandSellers).click();

	   //--------------------------Link Purchaser with Seller----------------
		Thread.sleep(Const * 30);

		Select SellerName = new Select(driver.findElement(VendorName)); // اسم المشتري
		SellerName.selectByValue("1");
		Thread.sleep(Const);
		
		Select Properties = new Select(driver.findElement(PropertiesA2)); // العقارات
		Properties.selectByValue("1");
		Thread.sleep(Const);

		Select OwnerName = new Select(driver.findElement(ownerName)); //اسم المالك
		OwnerName.selectByValue("1");
		Thread.sleep(Const);
		
		driver.findElement(areatoBeOwnedNum).sendKeys("40"); //المساحة المراد تملكها رقما
		Thread.sleep(Const);
		
		driver.findElement(areatoBeOwned).sendKeys("40"); //المساحة المراد تملكها كتابة
		Thread.sleep(Const);
		
		driver.findElement(numberofProportions).sendKeys("2"); // الحصص المراد تملكها رقما
		Thread.sleep(Const*20);
		driver.findElement(NextToReviewSection).click();
		Thread.sleep(Const*20);
	//---------------------------Review Section ------------------------
		Thread.sleep(Const * 20);
		driver.findElement(submitRequest).click();
		Thread.sleep(Const * 50);

	}
	@Test
	// اصلاح و افراز و تطوير
	public void Case1700() throws InterruptedException, IOException {
		// -----------------------------Applicant info-----------------------------

		Select ApplicantTypeDDL = new Select(driver.findElement(ApplicantType));
		ApplicantTypeDDL.selectByVisibleText(purchaser); // مشتري
		Thread.sleep(Const * 10);
		// نوع الموافقة
		driver.findElement(InternalRequestApprovalRadio).click();
		Select Purpose = new Select(driver.findElement(PurposeOfPossession)); // الغاية الرئيسية
		Purpose.selectByVisibleText(RepairnadDischargeDevelopment);
		Thread.sleep(Const * 20);
		Select Purpose2 = new Select(driver.findElement(SecondaryPurposeOfPossession)); // الغاية الفرعية
		Purpose2.selectByVisibleText(CombineAreas);
		Thread.sleep(Const * 20);
		//navigate out
		driver.findElement(By.id("pt1:r1:1:s1")).click();
 
		//navigate out
				driver.findElement(By.id("pt1:r1:1:s1")).click();
		// Next to Purchaser info
		Thread.sleep(Const*20);
		driver.findElement(nextToPurchaseInfo).click();

		// ---------------------------Purchaser info------------------------------

		// معلومات المشتري
		driver.findElement(BuyerFields1).sendKeys(buyerInfoContent1);
		driver.findElement(BuyerFields2).sendKeys(buyerInfoContent2);
		driver.findElement(BuyerFields3).sendKeys(buyerInfoContent3);
		driver.findElement(BuyerFields4).sendKeys(buyerInfoContent4);
		Thread.sleep(Const);
		driver.findElement(nameasinPassport).sendKeys(nameasinPassportContent); // الاسم حسب جواز السفر
		Thread.sleep(Const);
		Select NationalityDDL = new Select(driver.findElement(nationality)); // الجنسية
		NationalityDDL.selectByVisibleText(Egyptian);
		Thread.sleep(Const);
		driver.findElement(phoneNumber).sendKeys(phoneNoContent); // رقم الهاتف
		Select CountryDDL = new Select(driver.findElement(CountryCode)); // الرمز الدولي
		CountryDDL.selectByVisibleText(code1);
		Thread.sleep(Const);
		Select passportTypeDDL = new Select(driver.findElement(passportType)); // نوع جواز السفر
		passportTypeDDL.selectByVisibleText(Permenant);
		Thread.sleep(Const);
		driver.findElement(passportNumber).sendKeys(passportNumberContent); // رقم جواز السفر
		Thread.sleep(Const);
		driver.findElement(productionDate).sendKeys(productionDateContent); // تاريخ الاصدار
		Thread.sleep(Const);
		driver.findElement(ExpiryDate).sendKeys(ExpiryDateContent); // تاريخ الانتهاء
		Thread.sleep(Const * 10);
		driver.findElement(productionLocation).sendKeys(productionLocationContent); // مكان الاصدار
		Thread.sleep(Const);

		Select arrivalCountryDDL = new Select(driver.findElement(arrivalCountry)); // بلد القدوم
		arrivalCountryDDL.selectByVisibleText(AbuDhabi);
		Thread.sleep(Const * 10);

		driver.findElement(placeOfBirth).sendKeys(placeOfBirthContent); // مكان الولادة
		Thread.sleep(Const * 10);
		driver.findElement(birthDate).sendKeys(dateOfBirthContent); // تاريخ الولادة
		Thread.sleep(Const * 10);

		driver.findElement(NoResidency).click(); // -لا - لديك إقامة بالمملكة
		Thread.sleep(Const * 10);
		driver.findElement(noProperty).click(); // لا - هل لديك عقارات داخل المملكة؟
		Thread.sleep(Const * 10);

		driver.findElement(currentResidenceAddress).sendKeys(currentResidenceAddressContent); // عنوان الإقامة الحالية
		Thread.sleep(Const);

		Select GenderDDL = new Select(driver.findElement(Gender)); // الجنس
		GenderDDL.selectByVisibleText(female); // أنثى
		Thread.sleep(Const * 10);

		Select SocialStatusDDL = new Select(driver.findElement(socialStatus)); // الحالة الاجتماعية
		 SocialStatusDDL.selectByVisibleText(single); //أعزب
		//SocialStatusDDL.selectByVisibleText(married); // متزوج

		Thread.sleep(Const * 10);

		driver.findElement(job).sendKeys(JobContent); // عنوان الإقامة الحالية
		Thread.sleep(Const * 10);

		driver.findElement(registrationNo).sendKeys(registrationNoContent); // رقم الدخول
		Thread.sleep(Const);

		driver.findElement(additionalInfo).sendKeys(additionalInfoContent); // معلومات اضافية
		Thread.sleep(Const);

		driver.findElement(noOtherNationality).click();// - لا - جنسية أخرى
		Thread.sleep(Const);

		Select motherNationalityDDL = new Select(driver.findElement(motherNationality)); // جنسية الام
		motherNationalityDDL.selectByVisibleText(Jordanian);
		Thread.sleep(Const);

		driver.findElement(insideKigdom).click();// - نعم - هل المستدعى له داخل المملكة؟
		Thread.sleep(Const);
		// معلومات الام
		driver.findElement(MomFirstName).sendKeys(MomFirstNameContent);
		Thread.sleep(Const);
		driver.findElement(MomSecondName).sendKeys(MomSecondNameContent);
		Thread.sleep(Const);
		driver.findElement(MomThirdName).sendKeys(MomThirdNameContent);
		Thread.sleep(Const);
		driver.findElement(MomLastName).sendKeys(MomLastNameContent);
		   Thread.sleep(Const * 20);

		// ------------------------Purchaser InfoAttachments--------------------

		//driver.findElement(Others).click();
		//Thread.sleep(Const * 20);
		//Runtime.getRuntime().exec(AttachPath);
		driver.findElement(Passport).click();
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 10);

		Thread.sleep(Const * 10);
		driver.findElement(nextToPrpertyInfoFromPurchaserInfo).click();

		// ---------------------Property & Seller Info ------------------------------
		Thread.sleep(Const * 10);

		driver.findElement(recordNo).sendKeys("1-6BAE1P"); // رقم القيد
		Thread.sleep(Const * 10);
		driver.findElement(DLSKeyButton).click();
		Thread.sleep(Const * 10);
		driver.findElement(schemeNo).sendKeys("1-6BAE1P"); // الرقم المميز للمخطط
		Thread.sleep(Const);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pgl5\"]/div[4]")).click(); // click-anywhere-to-navigate-out
		Thread.sleep(Const);
		driver.findElement(OwnersCheckbox).click();
		
		// ------------------------Property InfoAttachments--------------------

		driver.findElement(Others2).click();
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 20);
		driver.findElement(CoRegistrationCertificate).click();
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 10);

		Thread.sleep(Const * 10);
		driver.findElement(NextToSellerAttach).click();

		//-------------------------Seller's Attachments----------------------

		driver.findElement(IDCardSeller).click();
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 50);
		driver.findElement(NextToLinkPurchaserandSellers).click();

	   //--------------------------Link Purchaser with Seller----------------
		Thread.sleep(Const * 30);

		Select SellerName = new Select(driver.findElement(VendorName)); // اسم المشتري
		SellerName.selectByValue("1");
		Thread.sleep(Const);
		
		Select Properties = new Select(driver.findElement(PropertiesA2)); // العقارات
		Properties.selectByValue("1");
		Thread.sleep(Const);

		Select OwnerName = new Select(driver.findElement(ownerName)); //اسم المالك
		OwnerName.selectByValue("1");
		Thread.sleep(Const);
		
		driver.findElement(areatoBeOwnedNum).sendKeys("40"); //المساحة المراد تملكها رقما
		Thread.sleep(Const);
		
		driver.findElement(areatoBeOwned).sendKeys("40"); //المساحة المراد تملكها كتابة
		Thread.sleep(Const);
		
		driver.findElement(numberofProportions).sendKeys("2"); // الحصص المراد تملكها رقما
		Thread.sleep(Const*20);
		driver.findElement(NextToReviewSection).click();
		Thread.sleep(Const*20);
	//---------------------------Review Section ------------------------
		Thread.sleep(Const * 20);
		driver.findElement(submitRequest).click();
		Thread.sleep(Const * 50);

	}
	@Test
	//  المشتري سوري الجنسية مقيم داخل المملكة
	
    public void Case2000() throws InterruptedException, IOException {
		// -----------------------------Applicant info-----------------------------

		Select ApplicantTypeDDL = new Select(driver.findElement(ApplicantType));
		ApplicantTypeDDL.selectByVisibleText(purchaser); // مشتري
		Thread.sleep(Const * 10);
		// نوع الموافقة
		driver.findElement(InternalRequestApprovalRadio).click();
		Select Purpose = new Select(driver.findElement(PurposeOfPossession)); // الغاية الرئيسية
		Purpose.selectByVisibleText(Residential);
		Thread.sleep(Const * 20);
		Select Purpose2 = new Select(driver.findElement(SecondaryPurposeOfPossession)); // الغاية الفرعية
		Purpose2.selectByVisibleText(Residence);
		
		// Next to Purchaser info
		Thread.sleep(Const);
		driver.findElement(nextToPurchaseInfo).click();

		// ---------------------------Purchaser info------------------------------

		// معلومات المشتري
		driver.findElement(BuyerFields1).sendKeys(buyerInfoContent1);
		driver.findElement(BuyerFields2).sendKeys(buyerInfoContent2);
		driver.findElement(BuyerFields3).sendKeys(buyerInfoContent3);
		driver.findElement(BuyerFields4).sendKeys(buyerInfoContent4);
		Thread.sleep(Const);
		driver.findElement(nameasinPassport).sendKeys(nameasinPassportContent); // الاسم حسب جواز السفر
		Thread.sleep(Const);
		Select NationalityDDL = new Select(driver.findElement(nationality)); // الجنسية
		NationalityDDL.selectByVisibleText(Syrian);
		Thread.sleep(Const);
		driver.findElement(phoneNumber).sendKeys(phoneNoContent); // رقم الهاتف
		Select CountryDDL = new Select(driver.findElement(CountryCode)); // الرمز الدولي
		CountryDDL.selectByVisibleText(code1);
		Thread.sleep(Const);
		Select passportTypeDDL = new Select(driver.findElement(passportType)); // نوع جواز السفر
		passportTypeDDL.selectByVisibleText(Permenant);
		Thread.sleep(Const);
		driver.findElement(passportNumber).sendKeys(passportNumberContent); // رقم جواز السفر
		Thread.sleep(Const);
		driver.findElement(productionDate).sendKeys(productionDateContent); // تاريخ الاصدار
		Thread.sleep(Const);
		driver.findElement(ExpiryDate).sendKeys(ExpiryDateContent); // تاريخ الانتهاء
		Thread.sleep(Const * 10);
		driver.findElement(productionLocation).sendKeys(productionLocationContent); // مكان الاصدار
		Thread.sleep(Const);

		Select arrivalCountryDDL = new Select(driver.findElement(arrivalCountry)); // بلد القدوم
		arrivalCountryDDL.selectByVisibleText(AbuDhabi);
		Thread.sleep(Const * 10);

		driver.findElement(placeOfBirth).sendKeys(placeOfBirthContent); // مكان الولادة
		Thread.sleep(Const * 10);
		driver.findElement(birthDate).sendKeys(dateOfBirthContent); // تاريخ الولادة
		Thread.sleep(Const * 30);

		driver.findElement(YesResidency2).click(); // -نعم - لديك إقامة بالمملكة
		Thread.sleep(Const * 10);
		
		
		driver.findElement(noProperty).click(); // لا - هل لديك عقارات داخل المملكة؟
		Thread.sleep(Const * 10);
		driver.findElement(ResidencyNo).sendKeys("45521"); //  
		Thread.sleep(Const * 10);
		driver.findElement(ResidencyDate).sendKeys("1995/08/13"); //  

		driver.findElement(currentResidenceAddress).sendKeys(currentResidenceAddressContent); // عنوان الإقامة الحالية
		Thread.sleep(Const);

		Select GenderDDL = new Select(driver.findElement(Gender)); // الجنس
		GenderDDL.selectByVisibleText(female); // أنثى
		Thread.sleep(Const * 10);

		Select SocialStatusDDL = new Select(driver.findElement(socialStatus)); // الحالة الاجتماعية
		 SocialStatusDDL.selectByVisibleText(single); //أعزب
		//SocialStatusDDL.selectByVisibleText(married); // متزوج

		Thread.sleep(Const * 10);

		driver.findElement(job).sendKeys(JobContent); // عنوان الإقامة الحالية
		Thread.sleep(Const * 10);

		driver.findElement(registrationNo).sendKeys(registrationNoContent); // رقم الدخول
		Thread.sleep(Const);

		driver.findElement(additionalInfo).sendKeys(additionalInfoContent); // معلومات اضافية
		Thread.sleep(Const);

		driver.findElement(noOtherNationality).click();// - لا - جنسية أخرى
		Thread.sleep(Const);

		Select motherNationalityDDL = new Select(driver.findElement(motherNationality)); // جنسية الام
		motherNationalityDDL.selectByVisibleText(Jordanian);
		Thread.sleep(Const);

		driver.findElement(insideKigdom).click();// - نعم - هل المستدعى له داخل المملكة؟
		Thread.sleep(Const);
		// معلومات الام
		driver.findElement(MomFirstName).sendKeys(MomFirstNameContent);
		Thread.sleep(Const);
		driver.findElement(MomSecondName).sendKeys(MomSecondNameContent);
		Thread.sleep(Const);
		driver.findElement(MomThirdName).sendKeys(MomThirdNameContent);
		Thread.sleep(Const);
		driver.findElement(MomLastName).sendKeys(MomLastNameContent);
		   Thread.sleep(Const * 20);

		// ------------------------Purchaser InfoAttachments--------------------

		//driver.findElement(Others).click();
		//Thread.sleep(Const * 20);
		//Runtime.getRuntime().exec(AttachPath);
		driver.findElement(SecurityCard).click();
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 10);

		Thread.sleep(Const * 10);
		driver.findElement(nextToPrpertyInfoFromPurchaserInfo).click();

		// ---------------------Property & Seller Info ------------------------------
		Thread.sleep(Const * 10);

		driver.findElement(recordNo).sendKeys("1-6BAE1P"); // رقم القيد
		Thread.sleep(Const * 10);
		driver.findElement(DLSKeyButton).click();
		Thread.sleep(Const * 10);
		driver.findElement(schemeNo).sendKeys("1-6BAE1P"); // الرقم المميز للمخطط
		Thread.sleep(Const);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pgl5\"]/div[4]")).click(); // click-anywhere-to-navigate-out
		Thread.sleep(Const);
		driver.findElement(OwnersCheckbox).click();
		
		// ------------------------Property InfoAttachments--------------------

		driver.findElement(Others2).click();
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 20);
		driver.findElement(CoRegistrationCertificate).click();
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 10);

		Thread.sleep(Const * 10);
		driver.findElement(NextToSellerAttach).click();

		//-------------------------Seller's Attachments----------------------

		driver.findElement(IDCardSeller).click();
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 50);
		driver.findElement(NextToLinkPurchaserandSellers).click();

	   //--------------------------Link Purchaser with Seller----------------
		Thread.sleep(Const * 30);

		Select SellerName = new Select(driver.findElement(VendorName)); // اسم المشتري
		SellerName.selectByValue("1");
		Thread.sleep(Const);
		
		Select Properties = new Select(driver.findElement(PropertiesA2)); // العقارات
		Properties.selectByValue("1");
		Thread.sleep(Const);

		Select OwnerName = new Select(driver.findElement(ownerName)); //اسم المالك
		OwnerName.selectByValue("1");
		Thread.sleep(Const);
		
		driver.findElement(areatoBeOwnedNum).sendKeys("40"); //المساحة المراد تملكها رقما
		Thread.sleep(Const);
		
		driver.findElement(areatoBeOwned).sendKeys("40"); //المساحة المراد تملكها كتابة
		Thread.sleep(Const);
		
		driver.findElement(numberofProportions).sendKeys("2"); // الحصص المراد تملكها رقما
		Thread.sleep(Const*20);
		driver.findElement(NextToReviewSection).click();
		Thread.sleep(Const*20);
	//---------------------------Review Section ------------------------
		Thread.sleep(Const * 20);
		driver.findElement(submitRequest).click();
		Thread.sleep(Const * 50);

	}
	@Test
	//  المشتري سوري الجنسية مقيم خارج المملكة
	public void Case2100() throws InterruptedException, IOException {
		// -----------------------------Applicant info-----------------------------

		Select ApplicantTypeDDL = new Select(driver.findElement(ApplicantType));
		ApplicantTypeDDL.selectByVisibleText(purchaser); // مشتري
		Thread.sleep(Const * 10);
		// نوع الموافقة
		driver.findElement(InternalRequestApprovalRadio).click();
		Select Purpose = new Select(driver.findElement(PurposeOfPossession)); // الغاية الرئيسية
		Purpose.selectByVisibleText(Residential);
		Thread.sleep(Const * 20);
		Select Purpose2 = new Select(driver.findElement(SecondaryPurposeOfPossession)); // الغاية الفرعية
		Purpose2.selectByVisibleText(Residence);
		
		// Next to Purchaser info
		Thread.sleep(Const);
		driver.findElement(nextToPurchaseInfo).click();

		// ---------------------------Purchaser info------------------------------
		// معلومات المشتري
		driver.findElement(BuyerFields1).sendKeys(buyerInfoContent1);
		driver.findElement(BuyerFields2).sendKeys(buyerInfoContent2);
		driver.findElement(BuyerFields3).sendKeys(buyerInfoContent3);
		driver.findElement(BuyerFields4).sendKeys(buyerInfoContent4);
		Thread.sleep(Const);
		driver.findElement(nameasinPassport).sendKeys(nameasinPassportContent); // الاسم حسب جواز السفر
		Thread.sleep(Const);
		Select NationalityDDL = new Select(driver.findElement(nationality)); // الجنسية
		NationalityDDL.selectByVisibleText(Syrian);
		Thread.sleep(Const);
		driver.findElement(phoneNumber).sendKeys(phoneNoContent); // رقم الهاتف
		Select CountryDDL = new Select(driver.findElement(CountryCode)); // الرمز الدولي
		CountryDDL.selectByVisibleText(code1);
		Thread.sleep(Const);
		Select passportTypeDDL = new Select(driver.findElement(passportType)); // نوع جواز السفر
		passportTypeDDL.selectByVisibleText(Permenant);
		Thread.sleep(Const);
		driver.findElement(passportNumber).sendKeys(passportNumberContent); // رقم جواز السفر
		Thread.sleep(Const);
		driver.findElement(productionDate).sendKeys(productionDateContent); // تاريخ الاصدار
		Thread.sleep(Const);
		driver.findElement(ExpiryDate).sendKeys(ExpiryDateContent); // تاريخ الانتهاء
		Thread.sleep(Const * 10);
		driver.findElement(productionLocation).sendKeys(productionLocationContent); // مكان الاصدار
		Thread.sleep(Const);
		Select arrivalCountryDDL = new Select(driver.findElement(arrivalCountry)); // بلد القدوم
		arrivalCountryDDL.selectByVisibleText(AbuDhabi);
		Thread.sleep(Const * 10);
		driver.findElement(placeOfBirth).sendKeys(placeOfBirthContent); // مكان الولادة
		Thread.sleep(Const * 10);
		driver.findElement(birthDate).sendKeys(dateOfBirthContent); // تاريخ الولادة
		Thread.sleep(Const * 10);

		driver.findElement(NoResidency).click(); // -نعم - لديك إقامة بالمملكة
		Thread.sleep(Const * 10);
		driver.findElement(noProperty).click(); // لا - هل لديك عقارات داخل المملكة؟
		Thread.sleep(Const * 10);

		driver.findElement(currentResidenceAddress).sendKeys(currentResidenceAddressContent); // عنوان الإقامة الحالية
		Thread.sleep(Const);

		Select GenderDDL = new Select(driver.findElement(Gender)); // الجنس
		GenderDDL.selectByVisibleText(female); // أنثى
		Thread.sleep(Const * 10);

		Select SocialStatusDDL = new Select(driver.findElement(socialStatus)); // الحالة الاجتماعية
		// SocialStatusDDL.selectByVisibleText(single); //أعزب
		SocialStatusDDL.selectByVisibleText(married); // متزوج

		Thread.sleep(Const * 10);

		driver.findElement(job).sendKeys(JobContent); // عنوان الإقامة الحالية
		Thread.sleep(Const * 10);

		driver.findElement(registrationNo).sendKeys(registrationNoContent); // رقم الدخول
		Thread.sleep(Const);

		driver.findElement(additionalInfo).sendKeys(additionalInfoContent); // معلومات اضافية
		Thread.sleep(Const);

		driver.findElement(noOtherNationality).click();// - لا - جنسية أخرى
		Thread.sleep(Const);

		Select motherNationalityDDL = new Select(driver.findElement(motherNationality)); // جنسية الام
		motherNationalityDDL.selectByVisibleText(Jordanian);
		Thread.sleep(Const);

		driver.findElement(insideKigdom).click();// - نعم - هل المستدعى له داخل المملكة؟
		Thread.sleep(Const);
		// معلومات الام
		driver.findElement(MomFirstName).sendKeys(MomFirstNameContent);
		Thread.sleep(Const);
		driver.findElement(MomSecondName).sendKeys(MomSecondNameContent);
		Thread.sleep(Const);
		driver.findElement(MomThirdName).sendKeys(MomThirdNameContent);
		Thread.sleep(Const);
		driver.findElement(MomLastName).sendKeys(MomLastNameContent);
		   Thread.sleep(Const * 20);

		// ------------------------Purchaser InfoAttachments--------------------

//		driver.findElement(Others).click();
//		Thread.sleep(Const * 20);
//		Runtime.getRuntime().exec(AttachPath);
		driver.findElement(ResidenceCard).click(); //البطاقة الأمنية
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 10);

		Thread.sleep(Const * 10);
		driver.findElement(nextToPrpertyInfoFromPurchaserInfo).click();

		// ---------------------Property & Seller Info ------------------------------
		Thread.sleep(Const * 10);

		driver.findElement(recordNo).sendKeys("1-6BAE1P"); // رقم القيد
		Thread.sleep(Const * 10);
		driver.findElement(DLSKeyButton).click();
		Thread.sleep(Const * 10);
		driver.findElement(schemeNo).sendKeys("1-6BAE1P"); // الرقم المميز للمخطط
		Thread.sleep(Const);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pgl5\"]/div[4]")).click(); // click-anywhere-to-navigate-out
		Thread.sleep(Const);
		driver.findElement(OwnersCheckbox).click();
		
		// ------------------------Property InfoAttachments--------------------

		//driver.findElement(Others2).click();
		//Thread.sleep(Const * 20);
		//Runtime.getRuntime().exec(AttachPath);
		//Thread.sleep(Const * 20);
	
		Thread.sleep(Const * 10);
		driver.findElement(NextToSellerAttach).click();

		//-------------------------Seller's Attachments----------------------

		driver.findElement(IDCardSeller).click();
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 50);
		driver.findElement(NextToLinkPurchaserandSellers).click();

	   //--------------------------Link Purchaser with Seller----------------
		Thread.sleep(Const * 30);

		Select SellerName = new Select(driver.findElement(VendorName)); // اسم المشتري
		SellerName.selectByValue("1");
		Thread.sleep(Const);
		
		Select Properties = new Select(driver.findElement(PropertiesA2)); // العقارات
		Properties.selectByValue("1");
		Thread.sleep(Const);

		Select OwnerName = new Select(driver.findElement(ownerName)); //اسم المالك
		OwnerName.selectByValue("1");
		Thread.sleep(Const);
		
		driver.findElement(areatoBeOwnedNum).sendKeys("40"); //المساحة المراد تملكها رقما
		Thread.sleep(Const);
		
		driver.findElement(areatoBeOwned).sendKeys("40"); //المساحة المراد تملكها كتابة
		Thread.sleep(Const);
		
		driver.findElement(numberofProportions).sendKeys("2"); // الحصص المراد تملكها رقما
		Thread.sleep(Const*20);
		driver.findElement(NextToReviewSection).click();
		Thread.sleep(Const*20);
	//---------------------------Review Section ------------------------
		Thread.sleep(Const * 20);
		driver.findElement(submitRequest).click();
		Thread.sleep(Const * 50);

	}
	@Test
	//  المشتري اماراتي الجنسية
	public void Case2200() throws InterruptedException, IOException {
		// -----------------------------Applicant info-----------------------------

		Select ApplicantTypeDDL = new Select(driver.findElement(ApplicantType));
		ApplicantTypeDDL.selectByVisibleText(purchaser); // مشتري
		Thread.sleep(Const * 10);
		// نوع الموافقة
		driver.findElement(InternalRequestApprovalRadio).click();
		Select Purpose = new Select(driver.findElement(PurposeOfPossession)); // الغاية الرئيسية
		Purpose.selectByVisibleText(Residential);
		Thread.sleep(Const * 20);
		Select Purpose2 = new Select(driver.findElement(SecondaryPurposeOfPossession)); // الغاية الفرعية
		Purpose2.selectByVisibleText(Residence);
		
		// Next to Purchaser info
		Thread.sleep(Const);
		driver.findElement(nextToPurchaseInfo).click();

		// ---------------------------Purchaser info------------------------------

		// معلومات المشتري
		driver.findElement(BuyerFields1).sendKeys(buyerInfoContent1);
		driver.findElement(BuyerFields2).sendKeys(buyerInfoContent2);
		driver.findElement(BuyerFields3).sendKeys(buyerInfoContent3);
		driver.findElement(BuyerFields4).sendKeys(buyerInfoContent4);
		Thread.sleep(Const);
		driver.findElement(nameasinPassport).sendKeys(nameasinPassportContent); // الاسم حسب جواز السفر
		Thread.sleep(Const);
		Select NationalityDDL = new Select(driver.findElement(nationality)); // الجنسية
		NationalityDDL.selectByVisibleText(emirates);
		Thread.sleep(Const);
		driver.findElement(phoneNumber).sendKeys(phoneNoContent); // رقم الهاتف
		Select CountryDDL = new Select(driver.findElement(CountryCode)); // الرمز الدولي
		CountryDDL.selectByVisibleText(code1);
		Thread.sleep(Const);
		Select passportTypeDDL = new Select(driver.findElement(passportType)); // نوع جواز السفر
		passportTypeDDL.selectByVisibleText(Permenant);
		Thread.sleep(Const);
		driver.findElement(passportNumber).sendKeys(passportNumberContent); // رقم جواز السفر
		Thread.sleep(Const);
		driver.findElement(productionDate).sendKeys(productionDateContent); // تاريخ الاصدار
		Thread.sleep(Const);
		driver.findElement(ExpiryDate).sendKeys(ExpiryDateContent); // تاريخ الانتهاء
		Thread.sleep(Const * 10);
		driver.findElement(productionLocation).sendKeys(productionLocationContent); // مكان الاصدار
		Thread.sleep(Const);

		Select arrivalCountryDDL = new Select(driver.findElement(arrivalCountry)); // بلد القدوم
		arrivalCountryDDL.selectByVisibleText(AbuDhabi);
		Thread.sleep(Const * 10);

		driver.findElement(placeOfBirth).sendKeys(placeOfBirthContent); // مكان الولادة
		Thread.sleep(Const * 10);
		driver.findElement(birthDate).sendKeys(dateOfBirthContent); // تاريخ الولادة
		Thread.sleep(Const * 10);

		driver.findElement(YesResidency).click(); // -نعم - لديك إقامة بالمملكة
		Thread.sleep(Const * 10);
		driver.findElement(noProperty).click(); // لا - هل لديك عقارات داخل المملكة؟
		Thread.sleep(Const * 10);

		driver.findElement(currentResidenceAddress).sendKeys(currentResidenceAddressContent); // عنوان الإقامة الحالية
		Thread.sleep(Const);

		Select GenderDDL = new Select(driver.findElement(Gender)); // الجنس
		GenderDDL.selectByVisibleText(female); // أنثى
		Thread.sleep(Const * 10);

		Select SocialStatusDDL = new Select(driver.findElement(socialStatus)); // الحالة الاجتماعية
		// SocialStatusDDL.selectByVisibleText(single); //أعزب
		SocialStatusDDL.selectByVisibleText(married); // متزوج

		Thread.sleep(Const * 10);

		driver.findElement(job).sendKeys(JobContent); // عنوان الإقامة الحالية
		Thread.sleep(Const * 10);

		driver.findElement(registrationNo).sendKeys(registrationNoContent); // رقم الدخول
		Thread.sleep(Const);

		driver.findElement(additionalInfo).sendKeys(additionalInfoContent); // معلومات اضافية
		Thread.sleep(Const);

		driver.findElement(noOtherNationality).click();// - لا - جنسية أخرى
		Thread.sleep(Const);

		Select motherNationalityDDL = new Select(driver.findElement(motherNationality)); // جنسية الام
		motherNationalityDDL.selectByVisibleText(Jordanian);
		Thread.sleep(Const);

		driver.findElement(insideKigdom).click();// - نعم - هل المستدعى له داخل المملكة؟
		Thread.sleep(Const);
		// معلومات الام
		driver.findElement(MomFirstName).sendKeys(MomFirstNameContent);
		Thread.sleep(Const);
		driver.findElement(MomSecondName).sendKeys(MomSecondNameContent);
		Thread.sleep(Const);
		driver.findElement(MomThirdName).sendKeys(MomThirdNameContent);
		Thread.sleep(Const);
		driver.findElement(MomLastName).sendKeys(MomLastNameContent);
		   Thread.sleep(Const * 20);

		// ------------------------Purchaser InfoAttachments--------------------

//		driver.findElement(Others).click();
//		Thread.sleep(Const * 20);
//		Runtime.getRuntime().exec(AttachPath);
		driver.findElement(IDCard).click(); //هوية الاحوال الشخصية
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 10);

		Thread.sleep(Const * 10);
		driver.findElement(nextToPrpertyInfoFromPurchaserInfo).click();

		// ---------------------Property & Seller Info ------------------------------
		Thread.sleep(Const * 10);

		driver.findElement(recordNo).sendKeys("1-6BAE1P"); // رقم القيد
		Thread.sleep(Const * 10);
		driver.findElement(DLSKeyButton).click();
		Thread.sleep(Const * 10);
		driver.findElement(schemeNo).sendKeys("1-6BAE1P"); // الرقم المميز للمخطط
		Thread.sleep(Const);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pgl5\"]/div[4]")).click(); // click-anywhere-to-navigate-out
		Thread.sleep(Const);
		driver.findElement(OwnersCheckbox).click();
		
		// ------------------------Property InfoAttachments--------------------

		//driver.findElement(Others2).click();
		//Thread.sleep(Const * 20);
		//Runtime.getRuntime().exec(AttachPath);
		//Thread.sleep(Const * 20);
	
		Thread.sleep(Const * 10);
		driver.findElement(NextToSellerAttach).click();

		//-------------------------Seller's Attachments----------------------

		driver.findElement(IDCardSeller).click();
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 50);
		driver.findElement(NextToLinkPurchaserandSellers).click();

	   //--------------------------Link Purchaser with Seller----------------
		Thread.sleep(Const * 30);

		Select SellerName = new Select(driver.findElement(VendorName)); // اسم المشتري
		SellerName.selectByValue("1");
		Thread.sleep(Const);
		
		Select Properties = new Select(driver.findElement(PropertiesA2)); // العقارات
		Properties.selectByValue("1");
		Thread.sleep(Const);

		Select OwnerName = new Select(driver.findElement(ownerName)); //اسم المالك
		OwnerName.selectByValue("1");
		Thread.sleep(Const);
		
		driver.findElement(areatoBeOwnedNum).sendKeys("40"); //المساحة المراد تملكها رقما
		Thread.sleep(Const);
		
		driver.findElement(areatoBeOwned).sendKeys("40"); //المساحة المراد تملكها كتابة
		Thread.sleep(Const);
		
		driver.findElement(numberofProportions).sendKeys("2"); // الحصص المراد تملكها رقما
		Thread.sleep(Const*20);
		driver.findElement(NextToReviewSection).click();
		Thread.sleep(Const*20);
	//---------------------------Review Section ------------------------
		Thread.sleep(Const * 20);
		driver.findElement(submitRequest).click();
		Thread.sleep(Const * 50);

	}
	@Test
	//    جنسية المشتري لا تسمح له بالتملك
	public void Case2300() throws InterruptedException, IOException {
		// -----------------------------Applicant info-----------------------------

		Select ApplicantTypeDDL = new Select(driver.findElement(ApplicantType));
		ApplicantTypeDDL.selectByVisibleText(purchaser); // مشتري
		Thread.sleep(Const * 10);
		// نوع الموافقة
		driver.findElement(InternalRequestApprovalRadio).click();
		Select Purpose = new Select(driver.findElement(PurposeOfPossession)); // الغاية الرئيسية
		Purpose.selectByVisibleText(Residential);
		Thread.sleep(Const * 20);
		Select Purpose2 = new Select(driver.findElement(SecondaryPurposeOfPossession)); // الغاية الفرعية
		Purpose2.selectByVisibleText(Residence);
		
		// Next to Purchaser info
		Thread.sleep(Const);
		driver.findElement(nextToPurchaseInfo).click();

		// ---------------------------Purchaser info------------------------------

		// معلومات المشتري
		driver.findElement(BuyerFields1).sendKeys(buyerInfoContent1);
		driver.findElement(BuyerFields2).sendKeys(buyerInfoContent2);
		driver.findElement(BuyerFields3).sendKeys(buyerInfoContent3);
		driver.findElement(BuyerFields4).sendKeys(buyerInfoContent4);
		Thread.sleep(Const);
		driver.findElement(nameasinPassport).sendKeys(nameasinPassportContent); // الاسم حسب جواز السفر
		Thread.sleep(Const);
		Select NationalityDDL = new Select(driver.findElement(nationality)); // الجنسية
		NationalityDDL.selectByVisibleText(Israel);
		Thread.sleep(Const);
		driver.findElement(phoneNumber).sendKeys(phoneNoContent); // رقم الهاتف
		Select CountryDDL = new Select(driver.findElement(CountryCode)); // الرمز الدولي
		CountryDDL.selectByVisibleText(code1);
		Thread.sleep(Const);
		Select passportTypeDDL = new Select(driver.findElement(passportType)); // نوع جواز السفر
		passportTypeDDL.selectByVisibleText(Permenant);
		Thread.sleep(Const);
		driver.findElement(passportNumber).sendKeys(passportNumberContent); // رقم جواز السفر
		Thread.sleep(Const);
		driver.findElement(productionDate).sendKeys(productionDateContent); // تاريخ الاصدار
		Thread.sleep(Const);
		driver.findElement(ExpiryDate).sendKeys(ExpiryDateContent); // تاريخ الانتهاء
		Thread.sleep(Const * 10);
		driver.findElement(productionLocation).sendKeys(productionLocationContent); // مكان الاصدار
		Thread.sleep(Const);

		Select arrivalCountryDDL = new Select(driver.findElement(arrivalCountry)); // بلد القدوم
		arrivalCountryDDL.selectByVisibleText(AbuDhabi);
		Thread.sleep(Const * 10);

		driver.findElement(placeOfBirth).sendKeys(placeOfBirthContent); // مكان الولادة
		Thread.sleep(Const * 10);
		driver.findElement(birthDate).sendKeys(dateOfBirthContent); // تاريخ الولادة
		Thread.sleep(Const * 10);

		driver.findElement(NoResidency).click(); // -نعم - لديك إقامة بالمملكة
		Thread.sleep(Const * 10);
		driver.findElement(noProperty).click(); // لا - هل لديك عقارات داخل المملكة؟
		Thread.sleep(Const * 10);

		driver.findElement(currentResidenceAddress).sendKeys(currentResidenceAddressContent); // عنوان الإقامة الحالية
		Thread.sleep(Const);

		Select GenderDDL = new Select(driver.findElement(Gender)); // الجنس
		GenderDDL.selectByVisibleText(female); // أنثى
		Thread.sleep(Const * 10);

		Select SocialStatusDDL = new Select(driver.findElement(socialStatus)); // الحالة الاجتماعية
		// SocialStatusDDL.selectByVisibleText(single); //أعزب
		SocialStatusDDL.selectByVisibleText(married); // متزوج

		Thread.sleep(Const * 10);

		driver.findElement(job).sendKeys(JobContent); // عنوان الإقامة الحالية
		Thread.sleep(Const * 10);

		driver.findElement(registrationNo).sendKeys(registrationNoContent); // رقم الدخول
		Thread.sleep(Const);

		driver.findElement(additionalInfo).sendKeys(additionalInfoContent); // معلومات اضافية
		Thread.sleep(Const);

		driver.findElement(noOtherNationality).click();// - لا - جنسية أخرى
		Thread.sleep(Const);

		Select motherNationalityDDL = new Select(driver.findElement(motherNationality)); // جنسية الام
		motherNationalityDDL.selectByVisibleText(Jordanian);
		Thread.sleep(Const);

		driver.findElement(insideKigdom).click();// - نعم - هل المستدعى له داخل المملكة؟
		Thread.sleep(Const);
		// معلومات الام
		driver.findElement(MomFirstName).sendKeys(MomFirstNameContent);
		Thread.sleep(Const);
		driver.findElement(MomSecondName).sendKeys(MomSecondNameContent);
		Thread.sleep(Const);
		driver.findElement(MomThirdName).sendKeys(MomThirdNameContent);
		Thread.sleep(Const);
		driver.findElement(MomLastName).sendKeys(MomLastNameContent);
		   Thread.sleep(Const * 20);

		// ------------------------Purchaser InfoAttachments--------------------

//		driver.findElement(Others).click();
//		Thread.sleep(Const * 20);
//		Runtime.getRuntime().exec(AttachPath);
		driver.findElement(Passport).click(); //البطاقة الأمنية
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 10);

		Thread.sleep(Const * 10);
		driver.findElement(nextToPrpertyInfoFromPurchaserInfo).click();

	}
	@Test
	//  جنسية المشتري غير عربية و العقار يقع خارج التنظيم     
	public void Case2500() throws InterruptedException, IOException {
		// -----------------------------Applicant info-----------------------------

		Select ApplicantTypeDDL = new Select(driver.findElement(ApplicantType));
		ApplicantTypeDDL.selectByVisibleText(purchaser); // مشتري
		Thread.sleep(Const * 10);
		// نوع الموافقة
		driver.findElement(ExternalRequestApprovalRadio).click(); //خارج التنظيم
		Select Purpose = new Select(driver.findElement(PurposeOfPossession)); // الغاية الرئيسية
		Purpose.selectByVisibleText(Residential);
		Thread.sleep(Const * 20);
		Select Purpose2 = new Select(driver.findElement(SecondaryPurposeOfPossession)); // الغاية الفرعية
		Purpose2.selectByVisibleText(Residence);
		
		// Next to Purchaser info
		Thread.sleep(Const);
		driver.findElement(nextToPurchaseInfo).click();

		// ---------------------------Purchaser info------------------------------

		// معلومات المشتري
		driver.findElement(BuyerFields1).sendKeys(buyerInfoContent1);
		driver.findElement(BuyerFields2).sendKeys(buyerInfoContent2);
		driver.findElement(BuyerFields3).sendKeys(buyerInfoContent3);
		driver.findElement(BuyerFields4).sendKeys(buyerInfoContent4);
		Thread.sleep(Const);
		driver.findElement(nameasinPassport).sendKeys(nameasinPassportContent); // الاسم حسب جواز السفر
		Thread.sleep(Const);
		Select NationalityDDL = new Select(driver.findElement(nationality)); // الجنسية
		NationalityDDL.selectByVisibleText(Turkish);
		Thread.sleep(Const);
		driver.findElement(phoneNumber).sendKeys(phoneNoContent); // رقم الهاتف
		Select CountryDDL = new Select(driver.findElement(CountryCode)); // الرمز الدولي
		CountryDDL.selectByVisibleText(code1);
		Thread.sleep(Const);
		Select passportTypeDDL = new Select(driver.findElement(passportType)); // نوع جواز السفر
		passportTypeDDL.selectByVisibleText(Permenant);
		Thread.sleep(Const);
		driver.findElement(passportNumber).sendKeys(passportNumberContent); // رقم جواز السفر
		Thread.sleep(Const);
		driver.findElement(productionDate).sendKeys(productionDateContent); // تاريخ الاصدار
		Thread.sleep(Const);
		driver.findElement(ExpiryDate).sendKeys(ExpiryDateContent); // تاريخ الانتهاء
		Thread.sleep(Const * 10);
		driver.findElement(productionLocation).sendKeys(productionLocationContent); // مكان الاصدار
		Thread.sleep(Const);

		Select arrivalCountryDDL = new Select(driver.findElement(arrivalCountry)); // بلد القدوم
		arrivalCountryDDL.selectByVisibleText(AbuDhabi);
		Thread.sleep(Const * 10);

		driver.findElement(placeOfBirth).sendKeys(placeOfBirthContent); // مكان الولادة
		Thread.sleep(Const * 10);
		driver.findElement(birthDate).sendKeys(dateOfBirthContent); // تاريخ الولادة
		Thread.sleep(Const * 10);

		driver.findElement(NoResidency).click(); // -نعم - لديك إقامة بالمملكة
		Thread.sleep(Const * 10);
		driver.findElement(noProperty).click(); // لا - هل لديك عقارات داخل المملكة؟
		Thread.sleep(Const * 10);

		driver.findElement(currentResidenceAddress).sendKeys(currentResidenceAddressContent); // عنوان الإقامة الحالية
		Thread.sleep(Const);

		Select GenderDDL = new Select(driver.findElement(Gender)); // الجنس
		GenderDDL.selectByVisibleText(female); // أنثى
		Thread.sleep(Const * 10);

		Select SocialStatusDDL = new Select(driver.findElement(socialStatus)); // الحالة الاجتماعية
		// SocialStatusDDL.selectByVisibleText(single); //أعزب
		SocialStatusDDL.selectByVisibleText(married); // متزوج

		Thread.sleep(Const * 10);

		driver.findElement(job).sendKeys(JobContent); // عنوان الإقامة الحالية
		Thread.sleep(Const * 10);

		driver.findElement(registrationNo).sendKeys(registrationNoContent); // رقم الدخول
		Thread.sleep(Const);

		driver.findElement(additionalInfo).sendKeys(additionalInfoContent); // معلومات اضافية
		Thread.sleep(Const);

		driver.findElement(noOtherNationality).click();// - لا - جنسية أخرى
		Thread.sleep(Const);

		Select motherNationalityDDL = new Select(driver.findElement(motherNationality)); // جنسية الام
		motherNationalityDDL.selectByVisibleText(Jordanian);
		Thread.sleep(Const);

		driver.findElement(insideKigdom).click();// - نعم - هل المستدعى له داخل المملكة؟
		Thread.sleep(Const);
		// معلومات الام
		driver.findElement(MomFirstName).sendKeys(MomFirstNameContent);
		Thread.sleep(Const);
		driver.findElement(MomSecondName).sendKeys(MomSecondNameContent);
		Thread.sleep(Const);
		driver.findElement(MomThirdName).sendKeys(MomThirdNameContent);
		Thread.sleep(Const);
		driver.findElement(MomLastName).sendKeys(MomLastNameContent);
		   Thread.sleep(Const * 20);

		// ------------------------Purchaser InfoAttachments--------------------

//		driver.findElement(Others).click();
//		Thread.sleep(Const * 20);
//		Runtime.getRuntime().exec(AttachPath);
		driver.findElement(Passport).click(); //البطاقة الأمنية
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 10);

		Thread.sleep(Const * 10);
		driver.findElement(nextToPrpertyInfoFromPurchaserInfo).click();

	}
	@Test
	//    جنسية المشتري من الجنسيات التي يتوجب عليها مراجعة الأراضي
	public void Case2400() throws InterruptedException, IOException {
		// -----------------------------Applicant info-----------------------------

		Select ApplicantTypeDDL = new Select(driver.findElement(ApplicantType));
		ApplicantTypeDDL.selectByVisibleText(purchaser); // مشتري
		Thread.sleep(Const * 10);
		// نوع الموافقة
		driver.findElement(InternalRequestApprovalRadio).click();
		Select Purpose = new Select(driver.findElement(PurposeOfPossession)); // الغاية الرئيسية
		Purpose.selectByVisibleText(Residential);
		Thread.sleep(Const * 20);
		Select Purpose2 = new Select(driver.findElement(SecondaryPurposeOfPossession)); // الغاية الفرعية
		Purpose2.selectByVisibleText(Residence);
		
		// Next to Purchaser info
		Thread.sleep(Const);
		driver.findElement(nextToPurchaseInfo).click();

		// ---------------------------Purchaser info------------------------------

		// معلومات المشتري
		driver.findElement(BuyerFields1).sendKeys(buyerInfoContent1);
		driver.findElement(BuyerFields2).sendKeys(buyerInfoContent2);
		driver.findElement(BuyerFields3).sendKeys(buyerInfoContent3);
		driver.findElement(BuyerFields4).sendKeys(buyerInfoContent4);
		Thread.sleep(Const);
		driver.findElement(nameasinPassport).sendKeys(nameasinPassportContent); // الاسم حسب جواز السفر
		Thread.sleep(Const);
		Select NationalityDDL = new Select(driver.findElement(nationality)); // الجنسية
		NationalityDDL.selectByVisibleText(Palestine);
		Thread.sleep(Const);
		driver.findElement(phoneNumber).sendKeys(phoneNoContent); // رقم الهاتف
		Select CountryDDL = new Select(driver.findElement(CountryCode)); // الرمز الدولي
		CountryDDL.selectByVisibleText(code1);
		Thread.sleep(Const);
		Select passportTypeDDL = new Select(driver.findElement(passportType)); // نوع جواز السفر
		passportTypeDDL.selectByVisibleText(Permenant);
		Thread.sleep(Const);
		driver.findElement(passportNumber).sendKeys(passportNumberContent); // رقم جواز السفر
		Thread.sleep(Const);
		driver.findElement(productionDate).sendKeys(productionDateContent); // تاريخ الاصدار
		Thread.sleep(Const);
		driver.findElement(ExpiryDate).sendKeys(ExpiryDateContent); // تاريخ الانتهاء
		Thread.sleep(Const * 10);
		driver.findElement(productionLocation).sendKeys(productionLocationContent); // مكان الاصدار
		Thread.sleep(Const);

		Select arrivalCountryDDL = new Select(driver.findElement(arrivalCountry)); // بلد القدوم
		arrivalCountryDDL.selectByVisibleText(AbuDhabi);
		Thread.sleep(Const * 10);

		driver.findElement(placeOfBirth).sendKeys(placeOfBirthContent); // مكان الولادة
		Thread.sleep(Const * 10);
		driver.findElement(birthDate).sendKeys(dateOfBirthContent); // تاريخ الولادة
		Thread.sleep(Const * 10);

		driver.findElement(NoResidency).click(); // -نعم - لديك إقامة بالمملكة
		Thread.sleep(Const * 10);
		driver.findElement(noProperty).click(); // لا - هل لديك عقارات داخل المملكة؟
		Thread.sleep(Const * 10);

		driver.findElement(currentResidenceAddress).sendKeys(currentResidenceAddressContent); // عنوان الإقامة الحالية
		Thread.sleep(Const);

		Select GenderDDL = new Select(driver.findElement(Gender)); // الجنس
		GenderDDL.selectByVisibleText(female); // أنثى
		Thread.sleep(Const * 10);

		Select SocialStatusDDL = new Select(driver.findElement(socialStatus)); // الحالة الاجتماعية
		// SocialStatusDDL.selectByVisibleText(single); //أعزب
		SocialStatusDDL.selectByVisibleText(married); // متزوج

		Thread.sleep(Const * 10);

		driver.findElement(job).sendKeys(JobContent); // عنوان الإقامة الحالية
		Thread.sleep(Const * 10);

		driver.findElement(registrationNo).sendKeys(registrationNoContent); // رقم الدخول
		Thread.sleep(Const);

		driver.findElement(additionalInfo).sendKeys(additionalInfoContent); // معلومات اضافية
		Thread.sleep(Const);

		driver.findElement(noOtherNationality).click();// - لا - جنسية أخرى
		Thread.sleep(Const);

		Select motherNationalityDDL = new Select(driver.findElement(motherNationality)); // جنسية الام
		motherNationalityDDL.selectByVisibleText(Jordanian);
		Thread.sleep(Const);

		driver.findElement(insideKigdom).click();// - نعم - هل المستدعى له داخل المملكة؟
		Thread.sleep(Const);
		// معلومات الام
		driver.findElement(MomFirstName).sendKeys(MomFirstNameContent);
		Thread.sleep(Const);
		driver.findElement(MomSecondName).sendKeys(MomSecondNameContent);
		Thread.sleep(Const);
		driver.findElement(MomThirdName).sendKeys(MomThirdNameContent);
		Thread.sleep(Const);
		driver.findElement(MomLastName).sendKeys(MomLastNameContent);
		   Thread.sleep(Const * 20);

		// ------------------------Purchaser InfoAttachments--------------------

//		driver.findElement(Others).click();
//		Thread.sleep(Const * 20);
//		Runtime.getRuntime().exec(AttachPath);
		driver.findElement(Passport).click(); //البطاقة الأمنية
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 10);

		Thread.sleep(Const * 10);
		driver.findElement(nextToPrpertyInfoFromPurchaserInfo).click();

	}
	@Test
	//     المشتري لديه جنسيتين أحدهما لا تسمح له بالتملك      
	public void Case2600() throws InterruptedException, IOException {
		// -----------------------------Applicant info-----------------------------

		Select ApplicantTypeDDL = new Select(driver.findElement(ApplicantType));
		ApplicantTypeDDL.selectByVisibleText(purchaser); // مشتري
		Thread.sleep(Const * 10);
		// نوع الموافقة
		driver.findElement(InternalRequestApprovalRadio).click();
		Select Purpose = new Select(driver.findElement(PurposeOfPossession)); // الغاية الرئيسية
		Purpose.selectByVisibleText(Residential);
		Thread.sleep(Const * 20);
		Select Purpose2 = new Select(driver.findElement(SecondaryPurposeOfPossession)); // الغاية الفرعية
		Purpose2.selectByVisibleText(Residence);
		// Next to Purchaser info
		Thread.sleep(Const);
		driver.findElement(nextToPurchaseInfo).click();

		// ---------------------------Purchaser info------------------------------

		// معلومات المشتري
		driver.findElement(BuyerFields1).sendKeys(buyerInfoContent1);
		driver.findElement(BuyerFields2).sendKeys(buyerInfoContent2);
		driver.findElement(BuyerFields3).sendKeys(buyerInfoContent3);
		driver.findElement(BuyerFields4).sendKeys(buyerInfoContent4);
		Thread.sleep(Const);
		driver.findElement(nameasinPassport).sendKeys(nameasinPassportContent); // الاسم حسب جواز السفر
		Thread.sleep(Const);
		Select NationalityDDL = new Select(driver.findElement(nationality)); // الجنسية
		NationalityDDL.selectByVisibleText(Egyptian);
		Thread.sleep(Const);
		driver.findElement(phoneNumber).sendKeys(phoneNoContent); // رقم الهاتف
		Select CountryDDL = new Select(driver.findElement(CountryCode)); // الرمز الدولي
		CountryDDL.selectByVisibleText(code1);
		Thread.sleep(Const);
		Select passportTypeDDL = new Select(driver.findElement(passportType)); // نوع جواز السفر
		passportTypeDDL.selectByVisibleText(Permenant);
		Thread.sleep(Const);
		driver.findElement(passportNumber).sendKeys(passportNumberContent); // رقم جواز السفر
		Thread.sleep(Const);
		driver.findElement(productionDate).sendKeys(productionDateContent); // تاريخ الاصدار
		Thread.sleep(Const);
		driver.findElement(ExpiryDate).sendKeys(ExpiryDateContent); // تاريخ الانتهاء
		Thread.sleep(Const * 10);
		driver.findElement(productionLocation).sendKeys(productionLocationContent); // مكان الاصدار
		Thread.sleep(Const);

		Select arrivalCountryDDL = new Select(driver.findElement(arrivalCountry)); // بلد القدوم
		arrivalCountryDDL.selectByVisibleText(AbuDhabi);
		Thread.sleep(Const * 10);

		driver.findElement(placeOfBirth).sendKeys(placeOfBirthContent); // مكان الولادة
		Thread.sleep(Const * 10);
		driver.findElement(birthDate).sendKeys(dateOfBirthContent); // تاريخ الولادة
		Thread.sleep(Const * 10);

		driver.findElement(NoResidency).click(); // -نعم - لديك إقامة بالمملكة
		Thread.sleep(Const * 10);
		
		driver.findElement(noProperty).click(); // لا - هل لديك عقارات داخل المملكة؟
		Thread.sleep(Const * 10); 

		driver.findElement(currentResidenceAddress).sendKeys(currentResidenceAddressContent); // عنوان الإقامة الحالية
		Thread.sleep(Const);

		Select GenderDDL = new Select(driver.findElement(Gender)); // الجنس
		GenderDDL.selectByVisibleText(female); // أنثى
		Thread.sleep(Const * 10);

		Select SocialStatusDDL = new Select(driver.findElement(socialStatus)); // الحالة الاجتماعية
		// SocialStatusDDL.selectByVisibleText(single); //أعزب
		SocialStatusDDL.selectByVisibleText(married); // متزوج

		Thread.sleep(Const * 10);

		driver.findElement(job).sendKeys(JobContent); // عنوان الإقامة الحالية
		Thread.sleep(Const * 10);

		driver.findElement(registrationNo).sendKeys(registrationNoContent); // رقم الدخول
		Thread.sleep(Const);

		driver.findElement(additionalInfo).sendKeys(additionalInfoContent); // معلومات اضافية
		Thread.sleep(Const);

		driver.findElement(yesOtherNationality).click();// - نعم - جنسية أخرى
		Thread.sleep(Const);
		
		Select othernationality = new Select(driver.findElement(Othernationality)); //  جنسية
		othernationality.selectByVisibleText(Israel);
		Thread.sleep(Const * 20);
		
		Select motherNationalityDDL = new Select(driver.findElement(motherNationality)); // جنسية الام
		motherNationalityDDL.selectByVisibleText(Jordanian);
		Thread.sleep(Const);

		driver.findElement(insideKigdom).click();// - نعم - هل المستدعى له داخل المملكة؟
		Thread.sleep(Const);
		// معلومات الام
		driver.findElement(MomFirstName).sendKeys(MomFirstNameContent);
		Thread.sleep(Const);
		driver.findElement(MomSecondName).sendKeys(MomSecondNameContent);
		Thread.sleep(Const);
		driver.findElement(MomThirdName).sendKeys(MomThirdNameContent);
		Thread.sleep(Const);
		driver.findElement(MomLastName).sendKeys(MomLastNameContent);
		   Thread.sleep(Const * 20);

		// ------------------------Purchaser InfoAttachments--------------------

//		driver.findElement(Others).click();
//		Thread.sleep(Const * 20);
//		Runtime.getRuntime().exec(AttachPath);
		driver.findElement(Passport).click(); //البطاقة الأمنية
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 10);
		Thread.sleep(Const * 10);
		driver.findElement(nextToPrpertyInfoFromPurchaserInfo).click();

	}
	@Test
	//    البائع غير أردني الجنسية - مدة الحجز منتهية      
	public void Case3000() throws InterruptedException, IOException {
		// -----------------------------Applicant info-----------------------------

		Select ApplicantTypeDDL = new Select(driver.findElement(ApplicantType));
		ApplicantTypeDDL.selectByVisibleText(purchaser); // مشتري
		Thread.sleep(Const * 10);
		// نوع الموافقة
		driver.findElement(InternalRequestApprovalRadio).click();
		Select Purpose = new Select(driver.findElement(PurposeOfPossession)); // الغاية الرئيسية
		Purpose.selectByVisibleText(Residential);
		Thread.sleep(Const * 20);
		Select Purpose2 = new Select(driver.findElement(SecondaryPurposeOfPossession)); // الغاية الفرعية
		Purpose2.selectByVisibleText(Residence);
		// Next to Purchaser info
		Thread.sleep(Const);
		driver.findElement(nextToPurchaseInfo).click();

		// ---------------------------Purchaser info------------------------------

		// معلومات المشتري
		driver.findElement(BuyerFields1).sendKeys(buyerInfoContent1);
		driver.findElement(BuyerFields2).sendKeys(buyerInfoContent2);
		driver.findElement(BuyerFields3).sendKeys(buyerInfoContent3);
		driver.findElement(BuyerFields4).sendKeys(buyerInfoContent4);
		Thread.sleep(Const);
		driver.findElement(nameasinPassport).sendKeys(nameasinPassportContent); // الاسم حسب جواز السفر
		Thread.sleep(Const);
		Select NationalityDDL = new Select(driver.findElement(nationality)); // الجنسية
		NationalityDDL.selectByVisibleText(Egyptian);
		Thread.sleep(Const);
		driver.findElement(phoneNumber).sendKeys(phoneNoContent); // رقم الهاتف
		Select CountryDDL = new Select(driver.findElement(CountryCode)); // الرمز الدولي
		CountryDDL.selectByVisibleText(code1);
		Thread.sleep(Const);
		Select passportTypeDDL = new Select(driver.findElement(passportType)); // نوع جواز السفر
		passportTypeDDL.selectByVisibleText(Permenant);
		Thread.sleep(Const);
		driver.findElement(passportNumber).sendKeys(passportNumberContent); // رقم جواز السفر
		Thread.sleep(Const);
		driver.findElement(productionDate).sendKeys(productionDateContent); // تاريخ الاصدار
		Thread.sleep(Const);
		driver.findElement(ExpiryDate).sendKeys(ExpiryDateContent); // تاريخ الانتهاء
		Thread.sleep(Const * 10);
		driver.findElement(productionLocation).sendKeys(productionLocationContent); // مكان الاصدار
		Thread.sleep(Const);

		Select arrivalCountryDDL = new Select(driver.findElement(arrivalCountry)); // بلد القدوم
		arrivalCountryDDL.selectByVisibleText(AbuDhabi);
		Thread.sleep(Const * 10);

		driver.findElement(placeOfBirth).sendKeys(placeOfBirthContent); // مكان الولادة
		Thread.sleep(Const * 10);
		driver.findElement(birthDate).sendKeys(dateOfBirthContent); // تاريخ الولادة
		Thread.sleep(Const * 10);

		driver.findElement(NoResidency).click(); // -نعم - لديك إقامة بالمملكة
		Thread.sleep(Const * 10);
		
		driver.findElement(noProperty).click(); // لا - هل لديك عقارات داخل المملكة؟
		Thread.sleep(Const * 10); 

		driver.findElement(currentResidenceAddress).sendKeys(currentResidenceAddressContent); // عنوان الإقامة الحالية
		Thread.sleep(Const);

		Select GenderDDL = new Select(driver.findElement(Gender)); // الجنس
		GenderDDL.selectByVisibleText(female); // أنثى
		Thread.sleep(Const * 10);

		Select SocialStatusDDL = new Select(driver.findElement(socialStatus)); // الحالة الاجتماعية
		Thread.sleep(Const);
		SocialStatusDDL.selectByVisibleText(single); //أعزب
		//SocialStatusDDL.selectByVisibleText(married); // متزوج

		Thread.sleep(Const * 10);

		driver.findElement(job).sendKeys(JobContent); // عنوان الإقامة الحالية
		Thread.sleep(Const * 10);

		driver.findElement(registrationNo).sendKeys(registrationNoContent); // رقم الدخول
		Thread.sleep(Const);

		driver.findElement(additionalInfo).sendKeys(additionalInfoContent); // معلومات اضافية
		Thread.sleep(Const);

		driver.findElement(noOtherNationality).click();// - لا - جنسية أخرى
		Thread.sleep(Const);
		

		Select motherNationalityDDL = new Select(driver.findElement(motherNationality)); // جنسية الام
		motherNationalityDDL.selectByVisibleText(Jordanian);
		Thread.sleep(Const);

		driver.findElement(insideKigdom).click();// - نعم - هل المستدعى له داخل المملكة؟
		Thread.sleep(Const);
		// معلومات الام
		driver.findElement(MomFirstName).sendKeys(MomFirstNameContent);
		Thread.sleep(Const);
		driver.findElement(MomSecondName).sendKeys(MomSecondNameContent);
		Thread.sleep(Const);
		driver.findElement(MomThirdName).sendKeys(MomThirdNameContent);
		Thread.sleep(Const);
		driver.findElement(MomLastName).sendKeys(MomLastNameContent);
		   Thread.sleep(Const * 20);

		// ------------------------Purchaser InfoAttachments--------------------

//		driver.findElement(Others).click();
//		Thread.sleep(Const * 20);
//		Runtime.getRuntime().exec(AttachPath);
		driver.findElement(Passport).click(); //جواز السفر 
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 10);
		Thread.sleep(Const * 10);
		driver.findElement(nextToPrpertyInfoFromPurchaserInfo).click();
		// ---------------------Property & Seller Info ------------------------------
				Thread.sleep(Const * 10);

				driver.findElement(recordNo).sendKeys("1234567"); // رقم القيد
				Thread.sleep(Const * 10);
				driver.findElement(DLSKeyButton).click();
				Thread.sleep(Const * 10);
				driver.findElement(schemeNo).sendKeys("1234567"); // الرقم المميز للمخطط
				Thread.sleep(Const*10);
				//navigateOut
				driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pgl5\"]/div[4]")).click();
				Thread.sleep(Const*20);
                //Seller's checkBox
				driver.findElement(By.id("pt1:r1:1:pc2:t5:0:sbc2::content")).click();
				// ------------------------Property InfoAttachments--------------------
				Thread.sleep(Const * 10);
				driver.findElement(NextToSellerAttach).click();
				//-------------------------Seller's Attachments---------------------
				driver.findElement(PassportSeller).click();
				Thread.sleep(Const * 20);
				Runtime.getRuntime().exec(AttachPath);
				Thread.sleep(Const * 50);
				driver.findElement(NextToLinkPurchaserandSellers).click();
			   //--------------------------Link Purchaser with Seller----------------
				Thread.sleep(Const * 40);
				Select SellerName = new Select(driver.findElement(VendorName)); // اسم المشتري
				SellerName.selectByValue("1");
				Thread.sleep(Const);
				
				Select Properties = new Select(driver.findElement(PropertiesA2)); // العقارات
				Properties.selectByValue("1");
				Thread.sleep(Const);

				Select OwnerName = new Select(driver.findElement(ownerName)); //اسم المالك
				OwnerName.selectByValue("1");
				Thread.sleep(Const);
				
				driver.findElement(areatoBeOwnedNum).sendKeys("40"); //المساحة المراد تملكها رقما
				Thread.sleep(Const);
				
				driver.findElement(areatoBeOwned).sendKeys("40"); //المساحة المراد تملكها كتابة
				Thread.sleep(Const);
				
				driver.findElement(numberofProportions).sendKeys("2"); // الحصص المراد تملكها رقما
				Thread.sleep(Const*20);
				driver.findElement(NextToReviewSection).click();
				Thread.sleep(Const*20);
			//---------------------------Review Section ------------------------
				Thread.sleep(Const * 20);
				driver.findElement(submitRequest).click();
				Thread.sleep(Const * 50);
	}	
	@Test
	//   وجود موافقة البيع -البائع غير أردني الجنسية - مدة الحجز غير منتهية      
	public void Case3100() throws InterruptedException, IOException {
		// -----------------------------Applicant info-----------------------------

		Select ApplicantTypeDDL = new Select(driver.findElement(ApplicantType));
		ApplicantTypeDDL.selectByVisibleText(purchaser); // مشتري
		Thread.sleep(Const * 10);
		// نوع الموافقة
		driver.findElement(InternalRequestApprovalRadio).click();
		Select Purpose = new Select(driver.findElement(PurposeOfPossession)); // الغاية الرئيسية
		Purpose.selectByVisibleText(Residential);
		Thread.sleep(Const * 20);
		Select Purpose2 = new Select(driver.findElement(SecondaryPurposeOfPossession)); // الغاية الفرعية
		Purpose2.selectByVisibleText(Residence);
		// Next to Purchaser info
		Thread.sleep(Const);
		driver.findElement(nextToPurchaseInfo).click();

		// ---------------------------Purchaser info------------------------------

		// معلومات المشتري
		driver.findElement(BuyerFields1).sendKeys(buyerInfoContent1);
		driver.findElement(BuyerFields2).sendKeys(buyerInfoContent2);
		driver.findElement(BuyerFields3).sendKeys(buyerInfoContent3);
		driver.findElement(BuyerFields4).sendKeys(buyerInfoContent4);
		Thread.sleep(Const);
		driver.findElement(nameasinPassport).sendKeys(nameasinPassportContent); // الاسم حسب جواز السفر
		Thread.sleep(Const);
		Select NationalityDDL = new Select(driver.findElement(nationality)); // الجنسية
		NationalityDDL.selectByVisibleText(Egyptian);
		Thread.sleep(Const);
		driver.findElement(phoneNumber).sendKeys(phoneNoContent); // رقم الهاتف
		Select CountryDDL = new Select(driver.findElement(CountryCode)); // الرمز الدولي
		CountryDDL.selectByVisibleText(code1);
		Thread.sleep(Const);
		Select passportTypeDDL = new Select(driver.findElement(passportType)); // نوع جواز السفر
		passportTypeDDL.selectByVisibleText(Permenant);
		Thread.sleep(Const);
		driver.findElement(passportNumber).sendKeys(passportNumberContent); // رقم جواز السفر
		Thread.sleep(Const);
		driver.findElement(productionDate).sendKeys(productionDateContent); // تاريخ الاصدار
		Thread.sleep(Const);
		driver.findElement(ExpiryDate).sendKeys(ExpiryDateContent); // تاريخ الانتهاء
		Thread.sleep(Const * 10);
		driver.findElement(productionLocation).sendKeys(productionLocationContent); // مكان الاصدار
		Thread.sleep(Const);

		Select arrivalCountryDDL = new Select(driver.findElement(arrivalCountry)); // بلد القدوم
		arrivalCountryDDL.selectByVisibleText(AbuDhabi);
		Thread.sleep(Const * 10);

		driver.findElement(placeOfBirth).sendKeys(placeOfBirthContent); // مكان الولادة
		Thread.sleep(Const * 10);
		driver.findElement(birthDate).sendKeys(dateOfBirthContent); // تاريخ الولادة
		Thread.sleep(Const * 10);

		driver.findElement(NoResidency).click(); // -نعم - لديك إقامة بالمملكة
		Thread.sleep(Const * 10);
		
		driver.findElement(noProperty).click(); // لا - هل لديك عقارات داخل المملكة؟
		Thread.sleep(Const * 10); 

		driver.findElement(currentResidenceAddress).sendKeys(currentResidenceAddressContent); // عنوان الإقامة الحالية
		Thread.sleep(Const);

		Select GenderDDL = new Select(driver.findElement(Gender)); // الجنس
		GenderDDL.selectByVisibleText(female); // أنثى
		Thread.sleep(Const * 10);

		Select SocialStatusDDL = new Select(driver.findElement(socialStatus)); // الحالة الاجتماعية
		Thread.sleep(Const);
		SocialStatusDDL.selectByVisibleText(single); //أعزب
		//SocialStatusDDL.selectByVisibleText(married); // متزوج

		Thread.sleep(Const * 10);

		driver.findElement(job).sendKeys(JobContent); // عنوان الإقامة الحالية
		Thread.sleep(Const * 10);

		driver.findElement(registrationNo).sendKeys(registrationNoContent); // رقم الدخول
		Thread.sleep(Const);

		driver.findElement(additionalInfo).sendKeys(additionalInfoContent); // معلومات اضافية
		Thread.sleep(Const);

		driver.findElement(noOtherNationality).click();// - لا - جنسية أخرى
		Thread.sleep(Const);
		

		Select motherNationalityDDL = new Select(driver.findElement(motherNationality)); // جنسية الام
		motherNationalityDDL.selectByVisibleText(Jordanian);
		Thread.sleep(Const);

		driver.findElement(insideKigdom).click();// - نعم - هل المستدعى له داخل المملكة؟
		Thread.sleep(Const);
		// معلومات الام
		driver.findElement(MomFirstName).sendKeys(MomFirstNameContent);
		Thread.sleep(Const);
		driver.findElement(MomSecondName).sendKeys(MomSecondNameContent);
		Thread.sleep(Const);
		driver.findElement(MomThirdName).sendKeys(MomThirdNameContent);
		Thread.sleep(Const);
		driver.findElement(MomLastName).sendKeys(MomLastNameContent);
		   Thread.sleep(Const * 20);

		// ------------------------Purchaser InfoAttachments--------------------

//		driver.findElement(Others).click();
//		Thread.sleep(Const * 20);
//		Runtime.getRuntime().exec(AttachPath);
		driver.findElement(Passport).click(); //جواز السفر 
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 10);
		Thread.sleep(Const * 10);
		driver.findElement(nextToPrpertyInfoFromPurchaserInfo).click();
		// ---------------------Property & Seller Info ------------------------------
				Thread.sleep(Const * 10);

				driver.findElement(recordNo).sendKeys("1234558"); // رقم القيد
				Thread.sleep(Const * 10);
				driver.findElement(DLSKeyButton).click();
				Thread.sleep(Const * 10);
				driver.findElement(schemeNo).sendKeys("1234558"); // الرقم المميز للمخطط
				Thread.sleep(Const);
				//navigateOut
				driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pgl5\"]/div[4]")).click(); // click-anywhere-to-navigate-out
				Thread.sleep(Const*10);			
				driver.findElement(By.id("pt1:r1:1:pc2:t5:0:sbc2::content")).click();

				// ------------------------Property InfoAttachments--------------------

//				driver.findElement(Others2).click();
//				Thread.sleep(Const * 20);
//				Runtime.getRuntime().exec(AttachPath);
//				Thread.sleep(Const * 20);
				
				Thread.sleep(Const * 10);
				driver.findElement(NextToSellerAttach).click();
				//-------------------------Seller's Attachments----------------------

				driver.findElement(PassportSeller).click();
				Thread.sleep(Const * 20);
				Runtime.getRuntime().exec(AttachPath);
				Thread.sleep(Const * 50);
				driver.findElement(NextToLinkPurchaserandSellers).click();

			   //--------------------------Link Purchaser with Seller----------------
				Thread.sleep(Const * 30);

				Select SellerName = new Select(driver.findElement(VendorName)); // اسم المشتري
				SellerName.selectByValue("1");
				Thread.sleep(Const);
				
				Select Properties = new Select(driver.findElement(PropertiesA2)); // العقارات
				Properties.selectByValue("1");
				Thread.sleep(Const);

				Select OwnerName = new Select(driver.findElement(ownerName)); //اسم المالك
				OwnerName.selectByValue("1");
				Thread.sleep(Const);
				
				driver.findElement(areatoBeOwnedNum).sendKeys("40"); //المساحة المراد تملكها رقما
				Thread.sleep(Const);
				
				driver.findElement(areatoBeOwned).sendKeys("40"); //المساحة المراد تملكها كتابة
				Thread.sleep(Const);
				
				driver.findElement(numberofProportions).sendKeys("2"); // الحصص المراد تملكها رقما
				Thread.sleep(Const*20);
				driver.findElement(NextToReviewSection).click();
				Thread.sleep(Const*20);
			//---------------------------Review Section ------------------------
				Thread.sleep(Const * 20);
				driver.findElement(submitRequest).click();
				Thread.sleep(Const * 50);
	}	
	@Test
	//    البائع غير أردني الجنسية - مدة الحجز غير منتهية -عدم وجود الموافقة

	public void Case3200() throws InterruptedException, IOException {
		// -----------------------------Applicant info-----------------------------

		Select ApplicantTypeDDL = new Select(driver.findElement(ApplicantType));
		ApplicantTypeDDL.selectByVisibleText(purchaser); // مشتري
		Thread.sleep(Const * 10);
		// نوع الموافقة
		driver.findElement(InternalRequestApprovalRadio).click();
		Select Purpose = new Select(driver.findElement(PurposeOfPossession)); // الغاية الرئيسية
		Purpose.selectByVisibleText(Residential);
		Thread.sleep(Const * 20);
		Select Purpose2 = new Select(driver.findElement(SecondaryPurposeOfPossession)); // الغاية الفرعية
		Purpose2.selectByVisibleText(Residence);
		// Next to Purchaser info
		Thread.sleep(Const);
		driver.findElement(nextToPurchaseInfo).click();

		// ---------------------------Purchaser info------------------------------

		// معلومات المشتري
		driver.findElement(BuyerFields1).sendKeys(buyerInfoContent1);
		driver.findElement(BuyerFields2).sendKeys(buyerInfoContent2);
		driver.findElement(BuyerFields3).sendKeys(buyerInfoContent3);
		driver.findElement(BuyerFields4).sendKeys(buyerInfoContent4);
		Thread.sleep(Const);
		driver.findElement(nameasinPassport).sendKeys(nameasinPassportContent); // الاسم حسب جواز السفر
		Thread.sleep(Const);
		Select NationalityDDL = new Select(driver.findElement(nationality)); // الجنسية
		NationalityDDL.selectByVisibleText(Egyptian);
		Thread.sleep(Const);
		driver.findElement(phoneNumber).sendKeys(phoneNoContent); // رقم الهاتف
		Select CountryDDL = new Select(driver.findElement(CountryCode)); // الرمز الدولي
		CountryDDL.selectByVisibleText(code1);
		Thread.sleep(Const);
		Select passportTypeDDL = new Select(driver.findElement(passportType)); // نوع جواز السفر
		passportTypeDDL.selectByVisibleText(Permenant);
		Thread.sleep(Const);
		driver.findElement(passportNumber).sendKeys(passportNumberContent); // رقم جواز السفر
		Thread.sleep(Const);
		driver.findElement(productionDate).sendKeys(productionDateContent); // تاريخ الاصدار
		Thread.sleep(Const);
		driver.findElement(ExpiryDate).sendKeys(ExpiryDateContent); // تاريخ الانتهاء
		Thread.sleep(Const * 10);
		driver.findElement(productionLocation).sendKeys(productionLocationContent); // مكان الاصدار
		Thread.sleep(Const);

		Select arrivalCountryDDL = new Select(driver.findElement(arrivalCountry)); // بلد القدوم
		arrivalCountryDDL.selectByVisibleText(AbuDhabi);
		Thread.sleep(Const * 10);

		driver.findElement(placeOfBirth).sendKeys(placeOfBirthContent); // مكان الولادة
		Thread.sleep(Const * 10);
		driver.findElement(birthDate).sendKeys(dateOfBirthContent); // تاريخ الولادة
		Thread.sleep(Const * 10);

		driver.findElement(NoResidency).click(); // -نعم - لديك إقامة بالمملكة
		Thread.sleep(Const * 10);
		
		driver.findElement(noProperty).click(); // لا - هل لديك عقارات داخل المملكة؟
		Thread.sleep(Const * 10); 

		driver.findElement(currentResidenceAddress).sendKeys(currentResidenceAddressContent); // عنوان الإقامة الحالية
		Thread.sleep(Const);

		Select GenderDDL = new Select(driver.findElement(Gender)); // الجنس
		GenderDDL.selectByVisibleText(female); // أنثى
		Thread.sleep(Const * 10);

		Select SocialStatusDDL = new Select(driver.findElement(socialStatus)); // الحالة الاجتماعية
		SocialStatusDDL.selectByVisibleText(single); //أعزب
		//SocialStatusDDL.selectByVisibleText(married); // متزوج

		Thread.sleep(Const * 10);

		driver.findElement(job).sendKeys(JobContent); // عنوان الإقامة الحالية
		Thread.sleep(Const * 10);

		driver.findElement(registrationNo).sendKeys(registrationNoContent); // رقم الدخول
		Thread.sleep(Const);

		driver.findElement(additionalInfo).sendKeys(additionalInfoContent); // معلومات اضافية
		Thread.sleep(Const);

		driver.findElement(noOtherNationality).click();// - لا - جنسية أخرى
		Thread.sleep(Const);
		

		Select motherNationalityDDL = new Select(driver.findElement(motherNationality)); // جنسية الام
		motherNationalityDDL.selectByVisibleText(Jordanian);
		Thread.sleep(Const);

		driver.findElement(insideKigdom).click();// - نعم - هل المستدعى له داخل المملكة؟
		Thread.sleep(Const);
		// معلومات الام
		driver.findElement(MomFirstName).sendKeys(MomFirstNameContent);
		Thread.sleep(Const);
		driver.findElement(MomSecondName).sendKeys(MomSecondNameContent);
		Thread.sleep(Const);
		driver.findElement(MomThirdName).sendKeys(MomThirdNameContent);
		Thread.sleep(Const);
		driver.findElement(MomLastName).sendKeys(MomLastNameContent);
		   Thread.sleep(Const * 20);

		// ------------------------Purchaser InfoAttachments--------------------


		driver.findElement(Passport).click(); //جواز السفر 
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 10);
		Thread.sleep(Const * 10);
		driver.findElement(nextToPrpertyInfoFromPurchaserInfo).click();
		// ---------------------Property & Seller Info ------------------------------
				Thread.sleep(Const * 10);
				driver.findElement(recordNo).sendKeys("1234557"); // رقم القيد
				Thread.sleep(Const * 10);
				driver.findElement(DLSKeyButton).click();
				Thread.sleep(Const * 10);
				driver.findElement(schemeNo).sendKeys("1234557"); // الرقم المميز للمخطط
				Thread.sleep(Const);
				driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pgl5\"]/div[4]")).click(); // click-anywhere-to-navigate-out
				Thread.sleep(Const*10);
				driver.findElement(By.id("pt1:r1:1:pc2:t5:8:sbc2::content")).click();
				// ------------------------Property InfoAttachments--------------------
				Thread.sleep(Const * 10);
				driver.findElement(NextToSellerAttach).click();
				//-------------------------Seller's Attachments----------------------
				driver.findElement(PassportSeller).click();
				Thread.sleep(Const * 20);
				Runtime.getRuntime().exec(AttachPath);
				Thread.sleep(Const * 50);
				driver.findElement(NextToLinkPurchaserandSellers).click();
				
				   //--------------------------Link Purchaser with Seller----------------
				Thread.sleep(Const * 40);
				Select SellerName = new Select(driver.findElement(VendorName)); // اسم المشتري
				SellerName.selectByValue("0");
				Thread.sleep(Const);
				Select Properties = new Select(driver.findElement(PropertiesA2)); // العقارات
				Properties.selectByValue("0");
				Thread.sleep(Const);
				Select OwnerName = new Select(driver.findElement(ownerName)); //اسم المالك
				OwnerName.selectByValue("0");
				Thread.sleep(Const);
				driver.findElement(areatoBeOwnedNum).sendKeys("40"); //المساحة المراد تملكها رقما
				Thread.sleep(Const);
				driver.findElement(areatoBeOwned).sendKeys("40"); //المساحة المراد تملكها كتابة
				Thread.sleep(Const);
				driver.findElement(numberofProportions).sendKeys("2"); // الحصص المراد تملكها رقما
				Thread.sleep(Const*20);
				driver.findElement(NextToReviewSection).click();
				Thread.sleep(Const*20);
				//------------Assert----------
				
				Thread.sleep(Const * 20);
				String ActualResult = driver.findElement(By.xpath("//*[@id=\"pt1:r1:5:m1\"]/div/table/tbody/tr/td/table/tbody/tr/td[2]/div")).getText();
				String ExpectedResult = "البائع أجنبي وبحاجة لموافقة بيع";
				Assert.assertTrue(ActualResult.contains(ExpectedResult));
                System.out.print("Actual" + ActualResult);
                System.out.print("Expected" + ExpectedResult);               
				// capture-screenshot
				TakesScreenshot ts = (TakesScreenshot) driver;
				File source = ts.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(source, new File(".Screenshots/Case3.2.0.0.png"));	
				
	}	
	@Test
	//    البائع شركة - مدة الحجز منتهية
	public void Case3300() throws InterruptedException, IOException {
		// -----------------------------Applicant info-----------------------------
		Select ApplicantTypeDDL = new Select(driver.findElement(ApplicantType));
		ApplicantTypeDDL.selectByVisibleText(purchaser); // مشتري
		Thread.sleep(Const * 10);
		// نوع الموافقة
		driver.findElement(InternalRequestApprovalRadio).click();
		Select Purpose = new Select(driver.findElement(PurposeOfPossession)); // الغاية الرئيسية
		Purpose.selectByVisibleText(Residential);
		Thread.sleep(Const * 20);
		Select Purpose2 = new Select(driver.findElement(SecondaryPurposeOfPossession)); // الغاية الفرعية
		Purpose2.selectByVisibleText(Residence);
		// Next to Purchaser info
		Thread.sleep(Const);
		driver.findElement(nextToPurchaseInfo).click();
		// ---------------------------Purchaser info------------------------------
		// معلومات المشتري
		driver.findElement(BuyerFields1).sendKeys(buyerInfoContent1);
		driver.findElement(BuyerFields2).sendKeys(buyerInfoContent2);
		driver.findElement(BuyerFields3).sendKeys(buyerInfoContent3);
		driver.findElement(BuyerFields4).sendKeys(buyerInfoContent4);
		Thread.sleep(Const);
		driver.findElement(nameasinPassport).sendKeys(nameasinPassportContent); // الاسم حسب جواز السفر
		Thread.sleep(Const);
		Select NationalityDDL = new Select(driver.findElement(nationality)); // الجنسية
		NationalityDDL.selectByVisibleText(Egyptian);
		Thread.sleep(Const);
		driver.findElement(phoneNumber).sendKeys(phoneNoContent); // رقم الهاتف
		Select CountryDDL = new Select(driver.findElement(CountryCode)); // الرمز الدولي
		CountryDDL.selectByVisibleText(code1);
		Thread.sleep(Const);
		Select passportTypeDDL = new Select(driver.findElement(passportType)); // نوع جواز السفر
		passportTypeDDL.selectByVisibleText(Permenant);
		Thread.sleep(Const);
		driver.findElement(passportNumber).sendKeys(passportNumberContent); // رقم جواز السفر
		Thread.sleep(Const);
		driver.findElement(productionDate).sendKeys(productionDateContent); // تاريخ الاصدار
		Thread.sleep(Const);
		driver.findElement(ExpiryDate).sendKeys(ExpiryDateContent); // تاريخ الانتهاء
		Thread.sleep(Const * 10);
		driver.findElement(productionLocation).sendKeys(productionLocationContent); // مكان الاصدار
		Thread.sleep(Const);
		Select arrivalCountryDDL = new Select(driver.findElement(arrivalCountry)); // بلد القدوم
		arrivalCountryDDL.selectByVisibleText(AbuDhabi);
		Thread.sleep(Const * 10);
		driver.findElement(placeOfBirth).sendKeys(placeOfBirthContent); // مكان الولادة
		Thread.sleep(Const * 10);
		driver.findElement(birthDate).sendKeys(dateOfBirthContent); // تاريخ الولادة
		Thread.sleep(Const * 10);
		driver.findElement(NoResidency).click(); // -نعم - لديك إقامة بالمملكة
		Thread.sleep(Const * 10);
		driver.findElement(noProperty).click(); // لا - هل لديك عقارات داخل المملكة؟
		Thread.sleep(Const * 10); 
		driver.findElement(currentResidenceAddress).sendKeys(currentResidenceAddressContent); // عنوان الإقامة الحالية
		Thread.sleep(Const);
		Select GenderDDL = new Select(driver.findElement(Gender)); // الجنس
		GenderDDL.selectByVisibleText(female); // أنثى
		Thread.sleep(Const * 10);
		Select SocialStatusDDL = new Select(driver.findElement(socialStatus)); // الحالة الاجتماعية
		SocialStatusDDL.selectByVisibleText(single); //أعزب
		//SocialStatusDDL.selectByVisibleText(married); // متزوج
		Thread.sleep(Const * 10);
		driver.findElement(job).sendKeys(JobContent); // عنوان الإقامة الحالية
		Thread.sleep(Const * 10);
		driver.findElement(registrationNo).sendKeys(registrationNoContent); // رقم الدخول
		Thread.sleep(Const);

		driver.findElement(additionalInfo).sendKeys(additionalInfoContent); // معلومات اضافية
		Thread.sleep(Const);

		driver.findElement(noOtherNationality).click();// - لا - جنسية أخرى
		Thread.sleep(Const);
		Select motherNationalityDDL = new Select(driver.findElement(motherNationality)); // جنسية الام
		motherNationalityDDL.selectByVisibleText(Jordanian);
		Thread.sleep(Const);
		driver.findElement(insideKigdom).click();// - نعم - هل المستدعى له داخل المملكة؟
		Thread.sleep(Const);
		// معلومات الام
		driver.findElement(MomFirstName).sendKeys(MomFirstNameContent);
		Thread.sleep(Const);
		driver.findElement(MomSecondName).sendKeys(MomSecondNameContent);
		Thread.sleep(Const);
		driver.findElement(MomThirdName).sendKeys(MomThirdNameContent);
		Thread.sleep(Const);
		driver.findElement(MomLastName).sendKeys(MomLastNameContent);
		Thread.sleep(Const * 20);

		// ------------------------Purchaser InfoAttachments--------------------
		driver.findElement(Passport).click(); //جواز السفر 
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 10);
		Thread.sleep(Const * 10);
		driver.findElement(nextToPrpertyInfoFromPurchaserInfo).click();
		// ---------------------Property & Seller Info ------------------------------
				Thread.sleep(Const * 10);
				driver.findElement(recordNo).sendKeys("1234556"); // رقم القيد
				Thread.sleep(Const * 10);
				driver.findElement(DLSKeyButton).click();
				Thread.sleep(Const * 10);
				driver.findElement(schemeNo).sendKeys("1234556"); // الرقم المميز للمخطط
				Thread.sleep(Const);
				driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pgl5\"]/div[4]")).click(); // click-anywhere-to-navigate-out
				Thread.sleep(Const*20);
				driver.findElement(By.id("pt1:r1:1:pc2:t5:0:sbc2::content")).click();
				// ------------------------Property InfoAttachments--------------------
				driver.findElement(OrganizationalChart).click(); //   مخطط موقع تنظيمي
				Thread.sleep(Const * 20);
				Runtime.getRuntime().exec(AttachPath);
				Thread.sleep(Const * 10);
				driver.findElement(NextToSellerAttach).click();
				//-------------------------Seller's Attachments----------------------
				driver.findElement(CoCommercialRecord).click();
				Thread.sleep(Const * 20);
				Runtime.getRuntime().exec(AttachPath);
				Thread.sleep(Const * 50);
				driver.findElement(NextToLinkPurchaserandSellers).click();
			   //--------------------------Link Purchaser with Seller----------------
				Thread.sleep(Const * 30);

				Select SellerName = new Select(driver.findElement(VendorName)); // اسم المشتري
				SellerName.selectByValue("1");
				Thread.sleep(Const);
				
				Select Properties = new Select(driver.findElement(PropertiesA2)); // العقارات
				Properties.selectByValue("1");
				Thread.sleep(Const);

				Select OwnerName = new Select(driver.findElement(ownerName)); //اسم المالك
				OwnerName.selectByValue("1");
				Thread.sleep(Const);
				
				driver.findElement(areatoBeOwnedNum).sendKeys("40"); //المساحة المراد تملكها رقما
				Thread.sleep(Const);
				
				driver.findElement(areatoBeOwned).sendKeys("40"); //المساحة المراد تملكها كتابة
				Thread.sleep(Const);
				
				driver.findElement(numberofProportions).sendKeys("2"); // الحصص المراد تملكها رقما
				Thread.sleep(Const*20);
				driver.findElement(NextToReviewSection).click();
				Thread.sleep(Const*20);
			//---------------------------Review Section ------------------------
				Thread.sleep(Const * 20);
				driver.findElement(submitRequest).click();
				Thread.sleep(Const * 50);
	}
	@Test
	//  - وجود موافقة بيع-   البائع شركة - مدة الحجز غير منتهية
	public void Case3400() throws InterruptedException, IOException {
		// -----------------------------Applicant info-----------------------------

		Select ApplicantTypeDDL = new Select(driver.findElement(ApplicantType));
		ApplicantTypeDDL.selectByVisibleText(purchaser); // مشتري
		Thread.sleep(Const * 10);
		// نوع الموافقة
		driver.findElement(InternalRequestApprovalRadio).click();
		Select Purpose = new Select(driver.findElement(PurposeOfPossession)); // الغاية الرئيسية
		Purpose.selectByVisibleText(Residential);
		Thread.sleep(Const * 20);
		Select Purpose2 = new Select(driver.findElement(SecondaryPurposeOfPossession)); // الغاية الفرعية
		Purpose2.selectByVisibleText(Residence);
		// Next to Purchaser info
		Thread.sleep(Const);
		driver.findElement(nextToPurchaseInfo).click();

		// ---------------------------Purchaser info------------------------------
		// معلومات المشتري
		driver.findElement(BuyerFields1).sendKeys(buyerInfoContent1);
		driver.findElement(BuyerFields2).sendKeys(buyerInfoContent2);
		driver.findElement(BuyerFields3).sendKeys(buyerInfoContent3);
		driver.findElement(BuyerFields4).sendKeys(buyerInfoContent4);
		Thread.sleep(Const);
		driver.findElement(nameasinPassport).sendKeys(nameasinPassportContent); // الاسم حسب جواز السفر
		Thread.sleep(Const);
		Select NationalityDDL = new Select(driver.findElement(nationality)); // الجنسية
		NationalityDDL.selectByVisibleText(Egyptian);
		Thread.sleep(Const);
		driver.findElement(phoneNumber).sendKeys(phoneNoContent); // رقم الهاتف
		Select CountryDDL = new Select(driver.findElement(CountryCode)); // الرمز الدولي
		CountryDDL.selectByVisibleText(code1);
		Thread.sleep(Const);
		Select passportTypeDDL = new Select(driver.findElement(passportType)); // نوع جواز السفر
		passportTypeDDL.selectByVisibleText(Permenant);
		Thread.sleep(Const);
		driver.findElement(passportNumber).sendKeys(passportNumberContent); // رقم جواز السفر
		Thread.sleep(Const);
		driver.findElement(productionDate).sendKeys(productionDateContent); // تاريخ الاصدار
		Thread.sleep(Const);
		driver.findElement(ExpiryDate).sendKeys(ExpiryDateContent); // تاريخ الانتهاء
		Thread.sleep(Const * 10);
		driver.findElement(productionLocation).sendKeys(productionLocationContent); // مكان الاصدار
		Thread.sleep(Const);

		Select arrivalCountryDDL = new Select(driver.findElement(arrivalCountry)); // بلد القدوم
		arrivalCountryDDL.selectByVisibleText(AbuDhabi);
		Thread.sleep(Const * 10);
		driver.findElement(placeOfBirth).sendKeys(placeOfBirthContent); // مكان الولادة
		Thread.sleep(Const * 10);
		driver.findElement(birthDate).sendKeys(dateOfBirthContent); // تاريخ الولادة
		Thread.sleep(Const * 10);
		driver.findElement(NoResidency).click(); // -نعم - لديك إقامة بالمملكة
		Thread.sleep(Const * 10);
		driver.findElement(noProperty).click(); // لا - هل لديك عقارات داخل المملكة؟
		Thread.sleep(Const * 10); 
		driver.findElement(currentResidenceAddress).sendKeys(currentResidenceAddressContent); // عنوان الإقامة الحالية
		Thread.sleep(Const);
		Select GenderDDL = new Select(driver.findElement(Gender)); // الجنس
		GenderDDL.selectByVisibleText(female); // أنثى
		Thread.sleep(Const * 10);
		Select SocialStatusDDL = new Select(driver.findElement(socialStatus)); // الحالة الاجتماعية
		SocialStatusDDL.selectByVisibleText(single); //أعزب
		//SocialStatusDDL.selectByVisibleText(married); // متزوج
		Thread.sleep(Const * 10);
		driver.findElement(job).sendKeys(JobContent); // عنوان الإقامة الحالية
		Thread.sleep(Const * 10);
		driver.findElement(registrationNo).sendKeys(registrationNoContent); // رقم الدخول
		Thread.sleep(Const);

		driver.findElement(additionalInfo).sendKeys(additionalInfoContent); // معلومات اضافية
		Thread.sleep(Const);

		driver.findElement(noOtherNationality).click();// - لا - جنسية أخرى
		Thread.sleep(Const);
		

		Select motherNationalityDDL = new Select(driver.findElement(motherNationality)); // جنسية الام
		motherNationalityDDL.selectByVisibleText(Jordanian);
		Thread.sleep(Const);

		driver.findElement(insideKigdom).click();// - نعم - هل المستدعى له داخل المملكة؟
		Thread.sleep(Const);
		// معلومات الام
		driver.findElement(MomFirstName).sendKeys(MomFirstNameContent);
		Thread.sleep(Const);
		driver.findElement(MomSecondName).sendKeys(MomSecondNameContent);
		Thread.sleep(Const);
		driver.findElement(MomThirdName).sendKeys(MomThirdNameContent);
		Thread.sleep(Const);
		driver.findElement(MomLastName).sendKeys(MomLastNameContent);
		   Thread.sleep(Const * 20);

		// ------------------------Purchaser InfoAttachments--------------------
		driver.findElement(Passport).click(); //جواز السفر 
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 10);
		Thread.sleep(Const * 10);
		driver.findElement(nextToPrpertyInfoFromPurchaserInfo).click();
		// ---------------------Property & Seller Info ------------------------------
				Thread.sleep(Const * 10);

				driver.findElement(recordNo).sendKeys("1234555"); // رقم القيد
				Thread.sleep(Const * 10);
				driver.findElement(DLSKeyButton).click();
				Thread.sleep(Const * 10);
				driver.findElement(schemeNo).sendKeys("1234555"); // الرقم المميز للمخطط
				Thread.sleep(Const);
				driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pgl5\"]/div[4]")).click(); // click-anywhere-to-navigate-out
				Thread.sleep(Const*10);
				driver.findElement(By.id("pt1:r1:1:pc2:t5:0:sbc2::content")).click();			
				// ------------------------Property InfoAttachments--------------------
				driver.findElement(OrganizationalChart).click(); // مخطط موقع تنظيمي 
				Thread.sleep(Const * 20);
				Runtime.getRuntime().exec(AttachPath);
				Thread.sleep(Const * 10);
				driver.findElement(NextToSellerAttach).click();
				//-------------------------Seller's Attachments----------------------
				
				Thread.sleep(Const * 50);
				driver.findElement(NextToLinkPurchaserandSellers).click();

			   //--------------------------Link Purchaser with Seller----------------
				Thread.sleep(Const * 30);

				Select SellerName = new Select(driver.findElement(VendorName)); // اسم المشتري
				SellerName.selectByValue("1");
				Thread.sleep(Const);
				
				Select Properties = new Select(driver.findElement(PropertiesA2)); // العقارات
				Properties.selectByValue("1");
				Thread.sleep(Const);

				Select OwnerName = new Select(driver.findElement(ownerName)); //اسم المالك
				OwnerName.selectByValue("1");
				Thread.sleep(Const);
				
				driver.findElement(areatoBeOwnedNum).sendKeys("40"); //المساحة المراد تملكها رقما
				Thread.sleep(Const);
				
				driver.findElement(areatoBeOwned).sendKeys("40"); //المساحة المراد تملكها كتابة
				Thread.sleep(Const);
				
				driver.findElement(numberofProportions).sendKeys("2"); // الحصص المراد تملكها رقما
				Thread.sleep(Const*20);
				driver.findElement(NextToReviewSection).click();
				Thread.sleep(Const*20);
			//---------------------------Review Section ------------------------
				Thread.sleep(Const * 20);
				driver.findElement(submitRequest).click();
				Thread.sleep(Const * 50);
	}
	@Test
	//  -  عدم وجود موافقة بيع-   البائع شركة - مدة الحجز غير منتهية
	public void Case3500() throws InterruptedException, IOException {
		// -----------------------------Applicant info-----------------------------

		Select ApplicantTypeDDL = new Select(driver.findElement(ApplicantType));
		ApplicantTypeDDL.selectByVisibleText(purchaser); // مشتري
		Thread.sleep(Const * 10);
		// نوع الموافقة
		driver.findElement(InternalRequestApprovalRadio).click();
		Select Purpose = new Select(driver.findElement(PurposeOfPossession)); // الغاية الرئيسية
		Purpose.selectByVisibleText(Residential);
		Thread.sleep(Const * 20);
		Select Purpose2 = new Select(driver.findElement(SecondaryPurposeOfPossession)); // الغاية الفرعية
		Purpose2.selectByVisibleText(Residence);
		// Next to Purchaser info
		Thread.sleep(Const);
		driver.findElement(nextToPurchaseInfo).click();

		// ---------------------------Purchaser info------------------------------
		// معلومات المشتري
		driver.findElement(BuyerFields1).sendKeys(buyerInfoContent1);
		driver.findElement(BuyerFields2).sendKeys(buyerInfoContent2);
		driver.findElement(BuyerFields3).sendKeys(buyerInfoContent3);
		driver.findElement(BuyerFields4).sendKeys(buyerInfoContent4);
		Thread.sleep(Const);
		driver.findElement(nameasinPassport).sendKeys(nameasinPassportContent); // الاسم حسب جواز السفر
		Thread.sleep(Const);
		Select NationalityDDL = new Select(driver.findElement(nationality)); // الجنسية
		NationalityDDL.selectByVisibleText(Egyptian);
		Thread.sleep(Const);
		driver.findElement(phoneNumber).sendKeys(phoneNoContent); // رقم الهاتف
		Select CountryDDL = new Select(driver.findElement(CountryCode)); // الرمز الدولي
		CountryDDL.selectByVisibleText(code1);
		Thread.sleep(Const);
		Select passportTypeDDL = new Select(driver.findElement(passportType)); // نوع جواز السفر
		passportTypeDDL.selectByVisibleText(Permenant);
		Thread.sleep(Const);
		driver.findElement(passportNumber).sendKeys(passportNumberContent); // رقم جواز السفر
		Thread.sleep(Const);
		driver.findElement(productionDate).sendKeys(productionDateContent); // تاريخ الاصدار
		Thread.sleep(Const);
		driver.findElement(ExpiryDate).sendKeys(ExpiryDateContent); // تاريخ الانتهاء
		Thread.sleep(Const * 10);
		driver.findElement(productionLocation).sendKeys(productionLocationContent); // مكان الاصدار
		Thread.sleep(Const);

		Select arrivalCountryDDL = new Select(driver.findElement(arrivalCountry)); // بلد القدوم
		arrivalCountryDDL.selectByVisibleText(AbuDhabi);
		Thread.sleep(Const * 10);
		driver.findElement(placeOfBirth).sendKeys(placeOfBirthContent); // مكان الولادة
		Thread.sleep(Const * 10);
		driver.findElement(birthDate).sendKeys(dateOfBirthContent); // تاريخ الولادة
		Thread.sleep(Const * 10);
		driver.findElement(NoResidency).click(); // -نعم - لديك إقامة بالمملكة
		Thread.sleep(Const * 10);
		driver.findElement(noProperty).click(); // لا - هل لديك عقارات داخل المملكة؟
		Thread.sleep(Const * 10); 
		driver.findElement(currentResidenceAddress).sendKeys(currentResidenceAddressContent); // عنوان الإقامة الحالية
		Thread.sleep(Const);
		Select GenderDDL = new Select(driver.findElement(Gender)); // الجنس
		GenderDDL.selectByVisibleText(female); // أنثى
		Thread.sleep(Const * 10);
		Select SocialStatusDDL = new Select(driver.findElement(socialStatus)); // الحالة الاجتماعية
		SocialStatusDDL.selectByVisibleText(single); //أعزب
		//SocialStatusDDL.selectByVisibleText(married); // متزوج
		Thread.sleep(Const * 10);
		driver.findElement(job).sendKeys(JobContent); // عنوان الإقامة الحالية
		Thread.sleep(Const * 10);
		driver.findElement(registrationNo).sendKeys(registrationNoContent); // رقم الدخول
		Thread.sleep(Const);

		driver.findElement(additionalInfo).sendKeys(additionalInfoContent); // معلومات اضافية
		Thread.sleep(Const);

		driver.findElement(noOtherNationality).click();// - لا - جنسية أخرى
		Thread.sleep(Const);
		

		Select motherNationalityDDL = new Select(driver.findElement(motherNationality)); // جنسية الام
		motherNationalityDDL.selectByVisibleText(Jordanian);
		Thread.sleep(Const);

		driver.findElement(insideKigdom).click();// - نعم - هل المستدعى له داخل المملكة؟
		Thread.sleep(Const);
		// معلومات الام
		driver.findElement(MomFirstName).sendKeys(MomFirstNameContent);
		Thread.sleep(Const);
		driver.findElement(MomSecondName).sendKeys(MomSecondNameContent);
		Thread.sleep(Const);
		driver.findElement(MomThirdName).sendKeys(MomThirdNameContent);
		Thread.sleep(Const);
		driver.findElement(MomLastName).sendKeys(MomLastNameContent);
		   Thread.sleep(Const * 20);

		// ------------------------Purchaser InfoAttachments--------------------

//		driver.findElement(Others).click();
//		Thread.sleep(Const * 20);
//		Runtime.getRuntime().exec(AttachPath);
		driver.findElement(Passport).click(); //جواز السفر 
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 10);
		Thread.sleep(Const * 10);
		driver.findElement(nextToPrpertyInfoFromPurchaserInfo).click();
		// ---------------------Property & Seller Info ------------------------------
				Thread.sleep(Const * 10);
				driver.findElement(recordNo).sendKeys("1234554"); // رقم القيد
				Thread.sleep(Const * 10);
				driver.findElement(DLSKeyButton).click();
				Thread.sleep(Const * 10);
				driver.findElement(schemeNo).sendKeys("1234554"); // الرقم المميز للمخطط
				Thread.sleep(Const);
				driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pgl5\"]/div[4]")).click(); // click-anywhere-to-navigate-out
				Thread.sleep(Const*10);
				driver.findElement(By.id("pt1:r1:1:pc2:t5:0:sbc2::content")).click();
				// ------------------------Property InfoAttachments--------------------
				Thread.sleep(Const * 10);
				driver.findElement(NextToSellerAttach).click();
				//-------------------------Seller's Attachments----------------------
				driver.findElement(IDCardSeller).click();
				Thread.sleep(Const * 20);
				Runtime.getRuntime().exec(AttachPath);
				Thread.sleep(Const * 50);
				driver.findElement(NextToLinkPurchaserandSellers).click();

	}
	@Test
	//البائع جهة حكومية
	public void Case3600() throws InterruptedException, IOException {
		// -----------------------------Applicant info-----------------------------

		Select ApplicantTypeDDL = new Select(driver.findElement(ApplicantType));
		ApplicantTypeDDL.selectByVisibleText(purchaser); // مشتري
		Thread.sleep(Const * 10);
		// نوع الموافقة
		driver.findElement(InternalRequestApprovalRadio).click();
		Select Purpose = new Select(driver.findElement(PurposeOfPossession)); // الغاية الرئيسية
		Purpose.selectByVisibleText(Residential);
		Thread.sleep(Const * 20);
		Select Purpose2 = new Select(driver.findElement(SecondaryPurposeOfPossession)); // الغاية الفرعية
		Purpose2.selectByVisibleText(Residence);
		// Next to Purchaser info
		Thread.sleep(Const);
		driver.findElement(nextToPurchaseInfo).click();

		// ---------------------------Purchaser info------------------------------
		// معلومات المشتري
		driver.findElement(BuyerFields1).sendKeys(buyerInfoContent1);
		driver.findElement(BuyerFields2).sendKeys(buyerInfoContent2);
		driver.findElement(BuyerFields3).sendKeys(buyerInfoContent3);
		driver.findElement(BuyerFields4).sendKeys(buyerInfoContent4);
		Thread.sleep(Const);
		driver.findElement(nameasinPassport).sendKeys(nameasinPassportContent); // الاسم حسب جواز السفر
		Thread.sleep(Const);
		Select NationalityDDL = new Select(driver.findElement(nationality)); // الجنسية
		NationalityDDL.selectByVisibleText(Egyptian);
		Thread.sleep(Const);
		driver.findElement(phoneNumber).sendKeys(phoneNoContent); // رقم الهاتف
		Select CountryDDL = new Select(driver.findElement(CountryCode)); // الرمز الدولي
		CountryDDL.selectByVisibleText(code1);
		Thread.sleep(Const);
		Select passportTypeDDL = new Select(driver.findElement(passportType)); // نوع جواز السفر
		passportTypeDDL.selectByVisibleText(Permenant);
		Thread.sleep(Const);
		driver.findElement(passportNumber).sendKeys(passportNumberContent); // رقم جواز السفر
		Thread.sleep(Const);
		driver.findElement(productionDate).sendKeys(productionDateContent); // تاريخ الاصدار
		Thread.sleep(Const);
		driver.findElement(ExpiryDate).sendKeys(ExpiryDateContent); // تاريخ الانتهاء
		Thread.sleep(Const * 10);
		driver.findElement(productionLocation).sendKeys(productionLocationContent); // مكان الاصدار
		Thread.sleep(Const);

		Select arrivalCountryDDL = new Select(driver.findElement(arrivalCountry)); // بلد القدوم
		arrivalCountryDDL.selectByVisibleText(AbuDhabi);
		Thread.sleep(Const * 10);
		driver.findElement(placeOfBirth).sendKeys(placeOfBirthContent); // مكان الولادة
		Thread.sleep(Const * 10);
		driver.findElement(birthDate).sendKeys(dateOfBirthContent); // تاريخ الولادة
		Thread.sleep(Const * 10);
		driver.findElement(NoResidency).click(); // -نعم - لديك إقامة بالمملكة
		Thread.sleep(Const * 10);
		driver.findElement(noProperty).click(); // لا - هل لديك عقارات داخل المملكة؟
		Thread.sleep(Const * 10); 
		driver.findElement(currentResidenceAddress).sendKeys(currentResidenceAddressContent); // عنوان الإقامة الحالية
		Thread.sleep(Const);
		Select GenderDDL = new Select(driver.findElement(Gender)); // الجنس
		GenderDDL.selectByVisibleText(female); // أنثى
		Thread.sleep(Const * 10);
		Select SocialStatusDDL = new Select(driver.findElement(socialStatus)); // الحالة الاجتماعية
		SocialStatusDDL.selectByVisibleText(single); //أعزب
		//SocialStatusDDL.selectByVisibleText(married); // متزوج
		Thread.sleep(Const * 10);
		driver.findElement(job).sendKeys(JobContent); // عنوان الإقامة الحالية
		Thread.sleep(Const * 10);
		driver.findElement(registrationNo).sendKeys(registrationNoContent); // رقم الدخول
		Thread.sleep(Const);

		driver.findElement(additionalInfo).sendKeys(additionalInfoContent); // معلومات اضافية
		Thread.sleep(Const);

		driver.findElement(noOtherNationality).click();// - لا - جنسية أخرى
		Thread.sleep(Const);
		

		Select motherNationalityDDL = new Select(driver.findElement(motherNationality)); // جنسية الام
		motherNationalityDDL.selectByVisibleText(Jordanian);
		Thread.sleep(Const);

		driver.findElement(insideKigdom).click();// - نعم - هل المستدعى له داخل المملكة؟
		Thread.sleep(Const);
		// معلومات الام
		driver.findElement(MomFirstName).sendKeys(MomFirstNameContent);
		Thread.sleep(Const);
		driver.findElement(MomSecondName).sendKeys(MomSecondNameContent);
		Thread.sleep(Const);
		driver.findElement(MomThirdName).sendKeys(MomThirdNameContent);
		Thread.sleep(Const);
		driver.findElement(MomLastName).sendKeys(MomLastNameContent);
		   Thread.sleep(Const * 20);

		// ------------------------Purchaser InfoAttachments--------------------
		driver.findElement(Passport).click(); //جواز السفر 
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 10);
		Thread.sleep(Const * 10);
		driver.findElement(nextToPrpertyInfoFromPurchaserInfo).click();
		// ---------------------Property & Seller Info ------------------------------
				Thread.sleep(Const * 10);
				driver.findElement(recordNo).sendKeys("1234566"); // رقم القيد
				Thread.sleep(Const * 10);
				driver.findElement(DLSKeyButton).click();
				Thread.sleep(Const * 10);
				driver.findElement(schemeNo).sendKeys("1234566"); // الرقم المميز للمخطط
				Thread.sleep(Const);
				driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pc2:t5:0:sbc2::content\"]")).click(); // click-anywhere-to-navigate-out
				Thread.sleep(Const*10);
				driver.findElement( By.id("")).click();

				// ------------------------Property InfoAttachments--------------------
				Thread.sleep(Const * 10);
				driver.findElement(NextToSellerAttach).click();

				//-------------------------Seller's Attachments----------------------
				driver.findElement(FormalLetter).click();
				Thread.sleep(Const * 20);
				Runtime.getRuntime().exec(AttachPath);
				Thread.sleep(Const * 50);
				driver.findElement(NextToLinkPurchaserandSellers).click();

			   //--------------------------Link Purchaser with Seller----------------
				Thread.sleep(Const * 30);

				Select SellerName = new Select(driver.findElement(VendorName)); // اسم المشتري
				SellerName.selectByValue("1");
				Thread.sleep(Const);
				
				Select Properties = new Select(driver.findElement(PropertiesA2)); // العقارات
				Properties.selectByValue("1");
				Thread.sleep(Const);

				Select OwnerName = new Select(driver.findElement(ownerName)); //اسم المالك
				OwnerName.selectByValue("1");
				Thread.sleep(Const);
				
				driver.findElement(areatoBeOwnedNum).sendKeys("40"); //المساحة المراد تملكها رقما
				Thread.sleep(Const);
				
				driver.findElement(areatoBeOwned).sendKeys("40"); //المساحة المراد تملكها كتابة
				Thread.sleep(Const);
				
				driver.findElement(numberofProportions).sendKeys("2"); // الحصص المراد تملكها رقما
				Thread.sleep(Const*20);
				driver.findElement(NextToReviewSection).click();
				Thread.sleep(Const*20);
			//---------------------------Review Section ------------------------
				Thread.sleep(Const * 20);
				driver.findElement(submitRequest).click();
				Thread.sleep(Const * 50);
	}
	@Test
	//البائع  
	public void Case3700() throws InterruptedException, IOException {
		// -----------------------------Applicant info-----------------------------

		Select ApplicantTypeDDL = new Select(driver.findElement(ApplicantType));
		ApplicantTypeDDL.selectByVisibleText(purchaser); // مشتري
		Thread.sleep(Const * 10);
		// نوع الموافقة
		driver.findElement(InternalRequestApprovalRadio).click();
		Select Purpose = new Select(driver.findElement(PurposeOfPossession)); // الغاية الرئيسية
		Purpose.selectByVisibleText(Residential);
		Thread.sleep(Const * 20);
		Select Purpose2 = new Select(driver.findElement(SecondaryPurposeOfPossession)); // الغاية الفرعية
		Purpose2.selectByVisibleText(Residence);
		// Next to Purchaser info
		Thread.sleep(Const);
		driver.findElement(nextToPurchaseInfo).click();

		// ---------------------------Purchaser info------------------------------
		// معلومات المشتري
		driver.findElement(BuyerFields1).sendKeys(buyerInfoContent1);
		driver.findElement(BuyerFields2).sendKeys(buyerInfoContent2);
		driver.findElement(BuyerFields3).sendKeys(buyerInfoContent3);
		driver.findElement(BuyerFields4).sendKeys(buyerInfoContent4);
		Thread.sleep(Const);
		driver.findElement(nameasinPassport).sendKeys(nameasinPassportContent); // الاسم حسب جواز السفر
		Thread.sleep(Const);
		Select NationalityDDL = new Select(driver.findElement(nationality)); // الجنسية
		NationalityDDL.selectByVisibleText(Egyptian);
		Thread.sleep(Const);
		driver.findElement(phoneNumber).sendKeys(phoneNoContent); // رقم الهاتف
		Select CountryDDL = new Select(driver.findElement(CountryCode)); // الرمز الدولي
		CountryDDL.selectByVisibleText(code1);
		Thread.sleep(Const);
		Select passportTypeDDL = new Select(driver.findElement(passportType)); // نوع جواز السفر
		passportTypeDDL.selectByVisibleText(Permenant);
		Thread.sleep(Const);
		driver.findElement(passportNumber).sendKeys(passportNumberContent); // رقم جواز السفر
		Thread.sleep(Const);
		driver.findElement(productionDate).sendKeys(productionDateContent); // تاريخ الاصدار
		Thread.sleep(Const);
		driver.findElement(ExpiryDate).sendKeys(ExpiryDateContent); // تاريخ الانتهاء
		Thread.sleep(Const * 10);
		driver.findElement(productionLocation).sendKeys(productionLocationContent); // مكان الاصدار
		Thread.sleep(Const);

		Select arrivalCountryDDL = new Select(driver.findElement(arrivalCountry)); // بلد القدوم
		arrivalCountryDDL.selectByVisibleText(AbuDhabi);
		Thread.sleep(Const * 10);
		driver.findElement(placeOfBirth).sendKeys(placeOfBirthContent); // مكان الولادة
		Thread.sleep(Const * 10);
		driver.findElement(birthDate).sendKeys(dateOfBirthContent); // تاريخ الولادة
		Thread.sleep(Const * 10);
		driver.findElement(NoResidency).click(); // -نعم - لديك إقامة بالمملكة
		Thread.sleep(Const * 10);
		driver.findElement(noProperty).click(); // لا - هل لديك عقارات داخل المملكة؟
		Thread.sleep(Const * 10); 
		driver.findElement(currentResidenceAddress).sendKeys(currentResidenceAddressContent); // عنوان الإقامة الحالية
		Thread.sleep(Const);
		Select GenderDDL = new Select(driver.findElement(Gender)); // الجنس
		GenderDDL.selectByVisibleText(female); // أنثى
		Thread.sleep(Const * 10);
		Select SocialStatusDDL = new Select(driver.findElement(socialStatus)); // الحالة الاجتماعية
		SocialStatusDDL.selectByVisibleText(single); //أعزب
		//SocialStatusDDL.selectByVisibleText(married); // متزوج
		Thread.sleep(Const * 10);
		driver.findElement(job).sendKeys(JobContent); // عنوان الإقامة الحالية
		Thread.sleep(Const * 10);
		driver.findElement(registrationNo).sendKeys(registrationNoContent); // رقم الدخول
		Thread.sleep(Const);
		driver.findElement(additionalInfo).sendKeys(additionalInfoContent); // معلومات اضافية
		Thread.sleep(Const);
		driver.findElement(noOtherNationality).click();// - لا - جنسية أخرى
		Thread.sleep(Const);	
		Select motherNationalityDDL = new Select(driver.findElement(motherNationality)); // جنسية الام
		motherNationalityDDL.selectByVisibleText(Jordanian);
		Thread.sleep(Const);
		driver.findElement(insideKigdom).click();// - نعم - هل المستدعى له داخل المملكة؟
		Thread.sleep(Const);
		// معلومات الام
		driver.findElement(MomFirstName).sendKeys(MomFirstNameContent);
		Thread.sleep(Const);
		driver.findElement(MomSecondName).sendKeys(MomSecondNameContent);
		Thread.sleep(Const);
		driver.findElement(MomThirdName).sendKeys(MomThirdNameContent);
		Thread.sleep(Const);
		driver.findElement(MomLastName).sendKeys(MomLastNameContent);
		   Thread.sleep(Const * 20);
		// ------------------------Purchaser InfoAttachments--------------------
//		driver.findElement(Others).click();
//		Thread.sleep(Const * 20);
//		Runtime.getRuntime().exec(AttachPath);
		driver.findElement(Passport).click(); //جواز السفر 
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 10);
		Thread.sleep(Const * 10);
		driver.findElement(nextToPrpertyInfoFromPurchaserInfo).click();
		// ---------------------Property & Seller Info ------------------------------
				Thread.sleep(Const * 10);
				driver.findElement(recordNo).sendKeys("1234565"); // رقم القيد
				Thread.sleep(Const * 10);
				driver.findElement(DLSKeyButton).click();
				Thread.sleep(Const * 10);
				driver.findElement(schemeNo).sendKeys("1234565"); // الرقم المميز للمخطط
				Thread.sleep(Const);
				driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pc2:t5:0:sbc2::content\"]")).click(); // click-anywhere-to-navigate-out
				Thread.sleep(Const*10);
				// ------------------------Property InfoAttachments--------------------
				driver.findElement(OrganizationalChart).click();
				Thread.sleep(Const * 20);
				Runtime.getRuntime().exec(AttachPath);
				Thread.sleep(Const * 20);
				Thread.sleep(Const * 10);
				driver.findElement(NextToSellerAttach).click();
				//-------------------------Seller's Attachments----------------------
				driver.findElement(FormalLetter).click();
				Thread.sleep(Const * 20);
				Runtime.getRuntime().exec(AttachPath);
				Thread.sleep(Const * 50);
				driver.findElement(NextToLinkPurchaserandSellers).click();
			   //--------------------------Link Purchaser with Seller----------------
				Thread.sleep(Const * 30);

				Select SellerName = new Select(driver.findElement(VendorName)); // اسم المشتري
				SellerName.selectByValue("1");
				Thread.sleep(Const);
				
				Select Properties = new Select(driver.findElement(PropertiesA2)); // العقارات
				Properties.selectByValue("1");
				Thread.sleep(Const);

				Select OwnerName = new Select(driver.findElement(ownerName)); //اسم المالك
				OwnerName.selectByValue("1");
				Thread.sleep(Const);
				
				driver.findElement(areatoBeOwnedNum).sendKeys("40"); //المساحة المراد تملكها رقما
				Thread.sleep(Const);
				
				driver.findElement(areatoBeOwned).sendKeys("40"); //المساحة المراد تملكها كتابة
				Thread.sleep(Const);
				
				driver.findElement(numberofProportions).sendKeys("2"); // الحصص المراد تملكها رقما
				Thread.sleep(Const*20);
				driver.findElement(NextToReviewSection).click();
				Thread.sleep(Const*20);
			//---------------------------Review Section ------------------------
				Thread.sleep(Const * 20);
				driver.findElement(submitRequest).click();
				Thread.sleep(Const * 50);
	}
	@Test
	//   الجهة التنظيمية امانة عمان الكبرى- طلب مستعجل

	public void Case5000() throws InterruptedException, IOException {
		// -----------------------------Applicant info-----------------------------
		Select ApplicantTypeDDL = new Select(driver.findElement(ApplicantType));
		ApplicantTypeDDL.selectByVisibleText(purchaser); // مشتري
		Thread.sleep(Const * 10);		
		driver.findElement(ExpressRequestCheckBox).click(); //طلب مستعجل
		Thread.sleep(Const * 10);
		// نوع الموافقة
		driver.findElement(InternalRequestApprovalRadio).click();
		Select Purpose = new Select(driver.findElement(PurposeOfPossession)); // الغاية الرئيسية
		Purpose.selectByVisibleText(Residential);
		Thread.sleep(Const * 20);
		Select Purpose2 = new Select(driver.findElement(SecondaryPurposeOfPossession)); // الغاية الفرعية
		Purpose2.selectByVisibleText(Residence);
		// Next to Purchaser info
		Thread.sleep(Const*20);
		driver.findElement(nextToPurchaseInfo).click();

		// ---------------------------Purchaser info------------------------------
		// معلومات المشتري
		Thread.sleep(Const*20);
		driver.findElement(BuyerFields1).sendKeys(buyerInfoContent1);
		driver.findElement(BuyerFields2).sendKeys(buyerInfoContent2);
		driver.findElement(BuyerFields3).sendKeys(buyerInfoContent3);
		driver.findElement(BuyerFields4).sendKeys(buyerInfoContent4);
		Thread.sleep(Const);
		driver.findElement(nameasinPassport).sendKeys(nameasinPassportContent); // الاسم حسب جواز السفر
		Thread.sleep(Const);
		Select NationalityDDL = new Select(driver.findElement(nationality)); // الجنسية
		NationalityDDL.selectByVisibleText(Egyptian);
		Thread.sleep(Const);
		driver.findElement(phoneNumber).sendKeys(phoneNoContent); // رقم الهاتف
		Select CountryDDL = new Select(driver.findElement(CountryCode)); // الرمز الدولي
		CountryDDL.selectByVisibleText(code1);
		Thread.sleep(Const);
		Select passportTypeDDL = new Select(driver.findElement(passportType)); // نوع جواز السفر
		passportTypeDDL.selectByVisibleText(Permenant);
		Thread.sleep(Const);
		driver.findElement(passportNumber).sendKeys(passportNumberContent); // رقم جواز السفر
		Thread.sleep(Const);
		driver.findElement(productionDate).sendKeys(productionDateContent); // تاريخ الاصدار
		Thread.sleep(Const);
		driver.findElement(ExpiryDate).sendKeys(ExpiryDateContent); // تاريخ الانتهاء
		Thread.sleep(Const * 10);
		driver.findElement(productionLocation).sendKeys(productionLocationContent); // مكان الاصدار
		Thread.sleep(Const);

		Select arrivalCountryDDL = new Select(driver.findElement(arrivalCountry)); // بلد القدوم
		arrivalCountryDDL.selectByVisibleText(AbuDhabi);
		Thread.sleep(Const * 10);
		driver.findElement(placeOfBirth).sendKeys(placeOfBirthContent); // مكان الولادة
		Thread.sleep(Const * 10);
		driver.findElement(birthDate).sendKeys(dateOfBirthContent); // تاريخ الولادة
		Thread.sleep(Const * 10);
		driver.findElement(NoResidency).click(); // -نعم - لديك إقامة بالمملكة
		Thread.sleep(Const * 10);
		driver.findElement(noProperty).click(); // لا - هل لديك عقارات داخل المملكة؟
		Thread.sleep(Const * 10); 
		driver.findElement(currentResidenceAddress).sendKeys(currentResidenceAddressContent); // عنوان الإقامة الحالية
		Thread.sleep(Const);
		Select GenderDDL = new Select(driver.findElement(Gender)); // الجنس
		GenderDDL.selectByVisibleText(female); // أنثى
		Thread.sleep(Const * 10);
		Select SocialStatusDDL = new Select(driver.findElement(socialStatus)); // الحالة الاجتماعية
		SocialStatusDDL.selectByVisibleText(single); //أعزب
		//SocialStatusDDL.selectByVisibleText(married); // متزوج
		Thread.sleep(Const * 10);
		driver.findElement(job).sendKeys(JobContent); // عنوان الإقامة الحالية
		Thread.sleep(Const * 10);
		driver.findElement(registrationNo).sendKeys(registrationNoContent); // رقم الدخول
		Thread.sleep(Const);

		driver.findElement(additionalInfo).sendKeys(additionalInfoContent); // معلومات اضافية
		Thread.sleep(Const);

		driver.findElement(noOtherNationality).click();// - لا - جنسية أخرى
		Thread.sleep(Const);
		

		Select motherNationalityDDL = new Select(driver.findElement(motherNationality)); // جنسية الام
		motherNationalityDDL.selectByVisibleText(Jordanian);
		Thread.sleep(Const);

		driver.findElement(insideKigdom).click();// - نعم - هل المستدعى له داخل المملكة؟
		Thread.sleep(Const);
		// معلومات الام
		driver.findElement(MomFirstName).sendKeys(MomFirstNameContent);
		Thread.sleep(Const);
		driver.findElement(MomSecondName).sendKeys(MomSecondNameContent);
		Thread.sleep(Const);
		driver.findElement(MomThirdName).sendKeys(MomThirdNameContent);
		Thread.sleep(Const);
		driver.findElement(MomLastName).sendKeys(MomLastNameContent);
		   Thread.sleep(Const * 20);
		// ------------------------Purchaser InfoAttachments--------------------

//		driver.findElement(Others).click();
//		Thread.sleep(Const * 20);
//		Runtime.getRuntime().exec(AttachPath);
		driver.findElement(Passport).click(); //جواز السفر 
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 10);
		Thread.sleep(Const * 10);
		driver.findElement(nextToPrpertyInfoFromPurchaserInfo).click();
		// ---------------------Property & Seller Info ------------------------------
				Thread.sleep(Const * 10);
				driver.findElement(recordNo).sendKeys("1234564"); // رقم القيد
				Thread.sleep(Const * 10);
				driver.findElement(DLSKeyButton).click();
				Thread.sleep(Const * 10);
				driver.findElement(schemeNo).sendKeys("1234564"); // الرقم المميز للمخطط
				Thread.sleep(Const);
				driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pgl5\"]/div[4]")).click(); // click-anywhere-to-navigate-out
				Thread.sleep(Const*10);
				driver.findElement(NonJordanianOwner).click();
				driver.findElement(NonJordanianOwner).click();
				// ------------------------Property InfoAttachments--------------------

//				driver.findElement(Others2).click();
//				Thread.sleep(Const * 20);
//				Runtime.getRuntime().exec(AttachPath);
//				Thread.sleep(Const * 20);
				//--wrong Attachments
			 	driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pc1:t2:0:pgl50\"]/tbody/tr/td[3]/span")).click();
			    Thread.sleep(Const * 20);
				Runtime.getRuntime().exec(AttachPath);
				Thread.sleep(Const * 20);
				driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pc1:t2:1:pgl50\"]/tbody/tr/td[3]/span")).click();
				Thread.sleep(Const * 20);
				Runtime.getRuntime().exec(AttachPath);
				Thread.sleep(Const * 20);					
				Thread.sleep(Const * 10);
				driver.findElement(NextToSellerAttach).click();
				//-------------------------Seller's Attachments----------------------
				driver.findElement(IDCardSeller).click();
				Thread.sleep(Const * 20);
				Runtime.getRuntime().exec(AttachPath);
				Thread.sleep(Const * 50);
				driver.findElement(NextToLinkPurchaserandSellers).click();

			   //--------------------------Link Purchaser with Seller----------------
				Thread.sleep(Const * 30);
				Select SellerName = new Select(driver.findElement(VendorName)); // اسم المشتري
				SellerName.selectByValue("1");
				Thread.sleep(Const);			
				Select Properties = new Select(driver.findElement(PropertiesA2)); // العقارات
				Properties.selectByValue("1");
				Thread.sleep(Const);
				Select OwnerName = new Select(driver.findElement(ownerName)); //اسم المالك
				OwnerName.selectByValue("1");
				Thread.sleep(Const);				
				driver.findElement(areatoBeOwnedNum).sendKeys("40"); //المساحة المراد تملكها رقما
				Thread.sleep(Const);				
				driver.findElement(areatoBeOwned).sendKeys("40"); //المساحة المراد تملكها كتابة
				Thread.sleep(Const);				
				driver.findElement(numberofProportions).sendKeys("2"); // الحصص المراد تملكها رقما
				Thread.sleep(Const*20);
				driver.findElement(NextToReviewSection).click();
				Thread.sleep(Const*20);
			//---------------------------Review Section ------------------------
				Thread.sleep(Const * 20);
				driver.findElement(submitRequest).click();
				Thread.sleep(Const * 50);
	}
	@Test
	//   وزارة البلديات - طلب مستعجل
	public void Case5100() throws InterruptedException, IOException {
		// -----------------------------Applicant info-----------------------------

		Select ApplicantTypeDDL = new Select(driver.findElement(ApplicantType));
		ApplicantTypeDDL.selectByVisibleText(purchaser); // مشتري
		Thread.sleep(Const * 10);
		driver.findElement(ExpressRequestCheckBox).click(); //طلب مستعجل
		Thread.sleep(Const * 10);
		// نوع الموافقة
		driver.findElement(InternalRequestApprovalRadio).click();
		Select Purpose = new Select(driver.findElement(PurposeOfPossession)); // الغاية الرئيسية
		Purpose.selectByVisibleText(Residential);
		Thread.sleep(Const * 20);
		Select Purpose2 = new Select(driver.findElement(SecondaryPurposeOfPossession)); // الغاية الفرعية
		Purpose2.selectByVisibleText(Residence);
		// Next to Purchaser info
		Thread.sleep(Const*20);
		driver.findElement(nextToPurchaseInfo).click();
		// ---------------------------Purchaser info------------------------------
		// معلومات المشتري
		Thread.sleep(Const*20);
		driver.findElement(BuyerFields1).sendKeys(buyerInfoContent1);
		driver.findElement(BuyerFields2).sendKeys(buyerInfoContent2);
		driver.findElement(BuyerFields3).sendKeys(buyerInfoContent3);
		driver.findElement(BuyerFields4).sendKeys(buyerInfoContent4);
		Thread.sleep(Const);
		driver.findElement(nameasinPassport).sendKeys(nameasinPassportContent); // الاسم حسب جواز السفر
		Thread.sleep(Const);
		Select NationalityDDL = new Select(driver.findElement(nationality)); // الجنسية
		NationalityDDL.selectByVisibleText(Egyptian);
		Thread.sleep(Const);
		driver.findElement(phoneNumber).sendKeys(phoneNoContent); // رقم الهاتف
		Select CountryDDL = new Select(driver.findElement(CountryCode)); // الرمز الدولي
		CountryDDL.selectByVisibleText(code1);
		Thread.sleep(Const);
		Select passportTypeDDL = new Select(driver.findElement(passportType)); // نوع جواز السفر
		passportTypeDDL.selectByVisibleText(Permenant);
		Thread.sleep(Const);
		driver.findElement(passportNumber).sendKeys(passportNumberContent); // رقم جواز السفر
		Thread.sleep(Const);
		driver.findElement(productionDate).sendKeys(productionDateContent); // تاريخ الاصدار
		Thread.sleep(Const);
		driver.findElement(ExpiryDate).sendKeys(ExpiryDateContent); // تاريخ الانتهاء
		Thread.sleep(Const * 10);
		driver.findElement(productionLocation).sendKeys(productionLocationContent); // مكان الاصدار
		Thread.sleep(Const);

		Select arrivalCountryDDL = new Select(driver.findElement(arrivalCountry)); // بلد القدوم
		arrivalCountryDDL.selectByVisibleText(AbuDhabi);
		Thread.sleep(Const * 10);
		driver.findElement(placeOfBirth).sendKeys(placeOfBirthContent); // مكان الولادة
		Thread.sleep(Const * 10);
		driver.findElement(birthDate).sendKeys(dateOfBirthContent); // تاريخ الولادة
		Thread.sleep(Const * 10);
		driver.findElement(NoResidency).click(); // -نعم - لديك إقامة بالمملكة
		Thread.sleep(Const * 10);
		driver.findElement(noProperty).click(); // لا - هل لديك عقارات داخل المملكة؟
		Thread.sleep(Const * 10); 
		driver.findElement(currentResidenceAddress).sendKeys(currentResidenceAddressContent); // عنوان الإقامة الحالية
		Thread.sleep(Const);
		Select GenderDDL = new Select(driver.findElement(Gender)); // الجنس
		GenderDDL.selectByVisibleText(female); // أنثى
		Thread.sleep(Const * 10);
		Select SocialStatusDDL = new Select(driver.findElement(socialStatus)); // الحالة الاجتماعية
		SocialStatusDDL.selectByVisibleText(single); //أعزب
		//SocialStatusDDL.selectByVisibleText(married); // متزوج
		Thread.sleep(Const * 10);
		driver.findElement(job).sendKeys(JobContent); // عنوان الإقامة الحالية
		Thread.sleep(Const * 10);
		driver.findElement(registrationNo).sendKeys(registrationNoContent); // رقم الدخول
		Thread.sleep(Const);
		driver.findElement(additionalInfo).sendKeys(additionalInfoContent); // معلومات اضافية
		Thread.sleep(Const);
		driver.findElement(noOtherNationality).click();// - لا - جنسية أخرى
		Thread.sleep(Const);
		Select motherNationalityDDL = new Select(driver.findElement(motherNationality)); // جنسية الام
		motherNationalityDDL.selectByVisibleText(Jordanian);
		Thread.sleep(Const);

		driver.findElement(insideKigdom).click();// - نعم - هل المستدعى له داخل المملكة؟
		Thread.sleep(Const);
		// معلومات الام
		driver.findElement(MomFirstName).sendKeys(MomFirstNameContent);
		Thread.sleep(Const);
		driver.findElement(MomSecondName).sendKeys(MomSecondNameContent);
		Thread.sleep(Const);
		driver.findElement(MomThirdName).sendKeys(MomThirdNameContent);
		Thread.sleep(Const);
		driver.findElement(MomLastName).sendKeys(MomLastNameContent);
		   Thread.sleep(Const * 20);
		// ------------------------Purchaser InfoAttachments--------------------
//		driver.findElement(Others).click();
//		Thread.sleep(Const * 20);
//		Runtime.getRuntime().exec(AttachPath);
		driver.findElement(Passport).click(); //جواز السفر 
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 10);
		Thread.sleep(Const * 10);
		driver.findElement(nextToPrpertyInfoFromPurchaserInfo).click();
		// ---------------------Property & Seller Info ------------------------------
				Thread.sleep(Const * 10);
				driver.findElement(recordNo).sendKeys("1234563"); // رقم القيد
				Thread.sleep(Const * 10);
				driver.findElement(DLSKeyButton).click();
				Thread.sleep(Const * 10);
				driver.findElement(schemeNo).sendKeys("1234563"); // الرقم المميز للمخطط
				Thread.sleep(Const);
				driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pgl5\"]/div[4]")).click(); // click-anywhere-to-navigate-out
				Thread.sleep(Const*10);
				driver.findElement(NonJordanianOwner).click();
				driver.findElement(NonJordanianOwner).click();

				// ------------------------Property InfoAttachments--------------------

//				driver.findElement(Others2).click();
//				Thread.sleep(Const * 20);
//				Runtime.getRuntime().exec(AttachPath);
//				Thread.sleep(Const * 20);
				
				//--wrong Attachments
			 	driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pc1:t2:0:pgl50\"]/tbody/tr/td[3]/span")).click();
			    Thread.sleep(Const * 20);
				Runtime.getRuntime().exec(AttachPath);
				Thread.sleep(Const * 20);
				
				driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pc1:t2:1:pgl50\"]/tbody/tr/td[3]/span")).click();
				Thread.sleep(Const * 20);
				Runtime.getRuntime().exec(AttachPath);
				Thread.sleep(Const * 20);
					
				Thread.sleep(Const * 10);
				driver.findElement(NextToSellerAttach).click();

				//-------------------------Seller's Attachments----------------------

				driver.findElement(IDCardSeller).click();
				Thread.sleep(Const * 20);
				Runtime.getRuntime().exec(AttachPath);
				Thread.sleep(Const * 50);
				driver.findElement(NextToLinkPurchaserandSellers).click();

			   //--------------------------Link Purchaser with Seller----------------
				Thread.sleep(Const * 30);

				Select SellerName = new Select(driver.findElement(VendorName)); // اسم المشتري
				SellerName.selectByValue("1");
				Thread.sleep(Const);
				
				Select Properties = new Select(driver.findElement(PropertiesA2)); // العقارات
				Properties.selectByValue("1");
				Thread.sleep(Const);

				Select OwnerName = new Select(driver.findElement(ownerName)); //اسم المالك
				OwnerName.selectByValue("1");
				Thread.sleep(Const);
				
				driver.findElement(areatoBeOwnedNum).sendKeys("40"); //المساحة المراد تملكها رقما
				Thread.sleep(Const);
				
				driver.findElement(areatoBeOwned).sendKeys("40"); //المساحة المراد تملكها كتابة
				Thread.sleep(Const);
				
				driver.findElement(numberofProportions).sendKeys("2"); // الحصص المراد تملكها رقما
				Thread.sleep(Const*20);
				driver.findElement(NextToReviewSection).click();
				Thread.sleep(Const*20);
			//---------------------------Review Section ------------------------
				Thread.sleep(Const * 20);
				driver.findElement(submitRequest).click();
				Thread.sleep(Const * 50);
	}
	@Test
	// غير صحيح -   رقم المميز للمخطط
	public void Case5200() throws InterruptedException, IOException {
		// -----------------------------Applicant info-----------------------------

		Select ApplicantTypeDDL = new Select(driver.findElement(ApplicantType));
		ApplicantTypeDDL.selectByVisibleText(purchaser); // مشتري
		Thread.sleep(Const * 10);
		driver.findElement(ExpressRequestCheckBox).click(); //طلب مستعجل
		Thread.sleep(Const * 10);
		// نوع الموافقة
		driver.findElement(InternalRequestApprovalRadio).click();
		Select Purpose = new Select(driver.findElement(PurposeOfPossession)); // الغاية الرئيسية
		Purpose.selectByVisibleText(Residential);
		Thread.sleep(Const * 20);
		Select Purpose2 = new Select(driver.findElement(SecondaryPurposeOfPossession)); // الغاية الفرعية
		Purpose2.selectByVisibleText(Residence);
		// Next to Purchaser info
		Thread.sleep(Const*20);
		driver.findElement(nextToPurchaseInfo).click();
		// ---------------------------Purchaser info------------------------------
		// معلومات المشتري
		Thread.sleep(Const*20);
		driver.findElement(BuyerFields1).sendKeys(buyerInfoContent1);
		driver.findElement(BuyerFields2).sendKeys(buyerInfoContent2);
		driver.findElement(BuyerFields3).sendKeys(buyerInfoContent3);
		driver.findElement(BuyerFields4).sendKeys(buyerInfoContent4);
		Thread.sleep(Const);
		driver.findElement(nameasinPassport).sendKeys(nameasinPassportContent); // الاسم حسب جواز السفر
		Thread.sleep(Const);
		Select NationalityDDL = new Select(driver.findElement(nationality)); // الجنسية
		NationalityDDL.selectByVisibleText(Egyptian);
		Thread.sleep(Const);
		driver.findElement(phoneNumber).sendKeys(phoneNoContent); // رقم الهاتف
		Select CountryDDL = new Select(driver.findElement(CountryCode)); // الرمز الدولي
		CountryDDL.selectByVisibleText(code1);
		Thread.sleep(Const);
		Select passportTypeDDL = new Select(driver.findElement(passportType)); // نوع جواز السفر
		passportTypeDDL.selectByVisibleText(Permenant);
		Thread.sleep(Const);
		driver.findElement(passportNumber).sendKeys(passportNumberContent); // رقم جواز السفر
		Thread.sleep(Const);
		driver.findElement(productionDate).sendKeys(productionDateContent); // تاريخ الاصدار
		Thread.sleep(Const);
		driver.findElement(ExpiryDate).sendKeys(ExpiryDateContent); // تاريخ الانتهاء
		Thread.sleep(Const * 10);
		driver.findElement(productionLocation).sendKeys(productionLocationContent); // مكان الاصدار
		Thread.sleep(Const);

		Select arrivalCountryDDL = new Select(driver.findElement(arrivalCountry)); // بلد القدوم
		arrivalCountryDDL.selectByVisibleText(AbuDhabi);
		Thread.sleep(Const * 10);
		driver.findElement(placeOfBirth).sendKeys(placeOfBirthContent); // مكان الولادة
		Thread.sleep(Const * 10);
		driver.findElement(birthDate).sendKeys(dateOfBirthContent); // تاريخ الولادة
		Thread.sleep(Const * 10);
		driver.findElement(NoResidency).click(); // -نعم - لديك إقامة بالمملكة
		Thread.sleep(Const * 10);
		driver.findElement(noProperty).click(); // لا - هل لديك عقارات داخل المملكة؟
		Thread.sleep(Const * 10); 
		driver.findElement(currentResidenceAddress).sendKeys(currentResidenceAddressContent); // عنوان الإقامة الحالية
		Thread.sleep(Const);
		Select GenderDDL = new Select(driver.findElement(Gender)); // الجنس
		GenderDDL.selectByVisibleText(female); // أنثى
		Thread.sleep(Const * 10);
		Select SocialStatusDDL = new Select(driver.findElement(socialStatus)); // الحالة الاجتماعية
		SocialStatusDDL.selectByVisibleText(single); //أعزب
		//SocialStatusDDL.selectByVisibleText(married); // متزوج
		Thread.sleep(Const * 10);
		driver.findElement(job).sendKeys(JobContent); // عنوان الإقامة الحالية
		Thread.sleep(Const * 10);
		driver.findElement(registrationNo).sendKeys(registrationNoContent); // رقم الدخول
		Thread.sleep(Const);
		driver.findElement(additionalInfo).sendKeys(additionalInfoContent); // معلومات اضافية
		Thread.sleep(Const);
		driver.findElement(noOtherNationality).click();// - لا - جنسية أخرى
		Thread.sleep(Const);
		Select motherNationalityDDL = new Select(driver.findElement(motherNationality)); // جنسية الام
		motherNationalityDDL.selectByVisibleText(Jordanian);
		Thread.sleep(Const);

		driver.findElement(insideKigdom).click();// - نعم - هل المستدعى له داخل المملكة؟
		Thread.sleep(Const);
		// معلومات الام
		driver.findElement(MomFirstName).sendKeys(MomFirstNameContent);
		Thread.sleep(Const);
		driver.findElement(MomSecondName).sendKeys(MomSecondNameContent);
		Thread.sleep(Const);
		driver.findElement(MomThirdName).sendKeys(MomThirdNameContent);
		Thread.sleep(Const);
		driver.findElement(MomLastName).sendKeys(MomLastNameContent);
		   Thread.sleep(Const * 20);
		// ------------------------Purchaser InfoAttachments--------------------

//		driver.findElement(Passport).click(); //جواز السفر 
//		Thread.sleep(Const * 20);
//		Runtime.getRuntime().exec(AttachPath);
//		Thread.sleep(Const * 10);
//		Thread.sleep(Const * 10);
		   
			driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:pc1:t2:1:pgl50\"]/tbody/tr/td[3]/span")).click();
			Thread.sleep(Const * 20);
			Runtime.getRuntime().exec(AttachPath);
			Thread.sleep(Const * 10);			
			driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:pc1:t2:0:pgl50\"]/tbody/tr/td[3]/span")).click();
			Thread.sleep(Const * 20);
			Runtime.getRuntime().exec(AttachPath);
			Thread.sleep(Const * 10);			
		driver.findElement(nextToPrpertyInfoFromPurchaserInfo).click();
		// ---------------------Property & Seller Info ------------------------------
				Thread.sleep(Const * 10);
				driver.findElement(recordNo).sendKeys("1-6BAE1P"); // رقم القيد
				Thread.sleep(Const * 10);
				driver.findElement(DLSKeyButton).click();
				Thread.sleep(Const * 10);
				driver.findElement(schemeNo).sendKeys("522144"); // الرقم المميز للمخطط
				Thread.sleep(Const);
				driver.findElement(By.xpath("//*[@id=\"pt1:r1:3:pgl5\"]/div[4]")).click(); // click-anywhere-to-navigate-out
				Thread.sleep(Const*10);				
				// ----------------------Assert-Message-----------------------------------
				Thread.sleep(Const * 20);
				String ActualResult = driver.findElement(By.xpath("//*[@id=\"pt1:r1:3:m1\"]/div/table/tbody/tr/td/table/tbody/tr/td[2]/div")).getText();
				String ExpectedResult = "رمز المخطط غير صحيح";
				Assert.assertTrue(ActualResult.contains(ExpectedResult));
                System.out.print("Actual" + ActualResult);
                System.out.print("Expected" + ExpectedResult);               
				// capture-screenshot
				TakesScreenshot ts = (TakesScreenshot) driver;
				File source = ts.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(source, new File(".Screenshots/Case5.2.0.0.png"));			
	}
	
	@Test
//  نوع مقدم الطلب "وكيل مشتري"
	
    public void Case6000() throws InterruptedException, IOException {
		// -----------------------------Applicant info-----------------------------

		Select ApplicantTypeDDL = new Select(driver.findElement(ApplicantType));
		ApplicantTypeDDL.selectByVisibleText(SellerAgent); //  وكيل مشتري
		Thread.sleep(Const * 10);
		driver.findElement(judicialAgencyNo).sendKeys("555"); //*رقم الوكالة العدلية
		driver.findElement(judicialAgencyDate).sendKeys("2018/11/06");//*تاريخ الوكالة العدلية

		//driver.findElement(ExpressRequestCheckBox).click();
		Thread.sleep(Const * 10);

		// نوع الموافقة
		driver.findElement(InternalRequestApprovalRadio).click();
		Select Purpose = new Select(driver.findElement(PurposeOfPossession)); // الغاية الرئيسية
		Purpose.selectByVisibleText(Residential);
		Thread.sleep(Const * 20);
		Select Purpose2 = new Select(driver.findElement(SecondaryPurposeOfPossession)); // الغاية الفرعية
		Purpose2.selectByVisibleText(Residence);
		// Next to Purchaser info
		Thread.sleep(Const);
		
		driver.findElement(PowerofAttorney).click(); // صورة الوكالة العدلية
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		driver.findElement(nextToPurchaseInfo).click();

		// ---------------------------Purchaser info------------------------------
		// معلومات المشتري
		Thread.sleep(Const*20);

		driver.findElement(BuyerFields1).sendKeys(buyerInfoContent1);
		driver.findElement(BuyerFields2).sendKeys(buyerInfoContent2);
		driver.findElement(BuyerFields3).sendKeys(buyerInfoContent3);
		driver.findElement(BuyerFields4).sendKeys(buyerInfoContent4);
		Thread.sleep(Const);
		driver.findElement(nameasinPassport).sendKeys(nameasinPassportContent); // الاسم حسب جواز السفر
		Thread.sleep(Const);
		Select NationalityDDL = new Select(driver.findElement(nationality)); // الجنسية
		NationalityDDL.selectByVisibleText(Egyptian);
		Thread.sleep(Const);
		driver.findElement(phoneNumber).sendKeys(phoneNoContent); // رقم الهاتف
		Select CountryDDL = new Select(driver.findElement(CountryCode)); // الرمز الدولي
		CountryDDL.selectByVisibleText(code1);
		Thread.sleep(Const);
		Select passportTypeDDL = new Select(driver.findElement(passportType)); // نوع جواز السفر
		passportTypeDDL.selectByVisibleText(Permenant);
		Thread.sleep(Const);
		driver.findElement(passportNumber).sendKeys(passportNumberContent); // رقم جواز السفر
		Thread.sleep(Const);
		driver.findElement(productionDate).sendKeys(productionDateContent); // تاريخ الاصدار
		Thread.sleep(Const);
		driver.findElement(ExpiryDate).sendKeys(ExpiryDateContent); // تاريخ الانتهاء
		Thread.sleep(Const * 10);
		driver.findElement(productionLocation).sendKeys(productionLocationContent); // مكان الاصدار
		Thread.sleep(Const);

		Select arrivalCountryDDL = new Select(driver.findElement(arrivalCountry)); // بلد القدوم
		arrivalCountryDDL.selectByVisibleText(AbuDhabi);
		Thread.sleep(Const * 10);
		driver.findElement(placeOfBirth).sendKeys(placeOfBirthContent); // مكان الولادة
		Thread.sleep(Const * 10);
		driver.findElement(birthDate).sendKeys(dateOfBirthContent); // تاريخ الولادة
		Thread.sleep(Const * 10);
		driver.findElement(NoResidency).click(); // -نعم - لديك إقامة بالمملكة
		Thread.sleep(Const * 10);
		driver.findElement(noProperty).click(); // لا - هل لديك عقارات داخل المملكة؟
		Thread.sleep(Const * 10); 
		driver.findElement(currentResidenceAddress).sendKeys(currentResidenceAddressContent); // عنوان الإقامة الحالية
		Thread.sleep(Const);
		Select GenderDDL = new Select(driver.findElement(Gender)); // الجنس
		GenderDDL.selectByVisibleText(female); // أنثى
		Thread.sleep(Const * 10);
		Select SocialStatusDDL = new Select(driver.findElement(socialStatus)); // الحالة الاجتماعية
		SocialStatusDDL.selectByVisibleText(single); //أعزب
		//SocialStatusDDL.selectByVisibleText(married); // متزوج
		Thread.sleep(Const * 10);
		driver.findElement(job).sendKeys(JobContent); // عنوان الإقامة الحالية
		Thread.sleep(Const * 10);
		driver.findElement(registrationNo).sendKeys(registrationNoContent); // رقم الدخول
		Thread.sleep(Const);

		driver.findElement(additionalInfo).sendKeys(additionalInfoContent); // معلومات اضافية
		Thread.sleep(Const);

		driver.findElement(noOtherNationality).click();// - لا - جنسية أخرى
		Thread.sleep(Const);
		

		Select motherNationalityDDL = new Select(driver.findElement(motherNationality)); // جنسية الام
		motherNationalityDDL.selectByVisibleText(Jordanian);
		Thread.sleep(Const);

		driver.findElement(insideKigdom).click();// - نعم - هل المستدعى له داخل المملكة؟
		Thread.sleep(Const);
		// معلومات الام
		driver.findElement(MomFirstName).sendKeys(MomFirstNameContent);
		Thread.sleep(Const);
		driver.findElement(MomSecondName).sendKeys(MomSecondNameContent);
		Thread.sleep(Const);
		driver.findElement(MomThirdName).sendKeys(MomThirdNameContent);
		Thread.sleep(Const);
		driver.findElement(MomLastName).sendKeys(MomLastNameContent);
		   Thread.sleep(Const * 20);

		// ------------------------Purchaser InfoAttachments--------------------

//		driver.findElement(Others).click();
//		Thread.sleep(Const * 20);
//		Runtime.getRuntime().exec(AttachPath);
		driver.findElement(Passport).click(); //جواز السفر 
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 10);
		Thread.sleep(Const * 10);
	
		
		driver.findElement(nextToPrpertyInfoFromPurchaserInfo).click();
		// ---------------------Property & Seller Info ------------------------------
				Thread.sleep(Const * 10);

				driver.findElement(recordNo).sendKeys("1-6BAE1P"); // رقم القيد
				Thread.sleep(Const * 10);
				driver.findElement(DLSKeyButton).click();
				Thread.sleep(Const * 10);
				driver.findElement(schemeNo).sendKeys("1-6BAE1P"); // الرقم المميز للمخطط
				Thread.sleep(Const);
				driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pgl5\"]/div[4]")).click(); // click-anywhere-to-navigate-out
				Thread.sleep(Const*10);
				driver.findElement(NonJordanianOwner).click();
				driver.findElement(NonJordanianOwner).click();

				// ------------------------Property InfoAttachments--------------------

//				driver.findElement(Others2).click();
//				Thread.sleep(Const * 20);
//				Runtime.getRuntime().exec(AttachPath);
//				Thread.sleep(Const * 20);
				
				//--wrong Attachments
			 	driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pc1:t2:0:pgl50\"]/tbody/tr/td[3]/span")).click();
			    Thread.sleep(Const * 20);
				Runtime.getRuntime().exec(AttachPath);
				Thread.sleep(Const * 20);
				
				driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pc1:t2:1:pgl50\"]/tbody/tr/td[3]/span")).click();
				Thread.sleep(Const * 20);
				Runtime.getRuntime().exec(AttachPath);
				Thread.sleep(Const * 20);
					
				Thread.sleep(Const * 10);
				driver.findElement(NextToSellerAttach).click();

				//-------------------------Seller's Attachments----------------------

				driver.findElement(IDCardSeller).click();
				Thread.sleep(Const * 20);
				Runtime.getRuntime().exec(AttachPath);
				Thread.sleep(Const * 50);
				driver.findElement(NextToLinkPurchaserandSellers).click();

			   //--------------------------Link Purchaser with Seller----------------
				Thread.sleep(Const * 30);

				Select SellerName = new Select(driver.findElement(VendorName)); // اسم المشتري
				SellerName.selectByValue("1");
				Thread.sleep(Const);
				
				Select Properties = new Select(driver.findElement(PropertiesA2)); // العقارات
				Properties.selectByValue("1");
				Thread.sleep(Const);

				Select OwnerName = new Select(driver.findElement(ownerName)); //اسم المالك
				OwnerName.selectByValue("1");
				Thread.sleep(Const);
				
				driver.findElement(areatoBeOwnedNum).sendKeys("40"); //المساحة المراد تملكها رقما
				Thread.sleep(Const);
				
				driver.findElement(areatoBeOwned).sendKeys("40"); //المساحة المراد تملكها كتابة
				Thread.sleep(Const);
				
				driver.findElement(numberofProportions).sendKeys("2"); // الحصص المراد تملكها رقما
				Thread.sleep(Const*20);
				driver.findElement(NextToReviewSection).click();
				Thread.sleep(Const*20);
			//---------------------------Review Section ------------------------
				Thread.sleep(Const * 20);
				driver.findElement(submitRequest).click();
				Thread.sleep(Const * 50);
	}
	@Test
	//   نوع مقدم الطلب "بائع
	public void Case6100() throws InterruptedException, IOException {
		// -----------------------------Applicant info-----------------------------

		Select ApplicantTypeDDL = new Select(driver.findElement(ApplicantType));
		ApplicantTypeDDL.selectByVisibleText(Vendor); // بائع
		Thread.sleep(Const * 10);
		//driver.findElement(ExpressRequestCheckBox).click();
		Thread.sleep(Const * 10);

		// نوع الموافقة
		driver.findElement(InternalRequestApprovalRadio).click();
		Select Purpose = new Select(driver.findElement(PurposeOfPossession)); // الغاية الرئيسية
		Purpose.selectByVisibleText(Residential);
		Thread.sleep(Const * 20);
		Select Purpose2 = new Select(driver.findElement(SecondaryPurposeOfPossession)); // الغاية الفرعية
		Purpose2.selectByVisibleText(Residence);
		// Next to Purchaser info
		Thread.sleep(Const);
		
		driver.findElement(PowerofAttorney).click(); // صورة الوكالة العدلية
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		driver.findElement(nextToPurchaseInfo).click();

		// ---------------------------Purchaser info------------------------------
		// معلومات المشتري
		Thread.sleep(Const*20);

		driver.findElement(BuyerFields1).sendKeys(buyerInfoContent1);
		driver.findElement(BuyerFields2).sendKeys(buyerInfoContent2);
		driver.findElement(BuyerFields3).sendKeys(buyerInfoContent3);
		driver.findElement(BuyerFields4).sendKeys(buyerInfoContent4);
		Thread.sleep(Const);
		driver.findElement(nameasinPassport).sendKeys(nameasinPassportContent); // الاسم حسب جواز السفر
		Thread.sleep(Const);
		Select NationalityDDL = new Select(driver.findElement(nationality)); // الجنسية
		NationalityDDL.selectByVisibleText(Egyptian);
		Thread.sleep(Const);
		driver.findElement(phoneNumber).sendKeys(phoneNoContent); // رقم الهاتف
		Select CountryDDL = new Select(driver.findElement(CountryCode)); // الرمز الدولي
		CountryDDL.selectByVisibleText(code1);
		Thread.sleep(Const);
		Select passportTypeDDL = new Select(driver.findElement(passportType)); // نوع جواز السفر
		passportTypeDDL.selectByVisibleText(Permenant);
		Thread.sleep(Const);
		driver.findElement(passportNumber).sendKeys(passportNumberContent); // رقم جواز السفر
		Thread.sleep(Const);
		driver.findElement(productionDate).sendKeys(productionDateContent); // تاريخ الاصدار
		Thread.sleep(Const);
		driver.findElement(ExpiryDate).sendKeys(ExpiryDateContent); // تاريخ الانتهاء
		Thread.sleep(Const * 10);
		driver.findElement(productionLocation).sendKeys(productionLocationContent); // مكان الاصدار
		Thread.sleep(Const);

		Select arrivalCountryDDL = new Select(driver.findElement(arrivalCountry)); // بلد القدوم
		arrivalCountryDDL.selectByVisibleText(AbuDhabi);
		Thread.sleep(Const * 10);
		driver.findElement(placeOfBirth).sendKeys(placeOfBirthContent); // مكان الولادة
		Thread.sleep(Const * 10);
		driver.findElement(birthDate).sendKeys(dateOfBirthContent); // تاريخ الولادة
		Thread.sleep(Const * 10);
		driver.findElement(NoResidency).click(); // -نعم - لديك إقامة بالمملكة
		Thread.sleep(Const * 10);
		driver.findElement(noProperty).click(); // لا - هل لديك عقارات داخل المملكة؟
		Thread.sleep(Const * 10); 
		driver.findElement(currentResidenceAddress).sendKeys(currentResidenceAddressContent); // عنوان الإقامة الحالية
		Thread.sleep(Const);
		Select GenderDDL = new Select(driver.findElement(Gender)); // الجنس
		GenderDDL.selectByVisibleText(female); // أنثى
		Thread.sleep(Const * 10);
		Select SocialStatusDDL = new Select(driver.findElement(socialStatus)); // الحالة الاجتماعية
		SocialStatusDDL.selectByVisibleText(single); //أعزب
		//SocialStatusDDL.selectByVisibleText(married); // متزوج
		Thread.sleep(Const * 10);
		driver.findElement(job).sendKeys(JobContent); // عنوان الإقامة الحالية
		Thread.sleep(Const * 10);
		driver.findElement(registrationNo).sendKeys(registrationNoContent); // رقم الدخول
		Thread.sleep(Const);

		driver.findElement(additionalInfo).sendKeys(additionalInfoContent); // معلومات اضافية
		Thread.sleep(Const);

		driver.findElement(noOtherNationality).click();// - لا - جنسية أخرى
		Thread.sleep(Const);
		

		Select motherNationalityDDL = new Select(driver.findElement(motherNationality)); // جنسية الام
		motherNationalityDDL.selectByVisibleText(Jordanian);
		Thread.sleep(Const);

		driver.findElement(insideKigdom).click();// - نعم - هل المستدعى له داخل المملكة؟
		Thread.sleep(Const);
		// معلومات الام
		driver.findElement(MomFirstName).sendKeys(MomFirstNameContent);
		Thread.sleep(Const);
		driver.findElement(MomSecondName).sendKeys(MomSecondNameContent);
		Thread.sleep(Const);
		driver.findElement(MomThirdName).sendKeys(MomThirdNameContent);
		Thread.sleep(Const);
		driver.findElement(MomLastName).sendKeys(MomLastNameContent);
		   Thread.sleep(Const * 20);

		// ------------------------Purchaser InfoAttachments--------------------

//		driver.findElement(Others).click();
//		Thread.sleep(Const * 20);
//		Runtime.getRuntime().exec(AttachPath);
		driver.findElement(Passport).click(); //جواز السفر 
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec(AttachPath);
		Thread.sleep(Const * 10);
		Thread.sleep(Const * 10);
	
		
		driver.findElement(nextToPrpertyInfoFromPurchaserInfo).click();
		// ---------------------Property & Seller Info ------------------------------
				Thread.sleep(Const * 10);

				driver.findElement(recordNo).sendKeys("1-6BAE1P"); // رقم القيد
				Thread.sleep(Const * 10);
				driver.findElement(DLSKeyButton).click();
				Thread.sleep(Const * 10);
				driver.findElement(schemeNo).sendKeys("1-6BAE1P"); // الرقم المميز للمخطط
				Thread.sleep(Const);
				driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pgl5\"]/div[4]")).click(); // click-anywhere-to-navigate-out
				Thread.sleep(Const*10);
				driver.findElement(NonJordanianOwner).click();
				driver.findElement(NonJordanianOwner).click();

				// ------------------------Property InfoAttachments--------------------

//				driver.findElement(Others2).click();
//				Thread.sleep(Const * 20);
//				Runtime.getRuntime().exec(AttachPath);
//				Thread.sleep(Const * 20);
				
				//--wrong Attachments
			 	driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pc1:t2:0:pgl50\"]/tbody/tr/td[3]/span")).click();
			    Thread.sleep(Const * 20);
				Runtime.getRuntime().exec(AttachPath);
				Thread.sleep(Const * 20);
				
				driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pc1:t2:1:pgl50\"]/tbody/tr/td[3]/span")).click();
				Thread.sleep(Const * 20);
				Runtime.getRuntime().exec(AttachPath);
				Thread.sleep(Const * 20);
					
				Thread.sleep(Const * 10);
				driver.findElement(NextToSellerAttach).click();

				//-------------------------Seller's Attachments----------------------

				driver.findElement(IDCardSeller).click();
				Thread.sleep(Const * 20);
				Runtime.getRuntime().exec(AttachPath);
				Thread.sleep(Const * 50);
				driver.findElement(NextToLinkPurchaserandSellers).click();

			   //--------------------------Link Purchaser with Seller----------------
				Thread.sleep(Const * 30);

				Select SellerName = new Select(driver.findElement(VendorName)); // اسم المشتري
				SellerName.selectByValue("1");
				Thread.sleep(Const);
				Select Properties = new Select(driver.findElement(PropertiesA2)); // العقارات
				Properties.selectByValue("1");
				Thread.sleep(Const);

				Select OwnerName = new Select(driver.findElement(ownerName)); //اسم المالك
				OwnerName.selectByValue("1");
				Thread.sleep(Const);
				
				driver.findElement(areatoBeOwnedNum).sendKeys("40"); //المساحة المراد تملكها رقما
				Thread.sleep(Const);
				
				driver.findElement(areatoBeOwned).sendKeys("40"); //المساحة المراد تملكها كتابة
				Thread.sleep(Const);
				
				driver.findElement(numberofProportions).sendKeys("2"); // الحصص المراد تملكها رقما
				Thread.sleep(Const*20);
				driver.findElement(NextToReviewSection).click();
				Thread.sleep(Const*20);
			//---------------------------Review Section ------------------------
				Thread.sleep(Const * 20);
				driver.findElement(submitRequest).click();
				Thread.sleep(Const * 50);
	}

}
