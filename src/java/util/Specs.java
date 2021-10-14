class Specs {

    /*+KEY@ public normal_behaviour
      @  requires a != null;
      @  requires a.length % 2 == 0;
      @  ensures \result == (\num_of \bigint i;
      @       0 <= i < a.length / (\bigint)2;
      @       a[2 * i] != null);
      @  assignable \strictly_nothing;
      @*/
    public static int countEven(/*@nullable*/Object[] a) {
        int result = 0;
        
        /*@ loop_invariant
          @  result == (\num_of \bigint j;
          @       0 <= j < i/2;
          @       a[2 * j] != null);
          @ loop_invariant 0 <= i <= a.length;
          @ loop_invariant i%2 == 0;
          @ decreases a.length + 1 - i;
          @ assignable \strictly_nothing;
          @*/
        for(int i = 0; i < a.length; i += 2) {
            if(a[i] != null) {
                result ++;
            }
        }
        return result;
        
    }
    
    /*@ public normal_behaviour
      @  requires a != null;
      @  requires a.length % 2 == 0;
      @  requires countEven(a) < a.length / 3;
      @  requires a.length >= 8;
      @  ensures (\exists int x, y; 0 <= x < y < a.length;
      @     a[x] == null && a[y] == null);
      @  assignable \strictly_nothing;
      @*/
    public static int lemmaTwoNulls(Object[] a) {
        return 0;
    }

    /*@ normal_behaviour 
      @  requires true; // ... specs missing
      @  ensures true; 
      @*/
    void useCase(Object[] a) {
        //@ ghost int lemma;
        // somewhere in the code, we can invoke the lemma

        //@ set lemma = lemmaTwoNulls(a);      
        ;
        
        // then the rest of the code again
    }
}
