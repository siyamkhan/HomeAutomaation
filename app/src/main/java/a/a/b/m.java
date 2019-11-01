package a.a.a.a.a.b;

public static enum m {
  a(1),
  b(2),
  c(3),
  d(4);
  
  private final int e;
  
  static  {
    m[] arrayOfm = new m[4];
    arrayOfm[0] = a;
    arrayOfm[1] = b;
    arrayOfm[2] = c;
    arrayOfm[3] = d;
    f = arrayOfm;
  }
  
  m(int paramInt1) { this.e = paramInt1; }
  
  public static m a(String paramString) { return "io.crash.air".equals(paramString) ? c : ((paramString != null) ? d : a); }
  
  public int a() { return this.e; }
  
  public String toString() { return Integer.toString(this.e); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\b\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */