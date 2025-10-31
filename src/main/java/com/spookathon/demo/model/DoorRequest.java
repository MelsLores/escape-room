package com.spookathon.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Request DTO for POST /door endpoint.
 * Contains the key attempt to unlock the first door.
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
public class DoorRequest {
    private String key;
}
