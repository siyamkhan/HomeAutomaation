package android.arch.lifecycle;

public class o {
  private final a a;
  
  private final p b;
  
  public o(p paramp, a parama) {
    this.a = parama;
    this.b = paramp;
  }
  
  public <T extends n> T a(Class<T> paramClass) {
    String str = paramClass.getCanonicalName();
    if (str != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("android.arch.lifecycle.ViewModelProvider.DefaultKey:");
      stringBuilder.append(str);
      return (T)a(stringBuilder.toString(), paramClass);
    } 
    throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
  }
  
  public <T extends n> T a(String paramString, Class<T> paramClass) {
    n n1 = this.b.a(paramString);
    if (paramClass.isInstance(n1))
      return (T)n1; 
    n n2 = this.a.a(paramClass);
    this.b.a(paramString, n2);
    return (T)n2;
  }
  
  public static interface a {
    <T extends n> T a(Class<T> param1Class);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\arch\lifecycle\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */