## Project Description: 

    This project is a simple full stack web application made in ReactJS, SpringBoot, MongoDb and Spring Cloud. 
    The app is a simple timesheet application where a user can view his timesheet data and edit it. 

## How to Run: 

  ### Backend

    The Backend folder is a Java project that contains the backend functionality. To enable the Eureka and 
    Config Server, you would need to *create a separate folder Config with three files: 
    CompositeMicroservice.properties, EmployeeMicroservice.properties, and TimesheetMicroservice.properties.* 
    Each of these files will only contain one config line: server.port: <enter the port number of your choice> 
    but make sure that all three of them have different numbers.
  
    After that you would need to create a git repo for this project and store these files there. Finally, you
    would need to link the ConfigServer module to this repo by copying the path to the Config folder that we just
    created into the application.properties file of ConfigServer.

    Once done, you should be able to run the project. 

  ### Database
    You would also need to configure your own backend mongodb service that would need to be structured accordingly.
    Look at the domain of the microservices on how to set it up. Finally, make sure you replace the dbName and 
    password in the core microservice to access your database.

  ### Frontend
    The frontend is a simple react application. Just npm start it!


  ## Major Contributors: 

  * Ahmad Saad
  * Zetian 'Aiden' Wu
  * Special Shoutout to "Minh Tran" for helping out with the Frontend
