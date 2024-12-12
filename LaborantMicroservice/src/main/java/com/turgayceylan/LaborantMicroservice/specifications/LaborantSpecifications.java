package com.turgayceylan.LaborantMicroservice.specifications;

import com.turgayceylan.LaborantMicroservice.model.Laborant;
import org.springframework.data.jpa.domain.Specification;

public class LaborantSpecifications {
    public static Specification<Laborant> hasFirstName(String firstName) {
        return (root, query, criteriaBuilder) ->
                firstName == null ? null : criteriaBuilder.like(criteriaBuilder.lower(root.get("laborantName")), "%" + firstName.toLowerCase() + "%");
    }

    public static Specification<Laborant> hasLastName(String lastName) {
        return (root, query, criteriaBuilder) ->
                lastName == null ? null : criteriaBuilder.like(criteriaBuilder.lower(root.get("laborantSurname")), "%" + lastName.toLowerCase() + "%");
    }
}
