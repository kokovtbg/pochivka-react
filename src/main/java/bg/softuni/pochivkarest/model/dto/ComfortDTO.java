package bg.softuni.pochivkarest.model.dto;

import bg.softuni.pochivkarest.model.enums.ComfortEnum;

public class ComfortDTO {
    private ComfortEnum name;

    public ComfortEnum getName() {
        return name;
    }

    public void setName(ComfortEnum name) {
        this.name = name;
    }
}
