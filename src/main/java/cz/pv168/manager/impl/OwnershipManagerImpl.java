package cz.pv168.manager.impl;

import java.util.List;

import cz.pv168.dao.OwnershipDao;
import cz.pv168.dao.impl.OwnershipDaoImpl;
import cz.pv168.manager.LandManager;
import cz.pv168.manager.OwnershipManager;
import cz.pv168.model.Land;
import cz.pv168.model.Ownership;
import cz.pv168.model.Person;
import cz.pv168.utils.EntityException;

public class OwnershipManagerImpl implements OwnershipManager {

   private OwnershipDao ownershipDao;
   
   public OwnershipManagerImpl(){
      ownershipDao = new OwnershipDaoImpl();
   }
   
   public void createOwnership(Ownership ownership) throws EntityException {

   }

   public void updateOwnerShip(Ownership ownership) throws EntityException{

   }

   public void removeOwnership(Ownership ownership) throws EntityException{

   }

   public List<Person> getListOfPersonsOfLand() throws EntityException{
      return null;
   }

   public List<Land> getListOfLandsOfPerson() throws EntityException {
      return null;
   }

   public List<Ownership> getOwnershipList() throws EntityException{
      return null;
   }

   public Ownership getOwnershipById(Long id) throws EntityException{
      return null;
   }

}
