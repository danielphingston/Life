<?php
    $con = mysqli_connect("localhost", "id1114817_life", "password", "id1114817_life");
    
    $username = $_POST["username"];
    $password = $_POST["password"];
    
    $statement = mysqli_prepare($con, "SELECT username,password,verify,admin FROM login WHERE username = ? AND password = ?");
    mysqli_stmt_bind_param($statement, "ss", $username, $password);
    mysqli_stmt_execute($statement);

    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement,$username,$password,$verify,$admin);
    
    $response = array();
    $response["success"] = false;  
    
   while(mysqli_stmt_fetch($statement)){
        $response["success"] = true;  
        $response["username"] = $username;
        $response["password"] = $password;
		$response["verify"] = $verify;
		$response["admin"] = $admin;
  
    }
      print_r(json_encode($response));
?>