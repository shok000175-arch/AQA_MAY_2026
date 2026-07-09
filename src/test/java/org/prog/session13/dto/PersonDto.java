package org.prog.session13.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class PersonDto {
    public String gender;
    public String nat;
    public NameDto name;
}
