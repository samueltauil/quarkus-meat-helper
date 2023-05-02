package com.redhat;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;

@ApplicationScoped
@OpenAPIDefinition(
    info = @Info(
        title = "Meat Temperature API",
        version = "1.0.0",
        description = "An API that provides recommended cooking temperatures for various types of meat"
    )
)
@Path("/meat")
public class MeatHelper {

    @GET
    @Path("/{meat}/{doneness}")
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "Get recommended temperature for cooking meat", description = "Returns the recommended temperature in degrees Fahrenheit for cooking a particular type of meat to a specified level of doneness.")
    public String getTemperature(
        @Parameter(description = "The type of meat to cook (e.g. 'beef', 'chicken', 'pork')") @PathParam("meat") String meat,
        @Parameter(description = "The desired level of doneness (e.g. 'rare', 'medium', 'well-done')") @PathParam("doneness") String doneness) {

        int temperature = 0;

        switch (meat.toLowerCase()) {
            case "beef":
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
                        return "Unknown doneness for beef: " + doneness;
                }
                break;
            case "chicken":
                switch (doneness.toLowerCase()) {
                    case "breasts":
                        temperature = 165;
                        break;
                    case "thighs":
                        temperature = 170;
                        break;
                    default:
                        return "Unknown doneness for chicken: " + doneness;
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
