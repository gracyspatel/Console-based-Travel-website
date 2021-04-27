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