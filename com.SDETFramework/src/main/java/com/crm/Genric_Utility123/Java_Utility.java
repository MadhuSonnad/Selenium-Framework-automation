package com.crm.Genric_Utility123;

import java.util.Random;

public class Java_Utility {

/**This method is use to avoid Excel repetition
 *  
 * @return
 * @author MADHU
 */
		public int RanDomNum()
		{
			Random ran=new Random();
			int RanNum=ran.nextInt(1000);
			return RanNum;
		}
}
