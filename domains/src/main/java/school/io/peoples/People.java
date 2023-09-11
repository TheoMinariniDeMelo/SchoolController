package school.io.peoples;

import school.io.address.AddressID;
import school.io.transport.Transport;

import java.util.UUID;

public class People {
    protected UUID id;
    protected String name;
    protected Transport transport;
    protected String telephone;
    protected AddressID address;
    protected RoleID role;
}
