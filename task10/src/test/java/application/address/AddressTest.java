package application.address;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static application.dao.сlasses.utility.MockConstant.*;
import static application.dao.сlasses.utility.MockUtils.getAddress1;

class AddressTest {

    @Test
    void builder() {
        Address address1 = getAddress1();
        Address address2 = getAddress1();
        Assert.assertEquals("builder not equals", address1, address2);
    }

    @Test
    void getStreet() {
        Address address = getAddress1();
        Assert.assertEquals(address.getStreet(), STREET1);
    }

    @Test
    void getCity() {
        Address address = getAddress1();
        Assert.assertEquals(address.getCity(), CITY1);
    }

    @Test
    void setStreet() {
        Address address = getAddress1();
        address.setStreet("street");
        Assert.assertEquals(address.getStreet(), "street");
    }

    @Test
    void setCity() {
        Address address = getAddress1();
        address.setCity("city");
        Assert.assertEquals(address.getCity(), "city");
    }

    @Test
    void testToString() {
        Address address = getAddress1();
        Assert.assertEquals("to string not equals",
                address.toString(),
                "Address(street=new street, city=new city)");
    }
}