<?php

$connection	= new mysqli("localhost","root","","online_store_db");
$selectBrand = $connection->prepare("select distinct brand from electronic_products");
$selectBrand -> execute();

$brandResult = $selectBrand -> get_result();

$brands = array();

while ($row = $brandResult->fetch_assoc()){
	
	array_push($brands, $row);
	
}

echo json_encode($brands);