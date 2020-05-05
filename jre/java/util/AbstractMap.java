package java.util;

/**
 * @generated
 */
public abstract class AbstractMap extends java.lang.Object implements java.util.Map {
   /**
    * @generated
    */
   java.util.Set keySet;

   /**
    * @generated
    */
   java.util.Collection values;

   /**
    * @generated
    */
   /*@ protected behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   protected java.lang.Object clone() throws java.lang.CloneNotSupportedException;

   /**
    * @generated
    */
   public static class SimpleEntry extends java.lang.Object implements java.util.Map.Entry, java.io.Serializable {
      /**
       * @generated
       */
      /*@ public behavior
        @ requires true;
        @ ensures true;
        @ assignable \everything;
        @*/
      public SimpleEntry(java.util.Map.Entry param0);
   }
}