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
   $whichProf= $_POST["ta"];
   $query = 'SELECT TEACHINGASSISTANT.firstname AS A, TEACHINGASSISTANT.lastname AS B, TEACHINGASSISTANT.gradtype AS C, COUNT(*) AS D FROM TAAssignedTO, TEACHINGASSISTANT WHERE TAAssignedTO.tauserid=TEACHINGASSISTANT.userid AND TEACHINGASSISTANT.userid ="' . $whichProf . '"';
   $result=mysqli_query($connection,$query);
    if (!$result) {
         die("database query2 failed.");
     }
    echo "<table border=\'1\' style=\'width:100%\'>";
    echo "<tr>
        <td>First Name</td>
        <td>Last Name</td>
        <td>Degree Type</td>
        <td>Number of Classes</td>
        <td>Max Number of Classes</td>
        <td>Can Still T.A?</td></tr>";
    while ($row=mysqli_fetch_assoc($result)) {
        echo "<tr><td>";
        echo $row["A"]."</td>";
        echo "<td>";
        echo $row["B"]."</td>";
        echo "<td>";
        echo $row["C"]."</td>";
        echo "<td>";
        echo $row["D"]."</td>";
        $t = $row["B"];
        if (strcmp($t,"PhD")==0){
                $max = 8;
        }
        else{
                $max =  3;
        }
        echo "<td>";
        echo $max."</td>";
        echo "<td>";
        if ($t<$max){
                echo "Yes </td>";
        }
        else {
                echo "No </td>";
        }
        echo "</tr>";
     }
     mysqli_free_result($result);
?>
<?php
   mysqli_close($connection);
?>
</body>
</html>

