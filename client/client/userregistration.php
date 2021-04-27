<?php
    if(isset($_POST['submit']))
    {
        $servername = "localhost";
        $database = "customer";
        $username = "root";
        $password = "";

        $username=$_POST['username'];
        $fname=$_POST['fname'];
        $lname=$_POST['lname'];
        $address=$_POST['address'];
        $email=$_POST['email'];


        // Create connection
        $conn = mysqli_connect('localhost', 'root','','customer');
        // Check connection
        if (!$conn) {
            die("Connection failed: " . mysqli_connect_error());
        }
 
        echo "Connected successfully";
 
        $sql = "INSERT INTO customer_registration (username,fname,lname,address,email) VALUES ('$username','$fname','$lname','$address','$email')";
        if (mysqli_query($conn, $sql)) {
            //echo "New record created successfully";
        } else {
            //echo "Error: " . $sql . "<br>" . mysqli_error($conn);
        }
        mysqli_close($conn);

    } 
?>


<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
	<title>Registration Form</title>
	<link rel="stylesheet" type="text/css" href="userregistration.css">
</head>
<body>
	<form action = "userregistration.php" mehod = "POST">
	<div class="wrapper">
		<div class="title">
			Registration Form
		</div>
		<div class="form">
			<div class="input_field">
				<label>Username</label>
				<input type="text" class="input" name="username" required>
			</div>
			<div class="input_field">
				<label>First Name</label>
				<input type="text" class="input"  name="fname" required>
			</div>
			<div class="input_field">
				<label>Last Name</label>
				<input type="text" class="input" name="lname" required>
			</div>
			<div class="input_field">
				<label>Address</label>
				<textarea class="textarea" name="address" required></textarea>
			</div>
			
			<div class="input_field">
				<label>Phone Number</label>
				<input type="phone" class="input" name="p_no" required>
			</div>
			<div class="input_field">
				<label>Email Address</label>
				<input type="text" class="input" name="email" required>
			</div>
			<div class="input_field">
				<input type="submit" value="Submit" class="btn"/><br>
			</div>
			<a href="packagebooking.php"><b>Next></b></a>
		</div>
	</div>
	</form>
</body>
</html>