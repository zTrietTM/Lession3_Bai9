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
import org.apache.commons.lang3.RandomStringUtils as RandStr
import org.openqa.selenium.Keys as Keys



  WebUI.openBrowser('https://partners.shopify.com/3063910/stores/new?store_type=test_store&data_type=static_data')
  WebUI.maximizeWindow()


  WebUI.sendKeys(email, 'joy73838@omeie.com') 
  WebUI.click(btn_continue)
  WebUI.setEncryptedText(password, 'yWWnjn0zM30cuEjD7ZsPhQ==')
  WebUI.click(btn_login)
  
  def a = RandStr.randomNumeric(4,10)
  def chars = 'TrietTM-TrueProfit-stag-'
  def b = chars + a
  
  WebUI.sendKeys(storeName, dataStoreName)
  WebUI.click(span_clickRa)
  WebUI.click(btn_createStore)
 
 

  