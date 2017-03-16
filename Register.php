<?php
    $con = mysqli_connect("localhost", "id1075470_life", "password", "id1075470_life");
    
    $username = $_POST["username"];
    $password = $_POST["password"];
   

    $statement = mysqli_prepare($con, "INSERT INTO login (username,password,user_id) VALUES (?,?,NULL)");
    mysqli_stmt_bind_param($statement,"ss",$username, $password);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    print_r(json_encode($response));

?>