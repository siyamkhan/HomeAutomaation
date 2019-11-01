package a.a.a.a.a.c;

public static enum e {
  a, b, c, d;
  
  static  {
    e[] arrayOfe = new e[4];
    arrayOfe[0] = a;
    arrayOfe[1] = b;
    arrayOfe[2] = c;
    arrayOfe[3] = d;
    e = arrayOfe;
  }
  
  static <Y> int a(i parami, Y paramY) {
    e e1;
    if (paramY instanceof i) {
      e1 = ((i)paramY).b();
    } else {
      e1 = b;
    } 
    return e1.ordinal() - parami.b().ordinal();
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */