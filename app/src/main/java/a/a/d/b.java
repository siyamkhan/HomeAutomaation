package a.a.a.a.a.d;

import a.a.a.a.a.b.i;
import a.a.a.a.a.b.k;
import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class b<T> extends Object {
  protected final Context a;
  
  protected final a<T> b;
  
  protected final k c;
  
  protected final c d;
  
  protected final List<d> f = new CopyOnWriteArrayList();
  
  private final int g;
  
  public b(Context paramContext, a<T> parama, k paramk, c paramc, int paramInt) {
    this.a = paramContext.getApplicationContext();
    this.b = parama;
    this.d = paramc;
    this.c = paramk;
    this.e = this.c.a();
    this.g = paramInt;
  }
  
  private void a(int paramInt) {
    if (!this.d.a(paramInt, c())) {
      Locale locale = Locale.US;
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Integer.valueOf(this.d.a());
      arrayOfObject[1] = Integer.valueOf(paramInt);
      arrayOfObject[2] = Integer.valueOf(c());
      String str = String.format(locale, "session analytics events file is %d bytes, new event is %d bytes, this is over flush limit of %d, rolling it over", arrayOfObject);
      i.a(this.a, 4, "Fabric", str);
      d();
    } 
  }
  
  private void b(String paramString) {
    for (d d1 : this.f) {
      try {
        d1.a(paramString);
      } catch (Exception exception) {
        i.a(this.a, "One of the roll over listeners threw an exception", exception);
      } 
    } 
  }
  
  public long a(String paramString) {
    String[] arrayOfString = paramString.split("_");
    if (arrayOfString.length != 3)
      return 0L; 
    try {
      return Long.valueOf(arrayOfString[2]).longValue();
    } catch (NumberFormatException numberFormatException) {
      return 0L;
    } 
  }
  
  protected abstract String a();
  
  public void a(d paramd) {
    if (paramd != null)
      this.f.add(paramd); 
  }
  
  public void a(T paramT) {
    byte[] arrayOfByte = this.b.a(paramT);
    a(arrayOfByte.length);
    this.d.a(arrayOfByte);
  }
  
  public void a(List<File> paramList) { this.d.a(paramList); }
  
  protected int b() { return this.g; }
  
  protected int c() { return 8000; }
  
  public boolean d() {
    String str;
    boolean bool1 = this.d.b();
    boolean bool2 = true;
    if (!bool1) {
      str = a();
      this.d.a(str);
      Context context = this.a;
      Locale locale = Locale.US;
      Object[] arrayOfObject = new Object[bool2];
      arrayOfObject[0] = str;
      i.a(context, 4, "Fabric", String.format(locale, "generated new file %s", arrayOfObject));
      this.e = this.c.a();
    } else {
      str = null;
      bool2 = false;
    } 
    b(str);
    return bool2;
  }
  
  public List<File> e() { return this.d.a(1); }
  
  public void f() {
    c c1 = this.d;
    c1.a(c1.c());
    this.d.d();
  }
  
  public void g() {
    List list = this.d.c();
    int i = b();
    if (list.size() <= i)
      return; 
    int j = list.size() - i;
    Context context = this.a;
    Locale locale = Locale.US;
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(list.size());
    arrayOfObject[1] = Integer.valueOf(i);
    arrayOfObject[2] = Integer.valueOf(j);
    i.a(context, String.format(locale, "Found %d files in  roll over directory, this is greater than %d, deleting %d oldest files", arrayOfObject));
    TreeSet treeSet = new TreeSet(new Comparator<a>(this) {
          public int a(b.a param1a1, b.a param1a2) { return (int)(param1a1.b - param1a2.b); }
        });
    for (File file : list)
      treeSet.add(new a(file, a(file.getName()))); 
    ArrayList arrayList = new ArrayList();
    Iterator iterator = treeSet.iterator();
    while (iterator.hasNext()) {
      arrayList.add(((a)iterator.next()).a);
      if (arrayList.size() == j)
        break; 
    } 
    this.d.a(arrayList);
  }
  
  static class a {
    final File a;
    
    final long b;
    
    public a(File param1File, long param1Long) {
      this.a = param1File;
      this.b = param1Long;
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */