package cz.pv168.dao;

import java.util.List;

import cz.pv168.model.Land;
import cz.pv168.model.Ownership;
import cz.pv168.model.Person;

public interface OwnershipDao {

   public abstract void createOwnership(Ownership ownership);

   public abstract void updateOwnerShip(Ownership ownership);

   public abstract void removeOwnership(Ownership ownership);

   public abstract List<Person> getListOfPersonsOfLand();

   public abstract List<Land> getListOfLandsOfPerson();

   public abstract List<Ownership> getOwnershipList();

   public abstract Ownership getOwnershipById(Long id);

}