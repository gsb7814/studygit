


function selectAll(obj,selectOptionName){
	var checkedSelections = document.getElementsByName(selectOptionName);
	alert(checkedSelections);
	for(var i = 0;i <checkedSelections.length;i++) {   
		checkedSelections[i].checked=obj.checked;
	}
}



function addVoucherDetail(){
	alert(1111);
	
 var newDiv = document.getElementById("hide").cloneNode(true);
  newDiv.id=Math.random();
  newDiv.style.display="";
  document.getElementById("parent").appendChild(newDiv);
}

   function delVoucherDetail(){
  var last = document.getElementById("parent").lastChild;
  if(last.id!="first"){
  	document.getElementById("parent").removeChild(last);
  }else{
  	alert("不能删除最后一条");
  }
 computDebitSum();
 computCreditSum();
}

function computDebitSum(){
  
		var curSum = 0.00;
		var fdebits = document.getElementsByName("voucherMngBean.fdebit");
		//alert(1);
		for(i=1;i<fdebits.length;i++){
			fdebit = fdebits[i];
			if(fdebit.value!=''){
				curSum+=parseFloat(fdebit.value);
			}
		}
		//alert(curSum); 		
		var debitSum = document.getElementById("voucherMngBean.debitSum");
		debitSum.value = parseFloat(curSum).toFixed(2);
}

   function computCreditSum(){
   
		var curSum = 0.00;
		var fcredits = document.getElementsByName("voucherMngBean.fcredit");
		//alert(2);
		for(i=1;i<fcredits.length;i++){
			fcredit = fcredits[i];
			if(fcredit.value!=''){
				curSum+=parseFloat(fcredit.value);
			}
		} 	
		//alert(curSum); 		
		var creditSum = document.getElementById("voucherMngBean.creditSum");
		creditSum.value = parseFloat(curSum).toFixed(2);
}

