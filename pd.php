<?php
    $con = mysqli_connect("localhost", "id1114817_life", "password", "id1114817_life");
    
    $username=$_POST["username"];
    $organ =$_POST["organ"];
    $blood1=$_POST["blood1"];
    $blood2=$_POST["blood2"];
  
   

    $statement = mysqli_prepare($con, "INSERT INTO pd (username,organ,have,need) VALUES (?,?,?,?)");
    mysqli_stmt_bind_param($statement,"ssss", $username, $organ, $blood1, $blood2);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    print_r(json_encode($response));

?>