package testPackage;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cz.pv168.manager.LandManager;
import cz.pv168.manager.impl.LandManagerImpl;
import cz.pv168.model.Land;

public class LandManagerImplTest {

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
   public void test() {
      fail("Not yet implemented");
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
   public void testLandBuildSize() {
      Land l = new Land();
      LandManager manager = new LandManagerImpl();
  
      l.setLandID((long) 1);
      l.setSize(1.0);
      l.setBuildUpArea(-1.0);
      
      try{
         manager.updateLand(l);
         fail("Not yet implemented");
      }catch(Exception e){
         
      }
      

   }
}
