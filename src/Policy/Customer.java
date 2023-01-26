package Policy;

import java.io.Serializable;

public class Customer implements Serializable {
    String firstName, lastName, city;
    int customerPhone;
    Policy policy;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String city, int customerPhone, Policy policy) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.customerPhone = customerPhone;
        this.policy = policy;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }

    public int getCustomerPhone() {
        return customerPhone;
    }

    public Policy getPolicy() {
        return policy;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", customerPhone=" + customerPhone +
                ", policy=" + policy +
                '}';
    }
}
