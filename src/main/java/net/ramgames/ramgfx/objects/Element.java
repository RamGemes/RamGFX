package net.ramgames.ramgfx.objects;

import net.ramgames.ramgfx.utilities.Position;

import java.util.UUID;

public class Element {
    private final UUID uuid = UUID.randomUUID();

    public Position position;

    public Element(Position position) {
        this.position = position;
    }

    public UUID getUuid() {
        return uuid;
    }
}
