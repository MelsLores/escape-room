package com.spookathon.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * Root configuration for all puzzles loaded from puzzles.json.
 * 
 * @author Johan Gloria
 * @author Melany Rivera
 * @author Jese Sanchez
 * @author Luis Mendoza
 * @author Leonel Campos
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PuzzleConfig {
    private Map<String, Object> gameInfo;
    private List<Puzzle> puzzles;
}
