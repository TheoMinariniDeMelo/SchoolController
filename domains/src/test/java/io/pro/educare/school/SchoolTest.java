package io.pro.educare.school;

import io.pro.educare.address.Address;
import io.pro.educare.address.Country;
import io.pro.educare.TimeZone;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashSet;
import java.util.List;

@Tag("school_test")
public class SchoolTest {
    @Test
    public void givenParametersOfASchoolWithCNPJ_mustBeInstantiated() {
        var name = "School";
        var address = new Address(
                "Road",
                "NeighBorHood",
                0,
                "Reference",
                Country.BRA
        );
        var numberOfCountrySerial = "XX.XXX.XXX/0001-XX";
        var email = new LinkedHashSet<>(List.of("exemple@gmail.com"));
        var password = "Example_1234567";
        var telephone = new LinkedHashSet<>(List.of("32999999999"));
        var timeZone = TimeZone.BR;
        var isActivate = true;
        var aSchool = School.newSchool(
                address,
                password,
                telephone,
                numberOfCountrySerial,
                name,
                email,
                timeZone,
                isActivate
        );
        assertEquals(name, aSchool.getName());
        assertEquals(address, aSchool.getAddress());
        assertEquals(numberOfCountrySerial, aSchool.getNumberOfCountrySerial());
        assertEquals(telephone, aSchool.telephone);
        assertEquals(email, aSchool.getEmail());
        assertEquals(password, aSchool.getPassword());
        assertNotNull(aSchool.getCreatedAt());
        assertNotNull(aSchool.getUpdatedAt());
        assertNull(aSchool.getDeletedAt());
        assertTrue(aSchool.getIsActivate());
    }
}
