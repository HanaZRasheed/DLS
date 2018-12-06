package dls;

import org.openqa.selenium.By;

public class Fields {
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
	By judicialAgencyNo = By.id("pt1:r1:1:it7::content"); //وكيل مشتري
	By judicialAgencyDate = By.id("pt1:r1:1:id2::content"); //*تاريخ الوكالة العدلية
	By permitField1 = By.id("pt1:r1:1:it12::content");
	By permitField2 = By.id("pt1:r1:1:it13::content");
	
	By nextToPurchaseInfo = By.xpath("//*[@id=\"pt1:r1:1:b2\"]/a");	
    By AddOriginalProperty = By.id("pt1:r1:1:b5");
    By AddPurchaser = By.id("pt1:r1:2:b5");
    By OtherPurpose = By.id("pt1:r1:1:it11::content");
//-----------Original Property----------------------------
    By BackToApplicantInfo = By.id("pt1:r1:2:b3");
	// ----------------ATTACHMENTS--------------------------
	// Attachments on Applicant Info Screen
	By AuthorizationLetter = By.xpath("");// كتاب تفويض
	By PowerofAttorney = By.xpath("//*[@id=\"pt1:r1:1:pc1:t2:0:pgl50\"]/tbody/tr/td[3]/span");// صورة وكالة عدلية

	// Attachments on Purchaser info screen
	By IDCard = By.className("x22j"); // هوية أحوال مدنية
	By Passport = By.xpath("//*[@id=\"pt1:r1:2:pc1:t2:5:pgl50\"]/tbody/tr/td[3]/span");// جواز سفر
	By SecurityCard = By.xpath("//*[@id=\"pt1:r1:0:pc1:t2:4:pgl50\"]/tbody/tr/td[3]/span");// بطاقة أمنية
	By ResidenceCard = By.xpath("//*[@id=\"pt1:r1:0:pc1:t2:2:pgl50\"]/tbody/tr/td[3]/span");// بطاقة إقامة
	By Others = By.xpath("");

	// Attachments on Property Info screen
	By OrganizationalChart = By.xpath("//*[@id=\\\"pt1:r1:1:pc1:t2:2:pgl50\\\"]/tbody/tr/td[3]/span");// مخطط موقع تنظيمي
	By CoRegistrationCertificate = By.xpath("//*[@id=\\\"pt1:r1:1:pc1:t2:2:pgl50\\\"]/tbody/tr/td[3]/span");// شهادة تسجيل الشركة
	By ProfessionLicense = By.xpath("//*[@id=\\\"pt1:r1:1:pc1:t2:3:pgl50\\\"]/tbody/tr/td[3]/span");// رخصة المهن
	By Lamane3 = By.xpath("");// كتاب لا مانع
	By Others2 = By.xpath("");
	
	// Attachments on Seller's attachments section 
	By IDCardSeller2 =By.xpath("//*[@id=\"pt1:r1:3:pc1:t2:0:pgl50\"]/tbody/tr/td[3]/span");
	By IDCardSeller = By.xpath("//*[@id=\"pt1:r1:2:pc1:t2:0:pgl50\"]/tbody/tr/td[3]/span"); // هوية أحوال مدنية
	By FormalLetter = By.xpath("//*[@id=\"pt1:r1:2:pc1:t2:0:pgl50\"]/tbody/tr/td[3]/span"); // كتاب رسمي
	By CoCommercialRecord = By.xpath("//*[@id=\"pt1:r1:2:pc1:t2:0:pgl50\"]/tbody/tr/td[3]/span");// سجل تجاري للشركة
	By PassportSeller = By.xpath("//*[@id=\"pt1:r1:2:pc1:t2:0:pgl50\"]/tbody/tr/td[3]/span");// جواز السفر

	//------------------------------------------------Purchaser Info ----------------------
	// معلومات المشتري 4 حقول
	By BuyerFields1 = By.id("pt1:r1:2:it1::content"); 
	By BuyerFields2 = By.id("pt1:r1:2:it2::content");
	By BuyerFields3 = By.id("pt1:r1:2:it3::content");
	By BuyerFields4 = By.id("pt1:r1:2:it4::content");
	By nameasinPassport = By.id("pt1:r1:2:it5::content"); // الاسم حسب جواز السفر
	By nationality = By.id("pt1:r1:2:soc2::content"); // الجنسيةغ
	By Othernationality = By.id("pt1:r1:2:soc9::content"); //  جنسية أخرى

	By phoneNumber = By.id("pt1:r1:2:it28::content"); // الهاتف
	By CountryCode = By.id("pt1:r1:2:soc7::content"); // الرمز الدولي
	By passportType = By.id("pt1:r1:2:soc8::content"); // نوع جواز السفر
	By passportNumber = By.id("pt1:r1:2:it20::content"); // رقم جواز السفر
	By productionDate = By.id("pt1:r1:2:id1::content"); // تاريخ الإصدار
	By ExpiryDate = By.id("pt1:r1:2:id5::content"); // تاريخ الانتهاء
	By productionLocation = By.id("pt1:r1:2:soc3::content"); //  مكان الإصدار
	By arrivalCountry = By.id("pt1:r1:2:soc1::content"); //  بلد القدوم
	By placeOfBirth = By.id("pt1:r1:2:soc10::content"); // مكان الولادة

	By birthDate = By.id("pt1:r1:2:id3::content");// تاريخ الولادة
	// لديك إقامة بالمملكة
	By NoResidency = By.xpath("//*[@id=\"pt1:r1:2:sor4:_0\"]");
	By YesResidency = By.id("pt1:r1:0:sor4:_1");
	By YesResidency2 = By.id("pt1:r1:2:sor4");	
	By ResidencyNo = By.id("pt1:r1:2:it23::content"); // رقم الاقامة
	By ResidencyDate = By.id("pt1:r1:2:id6::content"); // تاريخ الاقامة

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
	By nextToPrpertyInfoFromPurchaserInfo = By.id("pt1:r1:2:b2");
	By NextToWifeHusbandScn = By.id("pt1:r1:2:b2");

	// -------------------------------------------------WifeHusband Info-----------------------
	//
	// معلومات الزوجة / الزوج
	By SellerName = By.id("pt1:r1:2:soc4::content");
	By addButton = By.id("pt1:r1:1:b5");
	By deleteButton = By.xpath("//*[@id=\"pt1:r1:2:b4\"]/a");
	By NextToPropertyScnfromWifeSCN = By.id("pt1:r1:1:b2");
	By spousefirstName=By.id("pt1:r1:1:it3::content");
	By spouseSecondName=By.id("pt1:r1:1:it4::content");
	By spouseThirdName=By.id("pt1:r1:1:it5::content");
	By spouseLastName=By.id("pt1:r1:1:it14::content");
	By spouseNationality=By.id("pt1:r1:1:soc2::content");
	By spouseMomfirstName=By.id("pt1:r1:1:it12::content");
	By spouseMomSecondName=By.id("pt1:r1:1:it10::content");
	By spouseMomThirdName=By.id("pt1:r1:1:it11::content");
	By spouseMomFourthName=By.id("pt1:r1:1:it13::content");
	By spouseMomNationality=By.id("pt1:r1:1:soc3::content");
	// ----------------------------------------Property Info-----------------------------------
	// معلومات العقار/العقارات المُراد شراؤها

	By recordNo2 = By.id("pt1:r1:2:it25::content"); // رقم القيد بعد صفحة معلومات الزوج
	By recordNo = By.id("pt1:r1:3:it25::content");  // رقم القيد
	By DLSKeyButton = By.id("pt1:r1:3:cb1");
	By DLSKeyButton2=By.id("pt1:r1:2:cb1");
	By schemeNo2=By.id("pt1:r1:2:it1::content");
	By schemeNo = By.id("pt1:r1:3:it1::content"); // الرقم المميز للمخطط
	By addPropertyButton = By.xpath("//*[@id=\"pt1:r1:3:b5\"]/a/span");
	By OwnersCheckbox = By.xpath("pt1:r1:1:pc2:t5:0:sbc2::content");
	// By SearchButton=By.id("pt1:r1:1:cb1"); // button البحث عن طريق رقم القيد
	By checkownersA = By.id("pt1:r1:1:pc2:t5:0:sbc2::content"); // الرجاء اختيار البائعين من قائمة المالكين
	By checkownersB = By.id("pt1:r1:1:pc2:t5:3:sbc2::content"); // - أكثر من بائع - الرجاء اختيار البائعين من قائمة
	By checkownersA1=By.id("pt1:r1:2:pc2:t5:0:sbc2::content");
    By NonJordanianOwner=By.id("pt1:r1:1:pc2:t5:7:sbc2::content");
	By NextToSellerAttach = By.id("pt1:r1:3:b2");													// المالكين
    By NextToSellerAttach2 = By.id("pt1:r1:2:b2");
	// use next for التالي
	// --------------------------------------------------Sellers Info---------------------------
	// مرفقات البائعين
    By Properties = By.id("pt1:r1:2:soc1::content"); // العقارات
	By Owners = By.id("pt1:r1:2:soc2::content"); // المالكين
	By NextToLinkPurchaserandSellers = By.id("pt1:r1:4:b466666666"); // التالي
    By NextToLinkPurchaserandSellers2 =By.id("pt1:r1:3:b466666666");
	//-----------------------Link Purchaser with Sellers---------------------
	
    By VendorName = By.id("pt1:r1:5:soc2::content"); // اسم المشتري
    By VendorName2 = By.id("pt1:r1:4:soc2::content"); // اسم المشتري
    By PropertiesA2 = By.id("pt1:r1:5:soc1::content"); // العقارات
    By PropertiesB2 = By.id("pt1:r1:4:soc1::content"); // العقارات
    By ownerName = By.id("pt1:r1:5:soc3::content");// اسم المالك
    By ownerName2 = By.id("pt1:r1:4:soc3::content");// اسم المالك
    By areatoBeOwnedNum = By.id("pt1:r1:5:it11::content"); // المساحة المراد تملكها رقما
    By areatoBeOwnedNum2 = By.id("pt1:r1:4:it11::content"); // المساحة المراد تملكها رقما
    By areatoBeOwned = By.id("pt1:r1:5:it1::content"); // المساحة المراد تملكها كتابة
    By areatoBeOwned2 = By.id("pt1:r1:4:it1::content"); // المساحة المراد تملكها كتابة
    By numberofProportions = By.id("pt1:r1:5:it9::content"); // الحصص المراد تملكها رقما
    By numberofProportions2 = By.id("pt1:r1:4:it9::content"); // الحصص المراد تملكها رقما
    By NextToReviewSection = By.id("pt1:r1:5:b12"); // التالي
    By NextToReviewSection2 = By.id("pt1:r1:4:b12"); // التالي
	//--------------------------------------------Review ------------------------------------------
	// مراجعة الطلب
	By submitRequest = By.id("pt1:r1:6:b1"); // تقديم طلب
	By submitRequest2 = By.id("pt1:r1:5:b1"); // تقديم طلب
	//----------------------------------------- Property Info------------------------------------
			// معلومات العقار الاصلي في حالة سكن توسعة *NEW
			By addOriginalPropertyButton=By.id("pt1:r1:1:b5");
			By Directorate=By.id("pt1:r1:2:soc5::content");
			By Village=By.id("pt1:r1:2:soc1::content");
			By BuildingNo=By.id("pt1:r1:2:it6::content");
			By BasinNo=By.id("pt1:r1:2:it6::content");
			By neighbourhoodNo=By.id("pt1:r1:2:soc3::content");
			By apartmentNo=By.id("pt1:r1:2:it1::content");
			By plateNo=By.id("pt1:r1:2:soc4::content");
			By PropertyType=By.id("pt1:r1:2:soc6::content");
			By licenseNo=By.id("pt1:r1:2:it3::content");
			By landNo=By.id("pt1:r1:0:it5::content");
			By FloorNo =By.id("pt1:r1:2:it7::content");
			By saveAddedOriginalProperty=By.id("pt1:r1:2:b1");
			By Hodd = By.id("pt1:r1:2:soc2::content");
		
		
}
