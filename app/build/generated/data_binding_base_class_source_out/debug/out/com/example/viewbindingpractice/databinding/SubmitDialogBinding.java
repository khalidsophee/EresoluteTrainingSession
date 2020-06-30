// Generated by view binder compiler. Do not edit!
package com.example.viewbindingpractice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.example.viewbindingpractice.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class SubmitDialogBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout dialog;

  @NonNull
  public final Button doneTick;

  @NonNull
  public final TextView submitDiscription;

  @NonNull
  public final TextView success;

  @NonNull
  public final ImageView thumsUp;

  private SubmitDialogBinding(@NonNull ConstraintLayout rootView, @NonNull ConstraintLayout dialog,
      @NonNull Button doneTick, @NonNull TextView submitDiscription, @NonNull TextView success,
      @NonNull ImageView thumsUp) {
    this.rootView = rootView;
    this.dialog = dialog;
    this.doneTick = doneTick;
    this.submitDiscription = submitDiscription;
    this.success = success;
    this.thumsUp = thumsUp;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static SubmitDialogBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static SubmitDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.submit_dialog, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static SubmitDialogBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      ConstraintLayout dialog = (ConstraintLayout) rootView;

      id = R.id.done_tick;
      Button doneTick = rootView.findViewById(id);
      if (doneTick == null) {
        break missingId;
      }

      id = R.id.submit_discription;
      TextView submitDiscription = rootView.findViewById(id);
      if (submitDiscription == null) {
        break missingId;
      }

      id = R.id.success;
      TextView success = rootView.findViewById(id);
      if (success == null) {
        break missingId;
      }

      id = R.id.thums_up;
      ImageView thumsUp = rootView.findViewById(id);
      if (thumsUp == null) {
        break missingId;
      }

      return new SubmitDialogBinding((ConstraintLayout) rootView, dialog, doneTick,
          submitDiscription, success, thumsUp);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
