<?php

$con = mysqli_connect("localhost", "id1114817_life", "password", "id1114817_life");

 
$sql = "SELECT * FROM request INNER JOIN login ON request.username = login.username";
$res = mysqli_query($con,$sql);
 
$result = array();
 
while($row = mysqli_fetch_array($res)){
array_push($result,
array('organ'=>$row[1],
'blood'=>$row[2],
'contact'=>$row[3],
'age'=>$row[4],
'state'=>$row[5],
'city'=>$row[6],
'reason'=>$row[7],
'name'=>$row[10],
'username'=>$row[4]
));
}
 
echo json_encode(array("result"=>$result));
 
mysqli_close($con);
 
?>