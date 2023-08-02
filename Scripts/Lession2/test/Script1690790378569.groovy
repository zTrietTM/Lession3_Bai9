import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable
//Create store


WebUI.setText(null, null)


def get_final_StoreName	(def tenStore)
{
	
	def final_StoreName
	def baoloi = WebUI.getText(div_bao_loi)
	try {
		
		
		println 'LOI LA:' + baoloi
		if(baoloi != 'Store URL is unavailable')
			{
				WebUI.setText(storeName, tenStore)
				WebUI.click(span_clickRa)
				WebUI.click(btn_createStore)
				final_StoreName = tenStore
			}
		
		else
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
	}
	catch(Exception e)
	
	{
		println ("Exception is: "+e)
	}
	
	return GlobalVariable.final_storeName = final_StoreName
}





def baoloi = WebUI.getText(div_bao_loi,FailureHandling.CONTINUE_ON_FAILURE)
println 'LOI LA:' + baoloi

if(baoloi != 'Store URL is unavailable')
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
else
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
