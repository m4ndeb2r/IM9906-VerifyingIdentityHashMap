package java.util;

class Test {

    /*@ public normal_behaviour
      @  requires o1 != o2;
      @*/
    void test(Object o1, Object o2) {
        VerifiedIdentityHashMap ihm = new VerifiedIdentityHashMap();
        assert ihm.size() == 0;
        ihm.put(o1, o2);
        assert ihm.size() == 1;
        assert ihm.get(o1) == o2;
        ihm.put(o2, o2);
        ihm.put(o2, o1);
        assert ihm.size() == 2;
        assert ihm.get(o1) == o1;
    }
    
}
