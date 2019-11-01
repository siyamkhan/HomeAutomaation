package android.support.e;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class s {
  public final Map<String, Object> a = new HashMap();
  
  public View b;
  
  final ArrayList<m> c = new ArrayList();
  
  public boolean equals(Object paramObject) {
    if (paramObject instanceof s) {
      View view = this.b;
      s s1 = (s)paramObject;
      if (view == s1.b && this.a.equals(s1.a))
        return true; 
    } 
    return false;
  }
  
  public int hashCode() { return 31 * this.b.hashCode() + this.a.hashCode(); }
  
  public String toString() {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("TransitionValues@");
    stringBuilder1.append(Integer.toHexString(hashCode()));
    stringBuilder1.append(":\n");
    String str1 = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str1);
    stringBuilder2.append("    view = ");
    stringBuilder2.append(this.b);
    stringBuilder2.append("\n");
    String str2 = stringBuilder2.toString();
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(str2);
    stringBuilder3.append("    values:");
    String str3 = stringBuilder3.toString();
    for (String str : this.a.keySet()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str3);
      stringBuilder.append("    ");
      stringBuilder.append(str);
      stringBuilder.append(": ");
      stringBuilder.append(this.a.get(str));
      stringBuilder.append("\n");
      str3 = stringBuilder.toString();
    } 
    return str3;
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\e\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */