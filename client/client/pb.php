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
            echo "New record created successfully";
        } else {
            //echo "Error: " . $sql . "<br>" . mysqli_error($conn);
        }
        mysqli_close($conn);

    } 
?>