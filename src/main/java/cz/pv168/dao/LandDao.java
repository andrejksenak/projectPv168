package cz.pv168.dao;

import java.util.List;

import cz.pv168.model.Land;

public interface LandDao {

   public abstract void createLand(Land land);

   public abstract void updateLand(Land land);

   public abstract void removeLand(Land land);

   public abstract Land getLandById(Long id);

   public abstract List<Land> getLandList();

   public abstract List<Land> getLandByArea();

}