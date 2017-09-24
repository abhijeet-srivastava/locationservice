package com.cvent.locationservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value.Immutable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import org.immutables.value.Value.Parameter;

/**
 * A complex immutable entity
 */
@Immutable
@JsonSerialize
@JsonDeserialize(as = ImmutableComplexEntity.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public interface ComplexEntity {

    int MIN_COMPLEXITY = 2;
    int MAX_COMPLEXITY = 100;

    /**
     * @return The complexity
     */
    @Min(MIN_COMPLEXITY)
    @Max(MAX_COMPLEXITY)
    @Parameter
    int getComplex();
}
