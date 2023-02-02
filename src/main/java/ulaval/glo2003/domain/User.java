package ulaval.glo2003.domain;

import java.util.UUID;

public class User {
    private final String id;
    private final String name;

    public User(String name) {
        if (name.length() < 2) {
            throw new IllegalArgumentException("User name should be at least 2 characters long.");
        }

        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
