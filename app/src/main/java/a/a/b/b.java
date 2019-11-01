package a.a.a.a.a.b;

class b {
  public final String a;
  
  public final boolean b;
  
  b(String paramString, boolean paramBoolean) {
    this.a = paramString;
    this.b = paramBoolean;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject != null) {
      if (getClass() != paramObject.getClass())
        return false; 
      b b1 = (b)paramObject;
      if (this.b != b1.b)
        return false; 
      String str = this.a;
      if (str != null) {
        if (!str.equals(b1.a))
          return false; 
      } else if (b1.a != null) {
        return false;
      } 
      return true;
    } 
    return false;
  }
  
  public int hashCode() {
    boolean bool;
    String str = this.a;
    if (str != null) {
      bool = str.hashCode();
    } else {
      bool = false;
    } 
    return bool * 31 + this.b;
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */