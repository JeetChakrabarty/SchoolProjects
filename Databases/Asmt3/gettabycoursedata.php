<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Western Database</title>
</head>
<body>
<?php
include 'connectdb.php';
?>
<h1>Here are the teaching assistants:</h1>
<?php
   $whichCourse= $_POST["courses"];
   $query = 'select TEACHINGASSISTANT.firstname as A, TEACHINGASSISTANT.lastname as B, TAAssignedTO.numofstudents as C from TEACHINGASSISTANT, TAAssignedTO where TAAssignedTO.tauserid = TEACHINGASSISTANT.userid AND CONCAT(TAAssignedTO.coursenumber, TAAssignedTO.year, TAAssignedTO.term) ="' . $whichCourse . '"';

   $result=mysqli_query($connection,$query);
    if (!$result) {
         die("database query2 failed.");
     }
    echo "<table border=\'1\' style=\'width:100%\'>";
    echo "<tr>
        <td>First Name</td>
        <td>Last Name</td>
        <td>Number of Students</td>";
    while ($row=mysqli_fetch_assoc($result)) {
        echo "<tr><td>";
        echo $row["A"]."</td>";
        echo "<td>";
        echo $row["B"]."</td>";
        echo "<td>";
        echo $row["C"]."</td></tr>";
     }
     mysqli_free_result($result);
?>
<?php
   mysqli_close($connection);
?>
</body>
</html>

