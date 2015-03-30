package cz.pv168.manager.impl;

import java.util.List;

import cz.pv168.dao.LandDao;
import cz.pv168.dao.impl.LandDaoImpl;
import cz.pv168.manager.LandManager;
import cz.pv168.model.Land;

public class LandManagerImpl implements LandManager {

   private LandDao landDao;
   
   public LandManagerImpl(){
      landDao = new LandDaoImpl();
   }
   
   public void createLand(Land land) {
      // TODO Auto-generated method stub
      
   }

   public void updateLand(Land land) {
      // TODO Auto-generated method stub
      
   }

   public void removeLand(Land land) {
      // TODO Auto-generated method stub
      
   }

   public Land getLandById(Long id) {
      // TODO Auto-generated method stub
      return null;
   }

   public List<Land> getLandList() {
      // TODO Auto-generated method stub
      return null;
   }

   public List<Land> getLandByArea() {
      // TODO Auto-generated method stub
      return null;
   }
   

}
