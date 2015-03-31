package cz.pv168.manager;
import java.util.List;

import cz.pv168.model.Land;
import cz.pv168.utils.DatabaseException;


public interface LandManager {
	/**
	  * 
	  * @param land
	  * @throws DatabaseException
	  */
   public  void createLand(Land land) throws DatabaseException;
	/**
	  * 
	  * @param land
	  * @throws DatabaseException
	  */
   public  void updateLand(Land land) throws DatabaseException;
	/**
	  * 
	  * @param land
	  * @throws DatabaseException
	  */
   public  void removeLand(Land land) throws DatabaseException;
   /**
    * 
    * @param id
    * @return
    * @throws DatabaseException
    */
   public  Land getLandById(Long id) throws DatabaseException;
   /**
    * 
    * @return
    * @throws DatabaseException
    */
   public  List<Land> getLandList() throws DatabaseException;
   /**
    * 
    * @param catastralArea
    * @return
    * @throws DatabaseException
    */
   public  List<Land> getLandByArea(String catastralArea) throws DatabaseException;
   
   public void dropTableLand() throws DatabaseException;
   
   public void createTableLand() throws DatabaseException;
}
