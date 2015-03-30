package cz.pv168.utils;

public class EntityException extends Exception {

   private static final long serialVersionUID = -8720173716208195168L;

   
   public EntityException(String msg) {
      super(msg);
  }

  public EntityException(Throwable cause) {
      super(cause);
  }

  public EntityException(String message, Throwable cause) {
      super(message, cause);
  }
}
