package com.cvent.locationservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value.Immutable;
import javax.validation.constraints.Size;
import javax.validation.Valid;

/**
 * An immutable entity
 */
@Immutable
@JsonSerialize
@JsonDeserialize(as = ImmutableEntity.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public interface Entity {

    int MIN_LEN_ANOTHER_FIELD = 2;
    int MAX_LEN_ANOTHER_FIELD = 10;

    /**
     * @return The field
     */
    String getField();

    /**
     * @return another field
     */
    @Size(min = MIN_LEN_ANOTHER_FIELD, max = MAX_LEN_ANOTHER_FIELD)
    String getAnotherField();

    /**
     * @return a complex entity
     */
    @Valid
    ComplexEntity getComplexEntity();
}
