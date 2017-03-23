<?php
    $con = mysqli_connect("localhost", "id1114817_life", "password", "id1114817_life");
    
    
   	$organ = $_POST["organ"];
	$blood = $_POST["blood"];
	$contact =$_POST["contact"];
	$age = $_POST["age"];
	$state = $_POST["state"];
	$city = $_POST["city"];
	$reason = $_POST["reason"];
        $username=$_POST["username"];
   

    $statement = mysqli_prepare($con, "INSERT INTO request ( organ, blood, contact, age, state, city, reason,username) VALUES (?,?,?,?,?,?,?,?)");
    mysqli_stmt_bind_param($statement,"ssiissss",$organ,$blood,$contact,$age,$state,$city,$reason,$username);
    mysqli_stmt_execute($statement);

function usernameAvailable() {
        global $con, $username;
        $statement = mysqli_prepare($con,  "SELECT * FROM request WHERE username = ?"); 
        mysqli_stmt_bind_param($statement, "s", $username);
        mysqli_stmt_execute($statement);
        mysqli_stmt_store_result($statement);
        $count = mysqli_stmt_num_rows($statement);
        mysqli_stmt_close($statement); 
        if ($count < 1){
            return true; 
        }else {
            return false; 
        }
    }  
  

    $response = array();
   $response["success"] = false;      

    

    if (usernameAvailable()){
               $response["success"] = true;  
    }
    else{ 
     $response["success"] = false; 
     $response["exist"]=true;  }
    
 
   print_r(json_encode($response));

?>