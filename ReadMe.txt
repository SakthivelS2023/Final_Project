Topic Name: Display Bookshelves
 
Problem Statement: Display Bookshelves  

Display Bookshelves
-------------------

Detailed Description: 
1. Display the name & price of first 3 Bookshelves below Rs. 15000, with Storage type as open & exclude out of stock
2. From Collections, retrieve all sub-menu items under By-At-home and store in a List; Display the same
3. Gift cards - choose "Birthday/Anniversay"; fill customize the gift card; fill from to details with any one input invalid (example: email); Capture & display the error message
  
 
Key Automation Scope:  
1.Handling alert, drag & drop, search option
2.Extract menu items & store in collections
3.Navigating back to home page
4.Scrolling down in web page
5.Filling form (in different objects in web page)
6.Capture warning message

 
 
About this Project:
Project folder	:Hackathon 

src/test/java	:Contains 3 packages and each package have different classes
			1)pageObjectModel
				-bsElement.java
				-TC_001_Verify_Website.java
				-TC_002_DisplayBookShelves.java
				-TC_003_FilterBookShelves.java
                                -TC_004_GiftCard.java
                                -TC_005_GiftCardFormsNegative.java
                                -TC_006_GiftCardFormsPositive.java
			2)test_Book
				-BaseClass.java
			3)utilities
				-ExtentReportManager.java

	
Reports		:Contains-
			1)ScreenShot folder 
                           -BookShelves-SS.png
                           -Error_Message-SS.png
                           -GiftCard-SS.png
                           -HomePage-SS.png
		 	2)Report folder
                           -Test-Report.html
		 	3)ExtentReport-SS folder
                           -ByAtHomeExtentReport_SS..png
                           -displayBookShelvesExtentReport_SS.png
                           -giftCardExtentReport_SS.png
                           -giftCardformNegativeExtentReport_SS.png
                           -giftCardformPositiveExtentReport_SS.png
                           -VerifyWebsiteExtentReport_SS.png
                        4)excel
                           -input.xlsx
                           -output1.xlsx
                           -output2.xlsx
                        

test-output	:Contains-
			1)pom.xml
			2)testng.xml
			3)other files
 
Tools and Technologies used:

-Selenium with Java in Eclipse IDE
-TestNG
-Maven
-WebDriverManager
-ExtentReports
-Apache POI

 



 