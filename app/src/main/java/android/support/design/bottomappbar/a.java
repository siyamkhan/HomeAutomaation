package android.support.design.bottomappbar;

import android.support.design.g.b;
import android.support.design.g.d;

public class a extends b {
  private float a;
  
  private float b;
  
  private float c;
  
  private float d;
  
  private float e;
  
  float a() { return this.e; }
  
  void a(float paramFloat) { this.e = paramFloat; }
  
  public void a(float paramFloat1, float paramFloat2, d paramd) {
    float f1 = this.c;
    if (f1 == 0.0F) {
      paramd.b(paramFloat1, 0.0F);
      return;
    } 
    float f2 = (f1 + 2.0F * this.b) / 2.0F;
    float f3 = paramFloat2 * this.a;
    float f4 = paramFloat1 / 2.0F + this.e;
    float f5 = paramFloat2 * this.d + f2 * (1.0F - paramFloat2);
    if (f5 / f2 >= 1.0F) {
      paramd.b(paramFloat1, 0.0F);
      return;
    } 
    float f6 = f2 + f3;
    float f7 = f6 * f6;
    float f8 = f5 + f3;
    float f9 = (float)Math.sqrt((f7 - f8 * f8));
    float f10 = f4 - f9;
    float f11 = f4 + f9;
    float f12 = (float)Math.toDegrees(Math.atan((f9 / f8)));
    float f13 = 90.0F - f12;
    float f14 = f10 - f3;
    paramd.b(f14, 0.0F);
    float f15 = f10 + f3;
    float f16 = f3 * 2.0F;
    paramd.a(f14, 0.0F, f15, f16, 270.0F, f12);
    paramd.a(f4 - f2, -f2 - f5, f4 + f2, f2 - f5, 180.0F - f13, f13 * 2.0F - 180.0F);
    paramd.a(f11 - f3, 0.0F, f11 + f3, f16, 270.0F - f12, f12);
    paramd.b(paramFloat1, 0.0F);
  }
  
  float b() { return this.d; }
  
  void b(float paramFloat) { this.d = paramFloat; }
  
  float c() { return this.c; }
  
  void c(float paramFloat) { this.c = paramFloat; }
  
  float d() { return this.b; }
  
  void d(float paramFloat) { this.b = paramFloat; }
  
  float e() { return this.a; }
  
  void e(float paramFloat) { this.a = paramFloat; }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\bottomappbar\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */