<?php
    $connection = new mysqli("localhost", "root", "", "online_store_db");
    $sqlcommand = $connection->prepare("DELETE FROM temporary_place_order WHERE email=?");
    $sqlcommand->bind_param("s",$_GET["email"]);
    $sqlcommand->execute();
?>