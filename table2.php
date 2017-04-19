<?php

$con = mysqli_connect("localhost", "id1114817_life", "password", "id1114817_life");

 $state = $_POST['state'];
  
$sql = "SELECT * FROM request INNER JOIN login ON request.username = login.username WHERE location = '$state' ";
$res = mysqli_query($con,$sql);
 
$result = array();
 
while($row = mysqli_fetch_array($res)){
array_push($result,
array('organ'=>$row[1],
'blood'=>$row[2],
'contact'=>$row[14],
'age'=>$row[3],
'state'=>$row[12],
'reason'=>$row[4],
'name'=>$row[7],
'username'=>$row[9]
));
}
 
echo json_encode(array("result"=>$result));
 
mysqli_close($con);
 
?>