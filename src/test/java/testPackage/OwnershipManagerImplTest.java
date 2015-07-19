package testPackage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cz.pv168.manager.LandManager;
import cz.pv168.manager.OwnershipManager;
import cz.pv168.manager.PersonManager;
import cz.pv168.manager.impl.LandManagerImpl;
import cz.pv168.manager.impl.OwnershipManagerImpl;
import cz.pv168.manager.impl.PersonManagerImpl;
import cz.pv168.model.Land;
import cz.pv168.model.Ownership;
import cz.pv168.model.Person;
import cz.pv168.utils.DatabaseException;

public class OwnershipManagerImplTest {

   OwnershipManager om = new OwnershipManagerImpl();
   PersonManager    pm = new PersonManagerImpl();
   LandManager      lm = new LandManagerImpl();
   Ownership        o1;
   Ownership        o2;
   Land             l1;
   Land             l2;
   Person           p1;
   Person           p2;

   private Ownership createOwnership(Long oID, Long pID, Long lID,
         Date startDate, Date endDate) {
      Ownership o = new Ownership();
      o.setOwnerShipID(oID);
      o.setPersonID(pID);
      o.setLandId(lID);
      o.setEndDate(startDate);
      o.setStartDate(endDate);

      return o;
   }

   public Date getDate(int year, int month, int date) {
      Calendar c = new GregorianCalendar();
      c.set(year, month, date);
      return c.getTime();
   }

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
         System.err.println("person EXISTS" + e);
      }

      try {
         lm.createTableLand();
      } catch (DatabaseException e) {
         System.err.println("Land EXISTS" + e);
      }

      try {
         om.createTableOwnership();
      } catch (DatabaseException e) {
         System.err.println("Ownership EXISTS" + e);
      }

      l1 = new Land();
      l1.setSize(new Double(10));
      l1.setCatastralArea("Slovensko");
      l1.setBuildUpArea(new Double(100));
      ;
      l1.setType("pozemok");
      l1.setNotes("pozemok1");

      p1 = new Person();
      p1.setName("JOHN");
      p1.setSurname("Alexandrejev");
      p1.setBirthDate(new Date());
      p1.setBirthNumber("849846");
      p1.setState("Russia");

      try {
         lm.createLand(l1);
         lm.createLand(l1);
         lm.createLand(l1);
         lm.createLand(l1);
         lm.createLand(l1);
      } catch (DatabaseException e) {
         System.err.println("Cannot create land  " + e);
      }
      try {
         pm.createPerson(p1);
         pm.createPerson(p1);
         pm.createPerson(p1);
         pm.createPerson(p1);
         pm.createPerson(p1);
      } catch (DatabaseException e) {
         System.err.println("Cannot create person  " + e);
      }
   }

   @After
   public void tearDown() throws Exception {
      try {
         om.dropTableOwnership();
      } catch (DatabaseException e) {
         System.err.println("Ownership EXISTS" + e);
      }

      try {
         pm.droptablePerson();
      } catch (DatabaseException e) {
         System.err.println("person EXISTS" + e);
      }

      try {
         lm.dropTableLand();
      } catch (DatabaseException e) {
         System.err.println("Land EXISTS" + e);
      }

   }

   // @Test
   public void testcretingtable() {
      try {
         pm.createTablePerson();
      } catch (DatabaseException e) {
         System.err.println("person EXISTS" + e);
      }

      try {
         lm.createTableLand();
      } catch (DatabaseException e) {
         System.err.println("Land EXISTS" + e);
      }

      try {
         om.createTableOwnership();
      } catch (DatabaseException e) {
         System.err.println("Ownership EXISTS" + e);
      }
      // ------------------------------------------------
      try {
         om.dropTableOwnership();
      } catch (DatabaseException e) {
         System.err.println("Ownership EXISTS" + e);
      }

      try {
         pm.droptablePerson();
      } catch (DatabaseException e) {
         System.err.println("person EXISTS" + e);
      }

      try {
         lm.dropTableLand();
      } catch (DatabaseException e) {
         System.err.println("Land EXISTS" + e);
      }

   }

   @Test
   public void testDates() {
      Ownership o;

      o = createOwnership(1L, 1L, 1L, getDate(2015, 2, 2), getDate(2015, 1, 1));
      try {
         om.createOwnership(o);
         fail("Cannot create with date d1>d2");
      } catch (DatabaseException e) {
         System.out.println("cathced ivalid date d1>d2");
      }
   }

   @Test
   public void testIDs() {
      Ownership ownership;

      ownership = createOwnership(null, 1L, 1L, getDate(2015, 1, 1),
            getDate(2015, 1, 1));

      try {
         om.createOwnership(ownership);
      } catch (DatabaseException e) {
         fail(e.getMessage());
      }

      ownership = createOwnership(1L, null, 1L, getDate(2015, 1, 1),
            getDate(2015, 1, 2));

      try {
         om.updateOwnerShip(ownership);
         fail("Ivalid person ID ");
      } catch (DatabaseException e) {
         System.out.println("Catched invalid Person ID ");
      }

      ownership = createOwnership(1L, 1L, null, getDate(2015, 1, 1),
            getDate(2015, 1, 2));
      try {
         om.updateOwnerShip(ownership);
         fail("Ivalid land ID ");
      } catch (DatabaseException e) {
         System.out.println("Catched invalid land ID ");
      }

   }

   @Test
   public void testInput() {
      OwnershipManager manager = new OwnershipManagerImpl();
      Ownership o1, o2, res = null;

      o1 = createOwnership(1L, 1L, 1L, getDate(2015, 1, 1), getDate(2015, 1, 2));
      o2 = createOwnership(2L, 1L, 1L, getDate(2015, 1, 1), getDate(2015, 1, 2));

      try {
         manager.createOwnership(o1);
      } catch (DatabaseException e1) {
         fail(e1.getMessage());
      }

      try {
         res = manager.getOwnershipById(1L);
      } catch (DatabaseException e1) {
         fail(e1.getMessage());
      }
      assertEquals("ownernership inputed is not the same as obtained from DB",
            o1, res);

      try {
         manager.createOwnership(o2);
      } catch (DatabaseException e) {
         e.printStackTrace();
         fail(e.getMessage());
      }
      assertNotEquals("o1 and o2 are not the same", o1, o2);

   }

   @Test
   public void testDelete() {
      OwnershipManager manager = new OwnershipManagerImpl();
      Ownership o;

      o = createOwnership(1L, 1L, 1L, getDate(2015, 1, 1), getDate(2015, 1, 2));

      try {
         manager.createOwnership(o);
      } catch (DatabaseException e) {
         fail(e.getMessage());
      }

      Ownership res = null;
      try {
         res = manager.getOwnershipById(1L);
      } catch (DatabaseException e1) {
         fail(e1.getMessage());
      }

      assertTrue("no object with such ID", res != null);
      // ------------------------------------------------------------
      try {
         manager.removeOwnership(o);
      } catch (DatabaseException e) {
         fail(e.getMessage());
      }

      try {
         res = manager.getOwnershipById(1L);
         fail("There should be nothing to find");
      } catch (DatabaseException e1) {

      }
   }

}
