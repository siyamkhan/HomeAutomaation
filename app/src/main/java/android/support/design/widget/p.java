package android.support.design.widget;

import android.support.v7.widget.m;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

public class p extends m {
  private CharSequence getHintFromLayout() {
    TextInputLayout textInputLayout = getTextInputLayout();
    return (textInputLayout != null) ? textInputLayout.getHint() : null;
  }
  
  private TextInputLayout getTextInputLayout() {
    for (ViewParent viewParent = getParent(); viewParent instanceof android.view.View; viewParent = viewParent.getParent()) {
      if (viewParent instanceof TextInputLayout)
        return (TextInputLayout)viewParent; 
    } 
    return null;
  }
  
  public CharSequence getHint() {
    TextInputLayout textInputLayout = getTextInputLayout();
    return (textInputLayout != null && textInputLayout.a()) ? textInputLayout.getHint() : super.getHint();
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo) {
    InputConnection inputConnection = super.onCreateInputConnection(paramEditorInfo);
    if (inputConnection != null && paramEditorInfo.hintText == null)
      paramEditorInfo.hintText = getHintFromLayout(); 
    return inputConnection;
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\widget\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */