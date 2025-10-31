package com.spookathon.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spookathon.demo.model.Puzzle;
import com.spookathon.demo.model.PuzzleConfig;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Service that loads and manages puzzle configurations from JSON file.
 * Provides methods to retrieve puzzles by endpoint or ID.
 * 
 * @author Johan Gloria
 * @author Melany Rivera
 * @author Jese Sanchez
 * @author Luis Mendoza
 * @author Leonel Campos
 */
@Service
public class PuzzleService {

    private PuzzleConfig puzzleConfig;
    private Map<String, Puzzle> puzzlesByEndpoint;
    private final ObjectMapper objectMapper;

    public PuzzleService() {
        this.objectMapper = new ObjectMapper();
        this.puzzlesByEndpoint = new HashMap<>();
    }

    /**
     * Loads puzzles from JSON file on application startup.
     */
    @PostConstruct
    public void loadPuzzles() {
        try {
            ClassPathResource resource = new ClassPathResource("puzzles.json");
            puzzleConfig = objectMapper.readValue(resource.getInputStream(), PuzzleConfig.class);
            
            // Index puzzles by endpoint for quick lookup
            for (Puzzle puzzle : puzzleConfig.getPuzzles()) {
                puzzlesByEndpoint.put(puzzle.getEndpoint(), puzzle);
            }
            
            System.out.println("✅ Loaded " + puzzleConfig.getPuzzles().size() + " puzzles from JSON");
        } catch (IOException e) {
            System.err.println("❌ Error loading puzzles.json: " + e.getMessage());
            throw new RuntimeException("Failed to load puzzle configuration", e);
        }
    }

    /**
     * Get a puzzle by its endpoint path.
     * 
     * @param endpoint The endpoint path (e.g., "/room", "/door")
     * @return Optional containing the puzzle if found
     */
    public Optional<Puzzle> getPuzzleByEndpoint(String endpoint) {
        return Optional.ofNullable(puzzlesByEndpoint.get(endpoint));
    }

    /**
     * Get a puzzle by its ID.
     * 
     * @param id The puzzle ID
     * @return Optional containing the puzzle if found
     */
    public Optional<Puzzle> getPuzzleById(Integer id) {
        return puzzleConfig.getPuzzles().stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    /**
     * Get all puzzles.
     * 
     * @return List of all puzzles
     */
    public List<Puzzle> getAllPuzzles() {
        return puzzleConfig.getPuzzles();
    }

    /**
     * Get puzzles by difficulty level.
     * 
     * @param level The difficulty level (EASY, MEDIUM, HARD)
     * @return List of puzzles for that level
     */
    public List<Puzzle> getPuzzlesByLevel(String level) {
        return puzzleConfig.getPuzzles().stream()
                .filter(p -> p.getLevel().equalsIgnoreCase(level))
                .toList();
    }

    /**
     * Validate if an answer is correct for a given puzzle.
     * Checks both the main correct answer and alternative answers.
     * Case-insensitive comparison with trimmed whitespace.
     * 
     * @param puzzle The puzzle to validate against
     * @param userAnswer The user's submitted answer
     * @return true if the answer is correct
     */
    public boolean isAnswerCorrect(Puzzle puzzle, String userAnswer) {
        if (userAnswer == null || puzzle.getCorrectAnswer() == null) {
            return false;
        }

        String normalizedAnswer = userAnswer.trim().toLowerCase();
        String normalizedCorrect = puzzle.getCorrectAnswer().trim().toLowerCase();

        // Check main answer
        if (normalizedAnswer.equals(normalizedCorrect)) {
            return true;
        }

        // Check alternative answers
        if (puzzle.getAlternativeAnswers() != null) {
            return puzzle.getAlternativeAnswers().stream()
                    .anyMatch(alt -> normalizedAnswer.equals(alt.trim().toLowerCase()));
        }

        return false;
    }

    /**
     * Get game information from configuration.
     * 
     * @return Map containing game metadata
     */
    public Map<String, Object> getGameInfo() {
        return puzzleConfig.getGameInfo();
    }
}
