<?php
    $con = mysqli_connect("localhost", "id1114817_life", "password", "id1114817_life");
    
    
   	$organ = $_POST["organ"];
	$blood = $_POST["blood"];
	$contact =$_POST["contact"];
	$age = $_POST["age"];
	$state = $_POST["state"];
	$city = $_POST["city"];
	$reason = $_POST["reason"];
   

    $statement = mysqli_prepare($con, "INSERT INTO request ( organs, blood, contact, age, state, city, reason) VALUES (?,?,?,?,?,?,?)");
    mysqli_stmt_bind_param($statement,"ssiisss",$organ,$blood,$contact,$age,$state,$city,$reason);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    print_r(json_encode($response));

?>