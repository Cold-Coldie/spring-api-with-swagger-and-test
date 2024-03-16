package com.coldie.roommateswithswaggerandtest.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(info = @Info(
        contact = @Contact(
                name = "Erioluwa",
                email = "ogedengbeoluwasemilogo@gmail.com"
        ),
        description = "Open API documentation for roommate API",
        title = "Open API Specification - Roommate API",
        version = "1.0",
        license = @License(
                name = "Licence Name",
                url = "https://some-url.com"
        ),
        termsOfService = "Ternms of Service"
),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8080"
                )
        }
)

public class OpenApiConfig {
}
