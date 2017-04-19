<?php
    $con = mysqli_connect("localhost", "id1114817_life", "password", "id1114817_life");
    
    $username =$_POST["username"];

    
    $statement = mysqli_prepare($con, "SELECT username,name,password,email,location,contact FROM login WHERE username = ? ");
    mysqli_stmt_bind_param($statement, "s", $username);
    mysqli_stmt_execute($statement);

    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement,$username,$name,$password,$email,$location,$contact);
    
    $response = array();
    $response["success"] = false;  
    
   while(mysqli_stmt_fetch($statement)){
        $response["success"] = true;  
        $response["username"] = $username;
        $response["name"] = $name;
        $response["password"] = $password;
	$response["email"] = $email;
	$response["location"] = $location;
	$response["contact"] = $contact;
    }
      print_r(json_encode($response));
?>