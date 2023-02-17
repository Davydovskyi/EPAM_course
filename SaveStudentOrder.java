package edu.jcourse.student_order;

import edu.jcourse.student_order.domain.*;
import edu.jcourse.student_order.domain.document.BirthCertificate;
import edu.jcourse.student_order.domain.document.MarriageCertificate;
import edu.jcourse.student_order.domain.document.Passport;
import edu.jcourse.student_order.exception.DAOException;

import java.time.LocalDate;

public class SaveStudentOrder {
    public static void main(String[] args) throws DAOException {
        System.out.println("ывало");
//        DictionaryDAO dictionaryDAO = new DictionaryDAOImpl();
//        List<Street> streets = dictionaryDAO.findStreets("Сад");
//        streets.forEach(System.out::println);
//
//        List<PassportOffice> passportOffices = dictionaryDAO.findPassportOffices("010020000000");
//        passportOffices.forEach(System.out::println);
//
//        List<RegisterOffice> registerOffices = dictionaryDAO.findRegisterOffices("010010000000");
//        registerOffices.forEach(System.out::println);

//        StudentOrder studentOrder1 = new StudentOrder();
//        saveStudentOrder(studentOrder1);
    }

    public static long saveStudentOrder(StudentOrder studentOrder) {
        long answer = 199;
        System.out.println("Save Student Order: ");
        return answer;
    }

    public static StudentOrder buildStudentOrder(long id) {
        StudentOrder studentOrder = new StudentOrder();
        studentOrder.setStudentOrderId(id);

        MarriageCertificate marriageCertificate = new MarriageCertificate("" + (9000 + id), new RegisterOffice(), LocalDate.of(2014, 12, 3));
        studentOrder.setMarriageCertificate(marriageCertificate);

        Street mainStreet = new Street(2L, "First Street");
        Address address = new Address("2356" + id, mainStreet, "12", "", "34");

        Adult husband = new Adult("Mike", "Scott", "Dvi", LocalDate.of(1980, 11, 23));
        husband.setUniversity("BMI");
        husband.setStudentId("" + (10000 + id));
        husband.setAddress(address);
        Passport husbandPassport = new Passport("" + (400 + id), "" + (60000 + id), LocalDate.of(2000, 4, 11),
                new PassportOffice());
        husband.setPassport(husbandPassport);

        Adult wife = new Adult("Jan", "Lewis", "Marry", LocalDate.of(1983, 2, 12));
        wife.setUniversity("BMI");
        wife.setStudentId("" + (20000 + id));
        wife.setAddress(address);
        Passport wifePassport = new Passport("" + (500 + id), "" + (70000 + id), LocalDate.of(2004, 4, 1),
                new PassportOffice());
        wife.setPassport(wifePassport);

        Child child = new Child("Mike", "Garry", "Scott", LocalDate.of(2018, 3, 23));
        BirthCertificate birthCertificate = new BirthCertificate("" + (30000 + id), new RegisterOffice(), LocalDate.of(2018, 3, 23));
        child.setBirthCertificate(birthCertificate);
        child.setAddress(address);

        studentOrder.setHusband(husband);
        studentOrder.setWife(wife);
        studentOrder.addChild(child);
        return studentOrder;
    }
}
