package com.DemoWebShop_GeneralUtility;

import java.time.LocalDateTime;

public class JavaUtility {
	
	public String localDateandTime()
	{
		String time= LocalDateTime.now().toString().replace(".", "").replace(":", "").replace("-", "");
		return time;
	}
	


}
