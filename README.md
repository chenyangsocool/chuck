# README

## how to get started with this solution

Enter the `starter` directory and execute the command `docker-compose -p truck-project up` to start all projects.

Then, access http://localhost:8080/truckList through a browser to see the project results.

## My Thoughts

### Solutions

Initially, I had three solutions.

1. The backend directly reads the contents of the CSV file.
2. The backend directly reads from a third-party data interface.
3. The backend synchronizes third-party data at scheduled intervals and retrieves data from the backend database to
   return
   to the frontend.

Ultimately, I chose the third solution because it allows for data timeliness while not being constrained by the query
conditions of third-party interfaces, making it easier to implement location-based query functionality.

## Deployment Methods

For deployment methods, I considered two options.

1. Write a separate Dockerfile for each project and start these projects individually using their Dockerfiles when
   needed.
2. Combine all projects into a Docker Compose and arrange the startup sequence.

In the end, I opted for the second solution because it enables one-click startup for all projects, which is very
convenient.

## Shortcomings

Due to time constraints, I was unable to implement the CLI query functionality, and the planned third-party data update
feature is also incomplete (currently, only data addition has been implemented).