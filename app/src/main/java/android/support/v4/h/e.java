package android.support.v4.h;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class e {
  private static boolean a = false;
  
  private static Method b;
  
  private static boolean c = false;
  
  private static Field d;
  
  static  {
  
  }
  
  private static DialogInterface.OnKeyListener a(Dialog paramDialog) {
    if (!c) {
      try {
        d = Dialog.class.getDeclaredField("mOnKeyListener");
        d.setAccessible(true);
      } catch (NoSuchFieldException noSuchFieldException) {}
      c = true;
    } 
    Field field = d;
    return (field != null) ? (DialogInterface.OnKeyListener)field.get(paramDialog) : null;
  }
  
  private static boolean a(ActionBar paramActionBar, KeyEvent paramKeyEvent) {
    if (!a) {
      try {
        b = paramActionBar.getClass().getMethod("onMenuKeyEvent", new Class[] { KeyEvent.class });
      } catch (NoSuchMethodException noSuchMethodException) {}
      a = true;
    } 
    Method method = b;
    return (method != null) ? ((Boolean)method.invoke(paramActionBar, new Object[] { paramKeyEvent })).booleanValue() : 0;
  }
  
  private static boolean a(Activity paramActivity, KeyEvent paramKeyEvent) {
    KeyEvent.DispatcherState dispatcherState;
    paramActivity.onUserInteraction();
    Window window = paramActivity.getWindow();
    if (window.hasFeature(8)) {
      ActionBar actionBar = paramActivity.getActionBar();
      if (paramKeyEvent.getKeyCode() == 82 && actionBar != null && a(actionBar, paramKeyEvent))
        return true; 
    } 
    if (window.superDispatchKeyEvent(paramKeyEvent))
      return true; 
    View view = window.getDecorView();
    if (r.b(view, paramKeyEvent))
      return true; 
    if (view != null) {
      dispatcherState = view.getKeyDispatcherState();
    } else {
      dispatcherState = null;
    } 
    return paramKeyEvent.dispatch(paramActivity, dispatcherState, paramActivity);
  }
  
  private static boolean a(Dialog paramDialog, KeyEvent paramKeyEvent) {
    KeyEvent.DispatcherState dispatcherState;
    DialogInterface.OnKeyListener onKeyListener = a(paramDialog);
    if (onKeyListener != null && onKeyListener.onKey(paramDialog, paramKeyEvent.getKeyCode(), paramKeyEvent))
      return true; 
    Window window = paramDialog.getWindow();
    if (window.superDispatchKeyEvent(paramKeyEvent))
      return true; 
    View view = window.getDecorView();
    if (r.b(view, paramKeyEvent))
      return true; 
    if (view != null) {
      dispatcherState = view.getKeyDispatcherState();
    } else {
      dispatcherState = null;
    } 
    return paramKeyEvent.dispatch(paramDialog, dispatcherState, paramDialog);
  }
  
  public static boolean a(a parama, View paramView, Window.Callback paramCallback, KeyEvent paramKeyEvent) {
    if (parama == null)
      return false; 
    if (Build.VERSION.SDK_INT >= 28)
      return parama.a(paramKeyEvent); 
    if (paramCallback instanceof Activity)
      return a((Activity)paramCallback, paramKeyEvent); 
    if (paramCallback instanceof Dialog)
      return a((Dialog)paramCallback, paramKeyEvent); 
    if (paramView == null || !r.b(paramView, paramKeyEvent)) {
      boolean bool1 = parama.a(paramKeyEvent);
      boolean bool2 = false;
      return bool1 ? true : bool2;
    } 
    return true;
  }
  
  public static boolean a(View paramView, KeyEvent paramKeyEvent) { return r.a(paramView, paramKeyEvent); }
  
  public static interface a {
    boolean a(KeyEvent param1KeyEvent);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\h\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */