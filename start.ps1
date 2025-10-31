# Script to start the Ghost Server Escape Room
Write-Host ""
Write-Host "========================================"  -ForegroundColor Cyan
Write-Host "  THE PHANTOM CODE: GHOST SERVER"         -ForegroundColor Green
Write-Host "========================================"  -ForegroundColor Cyan
Write-Host ""
Write-Host "Starting the server..." -ForegroundColor Yellow
Write-Host "The application will be available at: http://localhost:8080" -ForegroundColor Green
Write-Host ""
Write-Host "Press Ctrl+C to stop the server" -ForegroundColor Yellow
Write-Host ""

Set-Location $PSScriptRoot
& .\mvnw.cmd spring-boot:run
