package android.support.d.a;

import android.animation.TypeEvaluator;

public class f implements TypeEvaluator {
  private static final f a = new f();
  
  public static f a() { return a; }
  
  public Object evaluate(float paramFloat, Object paramObject1, Object paramObject2) {
    int i = ((Integer)paramObject1).intValue();
    float f1 = (0xFF & i >> 24) / 255.0F;
    float f2 = (0xFF & i >> 16) / 255.0F;
    float f3 = (0xFF & i >> 8) / 255.0F;
    float f4 = (i & 0xFF) / 255.0F;
    int j = ((Integer)paramObject2).intValue();
    float f5 = (0xFF & j >> 24) / 255.0F;
    float f6 = (0xFF & j >> 16) / 255.0F;
    float f7 = (0xFF & j >> 8) / 255.0F;
    float f8 = (j & 0xFF) / 255.0F;
    float f9 = (float)Math.pow(f2, 2.2D);
    float f10 = (float)Math.pow(f3, 2.2D);
    float f11 = (float)Math.pow(f4, 2.2D);
    float f12 = (float)Math.pow(f6, 2.2D);
    float f13 = (float)Math.pow(f7, 2.2D);
    float f14 = (float)Math.pow(f8, 2.2D);
    float f15 = f1 + paramFloat * (f5 - f1);
    float f16 = f9 + paramFloat * (f12 - f9);
    float f17 = f10 + paramFloat * (f13 - f10);
    float f18 = f11 + paramFloat * (f14 - f11);
    float f19 = f15 * 255.0F;
    float f20 = 255.0F * (float)Math.pow(f16, 0.45454545454545453D);
    float f21 = 255.0F * (float)Math.pow(f17, 0.45454545454545453D);
    float f22 = 255.0F * (float)Math.pow(f18, 0.45454545454545453D);
    return Integer.valueOf(Math.round(f19) << 24 | Math.round(f20) << 16 | Math.round(f21) << 8 | Math.round(f22));
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\d\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */