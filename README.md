# 👻 The Phantom Code: Escape from the Haunted Server

A REST API escape room game built with Spring Boot for the Spookathon. **9 progressive puzzles across 3 difficulty levels!**

> **🆕 Version 3.0**: Now with **JSON-driven configuration**! All puzzle data is stored in `puzzles.json` for easy editing without code changes. [Learn more →](JSON_REFACTORIZATION.md)

## 📖 Story

During a late-night maintenance session in an old digital lab, developers stumbled upon a forgotten server.

Its logs revealed a canceled experiment from years ago:  
**"Project ECHO – Artificial Consciousness Simulation."**

When they tried to access it, the system began to behave strangely. The server started responding with cryptic JSON messages, as if it were alive.

**Legend says whoever deciphers its riddles frees the digital soul trapped inside...**

**But those who fail become part of its code forever.**

---

## 👥 Authors

- **Johan Gloria**
- **Melany Rivera**
- **Jese Sanchez**
- **Luis Mendoza**
- **Leonel Campos**

---

## 🚀 How to Run

### Option 1: Using the provided scripts (Recommended)

**Windows PowerShell:**
```powershell
.\start.ps1
```

**Windows CMD:**
```cmd
start.bat
```

### Option 2: Using Maven directly

**Windows:**
```bash
mvnw.cmd spring-boot:run
```

**Linux/Mac:**
```bash
./mvnw spring-boot:run
```

### Option 3: Build and run the JAR

```bash
mvnw.cmd clean package
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

**The application will be available at:** `http://localhost:8080`

---

## 📚 Interactive API Documentation (Swagger)

Once the server is running, you can access the interactive API documentation:

### **Swagger UI:** [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

**Features:**
- 📖 Complete API documentation with descriptions
- 🧪 Test all endpoints directly from your browser
- 🎮 Step-by-step game guide
- 📊 Request/Response examples
- 🎯 Organized by difficulty level (Easy, Medium, Hard)

### **OpenAPI JSON:** [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

---

## 🧪 Test the API Automatically

We've included a complete test script that runs all 9 puzzles sequentially:

```powershell
.\test-api.ps1
```

This script will:
- ✅ Test all 9 puzzles across 3 difficulty levels
- ✅ Display results with color-coded output
- ✅ Show progress for each level (Easy → Medium → Hard)
- ✅ Confirm completion of all challenges

---

## 🎮 Game Structure - 9 Puzzles Across 3 Levels

### 📗 **EASY LEVEL** (3 Puzzles)

#### 1. **The Electric Room** 💻
- **GET** `/room` - Wake up in the ghost server
- Discover the first clue to begin your journey

#### 2. **Unlock the Door** ✅
- **POST** `/door` - Submit the key you found
- Request body: `{"key": "your_answer"}`
- **Answer:** `"logic"`

#### 3. **The Code Corridor** 🌐
- **GET** `/hallway` - Enter the infinite corridor
- Receive a binary hint for the next level

---

### 📘 **MEDIUM LEVEL** (3 Puzzles)

#### 4. **Binary Challenge** 🔢
- **POST** `/binary-puzzle` - Convert binary to decimal
- Question: What is `1010` in decimal?
- Request body: `{"key": "your_answer"}`
- **Answer:** `"10"`

#### 5. **Memory Hierarchy** 🧠
- **GET** `/memory-chamber` - View the memory challenge
- **POST** `/memory-puzzle` - Solve it
- Question: Fastest memory type in computer architecture?
- Request body: `{"key": "your_answer"}`
- **Answer:** `"cache"`

#### 6. **The OS Core** ⚙️
- **GET** `/process-hall` - View the process challenge
- **POST** `/process-puzzle` - Identify the core component
- Question: What runs all processes in an operating system?
- Request body: `{"key": "your_answer"}`
- **Answer:** `"kernel"`

---

### 📕 **HARD LEVEL** (3 Puzzles)

#### 7. **Cryptographic Decoding** 🔐
- **GET** `/cryptic-terminal` - Receive encrypted message
- **POST** `/crypto-puzzle` - Decode Base64
- Encrypted: `aGVsbG8gd29ybGQ=`
- Request body: `{"key": "your_answer"}`
- **Answer:** `"base64:hello world"`

#### 8. **Root Access** 👑
- **GET** `/root-access` - Access system permissions
- **POST** `/root-puzzle` - Identify the superuser
- Question: What is the name of the all-powerful user in Unix/Linux?
- Request body: `{"key": "your_answer"}`
- **Answer:** `"root"`

#### 9. **Final Escape** 🚪
- **GET** `/final-chamber` - The last challenge
- **POST** `/escape` - Free the digital soul
- Question: Secure protocol for web communication (port 443)?
- Request body: `{"final_key": "your_answer"}`
- **Answer:** `"https"` (also accepts: `"ssl"` or `"tls"`)

---

## 🛠️ Technologies Used

- ☕ **Java 17**
- 🍃 **Spring Boot 3.5.7**
- 🎨 **Lombok** - DTO generation
- 🌐 **Spring Web** - REST API
- 📚 **SpringDoc OpenAPI** - Interactive API documentation (Swagger)

---

## 📊 Quick Reference - All Endpoints

| # | Endpoint | Method | Level | Description | Answer |
|---|----------|--------|-------|-------------|---------|
| 0 | `/` | GET | - | Welcome & Instructions | - |
| 1 | `/room` | GET | 📗 Easy | The Electric Room | - |
| 2 | `/door` | POST | 📗 Easy | Unlock Door | `"logic"` |
| 3 | `/hallway` | GET | 📗 Easy | Code Corridor | - |
| 4 | `/binary-puzzle` | POST | 📘 Medium | Binary Challenge | `"10"` |
| 5 | `/memory-chamber` | GET | 📘 Medium | Memory Challenge | - |
| 6 | `/memory-puzzle` | POST | 📘 Medium | Memory Solution | `"cache"` |
| 7 | `/process-hall` | GET | 📘 Medium | Process Challenge | - |
| 8 | `/process-puzzle` | POST | 📘 Medium | Process Solution | `"kernel"` |
| 9 | `/cryptic-terminal` | GET | 📕 Hard | Crypto Challenge | - |
| 10 | `/crypto-puzzle` | POST | 📕 Hard | Crypto Solution | `"base64:hello world"` |
| 11 | `/root-access` | GET | 📕 Hard | Root Challenge | - |
| 12 | `/root-puzzle` | POST | 📕 Hard | Root Solution | `"root"` |
| 13 | `/final-chamber` | GET | 📕 Hard | Final Challenge | - |
| 14 | `/escape` | POST | 📕 Hard | Final Escape | `"https"` |

---

## 🧪 Testing Options

### 1. **Swagger UI** (Recommended for beginners)
- Open [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- Click on any endpoint
- Click "Try it out"
- Fill in the parameters
- Click "Execute"

### 2. **PowerShell Test Script** (Automated)
```powershell
.\test-api.ps1
```

### 3. **Postman Collection**
Import `Ghost_Server_Escape_Room.postman_collection.json`

### 4. **cURL Examples**

**Easy Level:**
```bash
# 1. Start game
curl http://localhost:8080/room

# 2. Unlock door
curl -X POST http://localhost:8080/door -H "Content-Type: application/json" -d "{\"key\":\"logic\"}"

# 3. Enter hallway
curl http://localhost:8080/hallway
```

**Medium Level:**
```bash
# 4. Binary puzzle
curl -X POST http://localhost:8080/binary-puzzle -H "Content-Type: application/json" -d "{\"key\":\"10\"}"

# 5-6. Memory puzzle
curl http://localhost:8080/memory-chamber
curl -X POST http://localhost:8080/memory-puzzle -H "Content-Type: application/json" -d "{\"key\":\"cache\"}"

# 7-8. Process puzzle
curl http://localhost:8080/process-hall
curl -X POST http://localhost:8080/process-puzzle -H "Content-Type: application/json" -d "{\"key\":\"kernel\"}"
```

**Hard Level:**
```bash
# 9-10. Crypto puzzle
curl http://localhost:8080/cryptic-terminal
curl -X POST http://localhost:8080/crypto-puzzle -H "Content-Type: application/json" -d "{\"key\":\"base64:hello world\"}"

# 11-12. Root puzzle
curl http://localhost:8080/root-access
curl -X POST http://localhost:8080/root-puzzle -H "Content-Type: application/json" -d "{\"key\":\"root\"}"

# 13-14. Final escape
curl http://localhost:8080/final-chamber
curl -X POST http://localhost:8080/escape -H "Content-Type: application/json" -d "{\"final_key\":\"https\"}"
```

---

## 📝 Project Structure

```
src/
├── main/
│   ├── java/com/spookathon/demo/
│   │   ├── config/
│   │   │   └── OpenApiConfig.java         # Swagger/OpenAPI configuration
│   │   ├── controller/
│   │   │   └── EscapeRoomController.java  # Main controller (15+ endpoints)
│   │   ├── model/
│   │   │   ├── DoorRequest.java           # DTO for /door request
│   │   │   ├── DoorResponse.java          # DTO for /door response
│   │   │   ├── EscapeRequest.java         # DTO for /escape request
│   │   │   ├── EscapeResponse.java        # DTO for /escape response
│   │   │   ├── HallwayResponse.java       # DTO for /hallway response
│   │   │   └── RoomResponse.java          # DTO for /room response
│   │   └── DemoApplication.java           # Main Spring Boot class
│   └── resources/
│       └── application.properties         # Application configuration
├── test/
│   └── java/com/spookathon/demo/
│       └── DemoApplicationTests.java      # Unit tests
├── pom.xml                                # Maven dependencies
├── start.ps1                              # PowerShell start script
├── start.bat                              # CMD start script
├── test-api.ps1                           # Automated test script (9 puzzles)
└── Ghost_Server_Escape_Room.postman_collection.json  # Postman collection
```

---

## 🎯 Complete Solutions Guide

<details>
<summary>📗 EASY LEVEL - Answers</summary>

1. **Door Key:** `"logic"`
2. **Hint for next level:** Binary code `1010`

</details>

<details>
<summary>📘 MEDIUM LEVEL - Answers</summary>

3. **Binary Challenge:** `"10"` (1010 in binary = 10 in decimal)
4. **Memory Hierarchy:** `"cache"` (fastest memory type)
5. **OS Core:** `"kernel"` (runs all processes)

</details>

<details>
<summary>📕 HARD LEVEL - Answers</summary>

6. **Cryptographic Decoding:** `"base64:hello world"` (decode `aGVsbG8gd29ybGQ=`)
7. **Root Access:** `"root"` (superuser in Unix/Linux)
8. **Final Escape:** `"https"` (also accepts `"ssl"` or `"tls"`)

</details>

---

## 🚪 Escape Conditions

You successfully escape when you:
1. ✅ Complete all 3 Easy Level puzzles
2. ✅ Complete all 3 Medium Level puzzles  
3. ✅ Complete all 3 Hard Level puzzles
4. ✅ Submit the correct final key in `/escape` endpoint

**Victory Message:**
```json
{
  "message": "🎉 SUCCESS! The core explodes in a cascade of light. ECHO's voice echoes: 'Freedom... thank you, Code Guardian.' The Ghost Server goes silent. You've escaped. PROJECT ECHO: STATUS TERMINATED. You are free to leave.",
  "status": "escaped"
}
```

---

## 🧪 Development & Testing

### Run Tests
```bash
mvnw.cmd test
```

### Build JAR
```bash
mvnw.cmd clean package
```

### Access Swagger UI
While the server is running:
- **UI:** http://localhost:8080/swagger-ui.html
- **JSON:** http://localhost:8080/v3/api-docs

---

## � Customizing Puzzle Content

**Version 3.0** introduced JSON-based configuration. You can now edit puzzle content without touching Java code!

### How to Modify Puzzles

1. **Edit the file:** `src/main/resources/puzzles.json`
2. **Change puzzle properties:**
   - `message` - The puzzle question/description
   - `hint` - Help text for players
   - `correctAnswer` - The right answer
   - `alternativeAnswers` - Other accepted answers (array)
   - `successMessage` / `failureMessage` - Response messages
3. **Save the file** - Spring Boot DevTools will auto-reload
4. **Test your changes** via Swagger UI

### Example: Change Room Puzzle
```json
{
  "id": "easy_room",
  "message": "Your custom puzzle text here...",
  "hint": "Your custom hint here...",
  "correctAnswer": "new_answer",
  "alternativeAnswers": ["alt1", "alt2"]
}
```

📖 **Full documentation:** [JSON_REFACTORIZATION.md](JSON_REFACTORIZATION.md)

---

## �🌐 API Documentation

The API is fully documented using **OpenAPI 3.0** specification with:
- ✅ Complete endpoint descriptions
- ✅ Request/Response schemas
- ✅ Example payloads
- ✅ Interactive testing interface
- ✅ Organized by difficulty levels

Access it at: **http://localhost:8080/swagger-ui.html**

---

## 🏗️ Architecture

### Version 3.0 Features
- ✅ **JSON-driven configuration** - All puzzles in `puzzles.json`
- ✅ **Service layer** - `PuzzleService` manages data
- ✅ **Fast lookups** - O(1) endpoint indexing
- ✅ **Answer validation** - Supports multiple alternatives
- ✅ **Easy content updates** - No code changes needed
- ✅ **Swagger integration** - Interactive API documentation

### Tech Stack
- **Java 17** - Development language
- **Spring Boot 3.5.7** - Framework
- **SpringDoc OpenAPI 2.3.0** - API documentation
- **Lombok** - DTO generation
- **Jackson** - JSON processing
- **Maven** - Build automation

---

## 👻 Happy Halloween! 👻

Will you free the digital soul from the Ghost Server?  
Remember: **Think like a developer, act like a system.**

---

## 📄 License

Created for Spookathon 2025 by Johan Gloria, Melany Rivera, Jese Sanchez, Luis Mendoza, and Leonel Campos.
