<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
   <head>
      <title>Quản lý tồn kho</title>
      <!-- Bootstrap Core CSS -->
      <link rel="stylesheet"
      href="
      <c:url value="/resources/css/bootstrap.min.css" />"
      type="text/css">
      <link rel="stylesheet"
      href="
      <c:url value="/resources/css/StockInward/jquery-ui.css" />"
      type="text/css">	
      <!-- Custom Fonts -->
      <link rel="stylesheet"
      href="
      <c:url value="/resources/css/font-awesome/css/font-awesome.min.css" />"
      type="text/css">
      <!-- Load JavaScript Libraries -->
      <script src="
      <c:url value="/resources/js/jquery/jquery-1.11.3.min.js" />"
      type="text/javascript"></script>
      <!-- Bootstrap Core JavaScript -->
      <script src="
      <c:url value="/resources/js/bootstrap.min.js" />"
      type="text/javascript"></script>
      <script src="
      <c:url value="/resources/js/jquery/jquery-ui.js" />"
      type="text/javascript"></script>
      <script src="
      <c:url value="/resources/js/bootstrap-dialog.min.js" />"
      type="text/javascript"></script>
   </head>
   <body>
      <div class="content-resize"
         style="background: rgb(255, 204, 153) none repeat scroll 0px 0px; width: 650px; margin-top: 50px; margin-left: 100px;">
         <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
               <table id="tbData" class="table table-bordered table-hover">
                  <thead>
                     <tr>
                        <th width="2%"><input id="check_all" class="formcontrol"
                           type="checkbox"></th>
                        <th>S. No</th>
                        <th width="15%">Product ID</th>
                        <th width="50%">Product Name</th>
                        <th width="20%">Quantity</th>
                     </tr>
                  </thead>
                  <tbody>
                  </tbody>
               </table>
            </div>
         </div>
         <div class="row">
            <div class="col-xs-6 col-md-4">
               <button class="btn btn-success addmore" type="button">+ Add More</button>
            </div>
         </div>
      </div>
      <script>
         function loadData(count, i) {
         	var html = "<tr id='row_" + i + "'>";
         	html += "<td><input class='case' type='checkbox'/></td>";
         	html += "<td><span id='snum" + i + "'>" + count + ".</span></td>";
         	html += "<td><input readonly='readonly'readonly='readonly' type='text' data-type='productID' name='productID[]' id='productID_"+i+"' class='form-control searchID' autocomplete='off'></td>";
         	html += "<td><input type='text' data-type='productName' name='productName[]' id='productName_"+i+"' class='form-control searchName' autocomplete='off'></td>";
         	html += "<td><input type='number' name='quantity[]' id='quantity_"
         		+ i
         		+ "' class='form-control changesNo' autocomplete='off' onkeypress='return IsNumeric(event);' ondrop='return false;' onpaste='return false;'></td>";
         	html += "</tr>";
         
         	return html;
         }
      </script>
   </body>
</html>
