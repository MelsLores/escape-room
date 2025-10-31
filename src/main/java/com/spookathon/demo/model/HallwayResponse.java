package com.spookathon.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Response DTO for GET /hallway endpoint.
 * Contains the corridor description, hint for the final puzzle, and progress status.
 * 
 * @author Johan Gloria
 * @author Melany Rivera
 * @author Jese Sanchez
 * @author Luis Mendoza
 * @author Leonel Campos
 * @version 1.0
 * @since 2025-10-31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HallwayResponse {
    private String message;
    private String hint;
    private String status;
}
