function putOnlyNumbers(evt){
	var nav4 = window.Event ? true : false;
	var key = nav4 ? evt.which : evt.keyCode;
	
	return (key <= 13 || (key >= 48 && key <= 57) || key == 44);
}

function limitlength(obj, length) {
	var maxlength = length;
	if (obj.value.length > maxlength)
		obj.value = obj.value.substring(0, maxlength);
}

function ejecutarImpresionDirecta(rfimp, rfdoc){
	var rfimp = rfimp + "---"+rfdoc;
	var url = "../../pdf.js-gh-pages/web/viewer.html?rfimp="+rfimp;
	var windopen = window.open(url);
	
	window.setTimeout(function() {
		windopen.addEventListener("beforeunload", function() {
			deletePdf([{ name : 'namepdf', value : rfdoc}]);
	    }, false);
	}, 0);
}

//retorna un json con las proiedades del navegador
function identificarNavegador(){
    // Opera 8.0+
	var isOpera = (!!window.opr && !!opr.addons) || !!window.opera || navigator.userAgent.indexOf(' OPR/') >= 0;
	    // Firefox 1.0+
	var isFirefox = typeof InstallTrigger !== 'undefined';
	    // At least Safari 3+: "[object HTMLElementConstructor]"
	var isSafari = Object.prototype.toString.call(window.HTMLElement).indexOf('Constructor') > 0;
	    // Internet Explorer 6-11
	var isIE = /*@cc_on!@*/false || !!document.documentMode;
	    // Edge 20+
	var isEdge = !isIE && !!window.StyleMedia;
	    // Chrome 1+
	var isChrome = !!window.chrome && !!window.chrome.webstore;
	    // Blink engine detection
	var isBlink = (isChrome || isOpera) && !!window.CSS;

	var respuesta ={
			opera : isOpera,
			firefox : isFirefox,
			safari : isSafari,
			ie : isIE,
			edge : isEdge,
			chrome : isChrome,
			blink : isBlink
	};
	
	return respuesta;
}


