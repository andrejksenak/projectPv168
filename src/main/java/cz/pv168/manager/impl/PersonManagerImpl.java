package cz.pv168.manager.impl;

import java.util.List;

import javax.sql.DataSource;

import cz.pv168.dao.PersonDao;
import cz.pv168.dao.impl.PersonDaoImpl;
import cz.pv168.manager.PersonManager;
import cz.pv168.model.Person;
import cz.pv168.utils.ConnectorDB;
import cz.pv168.utils.DatabaseException;

public class PersonManagerImpl implements PersonManager {

   private PersonDao personDao;

   private DataSource        ds;
   /**
    * 
    */
   public PersonManagerImpl() {
      ds = ConnectorDB.initDatasource(); // TOHLE PUJDE VYS 
      personDao = new PersonDaoImpl(ds);
   }
   /**
    * 
    */
   public void createPerson(Person person) throws DatabaseException {
      personDao.createPerson(person);
   }
   /**
    * 
    */
   public Person getPersonById(Long id) throws DatabaseException {
      return personDao.getPersonById(id);
   }
   /**
    * 
    */
   public List<Person> getPersonByName(String name) throws DatabaseException {
      return personDao.getPersonByName(name);
   }
   /**
    * 
    */
   public List<Person> getPersonList() throws DatabaseException {
      return personDao.getPersonList();
   }
   /**
    * 
    */
   public void removePerson(Person person) throws DatabaseException {
      personDao.removePerson(person);
   }
   /**
    * 
    */
   public void updatePerson(Person person) throws DatabaseException {
      personDao.updatePerson(person);
   }
   /**
    * 
    */
   public void droptablePerson() throws DatabaseException {
      personDao.droptablePerson();
   }
   /**
    * 
    */
   public void createTablePerson() throws DatabaseException {
      personDao.createTablePerson();
   }

}
