/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package h10;

/**
 *
 * @author mehta
 */

    public class Person implements Comparable<Person> {

    private String firstname;
    private String lastname;
    private String bday;
    private String phone;

    public Person() {
        firstname = "";
        lastname = "";
        bday = "";
        phone = "";
    }

    public Person(String w, String x, String y, String z) {
        firstname = w;
        lastname = x;
        bday = y;
        phone = z;
    }

    /**
     * @return the name
     */
    /**
     * @return the bday
     */
    public String getBday() {
        return bday;
    }

    /**
     * @param bday the bday to set
     */
    public void setBday(String bday) {
        this.bday = bday;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the first name
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the first name to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the last name
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the last name to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public int compareTo(Person x) {
        if (this.lastname.compareToIgnoreCase(x.lastname) > 0) {
            return 1;
        }
        if (this.lastname.compareToIgnoreCase(x.lastname) < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    public void writeOutput() {

        System.out.println(firstname + " " + lastname);
        System.out.println(bday);
        System.out.println(phone);
    }

    @Override
    public String toString() {
        return firstname + " " + lastname + "\n" + bday + "\n" + phone + "\n";
    }

}


