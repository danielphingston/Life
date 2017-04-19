<?php
    $con = mysqli_connect("localhost", "id1114817_life", "password", "id1114817_life");
    
    $name =$_POST["name"];
    $email=$_POST["email"];
    $username = $_POST["username"];
    $password = $_POST["password"];
    $location = $_POST["location"];
    $contact= $_POST["contact"];
   

    $statement = mysqli_prepare($con, "INSERT INTO login (name,email,username,password,location,contact) VALUES (?,?,?,?,?,?)");
    mysqli_stmt_bind_param($statement,"ssssss", $name, $email, $username, $password,$location,$contact);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    print_r(json_encode($response));

?>