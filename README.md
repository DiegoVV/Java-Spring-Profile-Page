# Java-Spring-Profile-Page
Project aimed at learning Java Spring while creating a common web application involving user profile and administration

The Front-End, made with react is located at src/main/frontend please execute npm install and then npm start from there after running the Java application

At localhost:3000 (or whichever port the application is running at), the admin login is "admin" with password "admin". You can navigate through / which is the login page, /list which is the admin user listing page, /signup which is the user creation page and /profile/{id} to see the profile of the user.

Get users: get request at http://localhost:8080/api/v1/user

Create user: post request at http://localhost:8080/api/v1/user with raw body of 
{
"name": "Postman",
"email": "post@gmail.mail",
"birthday": "1915-01-19",
"city": "Space",
"password": "password"
}

Get phones: get request at http://localhost:8080/api/v1/phone

Create phone: post request at http://localhost:8080/api/v1/phone with raw body of
{
"phone": "55 51 975346399"
}

Add phone to user: put request at http://localhost:8080/api/v1/phone/{phoneId}/users/{userId}

Get phones belongin to a certain user: get request at http://localhost:8080/api/v1/phone/users/{userId}