// ============================================================================
//
// Copyright (C) 2006-2007 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the  agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//   
// ============================================================================
package org.talend.core.model.context;

import org.talend.core.context.RepositoryContext;
import org.talend.core.model.process.IContext;
import org.talend.core.model.process.IContextParameter;
import org.talend.core.model.utils.ContextParameterUtils;
import org.talend.core.ui.context.DefaultCellEditorFactory;

/**
 * Parameter in a context. <br/>
 * 
 * $Id$
 * 
 */
public class JobContextParameter implements IContextParameter, Cloneable {

    public static final String LIST_SEPARATOR = ",";

    String name;

    String type;

    String value;

    String prompt;

    String comment;

    boolean promptNeeded;

    String scriptCode;

    IContext context;

    String[] valueList;

    public JobContextParameter() {

    }

    public String[] getValueList() {
        if (!isList()) {
            return null;
        }

        if (valueList == null && value.length() != 0) {
            valueList = getValue().split(",");
            return valueList;
        }

        return valueList;
    }

    public void setValueList(String[] list) {
        valueList = list;
        value = "";
        if (valueList.length != 0) {
            value = combineStrings(valueList);
        }
    }

    /**
     * Getter for context.
     * 
     * @return the context
     */
    public IContext getContext() {
        return this.context;
    }

    /**
     * Sets the context.
     * 
     * @param context the context to set
     */
    public void setContext(IContext context) {
        this.context = context;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.designer.core.model.context.IDesignerContextParameter#getName()
     */
    public String getName() {
        return this.name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.designer.core.model.context.IDesignerContextParameter#setName(java.lang.String)
     */
    public void setName(final String name) {
        this.name = name;

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.designer.core.model.context.IDesignerContextParameter#getPrompt()
     */
    public String getPrompt() {
        return this.prompt;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.designer.core.model.context.IDesignerContextParameter#setPrompt(java.lang.String)
     */
    public void setPrompt(final String prompt) {
        this.prompt = prompt;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.designer.core.model.context.IDesignerContextParameter#getType()
     */
    public String getType() {
        return this.type;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.designer.core.model.context.IDesignerContextParameter#setType(org.talend.core.model.metadata.EMetadataType)
     */
    public void setType(final String type) {
        this.type = type;
        valueList = null;
        value = "";
        // if (isList() && getValue() != null && getValue().length() != 0) {
        // valueList = getValue().split(",");
        // }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.designer.core.model.context.IDesignerContextParameter#setValue(java.lang.String)
     */
    public void setValue(final String value) {
        this.value = value;
        if (isList() && value.length() != 0) {
            valueList = getValue().split(LIST_SEPARATOR);
        }
    }

    public void setInternalValue(String value) {
        this.value = value;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.designer.core.model.context.IDesignerContextParameter#getValue()
     */
    public String getValue() {
        return this.value;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IContextParameter#getDiaplayValue()
     */
    public String getDisplayValue() {
        if (isList()) {
            if (valueList == null || valueList.length == 0) {
                return "(Empty)";

            } else {
                return "<" + combineStrings(valueList) + ">";
            }
        }
        return getValue();
    }

    private String combineStrings(String[] arrays) {
        StringBuilder sb = new StringBuilder();
        for (String string : arrays) {
            sb.append(string).append(LIST_SEPARATOR);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private boolean isList() {
        if (getType() == null) {
            return false;
        }
        return DefaultCellEditorFactory.isList(getType());
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.designer.core.model.context.IDesignerContextParameter#getComment()
     */
    public String getComment() {
        return this.comment;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.designer.core.model.context.IDesignerContextParameter#setComment(java.lang.String)
     */
    public void setComment(final String comment) {
        this.comment = comment;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.designer.core.model.context.IDesignerContextParameter#isPromptNeeded()
     */
    public boolean isPromptNeeded() {
        return this.promptNeeded;
    }

    /**
     * Getter for scriptCode.
     * 
     * @return the scriptCode
     */
    public String getScriptCode() {
        if (this.scriptCode == null) {
            scriptCode = ContextParameterUtils.getScriptCode(this, ((RepositoryContext) org.talend.core.CorePlugin.getContext()
                    .getProperty(org.talend.core.context.Context.REPOSITORY_CONTEXT_KEY)).getProject().getLanguage());
        }
        return this.scriptCode;
    }

    /**
     * Sets the scriptCode.
     * 
     * @param scriptCode the scriptCode to set
     */
    public void setScriptCode(String scriptCode) {
        this.scriptCode = scriptCode;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.designer.core.model.context.IDesignerContextParameter#setPromptNeeded(boolean)
     */
    public void setPromptNeeded(boolean promptNeeded) {
        this.promptNeeded = promptNeeded;
    }

    public IContextParameter clone() {
        IContextParameter clonedContextParameter = null;
        try {
            clonedContextParameter = (IContextParameter) super.clone();
        } catch (CloneNotSupportedException e) {
            // nothing
        }
        return clonedContextParameter;
    }

    public boolean sameAs(IContextParameter contextParam) {

        if (!contextParam.getComment().equals(comment)) {
            return false;
        }
        if (!contextParam.getName().equals(name)) {
            return false;
        }
        if (!contextParam.getPrompt().equals(prompt)) {
            return false;
        }
        if (!contextParam.getType().equals(type)) {
            return false;
        }
        if (!contextParam.getValue().equals(value)) {
            return false;
        }

        if (contextParam.isPromptNeeded() != promptNeeded) {
            return false;
        }

        // if (!contextParam.getScriptCode().equals(scriptCode)) {
        // return false;
        // }

        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final JobContextParameter other = (JobContextParameter) obj;

        if (this.getContext() != null && other.getContext() != null) {
            if (!this.getContext().equals(other.getContext())) {
                return false;
            }
        }

        if (this.name == null) {
            if (other.name != null)
                return false;
        } else if (!this.name.equals(other.name))
            return false;
        return true;
    }
}
