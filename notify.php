<?php
    $con = mysqli_connect("localhost", "id1114817_life", "password", "id1114817_life");
    
        $receiver= $_POST["receiver"];
	$notify =$_POST["notify"];
    
   

    $statement = mysqli_prepare($con,"INSERT INTO notify (receiver,notify) VALUES (?,?)");
    mysqli_stmt_bind_param($statement,"ss",$receiver,$notify);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    print_r(json_encode($response));

?>