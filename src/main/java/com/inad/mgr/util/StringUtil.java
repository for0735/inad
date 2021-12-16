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
	
	public static String insteadGun(String addr) {
		String insteadAddr = addr;
		
		insteadAddr = insteadAddr.replace("고양시 덕양구", "고양덕양구");
		insteadAddr = insteadAddr.replace("고양시 일산동구", "고양일산동구");
		insteadAddr = insteadAddr.replace("고양시 일산서구", "고양일산서구");
		insteadAddr = insteadAddr.replace("부산시 진구", "부산진구");
		insteadAddr = insteadAddr.replace("성남시 분당구", "성남분당구");
		insteadAddr = insteadAddr.replace("성남시 수정구", "성남수정구");
		insteadAddr = insteadAddr.replace("성남시 중원구", "성남중원구");
		insteadAddr = insteadAddr.replace("수원시 권선구", "수원권선구");
		insteadAddr = insteadAddr.replace("수원시 영통구", "수원영통구");
		insteadAddr = insteadAddr.replace("수원시 장안구", "수원장안구");
		insteadAddr = insteadAddr.replace("수원시 팔달구", "수원팔달구");
		insteadAddr = insteadAddr.replace("안산시 단원구", "안산단원구");
		insteadAddr = insteadAddr.replace("안산시 상록구", "안산상록구");
		insteadAddr = insteadAddr.replace("안양시 동안구", "안양동안구");
		insteadAddr = insteadAddr.replace("안양시 만안구", "안양만안구");
		insteadAddr = insteadAddr.replace("용인시 기흥구", "용인기흥구");
		insteadAddr = insteadAddr.replace("용인시 수지구", "용인수지구");
		insteadAddr = insteadAddr.replace("용인시 처인구", "용인처인구");
		insteadAddr = insteadAddr.replace("전주시 덕진구", "전주덕진구");
		insteadAddr = insteadAddr.replace("전주시 완산구", "전주완산구");
		insteadAddr = insteadAddr.replace("창원시 마산합포구", "창원마산합포구");
		insteadAddr = insteadAddr.replace("창원시 마산회원구", "창원마산회원구");
		insteadAddr = insteadAddr.replace("창원시 성산구", "창원성산구");
		insteadAddr = insteadAddr.replace("창원시 의창구", "창원의창구");
		insteadAddr = insteadAddr.replace("창원시 진해구", "창원진해구");
		insteadAddr = insteadAddr.replace("천안시 동남구", "천안동남구");
		insteadAddr = insteadAddr.replace("천안시 서북구", "천안서북구");
		insteadAddr = insteadAddr.replace("청주시 상당구", "청주상당구");
		insteadAddr = insteadAddr.replace("청주시 서원구", "청주서원구");
		insteadAddr = insteadAddr.replace("청주시 청원구", "청주청원구");
		insteadAddr = insteadAddr.replace("청주시 흥덕구", "청주흥덕구");
		insteadAddr = insteadAddr.replace("포항시 남구", "포항남구");
		insteadAddr = insteadAddr.replace("포항시 북구", "포항북구");
		
		return insteadAddr;
	}
}
