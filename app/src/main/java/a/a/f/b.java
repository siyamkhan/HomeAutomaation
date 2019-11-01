package a.a.a.a.a.f;

import a.a.a.a.c;
import a.a.a.a.i;
import android.content.Context;
import java.io.File;

public class b implements a {
  private final Context a;
  
  private final String b;
  
  private final String c;
  
  public b(i parami) {
    if (parami.r() != null) {
      this.a = parami.r();
      this.b = parami.t();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Android/");
      stringBuilder.append(this.a.getPackageName());
      this.c = stringBuilder.toString();
      return;
    } 
    throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
  }
  
  public File a() { return a(this.a.getFilesDir()); }
  
  File a(File paramFile) {
    if (paramFile != null) {
      if (!paramFile.exists()) {
        if (paramFile.mkdirs())
          return paramFile; 
        c.g().d("Fabric", "Couldn't create file");
      } else {
        return paramFile;
      } 
    } else {
      c.g().a("Fabric", "Null File");
    } 
    return null;
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\f\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */