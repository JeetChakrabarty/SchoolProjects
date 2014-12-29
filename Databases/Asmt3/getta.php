<?php
   $query = "SELECT * FROM TEACHINGASSISTANT WHERE firstname NOT LIKE '';";
   $result = mysqli_query($connection,$query);
   if (!$result) {
        die("databases query failed.");
    }
   echo "Which teaching assistants are you looking up? </br>";
   while ($row = mysqli_fetch_assoc($result)) {
        echo '<input type="radio" name="ta" value="';
        echo $row["userid"];
        echo '">' . $row["firstname"] . " " . $row["lastname"] .  "<br>";
   }
   mysqli_free_result($result);
?>

