package com.spookathon.demo.controller;

import com.spookathon.demo.model.*;
import com.spookathon.demo.service.PuzzleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The Phantom Code: Escape from the Haunted Server
 * 
 * REST Controller for the Ghost Server escape room game.
 * Players must decipher cryptic messages across three difficulty levels to free a digital soul.
 * 
 * This controller now uses PuzzleService to load configurations from puzzles.json,
 * making it easy to modify game content without changing code.
 * 
 * Game Structure:
 * - Easy Level: 3 puzzles (room, door, hallway)
 * - Medium Level: 3 puzzles (binary, memory, process)
 * - Hard Level: 3 puzzles (crypto, root, escape)
 * 
 * @author Johan Gloria
 * @author Melany Rivera
 * @author Jese Sanchez
 * @author Luis Mendoza
 * @author Leonel Campos
 * @version 3.0
 * @since 2025-10-31
 */
@RestController
@RequestMapping("/")
@Tag(name = "👻 Ghost Server Escape Room", description = "Interactive puzzle-solving REST API with 9 progressive challenges across 3 difficulty levels")
public class EscapeRoomController {

    @Autowired
    private PuzzleService puzzleService;

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
        Puzzle puzzle = puzzleService.getPuzzleByEndpoint("/room")
                .orElseThrow(() -> new RuntimeException("Puzzle not found"));
        
        RoomResponse response = new RoomResponse(
            puzzle.getMessage(),
            puzzle.getHint(),
            puzzle.getStatus()
        );
        return ResponseEntity.ok(response);
    }

    /**
     * POST /door - Easy Level: Puzzle 2/3
     * 
     * The player must send the correct key to unlock the first door.
     * The correct answer is loaded from puzzles.json.
     * 
     * @param request DoorRequest containing the key attempt
     * @return ResponseEntity with success or failure message
     */
    @Operation(
        summary = "📗 EASY 2/3: Unlock the Door",
        description = "Submit the key you discovered in the Electric Room to unlock the first door."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Door status updated"),
        @ApiResponse(responseCode = "400", description = "Invalid request - key is required")
    })
    @PostMapping("/door")
    public ResponseEntity<DoorResponse> openDoor(
        @Parameter(description = "Door unlock request with key", required = true)
        @RequestBody DoorRequest request) {
        
        Puzzle puzzle = puzzleService.getPuzzleByEndpoint("/door")
                .orElseThrow(() -> new RuntimeException("Puzzle not found"));
        
        String key = request.getKey();
        
        if (key == null) {
            return ResponseEntity.badRequest().body(
                new DoorResponse(
                    "You must provide a key.",
                    puzzle.getFailureStatus()
                )
            );
        }
        
        // Use the service to validate the answer
        if (puzzleService.isAnswerCorrect(puzzle, key)) {
            return ResponseEntity.ok(
                new DoorResponse(
                    puzzle.getSuccessMessage(),
                    puzzle.getSuccessStatus()
                )
            );
        } else {
            return ResponseEntity.ok(
                new DoorResponse(
                    puzzle.getFailureMessage(),
                    puzzle.getFailureStatus()
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
    @Operation(
        summary = "📗 EASY 3/3: The Code Corridor",
        description = "Enter the infinite corridor of code to continue your journey."
    )
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Hallway description returned successfully")})
    @GetMapping("/hallway")
    public ResponseEntity<HallwayResponse> getHallway() {
        Puzzle puzzle = puzzleService.getPuzzleByEndpoint("/hallway")
                .orElseThrow(() -> new RuntimeException("Puzzle not found"));
        
        HallwayResponse response = new HallwayResponse(
            puzzle.getMessage(),
            puzzle.getHint(),
            puzzle.getStatus()
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
    @Operation(
        summary = "📘 MEDIUM 1/3: Binary Challenge",
        description = "First medium-level challenge: Binary to Decimal conversion."
    )
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Binary puzzle response")})
    @PostMapping("/binary-puzzle")
    public ResponseEntity<DoorResponse> solveBinaryPuzzle(@RequestBody DoorRequest request) {
        Puzzle puzzle = puzzleService.getPuzzleByEndpoint("/binary-puzzle")
                .orElseThrow(() -> new RuntimeException("Puzzle not found"));
        
        String key = request.getKey();
        
        if (key == null) {
            return ResponseEntity.badRequest().body(
                new DoorResponse(
                    "You must provide an answer.",
                    puzzle.getFailureStatus()
                )
            );
        }
        
        if (puzzleService.isAnswerCorrect(puzzle, key)) {
            return ResponseEntity.ok(
                new DoorResponse(
                    puzzle.getSuccessMessage(),
                    puzzle.getSuccessStatus()
                )
            );
        } else {
            return ResponseEntity.ok(
                new DoorResponse(
                    puzzle.getFailureMessage(),
                    puzzle.getFailureStatus()
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
    @Operation(
        summary = "📘 MEDIUM 2/3: Memory Chamber",
        description = "Second medium challenge introduction. Explore memory hierarchy."
    )
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Memory chamber description returned successfully")})
    @GetMapping("/memory-chamber")
    public ResponseEntity<RoomResponse> getMemoryChamber() {
        Puzzle puzzle = puzzleService.getPuzzleByEndpoint("/memory-chamber")
                .orElseThrow(() -> new RuntimeException("Puzzle not found"));
        
        RoomResponse response = new RoomResponse(
            puzzle.getMessage(),
            puzzle.getHint(),
            puzzle.getStatus()
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
    @Operation(
        summary = "📘 MEDIUM 3/3: Memory Puzzle",
        description = "Second medium-level challenge: Memory hierarchy knowledge."
    )
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Memory puzzle response")})
    @PostMapping("/memory-puzzle")
    public ResponseEntity<DoorResponse> solveMemoryPuzzle(@RequestBody DoorRequest request) {
        Puzzle puzzle = puzzleService.getPuzzleByEndpoint("/memory-puzzle")
                .orElseThrow(() -> new RuntimeException("Puzzle not found"));
        
        String key = request.getKey();
        
        if (key == null) {
            return ResponseEntity.badRequest().body(
                new DoorResponse(
                    "You must provide an answer.",
                    puzzle.getFailureStatus()
                )
            );
        }
        
        if (puzzleService.isAnswerCorrect(puzzle, key)) {
            return ResponseEntity.ok(
                new DoorResponse(
                    puzzle.getSuccessMessage(),
                    puzzle.getSuccessStatus()
                )
            );
        } else {
            return ResponseEntity.ok(
                new DoorResponse(
                    puzzle.getFailureMessage(),
                    puzzle.getFailureStatus()
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
    @Operation(
        summary = "📘 MEDIUM 4/3: Process Hall",
        description = "Third medium challenge introduction. Learn about operating systems."
    )
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Process hall description returned successfully")})
    @GetMapping("/process-hall")
    public ResponseEntity<RoomResponse> getProcessHall() {
        Puzzle puzzle = puzzleService.getPuzzleByEndpoint("/process-hall")
                .orElseThrow(() -> new RuntimeException("Puzzle not found"));
        
        RoomResponse response = new RoomResponse(
            puzzle.getMessage(),
            puzzle.getHint(),
            puzzle.getStatus()
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
    @Operation(
        summary = "📘 MEDIUM 5/3: Process Puzzle",
        description = "Third medium-level challenge: Operating system knowledge."
    )
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Process puzzle response")})
    @PostMapping("/process-puzzle")
    public ResponseEntity<DoorResponse> solveProcessPuzzle(@RequestBody DoorRequest request) {
        Puzzle puzzle = puzzleService.getPuzzleByEndpoint("/process-puzzle")
                .orElseThrow(() -> new RuntimeException("Puzzle not found"));
        
        String key = request.getKey();
        
        if (key == null) {
            return ResponseEntity.badRequest().body(
                new DoorResponse(
                    "You must provide an answer.",
                    puzzle.getFailureStatus()
                )
            );
        }
        
        if (puzzleService.isAnswerCorrect(puzzle, key)) {
            return ResponseEntity.ok(
                new DoorResponse(
                    puzzle.getSuccessMessage(),
                    puzzle.getSuccessStatus()
                )
            );
        } else {
            return ResponseEntity.ok(
                new DoorResponse(
                    puzzle.getFailureMessage(),
                    puzzle.getFailureStatus()
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
    @Operation(
        summary = "📕 HARD 1/3: Cryptic Terminal",
        description = "First hard challenge introduction. Cryptography knowledge required."
    )
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Cryptic terminal description returned successfully")})
    @GetMapping("/cryptic-terminal")
    public ResponseEntity<RoomResponse> getCrypticTerminal() {
        Puzzle puzzle = puzzleService.getPuzzleByEndpoint("/cryptic-terminal")
                .orElseThrow(() -> new RuntimeException("Puzzle not found"));
        
        RoomResponse response = new RoomResponse(
            puzzle.getMessage(),
            puzzle.getHint(),
            puzzle.getStatus()
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
    @Operation(
        summary = "📕 HARD 2/3: Crypto Puzzle",
        description = "First hard-level challenge: Base64 decoding."
    )
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Crypto puzzle response")})
    @PostMapping("/crypto-puzzle")
    public ResponseEntity<DoorResponse> solveCryptoPuzzle(@RequestBody DoorRequest request) {
        Puzzle puzzle = puzzleService.getPuzzleByEndpoint("/crypto-puzzle")
                .orElseThrow(() -> new RuntimeException("Puzzle not found"));
        
        String key = request.getKey();
        
        if (key == null) {
            return ResponseEntity.badRequest().body(
                new DoorResponse(
                    "You must provide an answer.",
                    puzzle.getFailureStatus()
                )
            );
        }
        
        if (puzzleService.isAnswerCorrect(puzzle, key)) {
            return ResponseEntity.ok(
                new DoorResponse(
                    puzzle.getSuccessMessage(),
                    puzzle.getSuccessStatus()
                )
            );
        } else {
            return ResponseEntity.ok(
                new DoorResponse(
                    puzzle.getFailureMessage(),
                    puzzle.getFailureStatus()
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
    @Operation(
        summary = "📕 HARD 3/3: Root Access",
        description = "Second hard challenge introduction. UNIX/Linux superuser knowledge required."
    )
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Root access description returned successfully")})
    @GetMapping("/root-access")
    public ResponseEntity<RoomResponse> getRootAccess() {
        Puzzle puzzle = puzzleService.getPuzzleByEndpoint("/root-access")
                .orElseThrow(() -> new RuntimeException("Puzzle not found"));
        
        RoomResponse response = new RoomResponse(
            puzzle.getMessage(),
            puzzle.getHint(),
            puzzle.getStatus()
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
    @Operation(
        summary = "📕 HARD 4/3: Root Puzzle",
        description = "Second hard-level challenge: UNIX/Linux superuser knowledge."
    )
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Root puzzle response")})
    @PostMapping("/root-puzzle")
    public ResponseEntity<DoorResponse> solveRootPuzzle(@RequestBody DoorRequest request) {
        Puzzle puzzle = puzzleService.getPuzzleByEndpoint("/root-puzzle")
                .orElseThrow(() -> new RuntimeException("Puzzle not found"));
        
        String key = request.getKey();
        
        if (key == null) {
            return ResponseEntity.badRequest().body(
                new DoorResponse(
                    "Access denied. Provide credentials.",
                    puzzle.getFailureStatus()
                )
            );
        }
        
        if (puzzleService.isAnswerCorrect(puzzle, key)) {
            return ResponseEntity.ok(
                new DoorResponse(
                    puzzle.getSuccessMessage(),
                    puzzle.getSuccessStatus()
                )
            );
        } else {
            return ResponseEntity.ok(
                new DoorResponse(
                    puzzle.getFailureMessage(),
                    puzzle.getFailureStatus()
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
    @Operation(
        summary = "📕 HARD 5/3: Final Chamber",
        description = "The ultimate challenge before freedom. Secure web protocol knowledge required."
    )
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Final chamber description returned successfully")})
    @GetMapping("/final-chamber")
    public ResponseEntity<RoomResponse> getFinalChamber() {
        Puzzle puzzle = puzzleService.getPuzzleByEndpoint("/final-chamber")
                .orElseThrow(() -> new RuntimeException("Puzzle not found"));
        
        RoomResponse response = new RoomResponse(
            puzzle.getMessage(),
            puzzle.getHint(),
            puzzle.getStatus()
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
    @Operation(
        summary = "📕 HARD 6/3: FINAL ESCAPE",
        description = "The ultimate challenge. Free the digital soul and escape the Ghost Server!"
    )
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Escape attempt response")})
    @PostMapping("/escape")
    public ResponseEntity<EscapeResponse> escape(@RequestBody EscapeRequest request) {
        Puzzle puzzle = puzzleService.getPuzzleByEndpoint("/escape")
                .orElseThrow(() -> new RuntimeException("Puzzle not found"));
        
        String finalKey = request.getFinal_key();
        
        if (finalKey == null) {
            return ResponseEntity.badRequest().body(
                new EscapeResponse(
                    "You must provide the final key to escape.",
                    puzzle.getFailureStatus()
                )
            );
        }
        
        if (puzzleService.isAnswerCorrect(puzzle, finalKey)) {
            return ResponseEntity.ok(
                new EscapeResponse(
                    puzzle.getSuccessMessage(),
                    puzzle.getSuccessStatus()
                )
            );
        } else {
            return ResponseEntity.ok(
                new EscapeResponse(
                    puzzle.getFailureMessage(),
                    puzzle.getFailureStatus()
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
