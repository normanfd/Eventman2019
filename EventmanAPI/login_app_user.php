<?php
	$connection=new mysqli("localhost","root","","online_store_db");
	$check_login=$connection->prepare("SELECT * FROM app_user_table WHERE email=? and pass=?");
	$check_login->bind_param("ss",$_GET["email"],$_GET["pass"]);
	$check_login->execute();
	$loginresult=$check_login->get_result();
	
	if($loginresult->num_rows == 0){
		echo "The user does not exixt";
	}else{
		echo "The user does exist";
	}
 ?>
