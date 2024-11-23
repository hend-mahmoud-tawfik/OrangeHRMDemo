@echo off
:: Set Java and Allure paths
set JAVA_HOME=C:\Program Files\Java\jdk-17.0.5
set ALLURE=C:\Users\HIbrahim44\Downloads\allure-2.25.0 (1)\allure-2.25.0\bin

:: Update PATH environment variable
set path=%JAVA_HOME%\bin;%ALLURE%\bin;%path%

:: Run your TestNG tests with Maven and generate Allure results
mvn clean test

:: Generate and serve the Allure report
allure generate allure-results -o allure-report
allure serve allure-report

pause
exit