package Package;

import org.openqa.selenium.By;

public class APCO_Fields extends APCO_VARS {
	
	// Log-in page
				By username = By.xpath("//*[@id=\"pt1:it1::content\"]");
				By Password = By.id("pt1:it2::content");
				By forgetPasswordLink = By.id("pt1:l2::text");
				By LoginButton = By.xpath("//*[@id=\"pt1:b1\"]/a");
				By nextButton = By.xpath("//*[@id=\"pt1:r1:0:b1\"]/a/span"); // زر التالي

	// 
				By APCO=By.id("pt2:i1:3:sdi1::tia"); // موافقات التملك للمعنوين
				By verificationCode=By.id("pt1:s1:it15::content"); // رمز التحقق
				By continueButton=By.id("pt1:s1:b7"); // استمرار
				By agreeCheckbox=By.id("pt1:r1:0:sbc2::content");
				By NextToApplicantTab=By.xpath("/html/body/div/form/div[1]/div[2]/table/tbody/tr/td[2]/div/span/table/tbody/tr/td/div/div[1]/div[4]/div/div[1]/div/a/span");
				
				// Applicant type 
				By ApplicantType=By.id("pt1:r1:1:soc1::content");
				By residentialPurpose=By.id("pt1:r1:1:sor2:_0");
				By nonResidentialPurpose=By.id("pt1:r1:1:sor2:_1");
				By InsideOrganization=By.id("pt1:r1:1:sor1:_0");
				By OutsideOrganization=By.id("pt1:r1:1:sor1:_1");
				By mainPurposeOfPossession=By.id("pt1:r1:1:soc6::content");
				By SecondaryPurposeOfPossession =By.id("pt1:r1:1:soc7::content");
				
				By NationalNumber=By.id("pt1:r1:1:it10::content");
				By NextToBuyerInfo=By.xpath("/html/body/div[1]/form/div[1]/div[2]/table/tbody/tr/td[2]/div/span/table/tbody/tr/td/div/div[1]/div[15]/table/tbody/tr/td[4]/div/a/span");
				
				By addOriginalProperty=By.xpath("/html/body/div[1]/form/div[1]/div[2]/table/tbody/tr/td[2]/div/span/table/tbody/tr/td/div/div[1]/div[9]/table/tbody/tr/td/div/a/span");
				// Original PropertyInfo 
				
				By directorate=By.id("pt1:r1:2:soc5::content");
				By village=By.id("pt1:r1:2:soc1::content");
				By BuildingNo=By.id("pt1:r1:2:it6::content");
				By BasinNo=By.id("pt1:r1:2:soc2::content");
				By NeighbourhoodNo=By.id("pt1:r1:2:soc3::content");
				By apartmentNo=By.id("pt1:r1:2:it1::content");
				By plateNo=By.id("pt1:r1:2:soc4::content");
				By RealEStateType=By.id("pt1:r1:2:soc6::content");
				By licenseNo =By.id("pt1:r1:2:it3::content");
				By landNo=By.id("pt1:r1:2:it5::content");
				By floorNo=By.id("pt1:r1:2:it7::content");
				By saveOriginalPropertyInfo=By.xpath("/html/body/div[1]/form/div[1]/div[2]/table/tbody/tr/td[2]/div/span/table/tbody/tr/td/div/table[3]/tbody/tr/td[2]/div/a/span");
				
				// Buyer Info tab
				By CompanyNationalNumber=By.id("pt1:r1:2:it1::content");
				
				By NoPriorProperties=By.id("pt1:r1:2:sor1:_0"); 
				By NextToPartiesInfo=By.xpath("/html/body/div[1]/form/div[1]/div[2]/table/tbody/tr/td[2]/div/span/table/tbody/tr/td/div/div[1]/div[8]/table/tbody/tr/td[3]/div/a/span");
				By addBuyer=By.xpath("/html/body/div[1]/form/div[1]/div[2]/table/tbody/tr/td[2]/div/span/table/tbody/tr/td/div/div[1]/div[4]/table/tbody/tr/td[2]/table/tbody/tr/td[2]/div/a/span");
			
				// Parties Info 
				By CompanyName=By.id("pt1:r1:3:soc3::content");
				By partyName=By.id("pt1:r1:3:soc11::content");
				By firstName=By.id("pt1:r1:3:it1::content");
				By secondName=By.id("pt1:r1:3:it2::content");
				By thirdName=By.id("pt1:r1:3:it3::content");
				By fourthName=By.id("pt1:r1:3:it4::content");
				By nameAsInPassport=By.id("pt1:r1:3:it5::content");
				By nationality=By.id("pt1:r1:3:soc2::content");
				By phoneNumber=By.id("pt1:r1:3:it28::content");
				By countryCode=By.id("pt1:r1:3:soc7::content");
				By passportType=By.id("pt1:r1:3:soc8::content");
				By passportNumber=By.id("pt1:r1:3:it20::content");
				By productionDate=By.id("pt1:r1:3:id1::content");
				By ExpiryDate=By.id("pt1:r1:3:id5::content");
				By productionPlace=By.id("pt1:r1:3:it21::content");
				By arrivalPlace=By.id("pt1:r1:3:soc1::content");
				By placeOfBirth=By.id("pt1:r1:3:it32::content");
				By DateOfBirth=By.id("pt1:r1:3:id3::content");
				By NotResident=By.id("pt1:r1:3:sor4:_0");
				By IsResident=By.id("pt1:r1:3:sor4:_1");
				By noProperties=By.id("pt1:r1:3:sor2:_0");
				By hasProperties=By.id("pt1:r1:3:sor2:_1");
				By ResidencyNo=By.id("pt1:r1:3:it23::content");
				By ResidencyDate=By.id("pt1:r1:3:id6::content");
				By CurrrentResidencyAddress=By.id("pt1:r1:3:it6::content");
				By Gender=By.id("pt1:r1:3:soc12::content");
				By socialStatus=By.id("pt1:r1:3:soc6::content");
				By career=By.id("pt1:r1:3:it13::content");
				By enternaceNumber=By.id("pt1:r1:3:it7::content");
				By additionalInfo=By.id("pt1:r1:3:it24::content");
				By noOtherNationality=By.id("pt1:r1:3:sor1:_0");
				By yesOtherNationality=By.id("pt1:r1:3:sor1:_1");
				By anotherNationality=By.id("pt1:r1:3:soc9::content");
				By momNationality=By.id("pt1:r1:3:soc4::content");
				By OutsideKingdom=By.id("pt1:r1:3:sor5:_0");
				By InsideKingdom=By.id("pt1:r1:3:sor5:_1");
				
				By MomFirstName=By.id("pt1:r1:3:it36::content");
				By MomSecondName=By.id("pt1:r1:3:it37::content");
				By MomThirdName=By.id("pt1:r1:3:it38::content");
				By MomFourthName=By.id("pt1:r1:3:it39::content");
				
				
				By IdCard=By.xpath("/html/body/div[1]/form/div[1]/div[2]/table/tbody/tr/td[2]/div/span/table/tbody/tr/td/div/div[1]/div[13]/div/div[1]/div/div[1]/div/div[2]/table/tbody/tr[1]/td[3]/label/table/tbody/tr/td[3]/span");
				By passport=By.xpath("/html/body/div[1]/form/div[1]/div[2]/table/tbody/tr/td[2]/div/span/table/tbody/tr/td/div/div[1]/div[13]/div/div[1]/div/div[1]/div/div[2]/table/tbody/tr[2]/td[3]/label/table/tbody/tr/td[3]/span");
				By anotherAttachment=By.xpath("/html/body/div[1]/form/div[1]/div[2]/table/tbody/tr/td[2]/div/span/table/tbody/tr/td/div/div[1]/div[13]/div/div[1]/div/div[1]/div/div[2]/table/tbody/tr[1]/td[3]/label/table/tbody/tr/td[3]/span");
			By NextToPropertyInfo=By.xpath("/html/body/div[1]/form/div[1]/div[2]/table/tbody/tr/td[2]/div/span/table/tbody/tr/td/div/div[1]/div[14]/table/tbody/tr/td[4]/div/a/span");
	// معلومات العقار		
			By recordNo=By.id("pt1:r1:4:it25::content"); 
			By RecordNoButton=By.id("pt1:r1:4:cb1");
			By schemeNo=By.id("pt1:r1:4:it1::content");
			By checkOwner=By.id("pt1:r1:4:pc2:t5:0:sbc2::content");
			By checkOwner2=By.id("pt1:r1:4:pc2:t5:1:sbc2::content");
			By otherAttachemnt=By.xpath("/html/body/div[1]/form/div[1]/div[2]/table/tbody/tr/td[2]/div/span/table/tbody/tr/td/div/div[1]/div[8]/table/tbody/tr/td/div/div[11]/div/div[1]/div/div/div[2]/div/div[2]/table/tbody/tr/td[3]/label/table/tbody/tr/td[3]/span");
			By nextToSellerAttachments=By.xpath("/html/body/div[1]/form/div[1]/div[2]/table/tbody/tr/td[2]/div/span/table/tbody/tr/td/div/div[1]/div[10]/table/tbody/tr/td[4]/div/a/span");		
			By addProperty=By.xpath("/html/body/div[1]/form/div[1]/div[2]/table/tbody/tr/td[2]/div/span/table/tbody/tr/td/div/div[1]/div[6]/table/tbody/tr/td[2]/table/tbody/tr/td[1]/div/a/span");
// مرفقات البائعين
 By estate=By.id("pt1:r1:5:soc1::content");
 By owners=By.id("pt1:r1:5:soc2::content");
 By idCardAttachment=By.xpath("/html/body/div[1]/form/div[1]/div[2]/table/tbody/tr/td[2]/div/span/table/tbody/tr/td/div/div[1]/div[8]/div/div[1]/div/div[1]/div/div[2]/table/tbody/tr/td[3]/label/table/tbody/tr/td[3]/span");
 By nextToLinkBuyerwithSeller=By.xpath("/html/body/div[1]/form/div[1]/div[2]/table/tbody/tr/td[2]/div/span/table/tbody/tr/td/div/div[1]/div[9]/table/tbody/tr/td[4]/div/a");
 
 // ربط المشتريين مع البائعين
By Company=By.id("pt1:r1:6:soc2::content");
By Estates=By.id("pt1:r1:6:soc1::content");
By ownerName=By.id("pt1:r1:6:soc3::content");
By areaToBeOwnedInNumbers=By.id("pt1:r1:6:it11::content");
By areaTobeOwned=By.id("pt1:r1:6:it1::content");
By proportionsNumber=By.id("pt1:r1:6:it3::content");
By nextToReviewRequest=By.xpath("/html/body/div[1]/form/div[1]/div[2]/table/tbody/tr/td[2]/div/span/table/tbody/tr/td/div/div[1]/div[8]/table/tbody/tr/td[4]/div/a");
// مراجعة الطلب 
By submit=By.xpath("/html/body/div[1]/form/div[1]/div[2]/table/tbody/tr/td[2]/div/span/table/tbody/tr/td/div/div[1]/div[17]/table/tbody/tr/td[5]/div/a/span");
}
