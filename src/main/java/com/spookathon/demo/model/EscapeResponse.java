package com.spookathon.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Response DTO for POST /escape endpoint.
 * Contains the final escape result message and status (escaped/trapped/failed).
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
public class EscapeResponse {
    private String message;
    private String status;
}
