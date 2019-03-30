<?php
	include("connect.php");
	
	$q = "select * from electronic_products where brand=?";
	$fetchProducts = $connection->prepare($q);
	$fetchProducts->bind_param("s", $_GET["brand"]);
	$fetchProducts->execute();
	
	$epRes = $fetchProducts->get_result();
	
	$epArray = array();
	while($row = $epRes->fetch_assoc()) {
		array_push($epArray, $row);
	}
	echo json_encode($epArray);
?>
