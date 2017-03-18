<?php
    $con = mysqli_connect("localhost", "id1114817_life", "password", "id1114817_life");
    
    $name =$_POST["name"];
    $email=$_POST["email"];
    $username = $_POST["username"];
    $password = $_POST["password"];
   

    $statement = mysqli_prepare($con, "INSERT INTO login (name,email,username,password) VALUES (?,?,?,?)");
    mysqli_stmt_bind_param($statement,"ssss", $name, $email, $username, $password);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    print_r(json_encode($response));

?>