<?php

$con = mysqli_connect("localhost", "id1114817_life", "password", "id1114817_life");

 $username= $_POST['username'];
  
 $statement = mysqli_prepare($con, "SELECT organ,need FROM pd WHERE username = ?");
    mysqli_stmt_bind_param($statement, "s", $username);
    mysqli_stmt_execute($statement);


    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement,$organ,$need);    
    mysqli_stmt_fetch($statement);
     
  

$sql = "SELECT * FROM pd WHERE organ ='$organ' AND have='$need'";
$res = mysqli_query($con,$sql);
 
$result = array();
 
$result = array();
 
while($row = mysqli_fetch_array($res)){
array_push($result,
array('username'=>$row[0]
));
}
 
echo json_encode(array("result"=>$result));
 
mysqli_close($con);
 
?>