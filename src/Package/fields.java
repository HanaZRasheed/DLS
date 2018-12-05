package Package;

import org.openqa.selenium.By;

public class fields {
		// Log-in page
		By username = By.xpath("//*[@id=\"pt1:it1::content\"]");
		By Password = By.id("pt1:it2::content");
		By forgetPasswordLink = By.id("pt1:l2::text");
		By LoginButton = By.xpath("//*[@id=\"pt1:b1\"]/a");
		By nextButton = By.xpath("//*[@id=\"pt1:r1:0:b1\"]/a/span"); // زر التالي

		// تقديم طلب الحصول على موافقة تملّك لغير الأردنيين

		By NonJordanianPropertyApproval = By.id("pt2:i1:2:sdi1::tia"); // Service icon
		By verificationCode = By.id("pt1:s1:it15::content"); // رمز التحقق
		By continueButton = By.id("pt1:s1:b7"); // زر استمرار
		By ApprovalcheckBox = By.id("pt1:r1:0:sbc2::content"); // موافقة
		By ApplicantType = By.id("pt1:r1:1:soc1::content"); // نوع مقدم الطلب
		By ExpressRequestCheckBox = By.id("pt1:r1:1:sbc1::content"); // طلب مستعجل
		// المشتري Fields

		// نوع طلب الموافقة على التملّك
		By InternalRequestApprovalRadio = By.id("pt1:r1:1:sor1:_0"); // داخلي
		By ExternalRequestApprovalRadio = By.id("pt1:r1:1:sor1:_1"); // خارجي
		By PurposeOfPossession = By.id("pt1:r1:1:soc6::content"); // الغاية الرئيسية من التملك
		By SecondaryPurposeOfPossession = By.id("pt1:r1:1:soc7::content");// الغاية الفرعية من التملك
		// صناعة and مكاتب-تجارية fields
		By InstituteNationalNo = By.id("pt1:r1:1:it10::content");
		By CoNationalNumber = By.id("pt1:r1:1:it10::content"); // الرقم الوطني للمنشأة
		// وكيل مشتري and وكيل بائع fields
		By judicialAgencyNo = By.id("pt1:r1:1:it7::content"); //   رقم الوكالة عدلية
		By judicialAgencyDate = By.id("pt1:r1:1:id2::content"); // 
		By permitField1 = By.id("pt1:r1:1:it12::content");
		By permitField2 = By.id("pt1:r1:1:it13::content");
		By OtherPurpose = By.id("pt1:r1:1:it11::content");
		By nextToPurchaseInfo = By.xpath("//*[@id=\"pt1:r1:1:b2\"]/a");

		// ----------------ATTACHMENTS--------------------------

		// Attachments on Applicant Info Screen
		By AuthorizationLetter = By.xpath("");// كتاب تفويض
		By PowerofAttorney = By.xpath("//*[@id=\"pt1:r1:1:pc1:t2:0:pgl50\"]/tbody/tr/td[3]/span");// صورة وكالة عدلية
		By emiratiPassport=By.xpath("/html/body/div[1]/form/div[1]/div[2]/table/tbody/tr/td[2]/div/span/table/tbody/tr/td/div/div[1]/div[13]/div/div[1]/div/div[1]/div/div[2]/table/tbody/tr[2]/td[3]/label/table/tbody/tr/td[3]/span");
		// Attachments on Purchaser info screen
		By IDCard = By.className("x22j"); // هوية أحوال مدنية
		By Passport = By.xpath("/html/body/div[1]/form/div[1]/div[2]/table/tbody/tr/td[2]/div/span/table/tbody/tr/td/div/div[1]/div[13]/div/div[1]/div/div[1]/div/div[2]/table/tbody/tr[3]/td[3]/label/table/tbody/tr/td[3]/span");// جواز سفر
		By SecurityCard = By.xpath("//*[@id=\"pt1:r1:0:pc1:t2:4:pgl50\"]/tbody/tr/td[3]/span");// بطاقة أمنية
		By ResidenceCard = By.xpath("//*[@id=\"pt1:r1:0:pc1:t2:2:pgl50\"]/tbody/tr/td[3]/span");// بطاقة إقامة
		By Others = By.xpath("");

		// Attachments on Property Info screen
		By OrganizationalChart = By.xpath("/html/body/div[1]/form/div[1]/div[2]/table/tbody/tr/td[2]/div/span/table/tbody/tr/td/div/div[1]/div[8]/table/tbody/tr/td/div/div[11]/div/div[1]/div/div/div[2]/div/div[2]/table/tbody/tr[1]/td[3]/label/table/tbody/tr/td[3]/span");// مخطط موقع تنظيمي

		By CoRegistrationCertificate = By.xpath("//*[@id=\"pt1:r1:1:pc1:t2:3:pgl50\"]/tbody/tr/td[3]/span");// شهادة تسجيل الشركة
		By ProfessionLicense = By.xpath("//*[@id=\\\"pt1:r1:1:pc1:t2:3:pgl50\\\"]/tbody/tr/td[3]/span");// رخصة المهن
		//By Lamane3 = By.xpath("/html/body/div[1]/form/div[1]/div[2]/table/tbody/tr/td[2]/div/span/table/tbody/tr/td/div/div[1]/div[8]/table/tbody/tr/td/div/div[11]/div/div[1]/div/div/div[2]/div/div[2]/table/tbody/tr[4]/td[3]/label/table/tbody/tr/td[3]/span");// كتاب لا مانع
		By Others2 = By.xpath("");
		By Lamane3=By.xpath("/html/body/div[1]/form/div[1]/div[2]/table/tbody/tr/td[2]/div/span/table/tbody/tr/td/div/div[1]/div[8]/table/tbody/tr/td/div/div[11]/div/div[1]/div/div/div[2]/div/div[2]/table/tbody/tr[2]/td[3]/label/table/tbody/tr/td[3]/span");
		// Attachments on Buyers attachments section
		By IDCardBuyer = By.className("//*[@id=\"pt1:r1:2:pc1:t2:0:pgl50\"]/tbody/tr/td[3]/span"); // هوية أحوال مدنية
		By FormalLetter = By.className("x22j"); // كتاب رسمي
		//	By FormalLetter = By.xpath("//*[@id=\"pt1:r1:2:pc1:t2:0:pgl50\"]/tbody/tr/td[3]/span"); // كتاب رسمي

		By PassportBuyer = By.xpath("");// جواز السفر
		
		// Attachments on Seller's attachments section 
		By IDCardSeller2 =By.xpath("//*[@id=\"pt1:r1:3:pc1:t2:0:pgl50\"]/tbody/tr/td[3]/span");
		By IDCardSeller = By.xpath("//*[@id=\"pt1:r1:2:pc1:t2:0:pgl50\"]/tbody/tr/td[3]/span"); // هوية أحوال مدنية
		By CoCommercialRecord = By.xpath("//*[@id=\"pt1:r1:2:pc1:t2:0:pgl50\"]/tbody/tr/td[3]/span");// سجل تجاري للشركة
		By PassportSeller = By.xpath("//*[@id=\"pt1:r1:2:pc1:t2:0:pgl50\"]/tbody/tr/td[3]/span");// جواز السفر
		
		//------------------------------------------------Purchaser Info ----------------------
		// معلومات المشتري 4 حقول
		By buyerInfofield1 = By.id("pt1:r1:2:it1::content");
		By buyerInfofield2 = By.id("pt1:r1:2:it2::content");
		By buyerInfofield3 = By.id("pt1:r1:2:it3::content");
		By buyerInfofield4 = By.id("pt1:r1:2:it4::content");

		By nameasinPassport = By.id("pt1:r1:2:it5::content"); // الاسم حسب جواز السفر
		By nationality = By.id("pt1:r1:2:soc2::content"); // الجنسية
		By phoneNumber = By.id("pt1:r1:2:it28::content"); // الهاتف
		By CountryCode = By.id("pt1:r1:2:soc7::content"); // الرمز الدولي
		By passportType = By.id("pt1:r1:2:soc8::content"); // نوع جواز السفر
		By passportNumber = By.id("pt1:r1:2:it20::content"); // رقم جواز السفر
		By productionDate = By.id("pt1:r1:2:id1::content"); // تاريخ الإصدار
		By ExpiryDate = By.id("pt1:r1:2:id5::content"); // تاريخ الانتهاء
		By productionLocation = By.id("pt1:r1:2:it21::content"); // مكان الإصدار
		By arrivalCountry = By.id("pt1:r1:2:soc1::content"); // بلد القدوم
		By placeOfBirth = By.id("pt1:r1:2:it32::content"); // مكان الولادة

		By birthDate = By.id("pt1:r1:2:id3::content");// تاريخ الولادة
		// لديك إقامة بالمملكة
		By NoResidency = By.xpath("//*[@id=\"pt1:r1:2:sor4:_0\"]");
		By YesResidency = By.id("pt1:r1:0:sor4:_1");

		By ResidencyNo = By.id("pt1:r1:0:it23::content"); // رقم الاقامة
		By ResidencyDate = By.id("pt1:r1:0:id6::content"); // تاريخ الاقامة

		// هل لديك عقارات داخل المملكة؟
		By noProperty = By.id("pt1:r1:2:sor2:_0");
		By yesProperty = By.id("pt1:r1:0:sor2:_1");

		By currentResidenceAddress = By.id("pt1:r1:2:it6::content");// عنوان الإقامة الحالية
		By Gender = By.id("pt1:r1:2:soc12::content"); // الجنس
		By socialStatus = By.id("pt1:r1:2:soc6::content"); // الحالة الاجتماعية
		By job = By.id("pt1:r1:2:it13::content");// المهنة
		By registrationNo = By.id("pt1:r1:2:it7::content"); // رقم الدخول
		By additionalInfo = By.id("pt1:r1:2:it24::content"); // معلومات اضافية

		// Radio Button جنسية أخرى
		By noOtherNationality = By.id("pt1:r1:2:sor1:_0");
		By yesOtherNationality = By.id("pt1:r1:2:sor1:_1");

		By AnotherNationality = By.id("pt1:r1:0:soc9::content"); // fields of الجنسية الاخرى
		By motherNationality = By.id("pt1:r1:2:soc4::content"); // جنسية الأم

		// هل المستدعى له داخل المملكة؟
		By outsideKindom = By.id("pt1:r1:2:sor5:_0"); // لا
		By insideKigdom = By.id("pt1:r1:2:sor5:_1"); // نعم

		// معلومات الام
		By MomFirstName = By.id("pt1:r1:2:it36::content");
		By MomSecondName = By.id("pt1:r1:2:it37::content");
		By MomThirdName = By.id("pt1:r1:2:it38::content");
		By MomLastName = By.id("pt1:r1:2:it39::content");
		By nextToPrpertyInfoFromPurchaserInfo = By.xpath("/html/body/div[1]/form/div[1]/div[2]/table/tbody/tr/td[2]/div/span/table/tbody/tr/td/div/div[1]/div[14]/table/tbody/tr/td[4]/div/a/span");
		By NextToWifeHusbandScn = By.xpath("/html/body/div[1]/form/div[1]/div[2]/table/tbody/tr/td[2]/div/span/table/tbody/tr/td/div/div[1]/div[14]/table/tbody/tr/td[4]/div/a/span");
		
		By addMultiBuyers=By.xpath("/html/body/div[1]/form/div[1]/div[2]/table/tbody/tr/td[2]/div/span/table/tbody/tr/td/div/div[1]/div[7]/table/tbody/tr/td[2]/table/tbody/tr/td[1]/div/a/span"); // NEW
		
		
		// -------------------------------------Second Buyer Info-----------------------------
		By buyer2Infofield1 = By.id("pt1:r1:0:it1::content");
		By buyer2Infofield2 = By.id("pt1:r1:0:it2::content");
		By buyer2Infofield3 = By.id("pt1:r1:0:it3::content");
		By buyer2Infofield4 = By.id("pt1:r1:0:it4::content");

		By nameasinPassport2 = By.id("pt1:r1:0:it5::content"); // الاسم حسب جواز السفر
		By nationality2 = By.id("pt1:r1:0:soc2::content"); // الجنسية
		By phoneNumber2 = By.id("pt1:r1:0:it28::content"); // الهاتف
		By CountryCode2 = By.id("pt1:r1:0:soc7::content"); // الرمز الدولي
		By passportType2 = By.id("pt1:r1:0:soc8::content"); // نوع جواز السفر
		By passportNumber2 = By.id("pt1:r1:0:it20::content"); // رقم جواز السفر
		By productionDate2 = By.id("pt1:r1:0:id1::content"); // تاريخ الإصدار
		By ExpiryDate2 = By.id("pt1:r1:0:id5::content"); // تاريخ الانتهاء
		By productionLocation2 = By.id("pt1:r1:0:it21::content"); // مكان الإصدار
		By arrivalCountry2 = By.id("pt1:r1:0:soc1::content"); // بلد القدوم
		By placeOfBirth2 = By.id("pt1:r1:0:it32::content"); // مكان الولادة

		By birthDate2 = By.id("pt1:r1:0:id3::content");// تاريخ الولادة
		// لديك إقامة بالمملكة
		By NoResidency2 = By.id("pt1:r1:0:sor4:_0");
		By YesResidency2 = By.id("pt1:r1:0:sor4:_1");

		By ResidencyNo2 = By.id("pt1:r1:0:it23::content"); // رقم الاقامة
		By ResidencyDate2 = By.id("pt1:r1:0:id6::content"); // تاريخ الاقامة

		// هل لديك عقارات داخل المملكة؟
		By noProperty2 = By.id("pt1:r1:2:sor2:_0");
		By yesProperty2 = By.id("pt1:r1:0:sor2:_1");

		By currentResidenceAddress2 = By.id("pt1:r1:0:it6::content");// عنوان الإقامة الحالية
		By Gender2 = By.id("pt1:r1:0:soc12::content"); // الجنس
		By socialStatus2 = By.id("pt1:r1:0:soc6::content"); // الحالة الاجتماعية
		By job2 = By.id("pt1:r1:0:it13::content");// المهنة
		By registrationNo2 = By.id("pt1:r1:0:it7::content"); // رقم الدخول
		By additionalInfo2 = By.id("pt1:r1:0:it24::content"); // معلومات اضافية

		// Radio Button جنسية أخرى
		By noOtherNationality2 = By.id("pt1:r1:0:sor1:_0");
		By yesOtherNationality2 = By.id("pt1:r1:0:sor1:_1");

		By AnotherNationality2 = By.id("pt1:r1:0:soc9::content"); // fields of الجنسية الاخرى
		By motherNationality2= By.id("pt1:r1:0:soc4::content"); // جنسية الأم

		// هل المستدعى له داخل المملكة؟
		By outsideKindom2 = By.id("pt1:r1:0:sor5:_0"); // لا
		By insideKigdom2 = By.id("pt1:r1:0:sor5:_1"); // نعم

		// معلومات الام
		By MomFirstName2 = By.id("pt1:r1:0:it36::content");
		By MomSecondName2 = By.id("pt1:r1:0:it37::content");
		By MomThirdName2 = By.id("pt1:r1:0:it38::content");
		By MomLastName2 = By.id("pt1:r1:0:it39::content");
		By nextToPrpertyInfoFromPurchaserInfo2 = By.xpath("/html/body/div[1]/form/div[1]/div[2]/table/tbody/tr/td[2]/div/span/table/tbody/tr/td/div/div[1]/div[14]/table/tbody/tr/td[4]/div/a/span");
		By NextToWifeHusbandScn2 = By.xpath("/html/body/div[1]/form/div[1]/div[2]/table/tbody/tr/td[2]/div/span/table/tbody/tr/td/div/div[1]/div[14]/table/tbody/tr/td[4]/div/a/span");
		
		
		
		
		
		
		//----------------------------------------- Property Info------------------------------------
		// معلومات العقار الاصلي في حالة سكن توسعة *NEW
		By addOriginalPropertyButton=By.id("pt1:r1:1:b5");
		By Directorate=By.id("pt1:r1:3:soc5::content");
		By village=By.id("pt1:r1:3:soc1::content");
		By BuildingNo=By.id("pt1:r1:3:it6::content");
		By BasinNo=By.id("pt1:r1:3:it6::content");
		By neighbourhoodNo=By.id("pt1:r1:3:soc3::content");
		By apartmentNo=By.id("pt1:r1:3:it1::content");
		By plateNo=By.id("pt1:r1:3:soc4::content");
		By propertyType=By.id("pt1:r1:3:soc6::content");
		By licenseNo=By.id("pt1:r1:3:it3::content");
		By landNo=By.id("pt1:r1:3:it5::content");
		By FloorNo =By.id("pt1:r1:3:it7::content");
		By saveAddedOriginalProperty=By.id("pt1:r1:3:b1");
		
	
	
		// -------------------------------------------------WifeHusband Info-----------------------
		//
		 
		// معلومات الزوجة / الزوج
		By BuyerName = By.id("pt1:r1:2:soc4::content");
		
		By addSpouseInfoButton = By.xpath("/html/body/div[1]/form/div[1]/div[2]/table/tbody/tr/td[2]/div/span/table/tbody/tr/td/div/div[1]/div[11]/table/tbody/tr/td[2]/div/a/span");  
		By deleteButton = By.xpath("//*[@id=\"pt1:r1:2:b4\"]/a");
		By NextToPropertyScnfromWifeSCN = By.xpath("/html/body/div[1]/form/div[1]/div[2]/table/tbody/tr/td[2]/div/span/table/tbody/tr/td/div/div[1]/div[16]/table/tbody/tr/td[3]/div/a/span");
		By spousefirstName=By.id("pt1:r1:3:it3::content");
		By spouseSecondName=By.id("pt1:r1:3:it4::content");
		By spouseThirdName=By.id("pt1:r1:3:it5::content");
		By spouseLastName=By.id("pt1:r1:3:it14::content");
		By spouseNationality=By.id("pt1:r1:3:soc2::content");
		By spouseMomfirstName=By.id("pt1:r1:3:it12::content");
		By spouseMomSecondName=By.id("pt1:r1:3:it10::content");
		By spouseMomThirdName=By.id("pt1:r1:3:it11::content");
		By spouseMomFourthName=By.id("pt1:r1:3:it13::content");
		By spouseMomNationality=By.id("pt1:r1:3:soc3::content");
		// ----------------------------------------Property Info-----------------------------------
		// معلومات العقار/العقارات المُراد شراؤها

		By recordNo2 = By.id("pt1:r1:4:it25::content"); // رقم القيد بعد صفحة معلومات الزوج
		By recordNo = By.id("pt1:r1:3:it25::content");  // رقم القيد
		By DLSKeyButton = By.id("pt1:r1:3:cb1");
		By DLSKeyButton2=By.id("pt1:r1:4:cb1");
		By schemeNo2=By.id("pt1:r1:4:it1::content");
		By schemeNo = By.id("pt1:r1:3:it1::content"); // الرقم المميز للمخطط
		By addPropertyButton = By.xpath("/html/body/div[1]/form/div[1]/div[2]/table/tbody/tr/td[2]/div/span/table/tbody/tr/td/div/div[1]/div[6]/table/tbody/tr/td[2]/table/tbody/tr/td[1]/div/a/span");
		By OwnersCheckbox = By.xpath("//*[@id=\"pt1:r1:3:pc2:t5:0:sbc2::content\"]");
		// By SearchButton=By.id("pt1:r1:1:cb1"); // button البحث عن طريق رقم القيد
		By checkownersA = By.id("pt1:r1:3:pc2:t5:0:sbc2::content"); // الرجاء اختيار البائعين من قائمة المالكين
		By checkownersB = By.id("pt1:r1:1:pc2:t5:1:sbc2::content"); // - أكثر من بائع - الرجاء اختيار البائعين من قائمة
		By checkownersA1=By.id("pt1:r1:4:pc2:t5:0:sbc2::content"); 
		By CheckOwnersMultiProperty=By.id("pt1:r1:3:pc2:t5:1:sbc2::content");
		By checkownersA2= By.id("pt1:r1:2:pc2:t5:1:sbc2::content");
	    By NonJordanianOwner=By.id("pt1:r1:1:pc2:t5:7:sbc2::content");
		By NextToSellerAttach = By.xpath("/html/body/div[1]/form/div[1]/div[2]/table/tbody/tr/td[2]/div/span/table/tbody/tr/td/div/div[1]/div[10]/table/tbody/tr/td[4]/div/a/span");													// المالكين
	    By NextToSellerAttach2 = By.xpath("/html/body/div[1]/form/div[1]/div[2]/table/tbody/tr/td[2]/div/span/table/tbody/tr/td/div/div[1]/div[10]/table/tbody/tr/td[4]/div/a/span");
	 
		// use next for التالي
		
		
		 
		

		// use next for التالي
		// --------------------------------------------------Buyers Info---------------------------
		// مرفقات البائعين
	    By Properties = By.id("pt1:r1:4:soc1::content"); // العقارات
		By Owners = By.id("pt1:r1:4:soc2::content"); // المالكين
		By NextToLinkPurchaserandSellers  = By.xpath("/html/body/div[1]/form/div[1]/div[2]/table/tbody/tr/td[2]/div/span/table/tbody/tr/td/div/div[1]/div[9]/table/tbody/tr/td[4]/div/a/span"); //  التالي
	    By NextToLinkPurchaserandSellers2 =By.xpath("/html/body/div[1]/form/div[1]/div[2]/table/tbody/tr/td[2]/div/span/table/tbody/tr/td/div/div[1]/div[9]/table/tbody/tr/td[4]/div/a/span");
	    By Properties2=By.id("pt1:r1:5:soc1::content");
	    By Owners2=By.id("pt1:r1:5:soc2::content");
		

		//-----------------------Link Purchaser with Buyers---------------------
	    By buyerName = By.id("pt1:r1:5:soc2::content"); // اسم المشتري
	    By buyerName2 = By.id("pt1:r1:6:soc2::content"); // اسم المشتري
	    By PropertiesA2 = By.id("pt1:r1:5:soc1::content"); // العقارات
	    By PropertiesB2 = By.id("pt1:r1:6:soc1::content"); // العقارات
	    By ownerName = By.id("pt1:r1:5:soc3::content");// اسم المالك
	    By ownerName2 = By.id("pt1:r1:6:soc3::content");// اسم المالك
	    By areatoBeOwnedNum = By.id("pt1:r1:5:it11::content"); // المساحة المراد تملكها رقما
	    By areatoBeOwnedNum2 = By.id("pt1:r1:6:it11::content"); // المساحة المراد تملكها رقما
	    By areatoBeOwned = By.id("pt1:r1:5:it1::content"); // المساحة المراد تملكها كتابة
	    By areatoBeOwned2 = By.id("pt1:r1:6:it1::content"); // المساحة المراد تملكها كتابة
	    By numberofProportions = By.id("pt1:r1:5:it3::content"); // الحصص المراد تملكها رقما
	    By numberofProportions2 = By.id("pt1:r1:6:it3::content"); // الحصص المراد تملكها رقما
	    By NextToReviewSection = By.xpath("/html/body/div[1]/form/div[1]/div[2]/table/tbody/tr/td[2]/div/span/table/tbody/tr/td/div/div[1]/div[8]/table/tbody/tr/td[4]/div/a"); // التالي
	    By NextToReviewSection2 = By.xpath("/html/body/div[1]/form/div[1]/div[2]/table/tbody/tr/td[2]/div/span/table/tbody/tr/td/div/div[1]/div[8]/table/tbody/tr/td[4]/div/a/span"); // التالي
	    By addLinkPurchaserWithBuyer=By.xpath("/html/body/div[1]/form/div[1]/div[2]/table/tbody/tr/td[2]/div/span/table/tbody/tr/td/div/div[1]/div[3]/table/tbody/tr/td[2]/div/a/span");
		//--------------------------------------------Review ------------------------------------------
		// مراجعة الطلب
		By submitRequest = By.xpath("/html/body/div[1]/form/div[1]/div[2]/table/tbody/tr/td[2]/div/span/table/tbody/tr/td/div/div[1]/div[17]/table/tbody/tr/td[5]/div/a/span"); // تقديم طلب 
		By submitRequest2 = By.xpath("/html/body/div[1]/form/div[1]/div[2]/table/tbody/tr/td[2]/div/span/table/tbody/tr/td/div/div[1]/div[17]/table/tbody/tr/td[5]/div/a/span"); // تقديم طلب
		By agreeButton=By.xpath("/html/body/div/form/div[1]/div[2]/table/tbody/tr/td[2]/div/span/table/tbody/tr/td/div/div[1]/div[2]/table/tbody/tr/td[2]/div/div/div/div/div[5]/div/a/span"); // اوافق 
		// Epayment
		By EpaymentLink=By.xpath("/html/body/div[1]/form/div[1]/div[2]/table/tbody/tr/td[2]/div/span/table/tbody/tr/td/div/div[2]/div[3]/span/div[3]/div[9]/div/div[1]/div[1]/table/tbody/tr/td[1]/div/a/span");
		By feesDetails=By.id("pt1:r1:1:pc1:t4:0:l3::text");
		
	}

