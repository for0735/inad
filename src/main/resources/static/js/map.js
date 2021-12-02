/*
	const배열로 맵 데이터 뿌리기
*/
const jdata = {
name : ['a동','b동','c동'],
'a동' : ['1호',2,3], 
'b동' : [2,3], 
'c동' : [1,2,3,4]
};

/*
	원의 방정식을 이용하여 주소 가져오는 js파일
	(x-5)^2+(y-5)^2=25 ---> 지름길이 10일때 가정
	주소기준으로 10m간격의 위도, 경도를 뽑아냄. 그 뽑아낸 위도 경도값을 array에 담아 리턴
	
	
	(x-5)^2 + (y-5)^2 = 5^2
	(x-5)^2 = 5^2 - (y-5)^2
	x-5 = sqrt(5^2 -(y-5)^2)
	x = sqrt(5^2 -(y-5)^2) + 5
	
*/
//10미터 반경 구하기 (간격1미터)
function cycle10(obj){
	var x = [];
	var y = [];
 	
 	for(var i=0; i<5; i++){
 		y[i] = i+1;
 		x[i] = Math.sqrt(5**2 -(y[i]-5)**2) + 5;
 	}
 	
}

//200미터 반경 구하기
//y = 10, 20, 30, 40......
//x = -sqrt(100^2-(y-100)^2)+100
function cycle200(obj){ 	
	var x = [];
	var y = [];
 	
 	for(var i=0; i<=10; i++){
 		y[i] = 10*(i);
 		x[i] = -Math.sqrt(100**2-(y[i]-100)**2)+100;
 	}
 	var xArray = [];
 	var yArray = [];
 	var returnArray = [];
 	
 	for(var i=0; i<=10; i++){
 		yArray[i] = 100 - y[i];
 		xArray[i] = 100 - x[i];
 		
 		var YD = parseFloat(obj.Ma) - yArray[i]/100000;
 		var YU = parseFloat(obj.Ma) + yArray[i]/100000;
 		var XL = parseFloat(obj.La) + xArray[i]/100000;
 		var XR = parseFloat(obj.La) - xArray[i]/100000;

 		var tempYD = YD;
 		var tempYU = YU;
 		var tempXL = XL;
 		var tempXR = XR;
 		
 		while(true){
 			var tempObj1 = JSON.parse(JSON.stringify(obj));
 			Object.setPrototypeOf(tempObj1, Object.getPrototypeOf(obj));
 		
			tempObj1.Ma = Math.round(tempYD * 100000)/100000;
	 		tempObj1.La = Math.round(tempXL * 100000)/100000;
	 		
	 		returnArray[returnArray.length] = tempObj1;
	 		
	 		var tempObj2 = JSON.parse(JSON.stringify(obj));
 			Object.setPrototypeOf(tempObj2, Object.getPrototypeOf(obj));
	 		
	 		tempObj2.Ma = Math.round(tempYU * 100000)/100000;
	 		tempObj2.La = Math.round(tempXL * 100000)/100000;
	 		
	 		returnArray[returnArray.length] = tempObj2;
	 		
	 		tempXL = tempXL - 0.0001;
	 		
	 		if(tempXR > tempXL){
				break;
			}
		}
 	}
 	
 	return returnArray;
}

//500미터 반경 구하기
//y = 10, 20, 30, 40......
//x = -sqrt(250^2-(y-250)^2)+250
function cycle500(obj){

	var x = [];
	var y = [];
	
 	for(var i=0; i<=10; i++){
 		y[i] = 25*(i);
 		x[i] = -Math.sqrt(250**2-(y[i]-250)**2)+250;
 	}
 	var xArray = [];
 	var yArray = [];
 	var returnArray = [];
 	
 	for(var i=0; i<=10; i++){
 		yArray[i] = 250 - y[i];
 		xArray[i] = 250 - x[i];
 		
 		var YD = parseFloat(obj.Ma) - yArray[i]/100000;
 		var YU = parseFloat(obj.Ma) + yArray[i]/100000;
 		var XL = parseFloat(obj.La) + xArray[i]/100000;
 		var XR = parseFloat(obj.La) - xArray[i]/100000;

 		var tempYD = YD;
 		var tempYU = YU;
 		var tempXL = XL;
 		var tempXR = XR;
 		
 		while(true){
 			var tempObj1 = JSON.parse(JSON.stringify(obj));
 			Object.setPrototypeOf(tempObj1, Object.getPrototypeOf(obj));
 		
			tempObj1.Ma = Math.round(tempYD * 100000)/100000;
	 		tempObj1.La = Math.round(tempXL * 100000)/100000;
	 		
	 		returnArray[returnArray.length] = tempObj1;
	 		
	 		var tempObj2 = JSON.parse(JSON.stringify(obj));
 			Object.setPrototypeOf(tempObj2, Object.getPrototypeOf(obj));
	 		
	 		tempObj2.Ma = Math.round(tempYU * 100000)/100000;
	 		tempObj2.La = Math.round(tempXL * 100000)/100000;
	 		
	 		returnArray[returnArray.length] = tempObj2;
	 		
	 		tempXL = tempXL - 0.00020;
	 		
	 		if(tempXR > tempXL){
				break;
			}
		}
 	}
 	
 	return returnArray;
}

function getAddrList200(obj){
	let addrListArr200 = [];
	
	addrListArr200 = cycle200(obj);
	
	//주소리스트
    let addrList200 = [];
    for(let i=0; i<addrListArr200.length; i++){
    	searchDetailAddrFromCoords(addrListArr200[i], function(result1, status1) {
    		addrList200[i] = result1[0].address.address_name;
    		console.log(result1[0].address.address_name);
    	});
    }    
    
    return addrList200;
}


function getAddrList500(obj){
	let addrListArr500 = [];
	
	addrListArr500 = cycle500(obj);
	
	//주소리스트
    let addrList500 = [];
    for(let i=0; i<addrListArr500.length; i++){
    	searchDetailAddrFromCoords(addrListArr500[i], function(result1, status1) {
    		addrList500[i] = result1[0].address.address_name;
    		console.log(result1[0].address.address_name);
    	});
    }
    
    return addrList500;
}

function searchHo(){
	
}
