## Cinnamon Cinema 
Develop a program to allocate seats to customers purchasing tickers for a movie theatre.

### Requirements
The movie theatre has 15 seats, arranged in 3 rows of 5
<li>Rows are assigned a letter from A to C
<li>Seats are assigned a number from 1 to 5

<br>As a Cinnamon Cinemas Movie Theatre Manager
I want to allocate seats to customers
So that I can control reserved seating for the theatre
<li>GIVEN a customer wants to request some tickets
<li>WHEN they request a number of seats between 1 and 3 for a movie
<li>THEN the customer should be allocated the required number of seats from the available seating plan
<li>AND the seats should be recorded as allocated

### Acceptance criteria
<li>Write a program that allocates seats based on a random integer between 1 and 3
<li>Your program should allocate the required number of seats from the available seats starting from A1 and filling the auditorium from left to right, front to back
<li>All of the seats are available for sale when the program starts
<li>Once there are not enough seats available to be allocated then the program can halt

### Design
[UML Class Diagram](https://github.com/probert999/cinnamon-cinema/blob/main/uml/CinnamonCinema.png)

<li>BookingService - provides methods to add and retrieve movies, book seats, generate tickets and get customer list
<li>Cinema - has name of cinema and generates SeatingPlan. Passed into BookingService
<li>Movie - has movie details (name, time).  Each movie has its own SeatingPlan
<li>SeatingPlan - generates seats, maintains count and list of available seats and method to reserve seats
<li>Seat - has seat row and number, allocation status and customer id (if allocated)
<li>Ticket - has details of movie and seats
<li>Customer - maintains list of allocated tickets

#### Seat selection
The requirement to halt on not enough seats available to be allocated needs some clarification.
<br>This could mean the program is halted when a customer requests 3 seats and there are only 2 remaining, or
that booking remains open until the final seats are taken.  The program implements the latter for commercial reasons!

### Building and Running the application
Once cloned, the application can be built using the following Maven command:

><i>mvn compile package</i>

The unit tests will be executed as part of the build process which produces a jar file in the tagret directory.

<br>To run the application, from the command line, enter:

><i>java -jar target/cinnamon-cinema-1.0-SNAPSHOT.jar</i>

No user input is required.The output shows each booking request and whether it has been successful until all seats are booked.  A list of customers with the seat allocation is then produced.

### Future enhancements
<li>Multiple movies available for booking
<li>Take into consideration the date and time of the movie
<li>Different seating plan type
<li>Multiple screens within the cinema
<li>Improved automatic seat selection to keep customers on the same row
<li>Customer selection of seats
<li>Multiple customers booking at the same time (a lot to consider here!)
