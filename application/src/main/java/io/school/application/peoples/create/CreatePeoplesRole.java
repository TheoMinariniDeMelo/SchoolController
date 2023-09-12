package io.school.application.peoples.create;

import io.school.address.Address;
import io.school.role.Role;
import io.school.transport.Transport;

import java.util.UUID;

public record CreatePeoplesRole(

        String name,
        Transport transport,
        String telephone,
        Address address,
        Role role
) {
    public static CreatePeoplesRole with(
            String name,
            Transport transport,
            String telephone,
            Address address,
            Role role
    ) {
        return new CreatePeoplesRole( name, transport, telephone, address, role);
    }
}
