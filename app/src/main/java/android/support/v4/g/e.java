package android.support.v4.g;

import android.util.Log;
import java.io.Writer;

public class e extends Writer {
  private final String a;
  
  private StringBuilder b = new StringBuilder(128);
  
  public e(String paramString) { this.a = paramString; }
  
  private void a() {
    if (this.b.length() > 0) {
      Log.d(this.a, this.b.toString());
      StringBuilder stringBuilder = this.b;
      stringBuilder.delete(0, stringBuilder.length());
    } 
  }
  
  public void close() { a(); }
  
  public void flush() { a(); }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2) {
    for (int i = 0; i < paramInt2; i++) {
      char c = paramArrayOfChar[paramInt1 + i];
      if (c == '\n') {
        a();
      } else {
        this.b.append(c);
      } 
    } 
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\g\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */