package android.support.d.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.support.v4.h.b.a;
import android.support.v4.h.b.b;
import android.support.v4.h.b.c;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class d {
  public static Interpolator a(Context paramContext, int paramInt) {
    if (Build.VERSION.SDK_INT >= 21)
      return AnimationUtils.loadInterpolator(paramContext, paramInt); 
    XmlResourceParser xmlResourceParser = null;
    if (paramInt == 17563663)
      try {
        return new a();
      } catch (XmlPullParserException xmlPullParserException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Can't load animation resource ID #0x");
        stringBuilder.append(Integer.toHexString(paramInt));
        Resources.NotFoundException notFoundException = new Resources.NotFoundException(stringBuilder.toString());
        notFoundException.initCause(xmlPullParserException);
        throw notFoundException;
      } catch (IOException iOException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Can't load animation resource ID #0x");
        stringBuilder.append(Integer.toHexString(paramInt));
        Resources.NotFoundException notFoundException = new Resources.NotFoundException(stringBuilder.toString());
        notFoundException.initCause(iOException);
        throw notFoundException;
      } finally {
        if (xmlResourceParser != null)
          xmlResourceParser.close(); 
      }  
    xmlResourceParser = null;
    if (paramInt == 17563661)
      return new b(); 
    xmlResourceParser = null;
    if (paramInt == 17563662)
      return new c(); 
    xmlResourceParser = paramContext.getResources().getAnimation(paramInt);
    Interpolator interpolator = a(paramContext, paramContext.getResources(), paramContext.getTheme(), xmlResourceParser);
    if (xmlResourceParser != null)
      xmlResourceParser.close(); 
    return interpolator;
  }
  
  private static Interpolator a(Context paramContext, Resources paramResources, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser) {
    int i = paramXmlPullParser.getDepth();
    g g = null;
    while (true) {
      int j = paramXmlPullParser.next();
      if ((j != 3 || paramXmlPullParser.getDepth() > i) && j != 1) {
        g g1;
        if (j != 2)
          continue; 
        AttributeSet attributeSet = Xml.asAttributeSet(paramXmlPullParser);
        String str = paramXmlPullParser.getName();
        if (str.equals("linearInterpolator")) {
          g = new LinearInterpolator();
          continue;
        } 
        if (str.equals("accelerateInterpolator")) {
          g1 = new AccelerateInterpolator(paramContext, attributeSet);
        } else if (str.equals("decelerateInterpolator")) {
          g1 = new DecelerateInterpolator(paramContext, attributeSet);
        } else {
          if (str.equals("accelerateDecelerateInterpolator")) {
            AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
            continue;
          } 
          if (str.equals("cycleInterpolator")) {
            g1 = new CycleInterpolator(paramContext, attributeSet);
          } else if (str.equals("anticipateInterpolator")) {
            g1 = new AnticipateInterpolator(paramContext, attributeSet);
          } else if (str.equals("overshootInterpolator")) {
            g1 = new OvershootInterpolator(paramContext, attributeSet);
          } else if (str.equals("anticipateOvershootInterpolator")) {
            g1 = new AnticipateOvershootInterpolator(paramContext, attributeSet);
          } else {
            if (str.equals("bounceInterpolator")) {
              BounceInterpolator bounceInterpolator = new BounceInterpolator();
              continue;
            } 
            if (str.equals("pathInterpolator")) {
              g1 = new g(paramContext, attributeSet, paramXmlPullParser);
            } else {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("Unknown interpolator name: ");
              stringBuilder.append(paramXmlPullParser.getName());
              throw new RuntimeException(stringBuilder.toString());
            } 
          } 
        } 
        g = g1;
        continue;
      } 
      break;
    } 
    return g;
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\d\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */