package com.salyantech.homecontrolpanel.activity;

import android.os.Bundle;
import android.support.v7.app.c;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import com.google.android.gms.ads.AdView;
import com.salyantech.homecontrolpanel.c;
import com.salyantech.homecontrolpanel.c.a;
import java.util.ArrayList;

public class EditActivity extends c {
  private boolean A = false;
  
  private RadioButton k;
  
  private RadioButton l;
  
  private RadioButton m;
  
  private RadioButton n;
  
  private RadioButton o;
  
  private EditText p;
  
  private EditText q;
  
  private Button r;
  
  private MenuItem s;
  
  private MenuItem t;
  
  private MenuItem u;
  
  private ArrayList<a> v = new ArrayList();
  
  private String w = "";
  
  private String x = "";
  
  private String y = "";
  
  private String z = "";
  
  private void k() {
    c.a((AdView)findViewById(2131296282));
    a((Toolbar)findViewById(2131296482));
    if (g() != null) {
      g().b(true);
      g().a(true);
    } 
    this.k = (RadioButton)findViewById(2131296412);
    this.l = (RadioButton)findViewById(2131296409);
    this.m = (RadioButton)findViewById(2131296408);
    this.o = (RadioButton)findViewById(2131296411);
    this.n = (RadioButton)findViewById(2131296410);
    this.p = (EditText)findViewById(2131296333);
    this.q = (EditText)findViewById(2131296335);
    this.r = (Button)findViewById(2131296296);
  }
  
  private void l() {
    if (this.A) {
      RadioButton radioButton;
      this.q.setText(this.x);
      this.p.setText(this.y);
      this.r.setText(getResources().getString(2131755161));
      String str = this.z;
      byte b = -1;
      int i = str.hashCode();
      if (i != -2134663084) {
        if (i != -1006804125) {
          if (i != 3714) {
            if (i != 101139) {
              if (i == 3035401 && str.equals("bulb"))
                b = 0; 
            } else if (str.equals("fan")) {
              b = 1;
            } 
          } else if (str.equals("tv")) {
            b = 2;
          } 
        } else if (str.equals("others")) {
          b = 4;
        } 
      } else if (str.equals("speakers")) {
        b = 3;
      } 
      switch (b) {
        default:
          return;
        case 4:
          radioButton = this.n;
          break;
        case 3:
          radioButton = this.o;
          break;
        case 2:
          radioButton = this.k;
          break;
        case 1:
          radioButton = this.l;
          break;
        case 0:
          radioButton = this.m;
          break;
      } 
      radioButton.setChecked(true);
    } 
  }
  
  private void m() {
    Bundle bundle = getIntent().getExtras();
    if (bundle != null) {
      this.A = bundle.getBoolean("isEdit");
      this.w = bundle.getString("id");
      this.x = bundle.getString("switchName");
      this.z = bundle.getString("switchType");
      this.y = bundle.getString("command");
    } 
  }
  
  private void n() {
    m();
    l();
    this.r.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (EditActivity.a(this.a)) {
              EditActivity.b(this.a);
              return;
            } 
            EditActivity.c(this.a);
          }
        });
  }
  
  private void o() { // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield q : Landroid/widget/EditText;
    //   5: invokevirtual getText : ()Landroid/text/Editable;
    //   8: invokevirtual toString : ()Ljava/lang/String;
    //   11: invokevirtual trim : ()Ljava/lang/String;
    //   14: putfield x : Ljava/lang/String;
    //   17: aload_0
    //   18: aload_0
    //   19: getfield p : Landroid/widget/EditText;
    //   22: invokevirtual getText : ()Landroid/text/Editable;
    //   25: invokevirtual toString : ()Ljava/lang/String;
    //   28: invokevirtual trim : ()Ljava/lang/String;
    //   31: putfield y : Ljava/lang/String;
    //   34: aload_0
    //   35: getfield m : Landroid/widget/RadioButton;
    //   38: invokevirtual isChecked : ()Z
    //   41: ifeq -> 55
    //   44: ldc 'bulb'
    //   46: astore_2
    //   47: aload_0
    //   48: aload_2
    //   49: putfield z : Ljava/lang/String;
    //   52: goto -> 119
    //   55: aload_0
    //   56: getfield l : Landroid/widget/RadioButton;
    //   59: invokevirtual isChecked : ()Z
    //   62: ifeq -> 71
    //   65: ldc 'fan'
    //   67: astore_2
    //   68: goto -> 47
    //   71: aload_0
    //   72: getfield k : Landroid/widget/RadioButton;
    //   75: invokevirtual isChecked : ()Z
    //   78: ifeq -> 87
    //   81: ldc 'tv'
    //   83: astore_2
    //   84: goto -> 47
    //   87: aload_0
    //   88: getfield o : Landroid/widget/RadioButton;
    //   91: invokevirtual isChecked : ()Z
    //   94: ifeq -> 103
    //   97: ldc 'speakers'
    //   99: astore_2
    //   100: goto -> 47
    //   103: aload_0
    //   104: getfield n : Landroid/widget/RadioButton;
    //   107: invokevirtual isChecked : ()Z
    //   110: ifeq -> 119
    //   113: ldc 'others'
    //   115: astore_2
    //   116: goto -> 47
    //   119: aload_0
    //   120: invokespecial q : ()Z
    //   123: ifne -> 127
    //   126: return
    //   127: iconst_0
    //   128: istore_1
    //   129: iload_1
    //   130: invokestatic a : ()Lcom/salyantech/homecontrolpanel/b;
    //   133: getfield b : Lcom/salyantech/homecontrolpanel/a;
    //   136: getfield a : Ljava/util/ArrayList;
    //   139: invokevirtual size : ()I
    //   142: if_icmpge -> 269
    //   145: invokestatic a : ()Lcom/salyantech/homecontrolpanel/b;
    //   148: getfield b : Lcom/salyantech/homecontrolpanel/a;
    //   151: getfield a : Ljava/util/ArrayList;
    //   154: iload_1
    //   155: invokevirtual get : (I)Ljava/lang/Object;
    //   158: checkcast com/salyantech/homecontrolpanel/c/a
    //   161: invokevirtual a : ()Ljava/lang/String;
    //   164: aload_0
    //   165: getfield w : Ljava/lang/String;
    //   168: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   171: ifeq -> 263
    //   174: invokestatic a : ()Lcom/salyantech/homecontrolpanel/b;
    //   177: getfield b : Lcom/salyantech/homecontrolpanel/a;
    //   180: getfield a : Ljava/util/ArrayList;
    //   183: iload_1
    //   184: invokevirtual get : (I)Ljava/lang/Object;
    //   187: checkcast com/salyantech/homecontrolpanel/c/a
    //   190: iconst_0
    //   191: invokevirtual a : (I)V
    //   194: invokestatic a : ()Lcom/salyantech/homecontrolpanel/b;
    //   197: getfield b : Lcom/salyantech/homecontrolpanel/a;
    //   200: getfield a : Ljava/util/ArrayList;
    //   203: iload_1
    //   204: invokevirtual get : (I)Ljava/lang/Object;
    //   207: checkcast com/salyantech/homecontrolpanel/c/a
    //   210: aload_0
    //   211: getfield y : Ljava/lang/String;
    //   214: invokevirtual c : (Ljava/lang/String;)V
    //   217: invokestatic a : ()Lcom/salyantech/homecontrolpanel/b;
    //   220: getfield b : Lcom/salyantech/homecontrolpanel/a;
    //   223: getfield a : Ljava/util/ArrayList;
    //   226: iload_1
    //   227: invokevirtual get : (I)Ljava/lang/Object;
    //   230: checkcast com/salyantech/homecontrolpanel/c/a
    //   233: aload_0
    //   234: getfield z : Ljava/lang/String;
    //   237: invokevirtual d : (Ljava/lang/String;)V
    //   240: invokestatic a : ()Lcom/salyantech/homecontrolpanel/b;
    //   243: getfield b : Lcom/salyantech/homecontrolpanel/a;
    //   246: getfield a : Ljava/util/ArrayList;
    //   249: iload_1
    //   250: invokevirtual get : (I)Ljava/lang/Object;
    //   253: checkcast com/salyantech/homecontrolpanel/c/a
    //   256: aload_0
    //   257: getfield x : Ljava/lang/String;
    //   260: invokevirtual b : (Ljava/lang/String;)V
    //   263: iinc #1, 1
    //   266: goto -> 129
    //   269: aload_0
    //   270: invokevirtual finish : ()V
    //   273: return }
  
  private void p() {
    this.x = this.q.getText().toString().trim();
    this.y = this.p.getText().toString().trim();
    if (!q())
      return; 
    finish();
  }
  
  private boolean q() {
    if (this.x.isEmpty()) {
      EditText editText = this.q;
      editText.setError(getResources().getString(2131755125));
      return false;
    } 
    if (this.y.isEmpty()) {
      EditText editText = this.p;
      editText.setError(getResources().getString(2131755125));
      return false;
    } 
    if (!this.n.isChecked() && !this.o.isChecked() && !this.k.isChecked() && !this.l.isChecked() && !this.m.isChecked())
      c.a(this, getResources().getString(2131755126)); 
    return true;
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2131492892);
    k();
    n();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu) {
    getMenuInflater().inflate(2131558400, paramMenu);
    this.s = paramMenu.findItem(2131296377);
    this.t = paramMenu.findItem(2131296381);
    this.u = paramMenu.findItem(2131296376);
    this.u.setVisible(false);
    this.t.setVisible(false);
    this.s.setVisible(false);
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
    switch (paramMenuItem.getItemId()) {
      default:
        return super.onOptionsItemSelected(paramMenuItem);
      case 2131296382:
        c.c(this);
        return true;
      case 2131296379:
        c.a(this, HelpActivity.class);
      case 2131296378:
        return true;
      case 16908332:
        break;
    } 
    onBackPressed();
    return true;
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\com\salyantech\homecontrolpanel\activity\EditActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */