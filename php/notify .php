<?php
    $con = mysqli_connect("localhost", "id1114817_life", "password", "id1114817_life");
    
        $username = $_POST["username"];
	$notify =$_POST["notify"];
    
   

    $statement = mysqli_prepare($con, "UPDATE login SET notify =? WHERE username=? ");
    mysqli_stmt_bind_param($statement,"ss",$notify,$username);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    print_r(json_encode($response));

?>