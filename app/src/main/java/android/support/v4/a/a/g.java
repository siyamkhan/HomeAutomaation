package android.support.v4.a.a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

public class g {
  public static float a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt, float paramFloat) { return !a(paramXmlPullParser, paramString) ? paramFloat : paramTypedArray.getFloat(paramInt, paramFloat); }
  
  public static int a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt1, int paramInt2) { return !a(paramXmlPullParser, paramString) ? paramInt2 : paramTypedArray.getInt(paramInt1, paramInt2); }
  
  public static TypedArray a(Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, int[] paramArrayOfInt) { return (paramTheme == null) ? paramResources.obtainAttributes(paramAttributeSet, paramArrayOfInt) : paramTheme.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt, 0, 0); }
  
  public static b a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, Resources.Theme paramTheme, String paramString, int paramInt1, int paramInt2) {
    if (a(paramXmlPullParser, paramString)) {
      TypedValue typedValue = new TypedValue();
      paramTypedArray.getValue(paramInt1, typedValue);
      if (typedValue.type >= 28 && typedValue.type <= 31)
        return b.a(typedValue.data); 
      b b = b.a(paramTypedArray.getResources(), paramTypedArray.getResourceId(paramInt1, 0), paramTheme);
      if (b != null)
        return b; 
    } 
    return b.a(paramInt2);
  }
  
  public static String a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt) { return !a(paramXmlPullParser, paramString) ? null : paramTypedArray.getString(paramInt); }
  
  public static boolean a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt, boolean paramBoolean) { return !a(paramXmlPullParser, paramString) ? paramBoolean : paramTypedArray.getBoolean(paramInt, paramBoolean); }
  
  public static boolean a(XmlPullParser paramXmlPullParser, String paramString) { return (paramXmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", paramString) != null); }
  
  public static int b(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt1, int paramInt2) { return !a(paramXmlPullParser, paramString) ? paramInt2 : paramTypedArray.getColor(paramInt1, paramInt2); }
  
  public static TypedValue b(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt) { return !a(paramXmlPullParser, paramString) ? null : paramTypedArray.peekValue(paramInt); }
  
  public static int c(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt1, int paramInt2) { return !a(paramXmlPullParser, paramString) ? paramInt2 : paramTypedArray.getResourceId(paramInt1, paramInt2); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\a\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */