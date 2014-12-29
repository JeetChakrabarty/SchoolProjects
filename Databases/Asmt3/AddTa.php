<h4> Please Enter Assistants Info</h4>
<form action = "AddTadata.php" method = "post" enctype = "multipart/form-data">
<label>First Name:</label> <br>
<input type = "text" name ="fname">
<br>
<label> Last Name</label> <br>
<input type ="text" name ="lname">
<br>
<label> Student Number </label> <br>
<input type = "text" name = "SNO">
<br>
<label> Western ID </label> <br>
<input type = "text" name = "WID">
<br>
<label> Head Professor ID </label><br>
<input type = "text" name = "PID">
<br>
<label>Degree Type</label><br>
<input type = "radio" name = "dtype" value = "Masters">Masters<br>
<input type = "radio" name ="dtype" value = "PhD">PhD<br>
<br>
<label>Upload Picture</label>
<input type = "file" name = "file" id = "file"> <br>
<br>
<input type = "submit" value = "Add a TA"><br>
</form>
