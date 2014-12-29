<!DOCTYPE html>
<html>
<head>
<meta charset = "utf-8">
<title>Delete Professor</title>
</head>
<body>
<?php
include 'connectdb.php';
?>
<?php
$wid = $_POST["WID"];
$findProf = 'select * FROM  INSTRUCTOR where userid = "' . $wid . '"';
$query = 'delete from INSTRUCTOR where userid = "' . $wid . '"';
if (!mysqli_query($connection, $query)) {
echo "Please reassign TA or delete TA";
}
else{
echo "Professor  was deleted if in the database or doesn't exist";
}
?>
</body>
</html>

