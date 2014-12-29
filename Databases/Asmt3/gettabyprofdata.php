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
   $whichProf= $_POST["professors"];
   $query = 'SELECT firstname as A, lastname as B, userid as C, gradtype as D, imagelocation as E FROM TEACHINGASSISTANT WHERE profuserid ="' . $whichProf . '"';
   $result=mysqli_query($connection,$query);
    if (!$result) {
         die("database query2 failed.");
     }
    echo "<table border=\'1\' style=\'width:100%\'>";
    echo "<tr>
        <td>First Name</td>
        <td>Last Name</td>
        <td>User ID</td>
        <td>Degree</td>
        <td>Prof Relation</td>
        <td>Picture</td></tr>";
    while ($row=mysqli_fetch_assoc($result)) {
        echo "<tr><td>";
        echo $row["A"]."</td>";
        echo "<td>";
        echo $row["B"]."</td>";
        echo "<td>";
        echo $row["C"]."</td>";
        echo "<td>";
        echo $row["D"]."</td>";
        echo "<td>Head</td>";
        echo "<td><img src=";
        echo $row["E"]."></td></tr>";
     }
     mysqli_free_result($result);
   $query = 'SELECT TEACHINGASSISTANT.firstname as A, TEACHINGASSISTANT.lastname as B, TEACHINGASSISTANT.userid as C, TEACHINGASSISTANT.gradtype as D, TEACHINGASSISTANT.imagelocation as E FROM TEACHINGASSISTANT, CoSUPERVISE WHERE TEACHINGASSISTANT.userid = CoSUPERVISE.tauserid AND CoSUPERVISE.profuserid ="' . $whichProf . '"';
   $result=mysqli_query($connection,$query);
    if (!$result) {
         die("database query2 failed.");
     }
    while ($row=mysqli_fetch_assoc($result)) {
        echo "<tr><td>";
        echo $row["A"]."</td>";
        echo "<td>";
        echo $row["B"]."</td>";
        echo "<td>";
        echo $row["C"]."</td>";
        echo "<td>";
        echo $row["D"]."</td>";
        echo "<td>Co-Super</td>";
        echo "<td><img src=";
        echo $row["E"]."></td></tr>";
     }
     mysqli_free_result($result);
?>
<?php
   mysqli_close($connection);
?>
</body>
</html>

