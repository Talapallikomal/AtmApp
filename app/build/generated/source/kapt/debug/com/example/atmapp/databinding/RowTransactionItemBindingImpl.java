package com.example.atmapp.databinding;
import com.example.atmapp.R;
import com.example.atmapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class RowTransactionItemBindingImpl extends RowTransactionItemBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.guidelineAmount, 6);
        sViewsWithIds.put(R.id.guideline100Count, 7);
        sViewsWithIds.put(R.id.guideline200Count, 8);
        sViewsWithIds.put(R.id.guideline500Count, 9);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public RowTransactionItemBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }
    private RowTransactionItemBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.constraintlayout.widget.Guideline) bindings[7]
            , (androidx.constraintlayout.widget.Guideline) bindings[8]
            , (androidx.constraintlayout.widget.Guideline) bindings[9]
            , (androidx.constraintlayout.widget.Guideline) bindings[6]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[2]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[5]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[3]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[4]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[1]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.txtRs100Count.setTag(null);
        this.txtRs2000Count.setTag(null);
        this.txtRs200Count.setTag(null);
        this.txtRs500Count.setTag(null);
        this.txtWithdrawValue.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.model == variableId) {
            setModel((com.example.atmapp.model.AtmTransactionHistory) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setModel(@Nullable com.example.atmapp.model.AtmTransactionHistory Model) {
        this.mModel = Model;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.model);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        com.example.atmapp.model.AtmTransactionHistory model = mModel;
        java.lang.Integer modelAtm100NotesCount = null;
        java.lang.String modelAtm2000NotesCountJavaLangString = null;
        java.lang.Integer modelAtm200NotesCount = null;
        java.lang.String modelAtm200NotesCountJavaLangString = null;
        java.lang.Integer modelAtmWithdrawAmount = null;
        java.lang.String javaLangStringRsModelAtmWithdrawAmount = null;
        java.lang.Integer modelAtm2000NotesCount = null;
        java.lang.Integer modelAtm500NotesCount = null;
        java.lang.String modelAtm500NotesCountJavaLangString = null;
        java.lang.String modelAtm100NotesCountJavaLangString = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (model != null) {
                    // read model.atm100NotesCount
                    modelAtm100NotesCount = model.getAtm100NotesCount();
                    // read model.atm200NotesCount
                    modelAtm200NotesCount = model.getAtm200NotesCount();
                    // read model.atmWithdrawAmount
                    modelAtmWithdrawAmount = model.getAtmWithdrawAmount();
                    // read model.atm2000NotesCount
                    modelAtm2000NotesCount = model.getAtm2000NotesCount();
                    // read model.atm500NotesCount
                    modelAtm500NotesCount = model.getAtm500NotesCount();
                }


                // read (model.atm100NotesCount) + ("")
                modelAtm100NotesCountJavaLangString = (modelAtm100NotesCount) + ("");
                // read (model.atm200NotesCount) + ("")
                modelAtm200NotesCountJavaLangString = (modelAtm200NotesCount) + ("");
                // read ("Rs") + (model.atmWithdrawAmount)
                javaLangStringRsModelAtmWithdrawAmount = ("Rs") + (modelAtmWithdrawAmount);
                // read (model.atm2000NotesCount) + ("")
                modelAtm2000NotesCountJavaLangString = (modelAtm2000NotesCount) + ("");
                // read (model.atm500NotesCount) + ("")
                modelAtm500NotesCountJavaLangString = (modelAtm500NotesCount) + ("");
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtRs100Count, modelAtm100NotesCountJavaLangString);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtRs2000Count, modelAtm2000NotesCountJavaLangString);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtRs200Count, modelAtm200NotesCountJavaLangString);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtRs500Count, modelAtm500NotesCountJavaLangString);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtWithdrawValue, javaLangStringRsModelAtmWithdrawAmount);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): model
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}