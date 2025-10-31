package com.spookathon.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Puzzle configuration loaded from JSON.
 * Represents a single puzzle/challenge in the escape room.
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
public class Puzzle {
    private Integer id;
    private String level;
    private Integer order;
    private String name;
    private String endpoint;
    private String method;
    
    // For GET endpoints
    private String message;
    private String hint;
    private String status;
    
    // For POST endpoints
    private String correctAnswer;
    private List<String> alternativeAnswers;
    private String successMessage;
    private String successStatus;
    private String failureMessage;
    private String failureStatus;
}
