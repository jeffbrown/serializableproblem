package demo

import spock.lang.Specification

class PersonSpec extends Specification {

    void "test serialization"() {
        given:
        def p = new Person(firstName: 'Jeff', lastName: 'Brown')

        def bos = new ByteArrayOutputStream()
        def oos = new ObjectOutputStream(bos)

        when:
        oos.writeObject(p)
        oos.flush()

        def bis = new ByteArrayInputStream(bos.toByteArray())
        def ois = new ObjectInputStream(bis)
        def p2 = ois.readObject()

        then:
        p2 instanceof Person
        p2.firstName == 'Jeff'
        p2.lastName == 'Brown'
    }
}
