<?php 
	$connection = new mysqli("localhost", "root", "", "online_store_db");
	$gettemporder = $connection->prepare("SELECT * FROM temporary_place_order WHERE email=?");
	$gettemporder->bind_param("s",$_GET["email"]);
	$gettemporder->execute();
	$temporderresult = $gettemporder->get_result();
	
	//pop = populate invoicewithemailcommand
	$pop = $connection->prepare("INSERT INTO invoice(email) VALUES(?)");
	$pop ->bind_param("s",$_GET["email"]);
	$pop->execute();
	
	//glin = get lastest invoice number command
	$glin=$connection->prepare("SELECT MAX(invoice_num) AS latest_invoice_num FROM invoice WHERE email=?");
	$glin -> bind_param("s",$_GET["email"]);
	$glin -> execute();
	$invoice_number_result = $glin->get_result();
	$row_invoiceNumber = $invoice_number_result->fetch_assoc();
	
	while($row=$temporderresult->fetch_assoc()){
		//pidc = populate invoide detail command
		$pidc = $connection-> prepare("INSERT INTO invoice_details VALUE(?,?,?)");
		$pidc -> bind_param("iii",$row_invoiceNumber["latest_invoice_num"],$row["product_id"],$row["amount"]);
		$pidc ->execute();
		
		$deleteTempOrder = $connection->prepare("DELETE FROM temporary_place_order WHERE email=?");
		$deleteTempOrder->bind_param("s",$_GET["email"]);
		$deleteTempOrder->execute();
	}
	echo $row_invoiceNumber["latest_invoice_num"];
?>
