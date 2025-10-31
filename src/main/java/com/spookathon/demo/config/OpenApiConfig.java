package com.spookathon.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * OpenAPI/Swagger configuration for The Phantom Code: Ghost Server Escape Room API.
 * 
 * This configuration provides interactive API documentation accessible at:
 * - Swagger UI: http://localhost:8080/swagger-ui.html
 * - OpenAPI JSON: http://localhost:8080/v3/api-docs
 * 
 * @author Johan Gloria
 * @author Melany Rivera
 * @author Jese Sanchez
 * @author Luis Mendoza
 * @author Leonel Campos
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("👻 The Phantom Code: Ghost Server Escape Room API")
                        .version("1.0.0")
                        .description("""
                                # 🎮 Welcome to The Phantom Code: Ghost Server Escape Room!
                                
                                An interactive REST API escape room game with **9 progressive puzzles** across 3 difficulty levels.
                                
                                ## 🧩 Game Structure:
                                
                                ### 📗 Easy Level (3 Puzzles)
                                - 💻 **Puzzle 1**: The Electric Room - Logic puzzle
                                - 🔐 **Puzzle 2**: Unlock the Door - Code validation
                                - 🌐 **Puzzle 3**: The Code Corridor - Binary hint
                                
                                ### 📘 Medium Level (3 Puzzles)
                                - 🔢 **Puzzle 4**: Binary Challenge - Convert binary to decimal
                                - 🧠 **Puzzle 5**: Memory Hierarchy - Computer architecture
                                - ⚙️ **Puzzle 6**: The OS Core - Operating system knowledge
                                
                                ### 📕 Hard Level (3 Puzzles)
                                - 🔐 **Puzzle 7**: Cryptographic Decoding - Base64 decryption
                                - 👑 **Puzzle 8**: Root Access - System administration
                                - 🚪 **Puzzle 9**: Final Escape - Network protocols
                                
                                ## 🎯 How to Play:
                                1. Start with GET `/` to see the welcome message
                                2. Progress through each level in order
                                3. Use hints provided in GET endpoints
                                4. Submit answers via POST endpoints
                                5. Complete all 9 puzzles to escape!
                                
                                **Good luck, and may your code compile without errors! 👻**
                                """)
                        .contact(new Contact()
                                .name("Spookathon Team")
                                .email("spookathon@ghostserver.dev"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT")))
                .servers(List.of(
                        new Server()
                                .url("http://localhost:8080")
                                .description("Local Development Server")
                ));
    }
}
