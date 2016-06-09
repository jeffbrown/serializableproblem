package demo

import grails.validation.Validateable

class Person implements Serializable, Validateable {
    String firstName
    String lastName
}
