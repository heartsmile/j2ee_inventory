/**
 * @author: thaint
 */

$(document).ready(function() {
	var i = $('#tbData tr').length;
	//deletes the selected table rows
	$(".delete").on('click', function() {
		i --;
		$('.case:checkbox:checked').parents("tr").remove();
		$('#check_all').prop("checked", false); 
	});

	////to check all checkboxes
	$(document).on('change','#check_all',function(){
		$('input[class=case]:checkbox').prop("checked", $(this).is(':checked'));
	});
	
	//adds extra table rows
	$(".addmore").on('click',function(){
		
		count = $('#tbData tr').length;
		var productID = 'productID_' + (count - 1); 
		var productIDValue = $('#' + productID).val();
		
		if (count <= 1 || productIDValue) {
			//
			var html =loadData(count, i);
			$('#tbData').append(html);
			i++;
		}

	});
	
    var array;
    function getData() {

    	//var ID = request;
        $.ajax({
        	type: 'POST',
            url: './getProduct',
            dataType: 'json',
            data: {},
            success: function(response) {
                array = $.map(response, function(item) {
                    var code = item.split("|");
                    return {
                        label: code[autoTypeNo],
                        value: code[autoTypeNo],
                        data: item
                    }
                });
            },
            error : function(xhr, status){
                console.log(status);
            }
            
        });
        return false;
    }
    
    //auto-complete script
    $(document).on('focus','.searchName',function(){
    	type = $(this).data('type');

    	if(type =='productID' )autoTypeNo=0;
    	if(type =='productName' )autoTypeNo=1; 	

        $(this).autocomplete({
            minLength: 0,
            source: function(request, response) {
            	
            	// check request
            	if (request != null || request != "") {
                    getData();
                    //call the filter here
                    if (array != null) {
                        response($.ui.autocomplete.filter(array, request.term));
    				}
				}
            	
            },
            focus: function() {
                // prevent value inserted on focus
                return false;
            },
    		select: function( event, ui ) {
    			var names = ui.item.data.split("|");						
    			id_arr = $(this).attr('id');
    	  		id = id_arr.split("_");
    			elementId = id[id.length - 1];
    			$('#productID_'+elementId).val(names[0]);
    			$('#productName_'+elementId).val(names[1]);
    			$('#price_'+elementId).val(names[3]);
    		}	
        });

        $.ui.autocomplete.filter = function(array, term) {
            var matcher = new RegExp("^" + $.ui.autocomplete.escapeRegex(term), "i");
            return $.grep(array, function(value) {
                return matcher.test(value.label || value.value || value);
            });
        };
    });
    
	//save stock-inward
	$("#saveData").on('click',function(){
		
		var providerID = $('#select_providerID').val();
		var staffID = "3";
		var date = $('#ngayNhap').val();
		var reason = $('#reason').val();
		var totalAmount = $('#totalNumber').val();
		var totalMoney = $('#totalMoney').val();
		
		var stockInward = {
			"providerID" : providerID,
			"staffID" : staffID,
			"date" : date,
			"reason" : reason,
			"totalNumber" : totalAmount,
			"totalMoney" : totalMoney
		};
		
		var TableData = new Array();
		var idx = 1;
		$('#tbData tr').each(function(row, tr){
			var productID = "#productID_"+ idx;
			var stockID = "#stockID_" + idx;
			var quantity = "#quantity_" + idx;
			TableData[row]={
		        "productID" : $(productID).val()
		        , "stockID" : $(stockID).val()
		        , "quantity" : $(quantity).val()
		    }
			idx++;
		});
		//TableData.shift();  // first row is the table header - so remove
		//alert(TableData);
		
		// call ajax to save data
		var data = {};
		data[0] = JSON.stringify(stockInward);
		data[1] = JSON.stringify(TableData);
		$.ajax({
        	type: 'POST',
            url: './saveStockInward',
            dataType: 'json',
            data: data,
            success: function(response) {
                
            },
            error : function(xhr, status){
                console.log(status);
            }
            
        });
		
	});
});
//It restrict the non-numbers
var specialKeys = new Array();
specialKeys.push(8,46); //Backspace
function IsNumeric(e) {
    var keyCode = e.which ? e.which : e.keyCode;
    var ret = ((keyCode >= 48 && keyCode <= 57) || specialKeys.indexOf(keyCode) != -1);
    return ret;
}

