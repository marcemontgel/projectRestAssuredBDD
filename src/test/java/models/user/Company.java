package models.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.datafaker.Faker;

public record Company(
        @JsonProperty("department") String department,
        @JsonProperty("name") String name,
        @JsonProperty("title") String title
) {
    public static Company generateRandomCompany() {
        final var faker = new Faker();

        final var department = faker.company().industry();
        final var name = faker.company().name();
        final var title = faker.job().title();

        return new Company(department, name, title);
    }
}
