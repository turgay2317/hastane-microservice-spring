package com.turgayceylan.PatientMicroservice.specifications;

import com.turgayceylan.PatientMicroservice.model.Patient;
import org.springframework.data.jpa.domain.Specification;

public class PatientSpecifications {
    public static Specification<Patient> hasFirstName(String firstName) {
        return (root, query, criteriaBuilder) ->
                firstName == null ? null : criteriaBuilder.like(criteriaBuilder.lower(root.get("patientName")), "%" + firstName.toLowerCase() + "%");
    }

    public static Specification<Patient> hasLastName(String lastName) {
        return (root, query, criteriaBuilder) ->
                lastName == null ? null : criteriaBuilder.like(criteriaBuilder.lower(root.get("patientSurname")), "%" + lastName.toLowerCase() + "%");
    }

    public static Specification<Patient> hasTC(String tc) {
        return (root, query, criteriaBuilder) ->
                tc == null ? null : criteriaBuilder.like(criteriaBuilder.lower(root.get("patientTC")), "%" + tc + "%");
    }
}
