# Quandoo-API-e2e
API E2E automation for the user login and register with Java with TestNG

* The technology stack that is used
    * Prerequistes 
        *  Java
        *  IDE ( IntelliJ )
        *  Maven
        *  TestNG

* The reason behind the chosen framework and pattern
    * Java and Maven:  Rest Assured enables you to test REST APIs using java libraries and integrates well with Maven.
    * Rest Assured.io framework has made JSON complexities simple using core java basics.     

* How to make the framework work and how to execute the test
    *   Clone a copy of the `Quandoo-API-e2e` repo locally
    *   Open the project using IDE
    *   Navigate to the `Test > java > steps >` directory and open the java class `add_user_APITest`
    *   Right click the project and select `Run as TestNG`
         * Or go to the select `Run/Debug configuration` and select `Run as TestNG` from the drop down and `Run` 

* View test output report
    *  Go to the `test-output` directory
    *  Right click on the `emailable-report.html` file
    *  Open in > Browser > Chrome

* Next possible steps for improvement
    *   Intrigrate cucumber and reduce code duplicate
    *   Validate the responce 
        * I was getting a `WARNING: An illegal reflective access operation has occurre` so that I couldn't verify the responce from the e2e test ( didn't manage to resolve it since it took longer time, this is a know issue ) 

