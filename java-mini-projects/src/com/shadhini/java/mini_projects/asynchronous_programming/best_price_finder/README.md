# Best Price Finder

Program to find the cheapest flight; just like those price comparison websites.

We have different flight agencies that we need to query to get a quote for a given flight.

Here's an output of this program:
```text
Getting a quote from site3
Getting a quote from site1
Getting a quote from site2
Quote{site='site2', price=108} 
Quote{site='site1', price=109} 
Quote{site='site3', price=105} 
Retrieved all quotes in 2415 msec
```
The program 
* gets quotes from 3 different sites, 
* prints quotes and 
* prints the time taken to retrieve all quotes.

Note:
* All of this should happen asynchronously, as these imaginary websites may respond in different times.
* Also, the program should not block the user interface and wait for the response. 
* As soon as it retrieves a quote from a flight agency, it should print it to the console.

