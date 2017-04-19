<?php

$con = mysqli_connect("localhost", "id1114817_life", "password", "id1114817_life");

 $username= $_POST['username'];
  
$sql = "SELECT * FROM notify WHERE receiver='$username'";
$res = mysqli_query($con,$sql); 

$result = array();
 
while($row = mysqli_fetch_array($res)){
array_push($result,
array('username'=>$row[1]
));
}
 
echo json_encode(array("result"=>$result));
 
mysqli_close($con);
 
?>