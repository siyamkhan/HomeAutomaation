package android.support.v4.f;

import java.util.Locale;

public final class d {
  public static final c a = new e(null, false);
  
  public static final c b = new e(null, true);
  
  public static final c c = new e(b.a, false);
  
  public static final c d = new e(b.a, true);
  
  public static final c e = new e(a.a, false);
  
  public static final c f = f.a;
  
  static int a(int paramInt) {
    switch (paramInt) {
      default:
        return 2;
      case 1:
      case 2:
        return 0;
      case 0:
        break;
    } 
    return 1;
  }
  
  static int b(int paramInt) {
    switch (paramInt) {
      default:
        switch (paramInt) {
          default:
            return 2;
          case 16:
          case 17:
            return 0;
          case 14:
          case 15:
            break;
        } 
        break;
      case 1:
      case 2:
      
      case 0:
        break;
    } 
    return 1;
  }
  
  private static class a implements c {
    static final a a = new a(true);
    
    static final a b = new a(false);
    
    private final boolean c;
    
    private a(boolean param1Boolean) { this.c = param1Boolean; }
    
    public int a(CharSequence param1CharSequence, int param1Int1, int param1Int2) {
      int i = param1Int2 + param1Int1;
      boolean bool = false;
      while (param1Int1 < i) {
        switch (d.a(Character.getDirectionality(param1CharSequence.charAt(param1Int1)))) {
          case 1:
            if (!this.c)
              return 1; 
            bool = true;
            break;
          case 0:
            if (this.c)
              return 0; 
            bool = true;
            break;
        } 
        param1Int1++;
      } 
      return bool ? this.c : 2;
    }
  }
  
  private static class b implements c {
    static final b a = new b();
    
    public int a(CharSequence param1CharSequence, int param1Int1, int param1Int2) {
      int i = param1Int2 + param1Int1;
      int j = 2;
      while (param1Int1 < i && j == 2) {
        j = d.b(Character.getDirectionality(param1CharSequence.charAt(param1Int1)));
        param1Int1++;
      } 
      return j;
    }
  }
  
  private static interface c {
    int a(CharSequence param1CharSequence, int param1Int1, int param1Int2);
  }
  
  private static abstract class d implements c {
    private final d.c a;
    
    d(d.c param1c) { this.a = param1c; }
    
    private boolean b(CharSequence param1CharSequence, int param1Int1, int param1Int2) {
      switch (this.a.a(param1CharSequence, param1Int1, param1Int2)) {
        default:
          return a();
        case 1:
          return false;
        case 0:
          break;
      } 
      return true;
    }
    
    protected abstract boolean a();
    
    public boolean a(CharSequence param1CharSequence, int param1Int1, int param1Int2) {
      if (param1CharSequence != null && param1Int1 >= 0 && param1Int2 >= 0 && param1CharSequence.length() - param1Int2 >= param1Int1)
        return (this.a == null) ? a() : b(param1CharSequence, param1Int1, param1Int2); 
      throw new IllegalArgumentException();
    }
  }
  
  private static class e extends d {
    private final boolean a;
    
    e(d.c param1c, boolean param1Boolean) {
      super(param1c);
      this.a = param1Boolean;
    }
    
    protected boolean a() { return this.a; }
  }
  
  private static class f extends d {
    static final f a = new f();
    
    f() { super(null); }
    
    protected boolean a() { return (e.a(Locale.getDefault()) == 1); }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\f\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */