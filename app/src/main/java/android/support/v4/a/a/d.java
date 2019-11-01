package android.support.v4.a.a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.a.a;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

final class d {
  private static Shader.TileMode a(int paramInt) {
    switch (paramInt) {
      default:
        return Shader.TileMode.CLAMP;
      case 2:
        return Shader.TileMode.MIRROR;
      case 1:
        break;
    } 
    return Shader.TileMode.REPEAT;
  }
  
  static Shader a(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) {
    String str = paramXmlPullParser.getName();
    if (str.equals("gradient")) {
      TypedArray typedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.c.GradientColor);
      float f1 = g.a(typedArray, paramXmlPullParser, "startX", a.c.GradientColor_android_startX, 0.0F);
      float f2 = g.a(typedArray, paramXmlPullParser, "startY", a.c.GradientColor_android_startY, 0.0F);
      float f3 = g.a(typedArray, paramXmlPullParser, "endX", a.c.GradientColor_android_endX, 0.0F);
      float f4 = g.a(typedArray, paramXmlPullParser, "endY", a.c.GradientColor_android_endY, 0.0F);
      float f5 = g.a(typedArray, paramXmlPullParser, "centerX", a.c.GradientColor_android_centerX, 0.0F);
      float f6 = g.a(typedArray, paramXmlPullParser, "centerY", a.c.GradientColor_android_centerY, 0.0F);
      int i = g.a(typedArray, paramXmlPullParser, "type", a.c.GradientColor_android_type, 0);
      int j = g.b(typedArray, paramXmlPullParser, "startColor", a.c.GradientColor_android_startColor, 0);
      boolean bool = g.a(paramXmlPullParser, "centerColor");
      int k = g.b(typedArray, paramXmlPullParser, "centerColor", a.c.GradientColor_android_centerColor, 0);
      int m = g.b(typedArray, paramXmlPullParser, "endColor", a.c.GradientColor_android_endColor, 0);
      int n = g.a(typedArray, paramXmlPullParser, "tileMode", a.c.GradientColor_android_tileMode, 0);
      float f7 = g.a(typedArray, paramXmlPullParser, "gradientRadius", a.c.GradientColor_android_gradientRadius, 0.0F);
      typedArray.recycle();
      a a = a(b(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme), j, m, bool, k);
      switch (i) {
        default:
          return new LinearGradient(f1, f2, f3, f4, a.a, a.b, a(n));
        case 2:
          return new SweepGradient(f5, f6, a.a, a.b);
        case 1:
          break;
      } 
      if (f7 > 0.0F)
        return new RadialGradient(f5, f6, f7, a.a, a.b, a(n)); 
      throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramXmlPullParser.getPositionDescription());
    stringBuilder.append(": invalid gradient color tag ");
    stringBuilder.append(str);
    throw new XmlPullParserException(stringBuilder.toString());
  }
  
  private static a a(a parama, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3) { return (parama != null) ? parama : (paramBoolean ? new a(paramInt1, paramInt3, paramInt2) : new a(paramInt1, paramInt2)); }
  
  private static a b(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) {
    int i = 1 + paramXmlPullParser.getDepth();
    ArrayList arrayList1 = new ArrayList(20);
    ArrayList arrayList2 = new ArrayList(20);
    while (true) {
      int j = paramXmlPullParser.next();
      if (j != 1) {
        int k = paramXmlPullParser.getDepth();
        if (k >= i || j != 3) {
          if (j != 2 || k > i || !paramXmlPullParser.getName().equals("item"))
            continue; 
          TypedArray typedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.c.GradientColorItem);
          boolean bool1 = typedArray.hasValue(a.c.GradientColorItem_android_color);
          boolean bool2 = typedArray.hasValue(a.c.GradientColorItem_android_offset);
          if (bool1 && bool2) {
            int m = typedArray.getColor(a.c.GradientColorItem_android_color, 0);
            float f = typedArray.getFloat(a.c.GradientColorItem_android_offset, 0.0F);
            typedArray.recycle();
            arrayList2.add(Integer.valueOf(m));
            arrayList1.add(Float.valueOf(f));
            continue;
          } 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramXmlPullParser.getPositionDescription());
          stringBuilder.append(": <item> tag requires a 'color' attribute and a 'offset' ");
          stringBuilder.append("attribute!");
          throw new XmlPullParserException(stringBuilder.toString());
        } 
      } 
      break;
    } 
    return (arrayList2.size() > 0) ? new a(arrayList2, arrayList1) : null;
  }
  
  static final class a {
    final int[] a;
    
    final float[] b;
    
    a(int param1Int1, int param1Int2) {
      this.a = new int[] { param1Int1, param1Int2 };
      this.b = new float[] { 0.0F, 1.0F };
    }
    
    a(int param1Int1, int param1Int2, int param1Int3) {
      this.a = new int[] { param1Int1, param1Int2, param1Int3 };
      this.b = new float[] { 0.0F, 0.5F, 1.0F };
    }
    
    a(List<Integer> param1List1, List<Float> param1List2) {
      int i = param1List1.size();
      this.a = new int[i];
      this.b = new float[i];
      for (byte b1 = 0; b1 < i; b1++) {
        this.a[b1] = ((Integer)param1List1.get(b1)).intValue();
        this.b[b1] = ((Float)param1List2.get(b1)).floatValue();
      } 
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\a\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */