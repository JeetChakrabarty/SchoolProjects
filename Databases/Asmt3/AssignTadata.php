<!DOCTYPE html>
<html>
<head>
<meta charset = "utf-8">
<title>Assign TA</title>
</head>
<body>
<?php
include 'connectdb.php';
?>
<?php
$wid = $_POST["WID"];
$pid = $_POST["PID"];
$query = 'insert into CoSUPERVISE values("' . $pid . '","' . $wid . '")';
if (!mysqli_query($connection, $query)) {
die("Error: insert failed" .mysqli_error($connection));
}
else{

echo "Your TA was assigned";
}
?>
</body>
</html>

