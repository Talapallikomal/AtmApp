package com.example.atmapp.databinding;
import com.example.atmapp.R;
import com.example.atmapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class AtmActivityDataBindingImpl extends AtmActivityDataBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.layoutLastHeader, 8);
        sViewsWithIds.put(R.id.layoutHeader, 9);
        sViewsWithIds.put(R.id.progressLoading, 10);
        sViewsWithIds.put(R.id.cardViewTop, 11);
        sViewsWithIds.put(R.id.txtAtmAmount, 12);
        sViewsWithIds.put(R.id.guidelineAmount, 13);
        sViewsWithIds.put(R.id.txtRs100, 14);
        sViewsWithIds.put(R.id.guideline100Rs, 15);
        sViewsWithIds.put(R.id.txtRs200, 16);
        sViewsWithIds.put(R.id.guideline200Rs, 17);
        sViewsWithIds.put(R.id.txtRs500, 18);
        sViewsWithIds.put(R.id.guideline500Rs, 19);
        sViewsWithIds.put(R.id.txtRs2000, 20);
        sViewsWithIds.put(R.id.outlinedTextFieldWithDraw, 21);
        sViewsWithIds.put(R.id.edtFieldWithdraw, 22);
        sViewsWithIds.put(R.id.btnWithdraw, 23);
        sViewsWithIds.put(R.id.txtLastTransaction, 24);
        sViewsWithIds.put(R.id.cardViewLastTransaction, 25);
        sViewsWithIds.put(R.id.rvTransaction, 26);
        sViewsWithIds.put(R.id.txtYourTransaction, 27);
        sViewsWithIds.put(R.id.cardViewYourTransaction, 28);
        sViewsWithIds.put(R.id.rvYourTransaction, 29);
    }
    // views
    @NonNull
    private final android.widget.ScrollView mboundView0;
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView6;
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView7;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public AtmActivityDataBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 30, sIncludes, sViewsWithIds));
    }
    private AtmActivityDataBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.AppCompatButton) bindings[23]
            , (androidx.cardview.widget.CardView) bindings[25]
            , (androidx.cardview.widget.CardView) bindings[11]
            , (androidx.cardview.widget.CardView) bindings[28]
            , (com.google.android.material.textfield.TextInputEditText) bindings[22]
            , (androidx.constraintlayout.widget.Guideline) bindings[15]
            , (androidx.constraintlayout.widget.Guideline) bindings[17]
            , (androidx.constraintlayout.widget.Guideline) bindings[19]
            , (androidx.constraintlayout.widget.Guideline) bindings[13]
            , (android.view.View) bindings[9]
            , (android.view.View) bindings[8]
            , (com.google.android.material.textfield.TextInputLayout) bindings[21]
            , (android.widget.ProgressBar) bindings[10]
            , (androidx.recyclerview.widget.RecyclerView) bindings[26]
            , (androidx.recyclerview.widget.RecyclerView) bindings[29]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[12]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[1]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[24]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[14]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[2]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[16]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[20]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[5]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[3]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[18]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[4]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[27]
            );
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView6 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[6];
        this.mboundView6.setTag(null);
        this.mboundView7 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[7];
        this.mboundView7.setTag(null);
        this.txtAtmAmountValue.setTag(null);
        this.txtRs100Count.setTag(null);
        this.txtRs2000Count.setTag(null);
        this.txtRs200Count.setTag(null);
        this.txtRs500Count.setTag(null);
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
        if (BR.atmModel == variableId) {
            setAtmModel((com.example.atmapp.model.ATMEntity) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setAtmModel(@Nullable com.example.atmapp.model.ATMEntity AtmModel) {
        this.mAtmModel = AtmModel;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.atmModel);
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
        int atmModelAtm200NotesCount = 0;
        java.lang.String javaLangStringAtmModelAtm500NotesCount = null;
        java.lang.String javaLangStringAtmModelAtm200NotesCount = null;
        java.lang.String javaLangStringAtmModelAtm2000NotesCount = null;
        int atmModelAtm2000NotesCount = 0;
        com.example.atmapp.model.ATMEntity atmModel = mAtmModel;
        java.lang.String javaLangStringRsAtmModelAtmTotalAmount = null;
        int atmModelAtmTotalAmount = 0;
        int atmModelAtm100NotesCount = 0;
        java.lang.String javaLangStringAtmModelAtm100NotesCount = null;
        int atmModelAtm500NotesCount = 0;

        if ((dirtyFlags & 0x3L) != 0) {



                if (atmModel != null) {
                    // read atmModel.atm200NotesCount
                    atmModelAtm200NotesCount = atmModel.getAtm200NotesCount();
                    // read atmModel.atm2000NotesCount
                    atmModelAtm2000NotesCount = atmModel.getAtm2000NotesCount();
                    // read atmModel.atmTotalAmount
                    atmModelAtmTotalAmount = atmModel.getAtmTotalAmount();
                    // read atmModel.atm100NotesCount
                    atmModelAtm100NotesCount = atmModel.getAtm100NotesCount();
                    // read atmModel.atm500NotesCount
                    atmModelAtm500NotesCount = atmModel.getAtm500NotesCount();
                }


                // read ("") + (atmModel.atm200NotesCount)
                javaLangStringAtmModelAtm200NotesCount = ("") + (atmModelAtm200NotesCount);
                // read ("") + (atmModel.atm2000NotesCount)
                javaLangStringAtmModelAtm2000NotesCount = ("") + (atmModelAtm2000NotesCount);
                // read ("Rs.") + (atmModel.atmTotalAmount)
                javaLangStringRsAtmModelAtmTotalAmount = ("Rs.") + (atmModelAtmTotalAmount);
                // read ("") + (atmModel.atm100NotesCount)
                javaLangStringAtmModelAtm100NotesCount = ("") + (atmModelAtm100NotesCount);
                // read ("") + (atmModel.atm500NotesCount)
                javaLangStringAtmModelAtm500NotesCount = ("") + (atmModelAtm500NotesCount);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtAtmAmountValue, javaLangStringRsAtmModelAtmTotalAmount);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtRs100Count, javaLangStringAtmModelAtm100NotesCount);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtRs2000Count, javaLangStringAtmModelAtm2000NotesCount);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtRs200Count, javaLangStringAtmModelAtm200NotesCount);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtRs500Count, javaLangStringAtmModelAtm500NotesCount);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): atmModel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}