<?php
    //echo"Hello";
    if(isset($_POST['submit']))
    {
        $servername = "localhost";
        $database = "package";
        $username = "root";
        $password = "";
		
        $from_p=isset($_POST['from_p']) ? $_POST['from_p'] : '';
        $to_p=isset($_POST['to_p']) ? $_POST['to_p'] : '';
        $departure_date=isset($_POST['departure_date']) ? $_POST['departure_date'] : '';
        $return_date=isset($_POST['return_date']) ? $_POST['return_date'] : '';
		$airline=isset($_POST['airline']) ? $_POST['airline'] : '';
        $seating=isset($_POST['seating']) ? $_POST['seating'] : '';
        $adult=isset($_POST['adult']) ? $_POST['adult'] : '';
		$children=isset($_POST['children']) ? $_POST['children'] : '';
		

        // Create connection
        $conn = mysqli_connect('localhost', 'root','','package');
        // Check connection
        if (!$conn) {
			die("Connection failed: " . mysqli_connect_error());
			echo "Did not connect";
        }
		
        $sql = "INSERT INTO package_booking (from_p,to_p,departure_date,return_date,airline,seating,adult,children) VALUES ('$from_p','$to_p','$departure_date','$return_date','$airline','$seating','$adult','$children')";
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
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
	<title>Package Booking</title>
	<link rel="stylesheet" type="text/css" href="packagebooking.css">

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container"><!--container-->
		
		<form action="packagebooking.php" method="POST">
			<br>
			<h1 class="text-center">Package Booking Form</h1>
			<br>
			<div id="form"><!--form-->
				<h3 class="text-white">Booking Details </h3>
				<div id="input"><!--input-->
					<input type="text" id="input-group" placeholder="From" name="from_p" required><br>
					<input type="text" id="input-group" placeholder="To" name="to_p" required>
				</div>
				<br>
				<div class="input">
					<label>Departure Date</label>
					<input type="date" id="input-group" placeholder="Departure Date" name= "departure_date">
				</div><br>
				<div class="input">
					<label>Return Date</label>
					<input type="date" id="input-group" placeholder="Return Date" name="return_date">
				</div>
				<div id="input">
					<select id="input-group" style="background: black;">
						<option value="" name="airline">Preferred Airline</option>
						<option value="" name="airline">Kingfisher</option>
						<option value="" name="airline">AirIndia</option>
						<option value="" name="airline">JetAirways</option>
					</select>
					<br>
					<select id="input-group" style="background: black;">
						<option value="" name="seating">Preferred Seating</option>
						<option value="" name="seating">Business Class</option>
						<option value="" name="seating">Economy Class</option>
						<option value="" name="seating">First Class</option>
					</select>
				</div><!--input-->

				<div id="input2"><!--input2-->
					<input type="number" id="input-group" placeholder="Adult" name="adult"><br>
					<input type="number" id="input-group" placeholder="Children(0-11 years)" name="children"><br>
				</div><!--input2-->

				<input type="submit" class="btn btn-warning" name="submit" value="Submit" class="btn">
				<button  class="btn btn-warning"><a href="pay3.php"> Proceed To Pay</button></a>
				<button type="reset" class="btn btn-warning">Reset Form</button>
			</div><!--form-->

		</form><!--container-->
	</div>
</body>
</html>