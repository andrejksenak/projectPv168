package testPackage;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cz.pv168.manager.PersonManager;
import cz.pv168.manager.impl.PersonManagerImpl;
import cz.pv168.model.Person;
import cz.pv168.utils.DatabaseException;

public class PersonManagerImplTest {

   PersonManager pm = new PersonManagerImpl();
   Person p1;
   Person p2;
   
   @BeforeClass
   public static void setUpBeforeClass() throws Exception {
   }

   @AfterClass
   public static void tearDownAfterClass() throws Exception {
   }

   @Before
   public void setUp() throws Exception {
      try {
         pm.createTablePerson();
      } catch (DatabaseException e) {
         System.err.print("TABLE PERSON EXISTS");
      }
    
      p1= new Person(); 
      p1.setName("JOHN");
      p1.setSurname("Alexandrejev");
      p1.setBirthDate(new Date());
      p1.setBirthNumber("849846");
      p1.setState("Russia");
      
      p2= new Person(); 
      p2.setName("JOHN");
      p2.setSurname("Alexandrejev");
      p2.setBirthDate(new Date());
      p2.setBirthNumber("849846");
      p2.setState("Russia");
  
   }

   @After
   public void tearDown() throws Exception {
      try {
         pm.droptablePerson();
      } catch (DatabaseException e) {
         e.printStackTrace();
      }
   }

   @Test
   public void testInputPerson() {     
      try {
         System.out.println("-------------------------------");
         System.out.println("TEST : testInputPerson");
         pm.createPerson(p1);
         
         assertEquals("Persons must be equals", pm.getPersonById(p1.getPersonId()),p1);
         
         pm.removePerson(p1);
         
         try{
         p2 = pm.getPersonById(p1.getPersonId());
         fail("Person should have been removed\n");
         }
         catch(DatabaseException e ){
            System.out.println("Catched non existing user");
         }
         
      } catch (DatabaseException e) {
         fail(e.toString());
      }
      System.out.println("-------------------------------");
      
      
   }
   
   @Test
   public void testInvalidInput(){
      System.out.println("-------------------------------");
      System.out.println("TEST : testInvalidInput");
      p2.setName("");
      try {
         pm.createPerson(p2);
         fail("Ivalid name");
      } catch (DatabaseException e) {
         System.out.println("Catched Invalid Name");
      }
      p2.setName("Tomas");
      
      p2.setSurname("");
      try {
         pm.createPerson(p2);
         fail("Ivalid Surname");
      } catch (DatabaseException e) {
         System.out.println("Catched Invalid Surname");
      }
      p2.setSurname("Nesvadba");
      
      p2.setBirthDate(null);
      try {
         pm.createPerson(p2);
         fail("Ivalid Date");
      } catch (DatabaseException e) {
         System.out.println("Catched Invalid Date");
      }
      p2.setBirthDate(new Date());
      
      p2.setBirthNumber("");
      try {
         pm.createPerson(p2);
         fail("Ivalid BirthNumber");
      } catch (DatabaseException e) {
         System.out.println("Catched Invalid BirthNumber");
      }
      p2.setBirthNumber("6+846849684");
      
      p2.setState(null);
      try {
         pm.createPerson(p2);
         fail("Ivalid State");
      } catch (DatabaseException e) {
         System.out.println("Catched Invalid State");
      }
      p2.setState("Ukrajina");
      
      System.out.println("-------------------------------");
   }

   @Test
   public void testList(){
      System.out.println("-------------------------------");
      System.out.println("TEST : testInvalidInput");
      try {
         pm.createPerson(p1);
         pm.createPerson(p1);
         pm.createPerson(p1);
         pm.createPerson(p1);
         pm.createPerson(p1);
         
         assertEquals("List should be 5 rows long ",pm.getPersonList().size() , 5);
         
         pm.removePerson(p1);
         assertEquals("List should be 4 rows long ",pm.getPersonList().size() , 4);
         
      } catch (DatabaseException e) {
         fail(e.toString());
      }
      
      System.out.println("-------------------------------");
   }
}
