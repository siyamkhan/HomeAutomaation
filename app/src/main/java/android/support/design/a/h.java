package android.support.design.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v4.g.l;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class h {
  private final l<String, i> a = new l();
  
  public static h a(Context paramContext, int paramInt) {
    try {
      Animator animator = AnimatorInflater.loadAnimator(paramContext, paramInt);
      if (animator instanceof AnimatorSet)
        return a(((AnimatorSet)animator).getChildAnimations()); 
      if (animator != null) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(animator);
        return a(arrayList);
      } 
      return null;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Can't load animation resource ID #0x");
      stringBuilder.append(Integer.toHexString(paramInt));
      Log.w("MotionSpec", stringBuilder.toString(), exception);
      return null;
    } 
  }
  
  private static h a(List<Animator> paramList) {
    h h1 = new h();
    int i = paramList.size();
    for (byte b = 0; b < i; b++)
      a(h1, (Animator)paramList.get(b)); 
    return h1;
  }
  
  private static void a(h paramh, Animator paramAnimator) {
    if (paramAnimator instanceof ObjectAnimator) {
      ObjectAnimator objectAnimator = (ObjectAnimator)paramAnimator;
      paramh.a(objectAnimator.getPropertyName(), i.a(objectAnimator));
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Animator must be an ObjectAnimator: ");
    stringBuilder.append(paramAnimator);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public long a() {
    int i = this.a.size();
    long l1 = 0L;
    for (byte b = 0; b < i; b++) {
      i i1 = (i)this.a.c(b);
      l1 = Math.max(l1, i1.a() + i1.b());
    } 
    return l1;
  }
  
  public void a(String paramString, i parami) { this.a.put(paramString, parami); }
  
  public boolean a(String paramString) { return (this.a.get(paramString) != null); }
  
  public i b(String paramString) {
    if (a(paramString))
      return (i)this.a.get(paramString); 
    throw new IllegalArgumentException();
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null || getClass() != paramObject.getClass())
      return false; 
    h h1 = (h)paramObject;
    return this.a.equals(h1.a);
  }
  
  public int hashCode() { return this.a.hashCode(); }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append('\n');
    stringBuilder.append(getClass().getName());
    stringBuilder.append('{');
    stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    stringBuilder.append(" timings: ");
    stringBuilder.append(this.a);
    stringBuilder.append("}\n");
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */