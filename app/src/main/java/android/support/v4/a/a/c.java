package android.support.v4.a.a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.a.a;
import android.support.v4.e.a;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class c {
  private static int a(TypedArray paramTypedArray, int paramInt) {
    if (Build.VERSION.SDK_INT >= 21)
      return paramTypedArray.getType(paramInt); 
    TypedValue typedValue = new TypedValue();
    paramTypedArray.getValue(paramInt, typedValue);
    return typedValue.type;
  }
  
  public static a a(XmlPullParser paramXmlPullParser, Resources paramResources) {
    int i;
    while (true) {
      i = paramXmlPullParser.next();
      if (i != 2 && i != 1)
        continue; 
      break;
    } 
    if (i == 2)
      return b(paramXmlPullParser, paramResources); 
    throw new XmlPullParserException("No start tag found");
  }
  
  public static List<List<byte[]>> a(Resources paramResources, int paramInt) {
    if (paramInt == 0)
      return Collections.emptyList(); 
    typedArray = paramResources.obtainTypedArray(paramInt);
    try {
      if (typedArray.length() == 0)
        return Collections.emptyList(); 
      arrayList = new ArrayList();
      if (a(typedArray, 0) == 1)
        for (byte b = 0;; b++) {
          if (b < typedArray.length()) {
            int i = typedArray.getResourceId(b, 0);
            if (i != 0)
              arrayList.add(a(paramResources.getStringArray(i))); 
          } else {
            return arrayList;
          } 
        }  
      arrayList.add(a(paramResources.getStringArray(paramInt)));
      return arrayList;
    } finally {
      typedArray.recycle();
    } 
  }
  
  private static List<byte[]> a(String[] paramArrayOfString) {
    ArrayList arrayList = new ArrayList();
    int i = paramArrayOfString.length;
    for (byte b = 0; b < i; b++)
      arrayList.add(Base64.decode(paramArrayOfString[b], 0)); 
    return arrayList;
  }
  
  private static void a(XmlPullParser paramXmlPullParser) {
    for (byte b = 1; b; b++) {
      switch (paramXmlPullParser.next()) {
        default:
          continue;
        case 3:
          b--;
          continue;
        case 2:
          break;
      } 
    } 
  }
  
  private static a b(XmlPullParser paramXmlPullParser, Resources paramResources) {
    paramXmlPullParser.require(2, null, "font-family");
    if (paramXmlPullParser.getName().equals("font-family"))
      return c(paramXmlPullParser, paramResources); 
    a(paramXmlPullParser);
    return null;
  }
  
  private static a c(XmlPullParser paramXmlPullParser, Resources paramResources) {
    TypedArray typedArray = paramResources.obtainAttributes(Xml.asAttributeSet(paramXmlPullParser), a.c.FontFamily);
    String str1 = typedArray.getString(a.c.FontFamily_fontProviderAuthority);
    String str2 = typedArray.getString(a.c.FontFamily_fontProviderPackage);
    String str3 = typedArray.getString(a.c.FontFamily_fontProviderQuery);
    int i = typedArray.getResourceId(a.c.FontFamily_fontProviderCerts, 0);
    int j = typedArray.getInteger(a.c.FontFamily_fontProviderFetchStrategy, 1);
    int k = typedArray.getInteger(a.c.FontFamily_fontProviderFetchTimeout, 500);
    typedArray.recycle();
    if (str1 != null && str2 != null && str3 != null) {
      while (paramXmlPullParser.next() != 3)
        a(paramXmlPullParser); 
      return new d(new a(str1, str2, str3, a(paramResources, i)), j, k);
    } 
    ArrayList arrayList = new ArrayList();
    while (paramXmlPullParser.next() != 3) {
      if (paramXmlPullParser.getEventType() != 2)
        continue; 
      if (paramXmlPullParser.getName().equals("font")) {
        arrayList.add(d(paramXmlPullParser, paramResources));
        continue;
      } 
      a(paramXmlPullParser);
    } 
    return arrayList.isEmpty() ? null : new b((c[])arrayList.toArray(new c[arrayList.size()]));
  }
  
  private static c d(XmlPullParser paramXmlPullParser, Resources paramResources) {
    int i2;
    int n;
    int m;
    boolean bool;
    int k;
    int i;
    TypedArray typedArray = paramResources.obtainAttributes(Xml.asAttributeSet(paramXmlPullParser), a.c.FontFamilyFont);
    if (typedArray.hasValue(a.c.FontFamilyFont_fontWeight)) {
      i = a.c.FontFamilyFont_fontWeight;
    } else {
      i = a.c.FontFamilyFont_android_fontWeight;
    } 
    int j = typedArray.getInt(i, 400);
    if (typedArray.hasValue(a.c.FontFamilyFont_fontStyle)) {
      k = a.c.FontFamilyFont_fontStyle;
    } else {
      k = a.c.FontFamilyFont_android_fontStyle;
    } 
    if (1 == typedArray.getInt(k, 0)) {
      bool = true;
    } else {
      bool = false;
    } 
    if (typedArray.hasValue(a.c.FontFamilyFont_ttcIndex)) {
      m = a.c.FontFamilyFont_ttcIndex;
    } else {
      m = a.c.FontFamilyFont_android_ttcIndex;
    } 
    if (typedArray.hasValue(a.c.FontFamilyFont_fontVariationSettings)) {
      n = a.c.FontFamilyFont_fontVariationSettings;
    } else {
      n = a.c.FontFamilyFont_android_fontVariationSettings;
    } 
    String str1 = typedArray.getString(n);
    int i1 = typedArray.getInt(m, 0);
    if (typedArray.hasValue(a.c.FontFamilyFont_font)) {
      i2 = a.c.FontFamilyFont_font;
    } else {
      i2 = a.c.FontFamilyFont_android_font;
    } 
    int i3 = typedArray.getResourceId(i2, 0);
    String str2 = typedArray.getString(i2);
    typedArray.recycle();
    while (paramXmlPullParser.next() != 3)
      a(paramXmlPullParser); 
    return new c(str2, j, bool, str1, i1, i3);
  }
  
  public static interface a {}
  
  public static final class b implements a {
    private final c.c[] a;
    
    public b(c.c[] param1ArrayOfc) { this.a = param1ArrayOfc; }
    
    public c.c[] a() { return this.a; }
  }
  
  public static final class c {
    private final String a;
    
    private int b;
    
    private boolean c;
    
    private String d;
    
    private int e;
    
    private int f;
    
    public c(String param1String1, int param1Int1, boolean param1Boolean, String param1String2, int param1Int2, int param1Int3) {
      this.a = param1String1;
      this.b = param1Int1;
      this.c = param1Boolean;
      this.d = param1String2;
      this.e = param1Int2;
      this.f = param1Int3;
    }
    
    public String a() { return this.a; }
    
    public int b() { return this.b; }
    
    public boolean c() { return this.c; }
    
    public String d() { return this.d; }
    
    public int e() { return this.e; }
    
    public int f() { return this.f; }
  }
  
  public static final class d implements a {
    private final a a;
    
    private final int b;
    
    private final int c;
    
    public d(a param1a, int param1Int1, int param1Int2) {
      this.a = param1a;
      this.c = param1Int1;
      this.b = param1Int2;
    }
    
    public a a() { return this.a; }
    
    public int b() { return this.c; }
    
    public int c() { return this.b; }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\a\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */