package java.lang;

/**
 * @generated
 */
public class Object {
   /**
    * @generated
    */
   /*@ public normal_behavior
     @   requires true;
     @   ensures \result == self.equals(param0);
     @*/
   public /*@ helper strictly_pure @*/ boolean equals(/*@ nullable */ java.lang.Object param0);

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
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public final java.lang.Class getClass();

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public int hashCode();

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public java.lang.String toString();

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public final void notify();

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public final void notifyAll();

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public final void wait(long param0) throws java.lang.InterruptedException;

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public final void wait(long param0, int param1) throws java.lang.InterruptedException;

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public final void wait() throws java.lang.InterruptedException;

   /**
    * @generated
    */
   /*@ protected behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   protected void finalize() throws java.lang.Throwable;
}
