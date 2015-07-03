var obj;
$(document).ready(function() {
	
    var date = new Date();
    var month = date.getMonth()+1;
    var day = date.getDate();
    var output = date.getFullYear() + '-' + ((''+month).length<2 ? '0' : '') + month + '-' + ((''+day).length<2 ? '0' : '') + day; 
    
    $('#date').val(output);
	// call function calculation grandTotal
	setGrandTotal();
	// get list product
	var success = function(response) {
		if (response != "") {
			obj = jQuery.parseJSON(response);
			//load json to table 
			$('#tableInven tbody').html(getTableHTML());

			$('.inputQuantity').change(function(){
				var row = $(this).parent().parent();
				var col = row.find('td');
				
				var stockQ_index = 2;
				var realQ_index = 3;
				var diff_index = 4;
				var price_index = 5;
				var subTotal_index = 6;
				
				// get value
				var stockQuantity = parseInt(col.eq(stockQ_index).html());
				var realQuantity = parseInt($(this).val());
				
				var diff = col.eq(diff_index);
				var sub = col.eq(subTotal_index);
				
				var row_index = row.index()/2;
				
				var diffQuantity = (realQuantity - stockQuantity);
				var subToTal = diffQuantity * (parseInt(col.eq(price_index).html()));
				
				// set value for html
				diff.html(diffQuantity);
				sub.html(subToTal);
				
				// set value for return object
				obj[row_index]['realQuantity'] = realQuantity;
				obj[row_index]['differentQuantity'] = diffQuantity;
				obj[row_index]['subTotal'] = subToTal;
			
				// call function calculation grandTotal
				setGrandTotal();
			});
		} else {
			
		}
	};
	
	// dinh nghia ham error
	var error = function() {
		alert("Can't get list Product!");
	};
	
	var ajaxObject = {
		url : 'getListStockAdjustment',
		type : 'POST',
		success : success,
		error : error
	};
	
	// calling
	$.ajax(ajaxObject);

});

function setGrandTotal() {
	
	var grandTotal = 0;
	$('#tableInven .subTotal').each(function() {
		grandTotal += parseInt( $(this).html() );
	});
	
	$('#grandTotal').html(grandTotal);
};

function getTableHTML() {
    var html = "";
    for (i in obj) {
        html += "<tr>";

        for (var j = 0; j < Object.keys(obj[0]).length; j++) {
            switch (j) {
                //Column 0
                case 0:
                    html += "<td>" + obj[i]['productID'] + "</td>";
                    break;
                // Column 1
                case 1:
                    html += "<td>" + obj[i]['productName'] + "</td>";
                    break;
                // Column 2
                case 2:
                    html += "<td>" + obj[i]['stockQuantity'] + "</td>";
                    break;
                // Column 3
                case 3:
                    html += "<td>" + "<input type='number' min='1' value='" + obj[i]['realQuantity'] + "'  class='form-control inputQuantity' />" + "</td>";
                    break;
                // Column 4
                case 4:
                    html += "<td>" + obj[i]['differentQuantity'] + "</td>";
                    break;
                // Column 5
                case 5:
                    html += "<td>" + obj[i]['price'] + "</td>";
                    break;
                // Column 6
                case 6:
                    html += "<td class='subTotal'>" + obj[i]['subTotal'] + "</td>";
                    break;

                default:
                    break;
            }

        }
        html += "<tr>";

    }
    return html;
};