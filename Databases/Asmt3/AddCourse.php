<?php
include 'connectdb.php';
?>
<h4> Please Enter Course Info</h4>
<form action = "AddCoursedata.php" method = "post">
<label>Course Name:</label> <br>
<input type = "text" name ="cname">
<br>
<label> Course Number </label> <br>
<input type = "text" name = "cno">
<br>
<br>
<input type = "submit" value = "Add Course"><br>
</form>
<br>
