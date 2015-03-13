package com.plexobject.yodlee.domain;

public class FormField {
    public static class FieldType {
        private String typeName;

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        @Override
        public String toString() {
            return "FieldType [typeName=" + typeName + "]";
        }
    }

    private String name;
    private String displayName;
    private String valueIdentifier;
    private String valueMask;
    private String fieldInfoType;
    private String helpText;
    private int size;
    private int maxlength;
    private boolean isEditable;
    private boolean isOptional;
    private boolean isEscaped;
    private boolean isOptionalMFA;
    private boolean isMFA;
    private boolean addItemAccountSupported;
    private boolean isAddAccountMultiFormAction;
    private boolean isAutoRegistrationMultiFormAction;
    private boolean isAddItemAccountMultiFormAction;
    private boolean isSiteCredentialsStored;
    private boolean isPaymentAmountRequiredForAutopay;
    private boolean isNumberOfPaymentsRequiredForAutopay;
    private boolean isDirectTransferSupported;
    private FieldType fieldType;
    private String value;

    public FieldType getFieldType() {
        return fieldType;
    }

    public void setFieldType(FieldType fieldType) {
        this.fieldType = fieldType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getValueIdentifier() {
        return valueIdentifier;
    }

    public void setValueIdentifier(String valueIdentifier) {
        this.valueIdentifier = valueIdentifier;
    }

    public String getValueMask() {
        return valueMask;
    }

    public void setValueMask(String valueMask) {
        this.valueMask = valueMask;
    }

    public String getFieldInfoType() {
        return fieldInfoType;
    }

    public void setFieldInfoType(String fieldInfoType) {
        this.fieldInfoType = fieldInfoType;
    }

    public String getHelpText() {
        return helpText;
    }

    public void setHelpText(String helpText) {
        this.helpText = helpText;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getMaxlength() {
        return maxlength;
    }

    public void setMaxlength(int maxlength) {
        this.maxlength = maxlength;
    }

    public boolean isEditable() {
        return isEditable;
    }

    public void setEditable(boolean isEditable) {
        this.isEditable = isEditable;
    }

    public boolean isOptional() {
        return isOptional;
    }

    public void setOptional(boolean isOptional) {
        this.isOptional = isOptional;
    }

    public boolean isEscaped() {
        return isEscaped;
    }

    public void setEscaped(boolean isEscaped) {
        this.isEscaped = isEscaped;
    }

    public boolean isOptionalMFA() {
        return isOptionalMFA;
    }

    public void setOptionalMFA(boolean isOptionalMFA) {
        this.isOptionalMFA = isOptionalMFA;
    }

    public boolean isMFA() {
        return isMFA;
    }

    public void setMFA(boolean isMFA) {
        this.isMFA = isMFA;
    }

    public boolean isAddItemAccountSupported() {
        return addItemAccountSupported;
    }

    public void setAddItemAccountSupported(boolean addItemAccountSupported) {
        this.addItemAccountSupported = addItemAccountSupported;
    }

    public boolean isAddAccountMultiFormAction() {
        return isAddAccountMultiFormAction;
    }

    public void setAddAccountMultiFormAction(boolean isAddAccountMultiFormAction) {
        this.isAddAccountMultiFormAction = isAddAccountMultiFormAction;
    }

    public boolean isAutoRegistrationMultiFormAction() {
        return isAutoRegistrationMultiFormAction;
    }

    public void setAutoRegistrationMultiFormAction(
            boolean isAutoRegistrationMultiFormAction) {
        this.isAutoRegistrationMultiFormAction = isAutoRegistrationMultiFormAction;
    }

    public boolean isAddItemAccountMultiFormAction() {
        return isAddItemAccountMultiFormAction;
    }

    public void setAddItemAccountMultiFormAction(
            boolean isAddItemAccountMultiFormAction) {
        this.isAddItemAccountMultiFormAction = isAddItemAccountMultiFormAction;
    }

    public boolean isSiteCredentialsStored() {
        return isSiteCredentialsStored;
    }

    public void setSiteCredentialsStored(boolean isSiteCredentialsStored) {
        this.isSiteCredentialsStored = isSiteCredentialsStored;
    }

    public boolean isPaymentAmountRequiredForAutopay() {
        return isPaymentAmountRequiredForAutopay;
    }

    public void setPaymentAmountRequiredForAutopay(
            boolean isPaymentAmountRequiredForAutopay) {
        this.isPaymentAmountRequiredForAutopay = isPaymentAmountRequiredForAutopay;
    }

    public boolean isNumberOfPaymentsRequiredForAutopay() {
        return isNumberOfPaymentsRequiredForAutopay;
    }

    public void setNumberOfPaymentsRequiredForAutopay(
            boolean isNumberOfPaymentsRequiredForAutopay) {
        this.isNumberOfPaymentsRequiredForAutopay = isNumberOfPaymentsRequiredForAutopay;
    }

    public boolean isDirectTransferSupported() {
        return isDirectTransferSupported;
    }

    public void setDirectTransferSupported(boolean isDirectTransferSupported) {
        this.isDirectTransferSupported = isDirectTransferSupported;
    }

    @Override
    public String toString() {
        return "FormField [name=" + name + ", displayName=" + displayName
                + ", valueIdentifier=" + valueIdentifier + ", valueMask="
                + valueMask + ", fieldInfoType=" + fieldInfoType
                + ", helpText=" + helpText + ", size=" + size + ", maxlength="
                + maxlength + ", isEditable=" + isEditable + ", isOptional="
                + isOptional + ", isEscaped=" + isEscaped + ", isOptionalMFA="
                + isOptionalMFA + ", isMFA=" + isMFA
                + ", addItemAccountSupported=" + addItemAccountSupported
                + ", isAddAccountMultiFormAction="
                + isAddAccountMultiFormAction
                + ", isAutoRegistrationMultiFormAction="
                + isAutoRegistrationMultiFormAction
                + ", isAddItemAccountMultiFormAction="
                + isAddItemAccountMultiFormAction
                + ", isSiteCredentialsStored=" + isSiteCredentialsStored
                + ", isPaymentAmountRequiredForAutopay="
                + isPaymentAmountRequiredForAutopay
                + ", isNumberOfPaymentsRequiredForAutopay="
                + isNumberOfPaymentsRequiredForAutopay
                + ", isDirectTransferSupported=" + isDirectTransferSupported
                + ", fieldType=" + fieldType + ", value=" + value + "]";
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
