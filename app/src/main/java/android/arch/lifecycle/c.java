package android.arch.lifecycle;

public abstract class c {
  public abstract b a();
  
  public abstract void a(d paramd);
  
  public abstract void b(d paramd);
  
  public enum a {
    ON_ANY, ON_CREATE, ON_DESTROY, ON_PAUSE, ON_RESUME, ON_START, ON_STOP;
    
    static  {
      ON_RESUME = new a("ON_RESUME", 2);
      ON_PAUSE = new a("ON_PAUSE", 3);
      ON_STOP = new a("ON_STOP", 4);
      ON_DESTROY = new a("ON_DESTROY", 5);
      ON_ANY = new a("ON_ANY", 6);
      a[] arrayOfa = new a[7];
      arrayOfa[0] = ON_CREATE;
      arrayOfa[1] = ON_START;
      arrayOfa[2] = ON_RESUME;
      arrayOfa[3] = ON_PAUSE;
      arrayOfa[4] = ON_STOP;
      arrayOfa[5] = ON_DESTROY;
      arrayOfa[6] = ON_ANY;
      $VALUES = arrayOfa;
    }
  }
  
  public enum b {
    a, b, c, d, e;
    
    static  {
      b[] arrayOfb = new b[5];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      arrayOfb[2] = c;
      arrayOfb[3] = d;
      arrayOfb[4] = e;
      f = arrayOfb;
    }
    
    public boolean a(b param1b) { return (compareTo(param1b) >= 0); }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\arch\lifecycle\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */