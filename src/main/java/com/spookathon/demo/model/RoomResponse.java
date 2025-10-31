package com.spookathon.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Response DTO for GET /room endpoint.
 * Contains the initial room description, hint, and room status.
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
public class RoomResponse {
    private String message;
    private String hint;
    private String status;
}
