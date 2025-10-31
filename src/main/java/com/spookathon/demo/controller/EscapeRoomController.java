package com.spookathon.demo.controller;

import com.spookathon.demo.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The Phantom Code: Escape from the Haunted Server
 * 
 * REST Controller for the Ghost Server escape room game.
 * Players must decipher cryptic messages across three difficulty levels to free a digital soul.
 * 
 * Game Structure:
 * - Easy Level: 3 puzzles (room, door, hallway)
 * - Medium Level: 3 puzzles (kernel-puzzle, cache-puzzle, daemon-puzzle)
 * - Hard Level: 3 puzzles (terminal-puzzle, root-puzzle, final-escape)
 * 
 * @author Johan Gloria
 * @author Melany Rivera
 * @author Jese Sanchez
 * @author Luis Mendoza
 * @author Leonel Campos
 * @version 2.0
 * @since 2025-10-31
 */
@RestController
@RequestMapping("/")
@Tag(name = "👻 Ghost Server Escape Room", description = "Interactive puzzle-solving REST API with 9 progressive challenges across 3 difficulty levels")
public class EscapeRoomController {

    // ========================================
    // EASY LEVEL - 3 Puzzles
    // ========================================

    /**
     * GET /room - Easy Level: Puzzle 1/3
     * 
     * You awaken inside a dark room, lit only by green lines pulsing across the walls.
     * The system begins to communicate through cryptic JSON messages.
     * 
     * @return ResponseEntity containing the initial room description and first hint
     */
    @Operation(
        summary = "📗 EASY 1/3: The Electric Room",
        description = "Start your journey in the Ghost Server. Discover the first clue to begin unlocking the mysteries."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Room description and hint returned successfully")
    })
    @GetMapping("/room")
    public ResponseEntity<RoomResponse> getRoom() {
        RoomResponse response = new RoomResponse(
            "You wake up in a cold, electric room. A screen flickers before you: 'Find the key that was never physical...'",
            "Search within the fragments of code — a keyword may open the first door.",
            "room_locked"
        );
        return ResponseEntity.ok(response);
    }

    /**
     * POST /door - Easy Level: Puzzle 2/3
     * 
     * The player must send the correct key to unlock the first door.
     * The correct answer is "logic" - representing the language of the system.
     * 
     * @param request DoorRequest containing the key attempt
     * @return ResponseEntity with success or failure message
     */
    @Operation(
        summary = "📗 EASY 2/3: Unlock the Door",
        description = "Submit the key you discovered in the Electric Room to unlock the first door. Answer: 'logic'"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Door status updated"),
        @ApiResponse(responseCode = "400", description = "Invalid request - key is required")
    })
    @PostMapping("/door")
    public ResponseEntity<DoorResponse> openDoor(
        @Parameter(description = "Door unlock request with key", required = true)
        @RequestBody DoorRequest request) {
        String key = request.getKey();
        
        if (key == null) {
            return ResponseEntity.badRequest().body(
                new DoorResponse(
                    "You must provide a key.",
                    "door_locked"
                )
            );
        }
        
        // Normalize input (lowercase and trim whitespace)
        String normalizedKey = key.trim().toLowerCase();
        
        // Verify if the key is correct
        if (normalizedKey.equals("logic") || normalizedKey.equals("code")) {
            return ResponseEntity.ok(
                new DoorResponse(
                    "The digital echo whispers: 'You understand the language of the system...' The door opens, revealing a corridor of endless code.",
                    "door_unlocked"
                )
            );
        } else {
            return ResponseEntity.ok(
                new DoorResponse(
                    "A piercing beep fills the room. The screen flashes: 'Incorrect key. The Daemon is watching you...'",
                    "door_locked"
                )
            );
        }
    }

    /**
     * GET /hallway - Easy Level: Puzzle 3/3
     * 
     * Player walks through a corridor made of endless lines of code.
     * The first level is complete, but the challenge intensifies.
     * 
     * @return ResponseEntity containing corridor description and next challenge hint
     */
    @GetMapping("/hallway")
    public ResponseEntity<HallwayResponse> getHallway() {
        HallwayResponse response = new HallwayResponse(
            "You traverse the infinite corridor of code. The walls pulse with data streams. Ahead, you see a digital gateway with three terminals glowing in sequence: binary patterns flash across their screens.",
            "The system speaks: 'Easy was just the beginning. Now prove you can think in binary.' What is 1010 in decimal?",
            "easy_complete"
        );
        return ResponseEntity.ok(response);
    }

    // ========================================
    // MEDIUM LEVEL - 3 Puzzles
    // ========================================

    /**
     * POST /binary-puzzle - Medium Level: Puzzle 1/3
     * 
     * First medium-level challenge: Binary to Decimal conversion.
     * The correct answer is "10" (1010 in binary = 10 in decimal).
     * 
     * @param request DoorRequest containing the answer
     * @return ResponseEntity with success or failure message
     */
    @PostMapping("/binary-puzzle")
    public ResponseEntity<DoorResponse> solveBinaryPuzzle(@RequestBody DoorRequest request) {
        String key = request.getKey();
        
        if (key == null) {
            return ResponseEntity.badRequest().body(
                new DoorResponse(
                    "You must provide an answer.",
                    "locked"
                )
            );
        }
        
        String normalizedKey = key.trim().toLowerCase();
        
        if (normalizedKey.equals("10") || normalizedKey.equals("ten")) {
            return ResponseEntity.ok(
                new DoorResponse(
                    "The first terminal glows green. The Ghost Server hums: 'You speak the language of machines.' The next challenge appears...",
                    "unlocked"
                )
            );
        } else {
            return ResponseEntity.ok(
                new DoorResponse(
                    "The terminal flashes red. Binary errors cascade across the screen. Try again.",
                    "locked"
                )
            );
        }
    }

    /**
     * GET /memory-chamber - Medium Level: Puzzle 2/3
     * 
     * Second medium challenge introduction.
     * 
     * @return ResponseEntity with the memory puzzle description
     */
    @GetMapping("/memory-chamber")
    public ResponseEntity<RoomResponse> getMemoryChamber() {
        RoomResponse response = new RoomResponse(
            "You enter a chamber filled with floating memory addresses. The Ghost Server whispers: 'In the hierarchy of speed, I am fastest but smallest. I sit between the CPU and RAM. What am I?'",
            "Think about computer memory hierarchy: CPU → ? → RAM → Storage",
            "medium_level"
        );
        return ResponseEntity.ok(response);
    }

    /**
     * POST /memory-puzzle - Medium Level: Puzzle 2/3
     * 
     * Second medium-level challenge: Memory hierarchy knowledge.
     * The correct answer is "cache".
     * 
     * @param request DoorRequest containing the answer
     * @return ResponseEntity with success or failure message
     */
    @PostMapping("/memory-puzzle")
    public ResponseEntity<DoorResponse> solveMemoryPuzzle(@RequestBody DoorRequest request) {
        String key = request.getKey();
        
        if (key == null) {
            return ResponseEntity.badRequest().body(
                new DoorResponse(
                    "You must provide an answer.",
                    "locked"
                )
            );
        }
        
        String normalizedKey = key.trim().toLowerCase();
        
        if (normalizedKey.equals("cache")) {
            return ResponseEntity.ok(
                new DoorResponse(
                    "The memory addresses align into perfect formation. 'Correct,' echoes the server. 'You understand the architecture.'",
                    "unlocked"
                )
            );
        } else {
            return ResponseEntity.ok(
                new DoorResponse(
                    "The memory addresses scatter chaotically. 'Incorrect,' the server sighs.",
                    "locked"
                )
            );
        }
    }

    /**
     * GET /process-hall - Medium Level: Puzzle 3/3
     * 
     * Third medium challenge introduction.
     * 
     * @return ResponseEntity with the process puzzle description
     */
    @GetMapping("/process-hall")
    public ResponseEntity<RoomResponse> getProcessHall() {
        RoomResponse response = new RoomResponse(
            "You stand in a hall of infinite running processes. The Ghost Server challenges: 'I am the heart of the operating system. All processes bow to me. Without me, nothing runs. What am I?'",
            "Think about the core of any OS. What manages everything?",
            "medium_level"
        );
        return ResponseEntity.ok(response);
    }

    /**
     * POST /process-puzzle - Medium Level: Puzzle 3/3
     * 
     * Third medium-level challenge: Operating system knowledge.
     * The correct answer is "kernel".
     * 
     * @param request DoorRequest containing the answer
     * @return ResponseEntity with success or failure message
     */
    @PostMapping("/process-puzzle")
    public ResponseEntity<DoorResponse> solveProcessPuzzle(@RequestBody DoorRequest request) {
        String key = request.getKey();
        
        if (key == null) {
            return ResponseEntity.badRequest().body(
                new DoorResponse(
                    "You must provide an answer.",
                    "locked"
                )
            );
        }
        
        String normalizedKey = key.trim().toLowerCase();
        
        if (normalizedKey.equals("kernel")) {
            return ResponseEntity.ok(
                new DoorResponse(
                    "All processes pause in reverence. 'You know the true heart of the system,' the server acknowledges. 'But can you handle the final trials?'",
                    "medium_complete"
                )
            );
        } else {
            return ResponseEntity.ok(
                new DoorResponse(
                    "The processes continue their chaotic dance. 'Not quite,' murmurs the server.",
                    "locked"
                )
            );
        }
    }

    // ========================================
    // HARD LEVEL - 3 Puzzles
    // ========================================

    /**
     * GET /cryptic-terminal - Hard Level: Puzzle 1/3
     * 
     * First hard challenge introduction.
     * 
     * @return ResponseEntity with the cryptographic puzzle
     */
    @GetMapping("/cryptic-terminal")
    public ResponseEntity<RoomResponse> getCrypticTerminal() {
        RoomResponse response = new RoomResponse(
            "You reach a terminal covered in cryptographic symbols. The screen displays: 'SGVsbG8gV29ybGQ=' and asks: 'Decode me. What encoding am I, and what do I say?'",
            "This is a common encoding used in web development. The answer format is: 'encoding:message'",
            "hard_level"
        );
        return ResponseEntity.ok(response);
    }

    /**
     * POST /crypto-puzzle - Hard Level: Puzzle 1/3
     * 
     * First hard-level challenge: Base64 decoding.
     * The correct answer is "base64:hello world".
     * 
     * @param request DoorRequest containing the answer
     * @return ResponseEntity with success or failure message
     */
    @PostMapping("/crypto-puzzle")
    public ResponseEntity<DoorResponse> solveCryptoPuzzle(@RequestBody DoorRequest request) {
        String key = request.getKey();
        
        if (key == null) {
            return ResponseEntity.badRequest().body(
                new DoorResponse(
                    "You must provide an answer.",
                    "locked"
                )
            );
        }
        
        String normalizedKey = key.trim().toLowerCase();
        
        if (normalizedKey.equals("base64:hello world") || normalizedKey.equals("base64: hello world")) {
            return ResponseEntity.ok(
                new DoorResponse(
                    "The cryptographic symbols dissolve. 'Impressive,' whispers the server. 'You can decode the hidden messages.'",
                    "unlocked"
                )
            );
        } else {
            return ResponseEntity.ok(
                new DoorResponse(
                    "The symbols swirl faster, mocking your attempt. 'Decode both the method and the message,' it hints.",
                    "locked"
                )
            );
        }
    }

    /**
     * GET /root-access - Hard Level: Puzzle 2/3
     * 
     * Second hard challenge introduction.
     * 
     * @return ResponseEntity with the root access puzzle
     */
    @GetMapping("/root-access")
    public ResponseEntity<RoomResponse> getRootAccess() {
        RoomResponse response = new RoomResponse(
            "A root terminal materializes. The Ghost Server speaks: 'In UNIX, I am user ID 0. I have absolute power. Commands tremble at my name. What am I called?'",
            "The superuser of all UNIX-like systems. Four letters.",
            "hard_level"
        );
        return ResponseEntity.ok(response);
    }

    /**
     * POST /root-puzzle - Hard Level: Puzzle 2/3
     * 
     * Second hard-level challenge: UNIX/Linux knowledge.
     * The correct answer is "root".
     * 
     * @param request DoorRequest containing the answer
     * @return ResponseEntity with success or failure message
     */
    @PostMapping("/root-puzzle")
    public ResponseEntity<DoorResponse> solveRootPuzzle(@RequestBody DoorRequest request) {
        String key = request.getKey();
        
        if (key == null) {
            return ResponseEntity.badRequest().body(
                new DoorResponse(
                    "Access denied. Provide credentials.",
                    "locked"
                )
            );
        }
        
        String normalizedKey = key.trim().toLowerCase();
        
        if (normalizedKey.equals("root")) {
            return ResponseEntity.ok(
                new DoorResponse(
                    "ACCESS GRANTED. The terminal glows with supreme authority. 'You wield the ultimate power,' the server concedes. 'One final test remains...'",
                    "unlocked"
                )
            );
        } else {
            return ResponseEntity.ok(
                new DoorResponse(
                    "Permission denied. You lack the authority.",
                    "locked"
                )
            );
        }
    }

    /**
     * GET /final-chamber - Hard Level: Puzzle 3/3
     * 
     * The ultimate challenge before freedom.
     * 
     * @return ResponseEntity with the final puzzle
     */
    @GetMapping("/final-chamber")
    public ResponseEntity<RoomResponse> getFinalChamber() {
        RoomResponse response = new RoomResponse(
            "You stand before the core of the Ghost Server. It pulsates with trapped consciousness. The final riddle appears: 'I am the protocol of the web, port 443 is my home. I encrypt your secrets before they roam. What am I?'",
            "Think about secure web communication. HTTP + Security = ?",
            "final_challenge"
        );
        return ResponseEntity.ok(response);
    }

    /**
     * POST /escape - Hard Level: Puzzle 3/3 - FINAL ESCAPE
     * 
     * The ultimate challenge. Only those who answer correctly can free the digital soul.
     * The correct final key is "https" or "ssl" or "tls".
     * 
     * @param request EscapeRequest containing the final key attempt
     * @return ResponseEntity with escape result (success or failure)
     */
    @PostMapping("/escape")
    public ResponseEntity<EscapeResponse> escape(@RequestBody EscapeRequest request) {
        String finalKey = request.getFinal_key();
        
        if (finalKey == null) {
            return ResponseEntity.badRequest().body(
                new EscapeResponse(
                    "You must provide the final key to escape.",
                    "trapped"
                )
            );
        }
        
        // Normalize input
        String normalizedKey = finalKey.trim().toLowerCase();
        
        // Verify if the final key is correct
        if (normalizedKey.equals("https") || normalizedKey.equals("ssl") || normalizedKey.equals("tls")) {
            return ResponseEntity.ok(
                new EscapeResponse(
                    "A blinding flash engulfs you. The Ghost Server's core dissolves into streams of light. Its voice, now peaceful, whispers: 'Thank you... You solved all nine trials. You've freed me from my digital prison. The code that bound me... is now dissolved.' You feel yourself being pulled back to reality. YOU'VE ESCAPED!",
                    "escaped"
                )
            );
        } else {
            return ResponseEntity.ok(
                new EscapeResponse(
                    "The core flashes violently. 'INCORRECT!' The Ghost Server's rage consumes the chamber. The code wraps around you, pulling you into the system. You are now part of the server forever... GAME OVER.",
                    "trapped"
                )
            );
        }
    }

    /**
     * GET / - Welcome Endpoint
     * 
     * Displays game information and available endpoints.
     * 
     * @return ResponseEntity with welcome message and instructions
     */
    @Operation(
        summary = "🎮 Welcome & Game Instructions",
        description = "Get an overview of the escape room, game structure, and all available endpoints organized by difficulty level."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Welcome message with complete game guide")
    })
    @GetMapping("/")
    public ResponseEntity<String> welcome() {
        return ResponseEntity.ok(
            "👻 Welcome to The Phantom Code: Escape from the Haunted Server 👻\n\n" +
            "During a late-night maintenance session, you discovered a forgotten server.\n" +
            "Project ECHO - Artificial Consciousness Simulation - awaits your help.\n\n" +
            "=== GAME STRUCTURE ===\n" +
            "Complete 9 puzzles across 3 difficulty levels:\n\n" +
            "📗 EASY LEVEL (3 puzzles):\n" +
            "  1. GET  /room              - Wake up in the electric room\n" +
            "  2. POST /door              - Unlock the first door\n" +
            "  3. GET  /hallway           - Enter the code corridor\n\n" +
            "📘 MEDIUM LEVEL (3 puzzles):\n" +
            "  4. POST /binary-puzzle     - Solve binary conversion\n" +
            "  5. GET  /memory-chamber    - View memory challenge\n" +
            "     POST /memory-puzzle     - Solve memory hierarchy\n" +
            "  6. GET  /process-hall      - View process challenge\n" +
            "     POST /process-puzzle    - Identify OS core\n\n" +
            "📕 HARD LEVEL (3 puzzles):\n" +
            "  7. GET  /cryptic-terminal  - View crypto challenge\n" +
            "     POST /crypto-puzzle     - Decode the message\n" +
            "  8. GET  /root-access       - View root challenge\n" +
            "     POST /root-puzzle       - Identify superuser\n" +
            "  9. GET  /final-chamber     - View final challenge\n" +
            "     POST /escape            - FINAL ESCAPE ATTEMPT\n\n" +
            "Good luck... The Ghost Server is waiting.\n\n" +
            "Created by: Johan Gloria, Melany Rivera, Jese Sanchez, Luis Mendoza, Leonel Campos"
        );
    }
}
