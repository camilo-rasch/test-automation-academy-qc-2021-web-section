>>Description

With this test you can check a flow to booking a round flight, you are going to find asserts to validate 
the flow, and the last step of this test is fill the basic information of the travelers.

- You can find the @Test "Booking a flight" in the following path:
  src\test\java\com\web\automation\testTestBooking\Flight.java
  
- The driver currently is configurated to run in Windows operating system and on chrome browser.
  If you want to run thos test in Mac or other browser, please change the configuration in the following file:
  src\main\java\com\web\automation\driver\Driver.java
  
- You can change the data that exist in the flow in the following file:
  src\test\java\com\web\automation\data\Data.java
  
>>The Test make the following steps.

1. Search for a flight from LAS to LAX. Selecting Flight and roundtrip. Select 2
adults in the travelers link. Dates should be at least two months in the future and
MUST be selected using the datepicker calendar.

2. Verify the result page using the following:
a. There is a combobox that allows you to order by Price, Departure, Arrival
and Duration.
b. The flight price is present on every result.
c. Flight duration is present on every result.
d. Flight airline and flight route (Departure and Destination) are present on
every result.

3. Sort by duration > shorter. Verify the flight’s result list was correctly sorted.

4. Select your departure to Los Angeles first flight result.
a. Verify selected flight estimated departure time and arrival time matches in
sidebar flight review.
b. Accept flight.

5. Select your departure to Las Vegas third flight result
a. Verify selected flight estimated departure time and arrival time matches in
sidebar flight review.
b. Accept flight.

6. If a “Search for Hotels” card pops up, select “No thanks”.

7. Verify trip details in the new page, as follows:
a. Trip total price is present.
b. Departure and Destination information is present.
c. Selected Fare is Economy.

8. Press the “Check out” button.

9. Complete passenger basic information.

10. Choose and apply at least 5 validations to be performed in this page (Be clear in
the code which validations you have chosen)
