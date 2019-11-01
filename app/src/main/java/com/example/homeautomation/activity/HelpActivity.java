package com.salyantech.homecontrolpanel.activity;

import android.os.Bundle;
import android.support.v7.app.c;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.salyantech.homecontrolpanel.c;

public class HelpActivity extends c {
  private TextView k;
  
  private Toolbar l;
  
  private SpannableString a(CharSequence paramCharSequence, View.OnClickListener paramOnClickListener) {
    SpannableString spannableString = new SpannableString(paramCharSequence);
    spannableString.setSpan(new a(paramOnClickListener), 0, paramCharSequence.length(), 17);
    return spannableString;
  }
  
  private void a(TextView paramTextView) {
    MovementMethod movementMethod = paramTextView.getMovementMethod();
    if ((movementMethod == null || !(movementMethod instanceof LinkMovementMethod)) && paramTextView.getLinksClickable())
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance()); 
  }
  
  private void k() {
    SpannableString spannableString = a(getResources().getString(2131755063), new View.OnClickListener(this) {
          public void onClick(View param1View) { c.b(this.a); }
        });
    this.k.append(spannableString);
    a(this.k);
  }
  
  private void l() {
    this.k = (TextView)findViewById(2131296493);
    this.l = (Toolbar)findViewById(2131296482);
    a(this.l);
    if (g() != null) {
      g().b(true);
      g().a(true);
    } 
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2131492893);
    l();
    k();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu) {
    getMenuInflater().inflate(2131558400, paramMenu);
    MenuItem menuItem1 = paramMenu.findItem(2131296377);
    MenuItem menuItem2 = paramMenu.findItem(2131296381);
    MenuItem menuItem3 = paramMenu.findItem(2131296378);
    MenuItem menuItem4 = paramMenu.findItem(2131296379);
    MenuItem menuItem5 = paramMenu.findItem(2131296376);
    menuItem1.setVisible(false);
    menuItem2.setVisible(false);
    menuItem3.setVisible(false);
    menuItem5.setVisible(false);
    menuItem4.setVisible(false);
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
    int i = paramMenuItem.getItemId();
    if (i != 16908332) {
      if (i != 2131296382)
        return super.onOptionsItemSelected(paramMenuItem); 
      c.c(this);
      return true;
    } 
    onBackPressed();
    return true;
  }
  
  private static class a extends ClickableSpan {
    private View.OnClickListener a;
    
    public a(View.OnClickListener param1OnClickListener) { this.a = param1OnClickListener; }
    
    public void onClick(View param1View) { this.a.onClick(param1View); }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\com\salyantech\homecontrolpanel\activity\HelpActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */