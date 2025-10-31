# 👻 Complete test script for The Phantom Code: Ghost Server (9 Puzzles - 3 Levels)

Write-Host ""
Write-Host "================================================================" -ForegroundColor Cyan
Write-Host "       THE PHANTOM CODE: GHOST SERVER - FULL CHALLENGE        " -ForegroundColor Green
Write-Host "          9 Puzzles Across 3 Difficulty Levels                " -ForegroundColor Yellow
Write-Host "================================================================" -ForegroundColor Cyan
Write-Host ""

# Verify server is running
try {
    $test = Invoke-RestMethod -Uri "http://localhost:8080/" -Method Get -ErrorAction Stop
    Write-Host "✅ Server connected at http://localhost:8080" -ForegroundColor Green
} catch {
    Write-Host "❌ ERROR: Server is not running at http://localhost:8080" -ForegroundColor Red
    Write-Host "   Please run first: .\start.ps1 or .\start.bat" -ForegroundColor Yellow
    exit
}

Start-Sleep -Seconds 1

# ======================
# EASY LEVEL - 3 Puzzles
# ======================

Write-Host ""
Write-Host "================================================================" -ForegroundColor Green
Write-Host "                    📗 EASY LEVEL (3 Puzzles)                   " -ForegroundColor Green
Write-Host "================================================================" -ForegroundColor Green

# Easy Puzzle 1: GET /room
Write-Host ""
Write-Host "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" -ForegroundColor DarkGray
Write-Host "📗 EASY 1/3: ELECTRIC ROOM 💻" -ForegroundColor Cyan
Write-Host "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" -ForegroundColor DarkGray
Write-Host "Endpoint: GET /room" -ForegroundColor Yellow
$response1 = Invoke-RestMethod -Uri "http://localhost:8080/room" -Method Get
Write-Host "📖 Message:" -ForegroundColor Magenta
Write-Host $response1.message -ForegroundColor White
Write-Host "🔍 Hint:" -ForegroundColor Magenta
Write-Host $response1.hint -ForegroundColor White
Start-Sleep -Seconds 2

# Easy Puzzle 2: POST /door
Write-Host ""
Write-Host "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" -ForegroundColor DarkGray
Write-Host "📗 EASY 2/3: UNLOCK THE DOOR ✅" -ForegroundColor Cyan
Write-Host "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" -ForegroundColor DarkGray
Write-Host "Endpoint: POST /door" -ForegroundColor Yellow
Write-Host "Trying with key: 'logic'" -ForegroundColor Yellow
$body = @{ key = "logic" } | ConvertTo-Json
$response2 = Invoke-RestMethod -Uri "http://localhost:8080/door" -Method Post -Body $body -ContentType "application/json"
Write-Host "💬 Message:" -ForegroundColor Magenta
Write-Host $response2.message -ForegroundColor White
Write-Host "📊 Status: $($response2.status)" -ForegroundColor Green
Start-Sleep -Seconds 2

# Easy Puzzle 3: GET /hallway
Write-Host ""
Write-Host "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" -ForegroundColor DarkGray
Write-Host "📗 EASY 3/3: THE CODE CORRIDOR 🌐" -ForegroundColor Cyan
Write-Host "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" -ForegroundColor DarkGray
Write-Host "Endpoint: GET /hallway" -ForegroundColor Yellow
$response3 = Invoke-RestMethod -Uri "http://localhost:8080/hallway" -Method Get
Write-Host "📖 Message:" -ForegroundColor Magenta
Write-Host $response3.message -ForegroundColor White
Write-Host "🔍 Hint:" -ForegroundColor Magenta
Write-Host $response3.hint -ForegroundColor White
Start-Sleep -Seconds 2

# ======================
# MEDIUM LEVEL - 3 Puzzles
# ======================

Write-Host ""
Write-Host "================================================================" -ForegroundColor Yellow
Write-Host "                  📘 MEDIUM LEVEL (3 Puzzles)                   " -ForegroundColor Yellow
Write-Host "================================================================" -ForegroundColor Yellow

# Medium Puzzle 1: POST /binary-puzzle
Write-Host ""
Write-Host "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" -ForegroundColor DarkGray
Write-Host "📘 MEDIUM 1/3: BINARY CHALLENGE 🔢" -ForegroundColor Cyan
Write-Host "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" -ForegroundColor DarkGray
Write-Host "Endpoint: POST /binary-puzzle" -ForegroundColor Yellow
Write-Host "Question: What is 1010 in decimal?" -ForegroundColor Yellow
Write-Host "Trying with answer: '10'" -ForegroundColor Yellow
$body = @{ key = "10" } | ConvertTo-Json
$response4 = Invoke-RestMethod -Uri "http://localhost:8080/binary-puzzle" -Method Post -Body $body -ContentType "application/json"
Write-Host "💬 Message:" -ForegroundColor Magenta
Write-Host $response4.message -ForegroundColor White
Write-Host "📊 Status: $($response4.status)" -ForegroundColor Green
Start-Sleep -Seconds 2

# Medium Puzzle 2: GET /memory-chamber + POST /memory-puzzle
Write-Host ""
Write-Host "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" -ForegroundColor DarkGray
Write-Host "📘 MEDIUM 2/3: MEMORY HIERARCHY 🧠" -ForegroundColor Cyan
Write-Host "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" -ForegroundColor DarkGray
Write-Host "Endpoint: GET /memory-chamber" -ForegroundColor Yellow
$response5 = Invoke-RestMethod -Uri "http://localhost:8080/memory-chamber" -Method Get
Write-Host "📖 Message:" -ForegroundColor Magenta
Write-Host $response5.message -ForegroundColor White
Write-Host "🔍 Hint:" -ForegroundColor Magenta
Write-Host $response5.hint -ForegroundColor White
Write-Host ""
Write-Host "Endpoint: POST /memory-puzzle" -ForegroundColor Yellow
Write-Host "Trying with answer: 'cache'" -ForegroundColor Yellow
$body = @{ key = "cache" } | ConvertTo-Json
$response6 = Invoke-RestMethod -Uri "http://localhost:8080/memory-puzzle" -Method Post -Body $body -ContentType "application/json"
Write-Host "💬 Message:" -ForegroundColor Magenta
Write-Host $response6.message -ForegroundColor White
Write-Host "📊 Status: $($response6.status)" -ForegroundColor Green
Start-Sleep -Seconds 2

# Medium Puzzle 3: GET /process-hall + POST /process-puzzle
Write-Host ""
Write-Host "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" -ForegroundColor DarkGray
Write-Host "📘 MEDIUM 3/3: THE OS CORE ⚙️" -ForegroundColor Cyan
Write-Host "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" -ForegroundColor DarkGray
Write-Host "Endpoint: GET /process-hall" -ForegroundColor Yellow
$response7 = Invoke-RestMethod -Uri "http://localhost:8080/process-hall" -Method Get
Write-Host "📖 Message:" -ForegroundColor Magenta
Write-Host $response7.message -ForegroundColor White
Write-Host "🔍 Hint:" -ForegroundColor Magenta
Write-Host $response7.hint -ForegroundColor White
Write-Host ""
Write-Host "Endpoint: POST /process-puzzle" -ForegroundColor Yellow
Write-Host "Trying with answer: 'kernel'" -ForegroundColor Yellow
$body = @{ key = "kernel" } | ConvertTo-Json
$response8 = Invoke-RestMethod -Uri "http://localhost:8080/process-puzzle" -Method Post -Body $body -ContentType "application/json"
Write-Host "💬 Message:" -ForegroundColor Magenta
Write-Host $response8.message -ForegroundColor White
Write-Host "📊 Status: $($response8.status)" -ForegroundColor Green
Start-Sleep -Seconds 2

# ======================
# HARD LEVEL - 3 Puzzles
# ======================

Write-Host ""
Write-Host "================================================================" -ForegroundColor Red
Write-Host "                   📕 HARD LEVEL (3 Puzzles)                    " -ForegroundColor Red
Write-Host "================================================================" -ForegroundColor Red

# Hard Puzzle 1: GET /cryptic-terminal + POST /crypto-puzzle
Write-Host ""
Write-Host "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" -ForegroundColor DarkGray
Write-Host "📕 HARD 1/3: CRYPTOGRAPHIC DECODING 🔐" -ForegroundColor Cyan
Write-Host "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" -ForegroundColor DarkGray
Write-Host "Endpoint: GET /cryptic-terminal" -ForegroundColor Yellow
$response9 = Invoke-RestMethod -Uri "http://localhost:8080/cryptic-terminal" -Method Get
Write-Host "📖 Message:" -ForegroundColor Magenta
Write-Host $response9.message -ForegroundColor White
Write-Host "🔍 Hint:" -ForegroundColor Magenta
Write-Host $response9.hint -ForegroundColor White
Write-Host ""
Write-Host "Endpoint: POST /crypto-puzzle" -ForegroundColor Yellow
Write-Host "Trying with answer: 'base64:hello world'" -ForegroundColor Yellow
$body = @{ key = "base64:hello world" } | ConvertTo-Json
$response10 = Invoke-RestMethod -Uri "http://localhost:8080/crypto-puzzle" -Method Post -Body $body -ContentType "application/json"
Write-Host "💬 Message:" -ForegroundColor Magenta
Write-Host $response10.message -ForegroundColor White
Write-Host "📊 Status: $($response10.status)" -ForegroundColor Green
Start-Sleep -Seconds 2

# Hard Puzzle 2: GET /root-access + POST /root-puzzle
Write-Host ""
Write-Host "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" -ForegroundColor DarkGray
Write-Host "📕 HARD 2/3: ROOT ACCESS 👑" -ForegroundColor Cyan
Write-Host "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" -ForegroundColor DarkGray
Write-Host "Endpoint: GET /root-access" -ForegroundColor Yellow
$response11 = Invoke-RestMethod -Uri "http://localhost:8080/root-access" -Method Get
Write-Host "📖 Message:" -ForegroundColor Magenta
Write-Host $response11.message -ForegroundColor White
Write-Host "🔍 Hint:" -ForegroundColor Magenta
Write-Host $response11.hint -ForegroundColor White
Write-Host ""
Write-Host "Endpoint: POST /root-puzzle" -ForegroundColor Yellow
Write-Host "Trying with answer: 'root'" -ForegroundColor Yellow
$body = @{ key = "root" } | ConvertTo-Json
$response12 = Invoke-RestMethod -Uri "http://localhost:8080/root-puzzle" -Method Post -Body $body -ContentType "application/json"
Write-Host "💬 Message:" -ForegroundColor Magenta
Write-Host $response12.message -ForegroundColor White
Write-Host "📊 Status: $($response12.status)" -ForegroundColor Green
Start-Sleep -Seconds 2

# Hard Puzzle 3: GET /final-chamber + POST /escape
Write-Host ""
Write-Host "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" -ForegroundColor DarkGray
Write-Host "📕 HARD 3/3: FINAL ESCAPE 🚪" -ForegroundColor Cyan
Write-Host "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" -ForegroundColor DarkGray
Write-Host "Endpoint: GET /final-chamber" -ForegroundColor Yellow
$response13 = Invoke-RestMethod -Uri "http://localhost:8080/final-chamber" -Method Get
Write-Host "📖 Message:" -ForegroundColor Magenta
Write-Host $response13.message -ForegroundColor White
Write-Host "🔍 Hint:" -ForegroundColor Magenta
Write-Host $response13.hint -ForegroundColor White
Write-Host ""
Write-Host "Endpoint: POST /escape" -ForegroundColor Yellow
Write-Host "Trying with final key: 'https'" -ForegroundColor Yellow
$body = @{ final_key = "https" } | ConvertTo-Json
$response14 = Invoke-RestMethod -Uri "http://localhost:8080/escape" -Method Post -Body $body -ContentType "application/json"
Write-Host "💬 Message:" -ForegroundColor Magenta
Write-Host $response14.message -ForegroundColor White
Write-Host "📊 Status: $($response14.status)" -ForegroundColor Green

# Final
Write-Host ""
Write-Host "================================================================" -ForegroundColor Cyan
Write-Host "        ✨ YOU'VE COMPLETED ALL 9 PUZZLES! ✨                  " -ForegroundColor Green
Write-Host "     THE DIGITAL SOUL IS FREE - YOU'VE ESCAPED!                " -ForegroundColor Green
Write-Host "================================================================" -ForegroundColor Cyan
Write-Host ""
Write-Host "👻 All 9 puzzles completed successfully across 3 levels! 👻" -ForegroundColor Yellow
Write-Host ""
Write-Host "📗 Easy Level: 3/3 ✓" -ForegroundColor Green
Write-Host "📘 Medium Level: 3/3 ✓" -ForegroundColor Green
Write-Host "📕 Hard Level: 3/3 ✓" -ForegroundColor Green
Write-Host ""
Write-Host "Created by: Johan Gloria, Melany Rivera, Jese Sanchez, Luis Mendoza, Leonel Campos" -ForegroundColor Gray
Write-Host ""
