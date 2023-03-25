package bg.softuni.pochivkarest.model.dto;

import bg.softuni.pochivkarest.model.enums.TownEnum;

public class TownDTO {
    private TownEnum name;

    public TownEnum getName() {
        return name;
    }

    public void setName(TownEnum name) {
        this.name = name;
    }
}
