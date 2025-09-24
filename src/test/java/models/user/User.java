package models.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.datafaker.Faker;

import java.util.List;

public record User(
        @JsonProperty("firstname") String firstname,
        @JsonProperty("lastname") String lastname,
        @JsonProperty("age") int age,
        @JsonProperty("gender") String gender,
        @JsonProperty("email") String email,
        @JsonProperty("phone") String phone,
        @JsonProperty("role") String role,
        @JsonProperty("address") Address address,
        @JsonProperty("company") Company company
) {
    public static User generateRandomUser() {
        final var faker = new Faker();

        final var firstname = faker.name().firstName();
        final var lastname = faker.name().lastName();
        final var age = faker.number().numberBetween(20, 80);
        final var gender = List.of("male", "female").get(faker.number().numberBetween(0, 1));
        final var email = faker.internet().emailAddress();
        final var phone = faker.phoneNumber().phoneNumber();
        final var role = faker.job().position();
        final var address = Address.generateRandomAddress();
        final var company = Company.generateRandomCompany();

        return new User(firstname, lastname, age, gender, email, phone, role, address, company);
    }
}
