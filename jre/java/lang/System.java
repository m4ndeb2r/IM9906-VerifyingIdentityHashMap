package java.lang;

/**
 * @generated
 */
public final class System extends java.lang.Object {

   /*@ public behavior
     @ requires true;
     @   ensures 
     @     \result == \dl_genIdentityHash(param0);
     @ assignable \nothing;
     @*/
   public static int identityHashCode(java.lang.Object param0);

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public static void arraycopy(java.lang.Object param0, int param1, java.lang.Object param2, int param3, int param4);
}