package Package;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class APCO extends APCO_Fields {
	Integer Const=500;
	WebDriver driver;

	  @BeforeTest
	  public void Login() throws InterruptedException {
	// System.setProperty("webdriver.ie.driver",IEDriver);
	 //driver = new InternetExplorerDriver();
		  
		//  System.setProperty("webdriver.chrome.driver", ChromeDriver);
//		driver = new ChromeDriver();
		
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
	  @Test   
	  public void Case1000() throws InterruptedException, IOException {
			// Applicant info
		  driver.findElement(APCO).click();
		  Thread.sleep(Const*10);
		  driver.findElement(verificationCode).sendKeys(verificationCodeContent);
		  Thread.sleep(Const*10);
		  driver.findElement(continueButton).click();
		  Thread.sleep(Const*10);
		  driver.findElement(agreeCheckbox).click();
		  Thread.sleep(Const*10);
		  driver.findElement(NextToApplicantTab).click();
		  
		  Thread.sleep(Const*10);
		  Select ApplicantTypeDDL = new Select(driver.findElement(ApplicantType));
			ApplicantTypeDDL.selectByVisibleText(purchaser); // مشتري
			Thread.sleep(Const * 5);
			 driver.findElement(residentialPurpose).click();
			 driver.findElement(InsideOrganization).click();
			 Thread.sleep(Const*10);
			 
			  Select mainPurposeOfPossessionDDL = new Select(driver.findElement(mainPurposeOfPossession));
			  mainPurposeOfPossessionDDL.selectByVisibleText(Commercial_Office); // مكتب لادارة اعماله
				Thread.sleep(Const * 5);
				
				 Select SecondaryPurposeOfPossessionDDL = new Select(driver.findElement(SecondaryPurposeOfPossession));
				 SecondaryPurposeOfPossessionDDL.selectByVisibleText(utilizationOfBuilding); // 
					Thread.sleep(Const * 5);
					 driver.findElement(NationalNumber).sendKeys(NationalNumberContent);
						
					 Thread.sleep(Const * 5);
					 driver.findElement(NextToBuyerInfo).click(); 
					 driver.findElement(NextToBuyerInfo).click();  
					 Thread.sleep(Const * 10);

					 
					 //Buyer Info tab 
					 driver.findElement(CompanyNationalNumber).sendKeys(CompanyNationalNumberContent);
					 driver.findElement(NoPriorProperties).click();  
					 Thread.sleep(Const * 5);
					 driver.findElement(NextToPartiesInfo).click(); 
					 Thread.sleep(Const * 10);
					
					 // Parties Info tab

					 Select CompanyNameDDL = new Select(driver.findElement(CompanyName));
					 CompanyNameDDL.selectByValue("0"); // 
						Thread.sleep(Const * 5);

					Select partyNameDDL = new Select(driver.findElement(partyName));
					partyNameDDL.selectByValue("0"); // 
						Thread.sleep(Const * 5);
						
						 driver.findElement(firstName).sendKeys(FirstNameContent);
							Thread.sleep(Const * 5);
							
							 driver.findElement(secondName).sendKeys(SecondNameContent);
							 Thread.sleep(Const * 5);
							 
							 driver.findElement(thirdName).sendKeys(thirdNameContent); 
							 Thread.sleep(Const * 5);
							 driver.findElement(fourthName).sendKeys(fourthNameContent); 
							 Thread.sleep(Const * 5);
							
							 driver.findElement(nameAsInPassport).sendKeys(nameAsInPassportContent); 
							 Thread.sleep(Const * 5);
							 Select nationalityDDL = new Select(driver.findElement(nationality));
							 nationalityDDL.selectByVisibleText(Egyptian); // 
								Thread.sleep(Const * 5);
								
								 driver.findElement(phoneNumber).sendKeys(phoneNumberContent); 
								 Thread.sleep(Const * 5);
								 Select CountrycodeDDL = new Select(driver.findElement(countryCode));
								 CountrycodeDDL.selectByVisibleText(code1); // 
									Thread.sleep(Const * 10);
									
									 Select passportTypeDDL = new Select(driver.findElement(passportType));
									 passportTypeDDL.selectByVisibleText(Temperory); // 
										Thread.sleep(Const * 5);
										
								driver.findElement(passportNumber).sendKeys(passportNumberContent); 	
								Thread.sleep(Const * 5);

					 driver.findElement(productionDate).sendKeys(productionDateContent); 	
						Thread.sleep(Const * 5);
						 driver.findElement(ExpiryDate).sendKeys(ExpiryDateContent); 
						 Thread.sleep(Const * 5);
						 
						 driver.findElement(productionPlace).sendKeys(productionPlaceContent); 		 
						 Thread.sleep(Const * 5);
						 
						 Select arrivalPlaceDDL = new Select(driver.findElement(arrivalPlace));
						 arrivalPlaceDDL.selectByVisibleText(Italy); // 
							Thread.sleep(Const * 5);
							
							 driver.findElement(placeOfBirth).sendKeys(placeOfBirthContent); 	
								Thread.sleep(Const * 5);
								 driver.findElement(DateOfBirth).sendKeys(DateOfBirthContent);
									Thread.sleep(Const * 5);
									 driver.findElement(NotResident).click();
										Thread.sleep(Const * 5);
										 driver.findElement(noProperties).click();
											Thread.sleep(Const * 5);

										 driver.findElement(CurrrentResidencyAddress).sendKeys(CurrrentResidencyAddressContent); 
										 Thread.sleep(Const * 5);
										 
										 Select GenderDDL = new Select(driver.findElement(Gender));
										 GenderDDL.selectByVisibleText(female); // 
											Thread.sleep(Const * 5);	
											
											 Select socialStatusDDL = new Select(driver.findElement(socialStatus));
											 socialStatusDDL.selectByVisibleText(single); // 
												Thread.sleep(Const * 5);	
												

												 driver.findElement(career).sendKeys(careerContent); 
												 Thread.sleep(Const * 5);
												 
												 driver.findElement(enternaceNumber).sendKeys(enternaceNumberContent); 
												 Thread.sleep(Const * 5);
												 
												 Select momNationalityDDL = new Select(driver.findElement(momNationality));
												 momNationalityDDL.selectByVisibleText(Australian); // 
													Thread.sleep(Const * 5);	

													
													 driver.findElement(MomFirstName).sendKeys(MomFirstNameContent); 
													 Thread.sleep(Const * 5);
													 
													 driver.findElement(MomSecondName).sendKeys(MomSecondNameContent); 
													 Thread.sleep(Const * 5);
													 
													 driver.findElement(MomThirdName).sendKeys(MomThirdNameContent); 
													 Thread.sleep(Const * 5);
												
													 driver.findElement(MomFourthName).sendKeys(MomLastNameContent); 
													 Thread.sleep(Const * 5);
				//-----------------------------Attachments -----------------------------------------------------
			 driver.findElement(IdCard).click();
			Thread.sleep(Const * 5);		
			
			//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
			Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
			Thread.sleep(Const * 40);
			

			 driver.findElement(passport).click();
				Thread.sleep(Const * 5);		 
	
			
			Thread.sleep(Const * 30);
			//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
			Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
			Thread.sleep(Const * 40);
		
			 driver.findElement(NextToPropertyInfo).click();
				Thread.sleep(Const * 10);	
			//--------------------------------------------  معلومات العقار --------------------------------------------
				 driver.findElement(recordNo).sendKeys(RecordNoContent); 
				 Thread.sleep(Const * 5);
				 
				 driver.findElement(RecordNoButton).click(); 
				 Thread.sleep(Const * 5); 
				 
				 driver.findElement(schemeNo).sendKeys(RecordNoContent); 
				 Thread.sleep(Const * 5);
				 	 
				 driver.findElement(checkOwner).click(); 
				 Thread.sleep(Const * 5); 
				 
				 driver.findElement(otherAttachemnt).click(); 
				 Thread.sleep(Const * 5); 
				 
				//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
					Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
					Thread.sleep(Const * 40);
				 
					 driver.findElement(nextToSellerAttachments).click(); 
					 Thread.sleep(Const * 10); 
				//	 -----------------------------------------------------------مرفقات البائعين -------------------------
					 
					 Select estateDDL = new Select(driver.findElement(estate));
					 estateDDL.selectByValue("0"); // 
						Thread.sleep(Const * 5);
						
						 Select ownersDDL = new Select(driver.findElement(owners));
						 ownersDDL.selectByValue("0"); // 
							Thread.sleep(Const * 5);
							
							 driver.findElement(idCardAttachment).click(); 
								
							 Thread.sleep(Const * 30);
							 
								//Runtime.getRuntime().exec("\\C:\\Users\\hrasheed\\Documents\\File2.exe"); // Chrome
								Runtime.getRuntime().exec(FiletobeUploaded); // Firefox
								Thread.sleep(Const * 40);
								 driver.findElement(nextToLinkBuyerwithSeller).click(); 
								 
			//-----------------------------------------------ربط البائعين مع المشتريين--------------------------------------------------------
								 Select CompanyDDL = new Select(driver.findElement(Company));
								 CompanyDDL.selectByValue("0"); // 
									Thread.sleep(Const * 5);		
									
									 Select EstatesDDL = new Select(driver.findElement(Estates));
									 EstatesDDL.selectByValue("0"); // 
										Thread.sleep(Const * 5);	
										
										 Select ownerNameDDL = new Select(driver.findElement(ownerName));
										 ownerNameDDL.selectByValue("0"); // 
											Thread.sleep(Const * 5);	
											
											
											 driver.findElement(areaToBeOwnedInNumbers).sendKeys(areaToBeOwnedInNumbersContent); 
											 Thread.sleep(Const * 5);
											 
											 driver.findElement(areaTobeOwned).sendKeys(areaTobeOwnedContent); 
											 Thread.sleep(Const * 5);
											 
											 driver.findElement(proportionsNumber).sendKeys(proportionsNumberContent); 
											 Thread.sleep(Const * 5);
											 
											 driver.findElement(nextToReviewRequest).click(); 
											 Thread.sleep(Const * 10);
 // ------------------------------------------ مراجعة الطلب ------------------------------------------------------------
											 driver.findElement(submit).click(); 
											 Thread.sleep(Const * 10);
													 
}
}