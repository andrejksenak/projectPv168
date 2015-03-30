package testPackage;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cz.pv168.manager.OwnershipManager;
import cz.pv168.manager.impl.OwnershipManagerImpl;
import cz.pv168.model.Ownership;
import cz.pv168.utils.EntityException;

public class OwnershipManagerImplTest {

   
   private Ownership createOwnership(Long oID, Long pID, Long lID, Date startDate, Date endDate){
      Ownership o = new Ownership();
      o.setOwnerShipID(oID);
      o.setPersonID( pID);
      o.setLandId(lID);
      o.setEndDate(startDate);
      o.setStartDate(endDate);
      
      return o;
   }
   
   public Date getDate(int year, int month, int date){
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
   }

   @After
   public void tearDown() throws Exception {
   }

   @Test
   public void testDates() {
      OwnershipManager manager = new OwnershipManagerImpl();
      
      Ownership o;
      
      o= createOwnership(1L,1L,1L, getDate(2015, 2, 2),getDate(2015, 1 ,1));
      try{
         manager.updateOwnerShip(o);   
      }catch(EntityException e){
         fail(e.getMessage());
      }

      o= createOwnership(1L,1L,1L, null,getDate(2015, 1 ,1));
      
      try{
         manager.updateOwnerShip(o);
      }catch(EntityException e){
         fail(e.getMessage());
      }
      

   }
   
   @Test
   public void testIDs() {
      OwnershipManager manager = new OwnershipManagerImpl();
      Ownership o;

      o= createOwnership(null,1L,1L, getDate(2015, 1, 1),getDate(2015, 1 ,1));
      
      try{
         manager.updateOwnerShip(o);
      }catch(EntityException e){
         fail(e.getMessage());
      }
      
      o= createOwnership(1L,null,1L, getDate(2015, 1, 1),getDate(2015, 1 ,2));
      
      try{
         manager.updateOwnerShip(o);
      }catch(EntityException e){
         fail(e.getMessage());
      }
      
   }
   
   @Test 
   public void testInput(){
      OwnershipManager manager = new OwnershipManagerImpl();
      Ownership o1,o2,res=null;
      
      o1= createOwnership(1L,1L,1L, getDate(2015, 1, 1),getDate(2015, 1 ,2));
      o2= createOwnership(2L,1L,1L, getDate(2015, 1, 1),getDate(2015, 1 ,2));
      
      
      try {
         manager.createOwnership(o1);
      } catch (EntityException e1) {
         fail(e1.getMessage());
      }
      
      try {
         res = manager.getOwnershipById(1L);
      } catch (EntityException e1) {
         fail(e1.getMessage());
      }
      assertEquals("ownernership inputed is not the same as obtained from DB" ,o1,res) ;
      
      try {
         manager.createOwnership(o2);
      } catch (EntityException e) {
         e.printStackTrace();
         fail(e.getMessage());
      }
      assertNotEquals("o1 and o2 are not the same", o1,o2);
      
      
   }
   
   @Test
   public void testDelete(){
      OwnershipManager manager = new OwnershipManagerImpl();
      Ownership o;
      
      o= createOwnership(1L,1L,1L, getDate(2015, 1, 1),getDate(2015, 1 ,2));
      
      try {
         manager.createOwnership(o);
      } catch (EntityException e) {
         fail(e.getMessage());
      }
      
      Ownership res=null;
      try {
         res = manager.getOwnershipById(1L);
      } catch (EntityException e1) {
         fail(e1.getMessage());
      }
      
      assertTrue("no object with such ID",res!=null);
      //------------------------------------------------------------
      try {
         manager.removeOwnership(o);
      } catch (EntityException e) {
         fail(e.getMessage());
      }
      
      try {
         res = manager.getOwnershipById(1L);
      } catch (EntityException e1) {
         fail(e1.getMessage());
      }
      assertTrue("object was not removed",res==null);
   }
   
   

}
