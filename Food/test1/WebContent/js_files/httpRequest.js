/**
 * 
 */

var httpRequest = null;



 	function getXMLHttpRequest(){
 		if(window.ActiveXObject){ // InternetExploler
 				
			try{
				return new ActiveXObject("Msxml12.XMLHTTP");
			}catch(e){
				try{
					return new ActiveXObject("Microsoft.XMLHTTP");
				}catch(e1){
					return null;
				}
			}
			
		}else if(window.XMLHttpRequest){ //etc
			return new XMLHttpRequest();
		}else{
			return null;
		}
	}
 	
 	
 	function sendRequest(url, params, callback, method){
 		httpRequest = getXMLHttpRequest();
 		
 		if(method!=null){
 			method = method.toUpperCase();
 		}
 		
 		var httpMethod = method != null ? method : "GET"; //null값이면 get으로 설정 
 		
 		if(httpMethod != "GET" && httpMethod != "POST"){
 			httpMethod = "GET";
 		}
 		
 		var httpParams = (params == null || params == "") ? null : params;
 		
 		var httpUrl = url;
 		if(httpMethod == "GET" && httpParams != null){
 			httpUrl = httpUrl + "?" + httpParams;
 		}
 		
 		httpRequest.onreadystatechange = callback;
 		
 		httpRequest.open(httpMethod, httpUrl, true);
// 		-> open이 아래의 setRequestHeader보다 먼저 명령되어야 함
 		
 		httpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded"); // post방식의 경우
 		httpRequest.send(httpMethod == "POST" ? httpParams : null);
 		
 		
 	}
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	