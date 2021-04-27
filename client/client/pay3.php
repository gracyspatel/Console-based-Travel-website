<?php
//echo "done1";
    if(isset($_POST['submit']))
    {
        $servername = "localhost";
        $database = "payment";
        $username = "root";
        $password = "";
		//echo "done2";
        $cardnumber=$_POST['cardnumber'];
        $name=$_POST['name'];
        $expiry=$_POST['expiry'];
		$CVV=$_POST['CVV'];

		//echo "done3";
        // Create connection
        $conn = mysqli_connect('localhost', 'root','','payment');
        // Check connection
        if (!$conn) {
            die("Connection failed: " . mysqli_connect_error());
        }
		//echo "done3";
        //echo "Connected successfully";
 
        $sql = "INSERT INTO pay (cardnumber,name,expiry,CVV) VALUES ('$cardnumber','$name','$expiry','$CVV')";
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
	<title>PAY</title>
	<link rel="stylesheet" type="text/css" href="pay3.css">
</head>
<body>
<form action="pay3.php" method="POST">
	<div class="wrapper">
		<div class="checkout">
  			<h1> Checkout</h1>
  		</div>
  		<div class="form">
  			<div class="half">
				<label>Card Number: </label>
			    <input type="text" placeholder="Card number" name="cardnumber" required>
			</div>
			<div class="half">
				<label>Name on card :</label>
			    <input type="text" placeholder="Name on card" name="name" required>
			</div>
			
	    	<div class="half">
				<label>Expiry Date: </label>
		      	<input type="date" placeholder="MM/YY" name="expiry" required>
		    </div>
		    <div class="half">
				<label>CVV: </label>
		      	<input type="text" placeholder="CVV" name="CVV"  required>
		    </div>
		    <div class="half">
		    	<button type="submit" class="btn" name="submit">Pay Now</button>
			</div>
		</div>
	</div>
</form>
</body>
</html>
