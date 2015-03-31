package cz.pv168.dao;

import java.util.List;

import cz.pv168.model.Land;
import cz.pv168.utils.DatabaseException;

public interface LandDao {

   public abstract void createLand(Land land) throws DatabaseException;

   public abstract void updateLand(Land land) throws DatabaseException;

   public abstract void removeLand(Land land) throws DatabaseException;

   public abstract Land getLandById(Long id) throws DatabaseException;

   public abstract List<Land> getLandList() throws DatabaseException;

   public abstract List<Land> getLandByArea(String catastralArea) throws DatabaseException;
   
   public abstract void dropTableLand() throws DatabaseException;
 
   public abstract void createTableLand() throws DatabaseException;

}