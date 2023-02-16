# springboot-mgb

# Overview

Welcome! I love to continuously learn on my free time.  This is a simple Angular - Spring Boot application for a very basic Url link shortener I created to practice
and maintain my development skills.

Frameworks: Angular/Typescript (front end), Java on Spring Boot (back end)
Data Store: MySQL

To run locally:
- Download project
- Start the back end:
   - Open ShortenLinkApplication file
   - Run -> Run 'ShortenLinkApplication.java'
   - Endpoints are now available on localhost:8989 to exercise via Postman
- Start the front end:
   - From command line, navigate to the angularclient folder
   - Enter npm start
- On browser, navigate to localhost:4200 to start shortening Urls!
   
# What the application currently does
- Generates a unique link for each processed Url
- Persists original and new link to MySql Db
- When a shortened link is navigated to, the sessions is redirected to the original long link
- A count of the number of times a shortened link is visited is incremented in its entry on the Db with with every visit

# Planned enhancements to the application
- Flyway Db migration tracking
- Deprecation of Db items:
   - TTL
   - last access date and/or visit count
- Deploy and host in AWS


