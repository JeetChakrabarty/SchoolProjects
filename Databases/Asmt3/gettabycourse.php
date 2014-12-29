<?php
   $query = "select COURSE.coursename as A, COURSE.coursenumber as B, TAAssignedTO.year as C, TAAssignedTO.term as D from COURSE, TAAssignedTO where COURSE.coursenumber = TAAssignedTO.coursenumber";
   $result = mysqli_query($connection,$query);
   if (!$result) {
        die("databases query failed.");
    }
   echo "Which course offering are you looking up? </br>";
   while ($row = mysqli_fetch_assoc($result)) {
        echo '<input type="radio" name="courses" value="';
        echo $row["B"],$row["C"],$row["D"];
        echo '">' . $row["A"] . " " . $row["C"] . " " . $row["D"] .  "<br>";
   }
   mysqli_free_result($result);
?>



