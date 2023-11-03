import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.util.internal.PathUtil

//Mobile.startExistingApplication('com.impactplus.socialseeds')


Mobile.comment('Story: Sign in as a volunteer but with an unregistered account')

'Get full directory\'s path of android application'
def appPath = PathUtil.relativeToAbsolutePath(GlobalVariable.G_AppPath, RunConfiguration.getProjectDir())
Mobile.startApplication(appPath, false)

//Mobile.startApplication('com.impactplus.socialseeds',false)


Mobile.tap(findTestObject('Object Repository/Login_Volunteer/android.view.ViewGroup'), 0)

Mobile.delay(5)

Mobile.tap(findTestObject('Object Repository/Login_Volunteer/android.widget.Button'), 0)

Mobile.delay(5)

Mobile.tap(findTestObject('Object Repository/Login_Volunteer/android.view.ViewGroup (1)'), 0)

Mobile.delay(5)

Mobile.tap(findTestObject('Object Repository/Login_Volunteer/android.view.ViewGroup (2)'), 0)

//Mobile.tap(findTestObject('Object Repository/ForgotPass_Volunteer/android.view.ViewGroup'), 0)
//
//Mobile.tap(findTestObject('Object Repository/ForgotPass_Volunteer/android.widget.ImageView'), 0)
//
//Mobile.tap(findTestObject('Object Repository/ForgotPass_Volunteer/android.view.ViewGroup (1)'), 0)
//
//Mobile.tap(findTestObject('Object Repository/ForgotPass_Volunteer/android.widget.ImageView (1)'), 0)


Mobile.setText(findTestObject('Object Repository/Login_Volunteer/android.widget.EditText - Enter your Email'), 'yayangtaopik@gmail.com', 
    0)

Mobile.setText(findTestObject('Object Repository/Login_Volunteer/android.widget.EditText - Enter your Password'), 'socialseeds123456', 
    0)

Mobile.tap(findTestObject('Object Repository/Login_Volunteer/android.view.ViewGroup (3)'), 0)

//Mobile.verifyElementNotExist(findTestObject('Object Repository/Login_Volunteer/android.view.ViewGroup (4)'), 0)

Mobile.getText(findTestObject('Object Repository/Login_Volunteer/android.widget.TextView - Login failure'), 0)

Mobile.getText(findTestObject('Object Repository/Login_Volunteer/android.widget.TextView - Invalid login'), 0)

if (Mobile.verifyElementVisible(findTestObject('Object Repository/Login_Volunteer/android.widget.TextView - Invalid login'), 10) == true) {
	KeywordUtil.markPassed("Pass")
	Mobile.takeScreenshot()
	Mobile.tap(findTestObject('Object Repository/Login_Volunteer/android.widget.Button - OK'), 0)
} else {
	KeywordUtil.markFailed("Failed")
}

Mobile.closeApplication()

