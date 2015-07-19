package cz.pv168.controllers;

import java.io.IOException;
import java.util.List;

import cz.pv168.utils.ScriptRunner;

public class ProjectPV168Main {
   
   public static void main(String[] args){
     ScriptRunner s = new ScriptRunner();
     
     String str=null;
     List<String> list ;
     
     try {
      str = s.loadScript("dbScripts/createLandTable.sql");
      str = s.loadScript("dbScripts/createPersonTable.sql");
      str = s.loadScript("dbScripts/createOwnershipTable.sql");
      
     } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
     }
     
     System.out.println(str);
     list = s.getListCommands(str);
     
     for(String com : list){
        System.out.println(com);
     }
     
      
   }
}
