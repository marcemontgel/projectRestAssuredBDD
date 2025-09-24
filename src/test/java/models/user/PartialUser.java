package models.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.datafaker.Faker;

public record PartialUser(
        @JsonProperty("firstname") String firstname,
        @JsonProperty("lastname") String lastname,
        @JsonProperty("age") int age
) {
    public static PartialUser generateRandomPartialUser() {
        final var faker = new Faker();

        final var firstname = faker.name().firstName();
        final var lastname = faker.name().lastName();
        final var age = faker.number().numberBetween(10, 80);

        return new PartialUser(firstname, lastname, age);
    }
}
