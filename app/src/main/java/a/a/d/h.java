package a.a.a.a.a.d;

import a.a.a.a.a.b.i;
import a.a.a.a.a.b.u;
import android.content.Context;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jd.gui.api.API;

public class h implements c {
  private final Context a;
  
  private final File b;
  
  private final String c;
  
  private final File d;
  
  private u e;
  
  private File f;
  
  public h(Context paramContext, File paramFile, String paramString1, String paramString2) {
    this.a = paramContext;
    this.b = paramFile;
    this.c = paramString2;
    this.d = new File(this.b, paramString1);
    this.e = new u(this.d);
    e();
  }
  
  private void a(File paramFile1, File paramFile2) {
    API aPI;
    outputStream = null;
    try {
      closeable = new FileInputStream(paramFile1);
    } finally {
      aPI = null;
    } 
    i.a(closeable, "Failed to close file input stream");
    i.a(outputStream, "Failed to close output stream");
    paramFile1.delete();
    throw aPI;
  }
  
  private void e() {
    this.f = new File(this.b, this.c);
    if (!this.f.exists())
      this.f.mkdirs(); 
  }
  
  public int a() { return this.e.a(); }
  
  public OutputStream a(File paramFile) { return new FileOutputStream(paramFile); }
  
  public List<File> a(int paramInt) {
    ArrayList arrayList = new ArrayList();
    File[] arrayOfFile = this.f.listFiles();
    int i = arrayOfFile.length;
    for (byte b1 = 0; b1 < i; b1++) {
      arrayList.add(arrayOfFile[b1]);
      if (arrayList.size() >= paramInt)
        return arrayList; 
    } 
    return arrayList;
  }
  
  public void a(String paramString) {
    this.e.close();
    a(this.d, new File(this.f, paramString));
    this.e = new u(this.d);
  }
  
  public void a(List<File> paramList) {
    for (File file : paramList) {
      Context context = this.a;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = file.getName();
      i.a(context, String.format("deleting sent analytics file %s", arrayOfObject));
      file.delete();
    } 
  }
  
  public void a(byte[] paramArrayOfByte) { this.e.a(paramArrayOfByte); }
  
  public boolean a(int paramInt1, int paramInt2) { return this.e.a(paramInt1, paramInt2); }
  
  public boolean b() { return this.e.b(); }
  
  public List<File> c() { return Arrays.asList(this.f.listFiles()); }
  
  public void d() {
    try {
      this.e.close();
    } catch (IOException iOException) {}
    this.d.delete();
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\d\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */