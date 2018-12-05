package Package;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class APCO_VARS {
	
			//Drivers
			String IEDriver = "C:\\Users\\hrasheed\\DLS\\APNO\\DLS-APNO\\driver\\IEDriverServer.exe";
			String ChromeDriver = "C:\\Users\\hrasheed\\Downloads\\chromedriver.exe";
			String gekoDriver="C:\\Users\\hrasheed\\DLS\\APNO\\DLS-APNO\\driver\\geckodriver.exe";
	//Link 	
		//	String link="http://172.16.0.34:7003/dlseservices/faces/main_page"; // development 
			String link="http://172.16.0.38:7003/dlseservices/faces/index ";// Local

			// Upload From
			String FiletobeUploaded="C:\\Users\\hrasheed\\Documents\\FileUploadFirfox.exe";
			// Log in credentials 
			String usernameContent="Omran_Rabieh";
			String passwordContent="Oo@123";
			String verificationCodeContent="moict";
			
			// ApplicantType DDL options
			String purchaser="مشتري";
			String Vendor="بائع";
			String BuyerAgent="وكيل مشتري";
			String VendorAgent="وكيل بائع";
			String realtyOffices ="مكاتب عقارية";
			
		
			// PurposeOfPossession DDL options
			String Residential="سكن";
			String Agriculture="زراعة";
			String industry="صناعة";
			String FinanceLease="تأجير تمويلي";
			String Commercial_Office="تجارية_مكاتب"; //ادارة أعمال
			String RepairnadDischargeDevelopment="اصلاح وافراز وتطوير";
			String BussinessAdministration = "مكتب لأدارة اعماله";
			
			
			// SecondaryPurposeOfPossession DDL options - Residential
			String utilizationOfBuilding ="استغلال البناء المقام";
			String OtherPurposes="اخرى";
			String Residence="سكن";
			String expansion="توسعه";
			
			String NationalNumberContent="12344";
			String CompanyNationalNumberContent="200005441";
			String CompanyNationalNumberContent2="200000328";
			
			String FirstNameContent="هناء";
			String SecondNameContent="زيد";
			String thirdNameContent="عبدالكريم";
			String fourthNameContent="الرشيد";
			
			String nameAsInPassportContent="هناء زيد عبدالكريم الرشيد";
			
			// Nationalities  الجنسية - معلومات المشتري
						String emirates="الإماراتية";
						String Australian="الأسترالية";
						String Egyptian="المصرية";
						String Jordanian="الأردنية";
						
			String phoneNumberContent="079999999";
			// CountryCode DDL Options الرمز الدولي
						String code1="00976";
						String code2="00996";
						
						//Passport types DDL options نوع جواز السفر
						String Permenant="دائم";
						String Temperory="مؤقت";
						String Deplomatic="دبلوماسي";
						
					String passportNumberContent="1222";
					String productionDateContent="2018/1/1";
					String ExpiryDateContent="2018/12/31";
					String productionPlaceContent="Amman";
					
					
					
					// Arrival Country DDL options بلد القدوم
					String AbuDhabi="أبو ظبي";
					String Italy="إيطاليا";
					String Australia="أستراليا";
					
					
					String placeOfBirthContent="UAE";
					String DateOfBirthContent="1990/12/28";
					String CurrrentResidencyAddressContent="England";
					
					
					// Gender DDL options الجنس
					String male="ذكر";
					String female="أنثى";
					
					
					// socialStatus DDL options الحالة الاجتماعية
					String single="أعزب";
					String widow="ارمل";
					String married="متزوج";
					String divorced="مطلق";
					
					String careerContent="مبرمج";
					String enternaceNumberContent="1111";
					
					
				//  معلومات الام
					String MomFirstNameContent="الهام";
					String MomSecondNameContent="حسين";
					String MomThirdNameContent="ٍسليمان";
					String MomLastNameContent="عنبتاوي";
				
					String RecordNoContent="1-6BAE1P";
					
					String areaToBeOwnedInNumbersContent="1";
					String areaTobeOwnedContent="1";
					String proportionsNumberContent="1";
					
}
