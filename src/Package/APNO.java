package Package;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
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
	Thread.sleep(Const*50);

	
  }

  

 
 /* @Test
	// لغايات ادارة الاعمال
	public void Case1000() throws InterruptedException, IOException {
		// -----------------------------Applicant info-----------------------------

		Select ApplicantTypeDDL = new Select(driver.findElement(ApplicantType));
		ApplicantTypeDDL.selectByVisibleText(purchaser); // مشتري
		Thread.sleep(Const * 10);
		// نوع الموافقة
		driver.findElement(InternalRequestApprovalRadio).click();
		Select Purpose = new Select(driver.findElement(PurposeOfPossession)); // الغاية الرئيسية
		Purpose.selectByVisibleText(BussinessAdministration);
		Thread.sleep(Const * 20);
		Select Purpose2 = new Select(driver.findElement(SecondaryPurposeOfPossession)); // الغاية الفرعية
		Purpose2.selectByVisibleText(Residential);
		// رقم وطني للمنشأة
		driver.findElement(CoNationalNumber).sendKeys("987445215");
		// Next to Purchaser info
		Thread.sleep(Const);
		driver.findElement(nextToPurchaseInfo).click();

		// ---------------------------Purchaser info------------------------------

		// معلومات المشتري
		driver.findElement(buyerInfofield1).sendKeys(buyerInfofield1Content);
		driver.findElement(buyerInfofield2).sendKeys(buyerInfofield2Content);
		driver.findElement(buyerInfofield3).sendKeys(buyerInfofield3Content);
		driver.findElement(buyerInfofield4).sendKeys(buyerInfofield4Content);
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

		driver.findElement(Others).click();
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec("C:\\\\Users\\\\nftaiha\\\\Desktop\\\\attachemnts\\\\Uploader.exe");
		driver.findElement(Passport).click();
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec("C:\\\\Users\\\\nftaiha\\\\Desktop\\\\attachemnts\\\\Uploader.exe");
		Thread.sleep(Const * 10);

		Thread.sleep(Const * 10);
		driver.findElement(nextToPrpertyInfoFromPurchaserInfo).click();

		// ---------------------Property & Buyer Info ------------------------------
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
		Runtime.getRuntime().exec("C:\\\\Users\\\\nftaiha\\\\Desktop\\\\attachemnts\\\\Uploader.exe");
		Thread.sleep(Const * 20);
		driver.findElement(CoRegistrationCertificate).click();
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec("C:\\\\Users\\\\nftaiha\\\\Desktop\\\\attachemnts\\\\Uploader.exe");
		Thread.sleep(Const * 10);

		Thread.sleep(Const * 10);
		driver.findElement(NextToBuyerAttach).click();

		//-------------------------Buyer's Attachments----------------------

		driver.findElement(IDCardBuyer).click();
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec("C:\\\\Users\\\\nftaiha\\\\Desktop\\\\attachemnts\\\\Uploader.exe");
		Thread.sleep(Const * 20);
		
	   //--------------------------Link Purchaser with Buyer----------------
		Select BuyerName = new Select(driver.findElement(buyerName)); // اسم المشتري
		BuyerName.selectByValue("1");
		Thread.sleep(Const);
		
		Select Properties = new Select(driver.findElement(Properties2)); // العقارات
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
		Thread.sleep(Const);
		driver.findElement(nextToPurchaseInfo).click();

		// ---------------------------Purchaser info------------------------------

		// معلومات المشتري
		driver.findElement(buyerInfofield1).sendKeys(buyerInfofield1Content);
		driver.findElement(buyerInfofield2).sendKeys(buyerInfofield2Content);
		driver.findElement(buyerInfofield3).sendKeys(buyerInfofield3Content);
		driver.findElement(buyerInfofield4).sendKeys(buyerInfofield4Content);
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
		//SocialStatusDDL.selectByVisibleText(single); //أعزب
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

		// ------------------------Purchaser InfoAttachments--------------------

		Thread.sleep(Const * 10);
		driver.findElement(Passport).click();
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec("C:\\\\Users\\\\nftaiha\\\\Desktop\\\\attachemnts\\\\Uploader.exe");
		Thread.sleep(Const * 10);

		Thread.sleep(Const * 10);
		driver.findElement(NextToWifeHusbandScn).click();

		// ----------------------------------------Wife-HusbandInfo--------------------------------
		Select BuyerName1 = new Select(driver.findElement(BuyerName)); // اسم المشتري
		BuyerName1.selectByValue("0");
		Thread.sleep(Const * 10);
		
		//Add button 
		Thread.sleep(Const * 10);
		driver.findElement(addButton).click();
		// wife full name
		driver.findElement(spousefirstName).sendKeys("نوف");   
		Thread.sleep(Const);
		driver.findElement(spouseSecondName).sendKeys("هيثم");   
		Thread.sleep(Const);
		driver.findElement(spouseThirdName).sendKeys("ابراهيم");   
		Thread.sleep(Const);
		driver.findElement(spouseLastName).sendKeys("فتيحة");   
		Thread.sleep(Const);
	
		// nationality
		Select SpouseNationality = new Select(driver.findElement(spouseNationality)); // اسم المشتري
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
		
		Thread.sleep(Const * 10);
		driver.findElement(NextToPropertyScnfromWifeSCN).click();

		// ---------------------Property & Buyer Info ------------------------------
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
		Runtime.getRuntime().exec("C:\\\\Users\\\\nftaiha\\\\Desktop\\\\attachemnts\\\\Uploader.exe");
		Thread.sleep(Const * 20);
		driver.findElement(CoRegistrationCertificate).click();
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec("C:\\\\Users\\\\nftaiha\\\\Desktop\\\\attachemnts\\\\Uploader.exe");
		Thread.sleep(Const * 10);

		Thread.sleep(Const * 10);
		driver.findElement(NextToBuyerAttach).click();

		//-------------------------Buyer's Attachments----------------------

		driver.findElement(IDCardBuyer).click();
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec("C:\\\\Users\\\\nftaiha\\\\Desktop\\\\attachemnts\\\\Uploader.exe");
		Thread.sleep(Const * 20);
		
	   //--------------------------Link Purchaser with Buyer----------------
		Select BuyerName = new Select(driver.findElement(buyerName)); // اسم المشتري
		BuyerName.selectByValue("1");
		Thread.sleep(Const);
		
		Select Properties = new Select(driver.findElement(Properties2)); // العقارات
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
	// لغايات الزراعة
	public void Test() throws InterruptedException, IOException {
		// Applicant info

		Select ApplicantTypeDDL = new Select(driver.findElement(ApplicantType));
		ApplicantTypeDDL.selectByVisibleText(purchaser); // مشتري
		Thread.sleep(Const * 10);
		// نوع الموافقة
		driver.findElement(InternalRequestApprovalRadio).click();
		Select Purpose = new Select(driver.findElement(PurposeOfPossession)); // الغاية الرئيسية
		Purpose.selectByVisibleText(Agriculture);
		Thread.sleep(Const * 20);
		Select Purpose2 = new Select(driver.findElement(SecondaryPurposeOfPossession)); // الغاية الفرعية
		Purpose2.selectByVisibleText(AgriculturePurpose);
		// رقم وطني للمنشأة
		// driver.findElement(CoNationalNumber).sendKeys("987445215");
		// Next to Purchaser info
		Thread.sleep(Const * 10);
		driver.findElement(nextToPurchaseInfo).click();

		// Purchaser info
		// معلومات المشتري
		driver.findElement(buyerInfofield1).sendKeys(buyerInfofield1Content);
		driver.findElement(buyerInfofield2).sendKeys(buyerInfofield2Content);
		driver.findElement(buyerInfofield3).sendKeys(buyerInfofield3Content);
		driver.findElement(buyerInfofield4).sendKeys(buyerInfofield4Content);

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

		driver.findElement(NoResidency).click(); // لديك إقامة بالمملكة
		Thread.sleep(Const * 10);

		driver.findElement(noProperty).click(); // هل لديك عقارات داخل المملكة؟
		Thread.sleep(Const * 10);

		driver.findElement(currentResidenceAddress).sendKeys(currentResidenceAddressContent); // عنوان الإقامة الحالية
		Thread.sleep(Const);

		Select GenderDDL = new Select(driver.findElement(Gender)); // الجنس
		GenderDDL.selectByVisibleText(female);
		Thread.sleep(Const * 10);

		Select SocialStatusDDL = new Select(driver.findElement(socialStatus)); // الحالة الاجتماعية
		SocialStatusDDL.selectByVisibleText(single);
		Thread.sleep(Const * 10);

		driver.findElement(job).sendKeys(JobContent); // عنوان الإقامة الحالية
		Thread.sleep(Const * 10);

		driver.findElement(registrationNo).sendKeys(registrationNoContent); // رقم الدخول
		Thread.sleep(Const);

		driver.findElement(additionalInfo).sendKeys(additionalInfoContent); // معلومات اضافية
		Thread.sleep(Const);

		driver.findElement(noOtherNationality).click();// جنسية أخرى
		Thread.sleep(Const);

		Select motherNationalityDDL = new Select(driver.findElement(motherNationality)); // جنسية الام
		motherNationalityDDL.selectByVisibleText(Jordanian);
		Thread.sleep(Const);

		driver.findElement(insideKigdom).click();// هل المستدعى له داخل المملكة؟
		Thread.sleep(Const);
		// معلومات الام
		driver.findElement(MomFirstName).sendKeys(MomFirstNameContent);
		Thread.sleep(Const);
		driver.findElement(MomSecondName).sendKeys(MomSecondNameContent);
		Thread.sleep(Const);
		driver.findElement(MomThirdName).sendKeys(MomThirdNameContent);
		Thread.sleep(Const);
		driver.findElement(MomLastName).sendKeys(MomLastNameContent);
		Thread.sleep(Const * 10);
		// ---------------------------------Attachments--------------------------

		driver.findElement(IDCard).click();
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec("C:\\\\Users\\\\nftaiha\\\\Desktop\\\\attachemnts\\\\Uploader.exe");
		Thread.sleep(Const * 20);
		driver.findElement(Passport).click();
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec("C:\\\\Users\\\\nftaiha\\\\Desktop\\\\attachemnts\\\\Uploader.exe");
		Thread.sleep(Const * 10);

		driver.findElement(nextToPrpertyInfoFromPurchaserInfo).click();
		Thread.sleep(Const);
		// ------------------------Wife-Husband Info--------------------------------

		// ---------------------Property & Buyer Info ------------------------------
		driver.findElement(recordNo).sendKeys("1-6BAE1P"); // رقم القيد
		Thread.sleep(Const * 10);
		driver.findElement(DLSKeyButton).click();
		Thread.sleep(Const * 10);
		driver.findElement(schemeNo).sendKeys("1-6BAE1P"); // الرقم المميز للمخطط
		Thread.sleep(Const);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pgl5\"]/div[4]")).click(); // click-anywhere-to-navigate-out
		Thread.sleep(Const);
		driver.findElement(OwnersCheckbox).click();
	}*/

  
  @Test
  public void Case4000() throws InterruptedException, IOException {
		// Applicant info
 
	  driver.findElement(NonJordanianPropertyApproval).click(); // موافقات التملك لغير الاردنين
		Thread.sleep(Const*20);
		driver.findElement(verificationCode).sendKeys(verificationCodeContent); // رمز التحقق
		Thread.sleep(Const*50);
		
		driver.findElement(continueButton).click(); // استمرار
		Thread.sleep(Const*30);
		
		driver.findElement(ApprovalcheckBox).click();  // موافقة
		Thread.sleep(Const*20 );

		driver.findElement(nextButton).click(); //  التالي

		Thread.sleep(Const*20);

	  
		Select ApplicantTypeDDL = new Select(driver.findElement(ApplicantType));
		ApplicantTypeDDL.selectByVisibleText(purchaser); // مشتري
		Thread.sleep(Const * 20);
		// نوع الموافقة
		driver.findElement(InternalRequestApprovalRadio).click();
		Select Purpose = new Select(driver.findElement(PurposeOfPossession)); // الغاية الرئيسية
		Purpose.selectByVisibleText(Agriculture);
		Thread.sleep(Const * 20);
		Select Purpose2 = new Select(driver.findElement(SecondaryPurposeOfPossession)); // الغاية الفرعية
		Purpose2.selectByVisibleText(AgriculturePurpose);
		// رقم وطني للمنشأة
		// driver.findElement(CoNationalNumber).sendKeys("987445215");
		// Next to Purchaser info
		Thread.sleep(Const * 20);
		driver.findElement(nextToPurchaseInfo).click();
		Thread.sleep(Const * 20);
		// Purchaser info
		// معلومات المشتري
		driver.findElement(buyerInfofield1).sendKeys(buyerInfofield1Content);
		driver.findElement(buyerInfofield2).sendKeys(buyerInfofield2Content);
		driver.findElement(buyerInfofield3).sendKeys(buyerInfofield3Content);
		driver.findElement(buyerInfofield4).sendKeys(buyerInfofield4Content);

		Thread.sleep(Const * 20);
		driver.findElement(nameasinPassport).sendKeys(nameasinPassportContent); // الاسم حسب جواز السفر
		Thread.sleep(Const * 20);
		Select NationalityDDL = new Select(driver.findElement(nationality)); // الجنسية
		NationalityDDL.selectByVisibleText(emirates);
		Thread.sleep(Const * 20);
		driver.findElement(phoneNumber).sendKeys(phoneNoContent); // رقم الهاتف

		Select CountryDDL = new Select(driver.findElement(CountryCode)); // الرمز الدولي
		CountryDDL.selectByVisibleText(code1);
		Thread.sleep(Const*20);

		Select passportTypeDDL = new Select(driver.findElement(passportType)); // نوع جواز السفر
		passportTypeDDL.selectByVisibleText(Permenant);
		Thread.sleep(Const *20);

		driver.findElement(passportNumber).sendKeys(passportNumberContent); // رقم جواز السفر
		Thread.sleep(Const * 20);

		driver.findElement(productionDate).sendKeys(productionDateContent); // تاريخ الاصدار
		Thread.sleep(Const * 20);
		driver.findElement(ExpiryDate).sendKeys(ExpiryDateContent); // تاريخ الانتهاء
		Thread.sleep(Const * 10);

		driver.findElement(productionLocation).sendKeys(productionLocationContent); // مكان الاصدار
		Thread.sleep(Const* 20);

		Select arrivalCountryDDL = new Select(driver.findElement(arrivalCountry)); // بلد القدوم
		arrivalCountryDDL.selectByVisibleText(AbuDhabi);
		Thread.sleep(Const * 10);

		driver.findElement(placeOfBirth).sendKeys(placeOfBirthContent); // مكان الولادة
		Thread.sleep(Const * 10);

		driver.findElement(birthDate).sendKeys(dateOfBirthContent); // تاريخ الولادة
		Thread.sleep(Const * 10);

		driver.findElement(NoResidency).click(); // لديك إقامة بالمملكة
		Thread.sleep(Const * 10);

		driver.findElement(noProperty).click(); // هل لديك عقارات داخل المملكة؟
		Thread.sleep(Const * 10);

		driver.findElement(currentResidenceAddress).sendKeys(currentResidenceAddressContent); // عنوان الإقامة الحالية
		Thread.sleep(Const*20);

		Select GenderDDL = new Select(driver.findElement(Gender)); // الجنس
		GenderDDL.selectByVisibleText(female);
		Thread.sleep(Const * 10);

		Select SocialStatusDDL = new Select(driver.findElement(socialStatus)); // الحالة الاجتماعية
		SocialStatusDDL.selectByVisibleText(single);
		Thread.sleep(Const * 20);

		driver.findElement(job).sendKeys(JobContent); // المهنة
		Thread.sleep(Const * 20);

		driver.findElement(registrationNo).sendKeys(registrationNoContent); // رقم الدخول
		Thread.sleep(Const * 20 );

		driver.findElement(additionalInfo).sendKeys(additionalInfoContent); // معلومات اضافية
		Thread.sleep(Const * 20);

		driver.findElement(noOtherNationality).click();// جنسية أخرى
		Thread.sleep(Const*20);

		Select motherNationalityDDL = new Select(driver.findElement(motherNationality)); // جنسية الام
		motherNationalityDDL.selectByVisibleText(Jordanian);
		Thread.sleep(Const*20);

		driver.findElement(insideKigdom).click();// هل المستدعى له داخل المملكة؟
		Thread.sleep(Const * 20);
		// معلومات الام
		driver.findElement(MomFirstName).sendKeys(MomFirstNameContent);
		Thread.sleep(Const *20);
		driver.findElement(MomSecondName).sendKeys(MomSecondNameContent);
		Thread.sleep(Const * 20);
		driver.findElement(MomThirdName).sendKeys(MomThirdNameContent);
		Thread.sleep(Const * 20);
		driver.findElement(MomLastName).sendKeys(MomLastNameContent);
		Thread.sleep(Const * 30);
		// ---------------------------------Attachments--------------------------
		driver.findElement(IDCard).click();
		Thread.sleep(Const * 30);
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec("C:\\Users\\hrasheed\\Documents\\FileUploadFirfox.exe"); // Firefox
		Thread.sleep(Const * 40);
		
		driver.findElement(Passport).click();
		Thread.sleep(Const * 30);
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec("C:\\Users\\hrasheed\\Documents\\FileUploadFirfox.exe"); // Firefox
		Thread.sleep(Const * 40);

		driver.findElement(nextToPrpertyInfoFromPurchaserInfo).click();
		Thread.sleep(Const*30);
		// ------------------------Wife-Husband Info--------------------------------

		// ---------------------Property & Buyer Info ------------------------------
		driver.findElement(recordNo).sendKeys(recordNoContent); // رقم القيد
		Thread.sleep(Const * 20);
		driver.findElement(DLSKeyButton).click();
		Thread.sleep(Const * 20);
		driver.findElement(schemeNo).sendKeys(recordNoContent); // الرقم المميز للمخطط
		Thread.sleep(Const*20);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pgl5\"]/div[4]")).click(); // click-anywhere-to-navigate-out
		Thread.sleep(Const*20);
		driver.findElement(checkowners).click();
		Thread.sleep(Const*30);
		// --------------------------------Attachments---------------------------
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pc1:t2:0:pgl50\"]/tbody/tr/td[3]/span")).click(); //سند التسجيل
		Thread.sleep(Const * 50);
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec("C:\\Users\\hrasheed\\Documents\\FileUploadFirfox.exe");// FireFox
		Thread.sleep(Const * 50);
		
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pc1:t2:1:pgl50\"]/tbody/tr/td[3]/span")).click(); // مخطط الاراضي
		Thread.sleep(Const * 50);
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec("C:\\Users\\hrasheed\\Documents\\FileUploadFirfox.exe");// FireFox 
		Thread.sleep(Const * 50);
		
		driver.findElement(CoRegistrationCertificate).click(); // شهادة تسجيل الشركة
		Thread.sleep(Const * 50);
		
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec("C:\\Users\\hrasheed\\Documents\\FileUploadFirfox.exe"); // Firefox
		Thread.sleep(Const * 50);
		
		//driver.findElement(ProfessionLicense).click(); // رخصة المهن
		//Thread.sleep(Const * 50);
		
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		//Runtime.getRuntime().exec("C:\\Users\\hrasheed\\Documents\\FileUploadFirfox.exe"); // Firefox
	//	Thread.sleep(Const * 50); 
	
		driver.findElement(NextToBuyerAttach).click();
		Thread.sleep(Const * 50);
	//	--------------------------------------BuyerAttach-------------------
		
		Select PropertiesDDL = new Select(driver.findElement(Properties)); // العقارات
		PropertiesDDL.selectByValue("0");
		Thread.sleep(Const*20);
		
		
		Select OwnersDDL = new Select(driver.findElement(Owners)); // المالكين
		OwnersDDL.selectByValue("0");
		Thread.sleep(Const*20);
		
		driver.findElement(IDCard).click(); // هوية الاحوال المدنية
		Thread.sleep(Const * 50);
		
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec("C:\\Users\\hrasheed\\Documents\\FileUploadFirfox.exe"); // Firefox
		Thread.sleep(Const * 50);
		
		
		driver.findElement(NextToLinkPurchaserandBuyers).click(); 
		Thread.sleep(Const * 50);
		
	// -----------------------Link Purchaser with Buyers---------------------	
		
		Select buyerNameDDL = new Select(driver.findElement(buyerName)); // اسم المشتري
		buyerNameDDL.selectByValue("0");
		Thread.sleep(Const*20);
		
		Select PropertieslistDDL = new Select(driver.findElement(Propertieslist)); // االعقارات
		PropertieslistDDL.selectByValue("0");
		Thread.sleep(Const*20);
		
		Select ownerNametDDL = new Select(driver.findElement(ownerName)); // اسم المالك
		ownerNametDDL.selectByValue("0");
		Thread.sleep(Const*20);
		
		driver.findElement(areatoBeOwnedNum).sendKeys("123");
		Thread.sleep(Const*20);
		
		driver.findElement(areatoBeOwned).sendKeys("123");
		Thread.sleep(Const*20);
		
		driver.findElement(numberofProportions).sendKeys("4500");
		Thread.sleep(Const*50);
		
		driver.findElement(NextToReviewSection).click();
		driver.findElement(NextToReviewSection).click();
		Thread.sleep(Const*50);
		

		driver.findElement(submitRequest).click();
	
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
