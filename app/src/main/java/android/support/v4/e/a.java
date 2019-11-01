package android.support.v4.e;

import android.support.v4.g.k;
import android.util.Base64;
import java.util.List;

public final class a {
  private final String a;
  
  private final String b;
  
  private final String c;
  
  private final List<List<byte[]>> d;
  
  private final int e;
  
  private final String f;
  
  public a(String paramString1, String paramString2, String paramString3, List<List<byte[]>> paramList) {
    this.a = (String)k.a(paramString1);
    this.b = (String)k.a(paramString2);
    this.c = (String)k.a(paramString3);
    this.d = (List)k.a(paramList);
    this.e = 0;
    StringBuilder stringBuilder = new StringBuilder(this.a);
    stringBuilder.append("-");
    stringBuilder.append(this.b);
    stringBuilder.append("-");
    stringBuilder.append(this.c);
    this.f = stringBuilder.toString();
  }
  
  public String a() { return this.a; }
  
  public String b() { return this.b; }
  
  public String c() { return this.c; }
  
  public List<List<byte[]>> d() { return this.d; }
  
  public int e() { return this.e; }
  
  public String f() { return this.f; }
  
  public String toString() {
    StringBuilder stringBuilder1 = new StringBuilder();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("FontRequest {mProviderAuthority: ");
    stringBuilder2.append(this.a);
    stringBuilder2.append(", mProviderPackage: ");
    stringBuilder2.append(this.b);
    stringBuilder2.append(", mQuery: ");
    stringBuilder2.append(this.c);
    stringBuilder2.append(", mCertificates:");
    stringBuilder1.append(stringBuilder2.toString());
    for (byte b1 = 0; b1 < this.d.size(); b1++) {
      stringBuilder1.append(" [");
      List list = (List)this.d.get(b1);
      for (byte b2 = 0; b2 < list.size(); b2++) {
        stringBuilder1.append(" \"");
        stringBuilder1.append(Base64.encodeToString((byte[])list.get(b2), 0));
        stringBuilder1.append("\"");
      } 
      stringBuilder1.append(" ]");
    } 
    stringBuilder1.append("}");
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append("mCertificatesArray: ");
    stringBuilder3.append(this.e);
    stringBuilder1.append(stringBuilder3.toString());
    return stringBuilder1.toString();
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */