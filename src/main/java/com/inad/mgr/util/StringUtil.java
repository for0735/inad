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
	
	public static int remove_Duplicate_Elements(String arr[], int n){  
        if (n==0 || n==1){  
            return n;  
        }  
        String[] tempA = new String[n];  
        int j = 0;  
        for (int i=0; i<n-1; i++){  
            if (!arr[i].equals(arr[i+1])){  
                tempA[j++] = arr[i];  
            }  
         }  
        tempA[j++] = arr[n-1];       
        for (int i=0; i<j; i++){  
            arr[i] = tempA[i];  
        }  
        return j;  
    }  
	
	public static Boolean BJimok(String aJimok, String bJimok) {
		boolean tempJimok = false;
		
		if(aJimok.equals("01") || aJimok.equals("02")) {
			if(bJimok.equals("01") || bJimok.equals("02")) {
				tempJimok = true;
			}
		}
		
		if(aJimok.equals("01") || aJimok.equals("02")) {
			if(bJimok.equals("01") || bJimok.equals("02")) {
				tempJimok = true;
			}
		}
		
		return tempJimok;
	}
}
