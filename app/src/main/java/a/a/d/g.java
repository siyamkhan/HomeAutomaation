package a.a.a.a.a.d;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public class g extends h {
  public g(Context paramContext, File paramFile, String paramString1, String paramString2) { super(paramContext, paramFile, paramString1, paramString2); }
  
  public OutputStream a(File paramFile) { return new GZIPOutputStream(new FileOutputStream(paramFile)); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\d\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */