package android.support.d.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.v4.a.a.g;
import android.support.v4.graphics.b;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import org.xmlpull.v1.XmlPullParser;

public class g implements Interpolator {
  private float[] a;
  
  private float[] b;
  
  public g(Context paramContext, AttributeSet paramAttributeSet, XmlPullParser paramXmlPullParser) { this(paramContext.getResources(), paramContext.getTheme(), paramAttributeSet, paramXmlPullParser); }
  
  public g(Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, XmlPullParser paramXmlPullParser) {
    TypedArray typedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.l);
    a(typedArray, paramXmlPullParser);
    typedArray.recycle();
  }
  
  private void a(float paramFloat1, float paramFloat2) {
    Path path = new Path();
    path.moveTo(0.0F, 0.0F);
    path.quadTo(paramFloat1, paramFloat2, 1.0F, 1.0F);
    a(path);
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    Path path = new Path();
    path.moveTo(0.0F, 0.0F);
    path.cubicTo(paramFloat1, paramFloat2, paramFloat3, paramFloat4, 1.0F, 1.0F);
    a(path);
  }
  
  private void a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser) {
    if (g.a(paramXmlPullParser, "pathData")) {
      String str = g.a(paramTypedArray, paramXmlPullParser, "pathData", 4);
      Path path = b.a(str);
      if (path != null) {
        a(path);
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("The path is null, which is created from ");
      stringBuilder.append(str);
      throw new InflateException(stringBuilder.toString());
    } 
    if (g.a(paramXmlPullParser, "controlX1")) {
      if (g.a(paramXmlPullParser, "controlY1")) {
        float f1 = g.a(paramTypedArray, paramXmlPullParser, "controlX1", 0, 0.0F);
        float f2 = g.a(paramTypedArray, paramXmlPullParser, "controlY1", 1, 0.0F);
        boolean bool = g.a(paramXmlPullParser, "controlX2");
        if (bool == g.a(paramXmlPullParser, "controlY2")) {
          if (!bool) {
            a(f1, f2);
            return;
          } 
          a(f1, f2, g.a(paramTypedArray, paramXmlPullParser, "controlX2", 2, 0.0F), g.a(paramTypedArray, paramXmlPullParser, "controlY2", 3, 0.0F));
          return;
        } 
        throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
      } 
      throw new InflateException("pathInterpolator requires the controlY1 attribute");
    } 
    throw new InflateException("pathInterpolator requires the controlX1 attribute");
  }
  
  private void a(Path paramPath) {
    byte b1 = 0;
    PathMeasure pathMeasure = new PathMeasure(paramPath, false);
    float f = pathMeasure.getLength();
    int i = Math.min(3000, 1 + (int)(f / 0.002F));
    if (i > 0) {
      this.a = new float[i];
      this.b = new float[i];
      float[] arrayOfFloat1 = new float[2];
      for (byte b2 = 0; b2 < i; b2++) {
        pathMeasure.getPosTan(f * b2 / (i - 1), arrayOfFloat1, null);
        this.a[b2] = arrayOfFloat1[0];
        this.b[b2] = arrayOfFloat1[1];
      } 
      if (Math.abs(this.a[0]) <= 1.0E-5D && Math.abs(this.b[0]) <= 1.0E-5D) {
        float[] arrayOfFloat = this.a;
        int k = i - 1;
        if (Math.abs(arrayOfFloat[k] - 1.0F) <= 1.0E-5D && Math.abs(this.b[k] - 1.0F) <= 1.0E-5D) {
          byte b3 = 0;
          float f1 = 0.0F;
          while (b1 < i) {
            float[] arrayOfFloat3 = this.a;
            byte b4 = b3 + true;
            float f2 = arrayOfFloat3[b3];
            if (f2 >= f1) {
              arrayOfFloat3[b1] = f2;
              b1++;
              f1 = f2;
              b3 = b4;
              continue;
            } 
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("The Path cannot loop back on itself, x :");
            stringBuilder2.append(f2);
            throw new IllegalArgumentException(stringBuilder2.toString());
          } 
          if (!pathMeasure.nextContour())
            return; 
          throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
        } 
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("The Path must start at (0,0) and end at (1,1) start: ");
      stringBuilder1.append(this.a[0]);
      stringBuilder1.append(",");
      stringBuilder1.append(this.b[0]);
      stringBuilder1.append(" end:");
      float[] arrayOfFloat2 = this.a;
      int j = i - 1;
      stringBuilder1.append(arrayOfFloat2[j]);
      stringBuilder1.append(",");
      stringBuilder1.append(this.b[j]);
      throw new IllegalArgumentException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("The Path has a invalid length ");
    stringBuilder.append(f);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public float getInterpolation(float paramFloat) {
    if (paramFloat <= 0.0F)
      return 0.0F; 
    if (paramFloat >= 1.0F)
      return 1.0F; 
    int i = 0;
    int j = this.a.length - 1;
    while (j - i > 1) {
      int k = (i + j) / 2;
      if (paramFloat < this.a[k]) {
        j = k;
        continue;
      } 
      i = k;
    } 
    float[] arrayOfFloat1 = this.a;
    float f1 = arrayOfFloat1[j] - arrayOfFloat1[i];
    if (f1 == 0.0F)
      return this.b[i]; 
    float f2 = (paramFloat - arrayOfFloat1[i]) / f1;
    float[] arrayOfFloat2 = this.b;
    float f3 = arrayOfFloat2[i];
    return f3 + f2 * (arrayOfFloat2[j] - f3);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\d\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */