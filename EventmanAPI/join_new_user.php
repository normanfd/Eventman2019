  <?php
	$connection=new mysqli("localhost","root","","online_store_db");
	
	$checkemail= $connection->prepare("SELECT * FROM app_user_table WHERE email=?");
	$checkemail->bind_param("s",$_GET["email"]);
	$checkemail->execute();
	$emailresult=$checkemail->get_result();
	
	if($emailresult->num_rows == 0){
		$sqlcommand = $connection->prepare("INSERT INTO app_user_table VALUES (?,?,?)");
		$sqlcommand->bind_param("sss",$_GET["email"], $_GET["username"], $_GET["pass"]);
		$sqlcommand->execute();
		echo "Congratulations! Registration success";
	}else{
		echo "A user with this Email Address already exists";
	}
 ?>