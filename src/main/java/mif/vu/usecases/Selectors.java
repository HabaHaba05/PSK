package mif.vu.usecases;

import lombok.Getter;

import org.omnifaces.cdi.Param;
import javax.enterprise.inject.Model;

@Model
public class Selectors {

    @Getter
    @Param
    private Integer authorId;

    @Getter
    @Param
    private Integer libraryId;
}
