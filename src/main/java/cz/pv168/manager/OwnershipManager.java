package cz.pv168.manager;

import java.util.List;

import cz.pv168.model.Land;
import cz.pv168.model.Ownership;
import cz.pv168.model.Person;
import cz.pv168.utils.EntityException;

public interface OwnershipManager {

   public void createOwnership(Ownership ownership) throws EntityException;

   public void updateOwnerShip(Ownership ownership) throws EntityException;

   public void removeOwnership(Ownership ownership) throws EntityException;

   public List<Person> getListOfPersonsOfLand() throws EntityException;

   public List<Land> getListOfLandsOfPerson()throws EntityException;

   public List<Ownership> getOwnershipList()throws EntityException;

   public Ownership getOwnershipById(Long id)throws EntityException;
}
