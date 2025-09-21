Authentication (JWT Token)

This project uses JSON Web Token (JWT) authentication to secure APIs.
Once a user logs in successfully, the server generates a JWT token and returns it in the response.
This token must be included in the request headers for accessing protected APIs.

1. Login API

Endpoint:
user/authenticate/login

2. Using the JWT Token

For all secured endpoints, include the token in the Authorization header:
Example Request:

user/details/{user_id}

3. Token Expiry

JWT tokens are valid for a limited duration (60 Minutesr).

After expiry, you need to re-login to generate a new token.

4. Error Responses

401 Unauthorized → Missing or invalid token

403 Forbidden → Token expired or not allowed
