# Maureva airline project

To clone the repo, run the following

```
git clone https://github.com/akash57039691/Maureva.git
```

Building + Running the app

1st step: mvn clean install

2nd step: Run the application and run this API first to save the user (excluded from Authentication)

```
http://localhost:8080/api/user-booking/save
```

3rd step: Authentication

I have set only 1 user.

Username: maureva

Password: maureva

Do a post request on http://localhost:8080/api/authenticate with above user.

Retrieve the token and putting "Authorization: Bearer "Token"" in the header for every request.

NOTE: Please use the airport.csv and flight.xml from the folder data found in the application.
1) Upload airports (Postman -> Body -> form-data, key: file, value: airport_info.csv):
```
POST http://localhost:8080/api/airline/upload/airport
```

2) Upload flights (Postman -> Body -> form-data, key: file, value: flight.xml):
```
POST http://localhost:8080/api/airline/upload/flight
```

3) List all the airports and their details.
```
GET http://localhost:8080/api/airline/list/airport
```

4) List a specific airport along with their details.
```
GET http://localhost:8080/api/airline/list/airport/{id}
```

5) List all available flights between an origin and a destination, as well as their details (seats available).
```
GET http://localhost:8080/api/airline/list/flight/available
```

6) Based on step 4, a user shall be able to make the necessary reservation.
```
POST http://localhost:8080/api/user-booking/save
```
Body:
``` json
{
    "userId": 1,
    "flightId": 1,
    "bookingId": 3
}
```

7) Generate OPENAPI specification.
```
http://localhost:8080/swagger-ui/index.html
```