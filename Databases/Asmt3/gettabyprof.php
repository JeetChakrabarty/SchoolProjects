<?php
   $query = "SELECT firstname as A, lastname as B, userid as C FROM INSTRUCTOR WHERE firstname NOT LIKE '' GROUP BY INSTRUCTOR.userid";
   $result = mysqli_query($connection,$query);
   if (!$result) {
        die("databases query failed.");
    }
   echo "Which professor are you looking up? </br>";
   while ($row = mysqli_fetch_assoc($result)) {
        echo '<input type="radio" name="professors" value="';
        echo $row["C"];
        echo '">' . $row["A"] . " " . $row["B"] .  "<br>";
   }
   mysqli_free_result($result);
?>

