package android.support.v7.app;

class j {
  private static j d;
  
  public long a;
  
  public long b;
  
  public int c;
  
  static j a() {
    if (d == null)
      d = new j(); 
    return d;
  }
  
  public void a(long paramLong, double paramDouble1, double paramDouble2) {
    float f1 = (float)(paramLong - 946728000000L) / 8.64E7F;
    float f2 = 6.24006F + 0.01720197F * f1;
    double d1 = f2;
    double d2 = 0.03341960161924362D * Math.sin(d1);
    Double.isNaN(d1);
    double d3 = Math.PI + 1.796593063D + d2 + d1 + 3.4906598739326E-4D * Math.sin((2.0F * f2)) + 5.236000106378924E-6D * Math.sin((f2 * 3.0F));
    double d4 = -paramDouble2 / 360.0D;
    double d5 = (f1 - 9.0E-4F);
    Double.isNaN(d5);
    double d6 = (9.0E-4F + (float)Math.round(d5 - d4));
    Double.isNaN(d6);
    double d7 = d6 + d4 + 0.0053D * Math.sin(d1) + -0.0069D * Math.sin(2.0D * d3);
    double d8 = Math.asin(Math.sin(d3) * Math.sin(0.4092797040939331D));
    double d9 = 0.01745329238474369D * paramDouble1;
    double d10 = (Math.sin(-0.10471975803375244D) - Math.sin(d9) * Math.sin(d8)) / Math.cos(d9) * Math.cos(d8);
    if (d10 >= 1.0D) {
      this.c = 1;
    } else if (d10 <= -1.0D) {
      this.c = 0;
    } else {
      double d11 = (float)(Math.acos(d10) / 6.283185307179586D);
      Double.isNaN(d11);
      this.a = 946728000000L + Math.round(8.64E7D * (d7 + d11));
      Double.isNaN(d11);
      this.b = 946728000000L + Math.round(8.64E7D * (d7 - d11));
      if (this.b < paramLong && this.a > paramLong) {
        this.c = 0;
        return;
      } 
      this.c = 1;
      return;
    } 
    this.a = -1L;
    this.b = -1L;
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\app\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */