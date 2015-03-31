package testPackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cz.pv168.manager.LandManager;
import cz.pv168.manager.impl.LandManagerImpl;
import cz.pv168.model.Land;
import cz.pv168.utils.DatabaseException;

public class LandManagerImplTest {
	
   LandManager lm = new LandManagerImpl();
   Land l1;
   Land l2;
	
   @BeforeClass
   public static void setUpBeforeClass() throws Exception {
   }

   @AfterClass
   public static void tearDownAfterClass() throws Exception {
   }

   @Before
   public void setUp() throws Exception {
	   try {
	         lm.createTableLand();
	      } catch (DatabaseException e) {
	         System.err.print("TABLE LAND EXISTS");
	      }
	    
	      l1= new Land(); 
	      l1.setSize(new Double(10));
	      l1.setCatastralArea("Slovensko");
	      l1.setBuildUpArea(new Double(100));;
	      l1.setType("pozemok");;
	      l1.setNotes("pozemok1");;
	      
	      l2= new Land(); 
	      l2.setSize(new Double(20));
	      l2.setCatastralArea("Cesko");
	      l2.setBuildUpArea(new Double(200));
	      l2.setType("byt");;
	      l2.setNotes("3-izbovy");
	  
   }

   @After
   public void tearDown() throws Exception {
	   try {
         lm.dropTableLand();
      } catch (DatabaseException e) {
         e.printStackTrace();
      }
   }

   @Test
   public void test() {
      fail("Not yet implemented");
   }

   public void testInputLand() {     
      try {
         System.out.println("-------------------------------");
         System.out.println("TEST : testInputLand");
         lm.createLand(l1);
         
         assertEquals("Lands must be equals", lm.getLandById(l1.getLandID()),l1);
         
         lm.removeLand(l1);
         
         try{
         l2 = lm.getLandById(l1.getLandID());
         fail("Land should have been removed\n");
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
      l2.setSize(new Double (-1));
      try {
         lm.createLand(l2);
         fail("Ivalid name");
      } catch (DatabaseException e) {
         System.out.println("Catched Invalid Name");
      }
      l2.setSize(new Double("1"));
      
      l2.setBuildUpArea(new Double(-1));
      try {
         lm.createLand(l2);
         fail("Ivalid Surname");
      } catch (DatabaseException e) {
         System.out.println("Catched Invalid Surname");
      }
      l2.setBuildUpArea(new Double(1));
      
      l2.setCatastralArea("");
      try {
         lm.createLand(l2);
         fail("Ivalid Date");
      } catch (DatabaseException e) {
         System.out.println("Catched Invalid Date");
      }
      l2.setCatastralArea("Slovakia");
      
      l2.setType("");
      try {
         lm.createLand(l2);
         fail("Ivalid BirthNumber");
      } catch (DatabaseException e) {
         System.out.println("Catched Invalid BirthNumber");
      }
      l2.setType("dom");
      
      System.out.println("-------------------------------");
   }

   @Test
   public void testList(){
      System.out.println("-------------------------------");
      System.out.println("TEST : testInvalidInput");
      try {
         lm.createLand(l1);
         lm.createLand(l1);
         lm.createLand(l1);
         lm.createLand(l1);
         lm.createLand(l1);
         
         assertEquals("List should be 5 rows long ",lm.getLandList().size() , 5);
         
         lm.removeLand(l1);
         assertEquals("List should be 4 rows long ",lm.getLandList().size() , 4);
         
      } catch (DatabaseException e) {
         fail(e.toString());
      }
      
      System.out.println("-------------------------------");
   }
   
   public void testLandSize() {
      Land l = new Land();
      LandManager manager = new LandManagerImpl();
  
      l.setLandID((long) 1);
      l.setSize(-1.0);
      
      
      try{
         manager.updateLand(l);
         fail("Not yet implemented");
      }catch(Exception e){
         
      }
   }
   
}
