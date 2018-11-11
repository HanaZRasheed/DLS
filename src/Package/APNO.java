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
	  
	//  System.setProperty("webdriver.chrome.driver", ChromeDriver);
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

 //------------------------------------------------------------------------------------------------------------- 
  @Test   //  التحقق من الجهة التنظيمية - الجهة التنظيمية أمانة عمان الكبري 
  public void Case4000() throws InterruptedException, IOException {
		// Applicant info
 
	  driver.findElement(NonJordanianPropertyApproval).click(); // موافقات التملك لغير الاردنين
		Thread.sleep(Const*20);
		driver.findElement(verificationCode).sendKeys(verificationCodeContent); // رمز التحقق
		Thread.sleep(Const*30);
		
		driver.findElement(continueButton).click(); // استمرار
		Thread.sleep(Const*30);
		
		driver.findElement(ApprovalcheckBox).click();  // موافقة
		Thread.sleep(Const*20 );

		driver.findElement(nextButton).click(); //  التالي

		Thread.sleep(Const*20);

	  
		Select ApplicantTypeDDL = new Select(driver.findElement(ApplicantType));
		ApplicantTypeDDL.selectByVisibleText(purchaser); // مشتري
		Thread.sleep(Const * 5);
		// نوع الموافقة
		driver.findElement(InternalRequestApprovalRadio).click();
		Select Purpose = new Select(driver.findElement(PurposeOfPossession)); // الغاية الرئيسية
		Purpose.selectByVisibleText(Agriculture);
		Thread.sleep(Const * 5);
		Select Purpose2 = new Select(driver.findElement(SecondaryPurposeOfPossession)); // الغاية الفرعية
		Purpose2.selectByVisibleText(AgriculturePurpose);
		// رقم وطني للمنشأة
		// driver.findElement(CoNationalNumber).sendKeys("987445215");
		// Next to Purchaser info
		Thread.sleep(Const * 5);
		driver.findElement(nextToPurchaseInfo).click();
		Thread.sleep(Const * 5);
		// Purchaser info
		// معلومات المشتري
		driver.findElement(buyerInfofield1).sendKeys(buyerInfofield1Content);
		driver.findElement(buyerInfofield2).sendKeys(buyerInfofield2Content);
		driver.findElement(buyerInfofield3).sendKeys(buyerInfofield3Content);
		driver.findElement(buyerInfofield4).sendKeys(buyerInfofield4Content);

		Thread.sleep(Const * 5);
		driver.findElement(nameasinPassport).sendKeys(nameasinPassportContent); // الاسم حسب جواز السفر
		Thread.sleep(Const * 10);
		Select NationalityDDL = new Select(driver.findElement(nationality)); // الجنسية
		NationalityDDL.selectByVisibleText(emirates);
		Thread.sleep(Const * 10);
		driver.findElement(phoneNumber).sendKeys(phoneNoContent); // رقم الهاتف

		Select CountryDDL = new Select(driver.findElement(CountryCode)); // الرمز الدولي
		CountryDDL.selectByVisibleText(code1);
		Thread.sleep(Const*20);

		Select passportTypeDDL = new Select(driver.findElement(passportType)); // نوع جواز السفر
		passportTypeDDL.selectByVisibleText(Permenant);
		Thread.sleep(Const *10);

		driver.findElement(passportNumber).sendKeys(passportNumberContent); // رقم جواز السفر
		Thread.sleep(Const * 5);

		driver.findElement(productionDate).sendKeys(productionDateContent); // تاريخ الاصدار
		Thread.sleep(Const * 5);
		driver.findElement(ExpiryDate).sendKeys(ExpiryDateContent); // تاريخ الانتهاء
		Thread.sleep(Const * 5);

		driver.findElement(productionLocation).sendKeys(productionLocationContent); // مكان الاصدار
		Thread.sleep(Const* 5);

		Select arrivalCountryDDL = new Select(driver.findElement(arrivalCountry)); // بلد القدوم
		arrivalCountryDDL.selectByVisibleText(AbuDhabi);
		Thread.sleep(Const *5);

		driver.findElement(placeOfBirth).sendKeys(placeOfBirthContent); // مكان الولادة
		Thread.sleep(Const * 5);

		driver.findElement(birthDate).sendKeys(dateOfBirthContent); // تاريخ الولادة
		Thread.sleep(Const * 5);

		driver.findElement(NoResidency).click(); // لديك إقامة بالمملكة
		Thread.sleep(Const * 10);

		driver.findElement(noProperty).click(); // هل لديك عقارات داخل المملكة؟
		Thread.sleep(Const * 5);

		driver.findElement(currentResidenceAddress).sendKeys(currentResidenceAddressContent); // عنوان الإقامة الحالية
		Thread.sleep(Const*5);

		Select GenderDDL = new Select(driver.findElement(Gender)); // الجنس
		GenderDDL.selectByVisibleText(female);
		Thread.sleep(Const * 5);

		Select SocialStatusDDL = new Select(driver.findElement(socialStatus)); // الحالة الاجتماعية
		SocialStatusDDL.selectByVisibleText(single);
		Thread.sleep(Const * 5);

		driver.findElement(job).sendKeys(JobContent); // المهنة
		Thread.sleep(Const * 5);

		driver.findElement(registrationNo).sendKeys(registrationNoContent); // رقم الدخول
		Thread.sleep(Const * 5 );

		driver.findElement(additionalInfo).sendKeys(additionalInfoContent); // معلومات اضافية
		Thread.sleep(Const * 5);

		driver.findElement(noOtherNationality).click();// جنسية أخرى
		Thread.sleep(Const*10);

		Select motherNationalityDDL = new Select(driver.findElement(motherNationality)); // جنسية الام
		motherNationalityDDL.selectByVisibleText(Jordanian);
		Thread.sleep(Const*10);

		driver.findElement(insideKigdom).click();// هل المستدعى له داخل المملكة؟
		Thread.sleep(Const *5);
		// معلومات الام
		driver.findElement(MomFirstName).sendKeys(MomFirstNameContent);
		Thread.sleep(Const *5);
		driver.findElement(MomSecondName).sendKeys(MomSecondNameContent);
		Thread.sleep(Const * 5);
		driver.findElement(MomThirdName).sendKeys(MomThirdNameContent);
		Thread.sleep(Const * 5);
		driver.findElement(MomLastName).sendKeys(MomLastNameContent);
		Thread.sleep(Const * 5);
		// ---------------------------------Attachments--------------------------
		driver.findElement(IDCard).click();
		Thread.sleep(Const * 30);
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
		Thread.sleep(Const * 40);
		
		driver.findElement(Passport).click();
		Thread.sleep(Const * 30);
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
		Thread.sleep(Const * 40);

		driver.findElement(nextToPrpertyInfoFromPurchaserInfo).click();
		Thread.sleep(Const*30);
		// ------------------------Wife-Husband Info--------------------------------

		// ---------------------Property & Buyer Info ------------------------------
		driver.findElement(recordNo).sendKeys(recordNoContentCase4000); // رقم القيد
		Thread.sleep(Const * 20);
		driver.findElement(DLSKeyButton).click();
		Thread.sleep(Const * 20);
		driver.findElement(schemeNo).sendKeys(recordNoContentCase4000); // الرقم المميز للمخطط
		Thread.sleep(Const*20);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pgl5\"]/div[4]")).click(); // click-anywhere-to-navigate-out
		Thread.sleep(Const*20);
		driver.findElement(checkownersA).click();
		Thread.sleep(Const*30);
		// --------------------------------Attachments---------------------------
	
		/*driver.findElement(ProfessionLicense).click(); // رخصة المهن
				Thread.sleep(Const * 50);
				
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
		Thread.sleep(Const * 50); 
	
		
		driver.findElement(CoRegistrationCertificate).click(); // شهادة تسجيل الشركة
		Thread.sleep(Const * 50);
		
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
		Thread.sleep(Const * 50);
		*/
		
	
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
		Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
		Thread.sleep(Const * 50);
		
		
		driver.findElement(NextToLinkPurchaserandBuyers).click(); 
		Thread.sleep(Const * 50);
		
	// -----------------------Link Purchaser with Buyers---------------------	
		
		Select buyerNameDDL = new Select(driver.findElement(buyerName)); // اسم المشتري
		buyerNameDDL.selectByValue("0");
		Thread.sleep(Const*10);
		
		Select PropertieslistDDL = new Select(driver.findElement(PropertiesA2)); // االعقارات
		PropertieslistDDL.selectByValue("0");
		Thread.sleep(Const*10);
		
		Select ownerNametDDL = new Select(driver.findElement(ownerName)); // اسم المالك
		ownerNametDDL.selectByValue("0");
		Thread.sleep(Const*10);
		
		driver.findElement(areatoBeOwnedNum).sendKeys("123");
		Thread.sleep(Const*10);
		
		driver.findElement(areatoBeOwned).sendKeys("123");
		Thread.sleep(Const*10);
		
		driver.findElement(numberofProportions).sendKeys("1");
		Thread.sleep(Const*20);
		
		driver.findElement(NextToReviewSection).click();
		driver.findElement(NextToReviewSection).click();
		Thread.sleep(Const*60);
		

		driver.findElement(submitRequest).click();
		Thread.sleep(Const*30);
		driver.findElement(agreeButton).click();
		Thread.sleep(Const*50);
		
		driver.findElement(feesDetails).click();
		Thread.sleep(Const*50);
		
	}
  
  
//-----------------------------------------------------------------------------------------------------------  
  
  
  
  @Test  // التحقق من الجهة التنظيمية - الجهة التنظيمية وزارة البلديات او هيئة تشجيع الاستثمار 
  public void Case4100() throws InterruptedException, IOException {
		// Applicant info
 
	  driver.findElement(NonJordanianPropertyApproval).click(); // موافقات التملك لغير الاردنين
		Thread.sleep(Const*20);
		driver.findElement(verificationCode).sendKeys(verificationCodeContent); // رمز التحقق
		Thread.sleep(Const*10);
		
		driver.findElement(continueButton).click(); // استمرار
		Thread.sleep(Const*60);
		
		driver.findElement(ApprovalcheckBox).click();  // موافقة
		Thread.sleep(Const*30 );

		driver.findElement(nextButton).click(); //  التالي

		Thread.sleep(Const*30);

	  
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

		Thread.sleep(Const * 5);
		driver.findElement(nameasinPassport).sendKeys(nameasinPassportContent); // الاسم حسب جواز السفر
		Thread.sleep(Const * 5);
		Select NationalityDDL = new Select(driver.findElement(nationality)); // الجنسية
		NationalityDDL.selectByVisibleText(emirates);
		Thread.sleep(Const * 5);
		driver.findElement(phoneNumber).sendKeys(phoneNoContent); // رقم الهاتف

		Select CountryDDL = new Select(driver.findElement(CountryCode)); // الرمز الدولي
		CountryDDL.selectByVisibleText(code1);
		Thread.sleep(Const*20);

		Select passportTypeDDL = new Select(driver.findElement(passportType)); // نوع جواز السفر
		passportTypeDDL.selectByVisibleText(Permenant);
		Thread.sleep(Const *20);

		driver.findElement(passportNumber).sendKeys(passportNumberContent); // رقم جواز السفر
		Thread.sleep(Const * 5);

		driver.findElement(productionDate).sendKeys(productionDateContent); // تاريخ الاصدار
		Thread.sleep(Const * 5);
		driver.findElement(ExpiryDate).sendKeys(ExpiryDateContent); // تاريخ الانتهاء
		Thread.sleep(Const * 5);

		driver.findElement(productionLocation).sendKeys(productionLocationContent); // مكان الاصدار
		Thread.sleep(Const* 5);

		Select arrivalCountryDDL = new Select(driver.findElement(arrivalCountry)); // بلد القدوم
		arrivalCountryDDL.selectByVisibleText(AbuDhabi);
		Thread.sleep(Const * 10);

		driver.findElement(placeOfBirth).sendKeys(placeOfBirthContent); // مكان الولادة
		Thread.sleep(Const * 5);

		driver.findElement(birthDate).sendKeys(dateOfBirthContent); // تاريخ الولادة
		Thread.sleep(Const * 5);

		driver.findElement(NoResidency).click(); // لديك إقامة بالمملكة
		Thread.sleep(Const * 5);

		driver.findElement(noProperty).click(); // هل لديك عقارات داخل المملكة؟
		Thread.sleep(Const * 5);

		driver.findElement(currentResidenceAddress).sendKeys(currentResidenceAddressContent); // عنوان الإقامة الحالية
		Thread.sleep(Const*5);

		Select GenderDDL = new Select(driver.findElement(Gender)); // الجنس
		GenderDDL.selectByVisibleText(female);
		Thread.sleep(Const * 10);

		Select SocialStatusDDL = new Select(driver.findElement(socialStatus)); // الحالة الاجتماعية
		SocialStatusDDL.selectByVisibleText(married);
		Thread.sleep(Const * 20);

		driver.findElement(job).sendKeys(JobContent); // المهنة
		Thread.sleep(Const * 20);

		driver.findElement(registrationNo).sendKeys(registrationNoContent); // رقم الدخول
		Thread.sleep(Const * 20 );

		driver.findElement(additionalInfo).sendKeys(additionalInfoContent); // معلومات اضافية
		Thread.sleep(Const * 20);

		driver.findElement(noOtherNationality).click();// جنسية أخرى
		Thread.sleep(Const*60);

		Select motherNationalityDDL = new Select(driver.findElement(motherNationality)); // جنسية الام
		motherNationalityDDL.selectByVisibleText(Jordanian);
		Thread.sleep(Const*20);

		driver.findElement(insideKigdom).click();// هل المستدعى له داخل المملكة؟
		Thread.sleep(Const * 5);
		// معلومات الام
		driver.findElement(MomFirstName).sendKeys(MomFirstNameContent);
		Thread.sleep(Const *5);
		driver.findElement(MomSecondName).sendKeys(MomSecondNameContent);
		Thread.sleep(Const * 5);
		driver.findElement(MomThirdName).sendKeys(MomThirdNameContent);
		Thread.sleep(Const * 5);
		driver.findElement(MomLastName).sendKeys(MomLastNameContent);
		Thread.sleep(Const * 5);
		// ---------------------------------Attachments--------------------------
		driver.findElement(IDCard).click();
		Thread.sleep(Const * 30);
	//	Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
		Thread.sleep(Const * 40);
		
		driver.findElement(Passport).click();
		Thread.sleep(Const * 30);
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
		Thread.sleep(Const * 40);

		
		driver.findElement(NextToWifeHusbandScn).click();
		Thread.sleep(Const*70);
		// ------------------------Wife-Husband Info--------------------------------
	
		
		driver.findElement(addSpouseInfoButton).click();
		Thread.sleep(Const*5);
		// معلومات الزوج او الزوجة 
		driver.findElement(spousefirstName).sendKeys(spousefirstNameContent); 
		Thread.sleep(Const*5);
		
		driver.findElement(spouseSecondName).sendKeys(spouseSecondNameContent); 
		Thread.sleep(Const*5);
		
		driver.findElement(spouseThirdName).sendKeys(spouseThirdNameContent); 
		Thread.sleep(Const*5);
		
		driver.findElement(spouseLastName).sendKeys(spouselastNameContent); 
		Thread.sleep(Const*10);
		
		Select spouseNationalityDDL = new Select(driver.findElement(spouseNationality)); // جنسية الزوجة 
		spouseNationalityDDL.selectByVisibleText(Jordanian); 
		Thread.sleep(Const);
	
		
		driver.findElement(spouseMomfirstName).sendKeys(spouseMomfirstNameContent); 
		Thread.sleep(Const*5);
		
		driver.findElement(spouseMomSecondName).sendKeys(spouseMomSecondNameContent); 
		Thread.sleep(Const*5);
		
		driver.findElement(spouseMomThirdName).sendKeys(spouseMomThirdNameContent); 
		Thread.sleep(Const*5);
		
		driver.findElement(spouseMomFourthName).sendKeys(spouseMomlastNameContent); 
		Thread.sleep(Const*10);
		
		Select spouseMomNationalityDDL = new Select(driver.findElement(spouseMomNationality)); // جنسية أم  الزوجة 
		spouseMomNationalityDDL.selectByVisibleText(Jordanian); 
		Thread.sleep(Const * 5);
		
		driver.findElement(NextToPropertyScnfromWifeSCN).click();
		Thread.sleep(Const*50);
		// ---------------------Property & Buyer Info ------------------------------
		
		
		driver.findElement(recordNo2).sendKeys(recordNoContentCase4100); // رقم القيد
		Thread.sleep(Const * 20);
		driver.findElement(DLSKeyButton2).click();
		Thread.sleep(Const * 20);
		driver.findElement(schemeNo2).sendKeys(recordNoContentCase4100); // الرقم المميز للمخطط
		Thread.sleep(Const*20);
		//driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pgl5\"]/div[4]")).click(); // click-anywhere-to-navigate-out
		Thread.sleep(Const*20);
		driver.findElement(checkownersA1).click();
		
		Thread.sleep(Const*30);
		// --------------------------------Attachments---------------------------
		driver.findElement(OrganizationalChart).click(); //مخطط موقع تنظيمي
		Thread.sleep(Const * 50);
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded);// FireFox
		Thread.sleep(Const * 50);
		

		driver.findElement(Lamane3).click(); //لا مانع
		Thread.sleep(Const * 50);
		
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
	Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
		Thread.sleep(Const * 50); 
	
		driver.findElement(NextToBuyerAttach2).click();
		Thread.sleep(Const * 50);
	//	--------------------------------------BuyerAttach-------------------
		
		Select PropertiesDDL = new Select(driver.findElement(Properties2)); // العقارات
		PropertiesDDL.selectByValue("0");
		Thread.sleep(Const*20);
		
		
		Select OwnersDDL = new Select(driver.findElement(Owners2)); // المالكين
		OwnersDDL.selectByValue("0");
		Thread.sleep(Const*30);
		
	
		Thread.sleep(Const*50);
		
		driver.findElement(FormalLetter).click();
		driver.findElement(FormalLetter).click();
		// كتاب رسمي
		Thread.sleep(Const * 50);
		
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
		Thread.sleep(Const * 50);
		
		
		driver.findElement(NextToLinkPurchaserandBuyes2).click(); 
		Thread.sleep(Const * 50);
		
		
	// -----------------------Link Purchaser with Buyers---------------------	
		
		Select buyerNameDDL = new Select(driver.findElement(buyerName2)); // اسم المشتري
		buyerNameDDL.selectByValue("0");
		Thread.sleep(Const*20);
		
		Select PropertieslistDDL = new Select(driver.findElement(PropertiesB2)); // االعقارات
		PropertieslistDDL.selectByValue("0");
		Thread.sleep(Const*20);
		
		Select ownerNametDDL = new Select(driver.findElement(ownerName2)); // اسم المالك
		ownerNametDDL.selectByValue("0");
		Thread.sleep(Const*20);
		
		driver.findElement(areatoBeOwnedNum2).sendKeys("123");
		Thread.sleep(Const*20);
		
		driver.findElement(areatoBeOwned2).sendKeys("123");
		Thread.sleep(Const*20);
		
		driver.findElement(numberofProportions2).sendKeys("1");
		Thread.sleep(Const*50);
		
		driver.findElement(NextToReviewSection2).click();
		driver.findElement(NextToReviewSection2).click();
		Thread.sleep(Const*60);
		

		driver.findElement(submitRequest2).click();
		Thread.sleep(Const*30);
		
	
	}

  @Test  // التحقق من الجهة التنظيمية - الجهة التنظيمية سلطة وادي الاردن 
  public void Case4200() throws InterruptedException, IOException {
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
		Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
		Thread.sleep(Const * 40);
		
		driver.findElement(Passport).click();
		Thread.sleep(Const * 30);
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
		Thread.sleep(Const * 40);

		driver.findElement(nextToPrpertyInfoFromPurchaserInfo).click();
		Thread.sleep(Const*30);
		// ------------------------Wife-Husband Info--------------------------------

		// ---------------------Property & Buyer Info ------------------------------
		driver.findElement(recordNo).sendKeys(recordNoContentCase4200); // رقم القيد
		Thread.sleep(Const * 20);
		driver.findElement(DLSKeyButton).click();
		Thread.sleep(Const * 20);
		driver.findElement(schemeNo).sendKeys(recordNoContentCase4200); // الرقم المميز للمخطط
		Thread.sleep(Const*20);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pgl5\"]/div[4]")).click(); // click-anywhere-to-navigate-out
		Thread.sleep(Const*20);
		driver.findElement(checkownersA).click();
		Thread.sleep(Const*30);
		// --------------------------------Attachments---------------------------
		driver.findElement(OrganizationalChart).click(); //مخطط موقع تنظيمي
		Thread.sleep(Const * 50);
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded);// FireFox
		Thread.sleep(Const * 50);
		
		driver.findElement(Lamane3).click(); // لا مانع
		Thread.sleep(Const * 50);
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded);// FireFox 
		Thread.sleep(Const * 50);
		
		driver.findElement(NextToBuyerAttach).click();
		Thread.sleep(Const * 50);
	//	--------------------------------------BuyerAttach-------------------
		
		Select PropertiesDDL = new Select(driver.findElement(Properties)); // العقارات
		PropertiesDDL.selectByValue("0");
		Thread.sleep(Const*20);
		
		
		Select OwnersDDL = new Select(driver.findElement(Owners)); // المالكين
		OwnersDDL.selectByValue("0");
		Thread.sleep(Const*30);
		
		driver.findElement(FormalLetter).click();
		// كتاب رسمي
		Thread.sleep(Const * 50);
		
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
		Thread.sleep(Const * 50);
		
		
		driver.findElement(NextToLinkPurchaserandBuyers).click(); 
		Thread.sleep(Const * 50);
		
		
		
	// -----------------------Link Purchaser with Buyers---------------------	
		
		Select buyerNameDDL = new Select(driver.findElement(buyerName)); // اسم المشتري
		buyerNameDDL.selectByValue("0");
		Thread.sleep(Const*20);
		
		Select PropertieslistDDL = new Select(driver.findElement(PropertiesA2)); // االعقارات
		PropertieslistDDL.selectByValue("0");
		Thread.sleep(Const*20);
		
		Select ownerNametDDL = new Select(driver.findElement(ownerName)); // اسم المالك
		ownerNametDDL.selectByValue("0");
		Thread.sleep(Const*20);
		
		driver.findElement(areatoBeOwnedNum).sendKeys("123");
		Thread.sleep(Const*20);
		
		driver.findElement(areatoBeOwned).sendKeys("123");
		Thread.sleep(Const*20);
		
		driver.findElement(numberofProportions).sendKeys("1");
		Thread.sleep(Const*50);
		
		driver.findElement(NextToReviewSection).click();
		driver.findElement(NextToReviewSection).click();
		Thread.sleep(Const*60);
		
		driver.findElement(submitRequest).click();
		Thread.sleep(Const*30);
	
	}
  
  
  //--------------------------------------------
  @Test  // التحقق من الجهة التنظيمية - الجهة التنظيمية سلطة اقليم العقبة 
  public void Case4300() throws InterruptedException, IOException {
			// Applicant info
	 
		  driver.findElement(NonJordanianPropertyApproval).click(); // موافقات التملك لغير الاردنين
			Thread.sleep(Const*20);
			driver.findElement(verificationCode).sendKeys(verificationCodeContent); // رمز التحقق
			Thread.sleep(Const*30);
			
			driver.findElement(continueButton).click(); // استمرار
			Thread.sleep(Const*30);
			
			driver.findElement(ApprovalcheckBox).click();  // موافقة
			Thread.sleep(Const*20 );

			driver.findElement(nextButton).click(); //  التالي

			Thread.sleep(Const*20);

		  
			Select ApplicantTypeDDL = new Select(driver.findElement(ApplicantType));
			ApplicantTypeDDL.selectByVisibleText(purchaser); // مشتري
			Thread.sleep(Const * 5);
			// نوع الموافقة
			driver.findElement(InternalRequestApprovalRadio).click();
			Select Purpose = new Select(driver.findElement(PurposeOfPossession)); // الغاية الرئيسية
			Purpose.selectByVisibleText(Agriculture);
			Thread.sleep(Const * 5);
			Select Purpose2 = new Select(driver.findElement(SecondaryPurposeOfPossession)); // الغاية الفرعية
			Purpose2.selectByVisibleText(AgriculturePurpose);
			// رقم وطني للمنشأة
			// driver.findElement(CoNationalNumber).sendKeys("987445215");
			// Next to Purchaser info
			Thread.sleep(Const * 5);
			driver.findElement(nextToPurchaseInfo).click();
			Thread.sleep(Const * 5);
			// Purchaser info
			// معلومات المشتري
			driver.findElement(buyerInfofield1).sendKeys(buyerInfofield1Content);
			driver.findElement(buyerInfofield2).sendKeys(buyerInfofield2Content);
			driver.findElement(buyerInfofield3).sendKeys(buyerInfofield3Content);
			driver.findElement(buyerInfofield4).sendKeys(buyerInfofield4Content);

			Thread.sleep(Const * 5);
			driver.findElement(nameasinPassport).sendKeys(nameasinPassportContent); // الاسم حسب جواز السفر
			Thread.sleep(Const * 10);
			Select NationalityDDL = new Select(driver.findElement(nationality)); // الجنسية
			NationalityDDL.selectByVisibleText(emirates);
			Thread.sleep(Const * 10);
			driver.findElement(phoneNumber).sendKeys(phoneNoContent); // رقم الهاتف

			Select CountryDDL = new Select(driver.findElement(CountryCode)); // الرمز الدولي
			CountryDDL.selectByVisibleText(code1);
			Thread.sleep(Const*20);

			Select passportTypeDDL = new Select(driver.findElement(passportType)); // نوع جواز السفر
			passportTypeDDL.selectByVisibleText(Permenant);
			Thread.sleep(Const *10);

			driver.findElement(passportNumber).sendKeys(passportNumberContent); // رقم جواز السفر
			Thread.sleep(Const * 5);

			driver.findElement(productionDate).sendKeys(productionDateContent); // تاريخ الاصدار
			Thread.sleep(Const * 5);
			driver.findElement(ExpiryDate).sendKeys(ExpiryDateContent); // تاريخ الانتهاء
			Thread.sleep(Const * 5);

			driver.findElement(productionLocation).sendKeys(productionLocationContent); // مكان الاصدار
			Thread.sleep(Const* 5);

			Select arrivalCountryDDL = new Select(driver.findElement(arrivalCountry)); // بلد القدوم
			arrivalCountryDDL.selectByVisibleText(AbuDhabi);
			Thread.sleep(Const *5);

			driver.findElement(placeOfBirth).sendKeys(placeOfBirthContent); // مكان الولادة
			Thread.sleep(Const * 5);

			driver.findElement(birthDate).sendKeys(dateOfBirthContent); // تاريخ الولادة
			Thread.sleep(Const * 5);

			driver.findElement(NoResidency).click(); // لديك إقامة بالمملكة
			Thread.sleep(Const * 10);

			driver.findElement(noProperty).click(); // هل لديك عقارات داخل المملكة؟
			Thread.sleep(Const * 5);

			driver.findElement(currentResidenceAddress).sendKeys(currentResidenceAddressContent); // عنوان الإقامة الحالية
			Thread.sleep(Const*5);

			Select GenderDDL = new Select(driver.findElement(Gender)); // الجنس
			GenderDDL.selectByVisibleText(female);
			Thread.sleep(Const * 5);

			Select SocialStatusDDL = new Select(driver.findElement(socialStatus)); // الحالة الاجتماعية
			SocialStatusDDL.selectByVisibleText(single);
			Thread.sleep(Const * 5);

			driver.findElement(job).sendKeys(JobContent); // المهنة
			Thread.sleep(Const * 5);

			driver.findElement(registrationNo).sendKeys(registrationNoContent); // رقم الدخول
			Thread.sleep(Const * 5 );

			driver.findElement(additionalInfo).sendKeys(additionalInfoContent); // معلومات اضافية
			Thread.sleep(Const * 5);

			driver.findElement(noOtherNationality).click();// جنسية أخرى
			Thread.sleep(Const*10);

			Select motherNationalityDDL = new Select(driver.findElement(motherNationality)); // جنسية الام
			motherNationalityDDL.selectByVisibleText(Jordanian);
			Thread.sleep(Const*10);

			driver.findElement(insideKigdom).click();// هل المستدعى له داخل المملكة؟
			Thread.sleep(Const *5);
			// معلومات الام
			driver.findElement(MomFirstName).sendKeys(MomFirstNameContent);
			Thread.sleep(Const *5);
			driver.findElement(MomSecondName).sendKeys(MomSecondNameContent);
			Thread.sleep(Const * 5);
			driver.findElement(MomThirdName).sendKeys(MomThirdNameContent);
			Thread.sleep(Const * 5);
			driver.findElement(MomLastName).sendKeys(MomLastNameContent);
			Thread.sleep(Const * 5);
			// ---------------------------------Attachments--------------------------
			driver.findElement(IDCard).click();
			Thread.sleep(Const * 30);
			//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
			Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
			Thread.sleep(Const * 40);
			
			driver.findElement(Passport).click();
			Thread.sleep(Const * 30);
			//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
			Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
			Thread.sleep(Const * 40);

			driver.findElement(nextToPrpertyInfoFromPurchaserInfo).click();
			Thread.sleep(Const*30);
			// ------------------------Wife-Husband Info--------------------------------

			// ---------------------Property & Buyer Info ------------------------------
			driver.findElement(recordNo).sendKeys(recordNoContentCase4300); // رقم القيد
			Thread.sleep(Const * 20);
			driver.findElement(DLSKeyButton).click();
			Thread.sleep(Const * 20);
			driver.findElement(schemeNo).sendKeys(recordNoContentCase4300); // الرقم المميز للمخطط
			Thread.sleep(Const*20);
			driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pgl5\"]/div[4]")).click(); // click-anywhere-to-navigate-out
			Thread.sleep(Const*20);
			driver.findElement(checkownersA).click();
			Thread.sleep(Const*30);
			// --------------------------------Attachments---------------------------
		
			driver.findElement(OrganizationalChart).click(); //مخطط موقع تنظيمي
			Thread.sleep(Const * 50);
			//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
			Runtime.getRuntime().exec(FiletobeUploaded);// FireFox
			Thread.sleep(Const * 50);
			
		
			driver.findElement(NextToBuyerAttach).click();
			Thread.sleep(Const * 50);
		//	--------------------------------------BuyerAttach-------------------
			
		/*	Select PropertiesDDL = new Select(driver.findElement(Properties)); // العقارات
			PropertiesDDL.selectByValue("0");
			Thread.sleep(Const*20);
			
			
			Select OwnersDDL = new Select(driver.findElement(Owners)); // المالكين
			OwnersDDL.selectByValue("0");
			Thread.sleep(Const*20);
			
			driver.findElement(IDCard).click(); // هوية الاحوال المدنية
			Thread.sleep(Const * 50);
			
			//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
			Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
			Thread.sleep(Const * 50);
			
			
			driver.findElement(NextToLinkPurchaserandBuyers).click(); 
			Thread.sleep(Const * 50);
			
		// -----------------------Link Purchaser with Buyers---------------------	
			
			Select buyerNameDDL = new Select(driver.findElement(buyerName)); // اسم المشتري
			buyerNameDDL.selectByValue("0");
			Thread.sleep(Const*10);
			
			Select PropertieslistDDL = new Select(driver.findElement(PropertiesA2)); // االعقارات
			PropertieslistDDL.selectByValue("0");
			Thread.sleep(Const*10);
			
			Select ownerNametDDL = new Select(driver.findElement(ownerName)); // اسم المالك
			ownerNametDDL.selectByValue("0");
			Thread.sleep(Const*10);
			
			driver.findElement(areatoBeOwnedNum).sendKeys("123");
			Thread.sleep(Const*10);
			
			driver.findElement(areatoBeOwned).sendKeys("123");
			Thread.sleep(Const*10);
			
			driver.findElement(numberofProportions).sendKeys("1");
			Thread.sleep(Const*20);
			
			driver.findElement(NextToReviewSection).click();
			driver.findElement(NextToReviewSection).click();
			Thread.sleep(Const*60);
			

			driver.findElement(submitRequest).click();
			Thread.sleep(Const*30);
			driver.findElement(agreeButton).click();
			Thread.sleep(Const*50);
			
			driver.findElement(feesDetails).click();
			Thread.sleep(Const*50);
			*/
		}
	  
  @Test  // التحقق من الجهة التنظيمية - الجهة التنظيمية سلطة اقليم البتراء 
  public void Case4400() throws InterruptedException, IOException {
			// Applicant info
	 
		  driver.findElement(NonJordanianPropertyApproval).click(); // موافقات التملك لغير الاردنين
			Thread.sleep(Const*20);
			driver.findElement(verificationCode).sendKeys(verificationCodeContent); // رمز التحقق
			Thread.sleep(Const*30);
			
			driver.findElement(continueButton).click(); // استمرار
			Thread.sleep(Const*30);
			
			driver.findElement(ApprovalcheckBox).click();  // موافقة
			Thread.sleep(Const*20 );

			driver.findElement(nextButton).click(); //  التالي

			Thread.sleep(Const*20);

		  
			Select ApplicantTypeDDL = new Select(driver.findElement(ApplicantType));
			ApplicantTypeDDL.selectByVisibleText(purchaser); // مشتري
			Thread.sleep(Const * 5);
			// نوع الموافقة
			driver.findElement(InternalRequestApprovalRadio).click();
			Select Purpose = new Select(driver.findElement(PurposeOfPossession)); // الغاية الرئيسية
			Purpose.selectByVisibleText(Agriculture);
			Thread.sleep(Const * 5);
			Select Purpose2 = new Select(driver.findElement(SecondaryPurposeOfPossession)); // الغاية الفرعية
			Purpose2.selectByVisibleText(AgriculturePurpose);
			// رقم وطني للمنشأة
			// driver.findElement(CoNationalNumber).sendKeys("987445215");
			// Next to Purchaser info
			Thread.sleep(Const * 5);
			driver.findElement(nextToPurchaseInfo).click();
			Thread.sleep(Const * 5);
			// Purchaser info
			// معلومات المشتري
			driver.findElement(buyerInfofield1).sendKeys(buyerInfofield1Content);
			driver.findElement(buyerInfofield2).sendKeys(buyerInfofield2Content);
			driver.findElement(buyerInfofield3).sendKeys(buyerInfofield3Content);
			driver.findElement(buyerInfofield4).sendKeys(buyerInfofield4Content);

			Thread.sleep(Const * 5);
			driver.findElement(nameasinPassport).sendKeys(nameasinPassportContent); // الاسم حسب جواز السفر
			Thread.sleep(Const * 10);
			Select NationalityDDL = new Select(driver.findElement(nationality)); // الجنسية
			NationalityDDL.selectByVisibleText(emirates);
			Thread.sleep(Const * 10);
			driver.findElement(phoneNumber).sendKeys(phoneNoContent); // رقم الهاتف

			Select CountryDDL = new Select(driver.findElement(CountryCode)); // الرمز الدولي
			CountryDDL.selectByVisibleText(code1);
			Thread.sleep(Const*20);

			Select passportTypeDDL = new Select(driver.findElement(passportType)); // نوع جواز السفر
			passportTypeDDL.selectByVisibleText(Permenant);
			Thread.sleep(Const *10);

			driver.findElement(passportNumber).sendKeys(passportNumberContent); // رقم جواز السفر
			Thread.sleep(Const * 5);

			driver.findElement(productionDate).sendKeys(productionDateContent); // تاريخ الاصدار
			Thread.sleep(Const * 5);
			driver.findElement(ExpiryDate).sendKeys(ExpiryDateContent); // تاريخ الانتهاء
			Thread.sleep(Const * 5);

			driver.findElement(productionLocation).sendKeys(productionLocationContent); // مكان الاصدار
			Thread.sleep(Const* 5);

			Select arrivalCountryDDL = new Select(driver.findElement(arrivalCountry)); // بلد القدوم
			arrivalCountryDDL.selectByVisibleText(AbuDhabi);
			Thread.sleep(Const *5);

			driver.findElement(placeOfBirth).sendKeys(placeOfBirthContent); // مكان الولادة
			Thread.sleep(Const * 5);

			driver.findElement(birthDate).sendKeys(dateOfBirthContent); // تاريخ الولادة
			Thread.sleep(Const * 5);

			driver.findElement(NoResidency).click(); // لديك إقامة بالمملكة
			Thread.sleep(Const * 10);

			driver.findElement(noProperty).click(); // هل لديك عقارات داخل المملكة؟
			Thread.sleep(Const * 5);

			driver.findElement(currentResidenceAddress).sendKeys(currentResidenceAddressContent); // عنوان الإقامة الحالية
			Thread.sleep(Const*5);

			Select GenderDDL = new Select(driver.findElement(Gender)); // الجنس
			GenderDDL.selectByVisibleText(female);
			Thread.sleep(Const * 5);

			Select SocialStatusDDL = new Select(driver.findElement(socialStatus)); // الحالة الاجتماعية
			SocialStatusDDL.selectByVisibleText(single);
			Thread.sleep(Const * 5);

			driver.findElement(job).sendKeys(JobContent); // المهنة
			Thread.sleep(Const * 5);

			driver.findElement(registrationNo).sendKeys(registrationNoContent); // رقم الدخول
			Thread.sleep(Const * 5 );

			driver.findElement(additionalInfo).sendKeys(additionalInfoContent); // معلومات اضافية
			Thread.sleep(Const * 5);

			driver.findElement(noOtherNationality).click();// جنسية أخرى
			Thread.sleep(Const*10);

			Select motherNationalityDDL = new Select(driver.findElement(motherNationality)); // جنسية الام
			motherNationalityDDL.selectByVisibleText(Jordanian);
			Thread.sleep(Const*10);

			driver.findElement(insideKigdom).click();// هل المستدعى له داخل المملكة؟
			Thread.sleep(Const *5);
			// معلومات الام
			driver.findElement(MomFirstName).sendKeys(MomFirstNameContent);
			Thread.sleep(Const *5);
			driver.findElement(MomSecondName).sendKeys(MomSecondNameContent);
			Thread.sleep(Const * 5);
			driver.findElement(MomThirdName).sendKeys(MomThirdNameContent);
			Thread.sleep(Const * 5);
			driver.findElement(MomLastName).sendKeys(MomLastNameContent);
			Thread.sleep(Const * 5);
			// ---------------------------------Attachments--------------------------
			driver.findElement(IDCard).click();
			Thread.sleep(Const * 30);
			//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
			Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
			Thread.sleep(Const * 40);
			
			driver.findElement(Passport).click();
			Thread.sleep(Const * 30);
			//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
			Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
			Thread.sleep(Const * 40);

			driver.findElement(nextToPrpertyInfoFromPurchaserInfo).click();
			Thread.sleep(Const*30);
			// ------------------------Wife-Husband Info--------------------------------

			// ---------------------Property & Buyer Info ------------------------------
			driver.findElement(recordNo).sendKeys(recordNoContentCase4400); // رقم القيد
			Thread.sleep(Const * 20);
			driver.findElement(DLSKeyButton).click();
			Thread.sleep(Const * 20);
			driver.findElement(schemeNo).sendKeys(recordNoContentCase4400); // الرقم المميز للمخطط
			Thread.sleep(Const*20);
			driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pgl5\"]/div[4]")).click(); // click-anywhere-to-navigate-out
			Thread.sleep(Const*20);
			driver.findElement(checkownersA).click();
			Thread.sleep(Const*50);
			// --------------------------------Attachments---------------------------
			
			driver.findElement(OrganizationalChart).click(); //مخطط موقع تنظيمي
					Thread.sleep(Const * 50);
					
			//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
			Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
			Thread.sleep(Const * 50); 
		
			/*
			driver.findElement(CoRegistrationCertificate).click(); // شهادة تسجيل الشركة
			Thread.sleep(Const * 50);
			
			//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
			Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
			Thread.sleep(Const * 50);
			*/
			
		
			driver.findElement(NextToBuyerAttach).click();
			Thread.sleep(Const * 50);
		//	--------------------------------------BuyerAttach-------------------
			
		/*	Select PropertiesDDL = new Select(driver.findElement(Properties)); // العقارات
			PropertiesDDL.selectByValue("0");
			Thread.sleep(Const*20);
			
			
			Select OwnersDDL = new Select(driver.findElement(Owners)); // المالكين
			OwnersDDL.selectByValue("0");
			Thread.sleep(Const*20);
			
			driver.findElement(IDCard).click(); // هوية الاحوال المدنية
			Thread.sleep(Const * 50);
			
			//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
			Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
			Thread.sleep(Const * 50);
			
			
			driver.findElement(NextToLinkPurchaserandBuyers).click(); 
			Thread.sleep(Const * 50);
			
		// -----------------------Link Purchaser with Buyers---------------------	
			
			Select buyerNameDDL = new Select(driver.findElement(buyerName)); // اسم المشتري
			buyerNameDDL.selectByValue("0");
			Thread.sleep(Const*10);
			
			Select PropertieslistDDL = new Select(driver.findElement(PropertiesA2)); // االعقارات
			PropertieslistDDL.selectByValue("0");
			Thread.sleep(Const*10);
			
			Select ownerNametDDL = new Select(driver.findElement(ownerName)); // اسم المالك
			ownerNametDDL.selectByValue("0");
			Thread.sleep(Const*10);
			
			driver.findElement(areatoBeOwnedNum).sendKeys("123");
			Thread.sleep(Const*10);
			
			driver.findElement(areatoBeOwned).sendKeys("123");
			Thread.sleep(Const*10);
			
			driver.findElement(numberofProportions).sendKeys("1");
			Thread.sleep(Const*20);
			
			driver.findElement(NextToReviewSection).click();
			driver.findElement(NextToReviewSection).click();
			Thread.sleep(Const*60);
			

			driver.findElement(submitRequest).click();
			Thread.sleep(Const*30);
			driver.findElement(agreeButton).click();
			Thread.sleep(Const*50);
			
			driver.findElement(feesDetails).click();
			Thread.sleep(Const*50);
			*/
		}
  
  //------------------------------------------------------------------------------------------------
 
  @Test  // اكثر من عقار و كل عقار تابع لجهة تنظيمية مختلفة Not ready
  public void Case4500() throws InterruptedException, IOException {
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
		Thread.sleep(Const * 50);
	//	Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
		Thread.sleep(Const *50);
		
		driver.findElement(Passport).click();
		Thread.sleep(Const * 50);
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
		Thread.sleep(Const * 50);

		driver.findElement(nextToPrpertyInfoFromPurchaserInfo).click();
		Thread.sleep(Const*30);
		// ------------------------Wife-Husband Info--------------------------------

		// ---------------------Property & Buyer Info ------------------------------
		driver.findElement(recordNo).sendKeys(recordNoContentCase4100); // رقم القيد
		Thread.sleep(Const * 20);
		driver.findElement(DLSKeyButton).click();
		Thread.sleep(Const * 20);
		driver.findElement(schemeNo).sendKeys(recordNoContentCase4100); // الرقم المميز للمخطط
		Thread.sleep(Const*20);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pgl5\"]/div[4]")).click(); // click-anywhere-to-navigate-out
		Thread.sleep(Const*20);
		driver.findElement(checkownersA).click();
		Thread.sleep(Const*30);
		// --------------------------------Attachments---------------------------
	
		
	driver.findElement(OrganizationalChart).click(); // مخطط موقع تنظيمي
		Thread.sleep(Const * 50);
		
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
		Thread.sleep(Const * 50);
		
		
	//	------------------------------------Multi Property------------------------------------
		driver.findElement(addPropertyButton).click();
		Thread.sleep(Const * 50);
	
		driver.findElement(recordNo).sendKeys(recordNoContentCase4000); // رقم القيد
		Thread.sleep(Const * 20);
		driver.findElement(DLSKeyButton).click();
		Thread.sleep(Const * 20);
		driver.findElement(schemeNo).sendKeys(recordNoContentCase4000); // الرقم المميز للمخطط
		Thread.sleep(Const*20);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pgl5\"]/div[4]")).click(); // click-anywhere-to-navigate-out
		Thread.sleep(Const*20);
		driver.findElement(checkownersB).click();
		Thread.sleep(Const*30);
		
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pgl5\"]/div[4]")).click(); // click-anywhere-to-navigate-out
		Thread.sleep(Const*50);
			
			// -------------------------------- Attachments---------------------------
		
			
	/*	driver.findElement(mo5tetalaradi).click(); // مخطط الاراضي
		Thread.sleep(Const * 50);
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded);// FireFox 
		Thread.sleep(Const * 50);
		*/
			
	//	driver.findElement(CoRegistrationCertificate).click(); // شهادة تسجيل الشركة
		//Thread.sleep(Const * 50);
			
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		//Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
	//	Thread.sleep(Const * 50);
			
		//driver.findElement(ProfessionLicense).click(); // رخصة المهن
		//Thread.sleep(Const * 50);
			
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		//Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
		//	Thread.sleep(Const * 50); 
			
		driver.findElement(NextToBuyerAttach).click();
		
	//	--------------------------------------BuyerAttach-------------------
		
		Select PropertiesDDL = new Select(driver.findElement(Properties)); // العقارات
		PropertiesDDL.selectByValue("0");
		Thread.sleep(Const*20);
		
		
		Select OwnersDDL = new Select(driver.findElement(Owners)); // المالكين
		OwnersDDL.selectByValue("0");
		Thread.sleep(Const*20);
		
	
		driver.findElement(FormalLetter).click(); // الكتاب الرسمي
		Thread.sleep(Const * 50);
		
	//	Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
		Thread.sleep(Const * 50);
		
		
		
		driver.findElement(NextToLinkPurchaserandBuyers).click(); 
		Thread.sleep(Const * 50);
		
	// -----------------------Link Purchaser with Buyers---------------------	
		
		Select buyerNameDDL = new Select(driver.findElement(buyerName)); // اسم المشتري
		buyerNameDDL.selectByValue("0");
		Thread.sleep(Const*20);
		
		Select PropertieslistDDL = new Select(driver.findElement(PropertiesA2)); // االعقارات
		PropertieslistDDL.selectByValue("0");
		Thread.sleep(Const*20);
		
		Select ownerNametDDL = new Select(driver.findElement(ownerName)); // اسم المالك
		ownerNametDDL.selectByValue("0");
		Thread.sleep(Const*20);
		
		driver.findElement(areatoBeOwnedNum).sendKeys("123");
		Thread.sleep(Const*20);
		
		driver.findElement(areatoBeOwned).sendKeys("123");
		Thread.sleep(Const*20);
		
		driver.findElement(numberofProportions).sendKeys("1");
		Thread.sleep(Const*20);
		
		
		driver.findElement(addLinkPurchaserWithBuyer).click(); // add button
		Thread.sleep(Const*20);
		
		
		Select buyerNameDDL2 = new Select(driver.findElement(buyerName)); // اسم المشتري
		buyerNameDDL2.selectByValue("0");
		Thread.sleep(Const*20);
		
		Select PropertieslistDDL2 = new Select(driver.findElement(PropertiesA2)); // االعقارات
		PropertieslistDDL2.selectByValue("1");
		Thread.sleep(Const*20);
		
		Select ownerNametDDL2 = new Select(driver.findElement(ownerName)); // اسم المالك
		ownerNametDDL2.selectByValue("0");
		Thread.sleep(Const*20);
		
		driver.findElement(areatoBeOwnedNum).sendKeys("123");
		Thread.sleep(Const*20);
		
		driver.findElement(areatoBeOwned).sendKeys("123");
		Thread.sleep(Const*20);
		
		driver.findElement(numberofProportions).sendKeys("1");
		Thread.sleep(Const*50);
		
		
		driver.findElement(NextToReviewSection).click();
		
		Thread.sleep(Const*60);
		

		driver.findElement(submitRequest).click();
		driver.findElement(submitRequest).click();
		Thread.sleep(Const*30);
		driver.findElement(agreeButton).click();
		Thread.sleep(Const*50);
	
	}
  
  
  
  
  //---------------------------------------------------------------------------------------------------------

  
  @Test   //  التحقق من نوع مقدم الطلب - مشتري  
  public void Case6000() throws InterruptedException, IOException {
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
		Thread.sleep(Const * 20);

		driver.findElement(noProperty2).click(); // هل لديك عقارات داخل المملكة؟
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
		Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
		Thread.sleep(Const * 40);
		
		driver.findElement(Passport).click();
		Thread.sleep(Const * 30);
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
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
		driver.findElement(checkownersA).click();
		Thread.sleep(Const*30);
		// --------------------------------Attachments---------------------------
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pc1:t2:0:pgl50\"]/tbody/tr/td[3]/span")).click(); //سند التسجيل
		Thread.sleep(Const * 50);
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded);// FireFox
		Thread.sleep(Const * 50);
		
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pc1:t2:1:pgl50\"]/tbody/tr/td[3]/span")).click(); // مخطط الاراضي
		Thread.sleep(Const * 50);
	//	Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded);// FireFox 
		Thread.sleep(Const * 50);
		
		driver.findElement(CoRegistrationCertificate).click(); // شهادة تسجيل الشركة
		Thread.sleep(Const * 50);
		
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
		Thread.sleep(Const * 50);
		
		//driver.findElement(ProfessionLicense).click(); // رخصة المهن
		//Thread.sleep(Const * 50);
		
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		//Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
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
		Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
		Thread.sleep(Const * 50);
		
		
		driver.findElement(NextToLinkPurchaserandBuyers).click(); 
		Thread.sleep(Const * 50);
		
	// -----------------------Link Purchaser with Buyers---------------------	
		
		Select buyerNameDDL = new Select(driver.findElement(buyerName)); // اسم المشتري
		buyerNameDDL.selectByValue("0");
		Thread.sleep(Const*20);
		
		Select PropertieslistDDL = new Select(driver.findElement(PropertiesA2)); // االعقارات
		PropertieslistDDL.selectByValue("0");
		Thread.sleep(Const*20);
		
		Select ownerNametDDL = new Select(driver.findElement(ownerName)); // اسم المالك
		ownerNametDDL.selectByValue("0");
		Thread.sleep(Const*20);
		
		driver.findElement(areatoBeOwnedNum).sendKeys("123");
		Thread.sleep(Const*20);
		
		driver.findElement(areatoBeOwned).sendKeys("123");
		Thread.sleep(Const*20);
		
		driver.findElement(numberofProportions).sendKeys("1");
		Thread.sleep(Const*50);
		
		driver.findElement(NextToReviewSection).click();
		driver.findElement(NextToReviewSection).click();
		Thread.sleep(Const*60);
		

		driver.findElement(submitRequest).click();
	
	}
  
  /*
  @Test   //  التحقق من نوع مقدم الطلب - بائع  
  public void Case6100() throws InterruptedException, IOException {
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
		ApplicantTypeDDL.selectByVisibleText(Vendor); // بائع
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
		Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
		Thread.sleep(Const * 50);
		
		driver.findElement(Passport).click();
		Thread.sleep(Const * 30);
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
		Thread.sleep(Const * 50);

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
		driver.findElement(checkownersA).click();
		Thread.sleep(Const*30);
		// --------------------------------Attachments---------------------------
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pc1:t2:0:pgl50\"]/tbody/tr/td[3]/span")).click(); //سند التسجيل
		Thread.sleep(Const * 50);
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded);// FireFox
		Thread.sleep(Const * 50);
		
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pc1:t2:1:pgl50\"]/tbody/tr/td[3]/span")).click(); // مخطط الاراضي
		Thread.sleep(Const * 50);
	//	Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded);// FireFox 
		Thread.sleep(Const * 50);
		
		driver.findElement(CoRegistrationCertificate).click(); // شهادة تسجيل الشركة
		Thread.sleep(Const * 50);
		
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
		Thread.sleep(Const * 50);
		
		//driver.findElement(ProfessionLicense).click(); // رخصة المهن
		//Thread.sleep(Const * 50);
		
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		//Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
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
		Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
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
		Thread.sleep(Const*60);
		

		driver.findElement(submitRequest).click();
	
	}
  
  @Test   //  التحقق من نوع مقدم الطلب - وكيل مشتري  
  public void Case6200() throws InterruptedException, IOException {
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
		ApplicantTypeDDL.selectByVisibleText(BuyerAgent); // وكيل مشتري
		Thread.sleep(Const * 20);
		driver.findElement(judicialAgencyNo).click();
		driver.findElement(judicialAgencyNo).sendKeys("12345");
		driver.findElement(judicialAgencyDate).sendKeys("2018/10/8");
		Thread.sleep(Const * 20);
		
		// نوع الموافقة
		driver.findElement(InternalRequestApprovalRadio).click();
		Select Purpose = new Select(driver.findElement(PurposeOfPossession)); // الغاية الرئيسية
		Purpose.selectByVisibleText(Agriculture);
		Thread.sleep(Const * 20);
		Select Purpose2 = new Select(driver.findElement(SecondaryPurposeOfPossession)); // الغاية الفرعية
		Purpose2.selectByVisibleText(AgriculturePurpose);
		Thread.sleep(Const * 20);
		driver.findElement(PowerofAttorney).click();
		Thread.sleep(Const * 30);
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
		Thread.sleep(Const * 50);
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
		Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
		Thread.sleep(Const * 50);
		
		driver.findElement(Passport).click();
		Thread.sleep(Const * 30);
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
		Thread.sleep(Const * 50);

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
		driver.findElement(checkownersA).click();
		Thread.sleep(Const*30);
		// --------------------------------Attachments---------------------------
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pc1:t2:0:pgl50\"]/tbody/tr/td[3]/span")).click(); //سند التسجيل
		Thread.sleep(Const * 50);
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded);// FireFox
		Thread.sleep(Const * 50);
		
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pc1:t2:1:pgl50\"]/tbody/tr/td[3]/span")).click(); // مخطط الاراضي
		Thread.sleep(Const * 50);
	//	Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded);// FireFox 
		Thread.sleep(Const * 50);
		
		driver.findElement(CoRegistrationCertificate).click(); // شهادة تسجيل الشركة
		Thread.sleep(Const * 50);
		
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
		Thread.sleep(Const * 50);
		
		//driver.findElement(ProfessionLicense).click(); // رخصة المهن
		//Thread.sleep(Const * 50);
		
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		//Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
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
		Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
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
		Thread.sleep(Const*60);
		

		driver.findElement(submitRequest).click();
	
	}
  
  @Test   // التحقق من نوع مقدم الطلب - وكيل بائع  
  public void Case6300() throws InterruptedException, IOException {
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
		ApplicantTypeDDL.selectByVisibleText(VendorAgent); // وكيل بائع
		Thread.sleep(Const * 20);
		driver.findElement(judicialAgencyNo).click();
		driver.findElement(judicialAgencyNo).sendKeys("12345");
		driver.findElement(judicialAgencyDate).sendKeys("2018/10/8");
		Thread.sleep(Const * 20);
		
		// نوع الموافقة
		driver.findElement(InternalRequestApprovalRadio).click();
		Select Purpose = new Select(driver.findElement(PurposeOfPossession)); // الغاية الرئيسية
		Purpose.selectByVisibleText(Agriculture);
		Thread.sleep(Const * 20);
		Select Purpose2 = new Select(driver.findElement(SecondaryPurposeOfPossession)); // الغاية الفرعية
		Purpose2.selectByVisibleText(AgriculturePurpose);
		Thread.sleep(Const * 20);
		driver.findElement(PowerofAttorney).click();
		Thread.sleep(Const * 30);
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
		Thread.sleep(Const * 50);
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
		Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
		Thread.sleep(Const * 50);
		
		driver.findElement(Passport).click();
		Thread.sleep(Const * 30);
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
		Thread.sleep(Const * 50);

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
		driver.findElement(checkownersA).click();
		Thread.sleep(Const*30);
		// --------------------------------Attachments---------------------------
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pc1:t2:0:pgl50\"]/tbody/tr/td[3]/span")).click(); //سند التسجيل
		Thread.sleep(Const * 50);
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded);// FireFox
		Thread.sleep(Const * 50);
		
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pc1:t2:1:pgl50\"]/tbody/tr/td[3]/span")).click(); // مخطط الاراضي
		Thread.sleep(Const * 50);
	//	Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded);// FireFox 
		Thread.sleep(Const * 50);
		
		driver.findElement(CoRegistrationCertificate).click(); // شهادة تسجيل الشركة
		Thread.sleep(Const * 50);
		
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
		Thread.sleep(Const * 50);
		
		//driver.findElement(ProfessionLicense).click(); // رخصة المهن
		//Thread.sleep(Const * 50);
		
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		//Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
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
		Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
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
		Thread.sleep(Const*60);
		

		driver.findElement(submitRequest).click();
	
	}
  
  
  @Test   // التحقق من نوع مقدم الطلب - مكتب عقاري  
  public void Case6400() throws InterruptedException, IOException {
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
		ApplicantTypeDDL.selectByVisibleText(realtyOffices); // مكتب عقاري 
		Thread.sleep(Const * 20);
		
		driver.findElement(permitField1).sendKeys(permitField1Content); // رقم االرخصة
		Thread.sleep(Const*50);
		

		driver.findElement(permitField2).sendKeys(permitField2Content); // رقم االرخصة
		Thread.sleep(Const*50);
		
		// نوع الموافقة
		driver.findElement(InternalRequestApprovalRadio).click();
		Select Purpose = new Select(driver.findElement(PurposeOfPossession)); // الغاية الرئيسية
		Purpose.selectByVisibleText(Agriculture);
		Thread.sleep(Const * 20);
		Select Purpose2 = new Select(driver.findElement(SecondaryPurposeOfPossession)); // الغاية الفرعية
		Purpose2.selectByVisibleText(AgriculturePurpose);
		Thread.sleep(Const * 20);
		driver.findElement(PowerofAttorney).click();
		Thread.sleep(Const * 30);
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
		Thread.sleep(Const * 50);
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
		Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
		Thread.sleep(Const * 50);
		
		driver.findElement(Passport).click();
		Thread.sleep(Const * 30);
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
		Thread.sleep(Const * 50);

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
		driver.findElement(checkownersA).click();
		Thread.sleep(Const*30);
		// --------------------------------Attachments---------------------------
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pc1:t2:0:pgl50\"]/tbody/tr/td[3]/span")).click(); //سند التسجيل
		Thread.sleep(Const * 50);
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded);// FireFox
		Thread.sleep(Const * 50);
		
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pc1:t2:1:pgl50\"]/tbody/tr/td[3]/span")).click(); // مخطط الاراضي
		Thread.sleep(Const * 50);
	//	Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded);// FireFox 
		Thread.sleep(Const * 50);
		
		driver.findElement(CoRegistrationCertificate).click(); // شهادة تسجيل الشركة
		Thread.sleep(Const * 50);
		
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
		Thread.sleep(Const * 50);
		
		//driver.findElement(ProfessionLicense).click(); // رخصة المهن
		//Thread.sleep(Const * 50);
		
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		//Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
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
		Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
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
		Thread.sleep(Const*60);
		

		driver.findElement(submitRequest).click();
	
	}
  */

  @Test   //   not ready  أكثر من مشتري لأكثر من عقار و أكثر من بائع
  public void Case7000() throws InterruptedException, IOException {
		// Applicant info
 
	  driver.findElement(NonJordanianPropertyApproval).click(); // موافقات التملك لغير الاردنين
		Thread.sleep(Const*20);
		driver.findElement(verificationCode).sendKeys(verificationCodeContent); // رمز التحقق
		Thread.sleep(Const*30);
		
		driver.findElement(continueButton).click(); // استمرار
		Thread.sleep(Const*30);
		
		driver.findElement(ApprovalcheckBox).click();  // موافقة
		Thread.sleep(Const*10 );

		driver.findElement(nextButton).click(); //  التالي

		Thread.sleep(Const*20);

	  
		Select ApplicantTypeDDL = new Select(driver.findElement(ApplicantType));
		ApplicantTypeDDL.selectByVisibleText(purchaser); // مشتري
		Thread.sleep(Const * 10);
		// نوع الموافقة
		driver.findElement(InternalRequestApprovalRadio).click();
		Select Purpose = new Select(driver.findElement(PurposeOfPossession)); // الغاية الرئيسية
		Purpose.selectByVisibleText(Agriculture);
		Thread.sleep(Const * 10);
		Select Purpose2 = new Select(driver.findElement(SecondaryPurposeOfPossession)); // الغاية الفرعية
		Purpose2.selectByVisibleText(AgriculturePurpose);
		// رقم وطني للمنشأة
		// driver.findElement(CoNationalNumber).sendKeys("987445215");
		// Next to Purchaser info
		Thread.sleep(Const * 10);
		driver.findElement(nextToPurchaseInfo).click();
		Thread.sleep(Const * 10);
		// Purchaser info 1
		//  1معلومات المشتري
		driver.findElement(buyerInfofield1).sendKeys(buyerInfofield1Content);
		driver.findElement(buyerInfofield2).sendKeys(buyerInfofield2Content);
		driver.findElement(buyerInfofield3).sendKeys(buyerInfofield3Content);
		driver.findElement(buyerInfofield4).sendKeys(buyerInfofield4Content);

		Thread.sleep(Const * 10);
		driver.findElement(nameasinPassport).sendKeys(nameasinPassportContent); // الاسم حسب جواز السفر
		Thread.sleep(Const * 10);
		Select NationalityDDL = new Select(driver.findElement(nationality)); // الجنسية
		NationalityDDL.selectByVisibleText(emirates);
		Thread.sleep(Const * 10);
		driver.findElement(phoneNumber).sendKeys(phoneNoContent); // رقم الهاتف

		Select CountryDDL = new Select(driver.findElement(CountryCode)); // الرمز الدولي
		CountryDDL.selectByVisibleText(code1);
		Thread.sleep(Const*20);

		Select passportTypeDDL = new Select(driver.findElement(passportType)); // نوع جواز السفر
		passportTypeDDL.selectByVisibleText(Permenant);
		Thread.sleep(Const *10);

		driver.findElement(passportNumber).sendKeys(passportNumberContent); // رقم جواز السفر
		Thread.sleep(Const * 10);

		driver.findElement(productionDate).sendKeys(productionDateContent); // تاريخ الاصدار
		Thread.sleep(Const * 20);
		driver.findElement(ExpiryDate).sendKeys(ExpiryDateContent); // تاريخ الانتهاء
		Thread.sleep(Const * 10);

		driver.findElement(productionLocation).sendKeys(productionLocationContent); // مكان الاصدار
		Thread.sleep(Const* 10);

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
		Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
		Thread.sleep(Const * 40);
		
		driver.findElement(Passport).click();
		Thread.sleep(Const * 30);
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
		Thread.sleep(Const * 40);
		
		
		driver.findElement(addMultiBuyers).click();
		Thread.sleep(Const*30);
		//-------------------------------------------Second Buyer Info--------------------------------------------------------------
		// Purchaser info 2
				//   2معلومات المشتري
				driver.findElement(buyer2Infofield1).sendKeys(buyer2Infofield1Content);
				driver.findElement(buyer2Infofield2).sendKeys(buyer2Infofield2Content);
				driver.findElement(buyer2Infofield3).sendKeys(buyer2Infofield3Content);
				driver.findElement(buyer2Infofield4).sendKeys(buyer2Infofield4Content);

				Thread.sleep(Const * 10);
				driver.findElement(nameasinPassport2).sendKeys(nameasinPassportContent2); // الاسم حسب جواز السفر
				Thread.sleep(Const * 10);
				Select Nationality2DDL = new Select(driver.findElement(nationality2)); // الجنسية
				Nationality2DDL.selectByVisibleText(emirates);
				Thread.sleep(Const * 10);
				driver.findElement(phoneNumber2).sendKeys(phoneNoContent2); // رقم الهاتف

				Select Country2DDL = new Select(driver.findElement(CountryCode2)); // الرمز الدولي
				Country2DDL.selectByVisibleText(code1);
				Thread.sleep(Const*20);

				Select passpor2tTypeDDL = new Select(driver.findElement(passportType2)); // نوع جواز السفر
				passpor2tTypeDDL.selectByVisibleText(Permenant);
				Thread.sleep(Const *10);

				driver.findElement(passportNumber2).sendKeys(passportNumberContent2); // رقم جواز السفر
				Thread.sleep(Const * 10);

				driver.findElement(productionDate2).sendKeys(productionDateContent2); // تاريخ الاصدار
				Thread.sleep(Const * 20);
				driver.findElement(ExpiryDate2).sendKeys(ExpiryDateContent2); // تاريخ الانتهاء
				Thread.sleep(Const * 10);

				driver.findElement(productionLocation2).sendKeys(productionLocationContent2); // مكان الاصدار
				Thread.sleep(Const* 10);

				Select arrivalCountry2DDL = new Select(driver.findElement(arrivalCountry2)); // بلد القدوم
				arrivalCountry2DDL.selectByVisibleText(AbuDhabi);
				Thread.sleep(Const * 10);

				driver.findElement(placeOfBirth2).sendKeys(placeOfBirthContent2); // مكان الولادة
				Thread.sleep(Const * 10);

				driver.findElement(birthDate2).sendKeys(dateOfBirthContent2); // تاريخ الولادة
				Thread.sleep(Const * 10);

				driver.findElement(NoResidency2).click(); // لديك إقامة بالمملكة
				Thread.sleep(Const * 10);

				driver.findElement(noProperty).click(); // هل لديك عقارات داخل المملكة؟
				Thread.sleep(Const * 10);

				driver.findElement(currentResidenceAddress2).sendKeys(currentResidenceAddressContent2); // عنوان الإقامة الحالية
				Thread.sleep(Const*20);

				Select Gender2DDL = new Select(driver.findElement(Gender2)); // الجنس
				Gender2DDL.selectByVisibleText(female);
				Thread.sleep(Const * 10);

				Select SocialStatus2DDL = new Select(driver.findElement(socialStatus2)); // الحالة الاجتماعية
				SocialStatus2DDL.selectByVisibleText(single);
				Thread.sleep(Const * 20);

				driver.findElement(job2).sendKeys(JobContent); // المهنة
				Thread.sleep(Const * 20);

				driver.findElement(registrationNo2).sendKeys(registrationNoContent); // رقم الدخول
				Thread.sleep(Const * 20 );

				driver.findElement(additionalInfo2).sendKeys(additionalInfoContent); // معلومات اضافية
				Thread.sleep(Const * 20);

				driver.findElement(noOtherNationality2).click();// جنسية أخرى
				Thread.sleep(Const*20);

				Select motherNationality2DDL = new Select(driver.findElement(motherNationality2)); // جنسية الام
				motherNationality2DDL.selectByVisibleText(Jordanian);
				Thread.sleep(Const*20);

				driver.findElement(insideKigdom2).click();// هل المستدعى له داخل المملكة؟
				Thread.sleep(Const * 20);
				// معلومات الام
				driver.findElement(MomFirstName2).sendKeys(MomFirstNameContent2);
				Thread.sleep(Const *20);
				driver.findElement(MomSecondName2).sendKeys(MomSecondNameContent2);
				Thread.sleep(Const * 20);
				driver.findElement(MomThirdName2).sendKeys(MomThirdNameContent2);
				Thread.sleep(Const * 20);
				driver.findElement(MomLastName2).sendKeys(MomLastNameContent2);
				Thread.sleep(Const * 30);
				// ---------------------------------Attachments--------------------------
				driver.findElement(IDCard).click();
				Thread.sleep(Const * 30);
				//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
				Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
				Thread.sleep(Const * 40);
				
				driver.findElement(Passport).click();
				//Thread.sleep(Const * 30);
				//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
				Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
				//Thread.sleep(Const * 40);
		

		driver.findElement(nextToPrpertyInfoFromPurchaserInfo).click();
		Thread.sleep(Const*30);
		// ------------------------Wife-Husband Info--------------------------------

		// ---------------------Property & Buyer Info ------------------------------
		driver.findElement(recordNo).sendKeys(); // رقم القيد
		Thread.sleep(Const * 20);
		driver.findElement(DLSKeyButton).click();
		Thread.sleep(Const * 20);
		driver.findElement(schemeNo).sendKeys(recordNoContent); // الرقم المميز للمخطط
		Thread.sleep(Const*20);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pgl5\"]/div[4]")).click(); // click-anywhere-to-navigate-out
		Thread.sleep(Const*20);
		driver.findElement(checkownersA).click();
		Thread.sleep(Const*30);
		// --------------------------------Attachments---------------------------
		/*driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pc1:t2:0:pgl50\"]/tbody/tr/td[3]/span")).click(); //سند التسجيل
		Thread.sleep(Const * 50);
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded);// FireFox
		Thread.sleep(Const * 50);*/
		
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pc1:t2:1:pgl50\"]/tbody/tr/td[3]/span")).click(); // مخطط الاراضي
		Thread.sleep(Const * 50);
	//	Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded);// FireFox 
		Thread.sleep(Const * 50);
		
		/*driver.findElement(CoRegistrationCertificate).click(); // شهادة تسجيل الشركة
		Thread.sleep(Const * 50);
		
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
		Thread.sleep(Const * 50);*/
		
		//driver.findElement(ProfessionLicense).click(); // رخصة المهن
		//Thread.sleep(Const * 50);
		
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		//Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
	//	Thread.sleep(Const * 50); 
		
		
		//------------------------------------------- Multi Property---------------------------
		
		driver.findElement(addPropertyButton).click();
		Thread.sleep(Const * 20); 
		
		driver.findElement(recordNo).sendKeys(); // رقم القيد
		Thread.sleep(Const * 20);
		driver.findElement(DLSKeyButton).click();
		Thread.sleep(Const * 20);
		driver.findElement(schemeNo).sendKeys(recordNoContent); // الرقم المميز للمخطط
		Thread.sleep(Const*20);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:pgl5\"]/div[4]")).click(); // click-anywhere-to-navigate-out
		Thread.sleep(Const*20);
		driver.findElement(checkownersA).click();
		Thread.sleep(Const*30);
		
		

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
		Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
		Thread.sleep(Const * 50);
		
		Select PropertiesDDL2 = new Select(driver.findElement(Properties)); // العقارات
		PropertiesDDL2.selectByValue("1");
		Thread.sleep(Const*20);
		
		
		Select OwnersDDL2 = new Select(driver.findElement(Owners)); // المالكين
		OwnersDDL2.selectByValue("1");
		Thread.sleep(Const*20);
		
		driver.findElement(IDCard).click(); // هوية الاحوال المدنية
		Thread.sleep(Const * 50);
		
		//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
		Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
		Thread.sleep(Const * 50);
		
		
		driver.findElement(NextToLinkPurchaserandBuyers).click(); 
		Thread.sleep(Const * 50);
		
	// -----------------------Link Purchaser with Buyers---------------------	
		
		Select buyerNameDDL = new Select(driver.findElement(buyerName)); // اسم المشتري
		buyerNameDDL.selectByValue("0");
		Thread.sleep(Const*10);
		
		Select PropertieslistDDL = new Select(driver.findElement(PropertiesA2)); // االعقارات
		PropertieslistDDL.selectByValue("0");
		Thread.sleep(Const*10);
		
		Select ownerNametDDL = new Select(driver.findElement(ownerName)); // اسم المالك
		ownerNametDDL.selectByValue("0");
		Thread.sleep(Const*10);
		
		driver.findElement(areatoBeOwnedNum).sendKeys("123");
		Thread.sleep(Const*10);
		
		driver.findElement(areatoBeOwned).sendKeys("123");
		Thread.sleep(Const*10);
		
		driver.findElement(numberofProportions).sendKeys("1");
		Thread.sleep(Const*20);
		
		
		
		
		driver.findElement(NextToReviewSection).click();
		driver.findElement(NextToReviewSection).click();
		Thread.sleep(Const*60);
		

		driver.findElement(submitRequest).click();
		Thread.sleep(Const*30);
		driver.findElement(agreeButton).click();
		Thread.sleep(Const*50);
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
