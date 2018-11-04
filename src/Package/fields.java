package Package;

import org.openqa.selenium.By;

public class fields  {
	// Log-in page
	By username = By.xpath("//*[@id=\"pt1:it1::content\"]");
	By Password=By.id("pt1:it2::content");
	By forgetPasswordLink=By.id("pt1:l2::text");
	By LoginButton=By.xpath("//*[@id=\"pt1:b1\"]/a");
	
	// تقديم طلب الحصول على موافقة تملّك لغير الأردنيين

	By NonJordanianPropertyApproval=By.id("pt2:i1:2:sdi1::tia"); // موافقة تملّك لغير الأردنيين
	By validationCode=By.id("pt1:s1:it15::content"); // رمز التحقق
	By continueButton=By.id("pt1:s1:b7"); //  زر استمرار
	By ApprovalcheckBox=By.id("pt1:r1:0:sbc2::content"); // موافقة
	By nextButton= By.xpath("//*[@id=\"pt1:r1:0:b1\"]/a/span");  // زر التالي
	By ApplicantType=By.id("pt1:r1:1:soc1::content"); //  نوع مقدم الطلب
	By ExpressRequestCheckBox =By.id("pt1:r1:1:sbc1::content"); // طلب مستعجل
	// المشتري Fields
	
// نوع طلب الموافقة على التملّك
	By InternalRequestApprovalRadio=By.id("pt1:r1:1:sor1:_0"); // داخل التنظيم
	By ExternalRequestApprovalRadio=By.id("pt1:r1:1:sor1:_1"); // خارج التنظيم
	
	By PurposeOfPossession=By.id("pt1:r1:1:soc6::content"); // الغاية الرئيسية من التملك
	By SecondaryPurposeOfPossession=By.id("pt1:r1:1:soc7::content");// الغاية الفرعية من التملك
	By OtherField=By.id("pt1:r1:1:it11::content");// أخرى
	// صناعة and مكاتب-تجارية fields
	By InstituteNationalNo=By.id("pt1:r1:1:it10::content"); //الرقم الوطني للمنشأة
	
	//وكيل مشتري and وكيل بائع fields
	By judicialAgencyNo=By.id("pt1:r1:1:it7::content"); //
	By judicialAgencyDate =By.id("pt1:r1:1:id2::content");
	By permitField1=By.id("pt1:r1:1:it12::content");
	By permitField2=By.id("pt1:r1:1:it13::content");
	By next=By.xpath("//*[@id=\"pt1:r1:1:b2\"]/a");
	
	// معلومات المشتري 4 حقول
	By buyerInfofield1=By.id("pt1:r1:2:it1::content");
	By buyerInfofield2=By.id("pt1:r1:2:it2::content");
	By buyerInfofield3=By.id("pt1:r1:2:it3::content");
	By buyerInfofield4=By.id("pt1:r1:2:it4::content");
	
	By nameasinPassport=By.id("pt1:r1:2:it5::content"); //الاسم حسب جواز السفر
	By nationality=By.id("pt1:r1:2:soc2::content"); // الجنسية
	By phoneNumber=By.id("pt1:r1:2:it28::content"); // الهاتف
	By CountryCode=By.id("pt1:r1:2:soc7::content"); // الرمز الدولي
	By passportType=By.id("pt1:r1:2:soc8::content"); // نوع جواز السفر
	By passportNumber=By.id("pt1:r1:2:it20::content"); // رقم جواز السفر
	By productionDate=By.id("pt1:r1:2:id1::content"); // تاريخ الإصدار
	By ExpiryDate=By.id("pt1:r1:2:id5::content"); // تاريخ الانتهاء
	By productionLocation=By.id("pt1:r1:2:it21::content"); // مكان الإصدار
	By arrivalCountry=By.id("pt1:r1:2:soc1::content"); // بلد القدوم
	By placeOfBirth=By.id("pt1:r1:2:it32::content");  // مكان الولادة
	
	By birthDate=By.id("pt1:r1:2:id3::content");//تاريخ الولادة
	// لديك إقامة بالمملكة
	By NoResidency=By.xpath("//*[@id=\"pt1:r1:2:sor4:_0\"]");
	By YesResidency=By.id("pt1:r1:0:sor4:_1");
	
	By ResidencyNo=By.id("pt1:r1:0:it23::content"); //  رقم الاقامة
	By ResidencyDate=By.id("pt1:r1:0:id6::content"); // تاريخ الاقامة
	
	// هل لديك عقارات داخل المملكة؟
	By noProperty=By.id("pt1:r1:2:sor2:_0");
	By yesProperty=By.id("pt1:r1:0:sor2:_1");
	
	By currentResidenceAddress=By.id("pt1:r1:2:it6::content");// عنوان الإقامة الحالية
	By Gender=By.id("pt1:r1:2:soc12::content"); // الجنس
	By socialStatus=By.id("pt1:r1:2:soc6::content"); // الحالة الاجتماعية
	By job=By.id("pt1:r1:2:it13::content");// المهنة
	By registrationNo=By.id("pt1:r1:2:it7::content"); // رقم الدخول
	By additionalInfo=By.id("pt1:r1:2:it24::content"); // معلومات اضافية
	
	//  Radio Button جنسية أخرى
	By noOtherNationality=By.id("pt1:r1:2:sor1:_0");
	By yesOtherNationality=By.id("pt1:r1:2:sor1:_1");
	
	By AnotherNationality=By.id("pt1:r1:0:soc9::content"); //  fields of  الجنسية الاخرى
	By motherNationality=By.id("pt1:r1:0:soc4::content"); // جنسية الأم
	
	// هل المستدعى له داخل المملكة؟
	By outsideKindom=By.id("pt1:r1:0:sor5:_0"); // لا
	By insideKigdom=By.id("pt1:r1:0:sor5:_1"); //  نعم	
	
	// معلومات الام 
	By MomFirstName=By.id("pt1:r1:0:it36::content");
	By MomSecondName=By.id("pt1:r1:0:it37::content");
	By MomThirdName=By.id("pt1:r1:0:it38::content");
	By MomLastName=By.id("pt1:r1:0:it39::content");
	By chooseFile=By.xpath("//*[@id=\"pt1:r1:0:pc1:t2:0:pgl50\"]/tbody/tr/td[3]/span");
	By chooseFile1=By.xpath("//*[@id=\"pt1:r1:0:pc1:t2:1:pgl50\"]/tbody/tr/td[3]/span");
	
	By Nxt=By.xpath("//*[@id=\"pt1:r1:0:b2\"]/a");
	By AddButton=By.xpath("//*[@id=\"pt1:r1:0:b5\"]/a");
	
	
	// معلومات الزوجة / الزوج
	By BuyerName=By.id("pt1:r1:2:soc4::content");
	By addButton=By.xpath("/html/body/div[1]/form/div[1]/div[2]/table/tbody/tr/td[2]/div/span/table/tbody/tr/td/div/div[1]/div[11]/table/tbody/tr/td[2]/div/a");
	By deleteButton=By.xpath("//*[@id=\"pt1:r1:2:b4\"]/a");
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
	
	
	
	
	// معلومات العقار/العقارات المُراد شراؤها
	By recordNo=By.id("pt1:r1:1:it25::content");	// رقم القيد  
	
	By schemeNo=By.id("pt1:r1:1:it1::content"); //الرقم المميز للمخطط
	By SearchButton=By.id("pt1:r1:1:cb1"); //    button البحث عن طريق رقم القيد
	By addPropertyButton=By.xpath("//*[@id=\"pt1:r1:1:b5\"]/a/span"); // اضافة عقار
	By checkowners=By.id("pt1:r1:1:pc2:t5:0:sbc2::content"); // الرجاء اختيار البائعين من قائمة المالكين
	By checkOwners=By.id("pt1:r1:1:pc2:t5:1:sbc2::content"); // الرجاء اختيار البائعين من قائمة المالكين
	By choosefile2=By.xpath("//*[@id=\"pt1:r1:1:pc1:t2:0:pgl50\"]/tbody/tr/td[3]/span"); //  *سند التسجيل
	By choosefile3=By.xpath("//*[@id=\"pt1:r1:1:pc1:t2:1:pgl50\"]/tbody/tr/td[3]/span"); // *مخطط الأراضي
	By choosefile4=By.xpath("//*[@id=\"pt1:r1:1:pc1:t2:2:pgl50\"]/tbody/tr/td[3]/span"); // شهادة تسجيل الشركة
	By choosefile5=By.xpath("//*[@id=\"pt1:r1:1:pc1:t2:3:pgl50\"]/tbody/tr/td[3]/span"); // رخصة المهن
	By choosefile6=By.xpath("//*[@id=\"pt1:r1:1:pc1:t2:4:pgl50\"]/tbody/tr/td[3]/span"); // *موافقة وزارة الزراعة
	By choosefile7=By.xpath("//*[@id=\"pt1:r1:1:pc1:t2:2:pgl50\"]/tbody/tr/td[3]/span"); // 	مخطط الموقع التنظيمي
	// use next for التالي
	
	// مرفقات البائعين
	By Properties=By.id("pt1:r1:2:soc1::content"); // العقارات
	By Owners=By.id("pt1:r1:2:soc2::content"); // المالكين
	By chooseFile7=By.xpath(""); // هوية الاحوال المدنية
	By NEXT=By.id("pt1:r1:2:b466666666"); // التالي
	
	// ربط المشتريين مع البائعين
	By buyerName=By.id("pt1:r1:3:soc2::content"); // اسم المشتري
	By Properties2=By.id("pt1:r1:3:soc1::content"); //العقارات	
	By ownerName=By.id("pt1:r1:3:soc3::content");// اسم المالك
	By areatoBeOwnedNum=By.id("pt1:r1:3:it11::content"); //المساحة المراد تملكها رقما 	
	By areatoBeOwned=By.id("pt1:r1:3:it1::content"); // المساحة المراد تملكها كتابة	
	By numberofProportions=By.id("pt1:r1:3:it9::content"); //الحصص المراد تملكها رقما
	By Next=By.xpath(""); //  التالي 
	
	// مراجعة الطلب
	By submitRequest=By.xpath(""); // تقديم طلب  
	
	
}
