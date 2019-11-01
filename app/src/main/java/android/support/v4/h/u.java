package android.support.v4.h;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;

public final class u {
  public static void a(ViewParent paramViewParent, View paramView, int paramInt) {
    if (paramViewParent instanceof n) {
      ((n)paramViewParent).c(paramView, paramInt);
      return;
    } 
    if (paramInt == 0) {
      if (Build.VERSION.SDK_INT >= 21)
        try {
          paramViewParent.onStopNestedScroll(paramView);
          return;
        } catch (AbstractMethodError abstractMethodError) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("ViewParent ");
          stringBuilder.append(paramViewParent);
          stringBuilder.append(" does not implement interface ");
          stringBuilder.append("method onStopNestedScroll");
          Log.e("ViewParentCompat", stringBuilder.toString(), abstractMethodError);
          return;
        }  
      if (paramViewParent instanceof m)
        ((m)paramViewParent).onStopNestedScroll(paramView); 
    } 
  }
  
  public static void a(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    if (paramViewParent instanceof n) {
      ((n)paramViewParent).a(paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
      return;
    } 
    if (paramInt5 == 0) {
      if (Build.VERSION.SDK_INT >= 21)
        try {
          paramViewParent.onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
          return;
        } catch (AbstractMethodError abstractMethodError) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("ViewParent ");
          stringBuilder.append(paramViewParent);
          stringBuilder.append(" does not implement interface ");
          stringBuilder.append("method onNestedScroll");
          Log.e("ViewParentCompat", stringBuilder.toString(), abstractMethodError);
          return;
        }  
      if (paramViewParent instanceof m)
        ((m)paramViewParent).onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4); 
    } 
  }
  
  public static void a(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3) {
    if (paramViewParent instanceof n) {
      ((n)paramViewParent).a(paramView, paramInt1, paramInt2, paramArrayOfInt, paramInt3);
      return;
    } 
    if (paramInt3 == 0) {
      if (Build.VERSION.SDK_INT >= 21)
        try {
          paramViewParent.onNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfInt);
          return;
        } catch (AbstractMethodError abstractMethodError) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("ViewParent ");
          stringBuilder.append(paramViewParent);
          stringBuilder.append(" does not implement interface ");
          stringBuilder.append("method onNestedPreScroll");
          Log.e("ViewParentCompat", stringBuilder.toString(), abstractMethodError);
          return;
        }  
      if (paramViewParent instanceof m)
        ((m)paramViewParent).onNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfInt); 
    } 
  }
  
  public static boolean a(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2) {
    if (Build.VERSION.SDK_INT >= 21) {
      try {
        return paramViewParent.onNestedPreFling(paramView, paramFloat1, paramFloat2);
      } catch (AbstractMethodError abstractMethodError) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ViewParent ");
        stringBuilder.append(paramViewParent);
        stringBuilder.append(" does not implement interface ");
        stringBuilder.append("method onNestedPreFling");
        Log.e("ViewParentCompat", stringBuilder.toString(), abstractMethodError);
      } 
    } else if (paramViewParent instanceof m) {
      return ((m)paramViewParent).onNestedPreFling(paramView, paramFloat1, paramFloat2);
    } 
    return false;
  }
  
  public static boolean a(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean) {
    if (Build.VERSION.SDK_INT >= 21) {
      try {
        return paramViewParent.onNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
      } catch (AbstractMethodError abstractMethodError) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ViewParent ");
        stringBuilder.append(paramViewParent);
        stringBuilder.append(" does not implement interface ");
        stringBuilder.append("method onNestedFling");
        Log.e("ViewParentCompat", stringBuilder.toString(), abstractMethodError);
      } 
    } else if (paramViewParent instanceof m) {
      return ((m)paramViewParent).onNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
    } 
    return false;
  }
  
  public static boolean a(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt1, int paramInt2) {
    if (paramViewParent instanceof n)
      return ((n)paramViewParent).a(paramView1, paramView2, paramInt1, paramInt2); 
    if (paramInt2 == 0)
      if (Build.VERSION.SDK_INT >= 21) {
        try {
          return paramViewParent.onStartNestedScroll(paramView1, paramView2, paramInt1);
        } catch (AbstractMethodError abstractMethodError) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("ViewParent ");
          stringBuilder.append(paramViewParent);
          stringBuilder.append(" does not implement interface ");
          stringBuilder.append("method onStartNestedScroll");
          Log.e("ViewParentCompat", stringBuilder.toString(), abstractMethodError);
        } 
      } else if (paramViewParent instanceof m) {
        return ((m)paramViewParent).onStartNestedScroll(paramView1, paramView2, paramInt1);
      }  
    return false;
  }
  
  public static void b(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt1, int paramInt2) {
    if (paramViewParent instanceof n) {
      ((n)paramViewParent).b(paramView1, paramView2, paramInt1, paramInt2);
      return;
    } 
    if (paramInt2 == 0) {
      if (Build.VERSION.SDK_INT >= 21)
        try {
          paramViewParent.onNestedScrollAccepted(paramView1, paramView2, paramInt1);
          return;
        } catch (AbstractMethodError abstractMethodError) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("ViewParent ");
          stringBuilder.append(paramViewParent);
          stringBuilder.append(" does not implement interface ");
          stringBuilder.append("method onNestedScrollAccepted");
          Log.e("ViewParentCompat", stringBuilder.toString(), abstractMethodError);
          return;
        }  
      if (paramViewParent instanceof m)
        ((m)paramViewParent).onNestedScrollAccepted(paramView1, paramView2, paramInt1); 
    } 
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */