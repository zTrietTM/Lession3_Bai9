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
import internal.GlobalVariable
import net.bytebuddy.utility.RandomString

import org.openqa.selenium.Keys as Keys
import org.apache.commons.lang3.RandomStringUtils as RandStr




def chars = 'TrietTM-TrueProfit-stag-'

def a = RandStr.randomNumeric(2,10)

def b = chars + a
//def b = 'TrietTM-TrueProfit-stag-1234'

//Login spf partner
WebUI.openBrowser('https://partners.shopify.com/3063910/stores/new?store_type=test_store')
WebUI.maximizeWindow()
WebUI.setText(email, 'joy73838@omeie.com') 
WebUI.click(btn_continue)
WebUI.setEncryptedText(password, 'yWWnjn0zM30cuEjD7ZsPhQ==')
WebUI.click(btn_login)

WebUI.setText(storeName, b)
WebUI.click(span_clickRa)


//Create store
def get_final_StoreName	(def tenStore)
{
	
	    def final_StoreName
		
		if(WebUI.verifyElementPresent(div_bao_loi, 5, FailureHandling.OPTIONAL))
			{
				def chars2 = 'TrietTM-TrueProfit-stag-'
				def a2 = RandStr.randomNumeric(4,10)
				def b2 = chars2 + a2
				WebUI.sendKeys(storeName, Keys.chord(Keys.CONTROL, 'a'))
				WebUI.sendKeys(storeName, Keys.chord(Keys.BACK_SPACE))
				WebUI.setText(storeName, b2)
				WebUI.click(span_clickRa)
				WebUI.click(btn_createStore)
				final_StoreName = b2
			}
			else
			{
				try
				{
					WebUI.click(btn_createStore)
					final_StoreName = tenStore
				}
				catch(Exception e)
				{
					println "Exception: "+e
				}
			}
			
	return GlobalVariable.final_storeName = final_StoreName
	
}

get_final_StoreName(b)
println GlobalVariable.final_storeName

WebUI.waitForElementPresent(span_see_what_new,10,FailureHandling.CONTINUE_ON_FAILURE)

//Install true profit
WebUI.navigateToUrl('https://staging.trueprofit-web.pages.dev/')
WebUI.click(btn_sign_in_spf_domain)
WebUI.setText(input_spf_domain, GlobalVariable.final_storeName)
WebUI.click(btn_sign_in)


if(WebUI.verifyElementPresent(select_account, 5, FailureHandling.OPTIONAL))
{
	WebUI.click(select_account)
}

WebUI.waitForElementPresent(btn_install, 15)
WebUI.click(btn_install)

WebUI.waitForElementPresent(btn_let_get_start, 30)

Date today = new Date()

String todaysDate = today.format('yyyy_MM_dd')

WebUI.takeFullPageScreenshot('screenshot/screenshot_at_'+todaysDate+'_install_app.jpg')

