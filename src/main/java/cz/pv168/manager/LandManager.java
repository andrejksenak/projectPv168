package cz.pv168.manager;
import java.util.List;

import cz.pv168.model.Land;


public interface LandManager {
   
   public  void createLand(Land land);

   public  void updateLand(Land land);

   public  void removeLand(Land land);

   public  Land getLandById(Long id);

   public  List<Land> getLandList();

   public  List<Land> getLandByArea();
}
