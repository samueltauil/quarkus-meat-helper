package com.redhat;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;

@ApplicationScoped
@OpenAPIDefinition(
    info = @Info(
        title = "Meat Temperature API",
        version = "1.0.0",
        description = "An API that provides recommended cooking temperatures for various types of meat!!"
    )
)
@Path("/meat")
public class MeatHelper {
    
    /**
     * Get the recommended cooking temperature for a given type of meat and doneness level.
     *
     * @param meat    The type of meat (e.g., "beef", "chicken", "pork").
     * @param doneness The desired level of doneness (e.g., "rare", "medium", "well-done").
     * @return A string message with the recommended temperature in degrees Fahrenheit.
     */
    @GET
    @Path("/{meat}/{doneness}/{cut}")
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "Get recommended temperature for cooking meat", description = "Returns the recommended temperature in degrees Fahrenheit for cooking a particular type of meat to a specified level of doneness.")
    public String getTemperature(
        @Parameter(description = "The type of meat to cook (e.g. 'beef', 'chicken', 'pork')") @PathParam("meat") String meat,
        @Parameter(description = "The desired level of doneness (e.g. 'rare', 'medium', 'well-done')") @PathParam("doneness") String doneness,
        @Parameter(description = "The cut of meat (e.g. 'thighs', 'breast')") @PathParam("cut") String cut) {

        int temperature = 0;

        switch (meat.toLowerCase()) {
            case "beef":
                switch (doneness.toLowerCase()) {
                    case "rare":
                        temperature = 135;
                        break;
                    case "medium-rare":
                        temperature = 140;
                        break;
                    case "medium":
                        temperature = 155;
                        break;
                    case "medium-well":
                        temperature = 165;
                        break;
                    case "well-done":
                        temperature = 170;
                        break;
                    default:
                        return "Unknown doneness for beef: " + doneness;
                }
                break;
            case "chicken":
                // If a cut is specified, provide specific recommendations
                if (cut != null && !cut.isEmpty()) {
                    switch (cut.toLowerCase()) {
                        case "thighs":
                            temperature = 175; // USDA recommends 175°F for chicken thighs
                            break;
                        case "breast":
                            temperature = 165;
                            break;
                        default:
                            return "Unknown cut for chicken: " + cut;
                    }
                } else {
                    switch (doneness.toLowerCase()) {
                        case "medium":
                            temperature = 165;
                            break;
                        case "well-done":
                            temperature = 170;
                            break;
                        default:
                            return "Unknown doneness for chicken: " + doneness;
                    }
                }
                break;
            case "pork":
                switch (doneness.toLowerCase()) {
                    case "medium":
                        temperature = 145;
                        break;
                    case "medium-well":
                        temperature = 150;
                        break;
                    case "well-done":
                        temperature = 160;
                        break;
                    default:
                        return "Unknown doneness for pork: " + doneness;
                }
                break;
            case "lamb":
                switch (doneness.toLowerCase()) {
                    case "rare":
                        temperature = 135;
                        break;
                    case "medium-rare":
                        temperature = 145;
                        break;
                    case "medium":
                        temperature = 160;
                        break;
                    case "medium-well":
                        temperature = 165;
                        break;
                    case "well-done":
                        temperature = 170;
                        break;
                    default:
                        return "Unknown doneness for lamb: " + doneness;
                }
                break;
            case "duck":
                switch (doneness.toLowerCase()) {
                    case "rare":
                        temperature = 130;
                        break;
                    case "medium-rare":
                        temperature = 140;
                        break;
                    case "medium":
                        temperature = 155;
                        break;
                    case "medium-well":
                        temperature = 165;
                        break;
                    case "well-done":
                        temperature = 170;
                        break;
                    default:
                        return "Unknown doneness for duck: " + doneness;
                }
                break;
            default:
                return "Unknown meat: " + meat;
        }

        return String.format("Recommended temperature for %s %s: %d°F", meat, doneness, temperature);
    }
}
