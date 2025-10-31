@echo off
echo.
echo ========================================
echo   THE PHANTOM CODE: GHOST SERVER
echo ========================================
echo.
echo Starting the server...
echo The application will be available at: http://localhost:8080
echo.
echo Press Ctrl+C to stop the server
echo.

cd /d "%~dp0"
mvnw.cmd spring-boot:run
