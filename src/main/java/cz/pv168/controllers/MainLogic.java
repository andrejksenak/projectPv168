package cz.pv168.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cz.pv168.manager.LandManager;
import cz.pv168.manager.OwnershipManager;
import cz.pv168.manager.PersonManager;
import cz.pv168.manager.impl.LandManagerImpl;
import cz.pv168.manager.impl.OwnershipManagerImpl;
import cz.pv168.manager.impl.PersonManagerImpl;

public class MainLogic {

   private LandManager      landManager;
   private PersonManager    personManager;
   private OwnershipManager ownershipManager;
   private BasicDataSource  datasource;

   private static Logger LOGGER = LoggerFactory.getLogger(MainLogic.class);
   
  

   public MainLogic() {
      
      landManager = new LandManagerImpl();
      personManager = new PersonManagerImpl();
      ownershipManager = new OwnershipManagerImpl();
      

   }


}
