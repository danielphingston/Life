<?php
    $con = mysqli_connect("localhost", "id1114817_life", "password", "id1114817_life");
    
    $username = $_POST["username"];
   

    $statement = mysqli_prepare($con, "UPDATE login SET verify = 'Y' WHERE username= '$username' ");
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    print_r(json_encode($response));

?>