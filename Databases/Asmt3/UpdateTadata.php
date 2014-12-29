<!DOCTYPE html>
<html>
<head>
<meta charset = "utf-8">
<title>Updating TA</title>
</head>
<body>
<?php
include 'connectdb.php';
?>
<?php
$wid = $_POST["WID"];
$fname = $_POST["fname"];
$lname = $_POST["lname"];
$headid = $_POST["headid"];
$dtype = $_POST["degtype"];
if (strlen(WID) > 0)
{
if(strlen($headid) > 0)
{
$query = 'update TEACHINGASSISTANT set  profuserid = "' . $headid . '" where userid = "' . $wid . '"";"';
}
if(strlen($fname) > 0)
{
$query= 'update TEACHINGASSISTANT Set firstname = "' . $fname . '" Where userid = "' .$wid . '"";"';
}
if(strlen($lname) > 0)
{
$query = 'update TEACHINGASSISTANT set lastname = "' . $lname . '" Where userid = "' . $wid . '"";"';
}
if(strlen($dtype) > 0)
{
$query = 'update TEACHINGASSISTANT set gradtype = "' . $dtype . '" Where userid = "' . $wid . '"";"';
}
}
if (!mysqli_query($connection, $query)) {
die("Error: insert failed" .mysqli_error($connection));
}
echo "Your TA was updated";
?>
</body>
</html>

