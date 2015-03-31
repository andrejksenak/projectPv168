package cz.pv168.manager.impl;

import java.util.List;

import javax.sql.DataSource;

import cz.pv168.dao.OwnershipDao;
import cz.pv168.dao.impl.OwnershipDaoImpl;
import cz.pv168.manager.OwnershipManager;
import cz.pv168.model.Land;
import cz.pv168.model.Ownership;
import cz.pv168.model.Person;
import cz.pv168.utils.ConnectorDB;
import cz.pv168.utils.DatabaseException;

public class OwnershipManagerImpl implements OwnershipManager {

   private OwnershipDao ownershipDao;
   
   DataSource        ds;
   
   public OwnershipManagerImpl(){
      ds = ConnectorDB.initDatasource(); 
      ownershipDao = new OwnershipDaoImpl(ds);
   }
   /**
    * 
    */
   public void createOwnership(Ownership ownership) throws DatabaseException {
      ownershipDao.createOwnership(ownership);
   }
   /**
    * 
    */
   public void updateOwnerShip(Ownership ownership) throws DatabaseException{
      ownershipDao.updateOwnerShip(ownership);
   }
   /**
    * 
    */
   public void removeOwnership(Ownership ownership) throws DatabaseException{
      ownershipDao.removeOwnership(ownership);
   }
   /**
    * 
    */
   public List<Person> getListOfPersonsOfLand() throws DatabaseException{
      return ownershipDao.getListOfPersonsOfLand();
   }
   /**
    * 
    */
   public List<Land> getListOfLandsOfPerson() throws DatabaseException {
      return ownershipDao.getListOfLandsOfPerson();
   }
   /**
    * 
    */
   public List<Ownership> getOwnershipList() throws DatabaseException{
      return ownershipDao.getOwnershipList();
   }
   /**
    * 
    */
   public Ownership getOwnershipById(Long id) throws DatabaseException{
      return ownershipDao.getOwnershipById(id);
   }
   /**
    * 
    */
   public void createTableOwnership() throws DatabaseException {
      ownershipDao.createTableOwnership();
   }
   /**
    * 
    */
   public void dropTableOwnership() throws DatabaseException {
      ownershipDao.dropTableOwnership();
   }
   


}
