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
	
	public static Boolean BLandUse(String aLandUse, String bLandUse) {
		boolean tempLandUse = false;
		
		if(aLandUse.equals("110") || aLandUse.equals("150") || aLandUse.equals("160")) {
			if(bLandUse.equals("110") || bLandUse.equals("150") || bLandUse.equals("160")) {
				tempLandUse = true;
			}
		}
		
		if(aLandUse.equals("210") || aLandUse.equals("220") || aLandUse.equals("230") || aLandUse.equals("240")) {
			if(bLandUse.equals("210") || bLandUse.equals("220") || bLandUse.equals("230") || bLandUse.equals("240")) {
				tempLandUse = true;
			}
		}
		
		if(aLandUse.equals("310") || aLandUse.equals("320") || aLandUse.equals("330")) {
			if(bLandUse.equals("310") || bLandUse.equals("320") || bLandUse.equals("330")) {
				tempLandUse = true;
			}
		}
		
		if(aLandUse.equals("410") || aLandUse.equals("420") || aLandUse.equals("430")) {
			if(bLandUse.equals("410") || bLandUse.equals("420") || bLandUse.equals("430")) {
				tempLandUse = true;
			}
		}
		
		if(aLandUse.equals("510") || aLandUse.equals("610")) {
			if(bLandUse.equals("510") || bLandUse.equals("610")) {
				tempLandUse = true;
			}
		}
		
		return tempLandUse;
	}
}
