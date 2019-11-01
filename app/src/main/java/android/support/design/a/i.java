package android.support.design.a;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;

public class i {
  private long a = 0L;
  
  private long b = 300L;
  
  private TimeInterpolator c = null;
  
  private int d = 0;
  
  private int e = 1;
  
  public i(long paramLong1, long paramLong2) {
    this.a = paramLong1;
    this.b = paramLong2;
  }
  
  public i(long paramLong1, long paramLong2, TimeInterpolator paramTimeInterpolator) {
    this.a = paramLong1;
    this.b = paramLong2;
    this.c = paramTimeInterpolator;
  }
  
  static i a(ValueAnimator paramValueAnimator) {
    i i1 = new i(paramValueAnimator.getStartDelay(), paramValueAnimator.getDuration(), b(paramValueAnimator));
    i1.d = paramValueAnimator.getRepeatCount();
    i1.e = paramValueAnimator.getRepeatMode();
    return i1;
  }
  
  private static TimeInterpolator b(ValueAnimator paramValueAnimator) {
    TimeInterpolator timeInterpolator = paramValueAnimator.getInterpolator();
    if (timeInterpolator instanceof android.view.animation.AccelerateDecelerateInterpolator || timeInterpolator == null)
      return a.b; 
    if (timeInterpolator instanceof android.view.animation.AccelerateInterpolator)
      return a.c; 
    if (timeInterpolator instanceof android.view.animation.DecelerateInterpolator)
      timeInterpolator = a.d; 
    return timeInterpolator;
  }
  
  public long a() { return this.a; }
  
  public void a(Animator paramAnimator) {
    paramAnimator.setStartDelay(a());
    paramAnimator.setDuration(b());
    paramAnimator.setInterpolator(c());
    if (paramAnimator instanceof ValueAnimator) {
      ValueAnimator valueAnimator = (ValueAnimator)paramAnimator;
      valueAnimator.setRepeatCount(d());
      valueAnimator.setRepeatMode(e());
    } 
  }
  
  public long b() { return this.b; }
  
  public TimeInterpolator c() {
    TimeInterpolator timeInterpolator = this.c;
    return (timeInterpolator != null) ? timeInterpolator : a.b;
  }
  
  public int d() { return this.d; }
  
  public int e() { return this.e; }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject != null) {
      if (getClass() != paramObject.getClass())
        return false; 
      i i1 = (i)paramObject;
      return (a() != i1.a()) ? false : ((b() != i1.b()) ? false : ((d() != i1.d()) ? false : ((e() != i1.e()) ? false : c().getClass().equals(i1.c().getClass()))));
    } 
    return false;
  }
  
  public int hashCode() { return 31 * (31 * (31 * (31 * (int)(a() ^ a() >>> 32) + (int)(b() ^ b() >>> 32)) + c().getClass().hashCode()) + d()) + e(); }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append('\n');
    stringBuilder.append(getClass().getName());
    stringBuilder.append('{');
    stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    stringBuilder.append(" delay: ");
    stringBuilder.append(a());
    stringBuilder.append(" duration: ");
    stringBuilder.append(b());
    stringBuilder.append(" interpolator: ");
    stringBuilder.append(c().getClass());
    stringBuilder.append(" repeatCount: ");
    stringBuilder.append(d());
    stringBuilder.append(" repeatMode: ");
    stringBuilder.append(e());
    stringBuilder.append("}\n");
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */