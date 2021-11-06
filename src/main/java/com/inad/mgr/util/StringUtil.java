package com.inad.mgr.util;

public class StringUtil {
	public String getJiBun(String temp) {
		for(int i=0; i<5; i++) {
			if(temp.length() >= 4) {
				return temp;
			}
			
			temp = "0" + temp;
		}
		
		return temp;
	}
}
